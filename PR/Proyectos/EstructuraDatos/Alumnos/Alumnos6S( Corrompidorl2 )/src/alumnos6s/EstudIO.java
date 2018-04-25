package alumnos6s;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author yo
 */
public class EstudIO {
    //Atributos
    private ArrayList <Object> objetos;
    
    //Contructor
    public EstudIO(){
        objetos = new ArrayList();
    }
    
    public EstudIO(ArrayList <Object> objeto){
        objetos = objeto;
    }
    
    //Metodos
    public void insertarObjeto(Object obj){
        objetos.add(obj);
    }
    
    public boolean serializacion(){
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("aplicasion.info"))) {
            //Escribimos en un fichero
            for(Object se: objetos)
                escritor.writeObject(se);
            return true;
        } catch (IOException e) {
            System.err.println("OHHHHHHHHHHH:( " + e);
            return false;
        } 
    }
    
    public ArrayList <Object> desSerializacion(){
        ArrayList <Object> objects = new ArrayList();
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream("aplicasion.info"))) {
            //Cuando no haya mas objetos saltara la excepcion EOFException
            while (true) {
                Object tmp = lector.readObject();
                objects.add(tmp);
            }
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            return objects;
        } catch (EOFException e) {
            System.err.println("EOF");
            return objects;
        } catch (IOException e) {
            System.err.println(e);
            return objects;
        }
    }
    
    /**
     * 
     * - -- - -- - METODOS ESTATICOS - -- -- - 
     * 
     */
    
    public static boolean serializa(Object obj, String fichero){
    try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero))) {
            //Escribimos en un fichero
            escritor.writeObject(obj);
            return true;
        } catch (IOException e) {
            System.err.println("OHHHHHHHHHHH:( " + e);
            return false;
        } 
    }
    
    public static Object desSerializa(String fichero){
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
            //Cuando no haya mas objetos saltara la excepcion EOFException
            return lector.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            return null;
        } catch (EOFException e) {
            System.err.println("EOF");
            return null;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
    
    
    
}
