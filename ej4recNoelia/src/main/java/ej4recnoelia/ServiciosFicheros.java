/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4recnoelia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author noelia
 */
public class ServiciosFicheros {
    
    public static void leerJson() throws IOException{
        
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<CasoPrueba> casoPrueba = mapeador.readValue(new File("caso1.json"),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, CasoPrueba.class));

        for (CasoPrueba caso : casoPrueba) {
            System.out.println(caso);
        } 
    }
    
}
