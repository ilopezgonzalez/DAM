/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Formulario;
import Vista.Presupuesto;
import Vista.Principal;

/**
 *
 * @author damt209
 */
public class Calderas_AGL_25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Principal objetoPrincipal=new Principal();
        Formulario objetoFormulario=new Formulario(objetoPrincipal, false);
        Presupuesto objetoPresupuesto=new Presupuesto(objetoFormulario, true);
        
        Modelo modelo=new Modelo();
        Controlador ctrl=new Controlador(objetoPrincipal, objetoFormulario, objetoPresupuesto);
        
        objetoPrincipal.setVisible(true);
        
    }
    
}
