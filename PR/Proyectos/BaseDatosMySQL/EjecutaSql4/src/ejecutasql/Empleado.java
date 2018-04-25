package ejecutasql;

import java.util.ArrayList;

/**
 * @author yo
 */
public class Empleado {
    // Atributos
    private int id;
    private ArrayList <ArtImp> articulos;
    
    // Constructor
    public Empleado(int id){
        this.id = id;
        articulos = new ArrayList();
    }
    
    // Metodos
    
    // -- Get Y Set

    public int getId() {
        return id;
    }

    public ArtImp getArtImp(int index){
        return articulos.get(index);
    }
    
    public ArtImp getArtImpID(int id){
        for(ArtImp a:articulos)
            if(a.getIdArt()==id)
                return a;
        return null;
    }
    
    public boolean insertArtImp(ArtImp ai){
        if(getArtImpID(ai.getIdArt())==null){
            articulos.add(ai);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean contieneArtImp(ArtImp ai){
        if(getArtImpID(ai.getIdArt())==null)
            return false;
        else
            return true;
    }
    
    
    
}
