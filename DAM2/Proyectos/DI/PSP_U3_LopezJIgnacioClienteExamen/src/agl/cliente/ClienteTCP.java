/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agl.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String direccion; // La IP o Dirección de conexión
        Socket servidor; // Socket para conectarnos a un servidor u otra máquina
        int numCliente = 0; // Mi número de cliente
        int PUERTO = 6666;  // Puerto de conexión
        boolean conexionActiva = true;
        String ciudad = "";

        try {
            System.out.println("Cliente intenta conectarse");
            //Aquí indicar la ip donde está escuchando el servidor
            direccion = "127.0.0.1";
            // Nos conectamos al servidor: dirección y puerto
            servidor = new Socket(direccion, PUERTO);
            System.out.println("Conexion realizada con exito");
            DataOutputStream salida = new DataOutputStream(servidor.getOutputStream());
            DataInputStream entrada = new DataInputStream(servidor.getInputStream());
            System.out.println(entrada.readUTF());
            while (conexionActiva) {
                
                ciudad = teclado.nextLine();

                if (ciudad.toUpperCase().equals("Q")) {
                    salida.writeUTF(ciudad);
                    System.out.println(entrada.readUTF());
                    conexionActiva = false;
                } else {
                    
                    salida.writeUTF(ciudad);
                    System.out.println(entrada.readUTF());
                 
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
