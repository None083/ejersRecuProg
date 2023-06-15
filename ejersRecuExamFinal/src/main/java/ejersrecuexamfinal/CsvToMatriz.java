/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejersrecuexamfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author FX506
 */
public class CsvToMatriz {

    public static String[][] guardarCsvMatriz(String id) {

        try ( Scanner datosFichero = new Scanner(new File(id), "UTF-8")) {
            int fila = 0;
            String linea = datosFichero.nextLine();
            String[][] matriz = new String[395][8];

            for (int i = 0; i < 5; i++) {
                datosFichero.nextLine();
            }

            while (datosFichero.hasNextLine()) {
                matriz[fila] = linea.split(";");
                fila++;
                linea = datosFichero.nextLine();
            }
            return matriz;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static ActFormativas[][] guardarCsvMatrizClase(String id) {

        try ( Scanner datosFichero = new Scanner(new File(id), "UTF-8")) {
            int fila = 0;
            String linea = datosFichero.nextLine();
            ActFormativas[][] matriz = new ActFormativas[395][8];
            String[] tokens;

            for (int i = 0; i < 5; i++) {
                datosFichero.nextLine();
            }

            while (datosFichero.hasNextLine()) {
                tokens = linea.split(";");
                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                for (int j = 0; j < tokens.length; j++) {
                    matriz[fila][j] = new ActFormativas(tokens[0], tokens[1], tokens[2],
                        tokens[3], tokens[4], LocalDate.parse(tokens[5], formatters),
                        LocalDate.parse(tokens[6], formatters), tokens[7]);
                }

                fila++;
                linea = datosFichero.nextLine();
            }
            return matriz;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
