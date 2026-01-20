package psp_u3_udp_objetohilo_servidor;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import modelo.Rectangulo;

public class GestorClientes extends Thread {

    private static double sumatorioArea = 0;
    private static double sumatorioPerimetro = 0;

    private DatagramSocket socket;
    private DatagramPacket paquete;

    public GestorClientes(DatagramSocket socket, DatagramPacket paquete) {
        this.socket = socket;
        this.paquete = paquete;
    }

    @Override
    public void run() {
        try {
            // Deserializar objeto recibido
            ByteArrayInputStream bais = new ByteArrayInputStream(
                    paquete.getData(), 0, paquete.getLength()
            );
            ObjectInputStream ois = new ObjectInputStream(bais);

            Rectangulo rectangulo = (Rectangulo) ois.readObject();

            double area = rectangulo.calcularArea();
            double perimetro = rectangulo.calcularPerimetro();

            sumatorioArea += area;
            sumatorioPerimetro += perimetro;

            String respuesta =
                    "Area: " + area +
                    "\nPerimetro: " + perimetro +
                    "\nArea total acumulada: " + sumatorioArea +
                    "\nPerimetro total acumulado: " + sumatorioPerimetro;

            byte[] datosEnviar = respuesta.getBytes();

            DatagramPacket enviar = new DatagramPacket(
                    datosEnviar,
                    datosEnviar.length,
                    paquete.getAddress(),
                    paquete.getPort()
            );

            socket.send(enviar);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
