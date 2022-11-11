package cat.itacademy.barcelonactiva.lopezDiez.saul.s04.t02.n03.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Objects;

@Document(collection = "Fruita")
public class Fruita {
    @Id
    Long id;
    String nom;
    int quantitatQuilos;

    public Fruita(Long id, String nom, int quantitatQuilos) {
        this.id = id;
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }
    public Fruita( String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }
    public Fruita() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }

    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruita fruita = (Fruita) o;
        return id == fruita.id && quantitatQuilos == fruita.quantitatQuilos && Objects.equals(nom, fruita.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, quantitatQuilos);
    }

    @Override
    public String toString() {
        return "Fruita{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantitatQuilos=" + quantitatQuilos +
                '}';
    }
}
