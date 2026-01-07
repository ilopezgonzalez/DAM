/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja4_tcp_objetos_ejercicio1_servidor;

import modelo.Rectangulo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja4_TCP_OBJETOS_ejercicio1_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor; // Socket de escucha del servidor
        Socket cliente; // Socket para atender a un cliente
        int PUERTO = 7777; // Puerto para esuchar
        double sumatorioArea = 0;
        double sumatorioPerimetro = 0;
        String resultadosEnviar = "";

        System.out.println("Servidor esperando conexion...");

        try {
            servidor = new ServerSocket(PUERTO);
            
            cliente = servidor.accept();
                System.out.println("Cliente conectado:");
                System.out.println("IP: " + cliente.getInetAddress().getHostAddress());
                System.out.println("Puerto: " + cliente.getPort());
                System.out.println("Nombre: " + cliente.getInetAddress().getHostName());

                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
                salida.flush();
            for (int i = 1; i < 6; i++) {

                System.out.println("Esperando el rectangulo "+i+"...");
                Rectangulo rectangulo = (Rectangulo) entrada.readObject();

                sumatorioArea += rectangulo.calcularArea();
                sumatorioPerimetro += rectangulo.calcularPerimetro();

                salida.writeDouble(rectangulo.calcularArea());
                salida.writeDouble(rectangulo.calcularPerimetro());
                salida.writeDouble(sumatorioArea);
                salida.writeDouble(sumatorioPerimetro);
                salida.flush();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PSP_U3_hoja4_TCP_OBJETOS_ejercicio1_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
