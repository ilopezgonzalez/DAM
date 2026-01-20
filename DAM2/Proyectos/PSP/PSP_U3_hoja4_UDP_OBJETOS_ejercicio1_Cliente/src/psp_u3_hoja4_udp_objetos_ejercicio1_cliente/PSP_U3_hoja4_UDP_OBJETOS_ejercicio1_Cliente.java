/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja4_udp_objetos_ejercicio1_cliente;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Rectangulo;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja4_UDP_OBJETOS_ejercicio1_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            DatagramSocket sSocket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName("127.0.0.1");
            int puerto = 7777;
            boolean juegoActivo = true;
            System.out.println("Bienvenido al cliente de rectángulos");
            byte[] envioVacio=new byte[]{1};
            DatagramPacket paqueteVacio =new DatagramPacket(envioVacio, envioVacio.length, direccion, puerto);
            sSocket.send(paqueteVacio);
            for (int i = 1; i < 6; i++) {
                System.out.println("Envio del rectangulo " + i);
                System.out.printf("Ancho: ");
                double ancho = Double.parseDouble(teclado.nextLine());
                System.out.printf("Alto: ");
                double alto = Double.parseDouble(teclado.nextLine());
                Rectangulo rectangulo = new Rectangulo(ancho, alto);
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream salida = new ObjectOutputStream(byteStream);
                salida.writeObject(rectangulo);
                salida.flush();
                byte[] bytesRectangulo = byteStream.toByteArray();
                DatagramPacket enviar = new DatagramPacket(bytesRectangulo, bytesRectangulo.length, direccion, puerto);
                sSocket.send(enviar);
                byte[] bytesRecibir = new byte[1024];
                DatagramPacket recibir = new DatagramPacket(bytesRecibir, bytesRecibir.length);
                sSocket.receive(recibir);
                String recibido=new String(recibir.getData(), 0,recibir.getLength());
                System.out.println(recibido);
            }

        } catch (SocketException ex) {
            Logger.getLogger(PSP_U3_hoja4_UDP_OBJETOS_ejercicio1_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja4_UDP_OBJETOS_ejercicio1_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja4_UDP_OBJETOS_ejercicio1_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
