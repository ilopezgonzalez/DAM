/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hoja1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ilopezgonzalez
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (FileInputStream fis=new FileInputStream("bd.properties")){
            Properties props=new Properties();
            props.load(fis);
            String usuario=props.getProperty("USER");
            String pass=props.getProperty("PASSW");
            String server=props.getProperty("SERVER");
            int port=Integer.parseInt(props.getProperty("PORT"));
            System.out.println("Usuario: "+usuario);
            System.out.println("Password: "+pass);
            System.out.println("Server: "+server);
            System.out.println("Puerto: "+port);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de propiedades");
        }
    }
    
}
