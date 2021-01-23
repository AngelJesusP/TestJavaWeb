/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.com.InterfacesDao;

import app.com.Entity.ThomClienteEntity;
import java.util.List;
/**
 *
 * @author angel
 */
public interface ManteniemientoTable {  
    public boolean setRegistroCliente(ThomClienteEntity cliente);
    public List<ThomClienteEntity> getListarClientes();
    public boolean setEliminarCliente(Integer nm_cliente);
    public boolean setActualizarCliente(ThomClienteEntity cliente);
    public ThomClienteEntity setBuscarCliente(Integer id);
}
