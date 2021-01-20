/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.MangedBean;

import app.web.DAO.ClienteDao;
import app.web.Entity.ThomClienteEntity;
import app.web.Utils.JsfUtils;

import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author angel
 */
@Named(value = "clienteBean")
@ManagedBean(name = "clienteBean")
@RequestScoped
@ViewScoped
public class ClienteBean {

    @EJB
    private ClienteDao clienteImpl;

    private List<ThomClienteEntity> listaClientes = new ArrayList<>();
    private ThomClienteEntity cliente = new ThomClienteEntity();
    private final JsfUtils jsfUtil = new JsfUtils();

    private String myTimeStampBaja;
    private String nm_clienteBuscar;
    private boolean respuesta;

    private static Logger log = Logger.getLogger(ClienteBean.class.getName());
    
    public ClienteBean() { }

    /* METODOS A REALIZAR */
    public void setRegistrar_Actualizar_Cliente(boolean entrada) {
        try {
            this.myTimeStampBaja += " 00:00:00.000";

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            this.myTimeStampBaja += " 00:00:00.000";
            Date parsedDate = dateFormat.parse(this.myTimeStampBaja);
            Timestamp timestampBaja = new Timestamp(parsedDate.getTime());

            this.getCliente().setFechaBaja(timestampBaja);
            if (entrada) {
                Date fecha = new Date();
                Timestamp timeActual = new Timestamp(fecha.getTime());
                Timestamp myTimeStamp = timeActual;
                this.getCliente().setFechaRegistro(myTimeStamp);
            }
            
            this.respuesta = (entrada) ? clienteImpl.setRegistrarCliente(getCliente()) : clienteImpl.setActualizarCliente(getCliente());
            if (respuesta) {
                this.jsfUtil.getMessageDialog(true, "ACCION COMPLETADA",(entrada)?"Cliente registrado con exito.":"Actualizacion completada");
            } else {
                this.jsfUtil.getMessageDialog(false, "ERROR", "Ocurrio un error al momento de registrar");
            }
        } catch (ParseException e) {
            log.error("Ocurrio un error al momento de regsitrar "+e.getMessage());
        }
    }

    public void setBuscarCliente() {
        try {
            this.setCliente(this.clienteImpl.setBuscarCliente(Integer.parseInt(this.nm_clienteBuscar)));
            if (this.cliente == null) {
                this.jsfUtil.getMessageDialog(false, "NUMERO DEL CLIENTE NO REGISTRADO", "EL nm_cliente ingresado, No esta en la base de datos !!");
            } else { this.setMyTimeStampBaja(this.timeStampToString()); }
            
        } catch (NumberFormatException e) {
            log.debug("Ocurrio un error al momento de realizar la busqueda: "+e.getMessage());
        }
    }

    public void setEliminarCliente() {
        try {
            if (this.cliente.getNmCliente() != null) {
                this.respuesta = this.clienteImpl.setEliminarCliente(this.getCliente().getNmCliente());
                
                if (respuesta) {
                    this.jsfUtil.getMessageDialog(true, "ACCION COMPLETADA", "Cliente eliminado con exito.");
                } else {
                    this.jsfUtil.getMessageDialog(false, "ERROR", "Ocurrio un error al momento de eliminar el registro");
                }
            } else {
                this.jsfUtil.getMessageDialog(false, "DEBE BUSCAR EL CLIENTE A ELIMINAR", "Accion no permitida, Debe buscar el cliente que desee eliminar");
            }
        } catch (Exception e) {
            log.error("Error, No se pudo eliminar el registro de la base de datos "+e.getMessage());
        }
    }

    public String timeStampToString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.getCliente().getFechaBaja());
    }

    /* METODOS GETTER - SETTER */
    public ThomClienteEntity getCliente(){ return cliente; }
    public String getMyTimeStampBaja()   { return myTimeStampBaja; }
    public String getNm_clienteBuscar()  { return nm_clienteBuscar;}
    public List<ThomClienteEntity> getListaClientes() {
        this.listaClientes = this.clienteImpl.getListarClientes();
        return listaClientes;
    }

    public void setCliente(ThomClienteEntity cliente){ this.cliente = cliente; }
    public void setMyTimeStampBaja(String timestamp) { this.myTimeStampBaja = timestamp;}
    public void setNm_clienteBuscar(String buscar)   { this.nm_clienteBuscar = buscar;  }

}
