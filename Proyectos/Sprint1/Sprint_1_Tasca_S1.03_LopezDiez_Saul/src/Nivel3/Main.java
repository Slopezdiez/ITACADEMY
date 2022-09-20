package Nivel3;
//import UtilidadesSLD.*;
import  Menu.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Persona> lista;
    public static void main(String[] args) throws IOException {

        boolean sortir = false;

         lista=leerCSV();

        do{

            String[] lineas= {"\nMENú PRINCIPAL","1.Introduir persona.","2. Mostrar les persones ordenades per nom (A-Z).","3. Mostrar les persones ordenades per nom (Z-A).", "4.- Mostrar les persones ordenades per cognoms (A-Z).", "5.- Mostrar les persones ordenades per cognoms (Z-A).","6.- Mostrar les persones ordenades per DNI (1-9).","7.- Mostrar les persones ordenades per DNI (9-1).","0. Sortir de l'aplicació.\n"};
            List<String> list = new ArrayList<String>(List.of(lineas));
            switch( Menu.menu((byte) 0, (byte) 8,list)){
           // switch( Menu.menu((byte) 0, (byte) 8,Menu.opcionesMenu())){
                case 1: crearPersona();
                    break;
                case 2: listarPorNombre("normal");
                    break;
                case 3: listarPorNombre("inverso");;
                    break;
                case 4: listarPorApellido("normal");
                    break;
                case 5: listarPorApellido("inverso");;
                    break;
                case 6: listarPorDNI("normal");
                    break;
                case 7: listarPorDNI("inverso");;
                    break;
                case 0: System.out.println("Gràcies per utilitzar l'aplicació");
                    sortir = true;
                    break;
            }
        }while(!sortir);
    }

    private static void crearPersona() {
        String nombre=entradaDatos.inputsScanner.llegirString("nombre");
        String apellido=entradaDatos.inputsScanner.llegirString("apellido");
        String DNI=entradaDatos.inputsScanner.llegirString("DNI");
        Persona persona=new Persona(nombre,apellido,DNI);
        lista.add(persona);
    }

    private static List<Persona> leerCSV() throws IOException {
        List<Persona> personas=new ArrayList<Persona>();
        try (CSVReader csvReader = new CSVReader(new FileReader("personas.csv"));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                List<List> records = new ArrayList<>();
                records.add(Arrays.asList(values));
                Persona persona=new Persona(String.valueOf(records.get(0).get(0)), String.valueOf(records.get(0).get(1)), String.valueOf(records.get(0).get(2)));
                if(persona.getNom().equalsIgnoreCase("nom")){}else{personas.add(persona);}
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }

    private static void listarPorNombre(String orden) {
        CabeceraListado();
        switch (orden){
            case("normal"):
                List<Persona> sortedList = lista.stream()
                        .sorted(Comparator.comparing(Persona::getNom))
                        .collect(Collectors.toList());

                sortedList.forEach(System.out::println);

                break;
            case("inverso"):

                List<Persona> sortedListInverse = lista.stream()
                        .sorted(Comparator.comparing(Persona::getNom)
                                .reversed())
                        .collect(Collectors.toList());

                sortedListInverse.forEach(System.out::println);
                break;

        }

    }



    private static void listarPorApellido(String orden) {
        CabeceraListado();
        switch (orden){
            case("normal"):
                List<Persona> sortedList = lista.stream()
                        .sorted(Comparator.comparing(Persona::getCognom))
                        .collect(Collectors.toList());

                sortedList.forEach(System.out::println);

                break;
            case("inverso"):

                List<Persona> sortedListInverse = lista.stream()
                        .sorted(Comparator.comparing(Persona::getCognom)
                                .reversed())
                        .collect(Collectors.toList());

                sortedListInverse.forEach(System.out::println);
                break;

        }
    }

    private static void listarPorDNI(String orden) {
        CabeceraListado();
        switch (orden){
            case("normal"):
                List<Persona> sortedList = lista.stream()
                        .sorted(Comparator.comparing(Persona::getDNI))
                        .collect(Collectors.toList());

                sortedList.forEach(System.out::println);

                break;
            case("inverso"):

                List<Persona> sortedListInverse = lista.stream()
                        .sorted(Comparator.comparing(Persona::getDNI)
                                .reversed())
                        .collect(Collectors.toList());

                sortedListInverse.forEach(System.out::println);
                break;

        }

    }

    private static void CabeceraListado() {
        System.out.println("____Nom_______Cognoms________NIF");
    }
}
