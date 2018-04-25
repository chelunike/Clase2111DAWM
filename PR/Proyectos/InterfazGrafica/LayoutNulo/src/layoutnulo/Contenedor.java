package layoutnulo;
import java.util.ArrayList;

/**
 * @author yo
 */
public class Contenedor {
        
    //Atributos
    private ArrayList <Persona> lista;
    
    //Constructor
    public Contenedor(){
        lista = new ArrayList();
    }
    
    //Metodos
    public void insertarPersona(Persona cualquiera){
        lista.add(cualquiera);
    }
    
    public Persona anterior(Persona esta){
        if(lista.indexOf(esta) != 0 )
            return lista.get(lista.indexOf(esta)-1);
        else
            return esta;
    }
    
    public Persona siguiente(Persona esta){
        if(lista.indexOf(esta) != (lista.size()-1) )
            return lista.get(lista.indexOf(esta)+1);
        else
            return esta;
    }
    
    //Get
    public int size(){
        return lista.size();
    }
    
    public Persona getPersona(int index){
        return lista.get(index);
    }
    
    
}
