/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Obra;
import entidades.Puntuacion;
import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author noelia
 */
public class PuntuacionJpaController implements Serializable {

    public PuntuacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puntuacion puntuacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Obra obraId = puntuacion.getObraId();
            if (obraId != null) {
                obraId = em.getReference(obraId.getClass(), obraId.getIdobra());
                puntuacion.setObraId(obraId);
            }
            Usuario usuarioId = puntuacion.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getIdusu());
                puntuacion.setUsuarioId(usuarioId);
            }
            em.persist(puntuacion);
            if (obraId != null) {
                obraId.getPuntuacionList().add(puntuacion);
                obraId = em.merge(obraId);
            }
            if (usuarioId != null) {
                usuarioId.getPuntuacionList().add(puntuacion);
                usuarioId = em.merge(usuarioId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puntuacion puntuacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puntuacion persistentPuntuacion = em.find(Puntuacion.class, puntuacion.getIdpuntu());
            Obra obraIdOld = persistentPuntuacion.getObraId();
            Obra obraIdNew = puntuacion.getObraId();
            Usuario usuarioIdOld = persistentPuntuacion.getUsuarioId();
            Usuario usuarioIdNew = puntuacion.getUsuarioId();
            if (obraIdNew != null) {
                obraIdNew = em.getReference(obraIdNew.getClass(), obraIdNew.getIdobra());
                puntuacion.setObraId(obraIdNew);
            }
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getIdusu());
                puntuacion.setUsuarioId(usuarioIdNew);
            }
            puntuacion = em.merge(puntuacion);
            if (obraIdOld != null && !obraIdOld.equals(obraIdNew)) {
                obraIdOld.getPuntuacionList().remove(puntuacion);
                obraIdOld = em.merge(obraIdOld);
            }
            if (obraIdNew != null && !obraIdNew.equals(obraIdOld)) {
                obraIdNew.getPuntuacionList().add(puntuacion);
                obraIdNew = em.merge(obraIdNew);
            }
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getPuntuacionList().remove(puntuacion);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getPuntuacionList().add(puntuacion);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = puntuacion.getIdpuntu();
                if (findPuntuacion(id) == null) {
                    throw new NonexistentEntityException("The puntuacion with id " + id + " no longer exists.");
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
            Puntuacion puntuacion;
            try {
                puntuacion = em.getReference(Puntuacion.class, id);
                puntuacion.getIdpuntu();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puntuacion with id " + id + " no longer exists.", enfe);
            }
            Obra obraId = puntuacion.getObraId();
            if (obraId != null) {
                obraId.getPuntuacionList().remove(puntuacion);
                obraId = em.merge(obraId);
            }
            Usuario usuarioId = puntuacion.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getPuntuacionList().remove(puntuacion);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(puntuacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puntuacion> findPuntuacionEntities() {
        return findPuntuacionEntities(true, -1, -1);
    }

    public List<Puntuacion> findPuntuacionEntities(int maxResults, int firstResult) {
        return findPuntuacionEntities(false, maxResults, firstResult);
    }

    private List<Puntuacion> findPuntuacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puntuacion.class));
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

    public Puntuacion findPuntuacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puntuacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuntuacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puntuacion> rt = cq.from(Puntuacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
