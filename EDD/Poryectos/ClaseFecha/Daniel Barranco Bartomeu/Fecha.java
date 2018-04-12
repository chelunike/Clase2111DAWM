package EDFecha;

public class Fecha {
    int d;
    int m;
    int a;

    public Fecha(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }

    public Fecha(String s) {
        int longi=s.length();
        if (longi!=10)
            return;
        for(int i=0; i<longi;i++) {
            char c= s.charAt(i);
            if(i==2||i==5){
                if(c!='-' && c!='/' )
                    return;
            }
            else 
                if(c<'0' && c>'9')
                    return;
                    
        }
        d=Integer.parseInt(s.substring(0,2));
        m=Integer.parseInt(s.substring(3,5));
        a=Integer.parseInt(s.substring(6,10));
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

    
    public int getD() {
        return d;
    }

    public int getM() {
        return m;
    }

    public int getA() {
        return a;
    }
    
    public boolean correcta() {
        if (a <= 1582) {
            return false;
        }
        if (m < 1 || m > 12) {
            return false;
        }

        if (d < 1 || d > diasDM()) {
            return false;
        }

        return true;
    }

    private boolean bisiesto() {
        return (a % 400 == 0 || a % 4 == 0 && a % 100 !=0);
            

    }
    
    public boolean mayorQue(Fecha f2){
        if (a>f2.getA())
        return true;
        if (a<f2.getA())
        return false;
        if (m >f2.getM())
        return true;
        if (m<f2.getM())
        return false;
        return d >f2.getD();
       
        
    }

        private int diasDM() {
            int [] tdias={0,31,28,31,30,31,30,31,31,30,31,30,31};
             if (m<1 || m>12)
                 return -1;
             if (m==2 && bisiesto())
                 tdias[2]=29;
            return tdias[m];
  
    }
    public String cadenaSimple(){
        //return ""+d+"-"+m+"-"+a;
        return String.format("%2d/%2d/%4d",d,m,a);
    }
    
    public static void intercambio(Fecha fa, Fecha fb){
       int dx=fa.getD(), mx=fa.getM(), ax=fa.getA();
      fa.setD(fb.getD()); fa.setM(fb.getM()); fa.setA(fb.getA());
      fb.setD(dx); fb.setM(mx); fb.setA(ax);  
    }
    
    public  int difAños(Fecha f2){       
        int af=this.getA(); int ai=f2.getA();
        int mf=this.getM(); int mi=f2.getM();
        int df=this.getD(); int di=f2.getD();
        int dif=af-ai;
        if(mi>mf) 
           return dif-1;
        if(mi<mf)
           return dif;
        if(di>df)
           return dif-1;            
         return dif;
    }
    
    public int difMeses(Fecha f2){
        int af=this.getA(); int ai=f2.getA();
        int mf=this.getM(); int mi=f2.getM();
        int df=this.getD(); int di=f2.getD();
        int dif;
        
        return dif;
    }
    
}
