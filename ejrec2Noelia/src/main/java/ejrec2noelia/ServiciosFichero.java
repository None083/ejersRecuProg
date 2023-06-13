/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec2noelia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            try {
                while (datosFichero.hasNextLine()) {
                    linea = datosFichero.nextLine();

                    tokens = linea.split("-");
                    int ladoIzdo = Integer.parseInt(tokens[0].trim());
                    int ladoDer = Integer.parseInt(tokens[1].trim());
                    if (ladoIzdo >= 7 || ladoDer >= 7) {
                        datosFichero.nextLine();
                    } else {
                        fichasUnicas.add(new FichaDomino(ladoIzdo, ladoDer));
                    }
                }
            } catch (NumberFormatException nfe) {
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return fichasUnicas;
    }
    
    public static void escribirTxt(String id, Set<FichaDomino> domino){
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(id))) {
            for (FichaDomino f : domino) {
                flujo.write(f.toString());
                flujo.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
