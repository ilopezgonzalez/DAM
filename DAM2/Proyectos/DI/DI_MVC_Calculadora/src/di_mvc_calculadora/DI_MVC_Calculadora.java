/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di_mvc_calculadora;

import Controlador.Controlador_Calculadora;
import Modelo.Modelo_Calculadora;
import Vista.Vista_Calculadora;

/**
 *
 * @author damt209
 */
public class DI_MVC_Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo_Calculadora objetoModelo=new Modelo_Calculadora();
        Vista_Calculadora objetoVista=new Vista_Calculadora();
        
        Controlador_Calculadora ctrl=new Controlador_Calculadora(objetoModelo, objetoVista);
        
        ctrl.iniciar();
        objetoVista.setVisible(true);
    }
    
}
