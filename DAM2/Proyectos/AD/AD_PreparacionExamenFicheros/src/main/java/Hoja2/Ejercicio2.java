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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    private static Scanner teclado = new Scanner(System.in);
    private static boolean encontrado;

    public static void main(String[] args) {
        boolean seguir = true;
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
                    leerBuscarPalabra(pedirPalabra(), cargarArchivoCompletoArrayList());
                    break;
                case 2:
                    leerBuscarPalabraNumLinea(pedirPalabra(), cargarArchivoCompletoArrayList());
                    break;
                case 3:
                    grabar(sustituirPalabra(pedirPalabra(), cargarArchivoCompletoArrayList()));
                    
                    break;
                case 4:
                    grabar(sustituirLinea(pedirLinea(), cargarArchivoCompletoArrayList()));
                    break;
                case 5:
                    grabar(eliminarLinea(pedirLinea(), cargarArchivoCompletoArrayList()));
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

    public static ArrayList<String> cargarArchivoCompletoArrayList() {
        ArrayList<String> lineas = new ArrayList();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public static String pedirPalabra() {
        System.out.printf("Introduce la palabra a buscar:");
        String palabra = teclado.nextLine();
        return palabra;
    }

    public static int pedirLinea() {
        System.out.println("Introduce el numero de linea:");
        int numLinea = Integer.parseInt(teclado.nextLine());
        return numLinea;
    }

    public static void leerBuscarPalabra(String palabra, ArrayList<String> lineas) {
        encontrado = false;
        for (String linea : lineas) {
            if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                System.out.println(linea);
            }
        }
    }

    public static void leerBuscarPalabraNumLinea(String palabra, ArrayList<String> lineas) {
        int contador = 0;
        encontrado = false;
        for (String linea : lineas) {
            contador++;
            if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                System.out.println(contador + ". " + linea.trim());
            }
        }
    }

    public static ArrayList<String> sustituirPalabra(String palabra, ArrayList<String> lineas) {
        String nuevaPalabra;
        ArrayList<String> nuevasLineas = new ArrayList();
        for (String linea : lineas) {
            if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                System.out.println("Palabra encontrada. Introduce la nueva:");
                nuevaPalabra = teclado.nextLine();
                linea = linea.replace(palabra, nuevaPalabra);
            }
            nuevasLineas.add(linea);

        }
        return nuevasLineas;
    }

    public static ArrayList<String> sustituirLinea(int numLinea, ArrayList<String> lineas) {
        int contador = 0;
        ArrayList<String> nuevasLineas = new ArrayList<>();
        for (String linea : lineas) {
            contador++;
            if (contador == numLinea) {
                System.out.println("Linea encontrada. Introduce el nuevo contenido de la linea.");
                linea = teclado.nextLine();
            }
            nuevasLineas.add(linea);
        }
        return nuevasLineas;
    }

    public static ArrayList<String> eliminarLinea(int numLinea, ArrayList<String> lineas) {
        int contador=0;
        ArrayList<String> nuevasLineas=new ArrayList<>();
        for (String linea : lineas) {
            contador++;
            if (contador==numLinea) {
                System.out.println("Linea encontrada y eliminada.");
            }else{
                nuevasLineas.add(linea);
            }
        }
        return nuevasLineas;
    }
    
    public static void grabar(ArrayList<String> lineas){
        System.out.println("Introduce el nombre del nuevo archivo");
        String archivo=teclado.nextLine();
        try (FileWriter fw=new FileWriter(archivo+".json")){
            fw.write(lineas.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
