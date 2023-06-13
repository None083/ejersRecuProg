/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec3noelia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class Aplicacion {

    static private String id = "";

    public static void menuApp() {

        String opcion = "";
        int[][] matriz;
        int[][] matrizInvert;
        int[][] matrizFilasOrden;

        try {
            do {

                opcion = JOptionPane.showInputDialog(null, """
                                                         ------------------------------------------
                                                                    Escoge una opción
                                                         ------------------------------------------
                                                            1 - Crear matriz desde txt
                                                            2 - Invertir matriz y mostrar
                                                            3 - Invertir matriz y guardar en txt
                                                            4 - Crear matriz desde txt ordenada
                                                            0 - Salir
                                                         ------------------------------------------
                                                         """);

                switch (opcion) {
                    case "1":
                        matriz = leerFicheroTxt("matrizP.txt");

                        System.out.println("-------Crear matriz desde txt---------");
                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[i].length; j++) {
                                System.out.print(matriz[i][j] + " ");
                            }
                            System.out.println("");
                        }
                        break;
                    case "2":
                        matriz = leerFicheroTxt("matrizP.txt");
                        matrizInvert = invertirMatriz(matriz);

                        System.out.println("-------Invertir matriz y mostrar---------");
                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[i].length; j++) {
                                System.out.print(matrizInvert[i][j] + " ");
                            }
                            System.out.println("");
                        }
                        break;
                    case "3":
                        matriz = leerFicheroTxt("matrizP.txt");
                        matrizInvert = Aplicacion.invertirMatriz(matriz);
                        escribirTxt(matrizInvert);
                        JOptionPane.showMessageDialog(null,
                                "Invertir matriz con nombre \"" + id + "\" y guardar en txt realizado con éxito");
                        break;
                    case "4":
                        matrizFilasOrden = leerTxtMenorMayor("matrizP.txt");

                        System.out.println("---------Crear matriz desde txt ordenada---------");

                        for (int i = 0; i < matrizFilasOrden.length; i++) {
                            for (int j = 0; j < matrizFilasOrden[i].length; j++) {
                                System.out.print(matrizFilasOrden[i][j] + " ");
                            }
                            System.out.println("");
                        }
                        break;
                    case "0":
                        JOptionPane.showMessageDialog(null, "Hasta luegui <3");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }

            } while (!opcion.equals("0"));

        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "El programa se cerró inesperadamente");
        }
    }

    private static int[][] leerFicheroTxt(String id) {
        int[][] matriz = new int[3][7];
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(id), "UTF-8")) {
            int fila = 0;
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(",");
                for (int j = 0; j < tokens.length; j++) {
                    matriz[fila][j] = Integer.parseInt(tokens[j]);
                }
                fila++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return matriz;
    }

    private static int[][] invertirMatriz(int[][] matriz) {
        int[][] matrizInvert = new int[matriz.length][matriz[0].length];

        for (int i = matriz.length - 1; i >= 0; i--) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizInvert[matrizInvert.length - i - 1][j] = matriz[i][j];
            }
        }

        return matrizInvert;
    }

    private static void escribirTxt(int[][] matriz) {

        id = JOptionPane.showInputDialog("Introduce el nombre del fichero");

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(id + ".txt"))) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    flujo.write(Integer.toString(matriz[i][j]) + " ");
                }
                flujo.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[][] leerTxtMenorMayor(String id) {
        int[][] matriz = new int[3][7];
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(id), "UTF-8")) {
            int fila = 0;
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(",");
                int[] tokensInt = new int[tokens.length];

                for (int i = 0; i < tokens.length; i++) {
                    tokensInt[i] = Integer.parseInt(tokens[i]);
                }

                Arrays.sort(tokensInt);
                for (int j = 0; j < tokensInt.length; j++) {
                    matriz[fila][j] = tokensInt[j];
                }
                fila++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return matriz;
    }

}
