 package alumno;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author yo
 */
public class Persona {
        
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
    
    
    //Get
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNaci() {
        return fechaNaci;
    }
    
    
}
