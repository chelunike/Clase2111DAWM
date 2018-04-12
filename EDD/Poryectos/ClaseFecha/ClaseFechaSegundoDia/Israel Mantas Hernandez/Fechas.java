/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

/**
 *
 * @author israelmantashernandez
 */
import java.util.Scanner;

public class Fechas {


              Scanner entrada = new Scanner(System.in);

    public static void main(String[]args){
    
            Fecha f1= new Fecha(29,2,2003);
            Fecha f2= new Fecha(23,3,2001); 
         //   Fecha f3= new Fecha();
            
            
            System.out.println(f1.mayorQue(f1,f2));
            System.out.println(f1.bisiesto(f2));
    }
    
}





