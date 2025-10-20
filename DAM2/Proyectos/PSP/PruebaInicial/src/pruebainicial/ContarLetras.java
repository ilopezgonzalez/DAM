/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainicial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author damt209
 */
public class ContarLetras {

    private int contador;

    public ContarLetras() {
    }

    public int contar(String letra, String rutaFichero){
        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaFichero));
            int caracter;

            while ((caracter = lector.read()) != -1) {
                if ((char)caracter == letra.charAt(0)) {
                    contador++;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contador;
    }
}
