/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej4.contarCadenasTextoSincronizado;

/**
 *
 * @author ilopezgonzalez
 */
public class MainContarCadenasTextoSincronizado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador = 0;
        ContarCadenasTextoSincronizado[] arrayHilos = new ContarCadenasTextoSincronizado[10];
        try {
            for (int i = 0; i < 10; i++) {
                arrayHilos[i] = new ContarCadenasTextoSincronizado();
                arrayHilos[i].start();
                arrayHilos[i].join();

            }
            for (int i = 0; i < 10; i++) {
                System.out.println("EL hilo nº " + i + "contó " + arrayHilos[i].getContador());
                contador += arrayHilos[i].getContador();
            }
            System.out.println("El total de lineas contadas es " + contador);

        } catch (Exception e) {
        }
    }
}
