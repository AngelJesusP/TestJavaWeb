/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.DAOImpl;

import app.web.DAO.ClienteDAO;
import app.web.Entity.ThomClienteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author angel
 */
@Stateless
public class ClienteDAOImpl implements ClienteDAO {

    @PersistenceContext(unitName = "unidadPersistenciaThomCliente")
    private EntityManager em;
    
    private Query query;
    private ThomClienteEntity clienteAuxiliar;
    
    @Override
    public byte createCliente(ThomClienteEntity cliente) {
        try {
            this.clienteAuxiliar = this.em.find(ThomClienteEntity.class, cliente.getNmCliente());
            if (this.clienteAuxiliar == null) {
                this.em.persist(cliente);
                this.em.flush();
                return 0;
            }
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    @Override
    public List<ThomClienteEntity> listClientes() {
        try {
            this.query = this.em.createNamedQuery("ThomClienteEntity.findAll");
            return this.query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public byte removeCliente(Integer nm_cliente) {
        try {
            this.clienteAuxiliar = this.em.find(ThomClienteEntity.class, nm_cliente);
            if (this.clienteAuxiliar != null) {
                this.em.remove(this.clienteAuxiliar);
                this.em.flush();
                return 0;
            }
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    @Override
    public byte updateCliente(ThomClienteEntity cliente) {
        try {
            this.clienteAuxiliar = this.em.find(ThomClienteEntity.class, cliente.getNmCliente());
            if (this.clienteAuxiliar != null) {
                cliente.setFechaBaja(this.clienteAuxiliar.getFechaBaja());
                cliente.setFechaRegistro(this.clienteAuxiliar.getFechaRegistro());
                this.em.merge(cliente);
                this.em.flush();
                return 0;
            }
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    @Override
    public ThomClienteEntity findCliente(Integer nm_cliente) {
        return this.em.find(ThomClienteEntity.class, nm_cliente);
    }

}
