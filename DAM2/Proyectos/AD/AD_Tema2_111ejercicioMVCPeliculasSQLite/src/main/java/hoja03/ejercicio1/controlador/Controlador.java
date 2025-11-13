/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.controlador;

import hoja03.ejercicio1.modelo.Actuacion;
import hoja03.ejercicio1.modelo.Pelicula;
import hoja03.ejercicio1.modelo.Personaje;
import hoja03.ejercicio1.modelo.Resultado;
import hoja03.ejercicio1.servicio.Servicio;
import hoja03.ejercicio1.servicio.impl.ServicioImpl;
import hoja03.ejercicio1.vista.Consola;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author cic
 */
public class Controlador {

    private final Servicio servicio = new ServicioImpl();
    private final Consola vista = new Consola();
    private final Scanner teclado=new Scanner (System.in);
    public void start() {
        while (true) {
            int opcion = vista.mostrarMenuYLeerOpcion();
            switch (opcion) {
                case 1:
                    ObtenerPeliculas();
                    break;
                case 2:
                    ObtenerPersonajes();
                    break;
                case 3:
                    ObtenerPersonajePorID(vista.validarIdPersonaje());
                    break;
                case 4:
                    ObtenerPersonajesDePeliculas();
                    break;
                case 5:
                    ObtenerPeliculasSinProductora();
                    break;
                case 6:
                    ObtenerActuacionesPorPelicula();
                    break;
                case 7:
                    ObtenerPeliculaMasAntigua();
                    break;
                case 8:
                    ObtenerPeliculasPorActor(vista.pedirNombreActor());
                    break;
                case 9:
                    ObtenerPeliculasSinActuaciones();
                    break;
                case 0: {
                    vista.mostrarMensaje("Saliendo...");
                    return;
                }
                default:
                    vista.mostrarMensaje("Opcion no valida");
            }
        }
    }

    
    
    private void ObtenerPeliculas() {
        Resultado<List<Pelicula>> res = servicio.obtenerPeliculas();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.mostrarPeliculas(res.getData());
        }
    }

    private void ObtenerPersonajes() {
        Resultado<List<Personaje>> res = servicio.obtenerPersonajes();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.mostrarPersonajes(res.getData());
        }
    }

    public static void main(String[] args) {
        new Controlador().start();
    }

    private void ObtenerPersonajePorID(int id) {
        Resultado<Optional<Personaje>> res = servicio.encontarPorID(id);
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            Optional<Personaje> personajeOpt = res.getData();
            if (personajeOpt.isPresent()) {
                vista.encontrarPersonajePorID(personajeOpt);
            }
        }

    }
    
    private void ObtenerPersonajesDePeliculas(){
        Resultado<List<Actuacion>> res = servicio.obtenerPersonajesDePeliculas();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: "+res.getMessage());
        }else{
            vista.obtenerPersonajesPeliculas(res.getData());
                   
        }
    }
    
    private void ObtenerPeliculasSinProductora(){
        Resultado<List<Pelicula>> res = servicio.obtenerPeliculasSinProductor();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerPeliculasSinProductora(res.getData());
        }
    }
    
    private void ObtenerActuacionesPorPelicula(){
        Resultado<Map<String, Integer>> res= servicio.obtenerActuacionesPorPeliculas();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: "+res.getMessage());
        }else{
            vista.obtenerActuacionesPorPelicula(res.getData());
        }
    }
    
    private void ObtenerPeliculaMasAntigua(){
        Resultado<Optional<Pelicula>> res=servicio.obtenerPeliculaMasantigua();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: "+res.getMessage());
        }else{
            vista.obtenerPeliculaMasAntigua(res.getData());
        }
    }
    
    private void ObtenerPeliculasPorActor(String actor) {
        Resultado<List<Pelicula>> res = servicio.obtenerPeliculasPorActor(actor);
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerPeliculasPorActor(res.getData());
        }
    }
    
    private void ObtenerPeliculasSinActuaciones() {
        Resultado<List<Pelicula>> res = servicio.obtenerPeliculasSinActuaciones();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerPeliculasSinActuaciones(res.getData());
        }
    }
    
    
    
    
}
