package fecha;
//import java.util.Scanner; metodo Scanner

public class Fecha1 {
    private  int dia, mes, año;
    
    public Fecha1(){}
    
    
    public Fecha1(int dia,int mes,int año){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }
    //public static void leerFecha(){}
    public Fecha1 (String fecha){
        String dd, mm, aa;
        if (fecha.length()==10){
            System.out.println("Longitud fecha correcta ");
            if ((fecha.charAt(2)=='-'||fecha.charAt(2)=='/')
                && (fecha.charAt(5)=='-'||fecha.charAt(5)=='/')){
                
                dd= fecha.substring(0, 2);
                mm=fecha.substring(3, 5);
                aa=fecha.substring(6, 10);
                if(Fecha1.esDij(dd) && Fecha1.esDij(mm) && Fecha1.esDij(aa)){
                    System.out.println("Formato de fecha es correcto wei :) ");
                    this.dia=Integer.parseInt(dd);
                    this.mes=Integer.parseInt(mm);
                    this.año=Integer.parseInt(aa);
                }else{
                    System.out.println("Formato de fecha es incorrecto wei :( ");}
            }
        }else{
            System.out.println("Longitud fecha incorrecta");
        }
    }
    public static boolean esDij(String s){
        try{
            int n = Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error "+ e.getMessage());
            return false;
        }
    }
    
    public void insert(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.año = a;
    }
    
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAño(){
        return this.año;
    }

    /**
     * comprobar formato fecha 
         */
    public boolean comprobar(){
        boolean c = false;
        if (dia > 0 && dia<=31){
            if(mes<=12 && mes>0){
                if (año>=1582){
                    if (Fecha1.diaMes(mes)>=dia){
                        c = true;
                    }
                }
            }
        }
        if(mes==2){
            if(Fecha1.esBisiesto(año)&& dia>0 && dia<=29)
                c = true;
        }
        return c;
    }
 
    private static int diaMes(int mes){
        int d;
        switch (mes) {
            case 1: 
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: d = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11: d=30;
                break;
            case 2:  d=28;
                break;
            default:
                d=0;
        }
        return d;
    }
    
    private static boolean esBisiesto(int n){
        boolean f = false;
        if (n%400==0){
            f = true;
        }else{
            if (n%4==0 && n%100!=0)
                f = true;  
        }
        return f;
    }
    
    public int diferenciaDias(Fecha1 f2){
        
        /* Inicializar variables*/
        int di = this.dia, mi = this.mes, ai=this.año ;
        int df= f2.getDia(), mf=f2.getMes(), af=f2.getAño();
        int xd=0;
            if(ai != af){
            xd += Fecha1.diaMes(mi) - di;
            xd += df;
            for(int i=mi;i<=12;i++){
                xd += Fecha1.diaMes(i);
            }
            ai++;
            for(int k=0;k<mf;k++){
                xd+= Fecha1.diaMes(k);
            }
            for(int j=ai;j<af;j++){
                if (Fecha1.esBisiesto(j)){
                    xd+=366;
                }else{
                    xd+=365;}
            }
                }else{
            if (mi == mf){
                xd += df - di;
            }else{
                xd += Fecha1.diaMes(mi) - di;
                mi++;
                xd +=df;
                for(int i=mi;i<mf;i++){
                    xd+=Fecha1.diaMes(i);
                }
            }
        } 
                return xd;
    }
    
    public int difAño(Fecha1 f1, Fecha1 f2){
        int ai = f1.getAño(), af = f2.getAño(), da = 0;
        if(ai!=af){
            da = af - ai;
        }
        return da;
    }
    
    public int difaño(Fecha1 f2){
        int ai = this.getAño(), af = f2.getAño(), da = 0;
        if(ai!=af){
            da = af - ai;
        }
        return da;
    }
    
    public static int difMes( Fecha1 f1, Fecha1 f2){
        int mi = f1.getMes(), ai = f1.getAño();
        int mf = f2.getMes(), af = f2.getAño();
        int dm = 0;
        if(ai!=af){
            dm +=(af-ai)*12;
            dm += 12 - mi;
            dm += mf;
        }else{
            dm += mf - mi;
        }
        return dm;
    }
        public int difAño(Flecha f1, Flecha f2){
        int ai = f1.getAño(), af = f2.getAño(), da = 0;
        if(ai!=af){
            da = af - ai;
        }
        return da;
    }
    
    public boolean mayorFecha(Fecha1 f2) {
        boolean c = false;
        int d = this.dia, m = this.mes, a=this.año ;
        int df= f2.getDia(), mf=f2.getMes(), af=f2.getAño();
        
        if (a!=af){
            if(a>af)
                c=true;
        }else{
            if (m!=mf){
                if(m>mf)
                    c=true;
            }else{
                if(d>df)
                    c = true;
            }
        }
        return c;
    }
    
    public boolean menorFecha(Fecha1 f){
        return !(this.mayorFecha(f));
    }
    
    public void intercambia(Fecha1 f){
        int tpd=this.dia, tpm=this.mes, tpa=this.año;
        this.dia = f.getDia();
        this.mes = f.getMes();
        this.año = f.getAño();
        f.insert(tpd, tpm, tpa);
    }
    
    public static void intercambia(Fecha1 f1, Fecha1 f2){
        int tpd=f1.getDia(), tpm=f1.getMes(), tpa=f1.getAño();
        f1.insert(f2.getDia(), f2.getMes(), f2.getAño());
        f2.insert(tpd, tpm, tpa);
    }
    
    public int diaNext(){
        int dn=dia+1;
        if (!this.comprobar()){
            dn=1;
            mes++;
            if(!this.comprobar()){
                dn=1;
                mes=1;
                año++;
            }
        }
        return dn;
    }
    
    
    
    /**
     * 
     * 
     * 
     */
    public static void Comprobar(boolean comp){
        if (comp){
            System.out.println("correcto");
        }else{
            System.out.println("incorrecto");
         
        }
    }
    
}
