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
                        CasoPrueba caso = leerJson("caso1.json");
                        
                        System.out.println("Peso soportable: " + caso.getPeso());
                        System.out.println("Elefantes:");
                        caso.getListaElefantes().forEach(System.out::println);
                        
                        break;
                    case "2":
                        
                        break;
                    case "3":
                        
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
    
    private static List<Elefante> elefantesColumpiables(CasoPrueba caso) {
        List<Elefante> lista = new ArrayList<>();
        int sumaPeso = 0;
        
        if (caso.getPeso() + sumaPeso <= caso.getPeso()) {
            lista.add(new Elefante(nombre, sumaPeso));
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
