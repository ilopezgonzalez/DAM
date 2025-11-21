/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja1;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio4 {
    
    /**
     * @param args the command line arguments
     */
    
    private static String directorio;
    
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un directorio a buscar:");
        directorio = teclado.nextLine();
        Path ruta=Paths.get(directorio);
<<<<<<< HEAD
        //mostrarArchivos(ruta);
        
=======
        mostrarArchivos(ruta);
>>>>>>> f4b9f29c156cb4c06f4f7fdc7e2426dc76a23d25
        

    }
    
    public static void mostrarArchivos(Path ruta){
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(ruta);
            for (Path p : directoryStream) {
                if (!Files.isDirectory(p)) {
                    System.out.println(p.getFileName());
                }else{
                    mostrarArchivos(p);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    
    public static void listarDirectorios(File dir){
        File[] lista=dir.listFiles();//array que recoge los files del objeto directorio que se le ha pasado
        if (lista!=null) {//Si el diretorio esta vacio devuelve null.
            for (File file : lista) {
                if (file.isDirectory()) {
                    System.out.println("[Fichero]"+file.getAbsolutePath());
                    listarDirectorios(file);
                }else{
                    System.out.println("[Fichero]"+file.getAbsolutePath());
                }
            }
            
        }
    }

}
