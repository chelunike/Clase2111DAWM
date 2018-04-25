package lista;
/**
 * @author yo
 */
public class Lista {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // el codigo jere
        Entero l1, l2;
        l1 = new Entero(5);
        l2 = new Entero(6);
        
        l1.rellenoRandom();
        l1.TeoLee();

        System.out.println("Inicio ordenar ...");
        l1.ordenaPivot();
        l1.TeoLee(); 
        
    }

}
