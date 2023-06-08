/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package cursos;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author noelia
 */
public class Pruebas {

    public static void main(String[] args) throws IOException {
        
        List<ActFormativas> listaActividades = ServiciosFicheros.leerFicheroCsv("RegActForCep.csv");
        
        for (ActFormativas a : listaActividades) {
            System.out.println(a);
        }
        
        System.out.println("--------Lista ordenada por fecha de inicio y título-----------");
        
        listaActividades.stream()
                .sorted(Comparator.comparing(ActFormativas::getFecIni)
                        .thenComparing(ActFormativas::getTitulo))
                .forEach(a->System.out.println(a));
        
        // Escribir txt con sólo título y fecha fin
        // si finalizaron antes o durante marzo del 2020
        
        ServiciosFicheros.escrituraActividades("CursosAcabados.txt", listaActividades);
        
        // Creamos map con los centros y su numero de cursos
        
        Map<String, Integer> listaMap = ServiciosFicheros.mapNumeroCursos(listaActividades);
        
        System.out.println("--------------Map centros-cursos----------------");
        for (String c : listaMap.keySet()) {
            System.out.println(c + " tiene " + listaMap.get(c) + " cursos.");
        }
        
        // Escribimos Json
        ServiciosFicheros.escribirJson(listaMap, "centros.json");
        
        //Leemos Json
        ServiciosFicheros.leerJson();
        
        //Leemos txt
        System.out.println("-----------Leer txt---------------");
        ServiciosFicheros.leerTxt();
        
    }
}
