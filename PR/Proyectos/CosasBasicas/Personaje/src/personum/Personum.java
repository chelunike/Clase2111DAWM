    package personum;

import java.time.LocalDate;
import java.util.Scanner;

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
        
        LocalDate d = Personum.leerFecha();
        
        Persona Javi = new Persona("Javier",d,1.0);
        
        //Inserto personas himajinarias
        link.insertarOrden(yo);
        link.insertarOrden(patata);
        link.insertarOrden(manuer);
        link.insertarOrden(paco);
        link.insertarOrden(sapatoz);
        link.insertar(Javi);
        
        //Ordenaaaaaaaaaaaaaa
        link.ordenaFecha();
        
        //Imprimio la Lista
        System.out.println("LIstao: \n"+link.toString());
        
    }
    
    public static LocalDate leerFecha(){
        LocalDate fecha = LocalDate.now();
        Scanner en = new Scanner(System.in);
        System.out.print(" Inserte fecha en formato dd-mm-aaaa: ");
        String cfecha = en.next();
        
        String cDia = "", cMes ="", cAño ="";
        
        try{
            
            //NumberFormatException
            cDia = cfecha.substring(0, 2);
            cMes = cfecha.substring(3, 5);
            cAño = cfecha.substring(6);

            int dia = Integer.parseInt(cDia);
            int mes = Integer.parseInt(cMes);
            int año = Integer.parseInt(cAño);

            fecha = LocalDate.of(año, mes, dia);

            
        }catch(Exception e){
            System.out.println("error: "+e);
        }
        return fecha;
        
    }
        
}
