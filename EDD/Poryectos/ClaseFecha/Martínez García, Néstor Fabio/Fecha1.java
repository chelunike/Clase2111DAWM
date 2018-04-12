package fecha;

public class Fecha1 {

    private int d, m, a;
    int bisiesto;

    public Fecha1(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }
         
    
 
    public Fecha1(String s){
        int longi= s.length();
        if (s.length()!=10)
          return ;
        
        for(int i=0;i<longi ;i++){
          char c= s.charAt(i);
            if (i==2 || i==5){
                if (c!='-' &&  c!='/')
              return;
            }
            else
                 if (c<'0' && c>'9')
                     return;         
        }
    

    
    d = Integer.parseInt (s.substring (0,2));
    
    m = Integer.parseInt (s.substring (3,5));
    
    a = Integer.parseInt (s.substring (6,10));
    
        }  
    public int getD() {
        return d;
    }
    public int getM() {
        return m;
    }
    public int getA() {
        return a;
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
    
    
        public static void intercambio(Fecha1 fa,Fecha1 fb) {
        int dx=fa.getD(), mx=fa.getM(), ax=fa.getA();
        
        fa.setD(fb.getD());
        fa.setM(fb.getM());
        fa.setA(fb.getA());
   
        fb.setD(dx);
        fb.setM(mx);
        fb.setA(ax);
                }
        
        
            public int difAños(Fecha1 f1, Fecha1 f2){
        int ai = f1.getA(), af = f2.getA();
        int mi = f1.getM(), mf = f2.getM();
        int di = f1.getD(), df = f2.getD();
        int difAños =af-ai;
        if(mi>mf)
            return difAños -1;
        if (mi<mf)
            return difAños;
        if (di>df)
            return difAños -1;
        if (di<=df)
            return difAños;
        return difAños;
        }         
   
            public int difMeses(Fecha1 f1, Fecha1 f2){
        int ai = f1.getA(), af = f2.getA();
        int mi = f1.getM(), mf = f2.getM();
        int di = f1.getD(), df = f2.getD();
        int difMeses =(f1.difAños(f1,f2)*12);
        if(mi>mf)
            difMeses +=(mi-mf);
        if(mi<mf) 
            difMeses-=(mf-mi);
        if(di<df)
            difMeses--;
        return difMeses;
        }
   
            //Fecha1 f1= new Fecha1           //Fecha 1 clonada, podemos trabajar con ella sin el riesgo de afectar al this.
            //  (this.getD(),this.getM(),this.getA())
            
    public boolean bisiesto() {
          return ( a % 400 == 0 || a % 4== 0 && a % 100 != 0);}
        
    
    
        
    public boolean mayorQue(Fecha1 f){
            if (this.a >f.getA() )
              return true;
            if (this.a <f.getA() )
              return false;
            if (this.m >f.getM() )
              return true;
            if (this.m <f.getM() )
              return false;
            if (this.d >f.getD() )
              return true;
                return this.d> f.getD(); //no hace falta poner la comparacion de dia menor q el otro dia, pues sino sale por mayor, ya asbemos q es menor o igual, y cogera false.
    }
    
    
        public boolean correcta(){
      if (a<=1582)           //hacemos un primer filtro para quitar errores muy claros o incomodos(x ejmplo una fecha anterior a 1582)
          return false;  
     if (m<1 || m>12)
          return false;
     if (d<1 || d>31)
          return false; 
     return d <= diasMes();
         }
   
        
    int diasMes(){
        int[] tdias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ; //enero seria la posicion 0 y diciembre seria el 11,
        if (this.m<1 || this.m>12)
                return -1;
        if(this.bisiesto())
            tdias[2]=29;
        return tdias[this.m];
    }            
                
    
    public String cadenaSimple (){
        return String.format ("%2d/%2d/%4d", d, m, a);
    }  
    
    
    public String nombreMes(){  
             switch (m){
        case 1:
            return "de Enero";
        case 2:
            return "de Febrero";
        case 3:
            return "de Marzo";
        case 4:
            return "de Abril";
        case 5:
            return "de Mayo";
        case 6:
            return "de Junio";
        case 7:
            return "de Julio";
        case 8:
            return "de Agosto";
        case 9:
            return "de Septiembre";
        case 10:
            return "de Octubre";
        case 11:
            return "de Noviembre";
        case 12:
            return "de Diciembre";
                  }
             return "";
    }


     
     
     
     
}
    
    
//    public int difAños(Fecha1 f1, Fecha1 f2){
//        int ai = f1.getA(), af = f2.getA(), difa = 0;
//        if(ai!=af){
//            difa = af - ai;
//        }
//        return difa;
//    }
//    public int difMeses(Fecha1 f1, Fecha1 f2){
//        int mi = f1.getM(), mf = f2.getM(), difm = 0;
//        if(mi!=mf){
//            difm = mf - mi;
//        }
//        return difm;
//    }
//    public int difDías(Fecha1 f1, Fecha1 f2){
//        int di = f1.getD(), df = f2.getD(), difd = 0;
//        if(di!=df){
//            difd = df - di;
//        }
//        if (difd<0){
//          
//    }
//                ;
//        return difd;
//    }
//                                         
     

//    public int getBisiesto() {
//        return bisiesto;
//    }


//el && tiene prioridad sobre el || por loq  no necesitamos separarlo en 2 parentesis.
       //ESTA SENTENCIA DE ARRIBA SERIA LO MISMO Q:
//             if (a % 400 == 0 )
//                 return true;
//           if (a % 100 != 0 && a % 4 == 0)
//               return true//si no cumple las condiciones, no cogera el true, seguira bajando y cogera el false.NO ES NECESARIO EL ELSE!!
   

//        metodo alternativo con if

//
//        if ( m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12 )
//            return 31;
//         if ( m==4 || m==6 || m==9 || m==11 )
//             return 30;
//         if (bisiesto())
//             return 29;
//           return 28;
    
        
        //metodo alternativo con CASE
//        switch (m){
//          case 1:
//          case 3:
//          case 5:
//          case 7:
//          case 8:
//          case 10:
//          case 12: return 31;
//          case 4:
//          case 6:
//          case 9:
//          case 11: return 30;
//        }
//        if (bisiesto())
//        return 29;
//      return 28;
//    }
   
