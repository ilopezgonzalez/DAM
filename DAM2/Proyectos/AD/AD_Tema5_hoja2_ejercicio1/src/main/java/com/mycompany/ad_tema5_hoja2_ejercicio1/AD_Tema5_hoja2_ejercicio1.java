/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ad_tema5_hoja2_ejercicio1;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.TimeoutHelper;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author ilopezgonzalez
 */
public class AD_Tema5_hoja2_ejercicio1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("""
                               1.- A\u00f1adir Comunidad Autonoma sin provincias
                               2.- Consultar Comunidad Autonoma
                               3.- Asignar provincias a Comunidad Autonoma
                               4.- A\u00f1adir provincia a Comunidad Autonoma
                               5.- Modificar nombre de Comunidad Autonoma
                               6.- Eliminar provincia en Comunidad Autonoma
                               7.- Asignar capital a Comunidad Autonoma
                               8.- Asignar fecha Estatuto Autonomia
                               9.- Eliminar Comunidad Autonoma
                               0.- SALIR""");
            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1:
                    addCAsinProvincias();
                    break;
                case 2:
                    buscarComunidad();
                    break;
                case 3:
                    buscarProvincias();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Introduce una opcion del 1 al 9");
            }
        } while (opcion != 0);

    }

    public static void addCAsinProvincias() {
        Scanner teclado = new Scanner(System.in);
        try ( // Conexión al servidor local (puerto por defecto 27017)
                MongoClient mongoClient = MongoClients.create("mongodb://192.168.64.9:27017")) {
            MongoDatabase db = mongoClient.getDatabase("geografia");
            System.out.printf("Introduce el codigo de la Comunidad Autómoma: ");
            String codigo = teclado.nextLine();
            System.out.printf("Introduce el nombre de la Comunidad Autónoma: ");
            String nombre = teclado.nextLine();
            System.out.printf("Introduce la abreviatura de la Comunidad Autónoma: ");
            String abreviatura = teclado.nextLine();
            System.out.printf("Introduce el nombre de la capital de la Comunidad Autonoma: ");
            String capital = teclado.nextLine();
            System.out.printf("Introduce el numero de habitantes de la capital: ");
            int habitantes = Integer.parseInt(teclado.nextLine());
            System.out.printf("Introduce la extensión de la Comunidad Autonoma: ");
            int extension = Integer.parseInt(teclado.nextLine());
            System.out.printf("Introduce el numero de habitantes de la Comunidad Autonoma: ");
            int habitantesCom = Integer.parseInt(teclado.nextLine());

            MongoCollection<Document> coleccion = db.getCollection("ccaa");
            Document docCapital = new Document("nombre", capital)
                    .append("habitantes", habitantes);
            Document doc = new Document("codigo", codigo)
                    .append("nombre", nombre)
                    .append("abreviatura", abreviatura)
                    .append("capital", docCapital)
                    .append("extension", extension)
                    .append("habitantes", habitantesCom);
            try {
                coleccion.insertOne(doc);
                System.out.println("Añadida la CCAA");
            } catch (Exception e) {
                System.out.println("Error al ionsertar la CCAA");
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public static void buscarComunidad() {
        Scanner teclado = new Scanner(System.in);
        try ( // Conexión al servidor local (puerto por defecto 27017)
                MongoClient mongoClient = MongoClients.create("mongodb://192.168.64.9:27017")) {
            MongoDatabase db = mongoClient.getDatabase("geografia");
            System.out.printf("Introduce el nombre de la comunidad que quieras buscar: ");
            String comunidad = teclado.nextLine();
            System.out.println("");
            Document doc = db.getCollection("ccaa").find(eq("codigo",comunidad)).first();
            if (doc==null) {
                System.out.println("No existe la CCAA");
            }else{
                System.out.println(doc.toJson());
                System.out.println("CCAA: "+doc.getString("nombre"));
                Integer habitantes=doc.getInteger("habitantes");
                if(habitantes!=null) {
                    System.out.println("Habitantes: "+habitantes);
                }else{
                    System.out.println("Habitantes: Sin datos");
                }
                int extension=doc.getInteger("extension", -1);
                if (extension==-1) {
                    System.out.println("Extension: sin datos");
                }else{
                    System.out.println("Extension: "+extension);
                }
                Document docCap=(Document)doc.get("capital");
                String nombreCap=docCap.getString("nombre");
                System.out.println("Capital:" +nombreCap);
                Integer habitantesCap=docCap.getInteger("habitantes");
                if(habitantes!=null) {
                    System.out.println("Habitantes: "+habitantesCap);
                }else{
                    System.out.println("Habitantes: Sin datos");
                }
            }
            System.out.println("");

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public static void buscarProvincias() {
        Scanner teclado = new Scanner(System.in);
        try ( // Conexión al servidor local (puerto por defecto 27017)
                MongoClient mongoClient = MongoClients.create("mongodb://192.168.64.9:27017")) {
            MongoDatabase db = mongoClient.getDatabase("geografia");
            System.out.printf("Introduce el codigo de la comunidad que quieras buscar: ");
            int comunidad = Integer.parseInt(teclado.nextLine());
            Document doc = db.getCollection("ccaa").find(eq("codigo",comunidad)).first();
            if (doc==null) {
                System.out.println("No existe la CCAA");
            }else{
                System.out.println("CCAA: "+doc.getString("nombre"));
                Integer habitantes=doc.getInteger("habitantes");
                if(habitantes!=null) {
                    System.out.println("Habitantes: "+habitantes);
                }else{
                    System.out.println("Habitantes: Sin datos");
                }
                int extension=doc.getInteger("extension", -1);
                if (extension==-1) {
                    System.out.println("Extension: sin datos");
                }else{
                    System.out.println("Extension: "+extension);
                }
                Document docCap=(Document)doc.get("capital");
                
            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

}
