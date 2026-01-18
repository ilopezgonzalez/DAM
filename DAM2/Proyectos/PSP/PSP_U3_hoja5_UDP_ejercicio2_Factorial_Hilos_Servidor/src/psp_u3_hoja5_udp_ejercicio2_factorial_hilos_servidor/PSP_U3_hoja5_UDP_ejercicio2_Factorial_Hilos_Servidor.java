/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja5_udp_ejercicio2_factorial_hilos_servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja5_UDP_ejercicio2_Factorial_Hilos_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int puerto = 5555;
        int contador = 0;

        System.out.println("Servidor de factoriales iniciado");

        try (DatagramSocket socket = new DatagramSocket(puerto)) {

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

                // Espera a un cliente
                socket.receive(paquete);

                System.out.println("Atendiendo a cliente " + contador);

                // Hilo por cliente
                GestorClientes gc = new GestorClientes(contador, socket, paquete);
                gc.start();

                contador++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
