package personum;
import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.Scanner;
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
        String s="\nNombre\tFechaNaci\tEdad\tAltura\n";
        for(Persona p:lista)
            s += p.toString() +"\n";
        return s;
    }
    
    
    
    
    /**
     * 
     * Clases Internas :) 
     *  
     *  _______            ____     ______  ______  ______
     * |         |        /    \   |       |       |      
     * |         |       |      |  |       |       |       
     * |         |       |------|  |-----| |----   |-----|
     * |         |       |      |        | |             |
     * |_______  |______ |      |  ______| |______ ______|
     * 
     */
    
    
    public class OPA implements Comparator <Persona>{

        @Override
        public int compare(Persona p1, Persona p2) {
            return Double.compare(p1.getAltura(), p2.getAltura());
        }
    }
    
    
    public class OPEL implements Comparator <Persona>{
    
        @Override
        public int compare(Persona o1, Persona o2){
            return Integer.compare(o1.getEdad(), o2.getEdad());
        }
    }
    
    
    public class OrdenaPorFecha implements Comparator <Persona>{
        @Override
        public int compare(Persona o1, Persona o2) {
            return o1.getFecha().compareTo(o2.getFecha());
        }
    }
    
}
