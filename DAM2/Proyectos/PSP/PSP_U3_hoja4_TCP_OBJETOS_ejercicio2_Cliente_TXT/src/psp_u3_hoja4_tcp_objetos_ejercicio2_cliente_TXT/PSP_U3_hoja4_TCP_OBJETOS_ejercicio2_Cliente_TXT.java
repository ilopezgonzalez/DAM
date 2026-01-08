/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja4_tcp_objetos_ejercicio2_cliente_TXT;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
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
public class PSP_U3_hoja4_TCP_OBJETOS_ejercicio2_Cliente_TXT {

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

            }
            
            int size = recibir.readInt();
                byte[] buffer = new byte[size];
                recibir.readFully(buffer);
                FileOutputStream fos = new FileOutputStream("area_total.txt");
                fos.write(buffer);
                fos.close();
                
                
            File archivo = new File("area_total.txt");

                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(archivo);
                } else {
                    System.out.println("No se puede abrir automáticamente el archivo");
                }

        } catch (IOException ex) {
            Logger.getLogger(PSP_U3_hoja4_TCP_OBJETOS_ejercicio2_Cliente_TXT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
