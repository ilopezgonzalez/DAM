/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_hoja2_3_1000ping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalTime;

/**
 *
 * @author damt209
 */
public class PSP_hoja2_3_1000PING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
        Process p;
        String[] comando = {"ping", "localhost", "-n", "1000"};
        File f = new File("fichero.txt");
        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            p = pb.redirectOutput(f).start();
            long pid = p.pid();
            System.out.println(LocalTime.now() + " - Comienza el proceso y se esperan 10 segundos");
            Thread.sleep(10000);
            System.out.println(LocalTime.now() + " - Se lanza destroy");
            p.destroy();
            if (p.isAlive()) {
                System.out.println(LocalTime.now() + "Sigue funcionando, usaremos taskkill");
                new ProcessBuilder("taskkill", "/PID", String.valueOf(pid), "/F")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
            System.out.println(LocalTime.now() + " - Se lanza waitfor() y se esperan 5 segundos a que termine");
            p.waitFor();
            Thread.sleep(5000);
            System.out.println(LocalTime.now() + " - Buenas noches amigo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

