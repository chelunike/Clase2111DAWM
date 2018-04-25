/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoresprimos;
import java.util.Scanner;
/**
 *
 * @author SIDiu
 */
public class FactoresPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Er codijo ba aki
        //Variables
        int num;
        int div = 2;
        int tmp,exp=0,m=0;
        Scanner potato = new Scanner(System.in);
        
        //Codigo :)
        System.out.print("Insertar numero :) ");
        num = potato.nextInt();
        tmp = num;
        do {
            if(tmp%div==0){
            while(tmp%div==0){
                tmp /= div;
                exp++;
                }
            System.out.println("Numero div: "+div+"Contador: "+exp);
            }
            exp=0;
            div++;
        }while(tmp > 1);
    }
    
}
