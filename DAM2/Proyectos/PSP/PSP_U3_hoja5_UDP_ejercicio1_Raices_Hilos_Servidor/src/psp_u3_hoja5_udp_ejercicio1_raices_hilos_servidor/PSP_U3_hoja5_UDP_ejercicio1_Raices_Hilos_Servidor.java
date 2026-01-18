package psp_u3_hoja5_udp_ejercicio1_raices_hilos_servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;

public class PSP_U3_hoja5_UDP_ejercicio1_Raices_Hilos_Servidor {

    public static void main(String[] args) {

        int puerto = 5555;
        int contador = 0;

        System.out.println("Servidor UDP de raíz cuadrada iniciado");

        try (DatagramSocket socket = new DatagramSocket(puerto)) {

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

                // Espera a un cliente
                socket.receive(paquete);

                System.out.println("Atendiendo a cliente " + contador);

                // Hilo por cliente
                GestorCliente gc = new GestorCliente(contador, socket, paquete);
                gc.start();

                contador++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
