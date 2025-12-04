/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Partido;
import modelo.Socio;

/**
 *
 * @author alumno
 */
public class Vista {

    private final Scanner teclado = new Scanner(System.in);

    public Vista() {
    }

    public int mostrarMenu() {
        System.out.println("=================================================");
        System.out.println("  SISTEMA DE RESERVAS - CLUB DE BALONCESTO AGL");
        System.out.println("=================================================");
        System.out.println("""
                           1. Listar todos los partidos
                           2. Listar socios con reservas"
                           3. Añadir nuevo socio
                           4. Añadir nuevo partido
                           5. Realizar reserva de entradas
                           6. Cancelar reserva
                           7. Modificar precio de las entradas (Partidos futuros)
                           8. Eliminar partidos sin reservas
                           9. Confirmar reserva (procedimiento almacenado
                           0. Salir)
                           """);
                
        System.out.println("===================================================");
        System.out.println("Seleccione una opcion");

        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }

    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarPartidos(List<Partido> partidos) {
        if (partidos == null || partidos.isEmpty()) {
            System.out.println("No hay partidos.");
            return;
        } else {
            System.out.printf("%-3s %-30s %-50s %-5s %-4s %-6s\n", "id_partido", "rival", "fecha_partido", "aforo_total", "entradas_disponibles", "precio_entrada");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            for (Partido partido : partidos) {
                System.out.printf("%-3s %-30s %-50s %-5s %-4s %-6s\n",
                        partido.getId_partido(),
                        partido.getRival(),
                        partido.getFecha_partido(),
                        partido.getAforo_total(),
                        partido.getEntradas_disponibles(),
                        partido.getPrecio_entrada()
                );
            }
        }

    }

    public void mostrarsociosReservas(List<Socio> socios) {
        if (socios == null || socios.isEmpty()) {
            System.out.println("No hay socios con reservas.");
            return;
        } else {
            System.out.printf("%-3s %-30s %-50s %-50s %-20s %-30s\n", "id_socio", "nombre", "apellidos", "email", "telefono", "fecha_alta");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            for (Socio socio : socios) {
                System.out.printf("%-3s %-30s %-50s %-50s %-20s %-30s\n",
                        socio.getIdSocio(),
                        socio.getNombre(),
                        socio.getApellidos(),
                        socio.getEmail(),
                        socio.getTelefono(),
                        socio.getFecha_alta()
                );
            }
        }
    }

}


