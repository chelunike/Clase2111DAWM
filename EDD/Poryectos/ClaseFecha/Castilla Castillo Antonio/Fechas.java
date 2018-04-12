/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Fechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int dia, mes, año;
        

        
        Fecha f1 = new Fecha(20,2,1998);
        Fecha f2 = new Fecha ("25-04-1996");
        
        if (f1.correcta())
            System.out.println("F1 Es correcta ");
        if (f2.correcta())
            System.out.println("F2 Es correcta ");
        
        System.out.println("F1 antes de intercambiar: "+f1.cadenaSimple());
        System.out.println("f2 antes de intercambiar: "+f2.cadenaSimple());
        
        if (f1.correcta() && f2.correcta()){
            if (f1.mayorQue(f2)){
                System.out.println("");
                System.out.println("Vamos a intercambiar...");
                System.out.println("");
                
               Fecha.intercambio(f1,f2); 
               
            }
//            System.out.println("Diferencia en dias: "+
//                    f1.difDias(f2));
//            System.out.println("Diferencia en meses: "+
//                    f1.difMeses(f2));
            System.out.println("Diferencia en años: "+
                    f1.difAño(f2));
//            System.out.println("De la fecha "+
//                    f1.cadenaCompleta());
//            System.out.println(" y de la fecha "+
//                    f1.cadenaSimple());
            
            
        }
           
        
    }
}
    

