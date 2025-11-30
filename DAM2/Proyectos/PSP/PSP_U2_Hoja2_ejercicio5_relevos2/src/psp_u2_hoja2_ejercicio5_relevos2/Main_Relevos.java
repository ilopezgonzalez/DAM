/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_u2_hoja2_ejercicio5_relevos2;

/**
 *
 * @author ilopezgonzalez
 */
public class Main_Relevos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Carrera carrera=new Carrera();
        
        HiloCorredor c1=new HiloCorredor(1, carrera);
        HiloCorredor c2=new HiloCorredor(2, carrera);
        HiloCorredor c3=new HiloCorredor(3, carrera);
        HiloCorredor c4=new HiloCorredor(4, carrera);
        
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        
        
    }
    
}
