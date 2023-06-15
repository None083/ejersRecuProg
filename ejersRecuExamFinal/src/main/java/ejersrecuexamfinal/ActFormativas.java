/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejersrecuexamfinal;

import java.time.LocalDate;

/**
 *
 * @author noelia
 */
public class ActFormativas {
    
    private String centro;
    private String codigo;
    private String titulo;
    private String modalidad;
    private String estado;
    private LocalDate fecIni;
    private LocalDate fecFin;
    private String dirigido;

    public ActFormativas() {
    }

    public ActFormativas(String centro, String codigo, String titulo, String modalidad, String estado, LocalDate fecIni, LocalDate fecFin, String dirigido) {
        this.centro = centro;
        this.codigo = codigo;
        this.titulo = titulo;
        this.modalidad = modalidad;
        this.estado = estado;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.dirigido = dirigido;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecIni() {
        return fecIni;
    }

    public void setFecIni(LocalDate fecIni) {
        this.fecIni = fecIni;
    }

    public LocalDate getFecFin() {
        return fecFin;
    }

    public void setFecFin(LocalDate fecFin) {
        this.fecFin = fecFin;
    }

    public String getDirigido() {
        return dirigido;
    }

    public void setDirigido(String dirigido) {
        this.dirigido = dirigido;
    }

    @Override
    public String toString() {
        return "ActFormativas{" + "centro=" + centro + ", codigo=" + codigo + ", titulo=" + titulo + ", modalidad=" + modalidad + ", estado=" + estado + ", fecIni=" + fecIni + ", fecFin=" + fecFin + ", dirigido=" + dirigido + '}';
    }

    ActFormativas[] split(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
