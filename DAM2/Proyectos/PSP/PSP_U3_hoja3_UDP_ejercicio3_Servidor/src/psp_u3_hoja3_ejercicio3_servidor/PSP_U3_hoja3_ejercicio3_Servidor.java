/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja3_ejercicio3_servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja3_ejercicio3_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        boolean juegoActivo = true;
        int puerto = 5000;
        //Conexion
        InetAddress direccion = null;
        try {
            //Direccion de la conexion
            direccion = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja3_ejercicio3_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //InetAddress para conseguir los datos del host
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja3_ejercicio3_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("=== SERVIDOR UDP ===");
        System.out.println("Nombre: " + address.getHostName());
        System.out.println("IP: " + address.getHostAddress());
        System.out.println("Puesto: " + puerto);
        Random random = new Random();
        int numeroSecreto = random.nextInt(1, 101);
        System.out.println("Numero secreto generado");
        System.out.println("====================");

        DatagramSocket sSocket = new DatagramSocket(puerto);
        byte[] bytesRecibir = new byte[1024];
        DatagramPacket recibir = new DatagramPacket(bytesRecibir, bytesRecibir.length);

        while (juegoActivo) {
            sSocket.receive(recibir);
            int numeroRecibido = Integer.parseInt(new String(recibir.getData(), 0, recibir.getLength()));
            String cadenaEnviar = "";
            if (numeroRecibido == numeroSecreto) {
                cadenaEnviar = "¡CORRECTO! Has acertado el numero";
                juegoActivo = false;
            } else {
                if (numeroRecibido > numeroSecreto) {
                    cadenaEnviar = "El numero secreto es MENOR";
                } else {
                    cadenaEnviar = "El numero secreto es MAYOR";
                }
            }
            byte[] bytesEnviar = cadenaEnviar.getBytes();
            DatagramPacket enviar = new DatagramPacket(bytesEnviar, bytesEnviar.length, recibir.getAddress(), recibir.getPort());
            sSocket.send(enviar);
        }

    }

}
