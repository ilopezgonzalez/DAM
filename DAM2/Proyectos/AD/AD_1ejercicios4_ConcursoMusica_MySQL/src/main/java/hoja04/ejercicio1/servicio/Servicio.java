/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hoja04.ejercicio1.servicio;

import hoja04.ejercicio1.modelo.Cancion;
import hoja04.ejercicio1.modelo.Grupo;
import hoja04.ejercicio1.modelo.Resultado;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface Servicio {
    
    Resultado<List<Grupo>> obtenerGrupos();
    
    Resultado<List<Cancion>> obtenerCanciones();
    
}
