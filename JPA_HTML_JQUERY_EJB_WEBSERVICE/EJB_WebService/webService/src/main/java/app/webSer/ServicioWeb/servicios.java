/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.webSer.ServicioWeb;

import app.webSer.Entity.ThomClienteEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import app.webSer.DAO.ClienteDAO;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebParam;

/**
 *
 * @author angel
 */
@WebService(serviceName = "servicios")
public class servicios {

    @EJB
    private ClienteDAO clienteImpl;

    private ThomClienteEntity cliente = new ThomClienteEntity();

    @WebMethod(operationName = "listarCliente")
    public List<ThomClienteEntity> setListarClientes() {
        return this.clienteImpl.getListarClientes();
    }

    @WebMethod(operationName = "agregarCliente")
    public String setAgregarClientes(
            @WebParam(name = "nm_cliente") Integer nm_cliente, @WebParam(name = "cd_cliente")  String cd_cliente,
            @WebParam(name = "dn_nombre")  String dn_nombre,   @WebParam(name = "dn_direccion")String dn_direccion,
            @WebParam(name = "dn_email")   String dn_email,    @WebParam(name = "fecha_baja")  String fecha_baja,
            @WebParam(name = "cd_usuario") String cd_usuario,  @WebParam(name = "s_activo")    String s_activo,
            @WebParam(name = "cd_telefono")String cd_telefono, @WebParam(name = "ds_contacto") String ds_contacto,
            @WebParam(name = "ds_logo")    String ds_logo) {
        try {
            this.cliente.setNmCliente(nm_cliente);
            this.cliente.setCdCliente(cd_cliente);
            this.cliente.setDnNombre(dn_nombre);
            this.cliente.setDnDireccion(dn_direccion);
            this.cliente.setDnEmail(dn_email);
            this.cliente.setFechaRegistro(this.getFechaActual());
            this.cliente.setFechaBaja(this.getFechaBaja(fecha_baja));
            this.cliente.setCdUsuario(cd_usuario);
            this.cliente.setSActivo(s_activo);
            this.cliente.setCdTelefono(cd_telefono);
            this.cliente.setDsContacto(ds_contacto);
            this.cliente.setDsLogo(ds_logo);            
            
            String response = this.clienteImpl.setRegistrarCliente(cliente);
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    /* Metodo para generar un timestamp segun la fecha ingresada en String */
    private Timestamp getFechaBaja(String fechabajaStrig) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(fechabajaStrig);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return timestamp;
        } catch (Exception e) {
            return null;
        }
    }

    /* Metodo para generar un timestamp actual */
    private Timestamp getFechaActual() {
        Date fecha = new Date();
        Timestamp timeActual = new Timestamp(fecha.getTime());
        return timeActual;
    }

    @WebMethod(operationName = "buscarCliente")
    public String getBuscarClientes(@WebParam(name = "nm_cliente") Integer nm_cliente) {
        this.cliente = this.clienteImpl.setBuscarCliente(nm_cliente);
        if (this.cliente != null) {
            return this.cliente.getDnNombre();
        } else {
            return "No se pudo completar la accion !!";
        }
    }
    
    @WebMethod(operationName = "elimiarCliente")
    public boolean setEliminarCliente(@WebParam(name = "nm_cliente") Integer nm_cliente) {
        boolean response = this.clienteImpl.setEliminarCliente(nm_cliente);
        return response;
    }
    
    
}


