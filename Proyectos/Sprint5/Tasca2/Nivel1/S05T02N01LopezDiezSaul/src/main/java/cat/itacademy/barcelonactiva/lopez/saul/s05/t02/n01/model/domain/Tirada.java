package cat.itacademy.barcelonactiva.lopez.saul.s05.t02.n01.model.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "tiradas")
public class Tirada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="dado1")
    private int dado1;
    @Column(name ="dado2")
    private int dado2;
    @Column(name ="gano")
    private boolean gano;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;


    public Tirada(){}

    public Tirada(int dado1, int dado2, boolean gano, Jugador jugador) {
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.gano = gano;
        this.jugador = jugador;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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