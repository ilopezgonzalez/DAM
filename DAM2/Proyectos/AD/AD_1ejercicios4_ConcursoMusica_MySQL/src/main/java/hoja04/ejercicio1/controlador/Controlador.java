/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package hoja04.ejercicio1.controlador;

import hoja04.ejercicio1.modelo.Cancion;
import hoja04.ejercicio1.modelo.Grupo;
import hoja04.ejercicio1.modelo.Resultado;
import hoja04.ejercicio1.modelo.Voto;
import hoja04.ejercicio1.servicio.Servicio;
import hoja04.ejercicio1.servicio.impl.ServicioImpl;
import hoja04.ejercicio1.vista.Vista;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Controlador {

    private final Servicio servicio = new ServicioImpl();
    private final Vista vista = new Vista();
    private final Scanner teclado = new Scanner(System.in);

    public void start() {
        while (true) {
            int opcion = vista.mostrarMenuYElegirOpcion();
            switch (opcion) {
                case 1:
                    MostrarGrupos();
                    break;
                case 2:
                    MostrarCanciones();
                    break;
                case 3:
                    MostrarGruposConNumeroCanciones();
                    break;
                case 4:
                    MostrarCancionesDeGrupo(vista.preguntarNombreGrupo());
                    break;
                case 5:
                    MostrarCancionesMasVotadas();
                    break;
                case 6:
                    MostrarGruposSinCanciones();
                    break;
                case 7:
                    MostrarCincoUltimosVotos();
                    break;
                case 8:
                    BorrarVotosCancionesGrupo(vista.preguntarNombreGrupo());
                    BorrarCancionesGrupo(vista.preguntarNombreGrupo());
                    break;
                case 9:
                    String nombreGrupo=vista.preguntarNombreGrupo();
                    ObtenerDatosGrupoParaModificar(nombreGrupo);
                    ModificarDatosGrupo(vista.preguntarDatoModificar(nombreGrupo));
                    ObtenerDatosGrupoParaModificar(nombreGrupo);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {
        new Controlador().start();
    }

    private void MostrarGrupos() {
        Resultado<List<Grupo>> res = servicio.obtenerGrupos();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.mostrarGrupos(res.getData());
        }
    }

    private void MostrarCanciones() {
        Resultado<List<Cancion>> res = servicio.obtenerCanciones();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.mostrarCanciones(res.getData());
        }
    }

    private void MostrarGruposConNumeroCanciones() {
        Resultado<Map<String, Integer>> res = servicio.obtenerGruposConNumeroCanciones();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerGruposConNumeroCanciones(res.getData());
        }

    }

    private void MostrarCancionesDeGrupo(String nombreGrupo) {
        Resultado<List<Cancion>> res = servicio.obtenerCancionesDeGrupo(nombreGrupo);
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerCancionesDeGrupo(res.getData());
        }
    }

    private void MostrarCancionesMasVotadas() {
        Resultado<List<Cancion>> res = servicio.obtenerCancionesMasVotadas();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerCancionesMasVotadas(res.getData());
        }
    }

    private void MostrarGruposSinCanciones() {
        Resultado<List<Grupo>> res = servicio.obtenerGruposSinCancines();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerGruposSinCanciones(res.getData());
        }
    }

    private void MostrarCincoUltimosVotos() {
        Resultado<List<Voto>> res = servicio.obtenerCincoUltimosVotos();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.obtenerCincoUltimosVotos(res.getData());
        }
    }

    private void BorrarVotosCancionesGrupo(String nombreGrupo) {
        Resultado<Integer> res = servicio.borrarVotosCancionesGrupo(nombreGrupo);
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.borrarVotosCancionesGrupo("Se eliminaron" + res.getData() + "filas");
        }
    }

    private void BorrarCancionesGrupo(String nombreGrupo) {
        Resultado<String> res = servicio.borrarCancionesGrupo(nombreGrupo);
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.borrarVotosCancionesGrupo(res.getData());
        }
    }

    private void ObtenerDatosGrupoParaModificar(String nombreGrupo) {
        Resultado<Optional<Grupo>> res = servicio.obtenerDatosGrupoParaModificar(nombreGrupo);
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getData());
        } else {
            vista.obtenerDatosGrupoParaModificar(res.getData());
        }
    }
    
    private void ModificarDatosGrupo(String[] datos){
        Resultado<Integer> res = servicio.modificarDatosGrupo(datos);
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getData());
        } else {
            vista.modificarDatosGrupo(res.getData());
        }
    }
}
