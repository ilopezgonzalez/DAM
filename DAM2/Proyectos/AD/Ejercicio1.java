/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Comprobar que un fichero existe o no
        
//        File f = new File("D:\\Users\\damt209\\Desktop\\nuevoFichero.txt");
//        if (f.exists()) {
//            System.out.println("El fichero ya existe");
//        }else{
//            System.out.println("El fichero no existe");
//        }
////        
////        //Crear un fichero y comprobar si ya existe
////        
//        File fl = new File ("prueba.txt");
//        if (!fl.exists()) {
//            try {
//                if (fl.createNewFile()) {
//                    System.out.println("El fichero se ha creado");
//                }else{
//                    System.out.println("El fichero no se ha podido crear");
//                }
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        
//        //Buscar un fichero en una ruta determinada y sacar por pantalla su nombre, su ruta de acceso, si es de lectura, si es de escritura y su tamaño.
//        
//        File file = new File ("D:\\Users\\damt209\\Desktop\\nuevoFichero.txt");
//        if (file.exists()){
//            System.out.println("Nombre del archivo: "+file.getName());
//            System.out.println("Ruta del archivo: "+file.getPath());
//            System.out.println("Es de lectura: "+file.canRead());
//            System.out.println("Es de escritura: "+file.canRead());
//            System.out.println("Tamano: "+file.getTotalSpace());
//        }
//        
        
        
        solicitar();
        
        
     
        
        
    }
        //Crear un metodo que solicita al usuario una ruta de un directorio, y muestra por pantalla
        //los ficheros de ese directorio y los subidirectorios del mismo.
    
     public static void solicitar(){
         System.out.println("Introduce el directorio a analizar: ");
         Scanner input= new Scanner (System.in);
         String directorio= input.nextLine();
         
         File file1= new File(directorio);
         if (file1.exists()) {
             file1.getName();
         }
         
         
         
         
        }
    
}
