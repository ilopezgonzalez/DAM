/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicios1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ASUS
 */
public class AD_6LeerFicheroConfiguracion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Método en java que lea las propiedades de un fichero de configuracion.*/
        
        leerPropiedades();
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
