/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2_IPxNombre;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class IpxNombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre de la maquina a buscar");
        String nombreEquipo = teclado.nextLine();
        System.out.println(nombreEquipo);
        try {
            InetAddress address = InetAddress.getByName(nombreEquipo);
            String direccion=address.getHostAddress();
            System.out.println("La direccion IP es: "+direccion);
        } catch (UnknownHostException ex) {
            Logger.getLogger(IpxNombre.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
