package javaexamen;
/**
 * @author yo
 */
public abstract class C1 {

    private int atributo1;

    public C1(int a1) {
        this.atributo1 = a1;
    }

    public abstract int metodo1();/* {
        return atributo1 * 2;
    }*/

    public void metodo2() {
        System.out.println("hola soy el métodod2 desde C1");
    }//; No da error como tal

    public abstract void metodo3();

    public String metodo4() {
        return "hola desde C1";
    }
    
}
