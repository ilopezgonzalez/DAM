package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionClientes extends Thread {

    private int numCliente;
    private Socket cliente;

    public GestionClientes(Socket s, int cliente) {
        this.cliente = s;
        this.numCliente = cliente;
    }

    @Override
    public void run() {

        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try {
            System.out.println("Hilo de atención al Cliente: " + numCliente + " de " + cliente.getInetAddress());
            // setSoLinger() a true hace que el cierre del socket espere a que
            // el cliente lea los datos, hasta un máximo de 10 segundos de espera.
            // Si no ponemos esto, el socket se cierra inmediatamente y si el
            // cliente no ha tenido tiempo de leerlos, los datos se pierden.
            //cliente.setSoLinger (true, 10);

            // Declaramos los flujos de entrada y salida con el cliente
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());

            bufferDatosSalida.writeUTF("Eres el cliente número: " + numCliente);
            System.out.println("Enviado al cliente: " + "Eres el cliente número: " + numCliente);

            String mensajeRecibido = bufferDatosEntrada.readUTF();
            System.out.println("Recibido del Cliente '" + mensajeRecibido + "'");

        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferDatosEntrada.close();
                bufferDatosSalida.close();
                this.cliente.close();
            } catch (IOException ex) {
                Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
