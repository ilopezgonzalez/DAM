/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej1.sumaConcurrente;

/**
 *
 * @author ilopezgonzalez
 */
public class MainSumaConcurrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SumaImpares hiloImpares=new SumaImpares();
        SumaPares hiloPares=new SumaPares();
        
        hiloImpares.start();
        hiloPares.start();
    }
    
}
