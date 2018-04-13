/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

/**
 *
 * @author juan
 */
public class Taller {
    //tenemos 3 especialidades para los mecánicos:
    //para la especialidad 0 se corresponden 40 € por hora,
    //para la 1 50€ por hora, para la 2 55€ por hora
    static double[] precioHoraEspecialidad = {40.0,50.0, 55.0};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Coche coche = new Coche("bcd1234","seat","leon");
        //Mecanico: nombre, horas
        Mecanico m1 = new Mecanico("pepe", 1);
        Mecanico m2 = new Mecanico("luis", 0);
        Mecanico m3 = new Mecanico("ana", 2);
        //Trabajo: mecanico, horas
        Trabajo t1 = new Trabajo(m1,3);
        Trabajo t2 = new Trabajo(m2,2); 
        Trabajo t3 = new Trabajo(m3,4);
        
              
       Reparacion r1 = new Reparacion("01-01-2015");
       
        r1.insertaTrabajo(t1);
        r1.insertaTrabajo(t3);
        //
         Reparacion r2 = new Reparacion("01-03-2015");
        
        r2.insertaTrabajo(t1);
        r2.insertaTrabajo(t2);
        //
        
        Reparacion r3 = new Reparacion("01-02-2015");   
        r3.insertaTrabajo(t1);
        r3.insertaTrabajo(t2);
        r3.insertaTrabajo(t3);
        
       
        
        coche.insertaReparacion(r1);
        coche.insertaReparacion(r2);
        coche.insertaReparacion(r3);
        
        
        System.out.println(coche.listaReparaciones());
        
        coche.ordenaReparacionesPorFecha();
        System.out.println("=================Ordenado por fecha");
        
        System.out.println(coche.listaReparaciones());
     
     
     //suponiendo que hay tres mecanicos
     // escriba codigo para obtener las horas que ha trabajado cada mencánico
     //y que las escriba en pantalla
     // use las estructuras que crea necesarias.
     
     //--- escriba código aqui.
        
        
        
    }
    
    
   
    
   
    
}
