/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class ServidorTCPHilos {

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
                System.out.println("Atendiendo al cliente: " + numCliente);
                HiloSocketTCP hilo=new HiloSocketTCP(numCliente, cliente);
                hilo.start();
                numCliente++;
                }
            } catch (IOException ex) {
                Logger.getLogger(ServidorTCPHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }
    
}
