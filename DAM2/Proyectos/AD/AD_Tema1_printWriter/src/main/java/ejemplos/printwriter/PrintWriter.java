/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejemplos.printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author cic
 */
public class PrintWriter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File fichero = new File("mifichero.txt");
        try ( java.io.PrintWriter salida= new java.io.PrintWriter(fichero); ) {
            String cadena;
            System.out.println("Introduce texto: para finalizar teclea FIN");
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }
            salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } 
    }
}