/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec5noelia;

/**
 *
 * @author noelia
 */
public class Vehiculo {
    
    private String nombre;

    public Vehiculo(String nombre) {
        this.nombre = nombre;
    }

    public Vehiculo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "nombre=" + nombre + '}';
    }
    
    
    
}
