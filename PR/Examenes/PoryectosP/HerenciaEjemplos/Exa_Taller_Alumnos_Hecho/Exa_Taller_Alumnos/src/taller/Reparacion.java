/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author juan
 */
public class Reparacion implements Comparable <Reparacion> {
    
    private String fecha;
    private ArrayList<Trabajo> trabajos;
    
    public Reparacion (String fe) {
         fecha=fe;
         trabajos= new ArrayList();
    }
    
    public ArrayList<Trabajo> getTrabajos(){
        return trabajos;
    }
    
    
    public String getFecha(){
        return fecha;
    }
    
     public boolean insertaTrabajo(Trabajo t){
         return trabajos.add(t);
         
     }
     
     
    public double calculaImporte(){
        double suma=0;
        for(Trabajo t:trabajos) {
            suma+=t.calculaImporte();
        }
        return suma;
    }
    
    
    @Override
    public String toString(){
        String c="Fecha: "+this.fecha;
        for(Trabajo t: trabajos){
            c+=t.toString();
        }
        return c;
        
    }

    @Override
    public int compareTo(Reparacion o) {
        return o.getFecha().compareTo("00-00-0000");
    }
    
  
    


}
