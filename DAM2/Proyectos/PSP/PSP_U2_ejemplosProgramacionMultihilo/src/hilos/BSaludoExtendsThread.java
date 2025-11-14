/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;


public class BSaludoExtendsThread extends Thread {

    //clase  que extiende a Thread
    @Override
    public void run() {
        // se redefine el método run() con el código asociado al hilo
        System.out.println("¡Saludo desde un hilo extendiendo thread!");
    }

    public static void main(String args[]) {
        BSaludoExtendsThread hilo1 = new BSaludoExtendsThread();
        //se crea un objeto Thread, el hilo hilo1
        hilo1.start();
        //invoca a start() y pone en marcha el hilo hilo1
    }

}
