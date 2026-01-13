/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja5_ejercicio1_raices_hilos_servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja5_ejercicio1_Raices_Hilos_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numCliente = 0; // Contador de clientes
        ServerSocket servidor;
        Socket cliente;
        int puerto = 5555;
        boolean salir = false;

        System.out.println("Servidor de raiz cuadrada iniciado...");

        try {
            servidor = new ServerSocket(puerto);
            while (!salir) {
                cliente = servidor.accept();
                GestionClientes gc = new GestionClientes(1, cliente);
                gc.start();
            }
            servidor.close();

        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja5_ejercicio1_Raices_Hilos_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
