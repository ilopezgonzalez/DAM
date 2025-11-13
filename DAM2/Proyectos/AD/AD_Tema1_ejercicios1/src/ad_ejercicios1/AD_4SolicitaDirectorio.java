/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicios1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class AD_4SolicitaDirectorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    /*Crear un metodo que solicita al usuario una ruta de un directorio, y muestra por pantalla
    los ficheros de ese directorio y los subidirectorios del mismo.*/
        
        solicitar();
    }
    public static void solicitar() {
        System.out.println("Introduce el directorio a analizar: ");
        Scanner input = new Scanner(System.in);
        String directorio = input.nextLine();

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directorio));
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }

        } catch (IOException ex) {
            System.err.println("Error");
        }
    }
}
