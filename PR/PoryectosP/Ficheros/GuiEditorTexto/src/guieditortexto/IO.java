
package guieditortexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class IO {
    
    /*
    bloque que lee el archivo elegido y lo pasamos a File para poder recorrerlo
    creamos una variable para saber si hemos llegado al final del archivo
    si no hemos llegado al final, seguimos leyendo
    */
    public String leerFichero(File fichero){
        
        File archivo = fichero;

        String cadena = "";
        String contenido = "";
        try {
            
            FileReader fileReader = new FileReader(archivo);
            int valor = fileReader.read(); 
            
            while (valor != -1) {
                //cadena = cadena + valor; /*si no se hace el casting, muestra el valor númerico*/
                cadena = cadena +(char) valor;
                valor = fileReader.read();
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de lectura");
        }
    return cadena;   
    }
    
    /*
    Bloque para crear un nuevo fichero con el nombre que le pasamos, una vez lo creamos,
    podemos modificarlo en el TA y al guardar, se añade el contenido al fichero. 
    */
    
    public void nuevoArchivo(String nombre){
        
        String texto = nombre;
        FileWriter fileWriter;
       
        try {
            
           fileWriter = new FileWriter(nombre);
           JOptionPane.showMessageDialog(null, "Fichero creado correctamente");
           fileWriter.close();
           
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir, No se encuentra el archivo");
        } catch (IOException ex) {    
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* 
    bloque para guardar un fichero, donde le pasamos el nombre del archivo y su contenido
    */
    public void guardarFichero(String nombre, String cadena){
        
        File archivo = new File(nombre);
        FileWriter escribir;
        try {
            
            escribir = new FileWriter(nombre, true);
            escribir.write(cadena);
            escribir.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }
    
    
    
}
