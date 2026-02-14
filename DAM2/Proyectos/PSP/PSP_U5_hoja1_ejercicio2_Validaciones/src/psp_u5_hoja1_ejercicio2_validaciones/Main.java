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
    
    // Inicio de String (^), cualquier carácter (.), longitud exacta de 6 ({6}) y fin de línea ($).
    private static final Pattern LONGITUD = Pattern.compile("^.{6}$");

    // Inicio (^), 1 o más caracteres (+) de A-Z, a-z, 0-9 o símbolos (+_.-), @ obligatoria, 
    // y 1 o más caracteres (+) de A-Z, a-z, 0-9 o símbolos (.-) hasta el fin ($).
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Instancia de Logger para registrar eventos en la clase Main.
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Llama al método de configuración del registro de logs.
        configurarLogger();

        // Objeto Scanner para leer la entrada de datos desde la consola (System.in).
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre de usuario:");
        // Lee la línea completa introducida por el usuario y la guarda en nombre.
        String nombre = teclado.nextLine();

        System.out.println("Introduce el correo electronico:");
        // Lee la línea completa introducida por el usuario y la guarda en correo.
        String correo = teclado.nextLine();

        // Comprueba si ambos métodos de validación devuelven verdadero (&&).
        if (validarLongitud(nombre) && validarEmail(correo)) {
            // Registra mensaje de éxito (.info) en el log si los datos son válidos.
            logger.info("El usuario se ha registrado de manera correcta");
            
            // Crea objeto de la clase TratarFicheros y ejecuta el método escribir.
            TratarFicheros ficheros = new TratarFicheros(nombre, correo);
            ficheros.escribir();
        } else {
            // Registra mensaje de advertencia (.warning) si alguna validación falla.
            logger.warning("Los datos introducidos por el usuario No son correctos");
        }
    }

    // Crea un motor de búsqueda (matcher) con el patrón LONGITUD y comprueba si encaja (.matches).
    public static boolean validarLongitud(String cadena) {
        return LONGITUD.matcher(cadena).matches();
    }

    // Crea un motor de búsqueda (matcher) con el patrón EMAIL y comprueba si encaja (.matches).
    public static boolean validarEmail(String email) {
        return EMAIL.matcher(email).matches();
    }

    // Estructura try-catch para capturar errores de entrada/salida (IOException) al crear el archivo de log.
    private static void configurarLogger() {
        try {
            // Crea un manejador de archivo (FileHandler) para guardar logs en "validaciones.log" de forma acumulativa (true).
            FileHandler fileHandler = new FileHandler("validaciones.log", true);
            
            // Define el formato de texto plano (SimpleFormatter) para el archivo de log.
            fileHandler.setFormatter(new SimpleFormatter());

            // Añade el manejador al logger y define que registre todos los niveles de severidad (ALL).
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            // Imprime el error en la salida de errores (System.err) si falla la configuración.
            System.err.println("No se pudo configurar el logger: " + e.getMessage());
        }
    }
}