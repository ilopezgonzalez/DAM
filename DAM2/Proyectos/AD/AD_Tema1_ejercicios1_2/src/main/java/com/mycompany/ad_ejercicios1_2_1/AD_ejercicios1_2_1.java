/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios1_2_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class AD_ejercicios1_2_1 {

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

    /*Metodo que lee todo JSON por lineas y lo imprime linea a linea*/
    public static void leerFicheroCompleto() {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"));) {

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }

    }

    /*Metodo que lee JSON por lineas y busca una palabra, imprime las lineas donde aparece la palabra*/
    public static void leerLineasPalabra() {
        Scanner input = new Scanner(System.in);
        String linea;
        System.out.println("Introduce la palabra que quieras buscar:");
        String palabra = input.nextLine();
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"));) {
            while ((linea = br.readLine()) != null) {
                if (linea.contains(palabra)) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se ha enocntrado ninguna coincidencia");
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    /*Metodo que lee JSON linea a linea, busca una palabra y si la encuentra
    pide otra que la sustituye, despues va creando String (StringBuilder) con todas las lineas
    y un separador \n, para terminar FileWriter escribe todo el String en el archivo.
     */
    public static void sustituirPalabra() {
        Scanner input = new Scanner(System.in);
        String lectura;
        boolean encontrado = false;
        File f = new File("equipos_liga_baloncesto.json");
        System.out.println("Introduce la palabra que quieras buscar:");
        String palabraBuscada = input.nextLine();
        System.out.println("Introduce la palabra por la que la quieras sustituir:");
        String nuevaPalabra = input.nextLine();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            while ((lectura = br.readLine()) != null) {
                if (lectura.toLowerCase().contains(palabraBuscada.toLowerCase())) {
                    encontrado = true;
                    lectura = lectura.replace(palabraBuscada, nuevaPalabra);
                }
                sb.append(lectura).append(System.lineSeparator());
            }
            
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto2.json")) {
                    fw.write(sb.toString());
                }
                System.out.println("Se han sustituido las palabras");
            } else {
                System.out.println("Palabra no encontrada");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Metodo que lee JSON linea a linea, busca un numero de linea y la sustituye por el texto
    introducido, va creando un string (StringBuilder)con las lineas cuando encuentra la que busca
    tambien la mete en el StringBuilder, acaba Filewriter escribiendo todo el String en el archivo
     */
    public static void sustituirTextoLinea() throws FileNotFoundException, IOException {
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
                sb.append(linea).append(System.lineSeparator());

            }
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto2.json");) {
                    fw.write(sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*Metodo que lee JSON linea a linea, busca un numero de linea y la imprime, como queremos borrar esta,
    las que no coinciden las va metiendo en un string (StringBuilder) asi crea un String sin la linea que 
    buscamos, acaba Filewriter escribiendo todo el String en el archivo
     */
    public static void numeroLineaBorra() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el numero de linea que quieres imprimir y borrar:");
        int numLinea = Integer.parseInt(input.nextLine());
        String linea;
        StringBuilder sb = new StringBuilder();
        int contadorLineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"))) {
            boolean encontrado = false;
            while ((linea = br.readLine()) != null) {
                contadorLineas++;
                if (numLinea == contadorLineas) {
                    System.out.println("Linea encontrada");
                    encontrado = true;
                    System.out.println(linea);
                    System.out.println("Linea borrada");
                } else {
                    sb.append(linea).append(System.lineSeparator());

                }
            }
            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto2.json")) {
                    fw.write(sb.toString());
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }
}
