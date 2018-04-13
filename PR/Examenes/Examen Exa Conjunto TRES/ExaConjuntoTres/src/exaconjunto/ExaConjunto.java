package exaconjunto;
/**
 * @author yo
 */
public class ExaConjunto {

    public static void main(String[] args) {
        
        Elemento e1;
        
        e1 = new Elemento();
        e1.setNombre("casa");

        e1.setValor("a");

        System.out.println("1 elemento = " + e1);

        e1.setNombre("casa");

        e1.setValor("10");

        System.out.println("3 elemento = " + e1);
        e1 = new Elemento("piso", "-5");
        System.out.println("4 elemento = " + e1);

        Conjunto cA, cB;

        cA = new Conjunto();
        cA.inserta(new Elemento("casa", "20"));
        cA.inserta(new Elemento("piso", "30"));
        cA.inserta(new Elemento("local", "10"));

        System.out.println("5 cA: " + cA);
        
        cA.ordenaPorNombre();
        System.out.println("6 cA por nombre: " + cA);
       
         cA.ordenaPorValor();
        System.out.println("7 cA por valor: " + cA);

        cB = new Conjunto();
        cB.inserta(new Elemento("casa", "20"));
        cB.inserta(new Elemento("parcela", "40"));
        Elemento solar = new Elemento("solar", "50");
        System.out.println("8-"+cB.inserta(solar));
        System.out.println("9-"+cB.inserta(new Elemento("solar", "50")));
        System.out.println("10-cB: " + cB);
        System.out.println("11-está: " + cB.pertenece(new Elemento("solar", "50")));

        cB.borra(new Elemento("solar", "50"));
        System.out.println("10-cB despues de borrar solar : " + cB);



        cA.interseccion(cB);
        System.out.println("12- cA intersección union B:" + cA);

        cA = new Conjunto();
        cA.inserta(new Elemento("casa", "20"));
        cA.inserta(new Elemento("piso", "30"));
        cA.inserta(new Elemento("local", "10"));

        cA.diferencia(cB);
        System.out.println("13- cA menos  B:" + cA);
        
    }

}
