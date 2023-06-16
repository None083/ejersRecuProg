/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ejer1;

import java.util.List;

/**
 *
 * @author noelia
 */
public class Main {

    public static void main(String[] args) {
        
        List<Matricula> listaMat = Metodos.leerFicheroCsv("RegResEleSobMat.csv");
        
        for (Matricula m : listaMat) {
            System.out.println(m);
        }
        
        
        
    }
}
