/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ejemplos.byteabyte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cic
 */
public class EjemploByteAByte {

    public static void main(String[] args) {
        File fichero = new File("mifichero.txt");
        System.out.println("creando el fichero ");
        escribirCaracteres(fichero);
        System.out.println("leyendo el fichero creado");
        leerCaracteres(fichero);

    }

    public static void escribirCaracteres(File fichero) {
        String frase;
        Scanner e = new Scanner(System.in);
        System.out.println("introduce la información que quieres grabar en el fichero");
        frase = e.nextLine();
        try (FileOutputStream fo = new FileOutputStream(fichero)) {
            for (int i = 0; i < frase.length(); i++) {
                fo.write(frase.charAt(i));
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    public static void leerCaracteres(File fichero) {
        int caracter;
        try (FileInputStream fi = new FileInputStream(fichero)) {
            while ((caracter = fi.read()) != -1) {
                System.out.print((char) caracter);
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
}
