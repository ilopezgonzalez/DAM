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

        try {
            String comando = "jar cf Libreria.jar -C build/classes .";
            Process proceso = Runtime.getRuntime().exec(comando);
            int resultado = proceso.waitFor();

            if (resultado == 0) { //waitfor devuelve 0 si se ejecuta con exito
                System.out.println("JAR generado correctamente");
            } else {
                System.out.println("Error al generar el JAR");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
