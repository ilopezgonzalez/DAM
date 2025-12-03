package pkg.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Cliente {

    public static void main(String[] args) {
        // Definimos los parámetros de conexión
        String direccion; // La IP o Dirección de conexión
        Socket servidor; // Socket para conectarnos a un servidor u otra máquina
        int numCliente = 0; // Mi número de cliente
        int PUERTO = 6666;  // Puerto de conexión

        System.out.println("Soy el cliente e intento conectarme");

        try {
            //Aquí indicar la ip donde está escuchando el servidor
            direccion = "127.0.0.1";
            // Nos conectamos al servidor: dirección y puerto
            servidor = new Socket(direccion, PUERTO);
            // Operamos con la conexión. En este caso recibimos los datos que nos mandan
            System.out.println("Conexión realizada con éxito");

            //SE DECLARAN LOS FLUJOS DE COMUNICACIÓN CON EL SERVIDOR
            // Flujo de entrada o de lectura
            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            //Flujo de salida o de escritura
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //A PARTIR DE AQUÍ SE ESTABLECE EL PROTOCOLO DE COMUNICACIÓN CON EL SERVIDOR
            // Si queremos leer normal
            //  System.out.println(datos.readLine());
            // Si leemos con formato
            String mensaje = bufferDatosEntrada.readUTF();
            System.out.println(mensaje);

            System.out.println("Envío el mensaje para el servidor");
            bufferDatosSalida.writeUTF("Mensaje para el servidor");

            // CIERRE DE FLUJOS Y COMUNICACIÓN
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();
            System.out.println("Soy el cliente y cierro la conexión");
        } catch (IOException e) {
        }
    }
}
