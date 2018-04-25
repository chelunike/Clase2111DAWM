// Fig. 14.2: Suma.java
// Programa de suma que utiliza a JOptionPane para entrada y salida.
package d14.pkg2;
import javax.swing.JOptionPane; 

/**
 *
 * @author prg
 */
public class D142 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // obtiene la entrada del usuario de los diálogos de entrada de JOptionPane
      String primerNumero = 
         JOptionPane.showInputDialog( "Introduzca el primer entero" );
      String segundoNumero =
          JOptionPane.showInputDialog( "Introduzca el segundo entero" );

      // convierte las entradas String en valores int para usarlos en un cálculo
      int numero1 = Integer.parseInt( primerNumero ); 
      int numero2 = Integer.parseInt( segundoNumero );

      int suma = numero1 + numero2; // suma números

      // muestra los resultados en un diálogo de mensajes de JOptionPane
      JOptionPane.showMessageDialog( null, "La suma es " + suma, 
         "Suma de dos enteros", JOptionPane.PLAIN_MESSAGE );
      JOptionPane.showMessageDialog( null, "La suma es " + suma, 
         "Suma de dos enteros", JOptionPane.WARNING_MESSAGE );
      JOptionPane.showMessageDialog( null, "La suma es " + suma, 
         "Suma de dos enteros", JOptionPane.ERROR_MESSAGE);
        System.out.println("salida: "+JOptionPane.showConfirmDialog(null, suma));
    }
    
    
}
