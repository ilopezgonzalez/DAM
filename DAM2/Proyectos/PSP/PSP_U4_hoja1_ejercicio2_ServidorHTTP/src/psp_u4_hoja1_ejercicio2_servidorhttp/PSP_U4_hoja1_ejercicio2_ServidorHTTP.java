package psp_u4_hoja1_ejercicio2_servidorhttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

/*
 * ============================================================
 * SERVIDOR HTTP CONCURRENTE
 * ============================================================
 *
 * ¿Qué hace este servidor?
 * 1️⃣ Escucha en el puerto 8080.
 * 2️⃣ Espera clientes.
 * 3️⃣ Por cada cliente crea un hilo nuevo (concurrencia).
 * 4️⃣ Lee la petición HTTP.
 * 5️⃣ Extrae:
 *      - Ruta (GET /algo HTTP/1.1)
 *      - Cabecera personalizada X-Cliente-Nombre
 * 6️⃣ Devuelve una respuesta HTTP válida.
 * 7️⃣ Gestiona:
 *      - 200 OK
 *      - 404 Not Found
 *      - 400 Bad Request
 *
 * IMPORTANTE PARA EXAMEN:
 * → El servidor SIEMPRE debe ser concurrente.
 * → La respuesta HTTP debe tener:
 *      - Línea de estado
 *      - Cabeceras
 *      - Línea en blanco
 *      - Cuerpo
 */

public class PSP_U4_hoja1_ejercicio2_ServidorHTTP {

    // Puerto donde el servidor escuchará conexiones
    private static final int PUERTO = 8080;

    public static void main(String[] args) {

        /*
         * ServerSocket:
         * Abre un puerto del sistema y queda a la espera
         * de que un cliente se conecte.
         */
        try (ServerSocket servidor = new ServerSocket(PUERTO)) {

            System.out.println("Servidor iniciado en puerto " + PUERTO);

            /*
             * BUCLE INFINITO
             * Un servidor normalmente nunca se detiene.
             * Siempre está esperando nuevos clientes.
             */
            while (true) {

                /*
                 * accept()
                 * Bloquea el programa hasta que un cliente se conecta.
                 * Cuando alguien se conecta devuelve un objeto Socket.
                 */
                Socket cliente = servidor.accept();

                /*
                 * CONCURRENCIA:
                 * Creamos un hilo nuevo para atender a cada cliente.
                 *
                 * Si NO hiciéramos esto:
                 * → El servidor solo podría atender un cliente cada vez.
                 *
                 * Esto es lo que normalmente preguntan en examen.
                 */
                new Thread(() -> procesarCliente(cliente)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * ============================================================
     * MÉTODO QUE ATIENDE A UN CLIENTE
     * ============================================================
     */
    private static void procesarCliente(Socket cliente) {

        try (
            /*
             * BufferedReader:
             * Permite leer texto línea por línea desde el cliente.
             */
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            /*
             * PrintWriter:
             * Permite enviar texto al cliente.
             */
            PrintWriter pw = new PrintWriter(
                    cliente.getOutputStream(), true)
        ) {

            String linea;
            String ruta = null;   // Guardará la ruta solicitada
            String nombre = null; // Guardará el nombre del cliente

            /*
             * ============================================================
             * 1️⃣ LEER LA PETICIÓN HTTP
             * ============================================================
             *
             * Una petición HTTP tiene este formato:
             *
             * GET /ruta HTTP/1.1
             * Host: localhost
             * X-Cliente-Nombre: <Pepe>
             *
             * (línea vacía)
             *
             * La línea vacía indica el final de cabeceras.
             */

            while ((linea = br.readLine()) != null && !linea.isEmpty()) {

                /*
                 * Si la línea empieza por GET,
                 * es la línea principal de la petición.
                 */
                if (linea.startsWith("GET")) {

                    /*
                     * Dividimos por espacios:
                     * ["GET", "/hora", "HTTP/1.1"]
                     */
                    String[] partes = linea.split(" ");

                    if (partes.length >= 2) {
                        ruta = partes[1];
                    }
                }

                /*
                 * Leer cabecera personalizada
                 */
                if (linea.startsWith("X-Cliente-Nombre:")) {

                    /*
                     * Extraemos el texto entre < >
                     */
                    nombre = linea.substring(
                            linea.indexOf("<") + 1,
                            linea.lastIndexOf(">")
                    );
                }
            }

            /*
             * ============================================================
             * 2️⃣ VALIDAR PETICIÓN
             * ============================================================
             */

            if (ruta == null) {
                /*
                 * Si no hay línea GET válida,
                 * la petición está mal formada.
                 */
                pw.println("HTTP/1.1 400 Bad Request");
                pw.println("Content-Type: text/html");
                pw.println();
                pw.println("<h1>400 - Petición mal formada</h1>");
                return;
            }

            if (nombre == null || nombre.isEmpty()) {
                nombre = "desconocido";
            }

            // Hora actual del servidor
            String horaActual = LocalTime.now().withNano(0).toString();

            String estado;
            String cuerpo;

            /*
             * ============================================================
             * 3️⃣ GENERAR RESPUESTA SEGÚN RUTA
             * ============================================================
             */

            switch (ruta) {

                case "/":
                    estado = "HTTP/1.1 200 OK";
                    cuerpo = "<html><body><h1>Bienvenido</h1></body></html>";
                    break;

                case "/hora":
                    estado = "HTTP/1.1 200 OK";
                    cuerpo = "<html><body><h1>Hora actual: "
                            + horaActual + "</h1></body></html>";
                    break;

                default:
                    estado = "HTTP/1.1 404 Not Found";
                    cuerpo = "<html><body><h1>404 - No encontrado</h1></body></html>";
                    break;
            }

            /*
             * Mostrar información en consola (obligatorio en enunciado)
             */
            System.out.println("IP cliente: " + cliente.getInetAddress());
            System.out.println("Ruta solicitada: " + ruta);
            System.out.println("Hora enviada: " + horaActual);
            System.out.println("-----------------------------");

            /*
             * ============================================================
             * 4️⃣ ENVIAR RESPUESTA HTTP
             * ============================================================
             *
             * ESTRUCTURA OBLIGATORIA:
             *
             * HTTP/1.1 200 OK
             * Content-Type: ...
             * Content-Length: ...
             * X-Servidor-Saludo: ...
             * X-Servidor-Hora: ...
             *
             * (línea vacía)
             * cuerpo HTML
             */

            pw.println(estado);
            pw.println(Constantes.PRIMERA_CABECERA);
            pw.println("Content-Length: " + cuerpo.length());

            // Cabeceras personalizadas obligatorias
            pw.println("X-Servidor-Saludo: Hola " + nombre);
            pw.println("X-Servidor-Hora: " + horaActual);

            pw.println(); // Línea vacía obligatoria
            pw.println(cuerpo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
