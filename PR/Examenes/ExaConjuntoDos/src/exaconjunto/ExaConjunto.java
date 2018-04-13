/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaconjunto;

/**
 *
 * @author prg
 */
public class ExaConjunto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Elemento e1;

        e1 = new Elemento();
        e1.setNombre("casa");
        try {
            e1.setValor(1);
        } catch (ExcepcionConjuntoValor e) {
            System.out.println("mensage: " + e.getMessage());
        }
        System.out.println("1 elemento = " + e1);
        try {
            e1.setValor(-1);
        } catch (ExcepcionConjuntoValor e) {
            System.out.println("2 mensage: " + e.getMessage());
        }
        System.out.println("3 elemento = " + e1);
        e1 = new Elemento("piso", -5);
        System.out.println("4 elemento = " + e1);

        Conjunto cA, cB;

        cA = new Conjunto();
        cA.inserta(new Elemento("casa", 20));
        cA.inserta(new Elemento("piso", 30));
        cA.inserta(new Elemento("local", 10));

        System.out.println("5 cA: " + cA);

        cB = new Conjunto();
        cB.inserta(new Elemento("casa", 20));
        cB.inserta(new Elemento("parcela", 40));
        Elemento solar = new Elemento("solar", 50);
        System.out.println("6-"+cB.inserta(solar));
        System.out.println("7-"+cB.inserta(new Elemento("solar", 50)));
        System.out.println("8-cB: " + cB);
        System.out.println("9-está: " + cB.pertenece(new Elemento("solar", 50)));

        cA.union(cB);
        System.out.println("11- cA despues union B:" + cA);

    }

}
