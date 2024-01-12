package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.model.dto;

import java.util.Arrays;
import java.util.List;

public class FlorDTO {
    private Integer pk_FlorID;
    private String nombreFlor;
    private String paisFlor;
    private String tipoFlor;
    private static final List<String> PAISES_UE_LIST = Arrays.asList("Alemania","Austria", "Bélgica", "Bulgaria", "Chequia",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia","Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "Rumania", "Suecia");

    public FlorDTO() {
    }

    public FlorDTO(Integer pk_FlorID, String nombreFlor, String paisFlor, String tipoFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nombreFlor = nombreFlor;
        this.paisFlor = paisFlor;
        this.tipoFlor = tipoFlor;
    }
    public static List<String> getPaisesUE() {

        return PAISES_UE_LIST;
    }
    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

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

    public String getTipoFlor() {
        return tipoFlor;
    }

    public void setTipoFlor(String tipoFlor) {
        this.tipoFlor = tipoFlor;
    }
}


