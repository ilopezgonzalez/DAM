/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_hoja2_ejercicio5_relevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class Corredor extends Thread {

    private int id;
    //Objeto compartido
    private Object testigo;
    //Constructor con los dos atributos
    public Corredor(int id, Object testigo) {
        this.id = id;
        this.testigo = testigo;
    }
    
    
    //Metodo que sobreescribe el run del hilo
    @Override
    public void run() {
        //Se sincroniza el objeto compartido testigo ¡¡¡SIEMPRE EL OBJETO!!!
        synchronized (testigo) {
            try {
                System.out.println("El corredor " + id + " llega a la salida");
                //Se hace esperar al testigo
                testigo.wait();
                System.out.println("El corredor " + id + " sale");
                Thread.sleep(2000);
                System.out.println("El corredor " + id + " llega");
                System.out.println("El corredor " + id + " pasa el relevo");
                //El testigo notifica al siguiente hilo que puede continuar.
                testigo.notify();

            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
