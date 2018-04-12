

package fecha;


public class Fecha {

    private int dia,mes,año;
    
    //Constructores
    public Fecha(int dia,int mes,int año){
        this.dia=dia;
        this.mes=mes;
        this.año=año;
    }
    
    public Fecha(String cad){
        int lon = cad.length();
        String dd,mm,aa;
        
        if (lon == 10) {
            if ((cad.charAt(2) == '-' || cad.charAt(2) == '/') &&
                    (cad.charAt(5) == '-' || cad.charAt(5) == '/')) {
                
                dd = cad.substring(0, 2);
                mm = cad.substring(3, 5);
                aa = cad.substring(6);
                try {
                    dia = Integer.parseInt(dd);
                    mes = Integer.parseUnsignedInt(mm);
                    año = Integer.parseInt(aa);
                    
                } catch (NumberFormatException e) {//(ExceptionType name)
                    System.out.println(e.getMessage());
                    
                }
//                
            } 
        }
        
        
    }//Fin del constructor
    
    //Metodos
    public void setDatos(int d,int m,int a){
        this.dia=d;
        this.mes=m;
        this.año=a;
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
    
    public boolean esCorrecta(){
        boolean correcta=false;
        
        if(dia>0 && dia<=31){
            if(mes>0 && mes<=12){
                if(dia<=diasDelMes() && año>=1582)
                    correcta=true;
            }
        }//Fin primer if
        
        if(mes==2){
            if(esBisiesto() && dia>0 && dia<=29)
                correcta=true;
        }
        
        return correcta;
    }
    
    private int diasDelMes(){
        int dias=31;
        
        switch (mes){
            case 2: dias=28; break;
            case 4: 
            case 6: 
            case 9: 
            case 11: dias=30;                            
        }
        
        return dias;
        
    }
    
    private boolean esBisiesto(){
        boolean b=false;
        
        if(año%400==0)
            b=true;
        else{
            if(año%4==0 && año%100!=0)
                b=true;
        }
        
        return b;
    }
    
    public boolean mayorQue(Fecha f){
        
        if(año>f.getAño())
            return true;
        if(año<f.getAño())
            return false;
        
        if(mes>f.getMes())
            return true;
        if(mes<f.getMes())
            return false;
            
        return dia>f.getDia();
        
    }
    
    public static void intercambiar(Fecha f1, Fecha f2){
        int auxD=f1.getDia(), auxM=f1.getMes(), auxA=f1.getAño();
                
        f1.setDatos(f2.getDia(), f2.getMes(), f2.getAño());
        f2.setDatos(auxD, auxM, auxA);
    }
    
    public int difAños(Fecha f1, Fecha f2){
        int año1=f1.getAño();
        int año2=f2.getAño();
        int dif=0;
        
        if(año1!=año2)
            dif=año2-año1;
        
        return dif;
    }
    
    
    
    
    
    
    
}//Fin clase
