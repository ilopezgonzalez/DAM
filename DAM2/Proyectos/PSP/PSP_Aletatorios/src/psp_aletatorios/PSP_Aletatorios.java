/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_aletatorios;

import java.io.IOException;

/**
 *
 * @author damt209
 */
public class PSP_Aletatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] comando = {"cmd", "/c", "aleatorio.exe"};
        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();
            
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
