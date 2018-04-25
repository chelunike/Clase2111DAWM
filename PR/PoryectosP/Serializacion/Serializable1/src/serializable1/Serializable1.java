
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable1;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author juan
 */
public class Serializable1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Fernando", "Ureña", 23, 800);
        Empleado empleado2 = new Empleado("Antonio", "Lopez", 35, 1000);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.ddr"))) {
            //Escribimos en un fichero
            oos.writeObject(empleado1);
            oos.writeObject(empleado2);
        } catch (IOException e) {
            System.err.println("error " + e.getMessage());
        }

        try (ObjectInputStream ois = 
                new ObjectInputStream(new FileInputStream("empleados.dd"))) {
            //Cuando no haya mas objetos saltara la excepcion EOFException
            while (true) {
                Empleado aux = (Empleado) ois.readObject();
                System.out.println(aux.getNombre());
                System.out.println(aux.getApellido());
                System.out.println(aux.getEdad());
                System.out.println(aux.getSalario());
                System.out.println("");
            }
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (EOFException e) {
            System.err.println("EOF");
        } catch (IOException e) {
            try {
                System.out.println("hola"+e.getMessage());
                Desktop.getDesktop().browse(new URI("https://stackoverflow.com/search?q="+e.getMessage()));
                System.out.println("hola2");
            } catch (IOException | URISyntaxException ee) {
                System.out.println("chungo");
            }
            //Desktop.getDesktop().browse(new URI("https://stackoverflow.com/search?q="+e.getMessage()));
        }

    }

}
