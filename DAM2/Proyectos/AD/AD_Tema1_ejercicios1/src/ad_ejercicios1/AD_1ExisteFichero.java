/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicios1;

import java.io.File;

/**
 *
 * @author ASUS
 */
public class AD_1ExisteFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Comprobar si un fichero existe o no.
        
        File f = new File("D:\\Users\\damt209\\Desktop\\nuevoFichero.txt");
        if (f.exists()) {
            System.out.println("El fichero ya existe");
        } else {
            System.out.println("El fichero no existe");
        }
    }

}
