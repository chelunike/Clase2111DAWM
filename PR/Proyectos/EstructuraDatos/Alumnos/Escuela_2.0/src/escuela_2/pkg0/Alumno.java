package escuela_2.pkg0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yo
 */
public abstract class Alumno extends Cursos{
    
    //Variable
    private static int lastExp = 0;
    private int numExp;
    private String nombre;
    private LocalDate fechaNaci;
    private String curso;
    
    ArrayList <AsigNota> notas;
    /*      
    //Constructores
    public Alumno(){}
    public Alumno(String nombre, LocalDate fechaNaci){
        numExp = lastExp;
        lastExp++;
        this.nombre = nombre;
        this.fechaNaci = fechaNaci;
        try{
            LocalDate hoy = LocalDate.now();
            if((int)ChronoUnit.YEARS.between(this.fechaNaci, hoy) <= 0)
                throw new errorFecha();
        }catch(errorFecha e){
            System.out.println(e);
        }
        notas = new <AsigNota> ArrayList();
        this.insertarAsigs();
        this.insertaNotasRandom();
    }
    
    public Alumno(String nombre, String fechaNaci){
        numExp = lastExp;
        lastExp++;
        this.nombre = nombre;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //--Capturando Errores DateTimeParseException
        try{
            this.fechaNaci = LocalDate.parse(fechaNaci,fmt);
            LocalDate hoy = LocalDate.now();
            if((int)ChronoUnit.YEARS.between(this.fechaNaci, hoy) <= 0)
                throw new errorFecha();
            
        }catch(errorFecha p){
            System.err.println(p);
        }catch(java.time.format.DateTimeParseException n){
            System.err.println("Error, Formato de fecha incorrecto\n\t Vayase a freir esparragos :) \n\t Y que tenga un buen dia");
        }catch(Exception e){
            System.err.println("Error inesperado en tiempo de ejecucion");
        }
        //--Notas
        notas = new <AsigNota> ArrayList();
        this.insertarAsigs();
        this.insertaNotasRandom();
    }
    */
    //Get y Set

    public int getNumExp() {
        return numExp;
    }

    public void setNumExp(int numExp) {
        this.numExp = numExp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(LocalDate fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String Curso) {
        this.curso = Curso;
    }

    public ArrayList<AsigNota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<AsigNota> notas) {
        this.notas = notas;
    }
    
    public int getEdad(){
        int edad = 0;
        try{
            LocalDate tmp = this.getFechaNaci();
            LocalDate hoy = LocalDate.now();
            edad = (int)ChronoUnit.YEARS.between(tmp, hoy);
        }catch( java.lang.NullPointerException e){
            System.err.println("No existe edad \n\t Vayase a freir esparragos :) \n\t Y que tenga un buen dia");
        }
        return edad;
    }
    
    
    //Metodos
    public abstract double notaMedia();
    public abstract String[] asignaturas();
    
    public void insertarAsigs(){
        String[] asig = this.asignaturas();
        for(int i=0; i<asig.length; i++){
            AsigNota asign = new AsigNota(asig[i]); 
            notas.add(asign);
        }
    }
    
    public void insertaNotasRandom(){
        for(AsigNota n:notas){
            double nota = (double)((int)(Math.random()*1000))/100;
            n.setNota(nota);
        }
    }
    
    public void insertarNotas(){
        Scanner en = new Scanner(System.in);
        System.out.println("Notas de alumno: "+this.getNombre());
        for(AsigNota n:notas){
            System.out.printf("\nInserte nota de "+n.getAsig()+" :");
            double nota = en.nextDouble();
            n.setNota(nota);
        }
    }
    
    @Override
    public String toString(){
        String cad = "\n";
        cad += this.getNumExp()+"\t";
        cad += this.getNombre()+"\t";
        cad += this.getEdad() + "\t";
        cad += this.getCurso()+"\t";
        cad += this.notaMedia();
        return cad;
    }
    
    
    
    public class errorFecha extends Exception{
        
        public errorFecha(){
            System.err.println("Error en la fecha de Nacimiento:\n\tPor poco inteligente");
        }
        
        @Override
        public String toString(){
            return "Error rn la fecha de Nacimiento: \nno puede ser posterior al dia de hoy";
        }
    }
    
    public class errorMenor extends Exception{
        
        public errorMenor(){
            System.err.println("Error la fecha de Nacimiento\n\tPor poco inteligente");
        }
        
        @Override
        public String toString(){
            return "Error la fecha de Nacimiento \nno puede ser posterior al dia de hoy";
        }
    }
    
    
}
