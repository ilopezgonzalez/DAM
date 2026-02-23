/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u4_hoja2_ejercicio5_codigohttp_contenidocompleto_todascabeceras;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U4_hoja2_ejercicio5_CodigoHTTP_ContenidoCompleto_TodasCabeceras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.httpbin.org/get");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            System.out.println("Codigo HTTP: " + con.getResponseCode());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();
            
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
            e.printStackTrace();
        }
    }
    
}
