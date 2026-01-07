/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja4_tcp_objetos_ejercicio1_cliente;

import modelo.Rectangulo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja4_TCP_OBJETOS_ejercicio1_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String direccion; // La IP o Dirección de conexión
        Socket servidor; // Socket para conectarnos a un servidor u otra máquina
        int numCliente = 0; // Mi número de cliente
        int PUERTO = 7777;  // Puerto de conexión

        direccion = "127.0.0.1";
        System.out.println("Bienvenido al cliente de rectangulos");
        try {
            servidor = new Socket(direccion, PUERTO);
            ObjectOutputStream enviar = new ObjectOutputStream(servidor.getOutputStream());
            ObjectInputStream recibir = new ObjectInputStream(servidor.getInputStream());
            enviar.flush();
            for (int i = 1; i < 6; i++) {

                System.out.println("Introduce el ancho del rectangulo:");
                double ancho = Double.parseDouble(teclado.nextLine());
                System.out.println("Introduce el largo del rectangulo:");
                double alto = Double.parseDouble(teclado.nextLine());
                Rectangulo rectangulo = new Rectangulo(ancho, alto);

                enviar.writeObject(rectangulo);
                enviar.flush();

                double area = recibir.readDouble();
                double perimetro = recibir.readDouble();
                double sumatorioArea = recibir.readDouble();
                double sumatorioPerimetro = recibir.readDouble();

                System.out.println("Envio del rectangulo " + i);
                System.out.println("Ancho: " + ancho);
                System.out.println("Alto: " + alto);
                System.out.println("Area: " + area);
                System.out.println("Perimetro: " + perimetro);
                System.out.println("Area total acumulada: " + sumatorioArea);
                System.out.println("Perimetro total acumulado: " + sumatorioPerimetro);

            }

        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja4_TCP_OBJETOS_ejercicio1_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
