/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4recnoelia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class App {

    public static void menuApp() throws IOException {

        String opcion = "";
        List<Elefante> listaElefantes = new ArrayList<>();
        CasoPrueba caso = new CasoPrueba();

        try {
            do {

                opcion = JOptionPane.showInputDialog(null, """
                                                         -------------------------------------
                                                                    Escoge un caso
                                                         -------------------------------------
                                                                    1 - Caso 1
                                                                    2 - Caso 2
                                                                    3 - Caso 3
                                                                    0 - Salir
                                                         -------------------------------------
                                                         """);

                switch (opcion) {
                    case "1":
                        mostrarElefantes("caso1.json", listaElefantes, caso, opcion);
                        break;
                    case "2":
                        mostrarElefantes("caso2.json", listaElefantes, caso, opcion);
                        break;
                    case "3":
                        mostrarElefantes("caso3.json", listaElefantes, caso, opcion);
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

    private static void mostrarElefantes(String json, List<Elefante> listaElefantes, CasoPrueba caso, String opcion) throws IOException {
        caso = leerJson(json);
        System.out.println("Caso " + opcion);
        System.out.println("Peso soportable: " + caso.getPeso());
        System.out.println("Elefantes:");
        caso.getListaElefantes().forEach(System.out::println);

        System.out.println("---Elefantes que se han valanceado---");
        listaElefantes = elefantesColumpiables(caso);
        for (Elefante e : listaElefantes) {
            System.out.println(e);
        }
        if (listaElefantes.size() == 0) {
            System.out.println("Ninguno");
        }
        System.out.println("-------------------------------------");
    }

    private static List<Elefante> elefantesColumpiables(CasoPrueba caso) {
        List<Elefante> lista = new ArrayList<>();
        int sumaPeso = 0;
        for (Elefante e : caso.getListaElefantes()) {
            if (e.getPeso() + sumaPeso <= caso.getPeso()) {
                sumaPeso += e.getPeso();
                lista.add(e);
            }
        }

        return lista;
    }

    private static CasoPrueba leerJson(String json) throws JsonProcessingException, IOException {

        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        CasoPrueba casos = mapeador.readValue(new File(json),
                mapeador.getTypeFactory().constructType(CasoPrueba.class));

        return casos;

    }

}
