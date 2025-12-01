/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_preparacion_cajero;

/**
 *
 * @author ilopezgonzalez
 */
public class Cuenta {

    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void realizarOperacion(int id, int cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
            System.out.println("El cliente "+id+" ingresa " + cantidad + " euros. El saldo actual es: " + saldo);
        } else {
            if ((saldo + cantidad) > 0) {
                saldo = saldo + cantidad;
                System.out.println("El cliente "+id+" retira " + -cantidad + " euros. El saldo actual es: " + saldo);
            } else {
                System.out.println("Operacion rechazada no se pueden retirar " + cantidad + " porque el saldo es insuficiente.");
            }
        }
    }

}
