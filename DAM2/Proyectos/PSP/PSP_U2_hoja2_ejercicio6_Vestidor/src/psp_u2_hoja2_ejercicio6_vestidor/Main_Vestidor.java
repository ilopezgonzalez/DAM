/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_hoja2_ejercicio6_vestidor;

import java.util.ArrayList;

/**
 *
 * @author ilopezgonzalez
 */
public class Main_Vestidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        RecursoVestidor vestidor = new RecursoVestidor();
        ArrayList<HiloPersona> personas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            personas.add(new HiloPersona(i+1, vestidor));
        }

        for (HiloPersona persona : personas) {
            persona.start();
        }

    }

}
