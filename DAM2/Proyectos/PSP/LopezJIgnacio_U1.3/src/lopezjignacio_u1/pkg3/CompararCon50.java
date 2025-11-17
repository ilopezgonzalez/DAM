/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lopezjignacio_u1.pkg3;

public class CompararCon50 {

    public static void main(String[] args) {
        
        String numeroEntrada;
        if (args.length == 0) 
            numeroEntrada = "13";        
        else
            numeroEntrada = args[0];
        if (args.length != 1) {
            System.out.println("Es necesario pasar un argumento entero");
            System.out.println("Sin argumentos se ejecuta con un valor fijo " + numeroEntrada);
        }

        try {
            int numero = Integer.parseInt(numeroEntrada);

            if (numero > 50) {
                System.out.println("El número es mayor que 50.");
            } else if (numero < 50) {
                System.out.println("El número es menor que 50.");
            } else {
                System.out.println("El número es igual a 50.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: el argumento debe ser un número entero.");
        }
    }
}
