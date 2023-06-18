/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import controladores.ObraJpaController;
import controladores.PuntuacionJpaController;
import controladores.UsuarioJpaController;
import entidades.Obra;
import entidades.Puntuacion;
import entidades.Usuario;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author FX506
 */
public class Pruebas {
    
    private static PuntuacionJpaController pjc = new PuntuacionJpaController(Persistence.createEntityManagerFactory("artebd"));
    private static ObraJpaController ojc = new ObraJpaController(Persistence.createEntityManagerFactory("artebd"));
    private static UsuarioJpaController ujc = new UsuarioJpaController(Persistence.createEntityManagerFactory("artebd"));
    
    public static void main(String[] args) {
        
        List<Puntuacion> listaP = pjc.findPuntuacionEntities();

        for (Puntuacion p : listaP) {
            System.out.println(p);
        }
        
        System.out.println("-----------------------------------");
        List<Obra> listaO = ojc.findObraEntities();

        for (Obra o : listaO) {
            System.out.println(o);
        }
        
        System.out.println("----------------------------------------");
        List<Usuario> listaU = ujc.findUsuarioEntities();
        
        for (Usuario u : listaU) {
            System.out.println(u);
        }
        
    }
    
}
