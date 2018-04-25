package alumno6serial;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author yo
 */
public class Persona implements Comparable <Persona>, Serializable{
        
    //Atributos
    private String nombre;
    private LocalDate fechaNaci;
    
    //Constructor
    public Persona(String nombre, LocalDate fechaNacimiento){
        this.nombre = nombre;
        fechaNaci = fechaNacimiento;
    }
    
    public Persona(String nombre, String fechaNacimiento)throws java.time.format.DateTimeParseException {
        this.nombre = nombre;
//        try{
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fecha = LocalDate.parse(fechaNacimiento, fmt);
            fechaNaci = fecha;
//        }catch(Exception e){
//            System.err.println("Error al insertar fecha de nacimiento"+e);
//            fechaNaci = LocalDate.now();
//        }
    }
    
    //Metodos
    //SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setFechaNaci(LocalDate fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    //Get
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNaci() {
        return fechaNaci;
    }
    
    public String getFechaNaciToString() {
        return ""+fechaNaci.getDayOfMonth()+"-"+fechaNaci.getMonth().getValue()+"-"+fechaNaci.getYear();
    }
    
    @Override
    public int compareTo(Persona p) {
        return nombre.compareToIgnoreCase(p.getNombre());
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombre+" FechaNaci: "+fechaNaci.toString();
    }
    
}
