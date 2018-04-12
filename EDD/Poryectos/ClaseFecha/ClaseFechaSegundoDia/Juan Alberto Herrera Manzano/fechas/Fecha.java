package fechas;

public class Fecha {

    private int d, m, a;

    public Fecha(int dia, int mes, int año) {
        d = dia;
        m = mes;
        a = año;
    }

    public Fecha(String s) {
        int longitud = s.length();
        if (longitud != 10) {
            return;
        }

        for (int i = 0; i < longitud; i++) {
            char c = s.charAt(i);
            if (i == 2 || i == 5) {
                if (c != '-' && c != '/') {
                    return;
                }
            } else if (c < '0' && c > '9') {
                return;
            }
            d = Integer.parseInt(s.substring(0,2));
            m = Integer.parseInt(s.substring(3,5));
            a = Integer.parseInt(s.substring(6,10));
            
            //PRUEBA PARA CONTAR POSICIONES -> ("25-04-1996")
        }
    }

    public boolean correcta() {
        if (a <= 1582) {
            return false;
        }
        if (m < 1 || m > 12) {
            return false;
        }
        if (d < 1 || d > 31) {
            return false;
        }
        return (d <= diasMes());

    }

    //CUÁNTOS DIAS TIENE CADA MES
    private int diasMes() {
        int[] tdias = {0, 31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31};
        if (this.m < 1 || this.m > 12) {
            return -1;
        }
        if (this.m == 2 && this.bisiesto()) {
            tdias[2] = 29;
        }
        return tdias[this.m];

    }

    public boolean bisiesto() {
        return (a % 400 == 0 || (a % 4 == 0 && a % 100 != 0));
    }

    public boolean mayorQue(Fecha f) {
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
        return (this.d > f.getD());
    }
    
    public String cadenaSimple(){
        return String.format("%2d/%2d/%4d", d,m,a);
    }
    
    
    public static void intercambio (Fecha f1, Fecha f2){
        int auxa, auxm, auxd;
        auxd = f1.getD();
        auxm = f1.getM();
        auxa = f1.getA();
        
        f1.setD(f2.getD());
        f1.setM(f2.getM());
        f1.setA(f2.getA());
        
        f2.setD(auxd);
        f2.setM(auxm);
        f2.setA(auxa);        
    }
    
    //DIFERENCIA EN DIAS
    public int difDias (Fecha f2){
        int difdias;
        difdias = 0;
        
        
        
        return difdias;
    }
    
    //SET & GET
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
    
    

}
