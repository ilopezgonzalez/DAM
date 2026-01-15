/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u3_hoja5_ejercicio1_raices_hilos_servidor_tcp;

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
public class GestionClientes extends Thread {
    
    private int numCliente;
    private Socket socket;

    public GestionClientes(int numCliente, Socket socket) {
        this.numCliente = numCliente;
        this.socket = socket;
    }

    

    @Override
    public void run() {
        DataInputStream entrada;
        DataOutputStream salida;
        
        String banner="""
                      === SERVICIO DE RAIZ CUADRADA ===
                      Introduce un numero y pulsa ENTER
                      Numero:
                      """;
        try {
            salida=new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(banner);
            entrada=new DataInputStream(socket.getInputStream());
            int numero=entrada.readInt();
            double raiz=Math.sqrt(numero);
            salida.writeDouble(raiz);
            
        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
