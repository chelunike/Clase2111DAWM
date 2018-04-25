/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecantar;

/**
 *
 * @author juan
 */
public class InterfaceCantar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p = new Persona();
        hacerCantar(p);
        Canario c = new Canario();
        hacerCantar(c);
        ICantante p1 = new Persona();
        hacerCantar(p1);
     
 
    }

    public static void hacerCantar(ICantante c) {
        String nombreClase = c.getClass().getName();
            System.out.print("nombre clase: " + nombreClase);
        c.cantar();
    }

}
