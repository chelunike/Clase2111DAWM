package alumno;
import java.util.ArrayList;
import java.util.Comparator;

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
    
    //Ordena
    public void ordenaPorNombre(){
        lista.sort(null);
    }
    
    public void ordenaPorFechaNacimiento(){
        lista.sort(new ordenaFecha());
    }
    
    //Get
    public int size(){
        return lista.size();
    }
    
    public Persona getPersona(int index){
        return lista.get(index);
    }
    
    public class ordenaFecha implements Comparator <Persona>{

        @Override
        public int compare(Persona p1, Persona p2) {
            return p1.getFechaNaci().compareTo(p2.getFechaNaci());
        }
    
    }
    
    
    
    
}
