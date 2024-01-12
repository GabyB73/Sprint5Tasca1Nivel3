package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.domain;

import jakarta.persistence.*;

@Entity
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlorID;
    @Column(name = "nombre de la flor")
    private String nombreFlor;
    @Column(name = "país de la flor")
    private String paisFlor;

    public Flor() {

    }

    public Flor(String nombreFlor, String paisFlor) {
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }

    public Flor(Integer pk_FlorID, String nombreFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    /*public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }*/

    public String getNombreFlor() {
        return nombreFlor;
    }

    public void setNombreFlor(String nombreFlor) {
        this.nombreFlor = nombreFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "pk_FlorID=" + pk_FlorID +
                ", nombreFlor='" + nombreFlor + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                '}';
    }

}
