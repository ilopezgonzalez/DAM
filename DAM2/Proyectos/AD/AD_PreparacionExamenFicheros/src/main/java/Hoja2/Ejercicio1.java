/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    private static Scanner teclado = new Scanner(System.in);
    private static boolean encontrado;

    public static void main(String[] args) {
        boolean seguir=true;
        while (seguir) {
            System.out.println("""
                               Elige una de las siguiente opciones.
                               1. Leer contenido1.
                               2. Leer contenido2.
                               3. Remplazar texto.
                               4. Modificar linea.
                               5. Eliminar linea.
                               0. Salir
                               """);
            int opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    leerBuscarPalabra(pedirPalabra());
                    break;
                case 2:
                    leerBuscarPalabraNumLinea(pedirPalabra());
                    break;
                case 3:
                    sustituirPalabra(pedirPalabra());
                    break;
                case 4:
                    sustituirLinea();
                    break;
                case 5:
                    eliminarLinea();
                    break;
                case 0:
                    seguir=false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Debes introducir un numero correcto");  
                    break;
            }
        }
    }

    public static void leerArchivoCompleto() {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
        }
    }

    public static String pedirPalabra() {
        System.out.printf("Introduce la palabra a buscar:");
        String palabra = teclado.nextLine();
        return palabra;
    }

    public static void leerBuscarPalabra(String palabra) {
        String linea;
        encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                if (linea.contains(palabra)) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se han encontrado coincidencias");
            }
        } catch (Exception e) {
        }
    }

    public static void leerBuscarPalabraNumLinea(String palabra) {
        String linea;
        int contador = 0;
        encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                contador++;
                if (linea.contains(palabra)) {
                    System.out.println(contador + ". " + linea.trim());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se han encontrado coincidencias");
            }
        } catch (Exception e) {
        }
    }

    public static void sustituirPalabra(String palabra) {
        String linea;
        String nuevaLinea = "";
        System.out.println("Palabra encontrada. Introduce la palabra que la sustituira:");
        String nuevaPalabra = teclado.nextLine();
        encontrado = false;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                    linea = linea.replace(palabra, nuevaPalabra);
                    encontrado = true;
                }
                sb.append(linea).append(System.lineSeparator());
            }
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto.json")) {
                    fw.write(sb.toString());
                }
                System.out.println("Se ha sustituido la palabra");
            } else {
                System.out.println("No se ha encontrado la palabra");
            }

        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo. " + e.getStackTrace());

        }
    }

    public static void sustituirLinea() {
        int contadorLineas = 0;
        int lineaElegida;
        String linea;
        encontrado = false;
        boolean lineaEncontrada = true;
        System.out.println("Introduce un numero de linea para sustituir:");
        lineaElegida = Integer.parseInt(teclado.nextLine());
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                contadorLineas++;
                if (contadorLineas == lineaElegida) {
                    encontrado = true;
                    System.out.println("Linea encontrada. Introduce la nueva linea.");
                    linea = teclado.nextLine();
                }
                sb.append(linea).append(System.lineSeparator());
            }
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto.json")) {
                    fw.write(sb.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarLinea() {
        int contadorLineas = 0;
        int lineaElegida;
        String linea;
        encontrado = false;
        boolean lineaEncontrada = true;
        System.out.println("Introduce un numero de linea para eliminar:");
        lineaElegida = Integer.parseInt(teclado.nextLine());
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                contadorLineas++;
                if (contadorLineas == lineaElegida) {
                    encontrado = true;
                    System.out.println("Linea encontrada y borrada.");
                } else {
                    sb.append(linea).append(System.lineSeparator());
                }
            }
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto.json")) {
                    fw.write(sb.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
