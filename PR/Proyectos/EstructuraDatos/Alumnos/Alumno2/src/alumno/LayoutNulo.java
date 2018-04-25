

package alumno;

/**
 * @author yo
 */
public class LayoutNulo {
    
    //Constructoer
    public LayoutNulo(){}
    
    //Metodo Main
    public static void main(String[] args) {
        // TODO code application logic here
        //Creamos Contenedor
        Contenedor cont1 = new Contenedor();
        
        Alumno al1 = new Alumno("David", "12-12-1888", 1);
        Alumno al2 = new Alumno("Josemi", "12-12-1999", 1);
        Alumno al3 = new Alumno("Patata", "01-01-2000", 1);
        
        
        cont1.insertarPersona(al1);
        cont1.insertarPersona(al2);
        cont1.insertarPersona(al3);
        
        Ventanuco ventana = new Ventanuco(cont1, cont1);
        
    }
    
    //Metodo para dar vueltas
    private static void darVueltas(){
        new LayoutNulo();
    }
    
}
