package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHilos {

    public static void main(String[] args) {
        int numCliente = 0; // Contador de clientes
        ServerSocket servidor;
        Socket cliente;
        int puerto = 6555;
        boolean salir = false;

        System.out.println("Servidor arrancado y escuchando...");

        try {
            servidor = new ServerSocket(puerto);
            while (!salir) {
                System.out.println("Esperando conexiones...");
                cliente = servidor.accept();
                numCliente++;
                // Pasamos el control al hilo correspondiente
                System.out.println("Peticion -> " + cliente.getInetAddress() + " --- " + cliente.getPort());
                GestionClientes gc = new GestionClientes(cliente, numCliente);
                gc.start();
            }
            System.out.println("Servidor finalizado...");
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
