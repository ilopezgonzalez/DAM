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
public class Sale_Jardin extends Thread{
    
    private Recurso_Jardin jardin;

    public Sale_Jardin(String nombre, Recurso_Jardin jardin) {
        this.setName(nombre);
        this.jardin = jardin;
    }
    
    @Override
    public void run(){
        jardin.decrementaCuenta();
    }
        
    
    
    
}
