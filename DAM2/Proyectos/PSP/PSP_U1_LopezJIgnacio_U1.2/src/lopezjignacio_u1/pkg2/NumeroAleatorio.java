/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lopezjignacio_u1.pkg2;

import java.util.Random;

public class NumeroAleatorio {

    public static void main(String[] args) {
        Random random = new Random();
        int numero = random.nextInt(101); // genera número entre 0 y 100 inclusive
        //System.out.println("Número aleatorio generado: " + numero);
        System.out.println(numero);
    }

}
