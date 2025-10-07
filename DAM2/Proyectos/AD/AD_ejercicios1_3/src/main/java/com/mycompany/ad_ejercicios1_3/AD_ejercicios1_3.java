/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejercicios1_3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class AD_ejercicios1_3 {

    public static void main(String[] args) {

        int control = 0;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                               Elige una de las opciones:
                               1. Añadir municipio al fichero de objetos.
                               2. Listar minicipios del fichero de objetos.
                               3. Obtener datos de municipio del fichero de objetos.
                               4. Modificar numero de localidades de municipio.
                               5. Eliminar municipio.
                               6. Añadir al fichero de comarcas los municipios.
                               7. Listar le fichero de comarcas.
                               0. SALIR""");
            control = Integer.parseInt(input.nextLine());

            switch (control) {
                case 1:
                    File fichero = new File("municipios.dat");

                    break;
                default:
                    throw new AssertionError();
            }

        } while (control != 0);
    }

    public static void escribirDatos(File fichero) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero))) {
            dos.writeInt(25);
            dos.writeInt(25);
            dos.writeUTF("Hola Mundo");
            dos.writeDouble(3.14);
            dos.writeInt(25);
            dos.writeUTF("NULL");
            dos.writeChar('A');
            dos.writeUTF("Hola Mundo");
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
}
