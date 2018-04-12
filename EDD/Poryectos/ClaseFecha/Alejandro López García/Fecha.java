package EDFecha;

public class Fecha {

    int d;
    int m;
    int a;
    int difA=0;
    int difM=0;
    int difD=0;

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

    public boolean bisiesto() {
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

        int diasDM() {
            int [] tdias={0,31,28,31,30,31,30,31,31,30,31,30,31};
             if (m<1 || m>12)
                 return -1;
             if (m==2 && bisiesto())
                 tdias[2]=29;
            return tdias[m];
  
    }
    public String cadenaSimple(){
        return String.format(""+d+"/"+m+"/"+a);
    }
    
}
