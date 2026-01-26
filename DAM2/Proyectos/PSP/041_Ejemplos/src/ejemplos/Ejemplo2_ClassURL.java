/*
 * Constructores de Class URL.
 Usamos metodo Ver() para mostrar inforamción del URL usando metodos de la clase
 */
package ejemplos;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author jfranco
 */
public class Ejemplo2_ClassURL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("----------------------------------");
            System.out.println("Constructor simple.");
            url = new URL("http://www.google.es");
            Ver(url);
            System.out.println("Constructor simple para una URL.");
            url = new URL("https://www.google.es/services/?fg=1");
            Ver(url);
            System.out.println("Constructor protocolo + url + puerto + directorio");
            url = new URL("http", "aglinformatica.es", 6080, "citymap");
            Ver(url);
            System.out.println("Construcotr para objeto URL + directorio");
            URL urlBase = new URL("http://aglinformatica.es:6080/");
            url = new URL(urlBase, "/sara/perros/index.php");
            Ver(url);

        } catch (MalformedURLException e) {
            System.err.println("Error URL." + e.toString());
        }
    }

    private static void Ver(URL url) {
        System.out.println("----------------------------------");
        System.out.println("URL complet " + url.toString());
        System.out.println("getProtocol () " + url.getProtocol());
        System.out.println("getHost() " + url.getHost());
        System.out.println("getPort() " + url.getPort());
        System.out.println("getFile() " + url.getFile());
        System.out.println("getPath " + url.getPath());
        System.out.println("getQuery() " + url.getQuery());
        System.out.println("getAuthority() " + url.getAuthority());
        System.out.println("getUserInfo() " + url.getUserInfo());
        System.out.println("----------------------------------");
    }
}
