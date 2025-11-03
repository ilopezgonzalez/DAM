/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di_ejemplomvcsuma;

import Controlador.Controlador_Suma;
import Modelo.Modelo_Suma;
import Vista.Vista_Suma;

/**
 *
 * @author damt209
 */
public class DI_EjemploMvcSuma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo_Suma objetoModelo = new Modelo_Suma();
        Vista_Suma objetoVista= new Vista_Suma();
        
        Controlador_Suma ctrl= new Controlador_Suma(objetoModelo, objetoVista);
        
        ctrl.iniciar();
        objetoVista.setVisible(true);
    }
    
}
