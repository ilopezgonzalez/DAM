/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2.contarLineas;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author ilopezgonzalez
 */
public class CuentaLineas extends Thread {

    private String nombreArchivo;

    public CuentaLineas(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void run(){
        int contador=0;
        String linea;
        try (BufferedReader br=new BufferedReader(new FileReader(nombreArchivo))){
            while ((linea=br.readLine())!=null) {
                contador++;
            }
        } catch (Exception e) {
        }
        System.out.println("El numero de lineas es: "+contador);
    }
    
    
}
