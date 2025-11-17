/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_hoja2_3_programagui_destroy;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

/**
 *
 * @author damt209
 */
public class PSP_hoja2_3_ProgramaGUI_destroy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File salida = new File("salida.txt");
        File error = new File("error.txt");

        String[] comando = {"calc.exe"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        Process p = null;

        pb.redirectOutput(salida);
        pb.redirectError(error);

        try {
            p = pb.start();
            System.out.println(p.pid());
            System.out.println(LocalTime.now() + " - Comienza proceso y se esperan 5 segundos");
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comnado: " + comando);
            e.printStackTrace();
        }

        try {
            Thread.sleep(5000); // 5 seg
            System.out.println(LocalTime.now() + " - Se lanza el destroy");
            p.destroy();
            if (p.isAlive()) {
                System.out.println(LocalTime.now() + " - Se lanza el destroyForcibly");
                p.destroyForcibly(); // Forzar si sigue vivo
                System.out.println("Proceso forzado a terminar (destroyForcibly).");
            }
            System.out.println(LocalTime.now() + " - Se lanza el p.waitFor y se esperan 5 segundos a que termine");
            p.waitFor(); // Esperar a que realmente termine
            Thread.sleep(5000); // 5 seg

        } catch (InterruptedException e) {
            System.out.println("Error al ejecutar el sleep");
            e.printStackTrace();
        }

        System.out.println(LocalTime.now() + " - Buenas noches amigo!");
    }
}
