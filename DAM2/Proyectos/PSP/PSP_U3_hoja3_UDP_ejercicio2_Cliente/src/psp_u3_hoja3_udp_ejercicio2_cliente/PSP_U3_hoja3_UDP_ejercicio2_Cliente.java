/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja3_udp_ejercicio2_cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja3_UDP_ejercicio2_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket sSocket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName(args[0]);
            int puerto = 5000;
            System.out.println("Numero enviados: " + args[1] + " " + args[2] + " " + args[3]);
            String mensaje = args[1] + " " + args[2] + " " + args[3];
            byte[] mensajeBytes = mensaje.getBytes();
            DatagramPacket enviar = new DatagramPacket(mensajeBytes, mensajeBytes.length, direccion, puerto);
            sSocket.send(enviar);
            byte[] cadena = new byte[1024];
            DatagramPacket mensajeRecibir = new DatagramPacket(cadena, cadena.length);
            sSocket.receive(mensajeRecibir);
            String cuadrados=new String(mensajeRecibir.getData(), 0, mensajeRecibir.getLength());
            System.out.println("Cuadrados recibidos: "+cuadrados);

        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
