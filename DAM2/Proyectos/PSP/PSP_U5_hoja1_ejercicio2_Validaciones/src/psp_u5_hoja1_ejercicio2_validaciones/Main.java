/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u5_hoja1_ejercicio2_validaciones;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

/**
 *
 * @author ilopezgonzalez
 */
public class Main {
    
    
    // El caracter ^ indica el inicio del String, el caracter $ el final
    

    private static final Pattern LONGITUD = Pattern.compile("^.{6}$");
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        configurarLogger();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre de usuario:");
        String nombre = teclado.nextLine();
        System.out.println("Introduce el correo electronico:");
        String correo = teclado.nextLine();
        if (validarLongitud(nombre) && validarEmail(correo)) {
            logger.info("El usuario se ha registrado de manera correcta");
            TratarFicheros ficheros = new TratarFicheros(nombre, correo);
            ficheros.escribir();
        } else {
            logger.warning("Los datos introducidos por el usuario No son correctos");
        }

    }

    public static boolean validarLongitud(String cadena) {
        return LONGITUD.matcher(cadena).matches();
    }

    public static boolean validarEmail(String email) {
        return EMAIL.matcher(email).matches();
    }

    private static void configurarLogger() {
        try {
            // Crear handler para escribir en fichero
            FileHandler fileHandler = new FileHandler("validaciones.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

            // Evita que se duplique el log en consola
            //logger.setUseParentHandlers(false);
        } catch (IOException e) {
            System.err.println("No se pudo configurar el logger: " + e.getMessage());
        }
    }

}
