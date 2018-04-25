package alumno;
import java.time.LocalDate;

/**
 * @author yo
 */
public class Alumno extends Persona{
    
    //Atributos
    private int curso;
    private AsigNota[] notas;
    public static String[] Asignaturas = {"Mates","Programacion","Fisica","Sistemas"
                ,"Dib Tec","Lengua","Hitoria","Ingles"};
    
    //Constructor
    public Alumno(String nombre, LocalDate fechaNacimiento, int curso){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        notas = new AsigNota[5];
    }
    
    public Alumno(String nombre, String fechaNacimiento, int curso){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        notas = new AsigNota[5];
    }
    
    public Alumno(String nombre, LocalDate fechaNacimiento, int curso, AsigNota[] notas){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        this.notas = notas;
    }
    
    public Alumno(String nombre, String fechaNacimiento, int curso, AsigNota[] notas){
        super(nombre,fechaNacimiento);
        this.curso = curso;
        this.notas = notas;
    }
    
    //Metodos
    public void autoAsigNota(){
        String[] asig = {"Mates","Programacion","Fisica","Sistemas"
                ,"Dib Tec","Lengua","Hitoria","Ingles","Patata"};
        if(notas.length<=asig.length)
            for(int i=0; i<notas.length; i++){
                double nota = ((double)((int)(Math.random()*1000)))/100;
                AsigNota tmp = new AsigNota(asig[i], nota);
                notas[i] = tmp;
            }
    }
    
    //Get
    public int getCurso() {
        return curso;
    }

    public AsigNota[] getNotas() {
        return notas;
    }

    public void setNotas(AsigNota[] notas) {
        this.notas = notas;
    }
    
    
    
    public String toString(){
        return "Curso: "+curso+" ,Notas: "+notas.toString() ;
    }
    
}
