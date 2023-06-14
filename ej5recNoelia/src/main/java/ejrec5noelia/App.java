/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejrec5noelia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author noelia
 */
public class App {

    public static void menuApp() throws IOException {

        String opcion = "";
        Personaje p = leerJson("starwars.json");
        String color = "";

        try {
            do {

                opcion = JOptionPane.showInputDialog(null, """
                                                         --------------------------------------
                                                                    Escoge una opcion
                                                         --------------------------------------
                                                                1 - Cambiar color de pelo
                                                                2 - Cambiar color de ojos
                                                                3 - Mostrar personaje
                                                                4 - Guardar en nuevo json
                                                                0 - Salir
                                                         --------------------------------------
                                                         """);

                switch (opcion) {
                    case "1":
                        color = JOptionPane.showInputDialog(null,
                                "Escribe un color de pelo");
                        p.setColorPelo(color);
                        break;
                    case "2":
                        color = JOptionPane.showInputDialog(null,
                                "Escribe un color de ojos");
                        p.setColorOjos(color);
                        break;
                    case "3":
                        System.out.println(p);
                        break;
                    case "4":
                        escribirJson(p);
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

    private static Personaje leerJson(String json) throws JsonProcessingException, IOException {

        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        Personaje p = mapeador.readValue(new File(json),
                mapeador.getTypeFactory().constructType(Personaje.class));

        return p;

    }
    
    private static void escribirJson(Personaje p) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();

        mapeador.registerModule(new JavaTimeModule());

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapeador.writeValue(new File("personajeCambios.json"), p);
    }

}
