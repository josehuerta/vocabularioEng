/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entidades.Verbosirregulares;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author LALO
 */
public class VerbosirregularesJpaController implements Serializable {

    public VerbosirregularesJpaController() {
        this.emf =Persistence.createEntityManagerFactory("ProyectoPU") ;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Verbosirregulares verbosirregulares) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(verbosirregulares);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Verbosirregulares verbosirregulares) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            verbosirregulares = em.merge(verbosirregulares);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = verbosirregulares.getIdVerbo();
                if (findVerbosirregulares(id) == null) {
                    throw new NonexistentEntityException("The verbosirregulares with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Verbosirregulares verbosirregulares;
            try {
                verbosirregulares = em.getReference(Verbosirregulares.class, id);
                verbosirregulares.getIdVerbo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The verbosirregulares with id " + id + " no longer exists.", enfe);
            }
            em.remove(verbosirregulares);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Verbosirregulares> findVerbosirregularesEntities() {
        return findVerbosirregularesEntities(true, -1, -1);
    }

    public List<Verbosirregulares> findVerbosirregularesEntities(int maxResults, int firstResult) {
        return findVerbosirregularesEntities(false, maxResults, firstResult);
    }

    private List<Verbosirregulares> findVerbosirregularesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Verbosirregulares.class));
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

    public Verbosirregulares findVerbosirregulares(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Verbosirregulares.class, id);
        } finally {
            em.close();
        }
    }

    public int getVerbosirregularesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Verbosirregulares> rt = cq.from(Verbosirregulares.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
