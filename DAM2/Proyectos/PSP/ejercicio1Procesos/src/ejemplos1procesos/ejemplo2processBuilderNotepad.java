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
public class ejemplo2processBuilderNotepad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] comando={"notepad.exe"};
        
        //Objeto process builder que se asocia a la aplicacion
        ProcessBuilder pb=new ProcessBuilder(comando);
        Process p; //Para el objeto proceso
        
        try {
            p=pb.start();
        } catch (IOException e) {
            System.out.println("Error al ejecuar el comando: "+ comando);
            e.printStackTrace();
        }
        
    }
    
}
