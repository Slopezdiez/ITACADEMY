package Ejercicio1;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.util.Arrays.asList;

public class Botiga {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
           // List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            //databases.forEach(db -> System.out.println(db.toJson()));
            //Accessing the database
            MongoDatabase database = mongoClient.getDatabase("Botigues");
            MongoCollection<Document> client = database.getCollection("Client");
            MongoCollection<Document> localitat = database.getCollection("Localitat");
            MongoCollection<Document> provincia = database.getCollection("Provincia");
            MongoCollection<Document> comanda = database.getCollection("Comanda");
            MongoCollection<Document> detall = database.getCollection("Detall comanda");
            MongoCollection<Document> producte = database.getCollection("Producte");
            MongoCollection<Document> categories = database.getCollection("Categories Pizza");
            MongoCollection<Document> botiga = database.getCollection("Botigues");
            MongoCollection<Document> empleats = database.getCollection("Empleats");



            Document clients = new Document("idClient", "IdClient1");
            clients.append("nom", "Client1")
                    .append("cognoms", "Tenda Prova")
                    .append("Adreça", "Carrer Inexistent 0")
                    .append("Codi Postal","08090")
                    .append("Localitat","idLocalitat1")
                    .append("Provincia","idProvincia1")
                    .append("Numero de Telefon","938558989");
            client.insertOne(clients);

            Document localitatd = new Document("idLocalitat", "IdLocalitat1");
            localitatd.append("nom", "Barcelona");
            localitat.insertOne(localitatd);

            Document provinciad = new Document("idProvincia", "IdProvincia1");
            provinciad.append("nom", "Barcelona");
            provincia.insertOne(provinciad);

            DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");

            Date date = (Date)formatter.parse("03-08-2022 21:19:56");
            Date date2 = (Date)formatter.parse("03-08-2022 21:59:04");


            Document comandad = new Document("IdComanda","IdComanda1");
            comandad.append("Data/Hora comanda",date)
                    .append("Repartiment"," Domicili")
                    .append("Detall Comanda", asList(
                            /*new Document("IdDetall", "detall1").append("IdDetall", "detall2")))*/
                            new Document("IdDetall", "detall1"),
                            new Document ("IdDetall", "detall2")))
                    .append("Preu total","27")
                    .append("Data/Hora entrega",date2)
                    .append("Repartidor","IdEmpleat1");
            comanda.insertOne(comandad);

            Document detall1 = new Document("idDetall", "IdDetall1");
            detall1.append("Tipus","IdTipus1")
                    .append("Quantitat","1");
            detall.insertOne(detall1);

            Document detall2 = new Document("idDetall", "IdDetall2");
            detall2.append("Tipus","IdTipus2")
                    .append("Quantitat","1");
            detall.insertOne(detall2);

            Document producte1 = new Document("idTipus", "IdTipus1");
            producte1.append("Nom","Pizza")
                    .append("Descripcio","Pizza")
                    .append("Imatge","pizza.jpg")
                    .append("Preu","12")
                    .append("Categoria","IdCategoria1");
            producte.insertOne(producte1);

            Document producte2 = new Document("idTipus", "IdTipus2");
            producte2.append("Nom","Beguda")
                    .append("Descripcio","Beguda espirituosa")
                    .append("Imatge","beguda.jpg")
                    .append("Preu","4");
            producte.insertOne(producte2);

            Document categoria = new Document("idCategoria", "IdCategoria1");
            categoria.append("nom", "Carbonara");
           categories.insertOne(categoria);

            Document botigad = new Document("idBotiga", "IdBotiga1");
            botigad.append("nom", "Client1")
                    .append("Adreça", "Carrer Nou 1")
                    .append("Codi Postal","08090")
                    .append("Localitat","idLocalitat1")
                    .append("Provincia","idProvincia1");
            botiga.insertOne(botigad);

            Document empleatsd = new Document("idEmpleat", "IdEmpleat1");
            empleatsd.append("nom", "Empleat1")
                    .append("cognoms", "Currant Molt")
                    .append("NIF","38387858N")
                    .append("Numero de Telefon","938558989")
                    .append("Categoria", "repartidor");
            empleats.insertOne(empleatsd);



          /*   List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));*/
            } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }




    }



