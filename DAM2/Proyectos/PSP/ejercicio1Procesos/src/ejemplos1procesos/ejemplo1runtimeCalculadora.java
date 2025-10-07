/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos1procesos;

import java.io.IOException;

/**
 *
 * @author damt209
 */
public class ejemplo1runtimeCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //objeto runtime asociado a la aplicacion
        Runtime rt = Runtime.getRuntime();
        String[] comando = {"calc.exe"};
        Process p; //Para el objeto proceso

        try {
            p = rt.exec(comando);
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando: " + comando);
            e.printStackTrace();
        }

    }

}
