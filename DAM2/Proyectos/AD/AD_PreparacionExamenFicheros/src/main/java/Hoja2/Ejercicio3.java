/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja2;

import static Hoja2.Ejercicio2.cargarArchivoCompletoArrayList;
import static Hoja2.Ejercicio2.eliminarLinea;
import static Hoja2.Ejercicio2.grabar;
import static Hoja2.Ejercicio2.leerBuscarPalabra;
import static Hoja2.Ejercicio2.leerBuscarPalabraNumLinea;
import static Hoja2.Ejercicio2.pedirLinea;
import static Hoja2.Ejercicio2.pedirPalabra;
import static Hoja2.Ejercicio2.sustituirLinea;
import static Hoja2.Ejercicio2.sustituirPalabra;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio3 {

    private static Scanner teclado = new Scanner(System.in);
    private static boolean encontrado;
    private static int opcion;

    public static void main(String[] args) {

        boolean seguir = true;
        while (seguir) {
            System.out.printf("""
                               Elige una de las siguiente opciones.
                               1. Leer contenido1.
                               2. Leer contenido2.
                               3. Remplazar texto.
                               4. Modificar linea.
                               5. Eliminar linea.
                               0. Salir
                               Opcion:
                               """);
            try {
                opcion = Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un numero valido");
                continue;
            }

            switch (opcion) {
                case 1:
                    leerLineasPalabra(preguntarPalabra());
                    break;
                case 2:
                    leerLineasPalabraNumero(preguntarPalabra());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    seguir = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Debes introducir un numero correcto");
                    break;
            }
        }
    }

    public static void leerJsonCompleto() {
        ObjectMapper mapper = new ObjectMapper();
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json")) {
            JsonNode raiz = mapper.readTree(fis);
            if (raiz != null && raiz.isArray()) {
                for (JsonNode equipos : raiz) {
                    String id = equipos.get("id").asText();
                    int codigo = equipos.get("codigo").asInt();
                    String nombre = equipos.get("nombre").asText();
                    String localidad = equipos.get("localidad").asText();
                    int num_jugadores = equipos.get("num_jugadores").asInt();
                    JsonNode jugadores = equipos.get("jugadores");
                    System.out.println("----EQUIPO----");
                    System.out.println("Id: " + id);
                    System.out.println("Codigo: " + codigo);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Localidad: " + localidad);
                    System.out.println("Numero de jugadores: " + num_jugadores);
                    if (jugadores != null && jugadores.isArray()) {
                        for (JsonNode jugador : jugadores) {
                            String nombreJugador = jugador.asText();
                            System.out.println("Nombre: " + nombreJugador);
                        }
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String preguntarPalabra() {
        System.out.println("Introduce la palabra que quieras buscar:");
        String palabra = teclado.nextLine().trim();
        return palabra;
    }
    
    public static String preguntarNuevaPalabra(){
        System.out.println("Introduce la palabra por la que la quieres sustituir:");
        String nuevaPalabra=teclado.nextLine().trim();
        return nuevaPalabra;
    }

    public static void leerLineasPalabra(String palabra) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json")) {
            JsonNode root = mapper.readTree(fis);
            if (root != null && root.isArray()) {
                for (JsonNode equipo : root) {
                    if (equipo.toString().toLowerCase().contains(palabra)) {
                        System.out.println(equipo.toPrettyString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void leerLineasPalabraNumero(String palabra) {
        int contador=0;
        ObjectMapper mapper = new ObjectMapper();
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json")) {
            JsonNode root = mapper.readTree(fis);
            if (root != null && root.isArray()) {
                for (JsonNode equipo : root) {
                    contador++;
                    if (equipo.toString().toLowerCase().contains(palabra)) {
                        System.out.println(contador+". "+equipo.toPrettyString());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void sustituirPalabras(String palabra, String nuevaPalabra) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json");
                FileWriter fw=new FileWriter("nuevo_equipos_liga_baloncesto.json")) {
            JsonNode root = mapper.readTree(fis);
            if (root != null && root.isArray()) {
                for (JsonNode equipo : root) {
                    if (equipo.toString().toLowerCase().contains(palabra)) {
                        encontrado=true;
                        String nuevoString=equipo.toString().replace(palabra, nuevaPalabra).concat("\n");
                        fw.write(nuevoString);
                    }else{
                    fw.write(equipo.toPrettyString().concat("\n"));
                    }
                }
                if (!encontrado) {
                    System.out.println("No se ha encontrado la palabra buscada");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     

}
