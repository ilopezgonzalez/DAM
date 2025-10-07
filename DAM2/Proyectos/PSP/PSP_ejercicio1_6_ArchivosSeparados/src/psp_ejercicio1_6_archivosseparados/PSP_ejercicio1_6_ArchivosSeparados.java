/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejercicio1_6_archivosseparados;

import java.io.BufferedReader;
import java.io.File;
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
public class PSP_ejercicio1_6_ArchivosSeparados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String[] comando = {"CMD", "/C", "VERr"};
        File fileok=new File("ok.txt");
        File fileError=new File("error.txt");
        
        try {
            ProcessBuilder pb =new ProcessBuilder(comando);
            pb.redirectOutput(fileok).redirectError(fileError).start();
        } catch (Exception e) {
        }
        
        
        
        
    }
}
