/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u4_hoja2_ejercicio1_conectarurl;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U4_hoja2_ejercicio1_ConectarURL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url= new URL ("https://www.eldiariomontanes.es");
            HttpURLConnection con= (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            
            System.out.println("Codigo HTTP: "+con.getResponseCode());
            System.out.println("Mensaje: "+con.getResponseMessage());
            
        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
    }
    
}
