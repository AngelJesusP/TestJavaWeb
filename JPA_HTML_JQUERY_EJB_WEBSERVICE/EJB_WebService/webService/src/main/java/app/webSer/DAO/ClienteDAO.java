/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.webSer.DAO;

import app.webSer.Entity.ThomClienteEntity;
import java.util.List;
/**
 *
 * @author angel
 */
public interface ClienteDAO {
    
    public String setRegistrarCliente(ThomClienteEntity cliente);
    public List<ThomClienteEntity> getListarClientes();
    public boolean setEliminarCliente(Integer nm_cliente);
    public boolean setActualizarCliente(ThomClienteEntity cliente);
    public ThomClienteEntity setBuscarCliente(Integer nm_cliente);
    
}
