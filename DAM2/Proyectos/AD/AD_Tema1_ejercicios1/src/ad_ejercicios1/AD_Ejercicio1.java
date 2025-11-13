/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicios1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class AD_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        
//        //Comprobar que un fichero existe o no
//        
//        File f = new File("D:\\Users\\damt209\\Desktop\\nuevoFichero.txt");
//        if (f.exists()) {
//            System.out.println("El fichero ya existe");
//        }else{
//            System.out.println("El fichero no existe");
//        }
        //////        
//////        //Crear un fichero y comprobar si ya existe
//////        
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
////        
////        //Buscar un fichero en una ruta determinada y sacar por pantalla su nombre, su ruta de acceso, si es de lectura, si es de escritura y su tamaño.
////        
//        File file = new File ("D:\\Users\\damt209\\Desktop\\nuevoFichero.txt");
//        if (file.exists()){
//            System.out.println("Nombre del archivo: "+file.getName());
//            System.out.println("Ruta del archivo: "+file.getPath());
//            System.out.println("Es de lectura: "+file.canRead());
//            System.out.println("Es de escritura: "+file.canRead());
//            System.out.println("Tamano: "+file.getTotalSpace());
//        }
////        
//        
        //solicitar();
        //escribirConfiguracion();
        leerPropiedades();
    }
    //Crear un metodo que solicita al usuario una ruta de un directorio, y muestra por pantalla
    //los ficheros de ese directorio y los subidirectorios del mismo.

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

    public static void escribirConfiguracion() {
        Properties props=System.getProperties();
        props.setProperty("USER", "Adminitrador");
        props.setProperty("PASSW", "Admin-123");
        props.setProperty("SERVER", "localhost");
        props.setProperty("PORT", "3306");
        try (FileOutputStream out= new FileOutputStream("bd.properties")){
            props.store(out, "Parametros de conexion");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero de configuracion");
        }
        
    }
    
    public static void leerPropiedades(){
        try (FileInputStream in=new FileInputStream("bd.properties")){
            Properties props=new Properties();
            props.load(in);
            String usuario=props.getProperty("USER");
            String pass=props.getProperty("PASSW");
            String server=props.getProperty("SERVER");
            String port=props.getProperty("PORT");
            System.out.println("Usuario: "+usuario );
            System.out.println("Password: "+pass );
            System.out.println("Server: "+server );
            System.out.println("Port: "+port );
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de configuracion");
        }
        
    }
            

}
