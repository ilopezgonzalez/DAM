/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejercicio1_3_processbuilder_ping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author damt209
 */
public class PSP_ejercicio1_3_ProcessBuilder_Ping {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Process p = null;
        String[] comando = {"cmd", "/c", "ping", args[0]};
        InputStream is;
        InputStreamReader isr;
        BufferedReader bfr;
        //OutputStreamWriter osw;
        FileOutputStream fos;
        int exitValue = -1;

        try {
            p = new ProcessBuilder(comando).start();
        } catch (IOException e) {
            System.out.println("Error al ejecuar el comando: " + comando);
            e.printStackTrace();
            System.exit(-1);
        }
        String nombreFichero = args[1];
        File f = new File(nombreFichero);
        is = p.getInputStream();
        isr = new InputStreamReader(is);
        bfr = new BufferedReader(isr);
        fos = new FileOutputStream(f);

        try (OutputStreamWriter osw=new OutputStreamWriter(fos)){

            String line = bfr.readLine();
            while (line != null) {
                osw.write(line);
                osw.write(System.lineSeparator());
                line = bfr.readLine();
            }
            osw.close();
        } catch (IOException ex) {
            System.out.println("Error de lectura");
            ex.printStackTrace();
        }
    
        fos.close();
        bfr.close();
        isr.close();
        is.close();
    }

}
