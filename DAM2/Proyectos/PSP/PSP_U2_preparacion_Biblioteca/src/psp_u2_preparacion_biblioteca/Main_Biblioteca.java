/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_preparacion_biblioteca;

import java.util.ArrayList;

/**
 *
 * @author ilopezgonzalez
 */
public class Main_Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Biblioteca biblioteca=new Biblioteca();
        ArrayList<Estudiante> estudiantes=new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            estudiantes.add(new Estudiante(i+1, biblioteca));
        }
        for (Estudiante estudiante : estudiantes) {
            estudiante.start();
        }
    }
    
}
