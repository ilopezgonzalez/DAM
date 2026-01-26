/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jfranco
 */
public class Ejemplo4_URLGetInputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlConn = null;

        try {
            url = new URL("http://www.google.es");
            System.out.println("protocol = " + url.getProtocol()); //devuelve protocolo
            System.out.println("host = " + url.getHost()); //host 
            System.out.println("filename = " + url.getFile()); //nombre del archivo recuperado
            System.out.println("port = " + url.getPort()); //puerto 
            try {
                urlConn = url.openConnection();
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo4_URLGetInputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
            //obtiene el tipo de contenido
            String contentType = urlConn.getContentType();

            System.out.println("Encabezados destacados:\n* Content-Type: " + contentType);
            //obtiene la fecha de la  última modificación
            Date fecha = new Date(urlConn.getDate());
            System.out.println("* Fecha de la ultima modificacion: " + fecha);
            //if (contentType.startsWith("text/html"))
            try {
                //flujo para descargar el contenido de la pagina
                InputStream is = urlConn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo4_URLGetInputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ejemplo4_URLGetInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
