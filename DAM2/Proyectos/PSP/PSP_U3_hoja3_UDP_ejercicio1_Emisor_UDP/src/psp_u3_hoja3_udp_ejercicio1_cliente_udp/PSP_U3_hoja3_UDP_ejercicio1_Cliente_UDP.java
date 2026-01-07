/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja3_udp_ejercicio1_cliente_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja3_UDP_ejercicio1_Cliente_UDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        try {
            DatagramSocket sSocket=new DatagramSocket();
            InetAddress direccion=InetAddress.getByName("127.0.0.1");
            int puerto=5000;
            String mensaje="Cliente intentado adquierir hora actual";
            byte[] mensajeBytes=mensaje.getBytes();
            DatagramPacket enviar= new DatagramPacket(mensajeBytes, mensajeBytes.length, direccion, puerto);
            sSocket.send(enviar);
            System.out.println("Intentando conectar con el servidor: "+enviar.getAddress().getHostName()+" con direccion IP: "+enviar.getAddress().getHostAddress()+" para obtener la hora");
            System.out.println("=== DATOS DEL SERVIDOR ===");
            System.out.println("Nombre: "+enviar.getAddress().getHostName());
            System.out.println("IP: "+enviar.getAddress());
            System.out.println("Puesto del socket propio: "+sSocket.getLocalPort());
            System.out.println("===========================");
            byte[] recibirBuffer= new byte[1000];
            DatagramPacket recibir=new DatagramPacket(recibirBuffer, recibirBuffer.length);
            sSocket.receive(recibir);
            String mensajeRecibido= new String(recibir.getData(),0, recibir.getLength());
            System.out.println("Respuesta del servidor: "+mensajeRecibido);
            
        } catch (SocketException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio1_Cliente_UDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio1_Cliente_UDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio1_Cliente_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
