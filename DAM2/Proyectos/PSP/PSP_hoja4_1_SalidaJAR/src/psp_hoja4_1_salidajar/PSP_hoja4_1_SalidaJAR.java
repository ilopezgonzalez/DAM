/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_hoja4_1_salidajar;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author damt209
 */
public class PSP_hoja4_1_SalidaJAR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int aleatorio = new Random().nextInt(0, 101);//Valores aleatorios del 0 al 100
            System.out.println(aleatorio);
        }


    }
}
