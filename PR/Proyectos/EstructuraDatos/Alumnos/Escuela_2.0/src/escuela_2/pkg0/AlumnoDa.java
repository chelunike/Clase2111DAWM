package escuela_2.pkg0;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author yo
 */
public class AlumnoDa extends Alumno {
    
    //Variables
    String notaFct;
    double notaProyect;
    
    //Constructor
    public AlumnoDa(){}
    public AlumnoDa(String nombre, LocalDate fechaNaci, String notaFct, double notaProyecto){
        super(nombre, fechaNaci);
        this.notaFct = notaFct;
        this.notaProyect = notaProyecto;
        this.setCurso("Formacion Profesional");
    }
    
    public AlumnoDa(String nombre, String fechaNaci, String notaFct, double notaProyecto){
        super(nombre, fechaNaci);
        this.notaFct = notaFct;
        notaProyect = notaProyecto;
        this.setCurso("Bachiller");
    }
    
    //Get y Set

    //Metodos
    
    @Override
    public double notaMedia(){
        double medias = 0;
        ArrayList <AsigNota> tmp = this.getNotas();
        if(this.notaFct.compareToIgnoreCase("Apto") == 0){
            for(AsigNota n:tmp)
                medias += n.getNota();

            medias += this.notaProyect;
            medias /= tmp.size()+1;
        }

        return medias;
    }
    
    @Override
    public String[] asignaturas(){
        return this.getAsigFp();
    }
    
}
