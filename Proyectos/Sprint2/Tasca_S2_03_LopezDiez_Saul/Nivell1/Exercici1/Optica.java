package Ejercicio1;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Optica {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            //Accessing the database
            MongoDatabase database = mongoClient.getDatabase("Opticas");

            MongoCollection<Document> ulleres = database.getCollection("Ulleres");
            MongoCollection<Document> proveidors = database.getCollection("Proveidors");
            MongoCollection<Document> clients = database.getCollection("Clients");

            Document ullera = new Document("id", "ullera1");
            ullera.append("marca", "Rayban")
                    .append("proveidor", "proveidor1")
                    .append("graduacio",0.15)
                    .append("tipus de montura","fusta")
                    .append("color muntura","vermella")
                    .append("color vidre dret","negre")
                    .append("color vidre esquerre","negre")
                    .append("preu",100)
                    .append("venedor","13");
            ulleres.insertOne(ullera);


            Document proveidor = new Document("id", "proveidor1");
            proveidor.append("nom", "proveidor1").append("telefon",938788899).append("Fax",938788898).append("NIF","578484684A");
            proveidors.insertOne(proveidor);

            Document client = new Document("id", "client1");
            client.append("nom", "proveidor1").append("nom", "client1").append("adreca","carrer sant 1 4t 3ra").append("telefon",938788899).append("email","client1@gmail.com").append("data de registre","20/07/2022").append("recomanat per","");
            clients.insertOne(client);



            }
        }




    }



