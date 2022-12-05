package cat.itacademy.barcelonactiva.lopezdiez.saul.s05.t01.n02.model.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*@javax.persistence.Entity*/
@Table(name = "FlorsDTO")
@Entity
public class FlorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_FlorID;
    @Column (name ="nomFlor")
    private String nomFlor;
    @Column(name="paisFlor")
    private String paisFlor;
    @Column(name="tipusFlor")
    private String tipusFlor;

    //private List<String> paisesUE = Arrays.asList("Ukraine","France","Spain","Sweden","Germany","Finland","Norway","Poland","Italy","United Kingdom","Romania","Belarus","Greece","Bulgaria","Iceland","Portugal","Czech Republic","Denmark","Hungary","Serbia","Austria","Ireland","Lithuania","Latvia","Croatia","Bosnia and Herzegovina","Slovakia","Estonia","Netherlands","Switzerland","Moldova","Belgium","Albania","Macedonia","Slovenia","Montenegro","Cyprus","Luxembourg","Faroe Is.","Andorra","Malta","Liechtenstein","Guernsey","San Marino","Gibraltar","Monaco","Vatican City");

    public FlorDTO(Integer pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.tipusFlor=definirTipusFlor(paisFlor);
    }



    public FlorDTO(String nomFlor, String paisFlor) {
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.tipusFlor=definirTipusFlor(paisFlor);
    }
    public FlorDTO(Flor flor) {
        this.pk_FlorID =flor.getPk_FlorID();
        this.nomFlor = flor.getNomFlor();
        this.paisFlor = flor.getPaisFlor();
        this.tipusFlor=definirTipusFlor(paisFlor);
    }

    public FlorDTO() {

    }
    private String definirTipusFlor(String paisFlor) {
        List<String> paisesUE = Arrays.asList("Ukraine","France","Spain","Sweden","Germany","Finland","Norway","Poland","Italy","United Kingdom","Romania","Belarus","Greece","Bulgaria","Iceland","Portugal","Czech Republic","Denmark","Hungary","Serbia","Austria","Ireland","Lithuania","Latvia","Croatia","Bosnia and Herzegovina","Slovakia","Estonia","Netherlands","Switzerland","Moldova","Belgium","Albania","Macedonia","Slovenia","Montenegro","Cyprus","Luxembourg","Faroe Is.","Andorra","Malta","Liechtenstein","Guernsey","San Marino","Gibraltar","Monaco","Vatican City");
        if (paisesUE.stream().anyMatch(str ->str.equalsIgnoreCase(paisFlor))){
            return "UE";
        }else{return "No UE";}
    }


    public String getTipusFlor() {
        return tipusFlor;
    }

    public void setTipusFlor(String tipusFlor) {
        this.tipusFlor = tipusFlor;
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
        FlorDTO that = (FlorDTO) o;
        return Objects.equals(pk_FlorID, that.pk_FlorID) && Objects.equals(nomFlor, that.nomFlor) && Objects.equals(paisFlor, that.paisFlor) && Objects.equals(tipusFlor, that.tipusFlor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk_FlorID, nomFlor, paisFlor, tipusFlor);
    }

    @Override
    public String toString() {
        return "FlorDTO{" +
                "pk_FlorID=" + pk_FlorID +
                ", nomFlor='" + nomFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                ", tipusFlor='" + tipusFlor + '\'' +
                '}';
    }
}
