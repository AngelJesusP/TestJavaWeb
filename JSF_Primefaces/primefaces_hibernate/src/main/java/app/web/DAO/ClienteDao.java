/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.DAO;

import java.util.List;
import app.web.Entity.ThomClienteEntity;

public interface ClienteDao {
    
    public boolean setRegistrarCliente(ThomClienteEntity cliente);
    public List<ThomClienteEntity> getListarClientes();
    public boolean setEliminarCliente(Integer nm_cliente);
    public boolean setActualizarCliente(ThomClienteEntity cliente);
    public ThomClienteEntity setBuscarCliente(Integer nm_cliente);
    
}
