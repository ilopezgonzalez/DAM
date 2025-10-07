/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejercicio1_5_entornoproceso;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class PSP_ejercicio1_5_EntornoProceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Introduce el comando de la aplicacion: ");
        String[] comando={input.nextLine()};
        try {
            //Se crea el processBuilder con el comando
            ProcessBuilder pb=new ProcessBuilder(comando);
            Process p=pb.start();
            //Se crea el mapa de clave valor con el entorno del processBuilder que devuelve el mapa
            Map<String, String> entorno=pb.environment();
            for (Map.Entry<String, String> entry : entorno.entrySet()) {
                System.out.println(entry.getKey()+" = "+entry.getValue());
            }
            
            System.out.println("Proceso lanzado con PID: "+p.pid());
           
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar el comando: "+e.getMessage());
        }
    }
    
}
