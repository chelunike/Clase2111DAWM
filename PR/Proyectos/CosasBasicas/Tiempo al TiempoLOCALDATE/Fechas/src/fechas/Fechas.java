/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.time.*;
import java.util.Locale;
//import java.util.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.format.TextStyle;

/**
 *
 * @author juan
 */
public class Fechas {

//    public enum Day {
//
//        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
//        THURSDAY, FRIDAY, SATURDAY
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Instantiate a Date object
        /*
         Date date = new Date();

         // display time and date using toString()
         System.out.println(date.toString());

         // GregorianCalendar c = new GregorianCalendar();
         GregorianCalendar c1 = new GregorianCalendar();

         System.out.println("Fecha actual: " + c1.getTime().toLocaleString());
         c1.set(2000, Calendar.AUGUST, 31); //establece la fecha
         System.out.println("Fecha 31 Agosto 2000: " + c1.getTime().toLocaleString());
         c1.set(Calendar.MONTH, 13);
         System.out.println("Mal---Fecha 13 meses más: " + c1.getTime().toLocaleString());
         //como podremos observar no nos imprimirá la fecha deseada, hemos escrito una incoherencia
         c1.set(2000, Calendar.AUGUST, 31);
         //volvemos a la fecha anterior usando set y empleamos el método add 
         c1.add(Calendar.MONTH, 13); // Añadir 13 meses 
         System.out.println("Fecha 13 meses más: " + c1.getTime().toLocaleString()); //ahora sí es correcto
         c1.roll(Calendar.HOUR, 25); // Añadir 25 horas 
         System.out.println("Fecha 25 horas más: " + c1.getTime().toLocaleString());    //uso de roll

         System.out.println("=======================================");

         c1.set(2015, 10, 2);//atención enero= 0

         SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy HH:mm:ss");
         //System.out.println("Fecha Formateada: "+sdf.format(c1.getTime()));
         System.out.println("Fecha Formateada: " + sdf.format(c1.getTime()));
         System.out.println("AÑO: " + c1.get(Calendar.YEAR));
         System.out.println("MES: " + c1.get(Calendar.MONTH));
         System.out.println("DIA: " + c1.get(Calendar.DATE));
         System.out.println("HORA: " + c1.get(Calendar.HOUR));

         System.out.println("=======================================");
         c1.set(2014, 1, 30, 22, 15, 0);//atención enero= 0
         Locale local = new Locale("es", "ES");
         GregorianCalendar c2 = new GregorianCalendar(local);
         SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMMM/yyyy HH:mm:ss");

         System.out.println("Fecha Formateada: " + sdf2.format(c2.getTime()));
         System.out.println("AÑO: " + c2.get(Calendar.YEAR));
         System.out.println("MES: " + c2.get(Calendar.MONTH));
         System.out.println("DIA: " + c2.get(Calendar.DATE));
         System.out.println("HORA: " + c2.get(Calendar.HOUR));
         System.out.println(c1.compareTo(c2));

         // TODO code application logic here
         */
        /// java.time
        System.out.println("==============enum días y meses=========================");

//        //Existe un enum donde se definen todos los días de la semana 
//        DayOfWeek lunes = DayOfWeek.MONDAY;
//        System.out.printf(" Hoy es lunes. En 8 días será: %s%n", lunes.plus(8));
//        System.out.printf("Hoy es lunes. 2 días antes fue: %s%n", lunes.minus(2));
//
//        DayOfWeek lun = DayOfWeek.MONDAY;
////        Locale l = new Locale("es", "ES");
//        System.out.println("Con locale l = ES:");
//        System.out.println("TextStyle.FULL:" + lun.getDisplayName(TextStyle.FULL, l));
//        System.out.println("TextStyle.NARROW:" + lun.getDisplayName(TextStyle.NARROW, l));
//        System.out.println("TextStyle.SHORT:" + lun.getDisplayName(TextStyle.SHORT, l));
//        System.out.println("=======================================");
//
//        //Para los meses, existe el enum java.time.Month que básicamente hace lo mismo:
//        //Locale loc = new Locale("pt"); //probamos con portugues
//
//        Month mes = Month.MARCH;
//        System.out.printf("Dos meses más y será: %s%n", mes.plus(2));
//        System.out.printf("Hace 1 mes fué: %s%n", mes.minus(1));
//        System.out.printf("Este mes tiene %s días %n ", mes.maxLength());
//
//        // Además, con el método getDisplayName() se puede acceder al 
//        //texto que corresponde a la fecha, dependiendo del Locale
//        //actual, o el que definamos. Para mi país probé con esto: 
//        System.out.printf("TextStyle.FULL:%s%n", mes.getDisplayName(TextStyle.FULL, l));
//        System.out.printf("TextStyle.NARROW:%s%n", mes.getDisplayName(TextStyle.NARROW, l));
//        System.out.printf("TextStyle.SHORT:%s%n", mes.getDisplayName(TextStyle.SHORT, l));

        System.out.println("============LocalDate=========================================================");
        //Las clases de fecha como el java.time.LocalDate manejan la fecha,
        //pero, a diferencia del java.util.Date, es que  solo trabaja fecha, 
        //y no hora. Esto nos permitirá manipular la fecha para registrar 
        //fechas específicas como el día de cumpleaños o de matrimonio.
        //Aquí unos ejemplos:

        
        //obtiene la fecha actual
        LocalDate hoy = LocalDate.now();

        System.out.printf("Día actual con toString: " + hoy.toString());
        Locale l = new Locale("es", "ES");
// Extrayendo dia, mes y año);
        DayOfWeek hoyDiaSemana = hoy.getDayOfWeek();
        String hoyDiaSemanaSp=hoyDiaSemana.getDisplayName(TextStyle.FULL, l);
        Month hoyMes = hoy.getMonth();
        String hoyMesSp=hoyMes.getDisplayName(TextStyle.FULL, l);
        int hoyDiaMes = hoy.getDayOfMonth();
        
        int hoyAño = hoy.getYear();

        System.out.printf("\nHoy es  %s , %d de %s de %d ", hoyDiaSemanaSp, hoyDiaMes, hoyMesSp, hoyAño);
        
        
        /////////////////////////////////////////////Crear fecha determinada
        LocalDate fecha = LocalDate.of(1999, 8, 23);
        
        
        DayOfWeek dia = fecha.getDayOfWeek();
        System.out.printf("\nEl día que conocí a quien es mi esposa fue el %s y fue un %s%n", fecha, dia);

        // Para representar el mes de un año específico, usamos la clase 
        //java.time.YearMonth y también podemos obtener la cantidad de días 
        //de ese mes, sobre todo cuando jugamos con los bisiestos
        YearMonth mes1 = YearMonth.now();
       
       
        System.out.printf("Este mes es %s y tiene %d días%n", mes1, mes1.lengthOfMonth());

        mes1 = YearMonth.of(2004, Month.FEBRUARY);
        System.out.printf("El mes %s tuvo %d días,%n", mes1, mes1.lengthOfMonth());
        mes1 = YearMonth.of(2002, Month.FEBRUARY);
        System.out.printf("el mes %s tuvo %d días,%n", mes1, mes1.lengthOfMonth());
        mes1 = YearMonth.of(2000, Month.FEBRUARY);
        System.out.printf("el mes %s tuvo %d días%n", mes1, mes1.lengthOfMonth());
        mes1 = YearMonth.of(1800, Month.FEBRUARY);
        System.out.printf("Pero el mes %s tuvo %d días ¿Sabías que no es considerado bisiesto?%n", mes1, mes1.lengthOfMonth());

        //La clase java.time.MonthDay representa a un día de un mes en
        //particular, tal como decir que el año nuevo es el 1 de enero.
        MonthDay dia2 = MonthDay.of(Month.FEBRUARY, 29);
        System.out.printf("El día %s %s es válido para el año 2010%n", dia2, dia2.isValidYear(2010) ? "" : "no"); //la respuesta será NO

//Y la clase java.util.Year nos permite manipular y conocer sobre
//un año en específico, sin importar el día o mes.
        Year año = Year.now();
        System.out.printf("Este año es %s y %s es bisiesto%n", año, año.isLeap() ? "sí" : "no");
		
        /*
        LocalDate 	minus(long amountToSubtract, TemporalUnit unit)
                //Returns a copy of this date with the specified amount subtracted.
LocalDate 	minus(TemporalAmount amountToSubtract)
                //Returns a copy of this date with the specified amount subtracted.
LocalDate 	minusDays(long daysToSubtract)
                //Returns a copy of this LocalDate with the specified number of days subtracted.
LocalDate 	minusMonths(long monthsToSubtract)
                // Returns a copy of this LocalDate with the specified number of months subtracted.
LocalDate 	minusWeeks(long weeksToSubtract)
                 //Returns a copy of this LocalDate with the specified number of weeks subtracted.
LocalDate 	minusYears(long yearsToSubtract)
                //Returns a copy of this LocalDate with the specified number of years subtracted.
static LocalDate 	now()
                //Obtains the current date from the system clock in the default time-zone.
        */
        
        /*
        LocalDate 	plus(long amountToAdd, TemporalUnit unit)
            //Returns a copy of this date with the specified amount added.
        LocalDate 	plus(TemporalAmount amountToAdd)
                //Returns a copy of this date with the specified amount added.
        LocalDate 	plusDays(long daysToAdd)
        Returns a copy of this LocalDate with the specified number of days added.
        LocalDate 	plusMonths(long monthsToAdd)
                //Returns a copy of this LocalDate with the specified number of months added.
        LocalDate 	plusWeeks(long weeksToAdd)
                //Returns a copy of this LocalDate with the specified number of weeks added.
        LocalDate 	plusYears(long yearsToAdd)
                   //Returns a copy of this LocalDate with the specified number of years added.

        
        
        */
       
        LocalDate hoy2 = hoy.plusDays(10);
        LocalDate hoy3 = hoy.plusMonths(10);
        LocalDate hoy4 = hoy.plusYears(10);
        
        System.out.printf("Hoy %s %n",hoy.toString());
        System.out.printf("Hoy + 10 dias %s %n",hoy2.toString());
        System.out.printf("Hoy + 10 meses %s %n",hoy3.toString());
        System.out.printf("Hoy + 10 años %s %n",hoy4.toString());
        
        
        
        System.out.printf(" %s  es %s que  %s %n",hoy.toString(), hoy.compareTo(hoy2)<1 ? "menor":"mayor", hoy2.toString());
        
        
       // hoy.compareTo(hoy2);
        
        
        
        
        
        
        
        
        System.out.println("==============Local  Time===========================================================");
//La clase java.time.LocalTime es similar a las otras cosas que 
        //comienza con el prefijo Local, pero se centra
        //únicamente en la hora. 
        LocalTime justoAhora = LocalTime.now();
        System.out.printf("En este momento son las %d horas con %d minutos y %d segundos\n",
                justoAhora.getHour(), justoAhora.getMinute(), justoAhora.getSecond());

        System.out.println("==============LocalDateTime===========================================================");
//La clase java.time.LocalDateTime manipula la fecha y la hora sin importar 
        //la zona horaria. Esta clase es usada para representar la fecha 
        //(año, mes, día) junto con la hora (hora, minuto, segundo, nanosegundo)
        //y es - en efecto - la combinación de LocalDate y LocalTime.      
        LocalDateTime ahora1 = LocalDateTime.now();
        System.out.printf("La hora es: %s%n", ahora1);

        LocalDateTime algunDia1 = LocalDateTime.of(1976, Month.MARCH, 27, 6, 10);
        System.out.printf("Yo nací el %s%n", algunDia1);

        System.out.printf("Hace seis meses fue %s%n", LocalDateTime.now().minusMonths(6));

        LocalDateTime ahora = LocalDateTime.now();
        System.out.printf("La hora es: %s%n", ahora);

        LocalDateTime algunDia = LocalDateTime.of(1976, Month.MARCH, 27, 6, 10);
        System.out.printf("Yo nací el %s%n", algunDia);

        System.out.printf("Hace seis meses fue %s%n", LocalDateTime.now().minusMonths(6));

        System.out.println("=======================================");

    }

}
