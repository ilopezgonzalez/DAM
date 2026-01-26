/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientehttp;

import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejemplo cliente realizado con sockets
 *
 * @author jfranco
 */
public class ClienteHttp {

    private static String SERVER = "localhost"; 
    private static int PUERTO = 8066;//6080;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int op = 0;

            Socket cliente = new Socket(SERVER, PUERTO);
            InputStream is = cliente.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter printWriter = new PrintWriter(cliente.getOutputStream(), true);

            Scanner teclado = new Scanner(System.in);
            try {
                System.out.println("1. Consulta raiz\n"
                        + "2. Consulta Don Quijote\n"
                        + "3. Consulta otro\n"
                        + "4. Consulta con error\n");
                op = teclado.nextInt();

                switch (op) {
                    case 1:
                        printWriter.println("GET/ HTTP1.1");
                        break;
                    case 2:
                        printWriter.println("GET/quijote HTTP1.1");
                        break;
                    case 3:
                        printWriter.println("GET/otro HTTP1.1");
                        break;
                    case 4:
                        printWriter.println("HTTP1.1");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                String linea = null;
                linea = br.readLine();//leemos respuesta del servidor
                while (linea != null) {
                    System.out.println(linea);
                    linea = br.readLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato no válido");
                teclado.next();
            }

            cliente.close();

        } catch (IOException ex) {
            Logger.getLogger(ClienteHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
