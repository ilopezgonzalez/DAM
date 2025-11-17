/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_hoja2_2_programapadreespera_hijo;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author damt209
 */
public class PSP_hoja2_2_programaPadreEspera_hijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] comando = {"notepad.exe"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        Process p = pb.start();
        p.waitFor();//El programa padre espera a que termine el programa hijo
        for (int i = 0; i < 10; i++) {
            int aleatorio = new Random().nextInt(0, 101);
            System.out.println(aleatorio);
            Thread.sleep(500);
        }
        
    }
    
}
