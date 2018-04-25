package linkedlist;
import java.util.ArrayList;
/**
 * @author SIDiu
 */
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // El codijo aki
        
        /*
            Ejemplo de uso de ArrayList.
        */
        
        //Declarar
        ArrayList <String> ol = new ArrayList <String>();
        
        //Insertar
        ol.add("Yo");
        ol.add("Juan");
        ol.add("Patata");
        ol.add("Manolo");
        
        ol.add(3, "Yo");
        
        ol.sort(null);
        //Modificar un valor existente
        ol.set(0, "MiNombre");
        
        //Recorrelos
        for(int i=0; i<ol.size(); i++)
            System.out.println("Element: "+ ol.get(i));
        
//Longuitud y toString
        System.out.println("Lon: "+ol.size());
        System.out.println("Lista: "+ ol.toString());
        
        
        
        
        /*
            Lista de objetos dinamica luego puede redimensionarse
            http://www.enrique7mc.com/2016/07/diferencia-entre-arraylist-y-linkedlist/
            https://www.redeszone.net/2012/03/05/curso-de-java-estructuras-de-datos-arraylist-y-linkedlist/
        
        */
        LinkedList l = new LinkedList();
        
        
        
        
    }
    
}
