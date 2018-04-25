package personum;
import java.util.ArrayList;
/**
 * @author yo
 */
public class Lista {
    
    //Lista
    ArrayList <Persona> lista;
    
    //Constructor
    public Lista(){
        lista = new <Persona> ArrayList();
    }
    
    //Metodos
    
    public void insertar(Persona yo){
        lista.add(yo);
    }
     
    //Magia
    public void insertarOrden(Persona pe){
        lista.add(pe);
        this.ordenaNombre();
    }
    
    public void ordenaNombre(){
        lista.sort(null);
    }
    
    public void ordenaEdad(){
        lista.sort(new OPEL());
    }
    
    public void ordenaAltura(){
        lista.sort(new OPA());
    }
    
    public void ordenaFecha(){
        lista.sort(new OrdenaPorFecha());
    }
    
    @Override
    public String toString(){
        String s="\nNombre\tEdad\tAltura\n";
        for(Persona p:lista)
            s += p.toString() +"\n";
        return s;
    }
    
}
