/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDFecha;
import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Fecha {
     private int dia,mes,año;

//    int dia, mes, año;
//
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    public Fecha(String s){
        int longi=s.length();
        if(longi!=10)
            return;
        for(int i=0;i<longi;i++){
            char c=s.charAt(i);
            if(i==2||i==5){
                if(c!='-' && c!='/')//if(not(c=='-'&&c=='/'))
                    return;}
                else if(c<'0'||c>'9')
                    return;
                }
        
                dia=Integer.parseInt(s.substring(0, 2));
                mes=Integer.parseInt(s.substring(3, 5));
                año=Integer.parseInt(s.substring(6, 10));
    }
    
  public int getAÑO(){
  return año;}
  
  public int getMES(){
  return mes;}
   
  public int getDIA(){
  return dia;}
 
  public void setDia(int dia) {
  this.dia = dia;}

  public void setMes(int mes) {
  this.mes = mes;}

  public void setAño(int año) {
  this.año = año;}
    
    public boolean correcta() {
        if (año <= 1582) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1 || dia > 31) {
            return false;
        }
        //if
        return/*(*/ dia <= diasMes()/*)*/;
        //   return true;
        //return false;
    }

    private int diasMes() {
        int [] tdias=/*new int[12]*/{0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(this.mes<1 || this.mes>12)
            return -1;
        if (this.mes==2&&this.bisiesto()) {
            tdias[2]= 29;
        }
        return tdias[this.mes];
       /* if (mes == 1 || mes == 3 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            return 31;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        }
        if (bisiesto()) {
            return 29;
        }
        return 28;*/
    }

   private boolean bisiesto() {
        return año % 400 == 0 || año % 4 == 0 && año % 100 != 0;
    }


//SEGUNDA MANERA
//   public static int leerdia() {
//               Scanner entrada = new Scanner(System.in);
//        int dia;
//
//        System.out.print("Escribe un día: ");
//        dia = entrada.nextInt();
//        if (dia <= 0 || dia >= 32) {
//            System.out.println("_____________________");
//            System.out.println("No es posible.");
//            System.out.println("_____________________");
//            return Fecha.leerdia();
//           
//
//        } else {
//        System.out.println("    ");
//        System.out.println("----ACEPTADO----");
//        System.out.println("    ");}
//        return dia;
//    } 
//    public static int leermes() {
//        Scanner entrada = new Scanner(System.in);
//        int mes;
//
//        System.out.print("Escribe un mes: ");
//        mes = entrada.nextInt();
//        if (mes <= 0 || mes > 12) {
//            System.out.println("_____________________");
//            System.out.println("No es posible.");
//            System.out.println("_____________________");
//            return Fecha.leermes();
//           
//        } else {
//        System.out.println("    ");
//        System.out.println("----ACEPTADO----");
//        System.out.println("    "); }
//        return mes;
//    }
//    public static int leeraño() {
//        Scanner entrada = new Scanner(System.in);
//        int año;
//
//        System.out.print("Escribe un año: ");
//        año = entrada.nextInt();
//        if (año <= 0 || año <= 1581) {
//            System.out.println("_____________________");
//            System.out.println("No es posible.");
//            System.out.println("_____________________");
//        return Fecha.leeraño();
//
//        } else {
//        System.out.println("    ");
//        System.out.println("----ACEPTADO----");
//        System.out.println("    "); }
//       return año;
//    }
      public boolean mayorQue(Fecha f){
      if(this.año>f.getAÑO())
      return true;
      if(this.año<f.getAÑO())
          return false;
      if(this.mes>f.getMES())
          return true;
        if(this.mes<f.getMES())
          return false;
        if(this.dia>f.getDIA())
          return true;
       if(this.dia<f.getDIA())
          return false;
      return this.dia>f.getDIA();}
      
      public String cadenaSimple(){
      //return " "+dia+" "+mes+" "+año;
      return String.format("%2d/%2d/%4d",dia,mes,año);}
      
      
//      public int diferenciasDia(Fecha f){
//         if (this.año<f.getAÑO())
//         {int fecha=0;
//         while(this.año<f.getAÑO()){
//         int contador=0;}
//         fecha=f.getDIA()-this.dia;
//             return fecha;}
//         else return -1;
//             }
    public int diferenciaAño(Fecha f){
        Fecha f1=new Fecha(this.getAÑO(),this.getMES(),this.getDIA());
        Fecha f2=new Fecha(this.getAÑO(),this.getMES(),this.getDIA());
        if(f1.mayorQue(f2))
            Fecha.intercambio(f1, f2);
        int ai=f1.getAÑO(),af=f2.getAÑO();
        int mi=f1.getAÑO(),mf=f2.getAÑO();
        int di=f1.getAÑO(),df=f2.getAÑO();
        int diferencia=af-ai;
        if(mi>mf){
        return diferencia-1;}
        if(mi<mf){
        return diferencia;}
        if(di>df){
        return diferencia-1;}
        
        return diferencia;
        //El mio tiene muchos errores ya que no abarca los otros casos
   /* if (this.año<f.getAÑO()){
        int fecha=0;
       fecha=f.getAÑO()-this.año;
             return fecha;} else return -1;*/}
     
    
    
    public int diferenciaMes(Fecha f){
    if (this.año<f.getAÑO()){
        int fecha=0;
        int fecha2=0;
       fecha=f.getAÑO()-this.año;
       fecha=fecha*12;
       fecha2=f.getMES()-this.mes;
       if(fecha2>0)
       fecha=fecha-fecha2;
       else if(fecha2<0)
           fecha=fecha+fecha2;
             return fecha;} else return -1;}
    
    
     
      public static void intercambio(Fecha fa, Fecha fb){
      int dx=fa.getDIA(),mx=fa.getMES(),ax=fa.getAÑO();
      fa.setDia(fb.getDIA());fa.setMes(fb.getMES());fa.setAño(fb.getAÑO());
      fb.setDia(dx);fb.setMes(mx);fb.setAño(ax);
     }
    
}