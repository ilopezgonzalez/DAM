/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hoja04.ejercicio1.servicio;

import hoja04.ejercicio1.modelo.Cancion;
import hoja04.ejercicio1.modelo.Grupo;
import hoja04.ejercicio1.modelo.Resultado;
import hoja04.ejercicio1.modelo.Voto;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author ASUS
 */
public interface Servicio {
    
    Resultado<List<Grupo>> obtenerGrupos();
    
    Resultado<List<Cancion>> obtenerCanciones();
    
    Resultado<Map<String, Integer>> obtenerGruposConNumeroCanciones();
    
    Resultado<List<Cancion>> obtenerCancionesDeGrupo(String nombreGrupo);
    
    Resultado<List<Cancion>> obtenerCancionesMasVotadas();
    
    Resultado<List<Grupo>> obtenerGruposSinCancines();
    
    Resultado<List<Voto>> obtenerCincoUltimosVotos();
    
    Resultado<Integer> borrarVotosCancionesGrupo(String nombreGrupo);
    Resultado<String> borrarCancionesGrupo (String nombreGrupo);
    
    Resultado<Optional<Grupo>> obtenerDatosGrupoParaModificar(String nombreGrupo);
    Resultado<Integer> modificarDatosGrupo(String[] datos);
    
}
