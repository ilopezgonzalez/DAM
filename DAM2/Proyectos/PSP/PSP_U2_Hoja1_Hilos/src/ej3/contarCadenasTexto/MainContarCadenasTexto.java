/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej3.contarCadenasTexto;

/**
 *
 * @author ilopezgonzalez
 */
public class MainContarCadenasTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador=0;
        ContarCadenasTexto[] arrayHilos=new ContarCadenasTexto[10];
        try {
            for (int i = 0; i < 10; i++) {
                arrayHilos[i]=new ContarCadenasTexto();
                arrayHilos[i].start();
            }
            for (ContarCadenasTexto hilo : arrayHilos) {
                hilo.join();
            }
            
            for (int i = 0; i < 10; i++) {
                System.out.println("EL hilo nº "+i+" contó "+arrayHilos[i].getContador());
                contador+=arrayHilos[i].getContador();
            }
            System.out.println("El total de lineas contadas es "+contador);
            
        } catch (Exception e) {
        }
    }
    
}
