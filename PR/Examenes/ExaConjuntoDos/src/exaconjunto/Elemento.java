/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaconjunto;

/**
 *
 * @author prg
 */
public class Elemento {
    private String nombre;
    private int valor;
    
    public Elemento(){
        
    }
    
    public Elemento(String n, int v){
       
        -- escriba código
        setValor(v);
        
        
   
        setNombre(n);
    }
    
    
    --modifique setValor
    public void setValor(int valor) {
        if (valor < 0) 
            
      
        this.valor = valor;
    
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }
     public String toString() {
        String salida = "";
        salida += "nombre: " + nombre + " // valor: " + valor;

        return salida;
    }
     

      public boolean equals(Object  e){
         -- escriba código
                    return true;
         return false;
         
     }
//    
}
