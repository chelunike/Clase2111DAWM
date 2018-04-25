package trycatch;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
public class TryCatch {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        boolean algo=true;
        while (algo) {
            try {
                System.out.print("Escribe una fecha: ");
                String cadena = e.nextLine();
                String Divisor = "-";
                if (!cadena.contains("-")) {
                    Divisor = "/";
                }
                String[] vals = cadena.split(Divisor);
                if (vals.length != 3) {
                    throw new ArrayIndexOutOfBoundsException();//ArrayIndexOutOfBoundsException //No tiene la longitud exacta o no tiene guiones etc...
                }
                int dd = Integer.parseUnsignedInt(vals[0]);//NumberFormatException No es un numero
                int mm = Integer.parseUnsignedInt(vals[1]);//NumberFormatException No es un numero
                int yyyy = Integer.parseUnsignedInt(vals[2]);//NumberFormatException No es un numero
                LocalDate fecha = LocalDate.of(yyyy, mm, dd);//DateTimeException si la fecha esta mal
                if (yyyy >= 3000) {
                    throw new DateTimeException(""); //Excepción si el año es mayor o igual a 3000
                }
                algo=false;
            } catch (DateTimeException ex) {
                System.err.println("Fecha incorrecta, Prueba denuevo!");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("Por favor utiliza '-' o '/' e introduce con este formato dd-mm-yyyy o dd/mm/yyyy");
            } catch (NumberFormatException ex) {
                System.err.println("Error al intentar convertir los numeros");
            } catch (Exception ex) {
                System.err.println("Error desconocido");
            }
        }
        System.out.println("Fecha correcta");
    }
}
