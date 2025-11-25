/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_hoja2_ejercicio5_relevos;

/**
 *
 * @author ilopezgonzalez
 */
public class Main_Relevos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se crea un objeto testigo para poder pasarlo por parametro
        Object testigo=new Object();
        //Se crean los corredores, se les pasa por parametro su numero y el objeto testigo
        Corredor corredor1=new Corredor(1, testigo);
        Corredor corredor2=new Corredor(2, testigo);
        Corredor corredor3=new Corredor(3, testigo);
        Corredor corredor4=new Corredor(4, testigo);
        //Se inician los hilos
        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        //Se sincroniza el objeto y se notifica para que arranque
        synchronized (testigo) {
            testigo.notify();
        }
        
    }
    
}
