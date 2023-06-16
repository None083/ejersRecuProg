/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1;

import java.time.LocalDateTime;

/**
 *
 * @author noelia
 */
public class Matricula {
    
    private String nombre;
    //private LocalDateTime fechaReg;
    private String fechaReg;
    private int TICO;
    private int CDPC;
    private int AYSO;
    private int ANAP;
    private int PCYAA;
    private int FR2;

    public Matricula() {
    }

    public Matricula(String nombre, String fechaReg, int TICO, int CDPC, int AYSO, int ANAP, int PCYAA, int FR2) {
        this.nombre = nombre;
        this.fechaReg = fechaReg;
        this.TICO = TICO;
        this.CDPC = CDPC;
        this.AYSO = AYSO;
        this.ANAP = ANAP;
        this.PCYAA = PCYAA;
        this.FR2 = FR2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(String fechaReg) {
        this.fechaReg = fechaReg;
    }

    public int getTICO() {
        return TICO;
    }

    public void setTICO(int TICO) {
        this.TICO = TICO;
    }

    public int getCDPC() {
        return CDPC;
    }

    public void setCDPC(int CDPC) {
        this.CDPC = CDPC;
    }

    public int getAYSO() {
        return AYSO;
    }

    public void setAYSO(int AYSO) {
        this.AYSO = AYSO;
    }

    public int getANAP() {
        return ANAP;
    }

    public void setANAP(int ANAP) {
        this.ANAP = ANAP;
    }

    public int getPCYAA() {
        return PCYAA;
    }

    public void setPCYAA(int PCYAA) {
        this.PCYAA = PCYAA;
    }

    public int getFR2() {
        return FR2;
    }

    public void setFR2(int FR2) {
        this.FR2 = FR2;
    }

    @Override
    public String toString() {
        return "Matricula{" + "nombre=" + nombre + ", fechaReg=" + fechaReg + ", TICO=" + TICO + ", CDPC=" + CDPC + ", AYSO=" + AYSO + ", ANAP=" + ANAP + ", PCYAA=" + PCYAA + ", FR2=" + FR2 + '}';
    }

    
    
    
    
}
