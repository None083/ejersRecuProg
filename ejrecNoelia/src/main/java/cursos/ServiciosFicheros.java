/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cursos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author noelia
 */
public class ServiciosFicheros {

    public static List<ActFormativas> leerFicheroCsv(String id) {
        List<ActFormativas> listaActividades = new ArrayList<>();
        String linea;
        String[] tokens;

        try ( Scanner datosFichero = new Scanner(new File(id), "UTF-8")) {

            for (int i = 0; i < 5; i++) {
                datosFichero.nextLine();
            }

            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(";");

                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                listaActividades.add(new ActFormativas(tokens[0], tokens[1], tokens[2],
                        tokens[3], tokens[4], LocalDate.parse(tokens[5], formatters),
                        LocalDate.parse(tokens[6], formatters), tokens[7]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaActividades;
    }

    public static void escrituraActividades(String id, List<ActFormativas> lista) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(id))) {
            for (ActFormativas a : lista) {
                if (a.getFecFin().isBefore(LocalDate.of(2020, 04, 1))) {
                    flujo.write(a.getTitulo() + ";" + a.getFecFin());
                    flujo.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Map<String, Integer> mapNumeroCursos(List<ActFormativas> lista) {
        Map<String, Integer> listaMap = new HashMap<>();

        List<String> listaCentros = lista.stream()
                .map(c -> c.getCentro())
                .distinct()
                .toList();

        for (String c : listaCentros) {

            int contador = (int) lista.stream()
                    .filter(a -> a.getCentro().equals(c))
                    .count();
            listaMap.put(c, contador);
        }

        return listaMap;
    }

    public static void escribirJson(Map<String, Integer> listaMap, String id) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();

        mapeador.registerModule(new JavaTimeModule());

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapeador.writeValue(new File(id), listaMap);
    }

    public static void leerJson() throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        Map<String, Integer> listaMap = mapeador.readValue(new File("centros.json"),
                mapeador.getTypeFactory().constructMapType(HashMap.class, String.class, Integer.class));

        System.out.println("---- Leer Json ----");
        for (Map.Entry<String, Integer> entry : listaMap.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key + " " + val);
        }
    }
    
    public static void leerTxt(){
        List<String> lineas=new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get("CursosAcabados.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        for (String linea : lineas) {
            System.out.println(linea);
        }
    }

}
