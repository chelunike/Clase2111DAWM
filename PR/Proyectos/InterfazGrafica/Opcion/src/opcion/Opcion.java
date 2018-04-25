package opcion;

/**
 * @author SIDiu
 */
public class Opcion {

    private String descCorta;
    private String descLarga;

    public Opcion(String descCorta, String descLarga) {
        this.descCorta = descCorta;
        this.descLarga = descLarga;
    }

    public String getDescCorta() {
        return descCorta;
    }

    public void setDescCorta(String descCorta) {
        this.descCorta = descCorta;
    }

    public String getDescLarga() {
        return descLarga;
    }

    public void setDescLarga(String descLarga) {
        this.descLarga = descLarga;
    }


}
