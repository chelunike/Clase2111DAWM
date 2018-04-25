/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.ArrayList;
import java.util.Comparator;
//import taller.Reparacion.ordenaFecha;


/**
 *
 * @author juan
 */
public class Coche {

    private String matricula;
    private String marca;
    private String modelo;
    private ArrayList<Reparacion> reparaciones;

    //constructor 
    public Coche(String mat, String mar, String mod) {
        
        matricula=mat;
        marca=mar;
        modelo=mod;
        reparaciones = new ArrayList();

    }
    
    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public boolean insertaReparacion(Reparacion r){
        return reparaciones.add(r);
    }
    //Calcula la suma de los importes de las reparaciones del coche
    public double calculaImporteReparaciones(){
      double suma=0;
      
      for(Reparacion r: reparaciones){
          suma+=r.calculaImporte();
      }
      return suma;
    }
    
    @Override
    public String toString(){
                
        return  String.format("matricula: %s//marca: %s modelo: %s \n",matricula,marca,modelo);
       
    }
    //devuelve la lista de las reparciones del coche
   public String listaReparaciones(){
       String c="Matrícula: "+this.matricula+"\n";
       for (Reparacion r: reparaciones){
           c+=r.toString()+"\n"+"---------------"+"\n";
       }
       return c;
   }
   // ordena reparaciones por fecha(comparable)
   public void ordenaReparacionesPorFecha(){
        reparaciones.sort(new ordenaFecha());
   }

   //permite ordenar un arraylist de reparaciones por la fecha
   // implementado el metodo de la interfaz comparable
   public class ordenaFecha implements Comparator <Reparacion> {

        @Override
        public int compare(Reparacion r1, Reparacion r2) {
            return r1.getFecha().compareTo(r2.getFecha());
        }

    }
   
}
