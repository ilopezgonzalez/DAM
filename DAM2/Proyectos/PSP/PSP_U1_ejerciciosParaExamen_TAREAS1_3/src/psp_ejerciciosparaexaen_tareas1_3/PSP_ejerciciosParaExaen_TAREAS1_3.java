/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejerciciosparaexaen_tareas1_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class PSP_ejerciciosParaExaen_TAREAS1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Process p = null;
        String[] comando = {"cmd", "/c", "ping", args[0]};
        try {
            p = new ProcessBuilder(comando).start();
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando");
        }

        File f = new File(args[1]);
        

        try (BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
                OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(f)))
        {
            String line = br.readLine();
            while (line != null) {
                osw.write(line);
                osw.write(System.lineSeparator());
                line = br.readLine();
            }
            p.waitFor();
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP_ejerciciosParaExaen_TAREAS1_3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}


