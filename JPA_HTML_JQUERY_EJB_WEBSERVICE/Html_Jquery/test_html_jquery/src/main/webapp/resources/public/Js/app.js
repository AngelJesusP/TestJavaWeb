/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(() => {
    
    const getAjax = (url, metodo, datos) => {
        const ajax = $.ajax({
            method: metodo,
            url: url,
            data: datos
        });
        return ajax;
    };

    const getDatos = (accion) => {
        const json = {
            "nm_cliente": $('#nm_cliente').val(),
            "cd_cliente": $('#cd_cliente').val(),
            "dn_nombre": $('#dn_nombre').val(),
            "dn_direccion": $('#dn_direccion').val(),
            "dn_email": $('#dn_email').val(),
            "fecha_baja": $('#fecha_baja').val() + " 00:00:00.000",
            "cd_usuario": $('#cd_usuario').val(),
            "s_activo": $('input[name=radio]:checked').val(),
            "cd_telefono": $('#cd_telefono').val(),
            "ds_contacto": $('#ds_contacto').val(),
            "ds_logo": $('#ds_logo').val(),
            "accion": (accion) ? "add" : "update"
        };
        return json;
    };

    $('#btnAdd').on('click', (e) => {
        let ajax = getAjax("clienteController", "POST", getDatos(true));
        ajax.done((response) => {
            console.log(response);
        });
        ajax.fail((response) => {
            console.log("Error");
            console.log(response);
        });
    });
    
    
    $('#btnEliminar').on('click', (e) => {
        if ($('#nm_cliente').val() !== "") {
            const json = {
                "nm_cliente": $('#nm_cliente').val(),
                "accion": "remove"
            };
            let ajax = getAjax('clienteController', "POST", json);
            ajax.done((response) => {
                if (response.status === 200) {
                    alert("Cliente eliminado con exito");
                } else {
                    alert("Accion no completada \n "+response.message);
                }
            });
            ajax.fail((response) => {
                console.log("Error");
                console.log(response);
            });
        }
    });
    

    $('#btnListar').on('click', (e) => {
        let ajax = getAjax("clienteController", "GET", {});
        ajax.done((response) => {
            let array = response;
            let codigoHtml = '';
            array.forEach((item) => {
                codigoHtml += `
                    <tr onclick="DatatoInputs(this)" style="cursor: pointer">
                        <td>${item.nm_cliente}</td>
                        <td>${item.cd_cliente}</td>
                        <td>${item.dn_nombre}</td>
                        <td>${item.dn_direccion}</td>
                        <td>${item.dn_email}</td>
                        <td>${item.fecha_registro}</td>
                        <td>${item.fecha_baja}</td>
                        <td>${item.cd_usuario}</td>
                        <td>${item.s_activo}</td>
                        <td>${item.cd_telefono}</td>
                        <td>${item.ds_contacto}</td>
                        <td>${item.ds_logo}</td>
                    </tr>
                `;
            });
            $('#cuerpoTable').html(codigoHtml);
        });
        ajax.fail((response) => {
            console.log("Error");
            console.log(response);
        });
    });
    
    
    $('#btnUpdate').on('click', (e) => {
        let json = getDatos(false);
        json.fecha_baja = ($('#fecha_baja').val()==="")? "" : $('#fecha_baja').val() + " 00:00:00.000"; 
        let ajax = getAjax("clienteController", "POST", json);
        ajax.done((response) => {
            console.log(response);
        });
        ajax.fail((response) => {
            console.log("Error");
            console.log(response);
        });
        
    });
});


const DatatoInputs = (value) => {
    const fila = value.rowIndex;
    const tabla = document.getElementById('tablaContenido');
    $('#nm_cliente').val(tabla.rows[fila].cells[0].innerHTML);
    $('#cd_cliente').val(tabla.rows[fila].cells[1].innerHTML);
    $('#dn_nombre').val(tabla.rows[fila].cells[2].innerHTML);
    $('#dn_direccion').val(tabla.rows[fila].cells[3].innerHTML);
    $('#dn_email').val(tabla.rows[fila].cells[4].innerHTML);
    $('#fecha_baja').val(tabla.rows[fila].cells[6].innerHTML);
    
    $('#cd_usuario').val(tabla.rows[fila].cells[7].innerHTML);
    if (tabla.rows[fila].cells[8].innerHTML === "Y") {
        $("#activo").prop("checked", true);
    } else {
        $("#NoActivo").prop("checked", true);
    }
    $('#cd_telefono').val(tabla.rows[fila].cells[9].innerHTML);
    $('#ds_contacto').val(tabla.rows[fila].cells[10].innerHTML);                
    $('#ds_logo').val(tabla.rows[fila].cells[11].innerHTML);
};
