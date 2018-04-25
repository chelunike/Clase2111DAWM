package datejava;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.format.FormatStyle;
import java.*;
/**
 * @author yo
 */
public class DateJava {

    public static void main(String[] args) {
        // TODO code application logic here
        
        LocalDate l = LocalDate.now();
        Locale k = new Locale("es", "ES");
        System.out.println("Hoy"+l.toString());
        System.out.println("Hoy2: "+l.getDayOfWeek());
        DayOfWeek hoydia = l.getDayOfWeek();
        String dia = hoydia.getDisplayName(TextStyle.FULL, k);
        
        System.out.println("asd: %s "+dia);
        
    }
    
}
