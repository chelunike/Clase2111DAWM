package alumno;

import java.util.ArrayList;

/**
 * @author yo
 */
public class LayoutNulo {
    
    //Constructoer
    public LayoutNulo(){
        //Creamos Contenedor
        Contenedor cont1 = new Contenedor();
        
        Alumno al1 = new Alumno("David", "12-12-1989", 1);
        Alumno al2 = new Alumno("Josemi", "12-12-1999", 1);
        Alumno al3 = new Alumno("Patata", "01-01-2000", 1);
        Alumno al4 = new Alumno("David", "12-12-1714", 2);
        Alumno al5 = new Alumno("Josemi", "12-12-1999", 2);
        Alumno al6 = new Alumno("Patata", "01-01-2000", 2);
        
        al1.autoAsigNota(6);
        //al2.autoAsigNota();
        al3.autoAsigNota(6);
        al4.autoAsigNota(6);
        al5.autoAsigNota(6);
        al6.autoAsigNota(6);
        
        cont1.insertarPersona(al1);
        cont1.insertarPersona(al2);
        cont1.insertarPersona(al3);
        cont1.insertarPersona(al4);
        cont1.insertarPersona(al5);
        cont1.insertarPersona(al6);
        
        //Contenedor info = (Contenedor)EstudIO.desSerializa("alumnos.info");
        
        //System.out.println("Contenedor deserializado: \n"+info.toString());
        
        //Ventanuco ventana = new Ventanuco(info!=null?info:cont1);
        System.out.println("Saliendo Ventana");
        Ventanuco ventana = new Ventanuco(cont1);
        Contenedor result = ventana.getContenedor();
        
        System.out.println("Resultado: "+result.toString());
        
        EstudIO.serializa(result!=null?result:cont1, "alumnos.info");
        System.out.println("Hecho :)");
    }
    
    //Metodo Main
    public static void main(String[] args) {
        // TODO code application logic here
        LayoutNulo.darVueltas();
    }
    
    //Metodo para dar vueltas
    private static void darVueltas(){
        new LayoutNulo();
    }
    
}
