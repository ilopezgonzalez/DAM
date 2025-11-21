/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SincronizandoObjeto;

import SincronizandoMetodo.*;

/**
 *
 * @author damt209
 */
public class Main_Jardin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Recurso_Jardin jardin=new Recurso_Jardin();
        
        
        /*Hacemos entrar en el jardin 10 procesos mediante un for
        * cada uno se llamará desde 1 a 10
        */
        for (int i = 0; i < 10; i++) {
            (new Entra_Jardin("Entra "+i, jardin)).start();
        }
        
        /*Hacemos salir en el jardin 15 procesos mediante un for
        * cada uno se llamara desde 1 a 15
        */
        
        for (int i = 0; i < 15; i++) {
            (new Sale_Jardin("Sale "+i, jardin)).start();
        }
    }
    
}
