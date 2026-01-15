/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u3_hoja5_udp_ejercicio1_raices_hilos_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class GestorCliente extends Thread{
    
    private int numCliente;
    private Socket socket;

    public GestorCliente(int numCliente, Socket socket) {
        this.numCliente = numCliente;
        this.socket = socket;
    }

    @Override
    public void run() {
        double raiz;
        InetAddress direccion;
        int puerto=5555;
        DataInputStream entrada;
        DataOutputStream salida;
        
        try {
            direccion=InetAddress.getByName("127.0.0.1");
            DatagramSocket sSocket=new DatagramSocket(puerto);
            byte[] bytesRecibir=new byte[1024];
            DatagramPacket recibir=new DatagramPacket(bytesRecibir, bytesRecibir.length);
            sSocket.receive(recibir);
            int numeroRecibido=Integer.parseInt(new String(recibir.getData(), 0, recibir.getLength()));
            
            raiz=Math.sqrt(numeroRecibido);
            
            String stringEnviar=String.valueOf(raiz);
            byte[] bytesEnviar=stringEnviar.getBytes();
            DatagramPacket enviar=new DatagramPacket(bytesEnviar, bytesEnviar.length);
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
