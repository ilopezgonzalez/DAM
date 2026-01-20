/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u3_hoja5_ejercicio2_factorial_hilos_servidor_tcp;

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
public class GestorClientes extends Thread {
    
    private int numCliente;
    private Socket socket;

    public GestorClientes(int numCliente, Socket socket) {
        this.numCliente = numCliente;
        this.socket = socket;
    }

    @Override
    public void run() {
        long factorial=1;
        DataInputStream entrada;
        DataOutputStream salida;
        
        String banner="""
                      === SERVICIO DE FACTORIALES ===
                      Introduce un numero entero >= 0
                      Numero:
                      """;
        
        try {
            salida=new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(banner);
            entrada=new DataInputStream(socket.getInputStream());
            int numero=entrada.readInt();
            for (int i = numero; i >=1; i--) {
                factorial=factorial*i;
            }
            salida.writeLong(factorial);
            
        } catch (IOException ex) {
            Logger.getLogger(GestorClientes.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestorClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    
    
    
    
}
