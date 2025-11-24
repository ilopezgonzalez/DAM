/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_hoja2_ejercicio4_vuelo;

/**
 *
 * @author ilopezgonzalez
 */
public class Main_Vuelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread hilo1=new HiloClienteCompra(1, 2, asientosAvion);
        Thread hilo2=new HiloClienteCompra(2, 2, asientosAvion);
        
    }
    
}
