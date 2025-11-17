/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejerciciosparaexamen_tareas1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author ASUS
 */
public class PSP_ejerciciosParaExamen_TAREAS1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Process p = null;
        String[] comando = {"cmd", "/c", "dir"};
        try {
            p = new ProcessBuilder(comando).start();
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando");
        }
        
        File f = new File(args[0]);
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        try {
            String line = br.readLine();
            while (line != null) {
                osw.write(line);
                osw.write(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }

    }

}
