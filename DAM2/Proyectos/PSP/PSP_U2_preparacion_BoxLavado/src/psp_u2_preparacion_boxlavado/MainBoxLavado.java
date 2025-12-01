/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_preparacion_boxlavado;

import java.util.ArrayList;

/**
 *
 * @author ilopezgonzalez
 */
public class MainBoxLavado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Taller taller = new Taller();
        ArrayList<HiloCoche> coches = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            coches.add(new HiloCoche(i+1, taller));
        }

        for (HiloCoche coche : coches) {
            coche.start();
        }

    }

}
