 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja5_ejercicio2_factorial_hilos_servidor_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja5_ejercicio2_Factorial_Hilos_Servidor_TCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int colaCliente = 3; // Contador de clientes
        ServerSocket servidor;
        Socket cliente;
        int puerto = 5555;
        boolean salir = false;

        System.out.println("Servidor de factoriales iniciado...");

        try {
            servidor = new ServerSocket(puerto, colaCliente);
            int contador=0;
            while (true) {
                cliente = servidor.accept();
                System.out.println("Atendiendo al cliente: " + contador);
                GestorClientes gc = new GestorClientes(contador, cliente);
                gc.start();
                contador++;
            }

        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja5_ejercicio2_Factorial_Hilos_Servidor_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
