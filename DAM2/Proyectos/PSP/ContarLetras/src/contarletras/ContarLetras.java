/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contarletras;

import java.io.*;

public class ContarLetras {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java -jar Libreria.jar <letra> <fichero>");
            return;
        }

        String letra = args[0];
        String rutaFichero = args[1];
        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaFichero))) {
            int caracter;
            while ((caracter = lector.read()) != -1) {
                if ((char) caracter == letra.charAt(0)) {
                    contador++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el fichero: " + e.getMessage());
        }
        

        System.out.println(contador); // Esto se captura desde el proceso hijo
    }
}

