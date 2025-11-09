/*
 * Programa: ContarLetras
 * Descripción:
 *   Este programa recibe dos argumentos por línea de comandos:
 *     1. Una letra concreta.
 *     2. La ruta de un fichero de texto.
 *
 *   Recorre todo el fichero carácter por carácter y cuenta cuántas veces aparece
 *   la letra indicada. Al final, muestra el número total por pantalla.
 */

package contarletras;

import java.io.*;

public class ContarLetras {

    public static void main(String[] args) {
        // Comprobamos que el usuario haya pasado exactamente dos argumentos
        if (args.length != 2) {
            System.out.println("Uso: java -jar Libreria.jar <letra> <fichero>");
            return;  // Si no hay dos argumentos, se muestra el mensaje y el programa termina
        }
        
        /*
        * Los argumentos que se pasan a este programa se pasan desde el que ejecuta este
        * La ruta del archivo a leer se mete como argumento en la configuracion del segundo programa
        * y este lo recibe desde el programa padre.
        */
        String letra = args[0];       // Primer argumento: la letra que queremos contar
        String rutaFichero = args[1]; // Segundo argumento: la ruta del fichero a analizar
        int contador = 0;             // Variable para contar cuántas veces aparece la letra

        // Bloque try-with-resources: abre el fichero y garantiza que se cierre automáticamente
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaFichero))) {
            int caracter;  // Variable temporal para guardar cada carácter leído del fichero

            // Se lee el fichero carácter a carácter hasta llegar al final (-1)
            while ((caracter = lector.read()) != -1) {
                // Comprobamos si el carácter leído coincide con la letra que buscamos
                if ((char) caracter == letra.charAt(0)) {
                    contador++;  // Si coincide, aumentamos el contador
                }
            }
        } catch (IOException e) {
            // Si ocurre un error al abrir o leer el fichero, se muestra un mensaje de error
            System.err.println("Error leyendo el fichero: " + e.getMessage());
        }

        // Imprimimos el resultado final (número de apariciones)
        // Este valor será recogido por otro proceso si se ejecuta desde otro programa
        System.out.println(contador);
    }
}
