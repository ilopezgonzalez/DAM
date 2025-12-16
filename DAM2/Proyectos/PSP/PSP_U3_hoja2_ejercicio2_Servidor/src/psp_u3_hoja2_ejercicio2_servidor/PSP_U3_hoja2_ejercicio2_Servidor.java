/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja2_ejercicio2_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja2_ejercicio2_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor; // Socket de escucha del servidor
        Socket cliente; // Socket para atender a un cliente
        int numCliente = 0; // Contador de clientes
        int PUERTO = 6666; // Puerto para esuchar
        try {
            InetAddress address = InetAddress.getLocalHost();
            String direccionIP = address.getHostAddress();
            String nombre = address.getHostName();
            System.out.println("LocalHost= " + nombre + "/" + direccionIP);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja2_ejercicio2_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            servidor = new ServerSocket(PUERTO);
            do {
                cliente = servidor.accept();
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                while (true) {
                    int numero = Integer.parseInt(entrada.readUTF());
                    int cuadrado = (int) Math.pow(numero, 2);
                    System.out.println("Cliente = " + cliente.getInetAddress().getHostAddress() + " Entrada: " + numero + " Salida: " + cuadrado);

                    salida.writeUTF(String.valueOf(cuadrado));
                }

            } while (true);
        } catch (EOFException e) {
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja2_ejercicio2_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
