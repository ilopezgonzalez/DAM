/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja2_ejercicio3_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja2_TCP_ejercicio3_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String direccion; // La IP o Dirección de conexión
        Socket servidor; // Socket para conectarnos a un servidor u otra máquina
        int numCliente = 0; // Mi número de cliente
        int PUERTO = 6666;  // Puerto de conexión
        boolean juegoActivo=true;

        try {
            //Aquí indicar la ip donde está escuchando el servidor
            direccion = "127.0.0.1";
            // Nos conectamos al servidor: dirección y puerto
            servidor = new Socket(direccion, PUERTO);
            DataOutputStream salida = new DataOutputStream(servidor.getOutputStream());
            DataInputStream entrada = new DataInputStream(servidor.getInputStream());
            System.out.println("Tienes que acertar un numero del 1 al 100");

            while (juegoActivo) {
                System.out.println("Introduce el numero:");
                int numero = Integer.parseInt(teclado.nextLine());
                salida.writeUTF(String.valueOf(numero));
                String linea=entrada.readUTF();
                System.out.println(linea);
                if (linea.toLowerCase().contains("correcto")) {
                    juegoActivo=false;
                }
            }
            entrada.close();
            salida.close();
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
