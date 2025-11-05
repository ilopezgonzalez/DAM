/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di_reservasbotin_mvc;

import Controlador.Controlador_Botin;
import Modelo.Modelo_Botin;
import Vista.Vista_Inicio_Botin;
import Vista.Vista_Formulario;

/**
 *
 * @author damt209
 */
public class DI_ReservasBotin_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo_Botin objetoModelo=new Modelo_Botin();
        Vista_Inicio_Botin objetoInicio= new Vista_Inicio_Botin();
        Vista_Formulario objetoFormulario=new Vista_Formulario(objetoInicio, true);
        
        Controlador_Botin ctrl=new Controlador_Botin(objetoInicio, objetoFormulario, objetoModelo);
        ctrl.iniciar();
        objetoInicio.setVisible(true);
    }
    
}
