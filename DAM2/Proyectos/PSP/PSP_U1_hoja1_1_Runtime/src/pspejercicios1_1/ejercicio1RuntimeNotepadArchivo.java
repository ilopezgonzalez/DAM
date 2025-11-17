/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pspejercicios1_1;

import java.io.IOException;

/**
 *
 * @author damt209
 */
public class ejercicio1RuntimeNotepadArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        String[] comando = {"notepad.exe", args[0]};
        Process p; //Para el objeto proceso

        try {
            p = rt.exec(comando);
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando: " + comando);
            e.printStackTrace();
        }
    }

}
