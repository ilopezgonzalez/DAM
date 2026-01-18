package psp_u3_hoja5_udp_ejercicio1_raices_hilos_servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class GestorCliente extends Thread {

    private int numCliente;
    private DatagramSocket socket;
    private DatagramPacket paquete;

    public GestorCliente(int numCliente, DatagramSocket socket, DatagramPacket paquete) {
        this.numCliente = numCliente;
        this.socket = socket;
        this.paquete = paquete;
    }

    @Override
    public void run() {
        try {
            // Leer número recibido
            String recibido = new String(
                    paquete.getData(),
                    0,
                    paquete.getLength()
            );

            Double numero = Double.parseDouble(recibido);
            double raiz = Math.sqrt(numero);

            // Preparar respuesta
            String respuesta = String.valueOf(raiz);
            byte[] datos = respuesta.getBytes();

            DatagramPacket envio = new DatagramPacket(
                    datos,
                    datos.length,
                    paquete.getAddress(),
                    paquete.getPort()
            );

            socket.send(envio);

            System.out.println("Cliente " + numCliente +
                    " atendido. Número: " + numero +
                    " Raíz: " + raiz);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
