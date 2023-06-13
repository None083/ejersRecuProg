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
        
        System.out.println("Número de fichas: " + fichasUnicas.size());
        
        System.out.println("------Domino completo------------");
        Set<FichaDomino> domino = FichaDomino.generarDominoCompleto();
        
        for (FichaDomino f : domino) {
            System.out.println(f);
        }
        System.out.println("Número de fichas: " + domino.size());
        
        // Escribimos txt con el domino completo
        ServiciosFichero.escribirTxt("dominoCompleto.txt", domino);
        
    }
    
}
