/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbventasempart;

/**
 *
 * @author prg
 */
public class ArticuloTotal {
    private int id;
    private double total;
    
    public ArticuloTotal(int id, double total){
        this.id = id;
        this.total = total;
        
    }
    
    public double getTotal(){
        return total;
    }
    
    public String toString(){
        return "idArt:"+id+" Total:"+total;
    }
    
}
