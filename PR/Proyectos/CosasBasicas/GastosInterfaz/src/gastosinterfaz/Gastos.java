package gastosinterfaz;
import java.util.ArrayList;
/**
 * @author yo
 */
public class Gastos {
    
    private ArrayList <IGastos> gastos;
    
    public Gastos(){
        gastos = new <IGastos> ArrayList();
    }
    
    public void inserta(IGastos i){
        gastos.add(i);
    }
    
    public String listadoGastos(){
        String list="\nNombre  \tGastos\n";
        double t=0;
        for(IGastos n:gastos){
            list += n.descripcion()+"\t"+n.pagar()+"\n";
            t += n.pagar();
        }
        return list + "Total a pagar:  "+t+" :D";
    }
}
