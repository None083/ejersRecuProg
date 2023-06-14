/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author FX506
 */
@Entity
@Table(name = "puntuacion")
@NamedQueries({
    @NamedQuery(name = "Puntuacion.findAll", query = "SELECT p FROM Puntuacion p"),
    @NamedQuery(name = "Puntuacion.findByIdpuntu", query = "SELECT p FROM Puntuacion p WHERE p.idpuntu = :idpuntu"),
    @NamedQuery(name = "Puntuacion.findByPuntuacion", query = "SELECT p FROM Puntuacion p WHERE p.puntuacion = :puntuacion"),
    @NamedQuery(name = "Puntuacion.findByComentario", query = "SELECT p FROM Puntuacion p WHERE p.comentario = :comentario")})
public class Puntuacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpuntu")
    private Integer idpuntu;
    @Column(name = "puntuacion")
    private Integer puntuacion;
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "obra_id", referencedColumnName = "idobra")
    @ManyToOne
    private Obra obraId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "idusu")
    @ManyToOne
    private Usuario usuarioId;

    public Puntuacion() {
    }

    public Puntuacion(Integer idpuntu) {
        this.idpuntu = idpuntu;
    }

    public Integer getIdpuntu() {
        return idpuntu;
    }

    public void setIdpuntu(Integer idpuntu) {
        this.idpuntu = idpuntu;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Obra getObraId() {
        return obraId;
    }

    public void setObraId(Obra obraId) {
        this.obraId = obraId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpuntu != null ? idpuntu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntuacion)) {
            return false;
        }
        Puntuacion other = (Puntuacion) object;
        if ((this.idpuntu == null && other.idpuntu != null) || (this.idpuntu != null && !this.idpuntu.equals(other.idpuntu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Puntuacion[ idpuntu=" + idpuntu + " ]";
    }
    
}
