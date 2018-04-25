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
public class Trabajo {
    
    private Mecanico mecanico;
    private int horas;
    
    public Trabajo(Mecanico me, int horas){
        mecanico = me;
        this.horas = horas;
        
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
   //Calcula el importe del trabajo en función de la especialidad 
    //del mecánico y de las horas.
     public double calculaImporte(){
        double suma=0;
        suma+=this.horas*Taller.precioHoraEspecialidad[this.mecanico.getEspecialidad()];
        return suma;
     }
     
     
     @Override
     public String toString() {
         return this.mecanico.toString()+"//"+"Horas: "+this.horas+" Importe: "+this.calculaImporte();
         
     }
}
    
    
