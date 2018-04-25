package personum;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
/**
 * @author yo
 */
public class Persona implements Comparable <Persona> {
    
    //Atributos
    private String nombre;
    private int edad;
    private double altura;
    private LocalDate f;
    
    //Constructores
    public Persona(String nombre, String fechanacimiento, double altura){
        this.nombre = nombre;
        //this.edad = ;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.f = LocalDate.parse(fechanacimiento,fmt);
        this.edad = this.getEdad();
        this.altura = altura;
    }
    
    public Persona(String nombre, LocalDate fechaNaci, double altura){
        this.nombre = nombre;
        this.f = fechaNaci;
        this.edad = this.getEdad();
        this.altura = altura;
    }
    
    public Persona(String nombre, int dia, int mes, int año, double altura){
        this.nombre = nombre;
        this.f = LocalDate.of(año, mes, dia);
        this.edad = this.getEdad();
        this.altura = altura;
    }
    
    public Persona(String nombre, int edad, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }
    
    //Get y Set 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        LocalDate hoy = LocalDate.now();
        return (int)ChronoUnit.YEARS.between(f, hoy);
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public LocalDate getFecha() {
        return f;
    }

    public void setFecha(LocalDate f) {
        this.f = f;
    }
    
    
    
    
    //Metodos
    
    
    
    @Override
    public int compareTo(Persona pe){
        return this.getNombre().compareToIgnoreCase(pe.getNombre());
    }
    
    @Override
    public String toString(){
        return ""+nombre+"\t"+f.toString()+"\t"+edad+"\t"+altura;
    }
    
}
