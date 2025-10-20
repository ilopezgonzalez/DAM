/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebainicial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author damt209
 */
public class PSP_Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        try {
            ContarLetras cl = new ContarLetras();
            cl.contar(args[0], args[1]);
            String comando = "jar cf Libreria.jar -C build/classes .";
            Process proceso = Runtime.getRuntime().exec(comando);
            int resultado = proceso.waitFor();


        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

}
