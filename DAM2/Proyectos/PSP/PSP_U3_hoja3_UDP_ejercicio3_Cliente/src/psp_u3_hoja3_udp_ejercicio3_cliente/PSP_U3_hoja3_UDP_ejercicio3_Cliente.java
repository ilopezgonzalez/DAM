/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja3_udp_ejercicio3_cliente;

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
public class PSP_U3_hoja3_UDP_ejercicio3_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner teclado=new Scanner (System.in);
        try {
            DatagramSocket sSocket =new DatagramSocket();
            InetAddress direccion= InetAddress.getByName("127.0.0.1");
            int puerto= 5000;
            boolean juegoActivo=true;
            String numero="";
            System.out.println("Adivinar un numero");
            while (juegoActivo) {
                System.out.printf("Introduce un numero:");
                numero= String.valueOf(Integer.parseInt(teclado.nextLine()));
                byte[] numeroBytes= numero.getBytes();
                DatagramPacket enviar= new DatagramPacket(numeroBytes, numeroBytes.length, direccion, puerto);
                sSocket.send(enviar);
                byte[] cadenaRecibir= new byte[1024];
                DatagramPacket recibir=new DatagramPacket(cadenaRecibir, cadenaRecibir.length);
                sSocket.receive(recibir);
                String recibido= new String(recibir.getData(), 0, recibir.getLength());
                System.out.println("Servidor: "+recibido);
                if (recibido.toLowerCase().contains("acertado")) {
                    juegoActivo=false;
                }
                
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio3_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio3_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
