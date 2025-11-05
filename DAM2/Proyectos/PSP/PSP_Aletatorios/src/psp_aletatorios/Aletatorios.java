 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_aletatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class Aletatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Devuelve la ruta donde se ejecuta el java y ahi se deja el ejecutable
        //System.out.println(System.getProperty("user.dir"));
       Scanner sc = new Scanner(System.in);
        String entrada;

        System.out.println("Teclea cualquier letra para generar un número aleatorio.");
        System.out.println("Escribe 'fin' para terminar.");

        while (true) {
            System.out.print("Introduce una letra, introduce fin para finalizar ");
            entrada = sc.nextLine().trim();

            // Si el usuario escribe "fin", se termina
            if (entrada.equalsIgnoreCase("fin")) {
                System.out.println("Finalizando programa...");
                break;
            }

            // Si el usuario teclea cualquier otra cosa, lanzamos el ejecutable
            try {
                // Comando para ejecutar el hijo
                String[] comando = {"cmd", "/c", "aleatorio.exe"};
                Process proceso = new ProcessBuilder(comando).start();

                // Leemos la salida del hijo
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream()));

                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Programa hijo: " + linea);
                }

                // Esperamos a que el proceso termine
                proceso.waitFor();

            } catch (IOException e) {
                System.err.println("Error al ejecutar el proceso hijo: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Ejecución interrumpida: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

}
