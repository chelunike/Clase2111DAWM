
package exa_gprimitiva;

import java.io.*;
public class IO {
    
    public static String leeFichero(String nomFichero) {
        String salida="",c;
        BufferedReader input = null; 
        try{
            input = new BufferedReader(new FileReader(nomFichero));
            while((c=input.readLine())!=null)
                salida += c+System.lineSeparator();
            input.close();
        }catch(IOException e){
            System.out.println(""+e);
        }
        return salida;
    }

    public static void escribe(String nomFichero, String texto) {
       BufferedWriter output=null;
        try{
           output = new BufferedWriter(new FileWriter(nomFichero));
           output.write(texto);
           output.close();
        }catch(IOException e){
            System.out.println(""+e);
        }
    }
    
    
}
    

