/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejercicio1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author damt209
 */
public class ejercicio2ProcessBuilderCMDdir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Process p=null;
        String[] comando={"CMD","/c", "dir"};
        InputStream is;
        InputStreamReader isr;
        BufferedReader bfr;
        OutputStreamWriter osw;
        FileOutputStream fos;
        int exitValue = -1;
        
        try {
            p = new ProcessBuilder(comando).start();
        } catch (IOException e) {
            System.out.println("Error al ejecuar el comando: " + comando);
            e.printStackTrace();
            System.exit(exitValue);
        }
        //String nombreFichero = args[0];
        File f=new File(args[0]);
        is = p.getInputStream();
        isr = new InputStreamReader(is);
        bfr = new BufferedReader(isr);
        fos= new FileOutputStream(f);
        osw= new OutputStreamWriter(fos);
        
        
        try {
            
            String line = bfr.readLine();
            while (line != null) {
                osw.write(line);
                osw.write(System.lineSeparator());
                line = bfr.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura");
            ex.printStackTrace();
        }
        osw.close();
        fos.close();
        bfr.close();
        isr.close();
        is.close();
        
        
        
        
        
    }
    
}

