/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package eje.ejemplomongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

/**
 *
 * @author cic
 */
public class EjemploMongo {

    public static void main(String[] args) {
        try ( // Conexión al servidor local (puerto por defecto 27017)
                MongoClient mongoClient = MongoClients.create("mongodb://192.168.64.9:27017")) {
            MongoDatabase db = mongoClient.getDatabase("testdb");
            System.out.println("Conexión exitosa a la base de datos: " + db.getName());
            // si la coleccion no existe la crea cuando se añada un documento
        MongoCollection<Document> col = db.getCollection("personas");

        // Añadir documento
        Document doc = new Document("nombre", "Luis").append("edad", 40);
        col.insertOne(doc);

        // Modificar documento
        col.updateOne(Filters.eq("nombre", "Luis"), Updates.set("edad", 41));

        // Consultar documentos
        for (Document d : col.find()) {
            System.out.println(d.toJson());
        }

        // Eliminar documento
        //col.deleteOne(Filters.eq("nombre", "Luis"));

        // Eliminar colección
        //col.drop();
        }
    }
}
