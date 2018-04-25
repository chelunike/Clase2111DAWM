package appmatriz;

/**
 * @author yo
 */
public class AppMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Purebas Con las Matrizes
        //Creamos Matrizes
        Matriz m1 = new Matriz();
        Matriz m2 = new Matriz();
        Matriz r = new Matriz();
        //Asiganamos matrizes
        r.setMatriz(Matriz.multiplicacion(m1, m2));
        //LAs escribimos
        System.out.println(""+m1.toString());
        System.out.println(""+m2.toString());
        System.out.println(""+r.toString());
        System.out.println(""+Matriz.checkMulti(m1.getMatriz(), m2.getMatriz()));
        
        //Ventana
        new Ventana(m1, m2);
        
    }
    
}
