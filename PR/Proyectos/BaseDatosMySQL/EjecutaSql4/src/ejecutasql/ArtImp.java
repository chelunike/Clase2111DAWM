package ejecutasql;

/**
 * @author yo
 */
public class ArtImp {
    // Atributos
    private int id;
    private double importe;
    
    // Constructor
    public ArtImp(int idArt){
        this.id = idArt;
        importe = 0;
    }
    
    // Metodos
    
    // -- Get Y Set

    public int getIdArt() {
        return id;
    }
    
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    public void sumImporte(double importe) {
        this.importe += importe;
    }
    
    public void resetTotal(){
        importe =0; 
    }
    
    public String toString(){
        return "IdArt: "+id+" Importe: "+importe;
    }
    
}
