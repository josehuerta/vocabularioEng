/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Animales;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.exceptions.NonexistentEntityException;

/**
 *
 * @author LALO
 */
public class AnimalesJpaController implements Serializable {

    public AnimalesJpaController() {
       this.emf =Persistence.createEntityManagerFactory("ProyectoPU") ;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Animales animales) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(animales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Animales animales) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            animales = em.merge(animales);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = animales.getIdAnimal();
                if (findAnimales(id) == null) {
                    throw new NonexistentEntityException("The animales with id " + id + " no longer exists.");
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
            Animales animales;
            try {
                animales = em.getReference(Animales.class, id);
                animales.getIdAnimal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The animales with id " + id + " no longer exists.", enfe);
            }
            em.remove(animales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Animales> findAnimalesEntities() {
        return findAnimalesEntities(true, -1, -1);
    }

    public List<Animales> findAnimalesEntities(int maxResults, int firstResult) {
        return findAnimalesEntities(false, maxResults, firstResult);
    }

    private List<Animales> findAnimalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Animales.class));
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

    public Animales findAnimales(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Animales.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnimalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Animales> rt = cq.from(Animales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
