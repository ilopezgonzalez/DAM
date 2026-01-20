/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agl.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt209
 */
public class HiloSocketTCP extends Thread {

    private int numCliente;
    private Socket socket;

    public HiloSocketTCP(int numCliente, Socket socket) {
        this.numCliente = numCliente;
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner teclado = new Scanner(System.in);
        DataOutputStream salida = null;
        boolean conexionActiva = true;
        try {

            String ciudad;
            System.out.println("Conexion realizada con exito");
            salida = new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
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
        } catch (IOException ex) {
            Logger.getLogger(HiloSocketTCP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                salida.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloSocketTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
