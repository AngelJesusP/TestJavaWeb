/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.webSer.DAOImpl;

import app.webSer.ControllerJPA.ThomClienteEntityJpaController;
import app.webSer.Entity.ThomClienteEntity;
import java.util.List;
import javax.ejb.Stateless;
import app.webSer.DAO.ClienteDAO;
/**
 *
 * @author angel
 */
@Stateless
public class ClienteImpl implements ClienteDAO {
    
    private ThomClienteEntityJpaController controladorCliente = new ThomClienteEntityJpaController();
    
    @Override
    public String setRegistrarCliente(ThomClienteEntity cliente) {
        try {
            this.controladorCliente.create(cliente);
            return "Completado";
        } catch (Exception e) {
            System.out.println("MESSAGE: "+e.getMessage());
            return e.getMessage();
        }
    }
    
    @Override
    public List<ThomClienteEntity> getListarClientes() {
        return this.controladorCliente.findThomClienteEntityEntities();
    }

    @Override
    public boolean setEliminarCliente(Integer nm_cliente) {
        try {
            this.controladorCliente.destroy(nm_cliente);
            return true;
        } catch (Exception e) { return false; }
    }

    @Override
    public boolean setActualizarCliente(ThomClienteEntity cliente) {
        try {
            this.controladorCliente.create(cliente);
            return true;
        } catch (Exception e) {
            System.out.println("MESSAGE: "+e.getMessage());
            return false;
        }
    }

    @Override
    public ThomClienteEntity setBuscarCliente(Integer nm_cliente) {
        return this.controladorCliente.findThomClienteEntity(nm_cliente);
    }   
    
}