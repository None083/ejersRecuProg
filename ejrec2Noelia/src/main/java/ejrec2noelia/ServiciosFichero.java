/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec2noelia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author noelia
 */
public class ServiciosFichero {
    
    public static Set<FichaDomino> leerFicheroTxt(String id) {
        Set<FichaDomino> fichasUnicas = new HashSet<>();
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(id), "UTF-8")) {

            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                
                tokens = linea.split("-");
                int ladoIzdo = Integer.parseInt(tokens[0].trim());
                int ladoDer = Integer.parseInt(tokens[1].trim());
                
                for (int i = 0; i < tokens[i].length(); i++) {
                    System.out.println(tokens[i]);
                }
                
                fichasUnicas.add(new FichaDomino(ladoIzdo, ladoDer));
                
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return fichasUnicas;
    }
    
}
