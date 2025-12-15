/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u3_hoja2_ejercicio1_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author ilopezgonzalez
 */
public class PSP_U3_hoja2_ejercicio1_Cliente {

    /**
     * @param args the command line arguments
     */
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
            System.out.println("--------------");
            System.out.println("Me he conectado al servidor con Nombre: "+servidor.getInetAddress().getHostName());
            System.out.println("Su IP es: "+servidor.getInetAddress().getHostAddress());
            System.out.println("Su puerto es: "+servidor.getPort());
            System.out.println("--------------");
            

            //SE DECLARAN LOS FLUJOS DE COMUNICACIÓN CON EL SERVIDOR
            // Flujo de entrada o de lectura
            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            //Flujo de salida o de escritura
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //A PARTIR DE AQUÍ SE ESTABLECE EL PROTOCOLO DE COMUNICACIÓN CON EL SERVIDOR
            // Si queremos leer normal
            //  System.out.println(datos.readLine());
            // Si leemos con formato
            

            System.out.println("Envío el mensaje para el servidor");
            bufferDatosSalida.writeUTF("Cliente intentado adquirir la hora local");
            System.out.println("Intentando conectar con el servidor "+servidor.getInetAddress().getHostName()+" con direccion IP: "+servidor.getInetAddress().getHostAddress()+" para obetener la hora.");
            
            System.out.println("Recibo mensaje del servidor");
            String mensaje = bufferDatosEntrada.readUTF();
            System.out.println(mensaje);

            // CIERRE DE FLUJOS Y COMUNICACIÓN
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();
            System.out.println("Soy el cliente y cierro la conexión");
        } catch (IOException e) {
        }
    }
    
}
