/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja3_udp_ejercicio1_servidor_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja3_UDP_ejercicio1_servidor_UDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int puerto = 5000;
        InetAddress direccion = null;
        try {
            direccion = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio1_servidor_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }

        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            System.out.println("=== DATOS DEL SERVIDOR ===");
            System.out.println("Nombre: " + address.getHostName());
            System.out.println("IP: " + address.getHostAddress());
            System.out.println("Puerto de escucha: " + puerto);
            System.out.println("==========================");
            
            DatagramSocket sSocket = new DatagramSocket(puerto);
            byte[] cadena = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(cadena,cadena.length);
            while (true) {
                System.out.println("Cliente conectado:");
                sSocket.receive(mensaje);
                System.out.println("Nombre: " + mensaje.getAddress().getHostName());
                System.out.println("Direccion IP: " + mensaje.getAddress());
                System.out.println("Puerto: " + mensaje.getPort());
                String datos = new String(mensaje.getData(), 0, mensaje.getLength());
                System.out.println("Mensaje del cliente: " + datos);
                String hora = "La hora actual es: "+LocalTime.now().toString();
                System.out.println("==========");
                byte[] horaBytes = hora.getBytes();
                DatagramPacket envioHoras = new DatagramPacket(horaBytes, horaBytes.length,mensaje.getAddress(), mensaje.getPort());
                sSocket.send(envioHoras);
                
                
                
            }
        } catch (SocketException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio1_servidor_UDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio1_servidor_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
