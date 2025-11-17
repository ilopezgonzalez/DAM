/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author damt209
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String linea="";
        try {
            String[] comando = {"java", "-jar", "D:\\Users\\damt209\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\PSP\\LopezJIgnacio_U1.2\\dist\\LopezJIgnacio_U1.2.jar"};
            
            Process proceso = new ProcessBuilder(comando).start();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                
                while ((linea = br.readLine()) != null) { // leer línea por línea
                    System.out.println(linea.trim()); // mostrar en consola 
                }
            }

        } catch (IOException e) {
            System.out.println("No se encuentra el archivo");
        }

        try {
            String[] comando1 = {"java", "-jar", "D:\\Users\\damt209\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\PSP\\LopezJIgnacio_U1.3\\dist\\LopezJIgnacio_U1.3.jar", linea};
            Process proceso1=new ProcessBuilder(comando1).start();
            
             try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso1.getInputStream()))) {
                
                while ((linea = br.readLine()) != null) { // leer línea por línea
                    System.out.println(linea.trim()); // mostrar en consola 
                }
            }
        } catch (IOException e) {
            System.out.println("No se encuentra el segundo archivo");
        }

    }

}
