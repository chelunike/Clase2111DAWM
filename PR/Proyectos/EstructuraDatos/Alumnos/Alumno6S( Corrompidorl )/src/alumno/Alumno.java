package alumno;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author yo
 */
public class Alumno extends Persona implements Serializable{
    
    //Atributos
    private int curso;
    //private AsigNota[] notas;
    private ArrayList <AsigNota> notas;
    public static String[] Asignaturas = {"Mates","Programacion","Fisica","Sistemas"
                ,"Dib Tec","Lengua","Historia","Ingles"};
    
    //Constructor
    public Alumno(String nombre, LocalDate fechaNacimiento, int curso){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        notas = new ArrayList();
    }
    
    public Alumno(String nombre, String fechaNacimiento, int curso){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        notas = new ArrayList();
    }
    
    public Alumno(String nombre, LocalDate fechaNacimiento, int curso, ArrayList<AsigNota> notas){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        this.notas = notas;
    }
    
    public Alumno(String nombre, String fechaNacimiento, int curso, ArrayList<AsigNota> notas){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        this.notas = notas;
    }
    
    //Metodos
    public void autoAsigNota(int n){
        String[] asig = {"Mates","Programacion","Fisica","Sistemas"
                ,"Dib Tec","Lengua","Hitoria","Ingles","Patata"};
        if(n<=asig.length)
            for(int i=0; i<n; i++){
                double nota = ((double)((int)(Math.random()*1000)))/100;
                AsigNota tmp = new AsigNota(asig[i], nota);
                notas.add(tmp);
            }
    }
    
    //Get
    public int getCurso() {
        return curso;
    }
    
    //-- -- -- Notas -- -- -- 
    public ArrayList <AsigNota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList <AsigNota> notas) {
        this.notas = notas;
    }
    
    public void añadirNotas(AsigNota nota){
        notas.add(nota);
    }
    
    public AsigNota getNota(int index){
        return notas.get(index);
    }
    
    public void eliminarAsigNota(AsigNota nota){
        notas.remove(nota);
    }
    
    public boolean tieneAsignatura(String asig){
        for(AsigNota nota:notas){
            if(nota.getAsig().compareToIgnoreCase(asig)==0)
                return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "Nombre"+super.getNombre()+", FechaNaci"+super.getFechaNaci().toString()+" ,Curso: "+curso+" ,Notas: "+notas.toString() ;
    }
    
}
