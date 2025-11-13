/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ejemplos.ejemplobinario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author cic
 */
public class Ejemplobinario {

    public static void main(String[] args) {
        File fichero = new File("datos.dat");
        System.out.println("creando el fichero ");
        escribirDatos(fichero);
        System.out.println("leyendo el fichero creado");
        leerDatos(fichero);
    }

    public static void escribirDatos(File fichero) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero))) {
            dos.writeInt(25);
            dos.writeDouble(3.14);
            dos.writeChar('A');
            dos.writeUTF("Hola Mundo");
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    public static void leerDatos(File fichero) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
            while (true) {
                int entero = dis.readInt();
                double real = dis.readDouble();
                char caracter = dis.readChar();
                String cadena = dis.readUTF();
                System.out.println("Entero: " + entero);
                System.out.println("Real: " + real);
                System.out.println("Caracter: " + caracter);
                System.out.println("Cadena: " + cadena);
            }
        } catch (EOFException eof) {
            // Fin del fichero, salida normal
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
}
