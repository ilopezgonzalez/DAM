/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_preparacion_biblioteca;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class Biblioteca {
    
    int[] sillas= {0,0,0,0,0};

    public Biblioteca() {
    }
    
    public synchronized boolean lleno(){
        int contadorSillas=0;
        for (int silla : sillas) {
            if (silla!=0) {
                contadorSillas++;
            }
        }
        if (contadorSillas==5) {
            return true;
        }else{
            return false;
        }
    }
    
    public synchronized int sillaLibre(){
        for (int i = 0; i < sillas.length; i++) {
            if (sillas[i]==0) {
                return i;
            }
        }
        return -1;
    }
    
    public synchronized void entrar(int id){
        while (lleno()) {
            System.out.println("El alumno "+id+" no ha podido sentarse en la biblioteca por no haber sillas libres.");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int numSillaLibre=sillaLibre();
        if (numSillaLibre>=0) {
            sillas[numSillaLibre]=id;
            System.out.println("El alumno "+id+" se ha sentado en la silla "+numSillaLibre);
        }
    
    }
    
    public synchronized void salir(int id){
        for (int i = 0; i < sillas.length; i++) {
            if (sillas[i]==id) {
                sillas[i]=0;
                notifyAll();
                break;
            }
        }
    }
    
}
