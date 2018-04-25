package escuela_2.pkg0;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author yo
 */
public class Clase{
    //-----Atributos--------
    private String curso;
    private ArrayList <Alumno> alumn;
    
    //-------------Constructores-------------
    public Clase(String curso){
        this.curso = curso;
        alumn = new <Alumno> ArrayList();
    }
    
    /*   _____________________________
        |        Constructora         |
        |   Chapuzas Molina y Amigos  |
        |_____________________________|
        |  __________    _______      |
        | | __   __  |  | _____ |     |
        | ||__| |__| |  ||     ||     |
        | | __   __  |  ||_____||     |
        | ||__| |__| |  |    --o|     |
        | |__________|  |       |     |
    ____|_______________|_______|_____|_________
    */ 
    //-----------Get y Set-----------
    
    public Alumno getAlumn(int ind){
        return alumn.get(ind);
    }
    
    
    //--------Metodos---------
    
    public void insertarAlumno(Alumno al1){
        alumn.add(al1);
    }
    
    public int buscar(Alumno al1){
        return buscar(al1.getNombre());
    }
    
    public int buscar(String nombre){
        int i=0;
        for(Alumno n:alumn){
            if(n.getNombre().compareToIgnoreCase(nombre)==0)
                return i;
            i++;
        }
        return -1;
    }
    
    public boolean borrar(Alumno al1){
        return borrar(al1.getNombre());
    }
    
    public boolean borrar(String nombre){
        if(buscar(nombre)>0){
            alumn.remove(buscar(nombre));
            return true;
        }else
            return false;
    }
    
    public void ordenarNombre(){
        alumn.sort(null);
    }
    
    public void ordenaFechaNaci(){
        alumn.sort(new ordenaFecha());
    }
    
    public String listaAsigAprobadas(){
        String cad="";
        String[] asigs = Cursos.getAsig();
        for(Alumno al1:alumn){
            
           
        }
        return cad;
    }
    
    
    
    @Override
    public String toString(){
        String cad="";
        cad += "NumExp\tNombre\tFechaNaci\tNotaMedia\n";
        for(Alumno n:alumn)
            cad += n.getNumExp()+"\t"+n.getNombre()+"\t"+n.getFechaNaci()+"\t"+n.notaMedia()+"\n";
        return cad;
    }
    
    //---------Comparadores----------
    
    public class ordenaFecha implements Comparator <Alumno>{

        @Override
        public int compare(Alumno o1, Alumno o2) {
            return o1.getFechaNaci().compareTo(o2.getFechaNaci());
        }
        
    }
    
}
