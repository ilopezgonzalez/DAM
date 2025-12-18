/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja2_ejercicio2_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja2_ejercicio2_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numCliente = 0; // Mi número de cliente
        int PUERTO = 6666;  // Puerto de conexión
        String DIRECCION = args[0];
        

        for (int i = 1; i < args.length; i++) {
            try (Socket servidor = new Socket(DIRECCION, PUERTO);
                DataOutputStream salida = new DataOutputStream(servidor.getOutputStream());
                DataInputStream entrada = new DataInputStream(servidor.getInputStream())){
                
                String arg = args[i];
                salida.writeUTF(arg);
                String respuesta = entrada.readUTF();
                System.out.println("Solicitud: " + arg + " Resultado: " + Integer.parseInt(respuesta));

            } catch (IOException ex) {
                Logger.getLogger(PSP_U3_hoja2_ejercicio2_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
