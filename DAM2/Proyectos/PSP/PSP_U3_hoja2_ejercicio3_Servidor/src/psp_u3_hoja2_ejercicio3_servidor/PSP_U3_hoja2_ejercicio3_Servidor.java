/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja2_ejercicio3_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja2_ejercicio3_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor; // Socket de escucha del servidor
        Socket cliente; // Socket para atender a un cliente
        int numCliente = 0; // Contador de clientes
        int PUERTO = 6666; // Puerto para esuchar
        try {
            servidor = new ServerSocket(PUERTO);
            do {
                cliente = servidor.accept();
                Random random = new Random();
                int numeroRandom = random.nextInt(0, 100);
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                boolean acertado=false;
                while (!acertado) {
                    int numeroCliente = Integer.parseInt(entrada.readUTF());
                    if (numeroCliente==numeroRandom) {
                        System.out.println("Has acertado el numero "+numeroRandom);
                        acertado=true;
                        break;
                    }else{
                        System.out.println("No has acertado el numero");
                        if (numeroCliente<numeroRandom) {
                            System.out.println("El numero secreto es mayor");
                        }else{
                            
                        }
                    }
                }

            } while (true);

        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja2_ejercicio3_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
