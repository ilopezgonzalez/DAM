/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.prueba;

import com.sun.source.tree.BreakTree;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author damt209
 */
public class Ejercicio1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String[] comando = {"cmd", "/c", "copy", "fichero1.txt", "fichero2.txt"};
            System.out.println("Comienza el primer proceso...");
            System.out.println("-----------------------------");
            //Se crea el objeto de la clase ProcessBuilder al que se pasa el comando por parametro
            Process p1 = new ProcessBuilder(comando).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }

            System.out.println("...El primer proceso ha finalizado");
            System.out.println("-------------------------------");
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo");
        }

        try {
            String[] comando = {"cmd", "/c", "type", "fichero2.txt"};
            System.out.println("Comienza el segundo proceso...");
            System.out.println("-----------------------------");
            //Se crea el segundo proceso al que se pasa el nuevo parametro por comando
            Process p2 = new ProcessBuilder(comando).start();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);

                }

            } catch (IOException e) {
            }
            System.out.println("Valor de salida: " + p2.exitValue());
            System.out.println("Valor de salida waitfor:"+p2.waitFor());
        } catch (Exception e) {
        }
    }

}
