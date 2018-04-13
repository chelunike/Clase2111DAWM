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
       
        
        try{
            this.setValor(v);
                
        }
        
        catch(ExcepcionConjuntoValor e){
            this.valor=0;
        }
        
        this.setNombre(n);
    }
    
    
//    --modifique setValor
    public void setValor(int valor) throws ExcepcionConjuntoValor {
        if (valor < 0) 
            throw new ExcepcionConjuntoValor();
      
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
     

    @Override
      public boolean equals(Object  e){
         Elemento o= (Elemento)e; 
         
         if(this.getNombre().compareToIgnoreCase(o.getNombre())==0 && this.getValor()==o.getValor())
                    return true;
         else
            return false;
         
     }
//    
}
