/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja2_ejericicio1_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja2_TCP_ejericicio1_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Definimos los Sockets
            ServerSocket servidor; // Socket de escucha del servidor
            Socket cliente; // Socket para atender a un cliente
            int numCliente = 0; // Contador de clientes
            int PUERTO = 6666; // Puerto para esuchar
        try {
            
            InetAddress address=InetAddress.getLocalHost();
            String direccionIP=address.getHostAddress();
            String nombre=address.getHostName();
            System.out.println("Soy el SERVER, mi IP es: "+direccionIP);
            System.out.println("Mi nombre de HOST es: "+nombre);
            System.out.println("Estoy escuchando en el puerto: "+PUERTO);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja2_TCP_ejericicio1_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            servidor=new ServerSocket(PUERTO);
            do {
                cliente=servidor.accept();
                System.out.println("--------------------------");
                System.out.println("IP del cliente: "+cliente.getRemoteSocketAddress().toString());
                System.out.println("Nombre del cliente: "+cliente.getInetAddress().getHostName());
                System.out.println("Sale por su puerto: "+cliente.getPort());
                
                DataInputStream entrada=new DataInputStream(cliente.getInputStream());
                String mensaje=entrada.readUTF();
                System.out.println("Mensaje del cliente: "+mensaje);
                
                DataOutputStream salida=new DataOutputStream(cliente.getOutputStream());
                System.out.println("Se lanza mensaje al cliente: "+LocalTime.now());
                salida.writeUTF("Son las: "+LocalTime.now());
            } while (true);
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja2_TCP_ejericicio1_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
