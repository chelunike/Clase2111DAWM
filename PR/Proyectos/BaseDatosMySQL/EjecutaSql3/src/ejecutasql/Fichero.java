package ejecutasql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yo
 */
public class Fichero {
    // -- -- Metodos Estaticos -- --
    public static void escribe(String ruta, String texto){
        BufferedWriter output=null;
        try{
           output = new BufferedWriter(new FileWriter(ruta));
           output.write(texto);
           output.close();
        }catch(IOException e){
            System.out.println(""+e);
        }
    }
    
    public static String leer(String ruta){
        String salida="",c;
        BufferedReader input = null; 
        try{
            input = new BufferedReader(new FileReader(ruta));
            while((c=input.readLine())!=null)
                salida += c+System.lineSeparator();
            input.close();
        }catch(IOException e){
            System.out.println(""+e);
        }
        return salida;
    }
}
