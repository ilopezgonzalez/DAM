/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja1;

import java.io.File;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero=new File("mifichero.txt");
        System.out.println("Nombre del fichero: "+fichero.getName());
        System.out.println("Ruta del fichero: "+fichero.getAbsolutePath());
        System.out.println("Es de lectura? "+fichero.canRead());
        System.out.println("Tamano del fichero: "+fichero.getTotalSpace());
    }
    
}
