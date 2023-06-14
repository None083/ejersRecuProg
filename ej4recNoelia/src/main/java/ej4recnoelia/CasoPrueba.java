/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4recnoelia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonPropertyOrder({
    "peso",
    "elefantes"
})



/**
 *
 * @author noelia
 */
public class CasoPrueba {
    
    @JsonProperty("peso")
    private int peso;
    @JsonProperty("elefantes")
    private List<Elefante> listaElefantes;

    public CasoPrueba() {

    }
    
    /**
     * 
     * @param peso
     * @param elefantes
     */
    public CasoPrueba(int peso, List<Elefante> listaElefantes) {
        this.peso = peso;
        this.listaElefantes = listaElefantes;
    } 
    
    
    @JsonProperty("peso")
    public int getPeso() {
        return peso;
    }

    @JsonProperty("peso")
    public void setPeso(int peso) {
        this.peso = peso;
    }

    @JsonProperty("elefantes")
    public List<Elefante> getListaElefantes() {
        return listaElefantes;
    }

    @JsonProperty("elefantes")
    public void setListaElefantes(List<Elefante> listaElefantes) {
        this.listaElefantes = listaElefantes;
    }

    @Override
    public String toString() {
        return "CasoPrueba{" + "peso=" + peso + ", listaElefantes=" + listaElefantes + '}';
    }

    
    
}
