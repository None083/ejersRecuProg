/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ej4recnoelia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author noelia
 */
public class Pruebas {

    public static void main(String[] args) throws IOException {
        
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        CasoPrueba casos = mapeador.readValue(new File("caso1.json"),
                    mapeador.getTypeFactory().constructType(CasoPrueba.class));
        
        
        
    }
}
