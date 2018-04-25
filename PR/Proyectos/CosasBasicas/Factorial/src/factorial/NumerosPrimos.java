  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;
import java.util.Scanner;
/**
 *
 * @author yo y paciencia
 */
public class NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Illo el kodijo aki bale :)
       
       //variables
       int div=2,exp = 0,tmp,n;
       Scanner potato = new Scanner(System.in);
       System.out.print("Insertar numero primo: ");
       n = potato.nextInt();
       tmp = n;
       while(tmp > 1){
           if (tmp%div==0){
           while(tmp%div==0){
               tmp/=div;
               exp++;
           }
               System.out.println("El divisor:"+div+" dividido: "+exp);
           div++;
           exp=0;
           }
       }
    }
}
       
       
    
    

