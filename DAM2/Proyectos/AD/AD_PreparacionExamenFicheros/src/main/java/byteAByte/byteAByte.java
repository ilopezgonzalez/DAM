/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package byteAByte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ilopezgonzalez
 */
public class byteAByte {

    public static void main(String[] args) {
        File fichero = new File("miFichero.txt");
        escribirArchivo(fichero);
        leerArchivo(fichero);

    }

    public static void escribirArchivo(File fichero) {
        Scanner teclado = new Scanner(System.in);
        String frase;
        System.out.println("Introduce la frase que quieres incluir en el fichero:");
        frase = teclado.nextLine();
        try (FileOutputStream fos = new FileOutputStream(fichero, true)) {
            for (int i = 0; i < frase.length(); i++) {
                fos.write(frase.charAt(i));
            }
            fos.write('\n');
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void leerArchivo(File fichero) {
        int caracter;
        StringBuilder linea = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(fichero)) {
            while ((caracter = fis.read()) != -1) {
                if (caracter == '\n') {
                    System.out.println("Linea leida: " + linea);
                    linea.setLength(0);
                } else {
                    linea.append((char) caracter);
                }
            }
            if (linea.length() > 0) {
                System.out.println("Linea leida: " + linea);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
