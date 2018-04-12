
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
        if(longitudCadena !=10){
            //return;
            for(int i=0; i<longitudCadena; i++){
            caracter = cadena.charAt(i);
            if(i==2 || i==5){
                if(caracter != '-' && caracter !='/')
                    return;
            }else
                if(caracter <'0' || caracter > '9')
                    return;
            }
        }
        dia = Integer.parseInt(cadena.substring(0, 2));
        mes = Integer.parseInt(cadena.substring(3, 5));
        anno = Integer.parseInt(cadena.substring(6, 10));
        
    }    
    
    
    public boolean bisiesto(){
        boolean bisiesto = false;
        
        if(anno % 4 == 0 && anno % 100 == 0 && anno % 400 == 0){
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
         boolean correcta = false;
         if(annos <=1582){
             return false;
         }if(dias < 1 || dias > 31){
             return false;
            
         }return dias <= diasMes();
    }
    
    private int diasMes(){
        int[] tablaDias = {0,31,28,31,31,31,30,31,31,31,31,30,31};
        
        if(this.mes < 1 || this.mes > 12){
            return -1;
        }
        if(this.mes ==2 && bisiesto())
            tablaDias[2] = 29;
        return tablaDias[this.mes];
            
    }
    
       
   
    
    public int getAnno(){
        return anno;
    }
    
    public int getMes(){
        return mes;
        
    }
    
    public int getDia(){
        return dia;
    }
    
    public void setDia(int dia){
        this.dia= dia;
    }
    
    public void setMes(int mes){
        this.mes=mes;
    }
    
    public void setAnno(int anno){
        this.anno=anno;
    }

   
   
    public boolean mayorQue (Fecha f ) {
        if (this.anno > f.getAnno() )
            return true;
        if (this.anno < f.getDia() )
            return false;
        if (this.mes > f.getMes() )
            return true;
        if (this.mes > f.getMes() )
            return true;
        if (this.mes < f.getMes() )
            return false;
        return this.dia > f.getDia() ;
        
    }
            
            
    
    public static void intercambio(Fecha fa, Fecha fb){
        int iguales=0;
        int diaAuxiliar=fa.getDia();
        int mesAuxliar=fa.getMes();
        int AnnoAuxiliar=fa.getAnno();
        
        
        if(fa.equals(fb)){
            iguales=1;
        }else{
            fa.setDia(fb.getDia());
            fa.setMes(fb.getMes());
            fa.setAnno(fb.getAnno());
            
            fb.setDia(fa.getDia());
            fb.setMes(fa.getMes());
            fb.setAnno(fa.getAnno());
            
        }
    }
        
    public int diferenciaAnnos(Fecha fecha){
        int annoInicial=this.getAnno(), annoFinal = fecha.getAnno();
        int mesInicial=this.getMes(), mesFinal= fecha.getMes();
        int diaInicial=this.getDia(), diaFinal= fecha.getDia();
        int diferencia=annoInicial - annoFinal;
        
        if(mesInicial>mesFinal)
            return diferencia -1;
        
        if(mesInicial<mesFinal)
            return diferencia;
        
        if(mesInicial>mesFinal)
            return diferencia -1;
    
        
    }
}

        



    

    
 
   
//    public String diaSemana(int dia){
//         
//         String diaSemana = "";
//         if(dia == 1){
//             diaSemana = "Lunes";
//         }else if(dia == 2){
//             diaSemana = "Martes";
//         }else if(dia == 3){
//             diaSemana = "Miercoles";
//         }else if(dia == 4){
//             diaSemana = "Jueves";
//         }else if(dia == 5){
//             diaSemana = "Viernes";
//         }else if(dia == 6){
//             diaSemana = "Sabado";
//         }else if(dia == 7){
//             diaSemana = "Domingo";
//         }
//    return diaSemana;
//    }
    

