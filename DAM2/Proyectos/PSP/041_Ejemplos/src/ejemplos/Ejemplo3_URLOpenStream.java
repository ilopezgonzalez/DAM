/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jfranco
 */
public class Ejemplo3_URLOpenStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.es");   
            // url.openStream() = url.openConnenction().getInputStream();            
            // Se pueden usar estas 2 sentencias o InputStream is = url.openStream();
            //URLConnection urlConn = url.openConnection();
            //InputStream is = urlConn.getInputStream();            
            InputStream is = url.openStream();
            // openStream() para tener un flujo de entrada a la url
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //uso BufferedReader para leer linea a linea
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ejemplo3_URLOpenStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejemplo3_URLOpenStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
