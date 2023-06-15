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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author noelia
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
        if (obra.getPuntuacionList() == null) {
            obra.setPuntuacionList(new ArrayList<Puntuacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario autorId = obra.getAutorId();
            if (autorId != null) {
                autorId = em.getReference(autorId.getClass(), autorId.getIdusu());
                obra.setAutorId(autorId);
            }
            List<Puntuacion> attachedPuntuacionList = new ArrayList<Puntuacion>();
            for (Puntuacion puntuacionListPuntuacionToAttach : obra.getPuntuacionList()) {
                puntuacionListPuntuacionToAttach = em.getReference(puntuacionListPuntuacionToAttach.getClass(), puntuacionListPuntuacionToAttach.getIdpuntu());
                attachedPuntuacionList.add(puntuacionListPuntuacionToAttach);
            }
            obra.setPuntuacionList(attachedPuntuacionList);
            em.persist(obra);
            if (autorId != null) {
                autorId.getObraList().add(obra);
                autorId = em.merge(autorId);
            }
            for (Puntuacion puntuacionListPuntuacion : obra.getPuntuacionList()) {
                Obra oldObraIdOfPuntuacionListPuntuacion = puntuacionListPuntuacion.getObraId();
                puntuacionListPuntuacion.setObraId(obra);
                puntuacionListPuntuacion = em.merge(puntuacionListPuntuacion);
                if (oldObraIdOfPuntuacionListPuntuacion != null) {
                    oldObraIdOfPuntuacionListPuntuacion.getPuntuacionList().remove(puntuacionListPuntuacion);
                    oldObraIdOfPuntuacionListPuntuacion = em.merge(oldObraIdOfPuntuacionListPuntuacion);
                }
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
            List<Puntuacion> puntuacionListOld = persistentObra.getPuntuacionList();
            List<Puntuacion> puntuacionListNew = obra.getPuntuacionList();
            if (autorIdNew != null) {
                autorIdNew = em.getReference(autorIdNew.getClass(), autorIdNew.getIdusu());
                obra.setAutorId(autorIdNew);
            }
            List<Puntuacion> attachedPuntuacionListNew = new ArrayList<Puntuacion>();
            for (Puntuacion puntuacionListNewPuntuacionToAttach : puntuacionListNew) {
                puntuacionListNewPuntuacionToAttach = em.getReference(puntuacionListNewPuntuacionToAttach.getClass(), puntuacionListNewPuntuacionToAttach.getIdpuntu());
                attachedPuntuacionListNew.add(puntuacionListNewPuntuacionToAttach);
            }
            puntuacionListNew = attachedPuntuacionListNew;
            obra.setPuntuacionList(puntuacionListNew);
            obra = em.merge(obra);
            if (autorIdOld != null && !autorIdOld.equals(autorIdNew)) {
                autorIdOld.getObraList().remove(obra);
                autorIdOld = em.merge(autorIdOld);
            }
            if (autorIdNew != null && !autorIdNew.equals(autorIdOld)) {
                autorIdNew.getObraList().add(obra);
                autorIdNew = em.merge(autorIdNew);
            }
            for (Puntuacion puntuacionListOldPuntuacion : puntuacionListOld) {
                if (!puntuacionListNew.contains(puntuacionListOldPuntuacion)) {
                    puntuacionListOldPuntuacion.setObraId(null);
                    puntuacionListOldPuntuacion = em.merge(puntuacionListOldPuntuacion);
                }
            }
            for (Puntuacion puntuacionListNewPuntuacion : puntuacionListNew) {
                if (!puntuacionListOld.contains(puntuacionListNewPuntuacion)) {
                    Obra oldObraIdOfPuntuacionListNewPuntuacion = puntuacionListNewPuntuacion.getObraId();
                    puntuacionListNewPuntuacion.setObraId(obra);
                    puntuacionListNewPuntuacion = em.merge(puntuacionListNewPuntuacion);
                    if (oldObraIdOfPuntuacionListNewPuntuacion != null && !oldObraIdOfPuntuacionListNewPuntuacion.equals(obra)) {
                        oldObraIdOfPuntuacionListNewPuntuacion.getPuntuacionList().remove(puntuacionListNewPuntuacion);
                        oldObraIdOfPuntuacionListNewPuntuacion = em.merge(oldObraIdOfPuntuacionListNewPuntuacion);
                    }
                }
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
            List<Puntuacion> puntuacionList = obra.getPuntuacionList();
            for (Puntuacion puntuacionListPuntuacion : puntuacionList) {
                puntuacionListPuntuacion.setObraId(null);
                puntuacionListPuntuacion = em.merge(puntuacionListPuntuacion);
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
