/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja03.ejercicio1.vista;

import hoja03.ejercicio1.modelo.Actuacion;
import hoja03.ejercicio1.modelo.Pelicula;
import hoja03.ejercicio1.modelo.Personaje;
import hoja03.ejercicio1.modelo.TituloPeliculaNumPersonajes;
import java.util.List;
import java.util.Map;
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
        System.out.println("7. Obtener pelicula mas antigua");
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

    public int validarIdPersonaje() {
        int id=0;
        boolean validador = false;
        try {
            System.out.println("Introduce el id del personaje");
            id = Integer.parseInt(scanner.nextLine());
            while (validador != true) {
                if (id > 0) {
                    validador = true;
                } else {
                    System.out.println("Introduce un numero entero positivo");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Introduce un numero y no letras");
        }
        return id;
        
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

    public void obtenerPersonajesPeliculas(List<Actuacion> actuaciones){
        if (actuaciones==null||actuaciones.isEmpty()) {
            System.out.println("No hay ningun personaje de peliculas");
            return;
        }
        System.out.printf("%-50s %-6s %-20s %-20s%n", "Título", "Año", "Personaje", "Actor");
        System.out.println("---------------------------------------------------------------------");
        for (Actuacion actuacion : actuaciones) {
            System.out.printf("%-50s %-6s %-20s %-20s%n",actuacion.getMovie_id().getTitle(), actuacion.getMovie_id().getYear(), actuacion.getCharacter_id().getName(), actuacion.getActor());
        }

    }
    public void obtenerPeliculasSinProductora(List<Pelicula> peliculasSinProductor) {
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


    public void obtenerPeliculaMasAntigua(Optional<Pelicula> pelicula) {
        if (pelicula == null) {
            System.out.println("No hay una sola pelicula más antigua");
            return;
        }
        System.out.printf("%-50s %-6s%n", "Título", "Año");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-50s %-6s%n",
                pelicula.get().getTitle(), pelicula.get().getYear());
    }
    
    
    public void obtenerActuacionesPorPelicula(Map<String, Integer> mapa) {
        if (mapa == null || mapa.isEmpty()) {
            System.out.println("No hay peliculas con personajes");
            return;
        }
        System.out.printf("%-50s %-6s%n", "Título", "Personajes");
        System.out.println("---------------------------------------------------------------------");
        
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            String titulo=entry.getKey();
            int personajes=entry.getValue();
            System.out.printf("%-50s %-6s%n",titulo, personajes);
        }
  
    }
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
