/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.ejemploserializable;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author cic
 */
public class Teclado {

    public static String pedirMarca() {
        String marca;
        do {//pedir marca
            System.out.println("Introduce marca:");
            marca = new Scanner(System.in).nextLine();
            //validar marca
        } while (!validarMarca(marca)); //no sale del bucle hasta que no sea válido la marca

        return marca; //devuelve marca
    }

    public static boolean validarMarca(String nombre) {

        if (!nombre.matches("[A-ZÑ][a-zñ ]{3,25}")) { //[A-ZÑ]: La cadena debe comenzar con una letra mayúscula (de la A a la Z o la Ñ).
            //[a-zñ ]{3,25}: Después, debe haber entre 4 y 25 caracteres, cada uno puede ser una letra minúscula (de la a a la z o la ñ) o un espacio.
            System.out.println("Nombre de la marca no es valido");
            return false;
        }
        return true;

    }

    public static double pedirVelocidad() {
        double velocidad = 0;
        boolean rep;
        do {//pedir velocidad
            rep = false;
            try {
                System.out.println("Introduce Velocidad: ");
                velocidad = new Scanner(System.in).nextDouble();
                if (velocidad < 0) {
                    System.out.println("La velocidad tiene que ser positiva");
                    rep = true;
                }
            } catch (InputMismatchException e) {
                rep = true;
                System.out.println("Tipo de dato erróneo, debe ser un numero");
            }

        } while (rep); //no sale del bucle hasta que no sea válido el valor de la velocidad
        return velocidad;
    }

    public static int pedirGasolina() {
        int gasolina = 0;
        boolean rep;
        Scanner teclado;
        do {//pedir introducir gasolina
            rep = false;
            try {
                System.out.println("Introduce gasolina: ");
                gasolina = new Scanner(System.in).nextInt();
                if (gasolina < 0) {
                    System.out.println("Los litros de gasolina tienen que ser mayor que cero");
                    rep = true;
                }
            } catch (InputMismatchException e) {
                rep = true;
                System.out.println("Tipo de dato erróneo, debe ser un numero");
            }

        } while (rep); //no sale del bucle hasta que no sea válido los litros de gasolina
        return gasolina;
    }
}
