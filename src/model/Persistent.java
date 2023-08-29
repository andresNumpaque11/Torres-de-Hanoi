package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Andres Numpaque
 */
public class Persistent {
    
    
    public static Map<String, Integer> leerNivelesDesdeArchivo(String archivo) {
        Map<String, Integer> niveles = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    String nombreNivel = partes[0].trim();
                    int numeroDiscos = Integer.parseInt(partes[1].trim());
                    niveles.put(nombreNivel, numeroDiscos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return niveles;
    }
}
    
    

