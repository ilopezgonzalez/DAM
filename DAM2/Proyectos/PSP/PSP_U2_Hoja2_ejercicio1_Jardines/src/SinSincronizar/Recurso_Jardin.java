/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SinSincronizar;

import SincronizandoMetodo.*;

/**
 *
 * @author damt209
 */
public class Recurso_Jardin {

    //Clase que simula las entradas y salidas del jardin.
    private int cuenta;

    public Recurso_Jardin() {
        //Inicialmente hay 100 personas en el jardin
        this.cuenta = 100;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public void incrementaCuenta() {
        //Bloque el metodo por llevarsynchronized.
        //Metodo que incremente los hilos dentro del jardin.
        //Imprime el nombre del hilo.
        System.out.println("--------------------------------------------");
        System.out.println("Hilo " + Thread.currentThread().getName() + " ---Entra al jardin");
        //Aumenta en 1 la cantidad de hilos que hay dentro del jardin.
        cuenta++;
        //Imprime el nombre del hilo y da una cuenta de todos los que ha dentro del jardin.
        System.out.println("Hilo " + Thread.currentThread().getName() + " Hay " + cuenta + " en total en el jardin");
        System.out.println("--------------------------------------------");
    }

    public void decrementaCuenta() {
        //Bloque el metodo por llevarsynchronized.
        //Metodo que decrementa le numero de hilos en el jardin.
        //Imprime el nombre del hilo.
        System.out.println("--------------------------------------------");
        System.out.println("Hilo " + Thread.currentThread().getName() + " ---Sale del jardin");
        cuenta--;
        System.out.println("Hilo " + Thread.currentThread().getName() + " Hay " + cuenta + " en total en el jardin");
        System.out.println("--------------------------------------------");
    }

}
