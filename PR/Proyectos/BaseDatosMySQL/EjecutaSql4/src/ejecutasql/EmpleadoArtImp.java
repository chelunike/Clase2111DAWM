package ejecutasql;

import java.util.ArrayList;

/**
 * @author yo
 */
public class EmpleadoArtImp extends ArtImp{
    // Atributos
    private int id;
    
    // Constructor
    public EmpleadoArtImp(int idEmp, int idArt, double importe){
        super(idArt);
        this.id = idEmp;    
    }
    
    // Metodos
    
    // -- Get Y Set

    public int getId() {
        return id;
    }
    
    public String toString(){
        return "IdEmp: 0"+id+" "+super.toString();
    }
    
}
