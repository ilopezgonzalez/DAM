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

        // ------------------------------------------------------------
        // Comando que queremos ejecutar en Windows
        // ------------------------------------------------------------
        // NOTA: el comando "VERr" tiene un error a propósito. 
        // El comando correcto sería "ver". Aquí lo dejamos así para
        // que se pueda capturar en el fichero de errores.
        String[] comando = {"CMD", "/C", "VERr"};  

        // ------------------------------------------------------------
        // Ficheros donde se redirigirá la salida y los errores del proceso
        // ------------------------------------------------------------
        File fileok = new File("ok.txt");        // archivo para la salida estándar
        File fileError = new File("error.txt");  // archivo para la salida de errores

        try {
            // ------------------------------------------------------------
            // Crear el ProcessBuilder con el comando
            // ------------------------------------------------------------
            ProcessBuilder pb = new ProcessBuilder(comando);

            // ------------------------------------------------------------
            // Redirigir la salida estándar al fichero 'ok.txt'
            // y la salida de errores al fichero 'error.txt'
            // ------------------------------------------------------------
            pb.redirectOutput(fileok).redirectError(fileError).start();

            // NOTA: no se guarda la referencia del proceso. No usamos waitFor()
            //       ni leemos la salida en tiempo real. Solo redirigimos a ficheros.

        } catch (Exception e) {
            // ------------------------------------------------------------
            // Captura de cualquier excepción que pueda ocurrir al iniciar el proceso
            // ------------------------------------------------------------
            // En este caso el catch está vacío, pero en un programa real
            // conviene registrar el error.
        }
    }
}