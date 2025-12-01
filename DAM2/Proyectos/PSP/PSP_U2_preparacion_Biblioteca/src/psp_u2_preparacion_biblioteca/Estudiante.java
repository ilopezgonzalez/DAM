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
public class Estudiante extends Thread{

    private int id_estudiante;
    private Biblioteca biblioteca;

    public Estudiante(int id_estudiante, Biblioteca biblioteca) {
        this.id_estudiante = id_estudiante;
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        biblioteca.entrar(id_estudiante);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        biblioteca.salir(id_estudiante);
        

    }

    
}
