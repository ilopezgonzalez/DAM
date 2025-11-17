/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_ejerciciospara.examen_tareas1_1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_ejerciciosParaExamen_TAREAS1_1 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //Clsae runtime para ejecutar el comando
        Runtime rt=Runtime.getRuntime();
        //Array con el comando y los argumentos
        String[] comando={"notepad.exe", args[0]};
        //Crear objetos proceso
        Process p;
        try {
            //Ejecutar el comando en el objeto proceso
            p=rt.exec(comando);
            p.waitFor();
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando");
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP_ejerciciosParaExamen_TAREAS1_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
