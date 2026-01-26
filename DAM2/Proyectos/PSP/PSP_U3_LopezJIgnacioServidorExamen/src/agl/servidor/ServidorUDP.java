/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class ServidorUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int puerto = 6666;
        String stringRecibido = "";

        System.out.println("=== SERVIDOR UDP ===");
        try {

            DatagramSocket sSocket = new DatagramSocket(puerto);
            DatagramPacket recibir;
            do {
                byte[] bytesRecibir = new byte[1024];
                recibir = new DatagramPacket(bytesRecibir, bytesRecibir.length);
                sSocket.receive(recibir);
                stringRecibido = new String(recibir.getData(), 0, recibir.getLength());
                System.out.println("Mensaje recibido: " + stringRecibido);
                String nuevoString = stringRecibido.toUpperCase();
                System.out.println("Mensaje que se envia: " + nuevoString);
                byte[] bytesEnviar = nuevoString.getBytes();
                DatagramPacket enviar = new DatagramPacket(bytesEnviar, bytesEnviar.length, recibir.getAddress(), recibir.getPort());
                sSocket.send(enviar);
            } while (!stringRecibido.toUpperCase().equals("Q"));
            String stringFin="COMUNICACION FINALIZADA";
            byte[] bytesEnviar = stringFin.getBytes();
            DatagramPacket enviar = new DatagramPacket(bytesEnviar, bytesEnviar.length, recibir.getAddress(), recibir.getPort());
            sSocket.send(enviar);

        } catch (SocketException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
