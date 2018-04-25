/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipersonas;
import java.io.*;
/**
 *
 * @author depa10
 */
public class IOSerializar {
    
    private static ObjectInputStream input = null;
    private static ObjectOutputStream output = null;
    
    public static void serializarObjeto( String ruta, Object o ) {
        
        try
        {
            FileOutputStream file = new FileOutputStream(ruta);
            output = new ObjectOutputStream(file);
            
            output.writeObject(o);
        }
        catch(IOException e){}
        finally
        {
            try 
            {
                output.close();
            } catch (IOException ex) {}
        }
    }
    
    public static Object deserializarObjecto( String ruta ) {
        
        Object o = null;
        File fichero = new File(ruta);
        
        //Si existe el fichero obtenemos el objeto
        if ( fichero.exists() ) {
            
            try
            {
                FileInputStream file = new FileInputStream(fichero);
                input = new ObjectInputStream(file);
                
                o = input.readObject();
            }
            catch( ClassNotFoundException | IOException e){}
            finally
            {
                try
                {
                    input.close();
                }
                catch(IOException e){
                    System.out.println("Sin datos");
                
                
                }
            }
        }
        
        return o;
    }
    
}
