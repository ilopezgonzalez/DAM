/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja4_udp_objetos_ejercicio1_servidor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Rectangulo;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_Hoja4_UDP_OBJETOS_ejercicio1_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int contador = 1;
        double sumatorioArea = 0;
        double sumatorioPerimetro = 0;
        double area;
        double perimetro;

        int puerto = 7777;
        try {
            System.out.println("Servidor esperando conexion...");
            DatagramSocket sSocket = new DatagramSocket(puerto);

            byte[] bytesRecibir = new byte[1024];
            DatagramPacket recibir = new DatagramPacket(bytesRecibir, bytesRecibir.length);
            sSocket.receive(recibir);
            System.out.println("Cliente conectado:");
            System.out.println("IP: " + recibir.getAddress());
            System.out.println("Puerto: " + recibir.getPort());
            System.out.println("Nombre: " + recibir.getAddress().getHostName());
            System.out.println("Esperando rectangulo 1");

            while (contador <=5) {
                sSocket.receive(recibir);
                System.out.println("Esperando rectangulo " + (contador+1));
                ByteArrayInputStream bais = new ByteArrayInputStream(recibir.getData(), 0, recibir.getLength());
                ObjectInputStream recibido = new ObjectInputStream(bais);
                Rectangulo rectangulo = (Rectangulo) recibido.readObject();
                area = rectangulo.getAncho() * rectangulo.getAlto();
                perimetro = 2 * rectangulo.getAncho() + 2 * rectangulo.getAlto();
                sumatorioArea += rectangulo.calcularArea();
                sumatorioPerimetro += rectangulo.calcularPerimetro();
                contador++;
                String mensajeEnviar = "Area: " + area
                        + "\nPerimetro: " + perimetro
                        + "\nArea total acumulada: " + sumatorioArea
                        + "\nPerimetro total acumulado: " + sumatorioPerimetro;
                byte[] mensajeBytes = mensajeEnviar.getBytes();
                DatagramPacket enviar = new DatagramPacket(mensajeBytes, mensajeBytes.length, recibir.getAddress(), recibir.getPort());
                sSocket.send(enviar);
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_Hoja4_UDP_OBJETOS_ejercicio1_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(PSP_U3_Hoja4_UDP_OBJETOS_ejercicio1_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_Hoja4_UDP_OBJETOS_ejercicio1_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PSP_U3_Hoja4_UDP_OBJETOS_ejercicio1_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
