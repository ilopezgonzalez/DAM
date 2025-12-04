/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Partido;
import modelo.Resultado;
import modelo.Socio;

/**
 *
 * @author alumno
 */
public interface Servicio {
    
    Resultado <List<Partido>> obtenerTodosPartidos();
    Resultado <List<Socio>> obtenerSociosReserva();
    
}
