package psp_u3_hoja4_tcp_objetos_ejercicio2_servidor_txt;

import modelo.Rectangulo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PSP_U3_hoja4_TCP_OBJETOS_ejercicio2_Servidor_TXT {

    public static void main(String[] args) {
        int PUERTO = 7777;
        double sumatorioArea = 0;
        double sumatorioPerimetro = 0;

        System.out.println("Servidor esperando conexion...");

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado:");
            System.out.println("IP: " + cliente.getInetAddress().getHostAddress());
            System.out.println("Puerto: " + cliente.getPort());
            System.out.println("Nombre: " + cliente.getInetAddress().getHostName());

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            salida.flush();

            // Recibir los 5 rectángulos
            for (int i = 0; i < 5; i++) {
                System.out.println("Esperando el rectángulo " + (i + 1) + "...");
                Rectangulo rectangulo = (Rectangulo) entrada.readObject();
                sumatorioArea += rectangulo.calcularArea();
                sumatorioPerimetro += rectangulo.calcularPerimetro();
            }

            // Crear el archivo TXT (SE CIERRA ANTES DE LEER)
            File archivo = new File("area_total.txt");
            try (PrintWriter pw = new PrintWriter(archivo)) {
                pw.println("RESULTADOS FINALES");
                pw.println("Área total: " + sumatorioArea);
                pw.println("Perímetro total: " + sumatorioPerimetro);
            }

            //  Leer el archivo ya cerrado
            FileInputStream fis = new FileInputStream(archivo);
            byte[] buffer = new byte[(int) archivo.length()];
            fis.read(buffer);
            fis.close();

            //  Enviar archivo al cliente
            salida.writeInt(buffer.length);
            salida.write(buffer);   //bytes, NO writeObject
            salida.flush();

            System.out.println("Archivo enviado correctamente");

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PSP_U3_hoja4_TCP_OBJETOS_ejercicio2_Servidor_TXT.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
    }
}
