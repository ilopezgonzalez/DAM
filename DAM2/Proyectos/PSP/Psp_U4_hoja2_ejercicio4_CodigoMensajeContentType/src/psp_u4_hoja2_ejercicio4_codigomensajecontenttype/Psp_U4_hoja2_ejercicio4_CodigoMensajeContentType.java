/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u4_hoja2_ejercicio4_codigomensajecontenttype;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author ilopezgonzalez
 */
public class Psp_U4_hoja2_ejercicio4_CodigoMensajeContentType {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            System.out.println("Codigo HTTP: " + con.getResponseCode());
            System.out.println("Mensaje: " + con.getResponseMessage());
            System.out.println("Content Type: "+con.getContentType());

        } catch (Exception e) {
        }
    }

}
