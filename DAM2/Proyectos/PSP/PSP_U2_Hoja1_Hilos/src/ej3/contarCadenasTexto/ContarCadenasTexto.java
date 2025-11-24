/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3.contarCadenasTexto;

import java.util.Scanner;

/**
 *
 * @author ilopezgonzalez
 */
public class ContarCadenasTexto extends Thread {

    Scanner teclado = new Scanner(System.in);
    private int contador;

    public ContarCadenasTexto() {
    }

    public int getContador() {
        return contador;
    }
    

    public void run() {
        contador = 0;
        String lectura = "";
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe una linea, escribe FIN para finalizar:");
        while (!lectura.equals("FIN")) {
            lectura = teclado.nextLine();
            if (!lectura.equals("FIN")) {
                sb.append(lectura).append(System.lineSeparator());
                contador++;
            }
        }
    }
}
