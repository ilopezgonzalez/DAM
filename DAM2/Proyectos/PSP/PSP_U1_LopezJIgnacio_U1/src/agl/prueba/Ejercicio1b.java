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
public class Ejercicio1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] comando1={"cmd", "/c", "copy", "fichero1.txt", "fichero2.txt"};
        String[] comando2={"cmd", "/c", "type", "fichero2.txt"};
        
        ejecutaProceso(comando1);
        ejecutaProceso(comando2);
        
        
    }
    
    public static void ejecutaProceso (String[] comando){
        try {
            System.out.println("Comienza el proceso...");
            System.out.println("-----------------------------");
            //Se crea el objeto de la clase ProcessBuilder al que se pasa el comando por parametro
            Process p1=new ProcessBuilder(comando).start(); 
            BufferedReader br=new BufferedReader(new InputStreamReader(p1.getInputStream()));
            System.out.println(br.readLine());
            

            System.out.println("...El proceso ha finalizado");
            System.out.println("-------------------------------");
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo");
        }
    
    }
    
}

    
    

