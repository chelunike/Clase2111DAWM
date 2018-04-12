package fecha;

public class Fecha1 {

    static void intercambio(Fecha1 f1, Fecha1 f2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int d, m, a;

    public Fecha1(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }

    public Fecha1(String s) {
        int longi = s.length();
        if (longi != 10) {
            return;
        }
        for (int i = 0; i < longi; i++) {
            char c = s.charAt(i);
            if (i == 2 || i == 5) {
                if (c != '-' || c != '/') {
                    return;
                }
            } else if (c < '0' || c > '9') {
                return;
            }
        }
        d = Integer.parseInt(s.substring(0, 2));
        m = Integer.parseInt(s.substring(3, 5));
        a = Integer.parseInt(s.substring(6, 10));
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

    public boolean Correcta() {
        if (d < 1 || d > 31 || m < 1 || m > 12 || a < 1582) {
            return false;
        }
        return d <= diaMes();
    }

    private int diaMes() {
        int[] tdias = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (this.m < 1 || this.m > 12) {
            return -1;
        }
        if (this.m == 2 && this.bisiesto()) {
            tdias[2] = 29;
        }
        return tdias[this.m];

//        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
//            return 31;
//        }
//        if (m == 4 || m == 6 || m == 9 || m == 11) {                                                                                                                                                                          return 30;
//        }
//        if (bisiesto()) {
//            return 29;
//        }
//        return 28;
    }

    private boolean bisiesto() {
        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            return true;
        }
        return false;
    }

    public boolean mayorQue(Fecha1 f) {
        Fecha1 fNueva = new Fecha1(2, 4, 2017);
        f = fNueva;
        if (this.a > f.getA()) {
            return true;
        }
        if (this.a < f.getA()) {
            return false;
        }
        if (this.m > f.getM()) {
            return true;
        }
        if (this.m < f.getM()) {
            return false;
        }
        return this.d > f.getD();
    }

    public String cadenaSimple() {
//        return " "+d+"-"+m+"-"+a;
        return String.format("%2d/%2d/%4d", d, m, a);
    }
    
//    public static void intercambio(Fecha fa, Fecha fb){
//        int dx = fa.getD(), mx = fa.getM(), ax = fa.getA();
//        fa.setD(fb.getD());fa.setM(fb.getM());
//        fa.setA(fb.getA());
//        fb.setD(dx);fb.setM(mx);fb.setA(ax);
        
//}

    String difMeses(Fecha1 f2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String difDias(Fecha1 f2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String difAños(Fecha1 f2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String cadenaCompleta(Fecha1 f2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String cadenaSimple(Fecha1 f2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean correcta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//     public int diferenciaAños( Fecha f1, Fecha f2) {
//
//        int ai =this.getA(),af = f2.getA();
//        int mi = this.getM(), mf= f2.getM();
//        int di = this.getD(), df =f2.getD();
//        int diferencia = af - ai ;
//        if (mi>mf)
//            return diferencia- 1 ;
//        if (mi<mf)
//           
//
//        if (f1.correcta() && f2.correcta()) {
//            if (f1.mayorQue(f2)) {
//                Fecha.intercambio(f1, f2);
//            }
//        }
//        años = f2.a - f1.a;
//
//        if (f2.m < f1.m && años != 0) {
//            años -= 1;
//            return años;
//        }
//
//        if (f1.d > f2.d && años != 0) {
//            años -= 1;
//            return años;
//        }
//        return años;
//
//    }

  
}
