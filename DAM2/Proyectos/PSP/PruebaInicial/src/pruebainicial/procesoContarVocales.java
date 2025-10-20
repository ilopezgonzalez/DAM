/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainicial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author damt209
 */
public class procesoContarVocales {

    public static void main(String[] args) {

        String[] comando = {"java -jar D:\\Users\\damt209\\Desktop\\Repo\\DAM\\DAM2\\Proyectos\\PSP\\PruebInicial\\Libreria.jar"};
        int sumatorio=0;
        try {
            for (int i = 0; i < 5; i++) {
                ProcessBuilder pb = new ProcessBuilder(comando);
                Process p = pb.start();
                InputStream is= p.getInputStream();
                InputStreamReader isr=new InputStreamReader(is);
                BufferedReader br= new BufferedReader(isr);
                int cantidad=Integer.parseInt(br.readLine());
                sumatorio+=cantidad;
                p.waitFor();
                
                
            }
            System.out.println(sumatorio);
        } catch (Exception e) {
        }

    }

}
