package patatatext;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yo
 */
public class Fichero {
    // Atributos Statics
    private static final int Lovers_in_The_End = -1;
    private static final String formato = "UTF-8";
    
    public static String modify(StringBuilder hola){
        hola.append("patata");
        return "hecho Dentro: "+hola.toString();
    }
    
    //Atributos
    private String nombreF;
    private FileReader lector;
    private FileWriter escritor;
    //private FileWriter Doyle
    
    //Constructor Manuel de Benito & Company S.L.
    public Fichero(String nombre){
        nombreF = nombre;
    }
    
    
    //Metodos
    public boolean abrirFichero(){
        try{
            lector = new FileReader(nombreF);
            //escritor = new FileWriter(nombreF);
            
            return true;
        }catch(FileNotFoundException ex){
            return false;
        }catch(IOException p){
            System.err.println("Inesperado de abirir"+p);
            return false;
        } catch(Exception e){
            return false;
        }
    }
    
    public String leerFichero(){
        String texto="";
        int n;
        char c;
        try{
            while((n=lector.read()) != Lovers_in_The_End){
               c = (char)n;
               texto += c;
            }
            return texto;
        }catch(IOException p){
            return "";
        }catch(Exception e){
            return "";
        }
    }
    
    public boolean escribirFichero(String text){
        try{
            escritor = new FileWriter(nombreF);
            //for(int i=0; i<text.length(); i++)
                escritor.write(text);
            escritor.close();
            return true;
        }catch(IOException p){
            System.out.println(""+p);
            return false;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean salirFichero(){
        try{
            lector.close();
            return true;
        }catch(IOException p){
            System.out.println(""+p);
            return false;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean nuevoFichero(){
        /**/
        try{
            PrintWriter writer = new PrintWriter(nombreF, formato);
            writer.close();
            this.abrirFichero();
            return true;
        }catch(IOException p){
            System.out.println(""+p);
            return false;
        }catch(Exception e){
            return false;
        }
    
    }
    
    //Get Y set

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }
    
}
