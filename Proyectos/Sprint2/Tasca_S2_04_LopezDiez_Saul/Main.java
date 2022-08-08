import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import com.mongodb.quickstart.AggregationFramework;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.quickstart.AggregationFramework.printDocuments;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String connectionString = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("ITAcademy");
            MongoCollection<Document> restaurants = database.getCollection("restaurants");
            try {
                //1. Escriu una consulta per mostrar tots els documents en la col·lecció Restaurants.
                FindIterable<Document> iterDoc = restaurants.find();
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }
            try {
                //2. Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine per tots els documents en la col·lecció Restaurants.
                FindIterable<Document> iterDoc = restaurants.find().projection(include("restaurant_id", "name", "borough", "cuisine"));
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }
            try {
                //3.Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine, però exclou el camp _id per tots els documents en la col·lecció Restaurants.
                FindIterable<Document> iterDoc = restaurants.find().projection(fields(include("restaurant_id", "name", "borough", "cuisine"), excludeId()));
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }

            try {
                //4.Escriu una consulta per mostrar restaurant_id, name, borough i zip code, però exclou el camp _id per tots els documents en la col·lecció Restaurants.
                FindIterable<Document> iterDoc = restaurants.find().projection(fields(include("restaurant_id", "name", "borough", "address.zipcode"), excludeId()));
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }

            try {
                //5.Escriu una consulta per mostrar tots els restaurants que estan en el Bronx.
                FindIterable<Document> iterDoc = restaurants.find(eq("borough", "Bronx"));
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }

            try {
                //6.Escriu una consulta per mostrar els primers 5 restaurants que estan en el Bronx.
                FindIterable<Document> iterDoc = restaurants.find(eq("borough", "Bronx")).limit(5);
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {
            }

            try {
                //7.Escriu una consulta per mostrar el pròxim 5 restaurants després de saltar els primers 5 del Bronx.
                FindIterable<Document> iterDoc = restaurants.find(eq("borough", "Bronx")).skip(5).limit(5);
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }

            try {
                //8.Escriu una consulta per trobar els restaurants que tenen un score de més de 90.
                FindIterable<Document> iterDoc = restaurants.find(gt("grades.score", 90));
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }

            try {
                //9.Escriu una consulta per trobar els restaurants que tenen un score de més de 80 però menys que 100.
                FindIterable<Document> iterDoc = restaurants.find(new Document().append("grades.score", new Document().append("$gt", 80).append("$lt", 100)));

                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }

            try {
                //10.Escriu una consulta per trobar els restaurants que es localitzen en valor de latitud menys de -95.754168

                FindIterable<Document> iterDoc = restaurants.find(lt("address.coord.0", -95.754168));


                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {

                    System.out.println(it.next());
                }
            } catch (Exception ex) {

            }


            //11.Escriu una consulta de MongoDB per a trobar els restaurants que no preparen cap cuisine de 'American' i la seva qualificació és superior a 70 i latitud inferior a -65.754168
            try {
                //FindIterable<Document> iterDoc = restaurants.find(and(ne("cuisine", "American "), gt("grades.score", 70), lt("address.coord.0", -95.754168)));
                FindIterable<Document> iterDoc = restaurants.find(and(ne("cuisine", "American "), gt("grades.score", 70), lt("address.coord.0", -95.754168)));
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            } catch (Exception ex) {
            }

            //12.Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van aconseguir un marcador més de 70 i localitzat en la longitud menys que -65.754168. Nota: Fes aquesta consulta sense utilitzar $and operador.
            try {
                Bson match1 = match(nin("cuisine", "American "));
                Bson match2 = match(gt("grades.score", 70));
                Bson match3 = match(lt("address.coord.0", -65.754168));

                List<Document> results = restaurants.aggregate(Arrays.asList(match1, match2, match3))
                        .into(new ArrayList<>());
                System.out.println("==> restaurants que no preparen cap cuisine de 'American' i la seva qualificació és superior a 70 i latitud inferior a -65.754168");
                results.forEach(AggregationFramework.printDocuments());
            } catch (Exception ex) {
            }

            //13.Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van obtenir un punt de grau 'A' no pertany a Brooklyn. S'ha de mostrar el document segons la cuisine en ordre descendent
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$match",
                                        new Document("cuisine",
                                                new Document("$nin", Arrays.asList("American")))),
                                new Document("$match",
                                        new Document("grades.grade",
                                                new Document("$eq", "A"))),
                                new Document("$match",
                                        new Document("borough",
                                                new Document("$ne", "Brooklyn"))),
                                new Document("$sort",
                                        new Document("cuisine", -1L))))
                        .into(new ArrayList<>());
                System.out.println("==> restaurants que no preparen cap cuisine de 'American' i van obtenir un punt de grau 'A' no pertany a Brooklyn. S'ha de mostrar el document segons la cuisine en ordre descendent");
                results.forEach(printDocuments());


            } catch (Exception ex) {
            }

            //14.Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'Wil' com les tres primeres lletres en el seu nom.
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$match",
                                        new Document("name",
                                                new Document("$regex", Pattern.compile("^Wil(?i)")))),
                                new Document("$project",
                                        new Document("restaurant_id", 1L)
                                                .append("name", 1L)
                                                .append("borough", 1L)
                                                .append("cuisine", 1L)
                                                .append("_id", 0L))))
                        .into(new ArrayList<>());

                results.forEach(printDocuments());


            } catch (Exception ex) {
            }
            //15.Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'ces' com les últimes tres lletres en el seu nom.
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$match",
                                        new Document("name",
                                                new Document("$regex", Pattern.compile("ces$(?i)")))),
                                new Document("$project",
                                        new Document("restaurant_id", 1L)
                                                .append("name", 1L)
                                                .append("borough", 1L)
                                                .append("cuisine", 1L)
                                                .append("_id", 0L))))
                        .into(new ArrayList<>());

                results.forEach(printDocuments());


            } catch (Exception ex) {
            }
            //16.Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'Reg' com tres lletres en algun lloc en el seu nom.
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$match",
                                        new Document("name",
                                                new Document("$regex", Pattern.compile("Reg(?i)")))),
                                new Document("$project",
                                        new Document("restaurant_id", 1L)
                                                .append("name", 1L)
                                                .append("borough", 1L)
                                                .append("cuisine", 1L)
                                                .append("_id", 0L))))
                        .into(new ArrayList<>());

                results.forEach(printDocuments());


            } catch (Exception ex) {
            }


            //17.Escriu una consulta per trobar els restaurants que pertanyen al Bronx i van preparar qualsevol plat americà o xinès.
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$match",
                                        new Document("borough",
                                                new Document("$eq", "Bronx"))),
                                new Document("$match",
                                        new Document("cuisine",
                                                new Document("$in", Arrays.asList("American ", "Chinese"))))))
                        .into(new ArrayList<>());

                results.forEach(printDocuments());


            } catch (Exception ex) {
            }


            //18.Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que pertanyen a Staten Island o Queens o Bronx o Brooklyn.
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$project",
                                        new Document("restaurant_id", 1L)
                                                .append("name", 1L)
                                                .append("borough", 1L)
                                                .append("cuisine", 1L)
                                                .append("_id", 0L)),
                                new Document("$match",
                                        new Document("borough",
                                                new Document("$in", Arrays.asList("Staten Island", "Queens", "Bronx", "Brooklyn"))))))
                        .into(new ArrayList<>());

                results.forEach(printDocuments());


            } catch (Exception ex) {
            }


            //19.Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que no pertanyen a Staten Island o Queens o Bronx o Brooklyn.
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$project",
                                        new Document("restaurant_id", 1L)
                                                .append("name", 1L)
                                                .append("borough", 1L)
                                                .append("cuisine", 1L)
                                                .append("_id", 0L)),
                                new Document("$match",
                                        new Document("borough",
                                                new Document("$nin", Arrays.asList("Staten Island", "Queens", "Bronx", "Brooklyn"))))))
                        .into(new ArrayList<>());

                results.forEach(printDocuments());


            } catch (Exception ex) {
            }


            //20.Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que aconsegueixin un marcador que no és més de 10
            try {

                List<Document> results = restaurants.aggregate(Arrays.asList(new Document("$project",
                                        new Document("restaurant_id", 1L)
                                                .append("name", 1L)
                                                .append("borough", 1L)
                                                .append("cuisine", 1L)
                                                .append("_id", 0L)),
                                new Document("$match",
                                        new Document("grades.score",
                                                new Document("$not",
                                                        new Document("$gt", 10L))))))
                        .into(new ArrayList<>());

                results.forEach(printDocuments());


            } catch (Exception ex) {
            }


        }
    }
}



