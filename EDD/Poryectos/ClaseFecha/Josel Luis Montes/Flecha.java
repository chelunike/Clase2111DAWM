package fecha;
//import java.util.Scanner;

/**
 *
 * @author yo
 */

public class Flecha {
    //Atributos
    private  int dia, mes, año;
    
    //Construtores
    public Flecha(){}
    
    //Constructor Basico
    public Flecha(int dia,int mes,int año){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }
    
    /**
     * Inserta una cadena en formato:
     *  dd/mm/aaaa
     *  dd-mm-aaaa
     * Para instanciar el objeto
     * @param fecha Insertar cadena.
     */
    public Flecha (String fecha){
        String dd, mm, aa;
        if (fecha.length()==10){
            System.out.println("Longitud fecha correcta ");
            if ((fecha.charAt(2)=='-'||fecha.charAt(2)=='/')
                && (fecha.charAt(5)=='-'||fecha.charAt(5)=='/')){
                
                dd= fecha.substring(0, 2);
                mm=fecha.substring(3, 5);
                aa=fecha.substring(6, 10);
                if(Flecha.esDij(dd) && Flecha.esDij(mm) && Flecha.esDij(aa)){
                    System.out.println("Formato fecha correcto: "+dd+"/"+mm+"/"+aa);
                    this.dia=Integer.parseInt(dd);
                    this.mes=Integer.parseInt(mm);
                    this.año=Integer.parseInt(aa);
                }else{
                    System.out.println("Formato fecha incorrecto");}
            }else
               System.out.println("Formato fecha incorrecto");
        }else{
            System.out.println("Longitud fecha incorrecta");
        }
    }

    /**
     * Metodo auxiliar para comprobar si una cadena 
     * puede tranformarse a un entero
     * 
     * @param s Introfducir una cadena
     * @return 
     */
    private static boolean esDij(String s){
        try{
            int n = Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error "+ e.getMessage());
            return false;
        }
    }
    
    // Metodos....
    
    /**
     * Modifica los valores de la fecha
     * 
     * @param d Dia
     * @param m Mes
     * @param a Año
     */
    public void insert(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.año = a;
    }
    
    // Metodos para obtener los distintos valores de un objeto
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
     * Esta funcion te comprueba que el formato de la fecha    
     * 
     * @return
     */
    public boolean comprobar(){
        boolean c = false;
        if (dia > 0 && dia<=31){
            if(mes<=12 && mes>0){
                if (año>=1582){
                    if (Flecha.diaMes(mes)>=dia){
                        c = true;
                    }
                }
            }
        }
        if(mes==2){
            if(Flecha.esBisiesto(año)&& dia>0 && dia<=29)
                c = true;
        }
        return c;
    }
    
    /**
     * Devuelve el dia del mes correspondiente
     * @param mes
     * @return 
     */
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
    
    /**
     * Comprueba si un año es bisiesto
     * @param n Año
     * @return 
     */
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
    
    /**
     * Calcula la diferencia en dias entre
     * la fecha del propio objeto y otra dada
     * 
     * @param f2 Fecha 2º
     * @return 
     */
    public int diferenciaDias(Flecha f2){
        //Comprobaciones iniciales
        if(this.menorFecha(f2))
            this.intercambia(f2);

        // Inicio variables 
        int di = this.dia, mi = this.mes, ai=this.año ;
        int df= f2.getDia(), mf=f2.getMes(), af=f2.getAño();
        int xd=0;
        //Compruebo diferencia de año
        //Si hay tengo que calcular los dias 
        //de los años y las diferencias de los meses...
        if(ai != af){
            xd += Flecha.diaMes(mi) - di;
            xd += df;
            for(int i=mi;i<=12;i++){
                xd += Flecha.diaMes(i);
            }
            ai++;
            for(int k=0;k<mf;k++){
                xd+= Flecha.diaMes(k);
            }
            for(int j=ai;j<af;j++){
                if (Flecha.esBisiesto(j)){
                    xd+=366;
                }else{
                    xd+=365;}
            }
        //Si hay solo sumo los dias de los meses intermedios
        }else{
            if (mi == mf){
                xd += df - di;
            }else{
                xd += Flecha.diaMes(mi) - di;
                mi++;
                xd +=df;
                for(int i=mi;i<mf;i++){
                    xd+=Flecha.diaMes(i);
                }
            }
        } 
        //Devuelvo los dias
        return xd;
    }
    
    /**
     * Diferencia en años entre la propia del
     * objeto y otra.
     * @param f2 Fecha 2ª
     * @return 
     */
    public int difaño(Flecha f2){
        if(this.menorFecha(f2))
            this.intercambia(f2);
        
        int ai = this.getAño(), af = f2.getAño(), da = 0;
        if(ai!=af){
            da = af - ai;
        }else if(this.diferenciaDias(f2)>=364)
            da++;
        return da;
    }
    
    /**
     * Diferencia en años entre dos objetos
     * @param f1 Fecha inicio
     * @param f2 Fecha final
     * @return 
     */
    public static int difAño(Flecha f1, Flecha f2){
        if(f1.menorFecha(f2))
            f1.intercambia(f2);
        
        int ai = f1.getAño(), af = f2.getAño(), da = 0;
        if(ai!=af){
            da = af - ai;
        }
        return da;
    }
    
    /**
     * Diferencia en meses entre dos fechas
     * @param f1 Fecha Inicio
     * @param f2 Fecha Final
     * @return 
     */
    public static int difMes( Flecha f1, Flecha f2){
        if(f1.menorFecha(f2))
            f1.intercambia(f2);
        
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
    
    /**
     * Devuelve true o false si la fecha del propio 
     * objeto es mayor que la dada
     * @param f2 Fecha 2ª
     * @return boolean
     */
    public boolean mayorFecha(Flecha f2) {
        boolean c = false;
        int di = this.dia, mi = this.mes, ai=this.año ;
        int df= f2.getDia(), mf=f2.getMes(), af=f2.getAño();
        
        if (ai!=af){
            if(ai>af)
                c=true;
        }else{
            if (mi!=mf){
                if(mi>mf)
                    c=true;
            }else{
                if(di>df)
                    c = true;
            }
        }
        return c;
    }
    
    /**
     * Devuelve true si es menor que la fecha dada; es decir,
     * si la fecha es anterior a la dada
     * @param f Fecha 2ª
     * @return Boolean
     */
    public boolean menorFecha(Flecha f){
        return !(this.mayorFecha(f));
    }
    
    /**
     * Intercambia la fecha del objeto por la 
     * de otro objeto dado
     * @param f Fecha 2
     */
    public void intercambia(Flecha f){
        int tpd=this.dia, tpm=this.mes, tpa=this.año;
        this.dia = f.getDia();
        this.mes = f.getMes();
        this.año = f.getAño();
        f.insert(tpd, tpm, tpa);
    }
    
    /**
     * Instercambia dos fechas entre si
     * @param f1 Fecha 1
     * @param f2 Fecha 2
     */
    public static void intercambia(Flecha f1, Flecha f2){
        int tpd=f1.getDia(), tpm=f1.getMes(), tpa=f1.getAño();
        f1.insert(f2.getDia(), f2.getMes(), f2.getAño());
        f2.insert(tpd, tpm, tpa);
    }
    
    /**
     * Dia siguiente
     * 
     * @return devuelve el dia siguiente al actual
     */
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
     * Te dice el dia de la semana.
     * @return String con el dia de la semana
     */
    public static String diaSemana(Flecha fecha){
        //Declaramos nuestro dia y una lista con los dias de la semana.
        String dia = "";
        String[] semana = {"Viernes","Sábado","Domingo","Lunes","Martes","Miércoles","Jueves"};
        //Declaramos nuestra fecha de partida. (Que cae en Lunes)
        Flecha init = new Flecha( 1, 1, 1990);
        int dif=0;
        
        if(init.menorFecha(fecha))
            dif = init.diferenciaDias(fecha);
        else{
            Flecha.intercambia(init, fecha);
            dif = init.diferenciaDias(fecha);
        }
        
        try{
            dia += semana[dif%7];
        }catch(Exception e){
            System.out.println("Error en Dia de la semana :(");
        }
            
                
        return dia;
    } 
    
    
    /**
     * Esto es un decorador para una funcion de True o False
     * 
     * @param c Instertar funcion que devuelva True o False
     */
    public static void say(boolean c){
        if (c){
            System.out.println("-_-_-_-_-_-_-_-_-_-");
            System.out.println("|    Correcto :)  |");
            System.out.println("|       :)/       |");
            System.out.println("|       /|        |");
            System.out.println("|        |        |");
            System.out.println("|       / \\       |");
            System.out.println("-_-_-_-_-_-_-_-_-_-");
        }else{
            System.out.println("-_-_-_-_-_-_-_-_-_-");
            System.out.println("|  Incorrecto :(  |");
            System.out.println("|      \\ /        |");
            System.out.println("|       |         |");
            System.out.println("|       |/        |");
            System.out.println("|      /:(        |");
            System.out.println("-_-_-_-_-_-_-_-_-_-");
        }
    }
    
}
