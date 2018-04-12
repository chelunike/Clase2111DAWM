
package calendario;

public class Fecha {
    /* Atributos de clase */
    private int dia, mes, anno;
    
    /*CONSTRUCTOR POR DEFECTO, DEFINIVO POR SI ACASO, PERO INUTILIZADO POR EL DE ABAJO*/
    public Fecha(){
    }
    
    public Fecha(int dia, int mes, int anno){
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }
    
    public Fecha(String cadena){
        int longitudCadena = cadena.length();
        char caracter;
        if(longitudCadena != 10){
            //return;
            for(int i=0; i<longitudCadena; i++){
                caracter = cadena.charAt(i);
                if(i==2 || i==5){
                    if(caracter != '-' && caracter != '/')
                        return;
                }else
                   if(caracter < '0' || caracter > '9')
                        return;
            }
            
        }
        dia = Integer.parseInt(cadena.substring(0, 2));
        mes = Integer.parseInt(cadena.substring(3, 5));
        anno = Integer.parseInt(cadena.substring(6, 10));
    }
    
    private boolean bisiesto(){
        boolean bisiesto = false;
        
        if(anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0){
            bisiesto = true; 
        }else{
            bisiesto = false;
        }
        
    return bisiesto;
    }
     
    public boolean correcta(){
         int dias = this.dia;
         int meses = this.mes;
         int annos = this.anno;
         
         if(annos <= 1582){
             return false;
         }if(meses < 1 || meses > 12){
             return false;
         }if(dias < 1 || dias > 31){
             return false;
         } 
    return dias <= diasMes();  
    }
    

    private int diasMes(){
       int[] tablaDias = {0,31,28,31,30,31,30,31,31,31,31,30,31};
       
       if (this.mes < 1 || this.mes > 12){
           return -1;
       }if(this.mes == 2 && bisiesto())
           tablaDias[2] = 29;     
        return tablaDias[this.mes];  
    }
    
    public int restaMeses(int mes){
        int restaMes = 0;
        int anno = 0;
        restaMes = this.mes - mes;
        if(restaMes == -1){
            mes = 12;
            anno = restaAnnos(this.anno)  - 1;
        }
    return restaMes + anno + mes;
    }
    
    public int restaDias(int dias){
        int restaDias = 0;
        if(dia < 1){
            if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) 
                restaDias = 31 - dias;
            if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
               restaDias = 30 - dias;
        } 
        
    return restaDias;    
    }
    
    public int restaAnnos(int anno){
        int resta = 0;
        
        resta = this.anno - anno;
    return resta;
    }
    
    public boolean mayorQue(Fecha fecha){
        if(anno > fecha.getAnno()){
            return true;
        }if(anno < fecha.getAnno()){
            return false;
        }if(this.mes > fecha.getMes()){
            return true;
        }if(this.mes < fecha.getMes())
            return false;
       return this.dia > fecha.getDia();

    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }
    
    public void setDia(int dia){
        this.dia = dia;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    
    public void setAnno(int anno){
        this.anno = anno;
    }
            
    public void intercambia(Fecha fa, Fecha fb){
        int iguales = 0;
        int diaAuxiliar = getDia(), mesAuxiliar = getMes(), annoAuxiliar = getAnno();
        
        if(fa.equals(fb)){
            iguales = 1;
        }else{
            fa.setDia(fb.getDia());
            fa.setMes(fb.getMes());
            fa.setAnno(fb.getAnno());
            
            fb.setDia(fa.getDia());
            fb.setMes(fa.getMes());
            fb.setAnno(fa.getAnno());
        }
    }
    
    @Override
    public String toString(){
        int dia, mes, anno;
        dia = this.dia;
        mes = this.mes;
        anno = this.anno;
        
        return String.format("%2d/%2d/%4d", dia, mes, anno);
    }
    
    
    public int diferenciaAnnos(Fecha fecha){
        int annoInicial = this.getAnno(), annoFinal = fecha.getAnno();
    }
    
    public String diferenciaDias(int dias, Fecha anno){
        String dia = "";
        int diferencia = this.dia % 7;
        int diaNuevo = this.dia - diferencia;
        int mesNuevo = 0;
        int annoNuevo = 0;
        
        
        if(diaNuevo < this.dia){
            mesNuevo = this.mes - 1;
        }
        if(mesNuevo > 12){
            annoNuevo = this.anno + 1;
        }
        
        if(diferencia == 1){
            dia = "Lunes";
        }else if(diferencia == 2){
            dia = "Martes";
        }else if(diferencia == 3){
            dia = "Miércoles";
        }else if(diferencia == 4){
            dia = "Jueves";
        }else if(diferencia == 5){
            dia = "Viernes";
        }else if(diferencia == 6){
            dia = "Sabado";
        }else if(diferencia == 7){
            dia = "Domingo";
        }
        
    return " Dia semana: " + dia + " dia del mes: " + diaNuevo + " del " + mesNuevo + " del anno " + annoNuevo;
    }
    
    
}
