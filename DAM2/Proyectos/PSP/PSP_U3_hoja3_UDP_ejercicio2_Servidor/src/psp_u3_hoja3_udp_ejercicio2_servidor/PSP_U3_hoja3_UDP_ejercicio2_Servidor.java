/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja3_udp_ejercicio2_servidor;

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
public class PSP_U3_hoja3_UDP_ejercicio2_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int puerto = 5000;
        InetAddress direccion = null;
        try {
            direccion = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio2_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            System.out.println("=== DATOS DEL SERVIDOR ===");
            System.out.println("Nombre: " + direccion.getHostName());
            System.out.println("IP: " + direccion.getHostAddress());
            System.out.println("Puerto de escucha: " + puerto);
            System.out.println("==========================");

            DatagramSocket sSocket = new DatagramSocket(puerto);

            while (true) {
                byte[] cadena = new byte[1024];
                DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
                sSocket.receive(mensaje);
                String mensajeRecibido = new String(mensaje.getData(), 0, mensaje.getLength());
                System.out.println("Numeros recibidos del cliente: " + mensajeRecibido);
                String[] numeros = mensajeRecibido.toString().split(" ");
                int[] arrayNumeros = new int[numeros.length];
                for (int i = 0; i < numeros.length; i++) {
                    arrayNumeros[i] = Integer.parseInt(numeros[i]);
                }
                int[] nuevoArrayCuadrados = new int[arrayNumeros.length];
                for (int i = 0; i < nuevoArrayCuadrados.length; i++) {
                    nuevoArrayCuadrados[i] = (int)Math.pow(arrayNumeros[i], 2);
                }
                String cadenaEnviar="";
                for (int nuevoArrayCuadrado : nuevoArrayCuadrados) {
                    cadenaEnviar=cadenaEnviar.concat(String.valueOf(nuevoArrayCuadrado)+" ");
                }
                byte[] mensajeEnviarBytes =cadenaEnviar.getBytes();
                //La conexion ya está abierta, la direccion debe ser la misma que antes
                DatagramPacket enviar = new DatagramPacket(mensajeEnviarBytes, mensajeEnviarBytes.length, mensaje.getAddress(),mensaje.getPort());
                sSocket.send(enviar);
               
            }
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja3_UDP_ejercicio2_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
