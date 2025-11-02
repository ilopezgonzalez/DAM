/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja04.ejercicio1.vista;

import com.google.protobuf.Internal;
import hoja04.ejercicio1.modelo.Cancion;
import hoja04.ejercicio1.modelo.Grupo;
import hoja04.ejercicio1.modelo.Voto;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author damt209
 */
public class Vista {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenuYElegirOpcion() {
        System.out.println("");
        System.out.println("--- MENU ---");
        System.out.println("1. Listado de grupos");
        System.out.println("2. Listado de canciones");
        System.out.println("3. Numero de canciones por grupo");
        System.out.println("4. Canciones de un grupo");
        System.out.println("5. Las 5 canciones mas votadas");
        System.out.println("6. Grupos sin canciones");
        System.out.println("7. Los ultimos 5 votos");
        System.out.println("8. Eliminar canciones de un grupo");
        System.out.println("9. Modificar datos de un grupo");
        System.out.println("0. Salir");
        System.out.print("Elige opcion: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarGrupos(List<Grupo> grupos) {
        if (grupos == null || grupos.isEmpty()) {
            System.out.println("No hay ningun grupo para mostrar");
            return;
        }
        System.out.printf("%-3s %-20s %-20s %-25s\n", "ID", "Nombre", "Localidad", "Estilo");
        System.out.println("---------------------------------------------------------------------");
        for (Grupo grupo : grupos) {
            System.out.printf("%-3s %-20s %-20s %-25s\n",
                    grupo.getCodgrupo(),
                    grupo.getNombre(),
                    grupo.getLocalidad(),
                    grupo.getEstilo()
            );
        }
    }

    public void mostrarCanciones(List<Cancion> canciones) {
        if (canciones == null || canciones.isEmpty()) {
            System.out.println("No hay canciones para mostrar");
            return;
        }
        String grupoActual = null;
        System.out.printf("%-20s %-30s\n", "Grupo", "Cancion");
        System.out.println("---------------------------------------------------------------------");
        for (Cancion cancion : canciones) {
            //Nombre del grupo de la siguiente cancion
            String nombreGrupo = cancion.getGrupo().getNombre();
            /*En la primera iteracion grupoActual==null por lo que entra en el if
            en la segunda iteracion entra en el if solo si el grupo es diferente,
            si no entra en lugar de imprimir el nombre del grupo lo deja en blanco
             */
            if (grupoActual == null || !nombreGrupo.equals(grupoActual)) {
                System.out.printf("%-20s\n",
                        "--> " + cancion.getGrupo().getNombre());
                System.out.printf("%-20s %-30s\n",
                        "",
                        "> " + cancion.getTitulo());
                grupoActual = nombreGrupo;
            } else {
                System.out.printf("%-20s %-30s\n",
                        "",
                        "> " + cancion.getTitulo());
            }

        }
    }

    public void obtenerGruposConNumeroCanciones(Map<String, Integer> mapa) {
        if (mapa == null || mapa.isEmpty()) {
            System.out.println("No hay grupos con canciones");
            return;
        }
        System.out.printf("%-25s %-6s%n", "Grupo", "Canciones");
        System.out.println("---------------------------------------------------------------------");
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            String grupo = entry.getKey();
            int cancion = entry.getValue();
            System.out.printf("%-25s %-6s%n", grupo, cancion);
        }
    }

    public void obtenerCancionesDeGrupo(List<Cancion> canciones) {
        if (canciones == null || canciones.isEmpty()) {
            System.out.println("NO existen canciones de ese grupo");
            return;
        }
        System.out.printf("%-15s %-25s %15s%n", "NumCancion", "Titulo", "Duracion");
        System.out.println("---------------------------------------------------------------------");
        for (Cancion cancion : canciones) {
            System.out.printf("%-15s %-25s %15s%n",
                    cancion.getNum_Cancion(),
                    cancion.getTitulo(),
                    cancion.getDuracion()
            );
        }
    }

    public String preguntarNombreGrupo() {
        String nombreGrupo = "";
        System.out.println("Introduce el nombre del grupo");
        nombreGrupo = scanner.nextLine();
        return nombreGrupo;
    }

    public void obtenerCancionesMasVotadas(List<Cancion> canciones) {
        if (canciones == null || canciones.isEmpty()) {
            System.out.println("No hay ninguna cancion mas votada");
            return;
        }
        System.out.printf("%-20s %-20s%n", "Titulo", "Grupo");
        System.out.println("---------------------------------------------------------------------");
        for (Cancion cancion : canciones) {
            System.out.printf("%-20s %-20s%n",
                    cancion.getTitulo(),
                    cancion.getGrupo().getNombre()
            );
        }
    }

    public void obtenerGruposSinCanciones(List<Grupo> grupos) {
        if (grupos == null || grupos.isEmpty()) {
            System.out.println("No hay ninguna cancion mas votada");
            return;
        }
        System.out.printf("%-20s%n", "Grupo");
        System.out.println("---------------------------------------------------------------------");
        for (Grupo grupo : grupos) {
            System.out.printf("%-20s%n",
                    grupo.getNombre()
            );
        }
    }
    
    public void obtenerCincoUltimosVotos(List<Voto> votos) {
        if (votos == null || votos.isEmpty()) {
            System.out.println("No hay ninguna cancion mas votada");
            return;
        }
        System.out.printf("%-30s %-20s%n", "Cancion", "Grupo");
        System.out.println("---------------------------------------------------------------------");
        for (Voto voto : votos) {
            System.out.printf("%-30s %-20s%n",
                    voto.getCancion().getTitulo(),
                    voto.getCancion().getGrupo().getNombre()
            );
        }
    } 
    
    public String borrarVotosCancionesGrupo(String resultado){
            return resultado;
    }
    
    public String borrarCancionesGrupo (String resultado){
        return resultado;
    }

}
