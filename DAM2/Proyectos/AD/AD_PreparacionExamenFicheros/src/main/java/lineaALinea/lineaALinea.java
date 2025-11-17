/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lineaALinea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ilopezgonzalez
 */
public class lineaALinea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero=new File("mifichero.txt");
        escribirfichero(fichero);
        leerFichero(fichero);
       
    }
    
    public static void leerFichero(File fichero){
         String linea;
        try (BufferedReader br=new BufferedReader(new FileReader(fichero))){
            while ((linea=br.readLine())!=null) {                
                System.out.println(linea);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void escribirfichero(File fichero){
        Scanner teclado=new Scanner (System.in);
        System.out.println("Introduce la fase que quieres insertar en el fichero:");
        String linea=teclado.nextLine();
        try (BufferedWriter br=new BufferedWriter(new FileWriter(fichero,true))){
            br.write(linea);
            br.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
