package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        /* Se crea el socket cliente */
        Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;

        try {
            servidor = new Socket("localhost", 6555);

            System.out.println("Conectado al servidor...");

            //Se obtiene un stream de lectura para leer objetos, servidor input
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            String mensajeRecibido = bufferDatosEntrada.readUTF();
            System.out.println("Recibido del Servidor '" + mensajeRecibido + "'");

            bufferDatosSalida.writeUTF("Mensaje para el servidor");
            System.out.println("Enviado al Servidor '" + "Mensaje para el servidor" + "'");

        } catch (IOException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                //Cerramos la conexión
                bufferDatosEntrada.close();
                bufferDatosSalida.close();
                servidor.close();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
