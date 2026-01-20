package psp_u3_hoja5_ejercicio1_raices_hilos_cliente_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PSP_U3_hoja5_ejercicio1_Raices_Hilos_Cliente_UDP {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        try {
            DatagramSocket sSocket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName("127.0.0.1");
            int puerto = 5555;

            System.out.println("=== SERVICIO DE RAÍZ CUADRADA ===");
            System.out.println("Introduce un numero y pulsa ENTER");
            System.out.print("Número: ");

            String numero= String.valueOf(Double.parseDouble(teclado.nextLine()));

            byte[] numeroBytes = numero.getBytes();
            DatagramPacket enviar = new DatagramPacket(
                    numeroBytes,
                    numeroBytes.length,
                    direccion,
                    puerto
            );
            sSocket.send(enviar);

            byte[] buffer = new byte[1024];
            DatagramPacket recibir = new DatagramPacket(buffer, buffer.length);
            sSocket.receive(recibir);

            double resultado = Double.parseDouble(
                    new String(recibir.getData(), 0, recibir.getLength())
            );

            System.out.println(
                    "Raíz cuadrada de " + numero + " = " + resultado
            );

            sSocket.close();

        } catch (IOException e) {
            Logger.getLogger(
                    PSP_U3_hoja5_ejercicio1_Raices_Hilos_Cliente_UDP.class.getName()
            ).log(Level.SEVERE, null, e);
        } catch (NumberFormatException e) {
            System.out.println("Error: introduce un número válido.");
        }
    }
}
