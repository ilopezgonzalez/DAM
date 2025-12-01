/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_preparacion_boxlavado;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class Taller {
    
    int[] boxes= {0, 0};

    public Taller() {
    }
    
    public boolean lleno(){
        int contador_box=0;
        for (int box : boxes) {
            if (box!=0) {
                contador_box++;
            }
        }
        if (contador_box==2) {
            return true;
        }else{
            return false;
        }
    }
    
    public int boxLibre(){
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i]==0) {
                return i;
            }
            
        }
        return -1;
    }
    
    public synchronized void entrar(int id){
        while (lleno()) {
            System.out.println("El coche "+id+" tiene que esperar porque todos los boxes estan ocupados.");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Taller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int numBox=boxLibre();
        if (numBox>=0) {
            boxes[numBox]=id;
            System.out.println("El coche "+id+" entra en el box "+numBox);
        }
    }
    
    public synchronized void salir(int id){
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i]==id) {
                boxes[i]=0;
                notifyAll();
                break;
            }
            
        }
    
    }
    
}
