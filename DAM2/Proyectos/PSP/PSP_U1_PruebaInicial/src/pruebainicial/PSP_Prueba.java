/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebainicial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class PSP_Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){

        try {
            ContarLetras cl = new ContarLetras();
            cl.contar(args[0], args[1]);
            String comando = "jar cf Libreria.jar -C build/classes .";
            Process proceso = Runtime.getRuntime().exec(comando);
            int resultado = proceso.waitFor();


        } catch (IOException e) {
            System.out.println(e.getMessage());

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
