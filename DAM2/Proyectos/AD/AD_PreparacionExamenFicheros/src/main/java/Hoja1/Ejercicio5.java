/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja1;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        escribirPropiedades();
        
    }
    
    public static void escribirPropiedades(){
        Properties props=new Properties();
        props.setProperty("USER", "administrador");
        props.setProperty("PASSW", "Admin-123");
        props.setProperty("SERVER", "localhost");
        props.setProperty("PORT", "3306");
        try (FileOutputStream fos=new FileOutputStream("bd.properties")){
            props.store(fos, "Parametros de conexion a la BBDD");
            System.out.println("Archivo creado de manera correcta");
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo de configuracion");
        }
    }
    
}
