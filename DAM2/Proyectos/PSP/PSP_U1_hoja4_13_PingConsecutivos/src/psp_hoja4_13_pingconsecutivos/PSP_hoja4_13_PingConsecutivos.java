/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_hoja4_13_pingconsecutivos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author ASUS
 */
public class PSP_hoja4_13_PingConsecutivos {

    public static void main(String[] args) {

        // -------------------------------------------------
        // Comprobar que se han recibido los 3 argumentos
        // args[0] -> IP inicial
        // args[1] -> número de pings
        // args[2] -> nombre del fichero de salida
        // -------------------------------------------------
        if (args.length != 3) {
            System.err.println("Uso: java -jar PingsConsecutivos.jar <IP inicial> <número de pings> <fichero>");
            return;
        }

        String ipInicial = args[0];                 // IP de inicio
        int numPings = Integer.parseInt(args[1]);  // Cantidad de pings a realizar
        String nombreFichero = args[2];            // Fichero donde guardaremos resultados

        // -------------------------------------------------
        // Separar la parte fija de la IP (los tres primeros octetos)
        // y el último octeto que vamos a incrementar
        // -------------------------------------------------
        int ultimoPunto = ipInicial.lastIndexOf('.'); // posición del último punto en la IP
        if (ultimoPunto == -1) {                     // si no hay punto, IP inválida
            System.err.println("IP inicial no válida");
            return;
        }

        String baseIP = ipInicial.substring(0, ultimoPunto + 1); // "192.168.1."
        int ultimoOcteto = Integer.parseInt(ipInicial.substring(ultimoPunto + 1)); // "67" → 67

        // -------------------------------------------------
        // Abrimos el fichero para escribir resultados
        // -------------------------------------------------
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero, true))) {

            // -------------------------------------------------
            // Bucle que realiza los pings consecutivos
            // -------------------------------------------------
            for (int i = 0; i < numPings; i++) {
                int octetoActual = ultimoOcteto + i; // incrementar último octeto
                if (octetoActual > 255) {            // evitar IP inválida
                    System.err.println("Se excede el último octeto de la IP");
                    break;
                }

                String ipActual = baseIP + octetoActual; // IP completa actual
                System.out.println("Haciendo ping a: " + ipActual);

                // -------------------------------------------------
                // Construir comando ping para Windows
                // cmd /c ping <IP>
                // -------------------------------------------------
                String[] comando = {"cmd", "/c", "ping", ipActual};
                ProcessBuilder pb = new ProcessBuilder(comando);

                // Lanzar el proceso
                Process proceso = pb.start();

                // -------------------------------------------------
                // Leer la salida estándar del comando ping
                // Línea por línea y escribirla en pantalla y en fichero
                // -------------------------------------------------
                try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea); // mostrar en consola
                        pw.println(linea);         // guardar en fichero
                    }
                }

                // -------------------------------------------------
                // Esperar a que el proceso termine y mostrar su código de salida
                // -------------------------------------------------
                int resultado = proceso.waitFor();
                System.out.println("Proceso terminado con código: " + resultado);
                pw.println("Proceso terminado con código: " + resultado);
                pw.println("---------------------------------------------------");
            }

            System.out.println("Todos los pings realizados. Resultados guardados en " + nombreFichero);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}