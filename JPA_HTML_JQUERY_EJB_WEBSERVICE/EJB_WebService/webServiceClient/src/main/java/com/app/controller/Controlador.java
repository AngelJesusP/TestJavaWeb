/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.importWebService.webServiceThomCliente;
import com.app.model.ThomCliente;
import com.app.views.ClienteView;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {

    private ClienteView vistaCliente;

    private DefaultTableModel model;
    private webServiceThomCliente webServiceCliente = new webServiceThomCliente();

    private ThomCliente cliente = new ThomCliente();

    private final String headerTable[] = {
        "nmCliente", "cdCliente", "dnNombre", "dnDireccion",
        "dnEmail", "fechaRegistro", "fechaBaja", "cdUsuario",
        "sActivo", "cdTelefono", "dsContacto", "dsLogo"
    };

    public Controlador() {
        this.vistaCliente = new ClienteView();
        this.setCargarComponentes();
        this.vistaCliente.btn_agregarCliente.addActionListener(this);
        this.vistaCliente.btn_ListarClientes.addActionListener(this);
        this.vistaCliente.btn_EliminarCliente.addActionListener(this);
        this.vistaCliente.btn_ActualizarCliente.addActionListener(this);
        this.vistaCliente.btn_BuscarCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vistaCliente.btn_agregarCliente) {
            this.setAgregarClienteWebService();
        }

        if (e.getSource() == this.vistaCliente.btn_ListarClientes) {
            this.setCargarClientesWebService();
        }

        if (e.getSource() == this.vistaCliente.btn_EliminarCliente) {
            this.setEliminarClienteWebServce();
        }

        if (e.getSource() == this.vistaCliente.btn_BuscarCliente) {
            this.getBuscarClienteWebService();
        }
        
        if (e.getSource() == this.vistaCliente.btn_ActualizarCliente) {
            this.setActualizarClienteWebService();
        }
        

    }

    private void setCargarComponentes() {

        this.vistaCliente.imgAvatar.setIcon(new ImageIcon("src/main/java/com/app/img/cliente.png"));
        this.vistaCliente.setVisible(true);
        this.vistaCliente.setLocationRelativeTo(null);

        /* Maximizar la venta de JFrame al tamaño de la pantalla */
        this.vistaCliente.setExtendedState(Frame.MAXIMIZED_BOTH);

        /* Centrar los header del Jtable */
        TableCellRenderer rendererFromHeader = this.vistaCliente.tablaThomCliente.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        this.model = new DefaultTableModel(null, headerTable);
        this.vistaCliente.tablaThomCliente.setModel(model);

    }

    private void setCargarClientesWebService() {
        try {
            this.model = new DefaultTableModel(null, headerTable);
            List<app.web.webservice.ThomClienteEntity> lista = this.webServiceCliente.getListarClientes();
            if (lista != null) {
                Object datos[] = new Object[12];
                for (int i = 0; i < lista.size(); i++) {
                    datos[0] = lista.get(i).getNmCliente();
                    datos[1] = lista.get(i).getCdCliente();
                    datos[2] = lista.get(i).getDnNombre();
                    datos[3] = lista.get(i).getDnDireccion();
                    datos[4] = lista.get(i).getDnEmail();
                    datos[5] = lista.get(i).getFechaRegistro();
                    datos[6] = lista.get(i).getFechaBaja();
                    datos[7] = lista.get(i).getCdUsuario();
                    datos[8] = lista.get(i).getSActivo();
                    datos[9] = lista.get(i).getCdTelefono();
                    datos[10] = lista.get(i).getDsContacto();
                    datos[11] = lista.get(i).getDsLogo();
                    this.model.addRow(datos);
                }
                this.vistaCliente.tablaThomCliente.setModel(model);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void setAgregarClienteWebService() {
        try {
            Date fechaBajaAux = this.vistaCliente.fecha_baja.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String fechaBaja = dateFormat.format(fechaBajaAux);

            byte response = this.webServiceCliente.setAgregarClientes(
                    Integer.parseInt(this.vistaCliente.txt_nm_cliente.getText()),
                    this.vistaCliente.txt_cd_cliente.getText(),
                    this.vistaCliente.txt_dn_nombre.getText(),
                    this.vistaCliente.txt_dn_direccion.getText(),
                    this.vistaCliente.txt_dn_email.getText(), fechaBaja,
                    this.vistaCliente.txt_cd_usuario.getText(),
                    (this.vistaCliente.comp_s_activo.getSelectedItem() == "Activo") ? "Y" : "N",
                    this.vistaCliente.txt_cd_telefono.getText(),
                    this.vistaCliente.txt_ds_contacto.getText(),
                    this.vistaCliente.txt_ds_logo.getText()
            );
            JOptionPane.showMessageDialog(null, (response == 0) ? "Registro completado con exito" : "NO se pudo registar la informacion, Verificar !!",
                    (response == 0) ? "Compeltado" : "Error", (response == 0) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese bien los datos del cliente", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setActualizarClienteWebService() {
        try {
            byte response = this.webServiceCliente.setActualizarCliente(
                    Integer.parseInt(this.vistaCliente.txt_nm_cliente.getText()),
                    this.vistaCliente.txt_cd_cliente.getText(),
                    this.vistaCliente.txt_dn_nombre.getText(),
                    this.vistaCliente.txt_dn_direccion.getText(),
                    this.vistaCliente.txt_dn_email.getText(),
                    this.vistaCliente.txt_cd_usuario.getText(),
                    (this.vistaCliente.comp_s_activo.getSelectedItem() == "Activo") ? "Y" : "N",
                    this.vistaCliente.txt_cd_telefono.getText(),
                    this.vistaCliente.txt_ds_contacto.getText(),
                    this.vistaCliente.txt_ds_logo.getText());
            
            JOptionPane.showMessageDialog(null, (response == 0) ? "Actualizacion completado con exito" : "NO se pudo actualizar la informacion, Verificar !!",
                    (response == 0) ? "Compeltado" : "Error", (response == 0) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese bien los datos del cliente", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setEliminarClienteWebServce() {
        String nm_cliente = this.vistaCliente.txt_nm_cliente.getText();
        if (nm_cliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el nm del cliente para poder realizar la accion !!",
                    "Informacion", JOptionPane.ERROR_MESSAGE);
        } else {
            byte response = this.webServiceCliente.setEliminarCliente(Integer.parseInt(nm_cliente));
            JOptionPane.showMessageDialog(null, (response == 0) ? "Eliminacion completado con exito" : "NO se pudo eliminar la informacion, Verificar !!",
                    (response == 0) ? "Compeltado" : "Error", (response == 0) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getBuscarClienteWebService() {
        String nm_cliente = this.vistaCliente.txt_nm_cliente.getText();
        if (nm_cliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el numero del cliente que desee buscar !!");
        } else {
            app.web.webservice.ThomClienteEntity clienteAux = this.webServiceCliente.getBuscarClientes(Integer.parseInt(nm_cliente));
            if (clienteAux != null) {
                vistaCliente.txt_nm_cliente.setText(String.valueOf(clienteAux.getNmCliente()));
                vistaCliente.txt_cd_cliente.setText(clienteAux.getCdCliente());
                vistaCliente.txt_dn_nombre.setText(clienteAux.getDnNombre());
                vistaCliente.txt_dn_direccion.setText(clienteAux.getDnDireccion());
                vistaCliente.txt_dn_email.setText(clienteAux.getDnEmail());
                vistaCliente.txt_cd_usuario.setText(clienteAux.getCdUsuario());

                vistaCliente.txt_cd_telefono.setText(clienteAux.getCdTelefono());
                vistaCliente.txt_ds_contacto.setText(clienteAux.getDsContacto());
                vistaCliente.txt_ds_logo.setText(clienteAux.getDsLogo());
            } else {
                JOptionPane.showMessageDialog(null, "El numero del cliente no se encuentra registado o Ocurrio un erro al momento de realizar la busqueda",
                        "Informacion", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
