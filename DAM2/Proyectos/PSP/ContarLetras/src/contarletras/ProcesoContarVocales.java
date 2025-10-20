/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contarletras;

import java.io.*;

public class ProcesoContarVocales {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Uso: java contarletras.ProcesoContarVocales <fichero>");
            return;
        }

        String fichero = args[0];
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int sumatorio = 0;

        for (char vocal : vocales) {
            try {
                // Llama al JAR que está en la misma carpeta
                ProcessBuilder pb = new ProcessBuilder(
                        "java", "-jar", "src/contarletras/Libreria.jar", String.valueOf(vocal), fichero
                );

                Process proceso = pb.start();

                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea = lector.readLine();

                int contador = 0;
                if (linea != null) {
                    contador = Integer.parseInt(linea.trim());
                }

                proceso.waitFor();

                System.out.println("Vocal " + vocal + ": " + contador);
                sumatorio += contador;

            } catch (IOException e) {
                System.err.println("Error ejecutando el proceso para la vocal " + vocal + ": " + e.getMessage());
            } catch (InterruptedException ex) {
                System.err.println("El proceso fue interrumpido: " + ex.getMessage());
            }
        }

        System.out.println("Total de vocales: " + sumatorio);
    }
}
