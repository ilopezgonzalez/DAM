/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File("miFichero2.txt");
        try {
            fichero.createNewFile();
            if (fichero.exists()) {
                System.out.println("El fichero se ha creado correctamente");
            }else{
                System.out.println("El fichero no se pudo crear");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
