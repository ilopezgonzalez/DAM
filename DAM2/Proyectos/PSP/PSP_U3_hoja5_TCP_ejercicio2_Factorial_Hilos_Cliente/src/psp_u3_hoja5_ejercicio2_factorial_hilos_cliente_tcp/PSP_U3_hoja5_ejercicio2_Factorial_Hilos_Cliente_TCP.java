/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja5_ejercicio2_factorial_hilos_cliente_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja5_ejercicio2_Factorial_Hilos_Cliente_TCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado=new Scanner (System.in);
        
        try {
            Socket servidor=new Socket ("localhost", 5555);
            DataInputStream entrada;
            DataOutputStream salida;
            entrada=new DataInputStream(servidor.getInputStream());
            String banner=entrada.readUTF();
            System.out.printf(banner);
            
            int numero=Integer.parseInt(teclado.nextLine());
            salida=new DataOutputStream(servidor.getOutputStream());
            salida.writeInt(numero);
            long factorial=entrada.readLong();
            System.out.println("Factorial de "+numero+" = "+factorial);
        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja5_ejercicio2_Factorial_Hilos_Cliente_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
