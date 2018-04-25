package fechaedad;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author yono
 */
public class FechaEdad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = LocalDate.parse("1962-12-14");
        long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
        System.out.println("Edad: " + edad);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNac = LocalDate.parse("15-08-1993", fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s años, %s meses y %s días\n",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
        
        
        
           fmt = DateTimeFormatter.ofPattern("dd MM yyyy");
         fechaNac = LocalDate.parse("15 08 1993", fmt);
        ahora = LocalDate.now();

        periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s años, %s meses y %s días\n",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
        
        
        
        fechaNac =LocalDate.of(2000,2,1);
          ahora = LocalDate.now();
          edad = ChronoUnit.YEARS.between(fechaNac, hoy);
        System.out.println("Edad: " + edad);
          
          
          
    }

}
