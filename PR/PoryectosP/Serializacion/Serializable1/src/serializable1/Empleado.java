/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable1;
import java.io.Serializable;
/**
 *
 * @author juan
 */
public class Empleado implements Serializable {
 
    protected String nombre;
       protected String apellido;
        protected int edad;
        protected double salario;
     
    
 
   
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
     
    public double getSalario() {
        return salario;
    }
    
   
    public  void setSalario(double salario) {
        this.salario = salario;
    }
    
     public String getApellido() {
        return apellido;
    }
     
     public void setApellido ( String ape){
         apellido = ape;
     }
     
    public boolean equals (Empleado a){
         
        if(a.getNombre().equals(nombre) && a.getApellido().equals(apellido)){
            return true;
        }else{
            return false;
        }
    }
     
   
     
    public String toString (){
        String mensaje="El empleado se llama "+nombre+" "+apellido+" con "+edad+" años " +
                "y un salario de "+salario;
        return mensaje;
    }
   
 
   
    public Empleado(String nombre, String apellido, int edad, double salario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.salario=salario;
    }
}


    

