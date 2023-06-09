/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4recnoelia;

/**
 *
 * @author noelia
 */
public class Elefante {
    
    private String nombre;
    private int peso;

    public Elefante() {
    }

    public Elefante(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = Math.abs(peso);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = Math.abs(peso);
    }

    @Override
    public String toString() {
        return nombre + ", Peso: " + peso;
    }
    
    
    
}
