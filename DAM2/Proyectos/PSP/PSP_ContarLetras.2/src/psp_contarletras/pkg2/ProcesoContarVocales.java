/*
 * Programa: ProcesoContarVocales
 * Descripción:
 *   Este programa ejecuta otro programa Java (un .jar) que cuenta cuántas veces aparece
 *   una letra específica en un fichero de texto. 
 *   En este caso, llama al programa externo cinco veces —una por cada vocal (a, e, i, o, u)—,
 *   captura la salida de cada ejecución (el número de veces que aparece la vocal),
 *   muestra los resultados y calcula el total de vocales.
 */

package psp_contarletras.pkg2;

import java.io.*;

public class ProcesoContarVocales {

    public static void main(String[] args) {

        // Comprobamos que se haya pasado un argumento (la ruta del fichero a analizar)
        if (args.length != 1) {
            System.out.println("Uso: java contarletras.ProcesoContarVocales <fichero>");
            return; // Si no hay argumento, el programa termina
        }

        String fichero = args[0];  // Guardamos la ruta del fichero
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};  // Array con las vocales a analizar
        int sumatorio = 0;  // Acumulará el total de todas las vocales

        // Recorremos cada vocal
        for (char vocal : vocales) {
            try {
                // Preparamos el comando para ejecutar el otro programa (el .jar)
                // Sintaxis: java -jar <ruta_jar> <vocal> <fichero>
                ProcessBuilder pb = new ProcessBuilder(
                        "java", "-jar",
                        // Ruta donde se encuentra el jar creado por el otro programa
                        // En el ordenador de clase es D:\\Users\\damt209\\Repo\\DAM\\DAM2\\Proyectos\\PSP\\ContarLetras\\dist\\PSP_ContarLetras.jar
                        "C:\\Users\\ASUS\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\PSP\\ContarLetras\\dist\\PSP_ContarLetras.1.jar",
                        String.valueOf(vocal),  // Convertimos la vocal (char) a String
                        fichero                 // Añadimos el nombre del fichero como argumento
                );

                // Iniciamos el proceso (ejecuta el otro programa)
                Process proceso = pb.start();

                // Leemos la salida estándar del proceso (lo que imprime el otro programa)
                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

                // Leemos una línea de salida (el número de veces que aparece la vocal)
                String linea = lector.readLine();

                int contador = 0;
                // Si el programa devolvió algo, lo convertimos a número entero
                if (linea != null) {
                    contador = Integer.parseInt(linea.trim());
                }

                // Esperamos a que el proceso termine antes de continuar
                proceso.waitFor();

                // Mostramos el resultado individual por vocal
                System.out.println("Vocal " + vocal + ": " + contador);

                // Acumulamos el total
                sumatorio += contador;

            } catch (IOException e) {
                // Si ocurre un error al ejecutar el proceso o leer su salida
                System.err.println("Error ejecutando el proceso para la vocal " + vocal + ": " + e.getMessage());
            } catch (InterruptedException ex) {
                // Si el proceso hijo se interrumpe
                System.err.println("El proceso fue interrumpido: " + ex.getMessage());
            }
        }

        // Al finalizar el bucle, mostramos el total de vocales encontradas
        System.out.println("Total de vocales: " + sumatorio);
    }
}
