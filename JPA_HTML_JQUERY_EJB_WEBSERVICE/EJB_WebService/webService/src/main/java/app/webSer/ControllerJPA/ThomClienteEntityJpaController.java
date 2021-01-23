/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.webSer.ControllerJPA;

import app.webSer.ControllerJPA.exceptions.NonexistentEntityException;
import app.webSer.ControllerJPA.exceptions.PreexistingEntityException;
import app.webSer.ControllerJPA.exceptions.RollbackFailureException;
import app.webSer.Entity.ThomClienteEntity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import app.webSer.ConexionJPA.ConnectionJpa;
import javax.persistence.EntityNotFoundException;

public class ThomClienteEntityJpaController implements Serializable {
        
    private EntityManager em = null;

    public ThomClienteEntityJpaController() { }
    
    public void create(ThomClienteEntity thomClienteEntity) throws PreexistingEntityException, RollbackFailureException, Exception {
        this.em = ConnectionJpa.createEntityManager();
        try {
            this.em.getTransaction().begin();
            this.em.persist(thomClienteEntity);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ocurrio un error !!" + e.getMessage());
        }
    }

    public void edit(ThomClienteEntity thomClienteEntity) throws NonexistentEntityException, RollbackFailureException, Exception {
        this.em = ConnectionJpa.createEntityManager();
        try {
            this.em.getTransaction().begin();
            ThomClienteEntity clienteAux = this.em.find(ThomClienteEntity.class, thomClienteEntity.getNmCliente());
            if (this.em.contains(clienteAux)) {
                this.em.merge(thomClienteEntity);
            }
            this.em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ocurrio un error !!" + e.getMessage());
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        this.em = ConnectionJpa.createEntityManager();
        try {
            this.em.getTransaction().begin();
            ThomClienteEntity thomClienteEntity;
            try {
                thomClienteEntity = em.getReference(ThomClienteEntity.class, id);
                thomClienteEntity.getNmCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The thomClienteEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(thomClienteEntity);
            this.em.getTransaction().commit();
        } catch (Exception e) {   
        }
    }

    public List<ThomClienteEntity> findThomClienteEntityEntities() {
        return findThomClienteEntityEntities(true, -1, -1);
    }

    public List<ThomClienteEntity> findThomClienteEntityEntities(int maxResults, int firstResult) {
        return findThomClienteEntityEntities(false, maxResults, firstResult);
    }

    private List<ThomClienteEntity> findThomClienteEntityEntities(boolean all, int maxResults, int firstResult) {
        this.em = ConnectionJpa.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ThomClienteEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ThomClienteEntity findThomClienteEntity(Integer id) {
        this.em = ConnectionJpa.createEntityManager();
        try {
            return em.find(ThomClienteEntity.class, id);
        } finally {
            em.close();
        }
    }
}
