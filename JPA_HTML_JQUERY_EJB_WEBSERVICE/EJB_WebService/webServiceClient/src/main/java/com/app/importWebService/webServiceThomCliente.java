/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.importWebService;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class webServiceThomCliente {

    public webServiceThomCliente() {
    }

    public byte setAgregarClientes(Integer nmCliente, String cdCliente,
            String dnNombre, String dnDireccion, String dnEmail, String fechaBaja,
            String cdUsuario, String sActivo, String cdTelefono, String dsContacto, String dsLogo)
    {
        try { // Call Web Service Operation
            app.web.webservice.WebService_Service service = new app.web.webservice.WebService_Service();
            app.web.webservice.WebService port = service.getWebServicePort();
            byte result = port.agregarCliente(nmCliente, cdCliente, dnNombre, dnDireccion, dnEmail, fechaBaja, cdUsuario, sActivo, cdTelefono, dsContacto, dsLogo);
            return result;
        } catch (Exception ex) {
            return -1;
        }
    }

    public List<app.web.webservice.ThomClienteEntity> getListarClientes() {
        try { // Call Web Service Operation
            app.web.webservice.WebService_Service service = new app.web.webservice.WebService_Service();
            app.web.webservice.WebService port = service.getWebServicePort();
            return port.listarCliente();
        } catch (Exception ex) {
            return null;
        }
    }
    
    public byte setEliminarCliente(Integer nm_cliente) {
        try { // Call Web Service Operation
            app.web.webservice.WebService_Service service = new app.web.webservice.WebService_Service();
            app.web.webservice.WebService port = service.getWebServicePort();
            byte result = port.elimiarCliente(nm_cliente);
            return result;
        } catch (Exception ex) {
            return  -1;
        }
    }
    
    
    public byte setActualizarCliente(
            Integer nmCliente, String cdCliente, String dnNombre, String dnDireccion,
            String dnEmail, String cdUsuario, String sActivo,
            String cdTelefono, String dsContacto, String dsLogo) {
        
        try { // Call Web Service Operation
            app.web.webservice.WebService_Service service = new app.web.webservice.WebService_Service();
            app.web.webservice.WebService port = service.getWebServicePort();
            byte result = port.actualizarCliente(nmCliente, cdCliente, dnNombre, dnDireccion, dnEmail, cdUsuario, cdTelefono, dsContacto, dsLogo);
            return result;
        } catch (Exception ex) {
            return -1;
        }
    }

  
    public app.web.webservice.ThomClienteEntity getBuscarClientes(Integer nm_cliente) {
        try { // Call Web Service Operation
            app.web.webservice.WebService_Service service = new app.web.webservice.WebService_Service();
            app.web.webservice.WebService port = service.getWebServicePort();
            
            app.web.webservice.ThomClienteEntity result = port.buscarCliente(nm_cliente);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    
    
    
}
