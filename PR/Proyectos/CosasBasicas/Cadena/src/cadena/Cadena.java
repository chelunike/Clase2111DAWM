package cadena;
import java.util.Scanner;
/**
 * @author yo
 */
public class Cadena {
/**
 * Acitividades :) 16-Oct
 * Leer una cadena 
 * Escribir cuantos caracteres tiene una cadena
 * Escriva cuantas veces aparece el caracter a
 * Escirba si es palindromo
 * Escriba si la letra b esta en la cadena
 * @param args
 * Acts 17-Oct
 * Me pasan un caden en fomato dd-mm-aaaa
 * sacar fecha  y asegurar los diez caracteres.
 * y comprobar enteros.
 * 
 */
    
    public static void main(String[] args) {
        // Er codijo aki
        // Llamar a una sola activida plizz
        
        //Cadena1.init();
        //fecha();
        String c1 ,c2;
        c1 = "Hola";
        c2 = "Potato";
        System.out.println("Compara: "+ c1.equals(c2));// compareTo()
        
        
    }
    
    //Actividad Cadena
    public static boolean palindromo(String cad){
        boolean p = false;
        for (int i=0;i<cad.length();i++){
            if(cad.charAt(i)==cad.charAt(cad.length()-i-1)){
            p = true;
            }
        }        
        return p;
    }
    //Actividad Fecha/Cadena :)
    public static void fecha(){
        String fecha,dd="",mm="",aa="";
        Scanner l = new Scanner(System.in);
        System.out.print("Insertar fecha, si es logica mejor: ");
        fecha=l.nextLine();
        System.out.println("Gracias...");
        if (fecha.length()==10){
            System.out.println("Longitud fecha correcta ");
            if ((fecha.charAt(2)=='-'||fecha.charAt(5)=='/')
                && (fecha.charAt(2)=='-'||fecha.charAt(5)=='/')){
                
                dd= fecha.substring(0, 2);
                mm=fecha.substring(3, 5);
                aa=fecha.substring(6);
                if(esDig(dd) && esDij(mm) && esDij(aa)){
                    System.out.println("Formato fecha weno :) ");
                }else{
                    System.out.println("Formato fecha chungo :( ");}
            }
        }else{
            System.out.println("Longitud fecha incorrecta");
        }
        System.out.println(" -dia: "+dd+" -mes: "+mm+" -año: "+aa);    
    }
    
    public static boolean esDig(String j){
        for(int i=0;i<j.length();i++){
            if (!(j.charAt(i)>47 && j.charAt(i)<= 58)){
                return false;}
        }
        return true;
    }
    
    public static boolean esDij(String s){
        try{
            int n = Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error "+ e.getMessage());
            return false;
        }
    }
}
