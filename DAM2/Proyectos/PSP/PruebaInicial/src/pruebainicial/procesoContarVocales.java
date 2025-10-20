/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainicial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author damt209
 */
public class procesoContarVocales {

    public static void main(String[] args) {
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};

        int sumatorio = 0;
        for (char vocal : vocales) {
            try {
                String[] comando = {"java", "-jar", String.valueOf(vocal), "Libreria.jar"};
                ProcessBuilder pb = new ProcessBuilder(comando);
                Process p = pb.start();
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String linea;
                int contador = 0;
                if ((linea = br.readLine()) != null) {
                    contador = Integer.parseInt(linea.trim());
                }
                p.waitFor();
                System.out.println("Vocal " + vocal + ":" + contador);
                sumatorio += contador;

            } catch (IOException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("El total de vocale es: "+sumatorio);
    }

}
