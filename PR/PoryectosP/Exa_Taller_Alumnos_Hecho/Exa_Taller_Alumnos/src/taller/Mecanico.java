/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @author juan
 */
public class Mecanico {
    private String nombre;
    private int especialidad;// especialidad 0, 1, ó 2

     public Mecanico (String mec, int esp){
        nombre = mec;
        especialidad = esp;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString(){
       return "\n"+"Nombre: "+this.nombre+"//"+"Especialidad: "+this.especialidad+"\n";
    }
  
    
}
