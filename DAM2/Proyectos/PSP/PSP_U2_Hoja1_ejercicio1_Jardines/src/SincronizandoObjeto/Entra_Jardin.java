/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SincronizandoObjeto;

import SincronizandoMetodo.*;

/**
 *
 * @author damt209
 */
public class Entra_Jardin extends Thread {

    private Recurso_Jardin jardin;

    public Entra_Jardin(String nombre, Recurso_Jardin jardin) {
        this.setName(nombre);
        this.jardin = jardin;
    }

    @Override
    public void run() {
        //Bloquea sincronizando el objeto jardin
        synchronized (jardin) {
            //Ejecutar el programa es lo mismo que lanzar un hilo dentro del jardin
            jardin.incrementaCuenta();
        }
    }
}
