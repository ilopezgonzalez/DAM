/*
 * Ejemplo: Prueba de los metodos InetAddress
 */
package ejemplos;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author jfranco
 */
public class Ejemplo1_InetAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InetAddress host = null;
        InetAddress[] direcciones;

        try {
            //localhost
            /* host = InetAddress.getByName("localhost");
            probarMetodosInet(host);
            System.out.println("******************");*/
            //google
            host = InetAddress.getByName("www.amazon.com");
            probarMetodosInet(host);
            System.out.println("******************");
            //array para todas las direcciones de google
            direcciones = InetAddress.getAllByName(host.getHostName());
            //los leo
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println("Direcciones: "
                        + direcciones[i].toString());
            }
            System.out.println("******************");
        } catch (UnknownHostException e) {
            System.err.println("Error. Host desconocido");
        }
    }

    private static void probarMetodosInet(InetAddress maquina) {
        System.out.println("Metodo getByName: " + maquina);
        InetAddress host2;
        try {
            host2 = InetAddress.getLocalHost();
            System.out.println("Método getLocalHost(): " + host2);
        } catch (UnknownHostException e) {
            System.err.println("Error. Host desconocido");
        }
        //Metodos de la clase
        System.out.println("Método getHostName(): " + maquina.getHostName());
        System.out.println("Método getHostAddress(): " + maquina.getHostAddress());
        System.out.println("Método getCanonicalHostName(): " + maquina.getCanonicalHostName());
    }

}
