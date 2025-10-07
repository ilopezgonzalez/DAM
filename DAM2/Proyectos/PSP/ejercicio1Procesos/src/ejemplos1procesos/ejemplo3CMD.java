/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos1procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author damt209
 */
public class ejemplo3CMD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Process p = null;
        String[] comando = {"CMD", "/C", "VER"};
        InputStream is;
        InputStreamReader isr;
        BufferedReader bfr;
        int exitValue = -1;

        try {
            p = new ProcessBuilder(comando).start();
        } catch (IOException e) {
            System.out.println("Error al ejecuar el comando: " + comando);
            e.printStackTrace();
            System.exit(-1);
        }
        is = p.getInputStream();
        /*Lee el stream de salida del proceso
             para poder usar el metodo readline() se necesita un objeto bufferedReader*/
        isr = new InputStreamReader(is);
        bfr = new BufferedReader(isr);
        try {
            String line = bfr.readLine();
            while (line != null) {
                System.out.println(line);
                line = bfr.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura");
            ex.printStackTrace();
        }
        bfr.close();
        /*waitfor() hace esperar al proceso actual hasta que el subproceso
                representado por el objeto p termine. devuelve 0 si termina bien y
                el valor 1 si termina mal
         */
        try {
            exitValue = p.waitFor();
            System.out.println("Salida (0=bien y 1=mal):" + exitValue);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
        

    }

}

