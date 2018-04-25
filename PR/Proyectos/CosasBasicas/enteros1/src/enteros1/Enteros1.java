package enteros1;
/**
 * @author yo
 */

public class Enteros1 {

    public static void main(String[] args) {
        Enteros2 patata = new Enteros2();
        patata.setValor(3);

        System.out.println(patata.factorial(3));
        Enteros2 sapatoz = new Enteros2();
        sapatoz.setValor(12);
        
        //System.out.println(sapatoz.esPrimo(3));
        
        System.out.println("Valores iniciales -1º: "+sapatoz.getValor()+" -2º: "+patata.getValor());
        System.out.println("Intercambio....");
        intercambio(sapatoz, patata);
        System.out.println("Valores iniciales -1º: "+sapatoz.getValor()+" -2º: "+patata.getValor());
        
    }
    
    //Estas son mi clases,  solo for me :)
    private static void intercambio(Enteros2 a , Enteros2 b){
        int tmp;
        tmp = a.getValor();
        a.setValor(b.getValor());
        b.setValor(tmp);

    }
}
