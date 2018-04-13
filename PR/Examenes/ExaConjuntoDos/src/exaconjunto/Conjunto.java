/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaconjunto;

import java.util.ArrayList;

/**
 *
 * @author prg
 */
public class Conjunto {
    private ArrayList<Elemento> elementos;
    
    public Conjunto(){
     -- escriba código
    }
    
    
     public ArrayList<Elemento> getElementos(){
         return elementos;
     }


      
      
       public boolean pertenece(Elemento e){
              --escriba código
     }
     
     
     
    
     
     public boolean  inserta(Elemento e){
        -- escriba código
     }
     

     
    
     public void union(Conjunto con){
        -- escriba código
     }
     
     
      
      
     public String toString(){
         String salida ="listado del conjunto \n";
        --escriba código
         return salida;
     }
}
