/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejersrecuexamfinal;

/**
 *
 * @author FX506
 */
public class Pruebas {

    public static void main(String[] args) {

//        String[][] matriz = CsvToMatriz.guardarCsvMatriz("RegActForCep.csv");
//        
//        System.out.println("Csv a matriz de String");
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j]);
//            }
//            System.out.println("");
//        }
        int[][] matriz = Matrices.matrizNumerosUnicos();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
