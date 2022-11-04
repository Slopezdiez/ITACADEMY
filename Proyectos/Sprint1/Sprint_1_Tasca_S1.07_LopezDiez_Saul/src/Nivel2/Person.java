package Nivel2;

import java.io.Serializable;
@ObjectToJsonFile(directory = "J:\\Mi unidad\\ITACADEMY\\Proyectos\\Sprint1\\Sprint_1_Tasca_S1.07_LopezDiez_Saul\\src\\Nivel2\\jsonPerson.json")
public class Person implements Serializable {
    private String name;
    private String surname;
    private String dni;

    public Person(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}