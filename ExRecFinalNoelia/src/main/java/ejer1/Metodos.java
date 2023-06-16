/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author noelia
 */
public class Metodos {

    public static List<Matricula> leerFicheroCsv(String id) {
        List<Matricula> listaMatriculas = new ArrayList<>();
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(id), "US-ASCII")) {

            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(",");

                //DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm:ss");
                listaMatriculas.add(new Matricula(tokens[0], (tokens[1]),
                        Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                        Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaMatriculas;
    }

    public static Map<String, Long> numeroAlumnosPorAsignatura(List<Matricula> listaMat) {
        Map<String, Long> listaAsig = new TreeMap<>();

        //boolean anyMatch = listaMat.stream().anyMatch(m->(m.getANAP()==1 && m.getANAP()==2 && m.getANAP()==3);
        

        //listaAsig.put("ANAP", numAnap1);

        return listaAsig;
    }

}
