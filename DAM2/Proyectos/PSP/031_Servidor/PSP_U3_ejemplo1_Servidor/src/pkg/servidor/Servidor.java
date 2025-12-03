package pkg.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        //Definimos los Sockets
        ServerSocket servidor; // Socket de escucha del servidor
        Socket cliente; // Socket para atender a un cliente
        int numCliente = 0; // Contador de clientes
        int PUERTO = 6666; // Puerto para esuchar

        System.out.println("Soy el servidor y empiezo a escuchar peticiones por el puerto: " + PUERTO);

        try {
            // Apertura de socket para escuhar a través de un puerto
            servidor = new ServerSocket(PUERTO);
            // Atendemos a los clientes
            do {
                numCliente++;
                // Aceptamos la conexión
                cliente = servidor.accept();
                System.out.println("Llega el cliente: " + numCliente);

                //SE DECLARAN LOS FLUJOS DE COMUNICACIÓN CON EL CLIENTE
                //Flujo de entrada o lectura
                DataInputStream bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
                //Flujo de salida o de escritura
                DataOutputStream bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

                //A PARTIR DE AQUÍ SE ESTABLECE EL PROTOCOLO DE COMUNICACIÓN CON EL CLIENTE
                //Se envía un mensaje al cliente
                System.out.println("Envio el mensaje para el cliente");
                bufferDatosSalida.writeUTF("Usted es mi cliente: " + numCliente);

                //Se recibe un mensaje del cliente
                String mensaje = bufferDatosEntrada.readUTF();
                System.out.println("Mensaje del cliente: " + mensaje);

                // CIERRE DE FLUJOS Y DE LA CONEXIÓN
                bufferDatosEntrada.close();
                bufferDatosSalida.close();
                cliente.close();
                System.out.println("\t Se ha cerrado la conexión con el cliente: " + numCliente);
            } while (true); //Bucle infinito para aceptar conexiones infinitas de clientes
        } catch (IOException e) {
        }

    }
}
