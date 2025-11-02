/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_convertirenmayusculas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ConvierteMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una palabra para convertirla a MAYUSCULAS:");
        String entrada = input.nextLine().trim();
        try {
            String[] comando = {"cmd", "/c", "convMayus.exe"};
            Process p = new ProcessBuilder(comando).start();

            try (OutputStream os = p.getOutputStream(); OutputStreamWriter osw = new OutputStreamWriter(os); BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(entrada);
                bw.newLine();
                bw.flush();
                InputStream is = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String salida = br.readLine();
                System.out.println("Salida proceso hijo: " + salida);

            } catch (IOException e) {
            }
        } catch (IOException e) {
        }

    }

}
