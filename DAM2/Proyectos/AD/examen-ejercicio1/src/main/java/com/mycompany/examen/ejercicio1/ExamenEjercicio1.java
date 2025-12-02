/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen.ejercicio1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ExamenEjercicio1 {

    public static void main(String[] args) {
        escribirArchivo(leerJson());

    }

    public static ArrayList<String> leerJson() {

        File fichero = new File("recetas.json");
        String id = "";
        String tipo = "";
        String nombre = "";
        String dificultad = "";
        HashMap<String, String> mapa = new HashMap();
        ArrayList<String> listaRecetas = new ArrayList<>();

        if (!fichero.exists()) {
            System.out.println("No se encuentra el fichero");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            try (FileInputStream fis = new FileInputStream(fichero)) {
                JsonNode root = mapper.readTree(fis);
                for (JsonNode recetas : root) {
                    JsonNode receta = root.get("recetas");
                    if (receta != null && receta.isArray()) {
                        for (JsonNode rece : receta) {
                            id = rece.get("id").asText();
                            tipo = rece.get("tipo").asText();
                            nombre = rece.get("nombre").asText();
                            dificultad = rece.get("dificultad").asText();
                            listaRecetas.add("id: " + id + " tipo: " + tipo + " nombre: " + nombre + " dificultad: " + dificultad);
//                            listaRecetas.add("tipo: "+tipo);
//                            listaRecetas.add("nombre: "+nombre);
//                            listaRecetas.add("dificultad: "+dificultad);
//                            mapa.put("id", id);
//                            mapa.put("tipo", tipo);
//                            mapa.put("nombre", nombre);
//                            mapa.put("dificultad", dificultad);

                            JsonNode ingredientes = rece.get("ingredientes");
                            if (ingredientes != null && ingredientes.isArray()) {
                                int contador=0;
                                for (JsonNode ingrediente : ingredientes) {
                                    contador++;

//                                    mapa.put("ingredientes", String.valueOf(contador));
                                }
                                listaRecetas.add(" ingredientes: " + contador);
                                listaRecetas.add(System.lineSeparator());
                            }

                        }

                    }
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                Logger.getLogger(ExamenEjercicio1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(ExamenEjercicio1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listaRecetas;
    }

    public static void escribirArchivo(ArrayList<String> listaRecetas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resumen_recetas.txt"))) {
            for (String listaReceta : listaRecetas) {
                bw.write(listaReceta.toString());

            }

//            bw.write("Id: " + mapa.get("id").concat("\n"));
//            bw.write("Tipo: " + mapa.get("tipo").concat("\n"));
//            bw.write("Nombre: " + mapa.get("nombre").concat("\n"));
//            bw.write("Dificultad: " + mapa.get("dificultad").concat("\n"));
//            bw.write("Nº Ingredientes: " + mapa.get("ingredientes").concat("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
