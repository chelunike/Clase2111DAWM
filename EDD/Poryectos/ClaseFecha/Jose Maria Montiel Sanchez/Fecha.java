package fecha;

public class Fecha {

    int d, m, a;
public Fecha(int d, int m, int a){
    this.d=d;
    this.m=m;
    this.a=a;
}
public Fecha(){
    
}
public Fecha(String s){
    int longi=s.length();
    if (longi!=10)
        return;
    for(int i=0;i<longi;i++){
        char c=s.charAt(i);
        if (i==2 || i==5)
            if (c!='-' && c!='/')
                return;
            }
    d=Integer.parseInt(s.substring(0,2));
    m=Integer.parseInt(s.substring(3, 5));
    a=Integer.parseInt(s.substring(6, 10));
    
}

    public int getD() {
        return d;
    }

    public int getA() {
        return a;
    }

    public int getM() {
        return m;
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
    if(a<=1582)
        return false;
    if (m<1 || m>12)
        return false;
    if (d<1 || d>31)
        return false;
    return d<=diasmes();
    
}
private int diasmes(){
    switch(m){
        case 1: 
        case 3:
        case 5: 
        case 7: 
        case 8:
        case 10: 
        case 12: return 31;
        case 4:
        case 6:
        case 9:
        case 11: return 30;
    }
    if (bisiesto())
        return 29;
    return 28;
}
private boolean bisiesto(){
    return (a%400==0 || a%4==00 && a%100!=0);
    
}
public boolean mayor (Fecha f){
    if (this.a>f.getA())
        return true;
    if (this.a<f.getA())
        return false;
    if (this.m<f.getM())
        return false;
    if (this.m>f.getM())
        return true;
    return this.d>f.getD();
}
public String cadenasimple(){
    return String.format("%2d/%2d/%4d",d,m,a);
}
public static void intercabio(Fecha fa, Fecha fb){
    int dx=fa.d, mx=fa.m, ax=fa.getA();
    fa.setD(fb.getD());
    fa.setM(fb.getM());
    fa.setA(fb.getA());
    fb.setD(dx);
    fb.setM(mx);
    fb.setA(ax);
}
public int difAños(Fecha f2){
//    int año=0;
//    int aux=a;
//    if (this.a==f2.a) return año;
//    else
//    while (this.mayor(f2)){
//        a--;
//        año=año-1;
//    }
//    if (this.m>f2.m)
//        año-=1;
//    if (this.d>f2.d){
//            año-=1;}
//       
//    a=aux;
//    return año;
    int ai=this.getA(), af=f2.getA();
    int mi=this.getM(), mf=f2.getM();
    int di=this.getD(), df=f2.getD();
    int diferencia=ai-af;
    if (mf>mi)
        return diferencia-1;
    if(mf<mi)
        return diferencia;
    if(df>di)
        return diferencia-1;
    if(df<di)
        return diferencia;
    if (af==ai)
        return 0;
    return 0;
}
public int difMeses(Fecha f2){
     int mi=this.getM(), mf=f2.getM(), aux=0, aux2;
     aux2=mi;
     if (mi==mf)
         return 0;
     while(mi>mf){
         mi--;
         aux++;}
     mi=aux2;
     return aux;
    }
public int difDias(Fecha f2){
    int di=this.getD(), df=f2.getD(), diferencia;
     if (di==df){
         return 0;}
     if(di>df) 
        diferencia=df-di;
     else 
        diferencia=di-df;
     return diferencia;
}
}

