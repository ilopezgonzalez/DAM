/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_preparacion_cajero;

import java.util.Random;

/**
 *
 * @author ilopezgonzalez
 */
public class HiloCliente extends Thread {

    private int id_cliente;
    private Cuenta cuenta;

    public HiloCliente(int id_cliente, Cuenta cuenta) {
        this.id_cliente = id_cliente;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int numRandom = random.nextInt(2);
            int cantidadRandom = random.nextInt(1, 301);
            if (numRandom == 0) {
                cuenta.realizarOperacion(id_cliente, cantidadRandom);
            } else {
                cuenta.realizarOperacion(id_cliente, -cantidadRandom);
            }
        }

    }

}
