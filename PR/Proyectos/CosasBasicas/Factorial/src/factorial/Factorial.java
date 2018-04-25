
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;
import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    /**
     * Insertar varios numeros del 1 al 10
     * Estos se tienen que sumar
     * Decir cual es el menor y el mayor
     * Calcular si es multiplo de  2, 3, o 5
     * Cuantos numeros he hecho de entrada
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner potato = new Scanner(System.in);
        int num;     
        int con = 0;
        int sum = 0;
        int min = 10;
        int max = 0;
        
        
//        System.out.println("Teclee un numero entre el 0 y el 10");
//        num = potato.nextInt();
//        
//        while (num<=0 && num>=10)
//            System.out.println("Teclee un numero entre el 0 y el 10");
//            num = potato.nextInt();
//        con++;
//            sum = sum + num;
//            if (num <=min){
//                min = num;
//            }
//            if (num >= max){
//                max = num;
//            }
         factorial(3);
        
    }
    
    static int factorial(int num){
        //do {
            //System.out.println("Teclee un numero entre el 0 y el 10");
            //System.out.println("Insertar numero a factorizar: ");
            //num = potato.nextInt();
            int n = num;
            int f = 1;
            for(int i=1;i <= n;i++){
                f = f*i;
            }
            System.out.println("El PacoEnUnaMotoDeTrial es: "+f);
        //}while (num<=0 && num>=10);
            return f;
    }
    static int factorialRecursiva(int num){
        if (num > 1)
            return num*factorialRecursiva(num-1);
        return 1;
    }
}
