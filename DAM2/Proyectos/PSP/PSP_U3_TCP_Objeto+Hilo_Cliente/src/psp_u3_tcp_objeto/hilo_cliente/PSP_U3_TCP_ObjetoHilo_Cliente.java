package psp_u3_tcp_objeto.hilo_cliente;

import modelo.Rectangulo;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class PSP_U3_TCP_ObjetoHilo_Cliente {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String direccion = "127.0.0.1";
        int PUERTO = 5555;

        System.out.println("Bienvenido al cliente de rectángulos");

        try (Socket servidor = new Socket(direccion, PUERTO)) {

            ObjectOutputStream enviar = new ObjectOutputStream(servidor.getOutputStream());
            enviar.flush();
            ObjectInputStream recibir = new ObjectInputStream(servidor.getInputStream());

            // Pedir un solo rectángulo
            System.out.print("Introduce el ancho del rectángulo: ");
            double ancho = Double.parseDouble(teclado.nextLine());
            System.out.print("Introduce el alto del rectángulo: ");
            double alto = Double.parseDouble(teclado.nextLine());

            Rectangulo rectangulo = new Rectangulo(ancho, alto);

            // Enviar objeto al servidor
            enviar.writeObject(rectangulo);
            enviar.flush();

            // Recibir resultados
            double area = recibir.readDouble();
            double perimetro = recibir.readDouble();
            double sumatorioArea = recibir.readDouble();
            double sumatorioPerimetro = recibir.readDouble();

            System.out.println("Ancho: " + ancho);
            System.out.println("Alto: " + alto);
            System.out.println("Area: " + area);
            System.out.println("Perímetro: " + perimetro);
            System.out.println("Área total acumulada: " + sumatorioArea);
            System.out.println("Perímetro total acumulado: " + sumatorioPerimetro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
