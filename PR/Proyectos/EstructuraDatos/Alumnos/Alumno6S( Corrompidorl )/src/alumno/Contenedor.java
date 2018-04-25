package alumno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author yo
 */
public class Contenedor implements Serializable{
        
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
    
    @Override
    public String toString(){
        String c="";
        for(Persona al1:lista)
            c += al1.toString();
        return c;
    }
    
    
}
