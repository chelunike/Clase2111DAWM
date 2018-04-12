 package Fecha;
public class Fecha {
   
     /** Dar fecha y comprobar que es correcta
       Metodo siguiente dia diferencia dia, mes, año sacar fecha en formato
     * lunes 2 nov de 2017 Metodo comparar fecha*/
    public static void main(String[] args) {
     
        
        Flecha fecha = new Flecha(25, 11, 1999);
        Flecha fecha2 = new Flecha("25-10-2016");

        /*
        if(fecha.comprobar() && fecha2.comprobar()){
            if(fecha.menorFecha(fecha2))
                fecha.intercambia(fecha2);
            System.out.println("Diferencia en dias: "+fecha.diferenciaDias(fecha2));
        }*/
        
        System.out.println("Dia siguiente: "+ fecha.diaNext()+ " ");
        
    }
}
