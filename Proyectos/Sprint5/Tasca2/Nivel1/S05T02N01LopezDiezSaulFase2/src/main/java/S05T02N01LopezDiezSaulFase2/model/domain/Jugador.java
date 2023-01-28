package S05T02N01LopezDiezSaulFase2.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Document(collection = "jugadors")
public class Jugador {
    @Id
    private String id;
    private String nombre;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "jugadors", cascade = {
            CascadeType.ALL
    })
    private List<Tirada> tiradas;


    //Constructores
    public Jugador(){}

    public Jugador(String nombre){
        this.nombre = nombre;
        this.fechaRegistro = LocalDate.now();
    }

    public Jugador(String nombre, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

    //getters y setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Tirada> getTiradas() {
        return tiradas;
    }

    public void setTiradas(List<Tirada> tiradas) {
        this.tiradas = tiradas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(id, jugador.id) && Objects.equals(nombre, jugador.nombre) && Objects.equals(fechaRegistro, jugador.fechaRegistro) && Objects.equals(tiradas, jugador.tiradas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fechaRegistro, tiradas);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", tiradas=" + tiradas +
                '}';
    }
}



