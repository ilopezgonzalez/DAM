/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u3_hoja5_udp_ejercicio2_factorial_hilos_servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author ilopezgonzalez
 */
public class GestorClientes extends Thread {

    private int numCliente;
    private DatagramSocket socket;
    private DatagramPacket paquete;

    public GestorClientes(int numCliente, DatagramSocket socket, DatagramPacket paquete) {
        this.numCliente = numCliente;
        this.socket = socket;
        this.paquete = paquete;
    }

    @Override
    public void run() {
        try {
            long factorial = 1;
            // Leer número recibido
            String recibido = new String(
                    paquete.getData(),
                    0,
                    paquete.getLength()
            );

            int numero = Integer.parseInt(recibido);
            for (int i = numero; i >= 1; i--) {
                factorial = factorial * i;
            }
            // Preparar respuesta
            String respuesta = String.valueOf(factorial);
            byte[] datos = respuesta.getBytes();

            DatagramPacket envio = new DatagramPacket(
                    datos,
                    datos.length,
                    paquete.getAddress(),
                    paquete.getPort()
            );

            socket.send(envio);

            System.out.println("Cliente " + numCliente
                    + " atendido. Número: " + numero
                    + " Factorial: " + factorial);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
