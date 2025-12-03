/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1_MostrarIP;

import java.net.InetAddress;

/**
 *
 * @author damt209
 */
public class MostarIP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            InetAddress address=InetAddress.getLocalHost();
            String nombre=address.getHostName();
            //Se debe pasar la direccion a String
            String direccion=address.getHostAddress();
            System.out.println("La direccion ip de mi PC es: "+direccion);
            System.out.println("El nombre del host es: "+nombre);
        } catch (Exception e) {
        }
        
    }
    
}
