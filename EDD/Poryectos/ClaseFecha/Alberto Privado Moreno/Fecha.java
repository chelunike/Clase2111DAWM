package edfecha;


public class Fecha {
    private int d, m, a;
    int bisiesto;

    public Fecha(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }
    
    public Fecha( String s ){
        int longitud = s.length();
        if ( longitud != 10 )
            return;
        for (int i=0; i<longitud; i++){
            char c = s.charAt(i);
            if (i==2 || i==5){
                if (!(c == '-' || c == '/'))
                    return;
            }
            else
                if (c<'0' || c>'9')
                    return;
                }
        d=Integer.parseInt(s.substring(0,2));
        m=Integer.parseInt(s.substring(3,5));
        a=Integer.parseInt(s.substring(6,10));
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
    
    
    
    
    public boolean correcta(){
        if (a<=1582)
            return false;
        if (m < 1 || m > 12)
            return false;
        if (d < 1 || d > 31)
            return false;
        return d <= diasMes();
    }
    
    private int diasMes(){
        int[] tdias = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (this.m<1 || this.m>12)
            return -1;
        if (this.m == 2 && this.bisiesto())
            tdias[2]=29;
        return tdias[this.m];
    }
    
    private boolean bisiesto(){
        return (a%400==0 || a%4==0 && a%100!=0);
        
    }
    
    public boolean mayorQue(Fecha f){
        if ( this.a > f.getA() )
            return true;
        if ( this.a < f.getA() )
            return false;
        if ( this.m > f.getM() )
            return true;
        if ( this.m < f.getM() )
            return false;
        return this.d > f.getD();
    }
    
    public String cadenaSimple(){
//        return " "+d+"/"+m+"/"+a;
        return String.format ("%2d/%2d/%4d", d, m, a);
    }
    
    public static void intercambio(Fecha fa, Fecha fb){
        int dx=fa.getD(), mx=fa.getM(), ax=fa.getA();
        
        fa.setD(fb.getD());
        fa.setM(fb.getM());
        fa.setA(fb.getA());
        
        fb.setD(dx);
        fb.setM(mx);
        fb.setA(ax);
    }
    
    
    public int difAños(Fecha f){
        
        Fecha f1 = new Fecha(this.getD(), this.getM(), this.getA());
        Fecha f2 = new Fecha(f.getD(), f.getM(), f.getA());
        if (f1.mayorQue(f2))
            Fecha.intercambio(f1,f2);
        
        int ai = f1.getA(), af = f2.getA();
        int mi = f1.getM(), mf = f2.getM();
        int di = f1.getD(), df = f2.getD();
        int diferencia = af - ai;
        if (mi>mf) 
            return diferencia - 1;
        if (mi<mf)
            return diferencia;
        if (di>df)
            return diferencia - 1;
           return diferencia;    
    }
    
     public int difMeses(Fecha f){
        
        Fecha f1 = new Fecha(this.getD(), this.getM(), this.getA());
        Fecha f2 = new Fecha(f.getD(), f.getM(), f.getA());
        if (f1.mayorQue(f2))
            Fecha.intercambio(f1,f2);
        
        int ai = f1.getA(), af = f2.getA();
        int mi = f1.getM(), mf = f2.getM();
        int di = f1.getD(), df = f2.getD();
        int diferencia = mf - mi;
        if (di>df)
            return diferencia - 1;
           return diferencia;    
    }
    
//    public int difAños(Fecha f1, Fecha f2){
//        int ai = f1.getA(), af = f2.getA(), da = 0;
//        if(ai!=af){
//            da = af - ai;
//        }
//        return da;
//    }
//    
//     public int difMeses(Fecha f1, Fecha f2){
//        int mi = f1.getM(), mf = f2.getM(), dm = 0;
//        if(mi!=mf){
//            dm = mf - mi;
//        }
//        return dm;
//    }
//     
//      public int difDias(Fecha f1, Fecha f2){
//        int di = f1.getD(), df = f2.getD(), dd = 0;
//        if(di!=df){
//            dd = df - di;
//        }
//        if (dd<0){
//         =;
//         dd=dd+diasMes();
//        }
//        return dd;
//    }
    
         public String nombreMes(){  
             switch (m){
        case 1:
            return "Enero";
        case 2:
            return "Febrero";
        case 3:
            return "Marzo";
        case 4:
            return "Abril";
        case 5:
            return "Mayo";
        case 6:
            return "Junio";
        case 7:
            return "Julio";
        case 8:
            return "Agosto";
        case 9:
            return "Septiembre";
        case 10:
            return "Octubre";
        case 11:
            return "Noviembre";
        case 12:
            return "Diciembre";
                  }
             return "Mes no valido";
    }
    
}

   
// Ejercicios que hacer (Elegir)
// Diferencia entre fechas, dias, meses y años
// Ordenar fechas
// Cambiar formato a año, mes y dia
// Decir que dia de la semana es 'x' fecha
