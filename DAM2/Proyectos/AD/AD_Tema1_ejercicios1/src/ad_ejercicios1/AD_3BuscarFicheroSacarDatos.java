/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicios1;

import java.io.File;

/**
 *
 * @author ASUS
 */
public class AD_3BuscarFicheroSacarDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Buscar un fichero en una ruta determinada y sacar por pantalla su nombre, su ruta de acceso, si es de lectura, si es de escritura y su tamaño.
        
        File file = new File ("D:\\Users\\damt209\\Desktop\\nuevoFichero.txt");
        if (file.exists()){
            System.out.println("Nombre del archivo: "+file.getName());
            System.out.println("Ruta del archivo: "+file.getPath());
            System.out.println("Es de lectura: "+file.canRead());
            System.out.println("Es de escritura: "+file.canRead());
            System.out.println("Tamano: "+file.getTotalSpace());
        }
    }
    
}
