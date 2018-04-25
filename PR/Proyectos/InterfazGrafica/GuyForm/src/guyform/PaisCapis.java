package guyform;
/**
 * @author SIDiu
 */
public class PaisCapis {
    
    //Atributos
    private String pais;
    private String capital;
    
    public PaisCapis(String pais, String capital){
        this.pais = pais;
        this.capital = capital;
    }
    
    
    //Metodos Get y Set

    public String getPais() {
        return pais;
    }

    public void setPais(String Pais) {
        this.pais = Pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String Capital) {
        this.capital = Capital;
    }
    
    
}
