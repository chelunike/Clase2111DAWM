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
            d = Integer.parseInt(s.substring(0, 2));
            m = Integer.parseInt(s.substring(3, 5));
            a = Integer.parseInt(s.substring(6, 10));

            //("25-04-1996")
        }
        //System.out.println("Fechita es: "+m);
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

    public String cadenaSimple() {
        return String.format("%2d/%2d/%4d", d, m, a);
    }

    public static void intercambio(Fecha f1, Fecha f2) {//si no usamos los valores por defecto no se cambiarían las fechas de la clase, aunque si las del método
        int auxa, auxm, auxd;
        auxd = f1.d;
        auxm = f1.m;
        auxa = f1.a;

        f1.d = f2.d;
        f1.m = f2.m;
        f1.a = f2.a;

        f2.d = auxd;
        f2.m = auxm;
        f2.a = auxa;
        /*
        en vez de f1 es fa y en vez de f2 es fb
        int dx=fa.getD(), mx=fa.getM(), ax=fa.getA();
        
        fa.setD(fb.getD());
        fa.setM(fb.getM());
        fa.setA(fb.getA());
        
        fb.setD(dx);
        fb.setM(mx);
        fb.setA(ax);
         */
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

    public static int diferenciaAños(Fecha f1, Fecha f2) {

        int años;

        if (f1.correcta() && f2.correcta()) {
            if (f1.mayorQue(f2)) {
                Fecha.intercambio(f1, f2);
            }
        }
        años = f2.a - f1.a;

        if (f2.m < f1.m && años != 0) {
            años -= 1;
            return años;
        }

        if (f1.d > f2.d && años != 0) {
            años -= 1;
            return años;
        }
        return años;

    }
    
    public static int diferenciaMeses(Fecha f1, Fecha f2) {
        int meses=0, años;
        if(f1.d==f2.d&&f1.m==f2.m&&f1.a==f2.a){
            return meses;
        }
        años=Fecha.diferenciaAños(f1, f2);
        meses=años*12;
        if(f1.d>f2.d){
            meses-=1;
        }
        
        if(f1.m>f2.m){
            meses+=(12-(f1.m-f2.m));
        }else{
            if(f1.m==f2.m && f1.d!=f2.d && f1.a!=f2.a){
                meses=meses+12-(f1.m-f2.m);
            }            
            meses+=(f2.m-f1.m);
        }
        return meses;
    }
    
    public Fecha sumaDías(Fecha f1, int valor){
        for(int i=0;i<valor;i++){
            f1.d ++;
        if(!f1.correcta()){
            f1.d--;
            if(f1.m!=12){
                f1.d=1;
                f1.m++;
            }else{
                f1.d=1;
                f1.m=1;
                f1.a++;
            }
        }
        }
        return f1;
    }
    
    public static int diferenciaDías(Fecha f1, Fecha f2){
        if (f1.correcta() && f2.correcta()) {
            if (f1.mayorQue(f2)) {
                Fecha.intercambio(f1, f2);
            }
        }
        int dias=0;
        while(f1.d!=f2.d || f1.m!=f2.m || f1.a!=f2.a){
            f1.d ++;
        if(!f1.correcta()){
            f1.d--;
            if(f1.m!=12){
                f1.d=1;
                f1.m++;
            }else{
                f1.d=1;
                f1.m=1;
                f1.a++;
            }
        }
           dias++; 
        }
        
        return dias;
    }
    
    public static String toStringCompleto(Fecha f){
    String cadena="Día completo: ";
    int numDia; 
    numDia=((f.a-1)%7+((f.a-1)/4-3*((f.a-1)/100+1)/4)%7+f.d*f.d%7)%7;
    switch(numDia){
        case 0:
            cadena+="Miércoles ";
            break;
        case 1:
            cadena+="Jueves ";
            break;
        case 2:
            cadena+="Viernes ";
            break;
        case 3:
            cadena+="Sábado ";
            break;
        case 4:
            cadena+="Domingo ";
            break;
        case 5:
            cadena+="Lunes ";
            break;
        case 6:
            cadena+="Martes ";
            break;
    }
    cadena+=f.d+" de ";
    
    switch(f.m){
        case 1:
            cadena+="Enero";
            break;
        case 2:
            cadena+="Febrero";
            break;
        case 3:
            cadena+="Marzo";
            break;
        case 4:
            cadena+="Abril";
            break;
        case 5:
            cadena+="Mayo";
            break;
        case 6:
            cadena+="Junio";
            break;
        case 7:
            cadena+="Julio";
            break;
        case 8:
            cadena+="Agosto";
            break;
        case 9:
            cadena+="Septiembre";
            break;
        case 10:
            cadena+="Octubre";
            break;
        case 11:
            cadena+="Noviembre";
            break;
        case 12:
            cadena+="Diciembre";
            break;
    }
    cadena+=" de "+f.a;
    
    return cadena;
    }
}