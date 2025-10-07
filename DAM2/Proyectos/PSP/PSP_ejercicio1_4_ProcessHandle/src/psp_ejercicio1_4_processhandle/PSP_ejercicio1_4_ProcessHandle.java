/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejercicio1_4_processhandle;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 *
 * @author damt209
 */
public class PSP_ejercicio1_4_ProcessHandle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        String[] comando = {"calc.exe"};
        Process p;

        try {
            p = rt.exec(comando);
            ProcessHandle ph = p.toHandle();
            System.out.println("");
            // Clase Optional con el método ifPresent
            ph.info().command().ifPresent(comand -> System.out.println("Comando: " + comand));
            ph.info().arguments().ifPresent(arg->System.out.println("Argumentos: "+arg)); //Al estar los argumentos vacios no lo imprime
            ph.info().startInstant().ifPresent(tiempo->System.out.println("Tiempo inicio: "+tiempo));
            ph.info().totalCpuDuration().ifPresent(cpu->System.out.println("Tiempo CPU: "+cpu));
            ph.info().user().ifPresent(usuario->System.out.println("Propietario: "+usuario));
            System.out.println("Numero de hijos: "+ph.children().count());
            // Clase Optional sin considerar si el valor existe o no
            System.out.println("\nDATOS SIN CONFIRMAR SI ESTA PRESENTE");
            System.out.println("Comando: " + ph.info().command());
            System.out.println("Argumentos: " + ph.info().arguments());
            System.out.println("Tiempo inicio: " + ph.info().startInstant());
            System.out.println("Tiempo CPU: " + ph.info().totalCpuDuration());
            System.out.println("Propietario: " + ph.info().user());
            System.out.println("Numero de hijos: " + ph.children().count());
            
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando: " + comando);
            e.printStackTrace();
        }

    }

}
