package cat.itacademy.barcelonactiva.lopezDiez.saul.s05.t01.n03.model.domain;



import java.util.Objects;


public class Flor {

    Integer pk_FlorID;

    String nomFlor;

    String paisFlor;

    public Flor(Integer pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    public Flor(String nomFlor, String paisFlor) {
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    public Flor() {

    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flor flor = (Flor) o;
        return Objects.equals(pk_FlorID, flor.pk_FlorID) && Objects.equals(nomFlor, flor.nomFlor) && Objects.equals(paisFlor, flor.paisFlor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk_FlorID, nomFlor, paisFlor);
    }

    @Override
    public String toString() {
        return "Flor{" +
                "pk_FlorID=" + pk_FlorID +
                ", nomFlor='" + nomFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                '}';
    }
}
