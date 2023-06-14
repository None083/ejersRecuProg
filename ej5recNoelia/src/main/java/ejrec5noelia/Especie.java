/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec5noelia;

/**
 *
 * @author noelia
 */
public class Especie {
    
    private String nombre;

    public Especie(String nombre) {
        this.nombre = nombre;
    }

    public Especie() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Especie{" + "nombre=" + nombre + '}';
    }
    
    
    
}
