/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejrec2noelia;

import java.util.Set;

/**
 *
 * @author noelia
 */
public class Pruebas {

    public static void main(String[] args) {
        
        Set<FichaDomino> fichasUnicas = ServiciosFichero.leerFicheroTxt("domino.txt");
        
        for (FichaDomino f : fichasUnicas) {
            System.out.println(f);
        }
        
    }
    
}
