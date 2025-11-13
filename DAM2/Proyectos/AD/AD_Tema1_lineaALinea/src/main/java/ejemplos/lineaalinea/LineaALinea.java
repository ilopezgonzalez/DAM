/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejemplos.lineaalinea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cic
 */
public class LineaALinea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File fichero = new File("mifichero.txt");
        System.out.println("creando el fichero ");
        escribirLineaALinea(fichero);
        System.out.println("leyendo el fichero creado");
        leerLineaALinea(fichero);

    }

    public static void escribirLineaALinea(File fichero) {
        String frase;
        Scanner e = new Scanner(System.in);
        System.out.println("introduce la información que quieres grabar en el fichero");
        frase = e.nextLine();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fichero, true));) {
            br.write(frase);
            br.newLine();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
    // el final de la lectura lo detecta cuando es nulo

    public static void leerLineaALinea(File fichero) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(fichero));) {

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
}
