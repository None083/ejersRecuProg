/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author FX506
 */
@Entity
@Table(name = "obra")
@NamedQueries({
    @NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o"),
    @NamedQuery(name = "Obra.findByIdobra", query = "SELECT o FROM Obra o WHERE o.idobra = :idobra"),
    @NamedQuery(name = "Obra.findByTitulo", query = "SELECT o FROM Obra o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Obra.findByDescripcion", query = "SELECT o FROM Obra o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Obra.findByA\u00f1oPublicacion", query = "SELECT o FROM Obra o WHERE o.a\u00f1oPublicacion = :a\u00f1oPublicacion"),
    @NamedQuery(name = "Obra.findByCategoria", query = "SELECT o FROM Obra o WHERE o.categoria = :categoria")})
public class Obra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idobra")
    private Integer idobra;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "a\u00f1o_publicacion")
    private Integer añoPublicacion;
    @Column(name = "categoria")
    private String categoria;
    @JoinColumn(name = "autor_id", referencedColumnName = "idusu")
    @ManyToOne
    private Usuario autorId;
    @OneToMany(mappedBy = "obraId")
    private List<Puntuacion> puntuacionList;

    public Obra() {
    }

    public Obra(Integer idobra) {
        this.idobra = idobra;
    }

    public Obra(Integer idobra, String titulo) {
        this.idobra = idobra;
        this.titulo = titulo;
    }

    public Integer getIdobra() {
        return idobra;
    }

    public void setIdobra(Integer idobra) {
        this.idobra = idobra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Integer añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getAutorId() {
        return autorId;
    }

    public void setAutorId(Usuario autorId) {
        this.autorId = autorId;
    }

    public List<Puntuacion> getPuntuacionList() {
        return puntuacionList;
    }

    public void setPuntuacionList(List<Puntuacion> puntuacionList) {
        this.puntuacionList = puntuacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobra != null ? idobra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obra)) {
            return false;
        }
        Obra other = (Obra) object;
        if ((this.idobra == null && other.idobra != null) || (this.idobra != null && !this.idobra.equals(other.idobra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Obra[ idobra=" + idobra + " ]";
    }
    
}
