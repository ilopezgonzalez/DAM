/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prueba;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Prueba {

    public static void main(String[] args) {
        leerLineasPalabra();
    }

    public static void leerLineasPalabra() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la palabra que quieras buscar:");
        String palabra = input.nextLine().toLowerCase();

        ObjectMapper mapper = new ObjectMapper();
        boolean encontrado = false;

        try {
            JsonNode root = mapper.readTree(new File("equipos_liga_baloncesto.json"));

            if (root != null && root.isArray()) {
                for (JsonNode equipo : root) {
                    // Convertir el nodo a String JSON
                    String jsonEquipo = mapper.writerWithDefaultPrettyPrinter()
                                              .writeValueAsString(equipo);

                    // Dividir el bloque en líneas
                    String[] lineas = jsonEquipo.split("\n");

                    // Buscar la palabra en cada línea
                    for (String linea : lineas) {
                        if (linea.toLowerCase().contains(palabra)) {
                            System.out.println(linea);
                            encontrado = true;
                        }
                    }
                }

                if (!encontrado) {
                    System.err.println("La palabra buscada no se encuentra en el archivo.");
                }
            } else {
                System.err.println("Error: el archivo no contiene un array de equipos.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
