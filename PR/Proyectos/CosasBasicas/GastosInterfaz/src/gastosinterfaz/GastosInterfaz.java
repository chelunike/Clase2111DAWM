package gastosinterfaz;
/**
 * @author yo
 */
public class GastosInterfaz {

    public static void main(String[] args) {
        // <code> Aqui </code>
        
        Gastos g = new Gastos();

        
        //Crear Objetos
        EmFijo Paco = new EmFijo("Paco    ",30,100,10);
        EmComision Patata = new EmComision("Patata  ",12,100,10);
        EmFijo yo = new EmFijo("yo       ",18,200,5);
        EmComision Sapatoz = new EmComision("Sapatoz ",1,100,1);
        
        Compra c1 = new Compra("Tornillos",5,0.5);
        Compra c2 = new Compra("Tuercas  ",5,0.5);
        Compra c3 = new Compra("Patatas  ",1,5.5);
        Compra c4 = new Compra("Explosivos",100,2.5);
        
        //Insertamos
        g.inserta(Paco);
        g.inserta(Patata);
        g.inserta(yo);
        g.inserta(Sapatoz);
        g.inserta(c1);
        g.inserta(c2);
        g.inserta(c3);
        g.inserta(c4);
        
        //Ahora son Imprimi2
        
        System.out.println("Listao de Gastos Pal IRPF"+g.listadoGastos());
        
    }
    
}
