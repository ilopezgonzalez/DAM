package psp_u4_hoja1_ejercicio2_clientehttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * ============================================================
 * CLIENTE HTTP BÁSICO
 * ============================================================
 *
 * ¿Qué hace este cliente?
 *
 * 1️⃣ Se conecta al servidor (localhost:8080)
 * 2️⃣ Pide al usuario:
 *      - Nombre
 *      - Ruta
 * 3️⃣ Envía una petición HTTP válida
 * 4️⃣ Incluye cabecera personalizada:
 *      X-Cliente-Nombre
 * 5️⃣ Lee la respuesta completa del servidor
 * 6️⃣ Muestra cabeceras y cuerpo por pantalla
 *
 * IMPORTANTE PARA EXAMEN:
 * → El cliente NO necesita hilos.
 * → La petición HTTP debe terminar con una línea vacía.
 */

public class PSP_U4_hoja1_ejercicio2_ClienteHTTP {

    // Dirección del servidor
    private static final String SERVER = "localhost";

    // Puerto del servidor
    private static final int PUERTO = 8080;

    public static void main(String[] args) {

        /*
         * Socket:
         * Se conecta al servidor en la dirección y puerto indicados.
         */
        try (
            Socket cliente = new Socket(SERVER, PUERTO);

            /*
             * PrintWriter:
             * Se usa para enviar texto al servidor.
             */
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);

            /*
             * BufferedReader:
             * Se usa para leer la respuesta del servidor.
             */
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            /*
             * Scanner:
             * Permite leer datos del teclado.
             */
            Scanner teclado = new Scanner(System.in)
        ) {

            /*
             * ============================================================
             * 1️⃣ PEDIR DATOS AL USUARIO
             * ============================================================
             */

            System.out.print("Introduce tu nombre: ");
            String nombre = teclado.nextLine();

            System.out.println("1. HTML bienvenida (/)");
            System.out.println("2. Hora actual (/hora)");
            System.out.println("3. Otra ruta (404)");
            System.out.print("Opción: ");

            int opcion = Integer.parseInt(teclado.nextLine());

            /*
             * Según la opción elegida,
             * se define la ruta que enviaremos al servidor.
             */
            String ruta;

            switch (opcion) {
                case 1:
                    ruta = "/";
                    break;
                case 2:
                    ruta = "/hora";
                    break;
                default:
                    ruta = "/otra";
                    break;
            }

            /*
             * ============================================================
             * 2️⃣ ENVIAR PETICIÓN HTTP
             * ============================================================
             *
             * FORMATO CORRECTO:
             *
             * GET /ruta HTTP/1.1
             * Host: localhost
             * X-Cliente-Nombre: <nombre>
             *
             * (línea vacía obligatoria)
             */

            pw.println("GET " + ruta + " HTTP/1.1");
            pw.println("Host: " + SERVER);
            pw.println("X-Cliente-Nombre: <" + nombre + ">");
            pw.println(); // Línea vacía → fin de cabeceras

            /*
             * ============================================================
             * 3️⃣ LEER RESPUESTA DEL SERVIDOR
             * ============================================================
             *
             * Se leen todas las líneas enviadas por el servidor
             * hasta que cierre la conexión.
             */

            System.out.println("\n--- RESPUESTA DEL SERVIDOR ---\n");

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
