/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen.ejercicio2;

import com.fasterxml.jackson.core.io.DataOutputAsStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.examen.ejercicio2.Receta;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */

/*
* La ventaja de trabajar cons serilizacion binaria es que se pueden recuperar los objetos de los ficheros apra trabajar con ellos
* Por contra se trata de ficheros que no son legibles para el ser humano y hace falta interpretarlos mediante la lectura del objeto.
 */
public class ExamenEjercicio2 {

    public static void main(String[] args) {
        escribirObjetos(leerJson());
        leerObjetos();
    }

    public static ArrayList<Receta> leerJson() {

        File fichero = new File("recetas.json");
        String id = "";
        String nombre = "";
        int calorias = 0;
        HashMap<String, String> mapa = new HashMap();
        ArrayList<Receta> listaRecetas = new ArrayList<>();

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
                            nombre = rece.get("nombre").asText();
                            calorias = rece.get("calorias").asInt();

//                            listaRecetas.add("tipo: "+tipo);
//                            listaRecetas.add("nombre: "+nombre);
//                            listaRecetas.add("dificultad: "+dificultad);
//                            mapa.put("id", id);
//                            mapa.put("tipo", tipo);
//                            mapa.put("nombre", nombre);
//                            mapa.put("dificultad", dificultad);
                            Receta objeto = new Receta(id, nombre, calorias);
                            listaRecetas.add(objeto);

                        }

                    }

                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                Logger.getLogger(ExamenEjercicio2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(ExamenEjercicio2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listaRecetas;
    }

    public static void escribirObjetos(ArrayList<Receta> listaRecetas) {

        File fichero = new File("recetas.dat");
//        Receta receta = new Receta(mapa.get("id"), mapa.get("nombre"), Integer.parseInt(mapa.get("calorias")));
        for (Receta receta : listaRecetas) {

            try {
                ObjectOutputStream oos;
                if (!fichero.exists()) {
                    oos = new ObjectOutputStream(new FileOutputStream(fichero));
                    oos.writeObject(receta);
                } else {
                    oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                    oos.writeObject(receta);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void leerObjetos(){
        
        File fichero=new File("recetas.dat");
        boolean fin=false;
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero))){
            Receta receta;
            while (!fin) {
                receta=(Receta)ois.readObject();
                System.out.println(receta.toString());
            }
        } catch (IOException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenEjercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
