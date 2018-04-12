package edfecha;

public class Fecha1 {

    private int d, m, a;

    public Fecha1() {

    }

    public Fecha1(int dia, int mes, int año) {
        this.d = dia;
        this.m = mes;
        this.a = año;
    }

    public Fecha1(String s) {
        int longi = s.length();
        if (s.length() != 10) {
            return;
        }
        for (int i = 0; i < longi; i++) {
            char c = s.charAt(i);
            if (i == 2 || i == 5) {
                if (c != '-' && c != '/') {
                    return;
                }
            } else if (c > '9' || c < '0') {
                return;
            }

        }

        d = Integer.parseInt(s.substring(0, 2));
        m = Integer.parseInt(s.substring(3, 5));
        a = Integer.parseInt(s.substring(6));

    }

    public int getA() {
        return a;
    }

    public int getM() {
        return m;
    }

    public int getD() {
        return d;
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
    

    public boolean correcta() {

        if (m < 1 || m > 12 || d < 0 || d > 31 || a <= 1582) {
            return false;
        }
        return d <= diaMes();
    }

    private int diaMes() {
        int[] tdias = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (m < 1 || m > 12) {
            return -1;
        }
        if (m == 2 && bisiesto()) {
            return 29;
        }
        return tdias[m];
    }

    private boolean bisiesto() {
        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            return true;
        }

        return false;
    }

    public boolean mayorQue(Fecha1 f) {
        
        if (a > f.getA()) {
            return true;
        }
        if (a < f.getA()) {
            return false;
        }
        if (m > f.getM()) {
            return true;
        }
        if (m < f.getM()) {
            return false;
        }
        return d > f.getD();

    }
    public String cadenaSimple(){
        return String.format("%2d/%2d/%4d", d , m, a);
    }
//    public String cadenaCompleta(Fecha1 f){
//        String [] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sábado","Domingo"};
//        if ()
//            
//        
//    }
//    
    public static void intercambio(Fecha1 fa, Fecha1 fb){
        int dx = fa.getD(), mx = fa.getM(), ax = fa.getA();
        fa.setD(fb.getD()); fa.setM(fb.getM()); fa.setA(fb.getA());
        fb.setD(dx); fb.setM(mx); fb.setA(ax);
    }
    
   
 
    public int difAños(Fecha1 f){
    
    Fecha1 f1 = new Fecha1 (this.getD(), this.getM(), this.getA());    
    Fecha1 f2 = new Fecha1 (f.getD(),f.getM(),f.getA());
    
    if (f1.mayorQue(f2))
        Fecha1.intercambio(f1, f2);
    
    int ai = f1.getA(), af = f2.getA();
    int mi = f1.getM(), mf = f2.getM();
    int di = f1.getD(), df = f2.getD();
    int diferencia = af - ai;
    if (mi>mf)
        return diferencia-1;
    else if (mi < mf)
        return diferencia;
    else if (di>df)
        return diferencia-1;
    else
        return diferencia;
    }
    public int difMeses(Fecha1 f){
       
        Fecha1 f1 = new Fecha1 (this.getD(), this.getM(), this.getA());    
        Fecha1 f2 = new Fecha1 (f.getD(),f.getM(),f.getA());
    
    if (f1.mayorQue(f2))
        Fecha1.intercambio(f1, f2);
        
       int cont = f1.difAños(f2);
       int mi = f1.getM(), mf = f2.getM();
       int di = f1.getD(), df = f2.getD();
       int aux;
       if (cont == 0){
           if (mf > mi)
               return mf - mi;
       }
       if ()
           //Mañana lo termino
           
       
           
        
    }
//    public int difDias(Fecha1 d){
//        
//        
//    }  
}
