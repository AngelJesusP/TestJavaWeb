/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web.DaoImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import app.web.DAO.ClienteDao;
import app.web.Entity.ThomClienteEntity;
import app.web.MangedBean.ClienteBean;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author angel
 */
@Stateless
public class ClienteImpl implements ClienteDao {

    @PersistenceContext(unitName = "unidadPersistenciaPrimefaces_hibernate")
    private EntityManager em;

    private ThomClienteEntity clienteAux;
    private static Logger log = Logger.getLogger(ClienteBean.class.getName());

    @Override
    public boolean setRegistrarCliente(ThomClienteEntity cliente) {
        try {
            this.clienteAux = this.em.find(ThomClienteEntity.class, cliente.getNmCliente());
            if (this.clienteAux == null) {
                this.em.persist(cliente);
                this.em.flush();
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Registro NO completado, Ocurrio un fallo de inserccion: "+e.getMessage());
            return false;
        }
    }

    @Override
    public List<ThomClienteEntity> getListarClientes() {
        try {
            Query queryCliente = this.em.createNamedQuery("ThomClienteEntity.findAll");
            return queryCliente.getResultList();
        } catch (Exception e) { return null; }
    }

    @Override
    public boolean setEliminarCliente(Integer nm_cliente) {
        try {
            this.clienteAux = this.em.find(ThomClienteEntity.class, nm_cliente);
            if (this.clienteAux != null) {
                this.em.remove(this.clienteAux);
                this.em.flush();
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Error al tratar de eliminar el registro, Verificar "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean setActualizarCliente(ThomClienteEntity cliente) {
        try {
            this.em.merge(cliente);
            this.em.flush();
            return true;
        } catch (Exception e) {
            log.error("Error al tratar de actualizar el registro, Verificar fallos de inserccion: "+e.getMessage());
            return false;
        }
    }

    @Override
    public ThomClienteEntity setBuscarCliente(Integer nm_cliente) {
        try {
            this.clienteAux = this.em.find(ThomClienteEntity.class, nm_cliente);
            return (this.clienteAux != null) ? this.clienteAux : null;
        } catch (Exception e) { return null; }
    }
}
