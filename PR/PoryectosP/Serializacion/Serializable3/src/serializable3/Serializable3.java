/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author juan
 */
public class Serializable3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleados empleados = new Empleados();
        Empleado empleado1=new Empleado("Fernando", "Ureña", 23, 800);
        Empleado empleado2=new Empleado("Antonio", "Lopez", 35, 1000);
        Empleado empleado3=new Empleado("Ana", "Perez", 28, 1200);
        empleados.insertEmpleado(empleado1);
        empleados.insertEmpleado(empleado2);
        empleados.insertEmpleado(empleado3);
        
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("empleados.ddr"))){
            //Escribimos en un fichero
            oos.writeObject(empleados);
        }
        catch(IOException e){
            System.err.println("error " + e.getMessage());
        }
        
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("empleados.ddr"))){
            //Cuando no haya mas objetos saltara la excepcion EOFException
                Empleados aux=(Empleados)ois.readObject();
                for (Empleado e :empleados.lista ) {
                    System.out.println(e.toString());
                }
                
            
        }catch(ClassNotFoundException e){
            System.err.println(e.getMessage());
        }catch(EOFException e){
                System.err.println("EOF");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }

        // TODO code application logic here
    }
    
}
