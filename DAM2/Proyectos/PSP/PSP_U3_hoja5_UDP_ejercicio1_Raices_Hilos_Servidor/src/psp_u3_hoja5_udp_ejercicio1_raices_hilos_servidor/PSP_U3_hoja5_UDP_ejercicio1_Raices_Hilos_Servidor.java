/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja5_udp_ejercicio1_raices_hilos_servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja5_UDP_ejercicio1_Raices_Hilos_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int colaCliente=3;
        ServerSocket servidor;
        Socket cliente;
        int puerto=5555;
        boolean salir=false;
        
        System.out.println("Servidor de raiz cuadrada iniciado");
        
        try {
            servidor=new ServerSocket(puerto, colaCliente);
            int contador=0;
            while (true) {
                cliente=servidor.accept();
                System.out.println("Atendiendo a cliente "+contador);
                GestorCliente gc=new GestorCliente(contador, cliente);
                gc.start();
                contador++;
            }
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja5_UDP_ejercicio1_Raices_Hilos_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
