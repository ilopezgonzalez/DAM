/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ftp.cliente;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author jfrancoros
 */
public class ClienteFTP {

    private static String USUARIO = "demo";
    private static String PASSWORD = "demo";

    //https://demo.wftpserver.com/login.html
    //Welcome to WingFTP's online demo!
    //In this Web Client, you can:
    //1. Download the files under the folder "/download".
    //2. Upload your own files into the folder "/upload" (other people can see your files).
    
    public static void main(String[] args) {
        //Creo un objeto de tipo FTPClient
        FTPClient clienteFTP = new FTPClient();

        try {

            String servFTP = "demo.wftpserver.com";
            //Hago la conexión
            clienteFTP.connect(servFTP);

            //Respuesta del servidor
            System.out.println(clienteFTP.getReplyString());

            //Obtengo código de respuesta
            int reply = clienteFTP.getReplyCode();

            //Si no hay ningún error
            if (FTPReply.isPositiveCompletion(reply)) {
                //Me logeo con un usuario y contraseña
                boolean login = clienteFTP.login(USUARIO, PASSWORD);

                if (login) {
                    System.out.println("Login correcto....");
                } else {
                    System.out.println("Login incorrecto....");
                    clienteFTP.disconnect();
                    System.exit(-1);
                }

                //Imprimo el directorio de trabajo
                System.out.println("----- Working directory -------");
                System.out.println(clienteFTP.printWorkingDirectory());

                //clienteFTP.changeWorkingDirectory("/upload");
                clienteFTP.changeWorkingDirectory("/download");
                
                

                System.out.println("----- Changed working directory -------");
                System.out.println(clienteFTP.printWorkingDirectory());
                
                System.out.println("----- Files in working directory -------");
                String[] names = clienteFTP.listNames();
                
                for (int i=0; i<names.length; i++) {                    
                    System.out.println("\t" + names[i]);
                }
                
                String remoteFilePath = names[4];
                String localFilePath = remoteFilePath;
                System.out.println("Downloading file " + remoteFilePath + " to " + localFilePath);
                OutputStream outputStream =  new BufferedOutputStream(new FileOutputStream(localFilePath));
                if (!clienteFTP.retrieveFile(remoteFilePath, outputStream)) {
                    System.out.println("Failed to download file " + remoteFilePath);
                }
                outputStream.close();
                //clienteFTP.makeDirectory("prueba");

                System.out.println("Conexión finalizada");
            } else {
                clienteFTP.disconnect();
                System.out.println("Conexión rechazada: " + reply);
                System.exit(0);
            }
            clienteFTP.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(ClienteFTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
