package fecha;

public class Fecha1 {

    private int m, d, a;

    public Fecha1(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }

    public int getD() {
        return this.d;
    }

    public int getM() {
        return this.m;
    }

    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setD(int d) {
        this.d = d;
    }

    public Fecha1(String s) {
        int longi = s.length();
        if (longi != 10) {
            return;
        }
        for (int i = 0; i < longi; i++) {
            char c = s.charAt(i);
            if (i == 2 || i == 5) {
                if (c != '-' && c != '/') {
                    return;
                }
            } else {
                if (c < '0' || c > '9') {
                    return;
                }
            }
        }
        d = Integer.parseInt(s.substring(0, 2));
        m = Integer.parseInt(s.substring(3, 5));
        a = Integer.parseInt(s.substring(6, 10));
    }

    public boolean correcto() {
        if (a <= 1582) {
            return false;
        }
        if (m < 1 || m > 12) {
            return false;
        }
        if (d < 1 || d > 31) {
            return false;
        }
        return d <= diasMes();
    }

    private int diasMes() {
        int[] tdias = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (this.m < 1 || this.m > 12) {
            return -1;
        }
        if (this.m == 2 && this.bisiesto()) {
            tdias[2] = 29;
        }
        return tdias[this.m];
    }

    private boolean bisiesto() {
        return a % 400 == 0 || a % 4 == 0 && a % 100 != 0;
    }
    
    public String cadenaSimple(){
    return String.format("%2d /%2d / %4d", d, m, a);
    }

    public static void intercambio(Fecha1 fa, Fecha1 fb) {
        int dx = fa.getD(), mx = fa.getM(), ax = fa.getA();
        fa.setD(fb.getD());
        fa.setM(fb.getM());
        fa.setA(fb.getA());

        fb.setD(dx);
        fb.setM(mx);
        fb.setA(ax);
    }
    
    public int difAños(Fecha1 fb){
    int ai=this.getA(), af=fb.getA(), da=0;
    if(ai!=af){
    da = af-ai;
    }
    return da;
    }
    
    public int difMeses(Fecha1 fb){
    int mi=this.getM(), mf=fb.getM(), dm=0;
    if(mi!=mf){
    dm = mf-mi;
    }
    return dm;
    }
    
    public int difDias(Fecha1 fb){
    int di=this.getD(), df=fb.getD(), dd=0;
    if(di!=df){
    dd = df-di;
    }
    return dd;
    }
    
}
