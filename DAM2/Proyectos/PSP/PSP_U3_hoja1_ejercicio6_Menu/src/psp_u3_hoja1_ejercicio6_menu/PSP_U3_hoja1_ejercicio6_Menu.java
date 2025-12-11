/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja1_ejercicio6_menu;

import java.util.Scanner;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja1_ejercicio6_Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("""
                           Escoge una opcion:
                           1. Visualizar las direcciones IP del dispositivo.
                           2. Visualizar las direcciones IP de un dispositivo indicado por nombre.
                           3. Visualizar la direccion de loopback del dispositivo.
                           4. Visualizar la direccion IPv4 del dispositivo.
                           5. Visualizar la direccion IPv6 del dispositivo.
                           6. Visualizar el nombre del dispositivo y si IP.
                           7. Visualizar el nombre canónico de la maquina.
                           Opcion:
                           """);
        int opcion = Integer.parseInt(teclado.nextLine());

        while (true) {
            switch (opcion) {
                case 1:

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

}
