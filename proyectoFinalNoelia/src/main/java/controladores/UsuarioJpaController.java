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
import java.util.ArrayList;
import java.util.List;
import entidades.Puntuacion;
import entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author noelia
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getObraList() == null) {
            usuario.setObraList(new ArrayList<Obra>());
        }
        if (usuario.getPuntuacionList() == null) {
            usuario.setPuntuacionList(new ArrayList<Puntuacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Obra> attachedObraList = new ArrayList<Obra>();
            for (Obra obraListObraToAttach : usuario.getObraList()) {
                obraListObraToAttach = em.getReference(obraListObraToAttach.getClass(), obraListObraToAttach.getIdobra());
                attachedObraList.add(obraListObraToAttach);
            }
            usuario.setObraList(attachedObraList);
            List<Puntuacion> attachedPuntuacionList = new ArrayList<Puntuacion>();
            for (Puntuacion puntuacionListPuntuacionToAttach : usuario.getPuntuacionList()) {
                puntuacionListPuntuacionToAttach = em.getReference(puntuacionListPuntuacionToAttach.getClass(), puntuacionListPuntuacionToAttach.getIdpuntu());
                attachedPuntuacionList.add(puntuacionListPuntuacionToAttach);
            }
            usuario.setPuntuacionList(attachedPuntuacionList);
            em.persist(usuario);
            for (Obra obraListObra : usuario.getObraList()) {
                Usuario oldAutorIdOfObraListObra = obraListObra.getAutorId();
                obraListObra.setAutorId(usuario);
                obraListObra = em.merge(obraListObra);
                if (oldAutorIdOfObraListObra != null) {
                    oldAutorIdOfObraListObra.getObraList().remove(obraListObra);
                    oldAutorIdOfObraListObra = em.merge(oldAutorIdOfObraListObra);
                }
            }
            for (Puntuacion puntuacionListPuntuacion : usuario.getPuntuacionList()) {
                Usuario oldUsuarioIdOfPuntuacionListPuntuacion = puntuacionListPuntuacion.getUsuarioId();
                puntuacionListPuntuacion.setUsuarioId(usuario);
                puntuacionListPuntuacion = em.merge(puntuacionListPuntuacion);
                if (oldUsuarioIdOfPuntuacionListPuntuacion != null) {
                    oldUsuarioIdOfPuntuacionListPuntuacion.getPuntuacionList().remove(puntuacionListPuntuacion);
                    oldUsuarioIdOfPuntuacionListPuntuacion = em.merge(oldUsuarioIdOfPuntuacionListPuntuacion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdusu());
            List<Obra> obraListOld = persistentUsuario.getObraList();
            List<Obra> obraListNew = usuario.getObraList();
            List<Puntuacion> puntuacionListOld = persistentUsuario.getPuntuacionList();
            List<Puntuacion> puntuacionListNew = usuario.getPuntuacionList();
            List<Obra> attachedObraListNew = new ArrayList<Obra>();
            for (Obra obraListNewObraToAttach : obraListNew) {
                obraListNewObraToAttach = em.getReference(obraListNewObraToAttach.getClass(), obraListNewObraToAttach.getIdobra());
                attachedObraListNew.add(obraListNewObraToAttach);
            }
            obraListNew = attachedObraListNew;
            usuario.setObraList(obraListNew);
            List<Puntuacion> attachedPuntuacionListNew = new ArrayList<Puntuacion>();
            for (Puntuacion puntuacionListNewPuntuacionToAttach : puntuacionListNew) {
                puntuacionListNewPuntuacionToAttach = em.getReference(puntuacionListNewPuntuacionToAttach.getClass(), puntuacionListNewPuntuacionToAttach.getIdpuntu());
                attachedPuntuacionListNew.add(puntuacionListNewPuntuacionToAttach);
            }
            puntuacionListNew = attachedPuntuacionListNew;
            usuario.setPuntuacionList(puntuacionListNew);
            usuario = em.merge(usuario);
            for (Obra obraListOldObra : obraListOld) {
                if (!obraListNew.contains(obraListOldObra)) {
                    obraListOldObra.setAutorId(null);
                    obraListOldObra = em.merge(obraListOldObra);
                }
            }
            for (Obra obraListNewObra : obraListNew) {
                if (!obraListOld.contains(obraListNewObra)) {
                    Usuario oldAutorIdOfObraListNewObra = obraListNewObra.getAutorId();
                    obraListNewObra.setAutorId(usuario);
                    obraListNewObra = em.merge(obraListNewObra);
                    if (oldAutorIdOfObraListNewObra != null && !oldAutorIdOfObraListNewObra.equals(usuario)) {
                        oldAutorIdOfObraListNewObra.getObraList().remove(obraListNewObra);
                        oldAutorIdOfObraListNewObra = em.merge(oldAutorIdOfObraListNewObra);
                    }
                }
            }
            for (Puntuacion puntuacionListOldPuntuacion : puntuacionListOld) {
                if (!puntuacionListNew.contains(puntuacionListOldPuntuacion)) {
                    puntuacionListOldPuntuacion.setUsuarioId(null);
                    puntuacionListOldPuntuacion = em.merge(puntuacionListOldPuntuacion);
                }
            }
            for (Puntuacion puntuacionListNewPuntuacion : puntuacionListNew) {
                if (!puntuacionListOld.contains(puntuacionListNewPuntuacion)) {
                    Usuario oldUsuarioIdOfPuntuacionListNewPuntuacion = puntuacionListNewPuntuacion.getUsuarioId();
                    puntuacionListNewPuntuacion.setUsuarioId(usuario);
                    puntuacionListNewPuntuacion = em.merge(puntuacionListNewPuntuacion);
                    if (oldUsuarioIdOfPuntuacionListNewPuntuacion != null && !oldUsuarioIdOfPuntuacionListNewPuntuacion.equals(usuario)) {
                        oldUsuarioIdOfPuntuacionListNewPuntuacion.getPuntuacionList().remove(puntuacionListNewPuntuacion);
                        oldUsuarioIdOfPuntuacionListNewPuntuacion = em.merge(oldUsuarioIdOfPuntuacionListNewPuntuacion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdusu();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdusu();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Obra> obraList = usuario.getObraList();
            for (Obra obraListObra : obraList) {
                obraListObra.setAutorId(null);
                obraListObra = em.merge(obraListObra);
            }
            List<Puntuacion> puntuacionList = usuario.getPuntuacionList();
            for (Puntuacion puntuacionListPuntuacion : puntuacionList) {
                puntuacionListPuntuacion.setUsuarioId(null);
                puntuacionListPuntuacion = em.merge(puntuacionListPuntuacion);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
