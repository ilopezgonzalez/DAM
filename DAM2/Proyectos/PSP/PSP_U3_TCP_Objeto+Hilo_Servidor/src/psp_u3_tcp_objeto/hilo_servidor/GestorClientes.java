package psp_u3_tcp_objeto.hilo_servidor;

import modelo.Rectangulo;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GestorClientes extends Thread {

    private static double sumatorioArea = 0;
    private static double sumatorioPerimetro = 0;

    private int numCliente;
    private Socket socket;

    public GestorClientes(int numCliente, Socket socket) {
        this.numCliente = numCliente;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Crear streams
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            salida.flush();
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            System.out.println("Esperando rectángulo del cliente " + numCliente);

            // Leer un solo rectángulo
            Rectangulo rectangulo = (Rectangulo) entrada.readObject();

            double area = rectangulo.calcularArea();
            double perimetro = rectangulo.calcularPerimetro();

            sumatorioArea += area;
            sumatorioPerimetro += perimetro;

            // Enviar resultados al cliente
            salida.writeDouble(area);
            salida.writeDouble(perimetro);
            salida.writeDouble(sumatorioArea);
            salida.writeDouble(sumatorioPerimetro);
            salida.flush();

            socket.close();
            System.out.println("Cliente " + numCliente + " desconectado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
