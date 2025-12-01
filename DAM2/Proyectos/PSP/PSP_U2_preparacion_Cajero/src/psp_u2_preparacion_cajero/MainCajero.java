/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_preparacion_cajero;

import java.util.ArrayList;

/**
 *
 * @author ilopezgonzalez
 */
public class MainCajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Si se quiere sobre una sola cuenta se deja aqui el constructor de la cuenta
        Cuenta cuenta = new Cuenta(200);
        ArrayList<HiloCliente> clientes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            //Si se quiere que cada cliente tenga su propia cuenta se crea la cuenta en el bucle.
//            Cuenta cuenta = new Cuenta(200);
            clientes.add(new HiloCliente(i, cuenta));
        }

        for (HiloCliente cliente : clientes) {
            cliente.start();
        }

    }

}
