package psp_u3_udp_objetohilo_servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PSP_U3_UDP_ObjetoHilo_Servidor {

    public static void main(String[] args) {

        int puerto = 7777;

        try {
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Servidor UDP con hilos iniciado");

            while (true) {
                byte[] buffer = new byte[2048];
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

                socket.receive(paquete);

                GestorClientes gc = new GestorClientes(socket, paquete);
                gc.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
