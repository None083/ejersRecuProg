/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejersrecuexamfinal;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author FX506
 */
public class Matrices {
    
    public static int[][] matrizNumerosUnicos(){
        
        Random aleatorio = new Random();
        int[][] matriz = new int[3][3];
        Set<Integer> set = new HashSet<>();
        int numeroGenerado;
        
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                do{
                    numeroGenerado = aleatorio.nextInt(20 - 10 + 1) + 10;
                } while(set.contains(numeroGenerado));
                set.add(numeroGenerado);
                matriz[i][j] = numeroGenerado;
            }
            
        }
        return matriz;
    }
    
}
