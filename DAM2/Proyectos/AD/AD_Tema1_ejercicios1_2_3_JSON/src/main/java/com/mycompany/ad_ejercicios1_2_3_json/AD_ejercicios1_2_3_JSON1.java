/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios1_2_3_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class AD_ejercicios1_2_3_JSON1 {

    public static void main(String[] args) throws IOException {
        int control = 0;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                               Elige una de las siguientes opciones:
                               1. Leer Contenido1
                               2. Leer Contenido2
                               3. Reemplazar Texto
                               4. Modificar Linea
                               5. Eliminar Linea
                               0. Salir""");
            control = Integer.parseInt(input.nextLine());

            switch (control) {
                case 1:
                    leerFicheroCompleto();
                    break;

                case 2:
                    leerLineasPalabra();
                    break;

                case 3:
                    sustituirPalabra();
                    break;

                case 4:
                    sustituirTextoLinea();
                    break;
                case 5:
                    numeroLineaBorra();
                    break;

                default:
                    System.out.println("Saliendo");
            }

        } while (control != 0);
    }

    public static void leerFicheroCompleto() {
        ObjectMapper mapper = new ObjectMapper();
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json")) {
            JsonNode root = mapper.readTree(fis);
            if (root != null && root.isArray()) {
                for (JsonNode equipos : root) {
                    JsonNode idNode = equipos.get("id");
                    JsonNode codigoNode = equipos.get("codigo");
                    JsonNode equipoNode = equipos.get("nombre");
                    JsonNode localidadNode = equipos.get("localidad");
                    JsonNode num_jugadoresNode = equipos.get("num_jugadores");
                    if (idNode != null && codigoNode != null && equipoNode != null && localidadNode != null && num_jugadoresNode != null) {
                        String id = idNode.asText();
                        int codigo = codigoNode.asInt();
                        String equipo = equipoNode.asText();
                        String localidad = localidadNode.asText();
                        int num_jugadores = num_jugadoresNode.asInt();
                        System.out.println("ID: " + id + "\nCodigo equipo: " + codigo + "\nEquipo: " + equipo + "\nLocalidad: " + localidad + "\nNum. Jugadores: " + num_jugadores);
                        JsonNode jugadoresNode = equipos.get("jugadores");
                        if (jugadoresNode != null && jugadoresNode.isArray()) {
                            for (JsonNode jugador : jugadoresNode) {
                                String nombre = jugador.asText();
                                System.out.println("Nombre jugador: " + nombre);
                            }
                            System.out.println("");
                        } else {
                            System.err.println("Error: El nodo 'jugadores' no existe o no es un array.");
                        }
                    } else {
                        System.err.println("Error: Alguno de los nodos no existe en el archivo.");
                    }
                }
            } else {
                System.err.println("Error: No se encuentran datos.");
            }
        } catch (IOException e) {

        }
    }

    public static void leerLineasPalabra() throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la palabra que quieras buscar:");
        String palabra = input.nextLine().toLowerCase();
        ObjectMapper mapper = new ObjectMapper();
        boolean encontrado = false;
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json")) {
            ArrayNode equipos = (ArrayNode) mapper.readTree(fis);
            for (JsonNode equipo : equipos) {
                if (equipo.toString().toLowerCase().contains(palabra)) {
                    encontrado = true;
                    System.out.println(equipo.toPrettyString());
                }

            }
            if (!encontrado) {
                System.out.println("No se ha encontrado la palabra");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sustituirPalabra() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la palabra que quieras buscar:");
        String palabra = input.nextLine();
        System.out.println("Intrpoduce la plabra por la que la quieras sustituir:");
        String nuevaPalabra = input.nextLine();
        ObjectMapper mapper = new ObjectMapper();
        boolean encontrado = false;
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json");
                FileWriter fw = new FileWriter("equipos_liga_baloncesto2.json")) {
            ArrayNode equipos = (ArrayNode) mapper.readTree(fis);
            for (JsonNode equipo : equipos) {
                if (equipo.toString().contains(palabra)) {
                    encontrado = true;
                    String nuevoString = equipo.toPrettyString().replace(palabra, nuevaPalabra).concat("\n");
                    fw.write(nuevoString);
                } else {
                    fw.write(equipo.toPrettyString().concat("\n"));
                }
            }
            if (!encontrado) {
                System.out.println("No se ha encontrado la palabra");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sustituirTextoLinea() throws FileNotFoundException, IOException {
        ArrayList<String> contenido = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el numero de linea que quieres modificar");
        int numLinea = Integer.parseInt(input.nextLine());
        int contadorLineas = 0;
        String linea;
        StringBuilder sb = new StringBuilder();
        String nuevaLinea = "";
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"));) {
            boolean encontrado = false;
            while ((linea = br.readLine()) != null) {
                contadorLineas++;
                if (numLinea == contadorLineas) {
                    System.out.println("Linea encontrada");
                    encontrado = true;
                    System.out.println("Introduce el nuevo texto:");
                    linea = input.nextLine();
                }
                linea = linea.concat("\n");
                contenido.add(linea);

            }
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto2.json");) {
                    for (String line : contenido) {
                        fw.write(line);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void numeroLineaBorra() {
        ArrayList<String> contenido = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el numero de linea que quieres imprimir y borrar:");
        int numLinea = Integer.parseInt(input.nextLine());
        String linea;
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                linea = linea.concat("\n");
                contenido.add(linea);
            }
            if (contenido.size() >= numLinea) {
                System.out.println(contenido.get(numLinea));
                contenido.remove(numLinea);
                encontrado = true;
            } else {
                System.out.println("No se ha encontrado esa linea");
            }
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto2.json")) {
                    for (String line : contenido) {
                        fw.write(line);

                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }
}
