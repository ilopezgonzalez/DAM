/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_hoja3_accesomultiplefichero;

import java.io.*;

/**
 *
 * @author usuario
 */
public class CrearMultiplesAccesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Process nuevoProceso; //Definimos una variable de tipo Process
        PrintStream ps = null;

        try {
            File fichero = new File("javalog.txt");
            FileOutputStream fos = new FileOutputStream(fichero, true);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ps = new PrintStream(bos);
            System.setOut(ps);
            System.setErr(ps);

            for (int i = 1; i < 11; i++) {
                // Corregir linea de comandos
                ProcessBuilder pb=new ProcessBuilder("java -jar "
                        + "AccesoMultipleFichero.jar " + i + " nuevo.txt");
//                nuevoProceso = Runtime.getRuntime().exec("java -jar "
//                        + "AccesoMultipleFichero.jar " + i + " nuevo.txt");
                //Creamos el nuevo proceso y le indicamos el número de orden y
                //el fichero que debe utilizar.
                System.out.println("Creado el proceso " + i);
                //Mostramos en consola que hemos creado otro proceso     
                pb.wait();
            }
        } catch (SecurityException ex) {
            System.err.println("Ha ocurrido un error de Seguridad."
                    + "No se ha podido crear el proceso por falta de permisos.");
        } catch (Exception ex) {
            System.err.println("Ha ocurrido un error, descripción: "
                    + ex.toString());
        } finally {
            if (ps != null) {
                ps.flush();
                ps.close();
            }

        }
    }

}
