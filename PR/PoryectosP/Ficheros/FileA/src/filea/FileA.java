/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filea;
import java.util.Scanner; 
/**
 *
 * @author juan
 */
public class FileA {

   public static void main( String args[] ) 
{
Scanner entrada = new Scanner( System.in ); 
DemoFile aplicacion = new DemoFile(); 

System.out.print( "Escriba aqui el nombre del archivo o directorio: " ); 
aplicacion.analizarRuta( entrada.nextLine() ); 
} // fin de main 

    
}
