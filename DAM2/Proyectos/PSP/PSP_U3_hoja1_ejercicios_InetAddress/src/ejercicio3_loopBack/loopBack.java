/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3_loopBack;

import java.net.InetAddress;

/**
 *
 * @author ilopezgonzalez
 */
public class loopBack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLoopbackAddress();
            System.out.println("La direccion de loopback es: "+address.toString());
        } catch (Exception e) {
        }
    }
    
}
