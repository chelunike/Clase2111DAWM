/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

//import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Fecha {

    /**
     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        Scanner entrada = new Scanner(System.in);
//        int d, m, a;
//       
//        System.out.println("Teclee el dia :");
//        d = entrada.nextInt();
//        System.out.println("Teclee el mes : ");
//        m = entrada.nextInt();
//        System.out.println("Teclee el año : ");
//        a = entrada.nextInt();
//    
//        Fecha1 f1 =new Fecha1(d,m,a);
//        if (f1.correcta()){
//            System.out.println(d +" del "+ m +" del "+a);
//            System.out.println("CORRECTA");
//        }
//            else 
//            System.out.println("INTENTELO DE NUEVO");
//            
//    }
    
    public static void main(String[] args){
       int d,m,a;
            Fecha1 f1= new Fecha1(23,03,2013);
            Fecha1 f2= new Fecha1(23,04,2020);
       if (f1.correcta()&& f2.correcta()){
        if (f1.mayorQue(f2))
            Fecha1.intercambio(f1,f2);
        
           System.out.println("Fecha1: "+f1.cadenaSimple());
           System.out.println("Fecha2: "+f2.cadenaSimple());  
           System.out.println("Fecha1:Es "+f1.getD()+f1.nombreMes()+" del "+f1.getA());
           System.out.println("Diferencia en años: "+f1.difAños(f1, f2));
           System.out.println("Diferencia en meses: "+f1.difMeses(f1, f2));
        
    }

}
}



////////////////////////////////////////////////
//diferencia entre fechas, dias meses, años
//ordenar fechas
//cambiar formato a año mes dia
//dar valores de semana (lunes, martes....)
//y al mes(enero,febreor....)
////////////////////////////////////////////////


   
//       while (mes == 2 && año%4 !== 0 ) dia<= 28; {
//            System.out.println("su fecha es correcta !!: " +dia+"/"+mes+"/"+año" .");  
//       }
//        if (mes == 2 && año % 4 == 0 && dia <= 29
//            System.out.println("su fecha es correcta !!: "+ dia+"/"+mes+"/"+año" ."); 
//        
//        if (mes == 1||3||5||7||8||10||12 && dia <= 31 )
//               System.out.println("su fecha es correcta !!: " +dia+"/"+mes+"/"+año" .");
//        
//        if (mes == 4 ,6,9,11 && dia <= 30)
//        System.out.println("su fecha es correcta !!: " +dia+"/"+mes+"/"+año" .");
//   
//        
//        else (System.out.println("Intentelo de nuevo.");
  
