/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja5_udp_ejercicio2_factorial_hilos_cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja5_UDP_ejercicio2_Factorial_Hilos_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            DatagramSocket sSocket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName("127.0.0.1");
            int puerto = 5555;

            System.out.println("=== SERVICIO DE FACTORIALES ===");
            System.out.println("Introduce un numero entero >=0");
            System.out.print("Número: ");

            String numero= String.valueOf(Integer.parseInt(teclado.nextLine()));

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

            int resultado = Integer.parseInt(
                    new String(recibir.getData(), 0, recibir.getLength())
            );

            System.out.println(
                    "Factorial de " + numero + " = " + resultado
            );

            sSocket.close();

        } catch (IOException e) {
            Logger.getLogger(
                    PSP_U3_hoja5_UDP_ejercicio2_Factorial_Hilos_Cliente.class.getName()
            ).log(Level.SEVERE, null, e);
        } catch (NumberFormatException e) {
            System.out.println("Error: introduce un número válido.");
        }
    }
    
}
