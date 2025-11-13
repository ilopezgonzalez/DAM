/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.servicio;

import hoja03.ejercicio1.modelo.Actuacion;
import hoja03.ejercicio1.modelo.Pelicula;
import hoja03.ejercicio1.modelo.Personaje;
import hoja03.ejercicio1.modelo.Resultado;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author cic
 */
public interface Servicio {

    Resultado<List<Pelicula>> obtenerPeliculas();

    Resultado<List<Pelicula>> obtenerPeliculasSinProductor();

    Resultado<Optional<Pelicula>> obtenerPeliculaMasantigua();

    Resultado<List<Pelicula>> obtenerPeliculasPorActor(String actor);

    Resultado<List<Pelicula>> obtenerPeliculasSinActuaciones();

    Resultado<List<Personaje>> obtenerPersonajes();

    Resultado<Optional<Personaje>> encontarPorID(int id);

    Resultado<List<Actuacion>> obtenerPersonajesDePeliculas();

    Resultado<Map<String, Integer>> obtenerActuacionesPorPeliculas();

}
