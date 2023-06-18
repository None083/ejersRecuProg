/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.Obra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Usuario;
import entidades.Puntuacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author FX506
 */
public class ObraJpaController implements Serializable {

    public ObraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Obra obra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario autorId = obra.getAutorId();
            if (autorId != null) {
                autorId = em.getReference(autorId.getClass(), autorId.getIdusu());
                obra.setAutorId(autorId);
            }
            Puntuacion puntuacion = obra.getPuntuacion();
            if (puntuacion != null) {
                puntuacion = em.getReference(puntuacion.getClass(), puntuacion.getIdpuntu());
                obra.setPuntuacion(puntuacion);
            }
            em.persist(obra);
            if (autorId != null) {
                autorId.getObraList().add(obra);
                autorId = em.merge(autorId);
            }
            if (puntuacion != null) {
                Obra oldObraIdOfPuntuacion = puntuacion.getObraId();
                if (oldObraIdOfPuntuacion != null) {
                    oldObraIdOfPuntuacion.setPuntuacion(null);
                    oldObraIdOfPuntuacion = em.merge(oldObraIdOfPuntuacion);
                }
                puntuacion.setObraId(obra);
                puntuacion = em.merge(puntuacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Obra obra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Obra persistentObra = em.find(Obra.class, obra.getIdobra());
            Usuario autorIdOld = persistentObra.getAutorId();
            Usuario autorIdNew = obra.getAutorId();
            Puntuacion puntuacionOld = persistentObra.getPuntuacion();
            Puntuacion puntuacionNew = obra.getPuntuacion();
            if (autorIdNew != null) {
                autorIdNew = em.getReference(autorIdNew.getClass(), autorIdNew.getIdusu());
                obra.setAutorId(autorIdNew);
            }
            if (puntuacionNew != null) {
                puntuacionNew = em.getReference(puntuacionNew.getClass(), puntuacionNew.getIdpuntu());
                obra.setPuntuacion(puntuacionNew);
            }
            obra = em.merge(obra);
            if (autorIdOld != null && !autorIdOld.equals(autorIdNew)) {
                autorIdOld.getObraList().remove(obra);
                autorIdOld = em.merge(autorIdOld);
            }
            if (autorIdNew != null && !autorIdNew.equals(autorIdOld)) {
                autorIdNew.getObraList().add(obra);
                autorIdNew = em.merge(autorIdNew);
            }
            if (puntuacionOld != null && !puntuacionOld.equals(puntuacionNew)) {
                puntuacionOld.setObraId(null);
                puntuacionOld = em.merge(puntuacionOld);
            }
            if (puntuacionNew != null && !puntuacionNew.equals(puntuacionOld)) {
                Obra oldObraIdOfPuntuacion = puntuacionNew.getObraId();
                if (oldObraIdOfPuntuacion != null) {
                    oldObraIdOfPuntuacion.setPuntuacion(null);
                    oldObraIdOfPuntuacion = em.merge(oldObraIdOfPuntuacion);
                }
                puntuacionNew.setObraId(obra);
                puntuacionNew = em.merge(puntuacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = obra.getIdobra();
                if (findObra(id) == null) {
                    throw new NonexistentEntityException("The obra with id " + id + " no longer exists.");
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
            Obra obra;
            try {
                obra = em.getReference(Obra.class, id);
                obra.getIdobra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The obra with id " + id + " no longer exists.", enfe);
            }
            Usuario autorId = obra.getAutorId();
            if (autorId != null) {
                autorId.getObraList().remove(obra);
                autorId = em.merge(autorId);
            }
            Puntuacion puntuacion = obra.getPuntuacion();
            if (puntuacion != null) {
                puntuacion.setObraId(null);
                puntuacion = em.merge(puntuacion);
            }
            em.remove(obra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Obra> findObraEntities() {
        return findObraEntities(true, -1, -1);
    }

    public List<Obra> findObraEntities(int maxResults, int firstResult) {
        return findObraEntities(false, maxResults, firstResult);
    }

    private List<Obra> findObraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Obra.class));
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

    public Obra findObra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Obra.class, id);
        } finally {
            em.close();
        }
    }

    public int getObraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Obra> rt = cq.from(Obra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
