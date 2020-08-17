/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entidades.Partesdecuerpo;
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
public class PartesdecuerpoJpaController implements Serializable {

    public PartesdecuerpoJpaController() {
        this.emf =Persistence.createEntityManagerFactory("ProyectoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Partesdecuerpo partesdecuerpo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(partesdecuerpo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Partesdecuerpo partesdecuerpo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            partesdecuerpo = em.merge(partesdecuerpo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = partesdecuerpo.getIdParte();
                if (findPartesdecuerpo(id) == null) {
                    throw new NonexistentEntityException("The partesdecuerpo with id " + id + " no longer exists.");
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
            Partesdecuerpo partesdecuerpo;
            try {
                partesdecuerpo = em.getReference(Partesdecuerpo.class, id);
                partesdecuerpo.getIdParte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The partesdecuerpo with id " + id + " no longer exists.", enfe);
            }
            em.remove(partesdecuerpo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Partesdecuerpo> findPartesdecuerpoEntities() {
        return findPartesdecuerpoEntities(true, -1, -1);
    }

    public List<Partesdecuerpo> findPartesdecuerpoEntities(int maxResults, int firstResult) {
        return findPartesdecuerpoEntities(false, maxResults, firstResult);
    }

    private List<Partesdecuerpo> findPartesdecuerpoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Partesdecuerpo.class));
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

    public Partesdecuerpo findPartesdecuerpo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Partesdecuerpo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartesdecuerpoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Partesdecuerpo> rt = cq.from(Partesdecuerpo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
