package psp_u3_udp_objeto.hilo_cliente;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Rectangulo;

public class PSP_U3_UDP_ObjetoHilo_Cliente {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int puerto = 7777;

        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName("127.0.0.1");

            System.out.println("Bienvenido al cliente UDP de rectángulos");

            for (int i = 1; i <= 5; i++) {

                System.out.println("\nEnvío del rectángulo " + i);
                System.out.print("Ancho: ");
                double ancho = Double.parseDouble(teclado.nextLine());

                System.out.print("Alto: ");
                double alto = Double.parseDouble(teclado.nextLine());

                Rectangulo rectangulo = new Rectangulo(ancho, alto);

                // Serializar objeto
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(rectangulo);
                oos.flush();

                byte[] datosEnviar = baos.toByteArray();

                DatagramPacket paqueteEnviar = new DatagramPacket(
                        datosEnviar,
                        datosEnviar.length,
                        direccion,
                        puerto
                );

                socket.send(paqueteEnviar);

                // Recibir respuesta del servidor
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteRecibir = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteRecibir);

                String respuesta = new String(
                        paqueteRecibir.getData(),
                        0,
                        paqueteRecibir.getLength()
                );

                System.out.println("Respuesta del servidor:");
                System.out.println(respuesta);
            }

            socket.close();

        } catch (Exception ex) {
            Logger.getLogger(
                    PSP_U3_UDP_ObjetoHilo_Cliente.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }
}
