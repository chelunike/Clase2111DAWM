package empleadossinherencia;
import java.util.ArrayList;
/**
 * @author yo
 */
public class Nomina {
    
    private ArrayList lista; 
    
    public Nomina(){
        lista = new ArrayList();
    }
    
    public void insert(Object o){
        lista.add(o);
    }
    
    @Override
    public String toString(){
        String cad="Nobmre:\tSueldo:\n";
        for(Object o:lista){
            if(o instanceof EmpleadoFijo)
                cad+=((EmpleadoFijo)o).toString()+"\n";
            else if(o instanceof EmpleadoComision)
                cad +=((EmpleadoComision)o).toString()+"\n";
        }
        return cad;
    }
}
