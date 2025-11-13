/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejemplos.ejemploserializable;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author cic
 */
public class EjemploSerializable {

    public static void main(String[] args) {
        File fichero = new File("coches.dat");
        escribirFichero(fichero);
        leerFichero(fichero);
    }
// escribe un objeto coche, si ya existe el fichero añade un nuevo coche
    public static void escribirFichero(File fichero) {
        ObjectOutputStream fo = null;
        String marca = "";
        double velocidad;
        int gasolina;
        try {
            if (fichero.exists()) {
                fo = new MiObjectOutputStream(new FileOutputStream(fichero, true));

            } else {
                fo = new ObjectOutputStream(new FileOutputStream(fichero));
            }
            marca = Teclado.pedirMarca();
            velocidad = Teclado.pedirVelocidad();
            gasolina = Teclado.pedirGasolina();
            Coche coche = new Coche(marca, velocidad, gasolina);
            fo.writeObject(coche);
        } catch (IOException ex) {
            System.err.println(ex.toString());
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el fichero");
                }
            }
        }
    }

    // el final de la lectura lo detecta saltando la excepcion EOFException
    public static void leerFichero(File fichero) {
        boolean fin = false;
        try (ObjectInputStream os = new ObjectInputStream(new FileInputStream(fichero));) {
            Coche coche;
            while (!fin) {
                coche = (Coche) os.readObject();//Casting necesario 
                System.out.println(coche.toString());
            }
        } catch (EOFException e) {
            //termina la lectura del fichero
        } catch (ClassNotFoundException e) {
            System.out.println("Error el tipo de objeto no es compatible");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

}
