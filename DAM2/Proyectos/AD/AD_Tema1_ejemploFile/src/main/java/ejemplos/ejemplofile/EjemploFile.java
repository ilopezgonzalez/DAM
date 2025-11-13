/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejemplos.ejemplofile;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author cic
 */
public class EjemploFile {

   public static void main(String[] args) {

        //EJEMPLO 1: Comprobar existencia de un fichero por su Path.
        File f = new File("E:\\Documents\\prueba.txt");
        if (f.exists()) {
            System.out.println("El fichero existe");
        } else {
            System.out.println("El fichero no existe");
        }
        //EJEMPLO 2: Crear fichero, si no existe, en carpeta de trabajo actual
        File f1 = new File("prueba.txt");
        if (!f1.exists()) {
            try {
                // nos obliga a realizar un try catch recogiendo la posible excepción
                if (f1.createNewFile()) {
                    System.out.println("el fichero ha sido creado");
                } else {
                    System.out.println("el fichero no se ha podido crear");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        /*EJEMPLO 3: Comprobar el tipo de elemento que corresponde al Path ruta*/
        if (!f1.isFile()) {
            if (f1.isDirectory()) {
                System.out.println("No es un fichero es un directorio");
            }
        }
        else{
            System.out.println("Es un fichero");
        }
        
        /*EJEMPLO 4: Comprobar permiso de escritura*/
        if (f1.canWrite()) {
            System.out.println("En el fichero se puede escribir");
        } else {
            System.out.println("No se puede escribir");
        }

    }
}
