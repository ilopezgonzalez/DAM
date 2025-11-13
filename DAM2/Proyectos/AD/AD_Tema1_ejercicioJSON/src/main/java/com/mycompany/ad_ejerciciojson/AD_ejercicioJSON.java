/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_ejerciciojson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author damt209
 */
public class AD_ejercicioJSON {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileInputStream fis = new FileInputStream("equipos_liga_baloncesto.json")) {
            JsonNode root = mapper.readTree(fis);
            if (root != null && root.isArray()) {
                for (JsonNode equipos : root) {
                    JsonNode idNode = equipos.get("id");
                    JsonNode codigoNode = equipos.get("codigo");
                    JsonNode equipoNode = equipos.get("nombre");
                    JsonNode localidadNode = equipos.get("localidad");
                    JsonNode num_jugadoresNode = equipos.get("num_jugadores");
                    if (idNode != null&&codigoNode!=null&&equipoNode!=null&&localidadNode!=null&&num_jugadoresNode!=null) {
                        String id = idNode.asText();
                        int codigo = codigoNode.asInt();
                        String equipo=equipoNode.asText();
                        String localidad = localidadNode.asText();
                        int num_jugadores = num_jugadoresNode.asInt();
                        System.out.println("ID: "+id+"\nCodigo equipo: "+codigo+"\nEquipo: "+equipo+"\nLocalidad: "+localidad+"\nNum. Jugadores: "+num_jugadores);
                        JsonNode jugadoresNode = equipos.get("jugadores");
                        if (jugadoresNode != null && jugadoresNode.isArray()) {
                            for (JsonNode jugador : jugadoresNode) {
                                String nombre = jugador.asText();
                                System.out.println("Nombre jugador: " + nombre);
                            }
                            System.out.println("");
                        }else{
                            System.err.println("Error: El nodo 'jugadores' no existe o no es un array.");
                        }
                    }else{
                        System.err.println("Error: Alguno de los nodos no existe en el archivo.");
                    }
                }
            }else{
                System.err.println("Error: No se encuentran datos.");
            }
        } catch (IOException e) {
            
        }
    }
}
