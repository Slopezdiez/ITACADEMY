package S05T02N01LopezDiezSaulFase2.model.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Objects;


@Document(collection = "Tiradas")
public class Tirada {
    @Id
    private String id;

    private int dado1;

    private int dado2;

    private boolean gano;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="player_id")
    private Jugador jugador;


    public Tirada(){}

    public Tirada(int dado1, int dado2, boolean gano, Jugador jugador) {
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.gano = gano;
        this.jugador = jugador;
    }

    //getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }

    public boolean isGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = gano;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tirada tirada = (Tirada) o;
        return dado1 == tirada.dado1 && dado2 == tirada.dado2 && gano == tirada.gano && Objects.equals(id, tirada.id) && Objects.equals(jugador, tirada.jugador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dado1, dado2, gano, jugador);
    }

    @Override
    public String toString() {
        return "Tirada{" +
                "id=" + id +
                ", dado1=" + dado1 +
                ", dado2=" + dado2 +
                ", gano=" + gano +
                ", jugador=" + jugador +
                '}';
    }
}

