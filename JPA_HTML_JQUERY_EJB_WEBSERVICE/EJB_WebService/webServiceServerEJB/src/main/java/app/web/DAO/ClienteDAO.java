/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.DAO;

import app.web.Entity.ThomClienteEntity;
import java.util.List;

public interface ClienteDAO {
    
    public byte createCliente(ThomClienteEntity cliente);
    public List<ThomClienteEntity> listClientes();
    public byte removeCliente(Integer nm_cliente);
    public byte updateCliente(ThomClienteEntity cliente);
    public ThomClienteEntity findCliente(Integer nm_cliente);
    
}
