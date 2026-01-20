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
public class PSP_U3_hoja2_TCP_ejercicio3_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor; // Socket de escucha del servidor
        Socket cliente; // Socket para atender a un cliente
        int numCliente = 1; // Contador de clientes
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
                System.out.println("Escucho en el puerto: "+PUERTO);
                System.out.println("Cliente conectado");
                while (!acertado) {
                    int numeroCliente = Integer.parseInt(entrada.readUTF());
                    if (numeroCliente==numeroRandom) {
                        String mensaje="CORRECTO";
                        salida.writeUTF(mensaje);
                        acertado=true;
                        cliente.close();
                    }else{
                        if (numeroCliente<numeroRandom) {
                            String mensaje2="El numero secreto es mayor";
                            salida.writeUTF(mensaje2);
                        }else{
                            String mensaje2="El numero secreto es menor";
                            salida.writeUTF(mensaje2);
                            
                        }
                    }
                }

            } while (true);

        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja2_TCP_ejercicio3_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
