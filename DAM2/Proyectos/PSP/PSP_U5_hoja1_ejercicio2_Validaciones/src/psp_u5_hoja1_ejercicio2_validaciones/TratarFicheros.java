/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u5_hoja1_ejercicio2_validaciones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class TratarFicheros {

    // Atributos privados para almacenar los datos del usuario (nombre y correo).
    private String nombre;
    private String correo;
    
    // Obtiene la instancia del Logger definida en la clase Main para compartir el mismo archivo de registro.
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    // Constructor que inicializa las variables de clase con los valores recibidos por parámetro.
    public TratarFicheros(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Método para crear un archivo físico utilizando el nombre del usuario como título.
    public void escribir() {
        // Bloque try-with-resources que abre FileWriter y asegura su cierre automático al finalizar.
        try (FileWriter fw = new FileWriter(nombre)) {
            // Escribe en el archivo el nombre y el correo separados por una coma y un espacio.
            fw.write(nombre + ", " + correo);
            
            // Registra un evento informativo (.info) indicando el éxito de la operación de escritura.
            logger.info("Se ha escrito el archivo de manera correcta");
            
        } catch (IOException e) {
            // Captura errores de entrada/salida y muestra la traza del error en la consola de errores.
            e.printStackTrace();
            // Registra un evento de advertencia (.warning) si no se pudo crear o escribir el archivo.
            logger.warning("Error al intentar escribir en el archivo: " + e.getMessage());
        }
    }
}
