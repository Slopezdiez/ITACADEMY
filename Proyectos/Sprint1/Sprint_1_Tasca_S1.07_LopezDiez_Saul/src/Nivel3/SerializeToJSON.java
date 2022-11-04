package Nivel3;
import Nivel2.ObjectToJsonFile;
import Nivel2.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SerializeToJSON {
    private static FileWriter file;
    public static void main(String[] args) throws IOException {
        Nivel2.Person person = new Person("Saul", "Lopez", "123124123V");
        JSONObject jsonObject = new JSONObject(person);

        Nivel2.ObjectToJsonFile annotation = person.getClass().getAnnotation(ObjectToJsonFile.class);
  /*      file = new FileWriter( annotation.directory());
        file.write(jsonObject.toJSONString());*/
/*        try (PrintWriter out = new PrintWriter(new FileWriter( annotation.directory()))) {
            out.write(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(annotation.directory()), person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        System.out.println("Directorio: " + annotation.directory());
    }
}
