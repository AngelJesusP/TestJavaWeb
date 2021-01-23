/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.com.clienteControllerJPA;

import app.com.Entity.ThomClienteEntity;
import app.com.clienteControllerJPA.exceptions.NonexistentEntityException;
import app.com.clienteControllerJPA.exceptions.PreexistingEntityException;
import app.com.clienteControllerJPA.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author angel
 */
public class ThomClienteEntityJpaController implements Serializable {

    private UserTransaction utx;
    
    @PersistenceUnit(unitName = "app_test_html_jquery_war_1.0-SNAPSHOTPU")
    private EntityManagerFactory emf = null;

    public ThomClienteEntityJpaController() { }
    public ThomClienteEntityJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
    /* Si la unidad de persistencia es null, La inicializamos */
    public EntityManager getEntityManager() {
        if (this.emf == null) {
            this.emf = Persistence.createEntityManagerFactory("app_test_html_jquery_war_1.0-SNAPSHOTPU");
        }
        return emf.createEntityManager();
    }
    
    /* Si el UserTransaction es null , la inicializamos */
    private void getInitUserTransaction() throws NamingException {
        this.utx = InitialContext.doLookup("java:comp/UserTransaction");
    }
    
    
    public void create(ThomClienteEntity thomClienteEntity) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        this.getInitUserTransaction(); /* Agregamos el UserTransaction para poder user el metodo CREATE */
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(thomClienteEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                System.out.println("Message: "+re.getMessage());
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findThomClienteEntity(thomClienteEntity.getNmCliente()) != null) {
                throw new PreexistingEntityException("ThomClienteEntity " + thomClienteEntity + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ThomClienteEntity thomClienteEntity) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        this.getInitUserTransaction(); /* Agregamos el UserTransaction para poder user el metodo EDIT */
        try {
            utx.begin();
            em = getEntityManager();
            thomClienteEntity = em.merge(thomClienteEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                System.out.println("Message: "+re.getMessage());
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = thomClienteEntity.getNmCliente();
                if (findThomClienteEntity(id) == null) {
                    throw new NonexistentEntityException("The thomClienteEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        this.getInitUserTransaction(); /* Agregamos el UserTransaction para poder user el metodo DESTROY */
        try {
            utx.begin();
            em = getEntityManager();
            ThomClienteEntity thomClienteEntity;
            try {
                thomClienteEntity = em.getReference(ThomClienteEntity.class, id);
                thomClienteEntity.getNmCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The thomClienteEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(thomClienteEntity);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ThomClienteEntity> findThomClienteEntityEntities() {
        return findThomClienteEntityEntities(true, -1, -1);
    }

    public List<ThomClienteEntity> findThomClienteEntityEntities(int maxResults, int firstResult) {
        return findThomClienteEntityEntities(false, maxResults, firstResult);
    }

    private List<ThomClienteEntity> findThomClienteEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
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
        EntityManager em = getEntityManager();
        try {
            return em.find(ThomClienteEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getThomClienteEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ThomClienteEntity> rt = cq.from(ThomClienteEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
