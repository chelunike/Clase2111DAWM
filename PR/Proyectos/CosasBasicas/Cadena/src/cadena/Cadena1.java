package cadena;
import java.util.Scanner;

/**
 * @author yo
 */
public class Cadena1 {
    public static void init(){
        //Actividades de cadena 16-Oct
        
        Scanner potato = new Scanner(System.in);
        String cad;
        System.out.print("Insertar cadena: ");
        cad = potato.nextLine();
        System.out.println("Cadena introducida:"+cad);
        //Longitud
        System.out.println("La longitud de la cadena es de: "+cad.length());
        //Letra a
        int cnt=0;
        cad = cad.toLowerCase();
        for(int i=0;i<cad.length();i++){
            if (cad.charAt(i)=='a')
                cnt ++;
        }
        
        System.out.println("En la cadena se repite la a : "+cnt+" veces.");
        //Palindromo
        String tmp;
        tmp = cad.substring(0,cad.length()/2);
        String tmp2;
        String tmp3 ="";
        if (cad.length()%2==0){
            tmp2 = cad.substring(cad.length()/2,cad.length());
        }else{
            tmp2= cad.substring(cad.length()/2+1,cad.length());
        }

        for(int j = tmp2.length()-1;j>=0;j--){
            tmp3+=tmp2.charAt(j);
        }

        if (tmp==tmp3){
            System.out.println("La cadena es palindromo");
        }else{
            System.out.println("La cadena no es palindromo");
        }
        System.out.println("La cadena es palindromo?"+Cadena.palindromo(cad));
        //Aparece B
        boolean apareceB=false;
        
        for(int i=0;i<cad.length();i++){
            if(cad.charAt(i)=='b')
                apareceB=true;
        }
        
        if(apareceB==true)
            System.out.println("El caracter 'b' SÍ está en la cadena");
        else
            System.out.println("El caracter 'b' NO está en la cadena");
    }
}
