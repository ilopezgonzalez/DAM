/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import modelo.Partido;
import modelo.Resultado;
import modelo.Socio;
import servicioImpl.ServicioImpl;
import vista.Vista;

/**
 *
 * @author alumno
 */
public class Controlador {

    private static final ServicioImpl servicio = new ServicioImpl();
    private static final Vista vista = new Vista();
    private final Scanner teclado = new Scanner(System.in);
    private static int opcion;

    

    public static void main(String[] args) {
        
        Controlador.start();
    }
    
    public static void start() {
        while (true) {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    MostrarPartidos();
                    break;
                case 2:
                    MostrarSociosReservas();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private static void MostrarPartidos() {
        Resultado<List<Partido>> res = servicio.obtenerTodosPartidos();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.mostrarPartidos(res.getData());
        }
    }
    
    private static void MostrarSociosReservas() {
        Resultado<List<Socio>> res = servicio.obtenerSociosReserva();
        if (!res.isOk()) {
            vista.mostrarMensaje("Error: " + res.getMessage());
        } else {
            vista.mostrarsociosReservas(res.getData());
        }
    }

}
