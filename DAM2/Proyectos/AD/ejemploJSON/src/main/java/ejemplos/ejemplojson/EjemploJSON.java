/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ejemplos.ejemplojson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author cic
 */
public class EjemploJSON {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileInputStream fis = new FileInputStream("palabras.json")) {
            JsonNode root = mapper.readTree(fis);
            JsonNode palabrasArray = root.get("palabras");
            if (palabrasArray != null && palabrasArray.isArray()) {
                for (JsonNode palabraNode : palabrasArray) {
                    JsonNode textoNode = palabraNode.get("texto");
                    if (textoNode != null) {
                        String palabra = textoNode.asText();
                        System.out.println("Palabra: " + palabra + " Longitud: " + palabra.length());
                    } else {
                        System.out.println("Error: El nodo 'texto' no existe en una de las palabras.");
                    }
                }
            } else {
                System.out.println("Error: El nodo 'palabras' no existe o no es un array.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
