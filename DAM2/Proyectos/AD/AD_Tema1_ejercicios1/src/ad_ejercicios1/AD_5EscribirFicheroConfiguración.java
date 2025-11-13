/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicios1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ASUS
 */
public class AD_5EscribirFicheroConfiguración {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Método en java que escriba en un fichero de configuración que denominados bd.properties
        las propiedades de la clase System “properties” y añede los parámetros
        de conexión que figuran a continuación.
        USER = administrador
        PASSW = Admin-123
        SERVER = localhost
        PORT = 3306
        */
        
        escribirConfiguracion();
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
    
}
