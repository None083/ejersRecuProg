/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 *
 * @author noelia
 */
public class ArrayBidimensional {

    public static int[][] matrizAleatoria() {

        Random aleatorio = new Random();
        int[][] matriz = new int[6][6];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                try {
                    int numAleatorio = aleatorio.nextInt(100) + 1;
                    int aleatorio36 = aleatorio.nextInt(6 - 3 + 1) + 3;
                    int aleatorio13 = aleatorio.nextInt(3) + 1;

                    if (numAleatorio % 2 == 0 || numAleatorio >= 50) {

                        matriz[aleatorio36][aleatorio36] = numAleatorio;

                    } else if (numAleatorio % 2 == 0 || numAleatorio < 50) {

                        matriz[aleatorio36][aleatorio13] = numAleatorio;

                    } else if (numAleatorio % 2 == 1 || numAleatorio >= 50) {

                        matriz[aleatorio13][aleatorio36] = numAleatorio;

                    } else {

                        matriz[aleatorio13][aleatorio13] = numAleatorio;

                    }
                } catch (ArrayIndexOutOfBoundsException aioe) {

                }

            }
        }
        return matriz;
    }

    public static void matrizToTxt(String id, int[][] matriz) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(id))) {

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    
                    flujo.write(matriz[i][j] + " ");

                }
                flujo.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
