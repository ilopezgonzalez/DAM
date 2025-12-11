/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja1_ejercicio5_direccionmulticast;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja1_ejercicio5_direccionMulticast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            String direccion=args[0];
            InetAddress address=InetAddress.getByName(direccion);
            if (address.isMulticastAddress()) {
                System.out.println("La direccion "+direccion+" es multicast.");
            }else{
                System.out.println("La direccion "+direccion+" NO es multicast.");
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_hoja1_ejercicio5_direccionMulticast.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
