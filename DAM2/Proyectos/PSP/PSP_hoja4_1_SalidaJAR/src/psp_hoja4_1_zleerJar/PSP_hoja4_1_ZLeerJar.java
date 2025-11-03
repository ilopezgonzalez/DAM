/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_hoja4_1_zleerJar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author damt209
 */
public class PSP_hoja4_1_ZLeerJar {

    public static void main(String[] args) throws InterruptedException {
        try {
            // Comando jar (asegúrate de que el JDK está en PATH)
            String comando = "java -jar D:\\Users\\damt209\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\DI\\PSP_hoja4_1_SalidaJAR\\Libreria.jar";
            Process proceso = Runtime.getRuntime().exec(comando);
            int resultado = proceso.waitFor();
            try (BufferedReader br= new BufferedReader(new InputStreamReader(proceso.getInputStream()))){
                String linea;
                while ((linea=br.readLine())!=null) {
                    System.out.println("[JAR]"+linea);
                }
                
            } catch (Exception e) {
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
