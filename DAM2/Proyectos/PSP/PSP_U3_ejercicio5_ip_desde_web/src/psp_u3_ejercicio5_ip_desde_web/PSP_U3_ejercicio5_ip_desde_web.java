/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_ejercicio5_ip_desde_web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_ejercicio5_ip_desde_web {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String web=args[0];
            InetAddress address=InetAddress.getByName(web);
            String ip=address.getHostAddress();
            System.out.println("La ip de la web www.google.es es: "+ip);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PSP_U3_ejercicio5_ip_desde_web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
