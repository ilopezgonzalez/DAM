/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class ServidorTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor; // Socket de escucha del servidor
        Socket cliente; // Socket para atender a un cliente
        int numCliente = 1; // Contador de clientes
        int PUERTO = 6666; // Puerto para esuchar
        boolean conexionActiva = true;
        String pronostico = "";
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en el puerto: " + PUERTO);

            while (true) {
                cliente = servidor.accept();
                Random random = new Random();
                int numeroRandom = random.nextInt(0, 100);
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                boolean acertado = false;
                System.out.println("Llega el cliente: " + numCliente);
                System.out.println("Envio mensaje para el cliente");
                String mensajeInicial = "El tiempo. Introduzca la inicial de una ciudad o 'Q'.";
                salida.writeUTF(mensajeInicial);
                    

                while (conexionActiva) {
                    String entradaCiudad = entrada.readUTF();
                    
                    System.out.println("Mensaje del cliente: " + entradaCiudad.toUpperCase());

                    if (entradaCiudad.toUpperCase().equals("S")) {
                        pronostico = "El tiempo en Santander son nubes y claros, 17º.";
                        salida.writeUTF(pronostico);
                    }
                    if (entradaCiudad.toUpperCase().equals("M")) {
                        pronostico = "El tiempo en Madrid es soleado, 25º";
                        salida.writeUTF(pronostico);
                    }
                    if (entradaCiudad.toUpperCase().equals("Q")) {
                        pronostico = "Conexion finalizada. Gracias por usar el servicio.";
                        System.out.println("Se ha cerrado la conexión con el cliente: " + numCliente);
                        salida.writeUTF(pronostico);
                        
                    }
                    
                    
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
