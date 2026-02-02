/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u5_hoja1_ejercicio1_calculadoraloggerarchivo;

/**
 *
 * @author ilopezgonzalez
 */
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        configurarLogger();

        logger.info("Inicio del sistema Calculadora");

        int dividendo = 6;
        int divisor = 2;
        int resultado = 0;

        if (divisor == 0) {
            logger.severe("No se puede dividir entre 0");
        } else {
            resultado = dividendo / divisor;

            logger.info("Division correcta, el resultado es: " + resultado);
        }

    }

    private static void configurarLogger() {
        try {
            // Crear handler para escribir en fichero
            FileHandler fileHandler = new FileHandler("calculadora.log", true);
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
