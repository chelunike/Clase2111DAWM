package escuela_2.pkg0;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author yo
 */
public class AlumnoBch extends Alumno{
    
    //Variables
    double notaPau;
    
    
    //Constructor
    public AlumnoBch(){}
    public AlumnoBch(String nombre, LocalDate fechaNaci, double notaPau){
        super(nombre, fechaNaci);
        this.notaPau = notaPau; 
        this.setCurso("Bachiller");
    }
    
    public AlumnoBch(String nombre, String fechaNaci, double notaPau){
        super(nombre, fechaNaci);
        this.notaPau = notaPau;
        this.setCurso("Bachiller");
    }
    
    //metodos
    
    @Override
    public double notaMedia(){
        double medias = 0;
        ArrayList <AsigNota> tmp = this.getNotas();
        for(AsigNota n:tmp)
            medias += n.getNota();

        medias += this.notaPau;
        medias /= tmp.size()+1;
        
        return medias;
    }
    
    @Override
    public String[] asignaturas(){
        return this.getAsigBch();
    }
    
    
}
