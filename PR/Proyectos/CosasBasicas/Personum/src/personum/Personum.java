package personum;
/**
 * @author yo
 */
public class Personum {

    public static void main(String[] args) {
        // NINIO escribe aki er codijo
        
        //Instancio Lista
        Lista link = new Lista();
        
        //Creo personas himajinarias
        Persona patata = new Persona("Patata",12,2,2017,0.2);
        Persona yo = new Persona("Yo","03-03-1999",1.6);
        Persona manuer = new Persona("Manuel","01-10-1999",1.7);
        Persona paco = new Persona("Josemi","16-04-1999",2.1);
        Persona sapatoz = new Persona("David","01-01-1890",2.9);

        //Inserto personas himajinarias
        link.insertarOrden(yo);
        link.insertarOrden(patata);
        link.insertarOrden(manuer);
        link.insertarOrden(paco);
        link.insertarOrden(sapatoz);
        
        //Ordenaaaaaaaaaaaaaa
        //link.ordenaFecha();
        
        //Imprimio la Lista
        System.out.println("LIstao: \n"+link.toString());
        
    }
    
}
