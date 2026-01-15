/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja5_ejercicio1_raices_hilos_cliente_udp;

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
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja5_ejercicio1_Raices_Hilos_Cliente_UDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner (System.in);
        
        try {
            DatagramSocket sSocket=new DatagramSocket();
            InetAddress direccion=InetAddress.getByName("127.0.0.1");
            int puerto=5555;
            String numero="";
            System.out.println("=== SERVICIO DE RAIZ CUADRADA ===");
            System.out.println("Introduce un numero y pulsa ENTER");
            System.out.printf("Numero:");
            numero=String.valueOf(Integer.parseInt(teclado.nextLine()));
            byte[]numeroBytes=numero.getBytes();
            DatagramPacket enviar=new DatagramPacket(numeroBytes, numeroBytes.length, direccion, puerto);
            sSocket.send(enviar);
            byte[] cadenaRecibir=new byte [1024];
            DatagramPacket recibir=new DatagramPacket(cadenaRecibir, cadenaRecibir.length);
            sSocket.receive(recibir);
            
        } catch (SocketException ex) {
            Logger.getLogger(PSP_U3_hoja5_ejercicio1_Raices_Hilos_Cliente_UDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja5_ejercicio1_Raices_Hilos_Cliente_UDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja5_ejercicio1_Raices_Hilos_Cliente_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
