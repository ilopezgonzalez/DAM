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

    private String nombre;
    private String correo;
    
    // Usando el logger del Main podemos escribir logs en la consola de este y en el mismo archivo
    private static final Logger logger = Logger.getLogger(Main.class.getName());


    public TratarFicheros(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public void escribir() {
        try (FileWriter fw = new FileWriter(nombre)) {
            fw.write(nombre + ", " + correo);
            logger.info("Se ha escrito el archivo de manera correcta");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
