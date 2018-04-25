/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbventasempart;

import java.util.ArrayList;


public class EmpleadoArticuloTotal  {
    private int idEmp;
    private ArrayList<ArticuloTotal> lista;
    
    
    public EmpleadoArticuloTotal(int idEmp){
        this.idEmp = idEmp;
        lista = new ArrayList<ArticuloTotal>();       
    }
    
    public void insertaArticuloTotal(ArticuloTotal arTot){
        lista.add(arTot);
    }
    
    public double getTotal(){
        double total=0;
         for(ArticuloTotal arTot:lista)
            total += arTot.getTotal();
         return total;
        
    }
    
    public String toString(){
        String salida="IdEmp: "+String.valueOf(idEmp)+" Total:"+getTotal()+"\n\t";
        for(ArticuloTotal arTot:lista)
            salida += arTot.toString()+"\t";
      
        return salida;
    }
    
    
}
