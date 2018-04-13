package javaexamen;
/**
 * @author SIDiu
 */
public class C12 extends C1 {
    
    private int atributo2;

    public C12(int x, int y) {
        super(y);
        this.atributo2 = x;

    }

    @Override
    public void metodo2() {
        System.out.println("Hola desde C12");
        super.metodo4();
    }

    @Override // Esta no estaba
    public String metodo4() {
        return "hola desde C12";
    }

    @Override
    public int metodo1() {
        System.out.println("   hola esto no estaba metodo 1");
        return -1;
    }

    @Override
    public void metodo3() {
        System.out.println("Hola esto no estaba metodo 2");
    }
    
}
