/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.vista;

import hoja03.ejercicio1.modelo.Pelicula;
import hoja03.ejercicio1.modelo.PeliculaPersonajeActuacion;
import hoja03.ejercicio1.modelo.Personaje;
import hoja03.ejercicio1.modelo.TituloPeliculaNumPersonajes;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author cic
 */
public class Consola {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenuYLeerOpcion() {
        System.out.println("");
        System.out.println("--- MENU ---");
        System.out.println("1. Obtener peliculas");
        System.out.println("2. Obtener personajes");
        System.out.println("3. Obtener personaje por ID");
        System.out.println("4. Obtener personajes de peliculas");
        System.out.println("5. Obtener peliculas sin productora");
        System.out.println("6. Obtener peliculas y numero de personajes de cada una");
        System.out.println("0. Salir");
        System.out.print("Elige opcion: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarPeliculas(List<Pelicula> peliculas) {
        if (peliculas == null || peliculas.isEmpty()) {
            System.out.println("No hay peliculas para mostrar.");
            return;
        }
        System.out.printf("%-50s %-6s %-20s%n", "Título", "Año", "Producción");
        System.out.println("---------------------------------------------------------------------");
        for (Pelicula p : peliculas) {
            System.out.printf("%-50s %-6s %-20s%n",
                    p.getTitle(), p.getYear() == null ? "-" : p.getYear().toString(), p.getProducerDisplay());
        }
    }

    public void mostrarPersonajes(List<Personaje> personajes) {
        if (personajes == null || personajes.isEmpty()) {
            System.out.println("NO hay personajes para mostrar");
            return;
        }
        System.out.printf("%-4s %-40s %-70s %-20s %-15s %-8s\n", "ID", "Name", "Powers", "Company", "Origin", "Role");
        System.out.println("---------------------------------------------------------------------");
        for (Personaje personaje : personajes) {
            System.out.printf("%-4s %-40s %-70s %-20s %-15s %-8s\n",
                    personaje.getId(), personaje.getName(), personaje.getPowers(), personaje.getCompany(), personaje.getOriginDisplay(), personaje.getRoleDisplay());

        }
    }

    public void encontrarPersonajePorID(Optional<Personaje> personaje) {
        if (personaje == null) {
            System.out.println("NO hay personaje para mostrar");
            return;
        }
        System.out.printf("%-4s %-40s %-70s %-20s %-15s %-8s\n", "ID", "Name", "Powers", "Company", "Origin", "Role");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-4s %-40s %-70s %-20s %-15s %-8s\n",
                personaje.get().getId(), personaje.get().getName(), personaje.get().getPowers(), personaje.get().getCompany(), personaje.get().getOriginDisplay(), personaje.get().getRoleDisplay());
    }

    public void mostrarPeliculaPersonajeActuacion(List<PeliculaPersonajeActuacion> ppa) {
        if (ppa == null || ppa.isEmpty()) {
            System.out.println("NO hay personajes para mostrar");
            return;
        }
        System.out.printf("%-40s %5s %-40s %-40s\n", "TITULO PELICULA", "YEAR", "NOMBRE PERS", "NOMBRE ACTOR");
        System.out.println("---------------------------------------------------------------------");
        for (PeliculaPersonajeActuacion ppas : ppa) {
            System.out.printf("%-40s %-5s %-40s %-40s\n",
                    ppas.getTituloPelicula(), ppas.getYearPelicula(), ppas.getNombrePersonaje(), ppas.getNombreActor());

        }
    }

    public void mostrarPeliculasSinProductora(List<Pelicula> peliculasSinProductor) {
        if (peliculasSinProductor == null || peliculasSinProductor.isEmpty()) {
            System.out.println("No hay ninguna pelicula sin productora");
            return;
        }
        System.out.printf("%-50s %-6s %-20s%n", "Título", "Año", "Producción");
        System.out.println("---------------------------------------------------------------------");
        for (Pelicula p : peliculasSinProductor) {
            System.out.printf("%-50s %-6s %-20s%n",
                    p.getTitle(), p.getYear() == null ? "-" : p.getYear().toString(), p.getProducerDisplay() == null ? "-" : p.getProducerDisplay().toString());
        }
    }

    public void mostrarTituloPeliculaNumpersonajes(List<TituloPeliculaNumPersonajes> listaPeliculasNumPersonajes) {
        if (listaPeliculasNumPersonajes == null || listaPeliculasNumPersonajes.isEmpty()) {
            System.out.println("No hay peliculas");
            return;
        }
        System.out.printf("%-50s %-6s%n", "Titulo", "NumPersonajes");
        System.out.println("---------------------------------------------------------------------");
        for (TituloPeliculaNumPersonajes pelicula : listaPeliculasNumPersonajes) {
            System.out.printf("%-50s %-6s%n", pelicula.getTitle(), pelicula.getNumChar());
        }

    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
