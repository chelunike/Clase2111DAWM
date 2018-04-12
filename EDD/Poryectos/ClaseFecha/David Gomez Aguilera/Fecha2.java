
package edfechadavid;


public class Fecha2 {
    private int d, m, a, bisiesto;

    public Fecha2(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
        this.bisiesto = bisiesto;
        
        
    }

    public Fecha2(String s) {
        int longi = s.length();
        if (longi != 10) 
          
        {
            return;
        }
        for (int i = 0; i < longi; i++) {
            char c = s.charAt(i);
            if (i == 2 || i == 5) 
            {
                if (c != '-' && c != '/') {
                    return;
                } else {
                    if (c < '0' || c > '9') {
                        return;
                    }
                }
            }
        }
        d = Integer.parseInt(s.substring(0, 2));
        m = Integer.parseInt(s.substring(3, 5));
        a = Integer.parseInt(s.substring(6, 10));
    }

    public int getA() {
        return this.a;
    }

    public int getD() {
        return this.d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getM() {
        return this.m;
    }
      private boolean bisiesto() {
        return a % 400 == 0 || a % 4 == 0;
      }
      public boolean mayorQue (Fecha2 f){
          if (this.a > f.getA()){
              return true;
          }
          if (this.a < f.getA()){
              return false;
          }
          if (this.m > f.getM()){
              return true;
          }
          if (this.m < f.getM()){
              return false;
          }
          if (this.d < f.getD()){
              return true;
          }
          if (this.d > f.getD()){
              return false;
          } 
          return (this.d > f.getD());
      }
          
      
      
      public boolean correcto(){
          if (d>0 || d<31){
              if (m>0 || m<12){
                  if (a>1800 || a<9999){
                      return true;
      }else{
    return false;
}
}else{
return false;
}
}else{
return false;
} }
       
    private int diasMes() {
        int[] tdias = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
        if (this.m<1 || this.m>12) 
            return -1;
            if (this.m==2 && this.bisiesto()){
                tdias[2] = 29;
            }
            return tdias[this.m];
        }
        
    public String cadenaSimple() {
      
        return String.format("%2d/%2d/%4d", d, m, a);
    
    }
    
    public int diferenciaDias(int dias, Fecha2 año){
        String dia="";
        int diferencia=this.d%7;
        int 
    }
    
    
    
    
    
//    public static void intercambio(Fecha2 fa, Fecha2 fb){
//        
//        
//        int dx=fa.getD(), mx=fa.getM(), ax = 0;fa.getA(); 
//         fa.setD(fb.getD()); fa.setM(fb.getM());
//         fa.setA((fb.getA()));
//        fb.setD(dx); fb.setM(mx); fb.setA(ax); 
//        
//        
//    }

     
    }
    

