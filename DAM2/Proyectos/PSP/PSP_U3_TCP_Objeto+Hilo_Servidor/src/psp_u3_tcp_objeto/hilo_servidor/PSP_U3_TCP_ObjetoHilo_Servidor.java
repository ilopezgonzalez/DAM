package psp_u3_tcp_objeto.hilo_servidor;

import modelo.Rectangulo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PSP_U3_TCP_ObjetoHilo_Servidor {

    private static double sumatorioArea = 0;
    private static double sumatorioPerimetro = 0;

    public static void main(String[] args) {

        int puerto = 5555;
        int colaClientes = 3;

        System.out.println("Servidor de objetos con hilos iniciado");

        try (ServerSocket servidor = new ServerSocket(puerto, colaClientes)) {

            int contador = 0;
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Atendiendo al cliente: " + contador);
                GestorClientes gc = new GestorClientes(contador, cliente);
                gc.start();
                contador++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
