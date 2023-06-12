/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4recnoelia;

import java.util.List;

/**
 *
 * @author noelia
 */
public class CasoPrueba {
    
    private int peso;
    private List<Elefante> listaElefantes;

    public CasoPrueba() {

    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public List<Elefante> getListaElefantes() {
        return listaElefantes;
    }

    @Override
    public String toString() {
        return "CasoPrueba{" + "peso=" + peso + ", listaElefantes=" + listaElefantes + '}';
    }

    
    
    
}
