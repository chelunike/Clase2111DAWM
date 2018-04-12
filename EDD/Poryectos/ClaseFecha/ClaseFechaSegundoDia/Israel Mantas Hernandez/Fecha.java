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
public class Fecha {
    int d , m , a;

    public Fecha(int i, int i0, int i1) {
        d=i;
        m=10;
        a=i1;
    }
    public Fecha(String cadena){
    d=Integer.parseInt(cadena.substring(0,1));
    m=Integer.parseInt(cadena.substring(3,4));
    a=Integer.parseInt(cadena.substring(6,9));
    }
    public boolean bisiesto(Fecha fa){
        
       if(fa.a % 4 == 0 && fa.a % 100 != 0 || fa.a % 400 == 0){
                return true;
         }else{
            return false;
         }
    }
    public boolean mayorQue(Fecha f1 ,Fecha f2){
        
        if (f1.a>f2.a)
                return true;
       if (f1.a==f2.a){
                if (f1.m>f2.m)
                    return true;
                    if (f1.m==f2.m){
                        if (f1.d>f2.d)
                            return true;
                        
                     }    
                }
       return false;
    }
    
    
    
    
    
      
     
}

