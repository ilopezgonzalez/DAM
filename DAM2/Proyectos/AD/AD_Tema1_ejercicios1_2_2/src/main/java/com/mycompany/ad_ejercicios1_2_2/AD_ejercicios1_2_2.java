/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios1_2_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class AD_ejercicios1_2_2 {

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
        ArrayList<String> contenido = new ArrayList<>();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"));) {

            while ((linea = br.readLine()) != null) {
                contenido.add(linea);
            }

            for (String line : contenido) {
                System.out.println(line.toString());
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }

    }

    public static void leerLineasPalabra() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> contenido = new ArrayList<>();
        String linea;
        System.out.println("Introduce la palabra que quieras buscar:");
        String palabra = input.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader("equipos_liga_baloncesto.json"));) {

            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                    contenido.add(linea);
                }
            }

            for (String line : contenido) {
                System.out.println(line.toString());
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }

    }

    public static void sustituirPalabra() {
        ArrayList<String> contendio = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        try {
            String lectura;
            boolean encontrado = false;
            File f = new File("equipos_liga_baloncesto.json");
            System.out.println("Introduce la palabra que quieras buscar:");
            String palabraBuscada = input.nextLine();
            System.out.println("Introduce la palabra por la que la quieras sustituir:");
            String nuevaPalabra = input.nextLine();
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                while ((lectura = br.readLine()) != null) {
                    if (lectura.contains(palabraBuscada)) {
                        System.out.println("Palabra encontrada");
                        encontrado = true;
                        lectura = lectura.replace(palabraBuscada, nuevaPalabra);
                    }
                    lectura = lectura.concat("\n");
                    contendio.add(lectura);

                }
            }

            if (encontrado) {
                try (FileWriter fw = new FileWriter("equipos_liga_baloncesto2.json")) {
                    for (String line : contendio) {
                        fw.write(line);
                    }
                }
                System.out.println("Se han sustituido las palabras");
            } else {
                System.out.println("Palabra no encontrada");
            }

        } catch (Exception e) {
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
                linea=linea.concat("\n");
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
