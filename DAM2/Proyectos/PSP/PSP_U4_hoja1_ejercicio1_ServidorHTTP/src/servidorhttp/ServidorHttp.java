/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorhttp;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 ** Servidor HTTP que atiende peticiones de tipo 'GET' recibidas por el puerto
 * 8066
 *
 * NOTA: para probar este código, comprueba primero de que no tienes ningún otro
 * servicio por el puerto 8066 (por ejemplo, con el comando 'netstat' si estás
 * utilizando Windows)
 */
public class ServidorHttp {

    private static int PUERTO = 8066;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket cliente = null;
        try {
            servidor = new ServerSocket(PUERTO);
            imprimeDisponible();

            System.out.println("Esperando cliente");
            while (true) {
                cliente = servidor.accept();
                procesaPeticion(cliente);
                cliente.close();
                System.out.println("Cliente atendido");
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Procesamos la peticion del cliente
     */
    private static void procesaPeticion(Socket skcliente) {
        InputStream is = null;
        String peticion;
        String html;
        try {
            is = skcliente.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter printWriter = new PrintWriter(skcliente.getOutputStream(), true);
            peticion = br.readLine();
            peticion = peticion.replaceAll(" ", "");
            if (peticion.startsWith("GET")) {
                peticion = peticion.substring(3,
                        peticion.lastIndexOf("HTTP"));
                if (peticion.length() == 0
                        || peticion.equals("/")) {
                    //sirve la pagina
                    html = Constantes.HTML_INDEX;
                    printWriter.println(Constantes.LINEAINICIAL_OK);
                    printWriter.println(Constantes.PRIMERA_CABECERA);
                    printWriter.println("Content-length: "
                            + html.length() + 1);
                    printWriter.println(Constantes.DATE);
                    printWriter.println("\n");
                    printWriter.println(html);
                } //si se coresponde a la pagina de mendoza
                else if (peticion.equals("/quijote")) {
                    //sirve la pagina
                    html = Constantes.HTML_QUIJOTE;
                    printWriter.println(Constantes.DATE);
                    printWriter.println(Constantes.LINEAINICIAL_OK);
                    printWriter.println(Constantes.PRIMERA_CABECERA);
                    //printWriter.println("Content-length: " + html.length());
                    printWriter.println("Content-length: " + html.length() + 1);
                    printWriter.println(Constantes.DATE);
                    printWriter.println("\n");
                    printWriter.println(html);
                } //para cualquier otro caso
                else {
                    html = Constantes.HTML_NOENCONTRADO;
                    printWriter.println(Constantes.DATE);
                    printWriter.println(Constantes.LINEAINICIAL_NOTFOUND);
                    printWriter.println(Constantes.PRIMERA_CABECERA);
                    printWriter.println("Content-length: " + html.length());
                    printWriter.println(Constantes.DATE);
                    printWriter.println("\n");
                    printWriter.println(html);
                }
            } else {
                printWriter.println(Constantes.LINEAINICIAL_BADREQUEST);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorHttp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(ServidorHttp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * mensaje en la salida que confirma el arrranque y algunas indicaciones
     * posteriores
     */
    private static void imprimeDisponible() {
        System.out.println("El servidor Web escucha en el puerto " + PUERTO);
        System.out.println("Escribe en el navegador http://localhost:8066 \n"
                + "para solicitar la pagina de bienvenida");
        System.out.println("Escribe en el navegador http://localhost:8066/quijote \n"
                + "para solicitar el principio del Quijote");
    }

}
