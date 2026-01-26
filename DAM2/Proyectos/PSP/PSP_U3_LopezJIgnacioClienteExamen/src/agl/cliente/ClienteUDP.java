/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class ClienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int puerto = 6666;
        InetAddress direccion = null;
        String stringRecibido = "";
        try {
            direccion = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        String stringEnviar = "";

        System.out.println("Introduce un mensaje para repetir o 'Q' para salir");

        try {
            do {
                DatagramSocket sSocket = new DatagramSocket();
                stringEnviar = teclado.nextLine();
                byte[] bytesEnviar = stringEnviar.getBytes();
                DatagramPacket enviar = new DatagramPacket(bytesEnviar, bytesEnviar.length, direccion, puerto);
                sSocket.send(enviar);
                byte[] bytesRecibir = new byte[1024];
                DatagramPacket recibir = new DatagramPacket(bytesRecibir, bytesRecibir.length);
                stringRecibido = new String(recibir.getData(), 0, recibir.getLength());
                System.out.println("Servidor: " + stringRecibido);
            } while (!stringEnviar.toUpperCase().equals("Q"));

        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
