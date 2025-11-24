/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1.sumaConcurrente;

/**
 *
 * @author ilopezgonzalez
 */
public class SumaPares extends Thread {
    
    private int contador;

    public SumaPares() {
        this.contador = 0;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            if (i%2==0) {
                contador+=i;
            }
            System.out.println("El contador de PARES tiene un valor de: "+contador);
        }
    }
    
    
    
}
