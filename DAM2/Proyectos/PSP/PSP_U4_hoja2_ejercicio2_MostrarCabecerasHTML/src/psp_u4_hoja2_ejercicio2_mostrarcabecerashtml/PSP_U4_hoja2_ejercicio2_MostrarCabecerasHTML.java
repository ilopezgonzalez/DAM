/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u4_hoja2_ejercicio2_mostrarcabecerashtml;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U4_hoja2_ejercicio2_MostrarCabecerasHTML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.marca.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            System.out.println("Codigo HTTP: " + con.getResponseCode());
            System.out.println("Cabeceras:");
            Map<String, List<String>> listaCabeceras = con.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : listaCabeceras.entrySet()) {
                String clave = entry.getKey();
                List<String> valores = entry.getValue();

                System.out.println("Cabecera: " + clave);
                for (String valor : valores) {
                    System.out.println("   Valor: " + valor);
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
