/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicios1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class AD_2ComprobarFicheroExiste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Crear un fichero y comprobar si ya existe

        
        File fl = new File ("prueba.txt");
        if (!fl.exists()) {
            try {
                if (fl.createNewFile()) {
                    System.out.println("El fichero se ha creado");
                }else{
                    System.out.println("El fichero no se ha podido crear");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("El fichero ya estaba creado.");
        }
    }
    
}
