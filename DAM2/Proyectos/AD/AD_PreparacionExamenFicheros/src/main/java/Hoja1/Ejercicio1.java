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
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero=new File("miFichero.txt");
        if (fichero.exists()) {
            System.out.println("El fichero existe");
        }else{
            System.out.println("El fichero NO existe");
        }
        
    }
    
}
