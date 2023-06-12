/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4recnoelia;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


/**
 *
 * @author noelia
 */
public class ServiciosFicheros {
    
    public static Object leerJson(String json, Class clase) throws IOException{
        
        ObjectMapper mapeador = new ObjectMapper();

        return mapeador.readValue(json,clase);

    }
    
}
