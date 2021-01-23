/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.com.DAO;

import app.com.Entity.ThomClienteEntity;
import app.com.InterfacesDao.ManteniemientoTable;
import java.util.List;
import app.com.clienteControllerJPA.ThomClienteEntityJpaController;
import java.util.ArrayList;
/**
 *
 * @author angel
 */
public class ClienteImp implements ManteniemientoTable {

    private ThomClienteEntityJpaController TCEJ = new ThomClienteEntityJpaController();
    private List<ThomClienteEntity> listaCliente = null;
    
    @Override
    public boolean setRegistroCliente(ThomClienteEntity cliente) {
        try {
            this.TCEJ.create(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ThomClienteEntity> getListarClientes() {
        this.listaCliente = new ArrayList<>();
        try {
            this.listaCliente = this.TCEJ.findThomClienteEntityEntities();
            return this.listaCliente;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean setEliminarCliente(Integer nm_cliente) {
        try {
            this.TCEJ.destroy(nm_cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean setActualizarCliente(ThomClienteEntity cliente) {
        try {
            this.TCEJ.edit(cliente);
            return true;
        } catch (Exception e) {
            System.out.println("Message Error: "+e.getMessage());
            return false;
        }
    }

    @Override
    public ThomClienteEntity setBuscarCliente(Integer id) {
        return this.TCEJ.findThomClienteEntity(id);
    }
    
}
