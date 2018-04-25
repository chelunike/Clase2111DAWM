package empleadosherencia;
import java.util.ArrayList;
/**
 * @author yo
 */
public class Nomina {
    
    private ArrayList <Empleado> lista; 
    
    public Nomina(){
        lista = new ArrayList <Empleado>();
    }
    
    public void insert(Empleado o){
        lista.add(o);
    }
    
    @Override
    public String toString(){
        String cad="Nobmre:\tSueldo:\n";
        for(Empleado o:lista){
            cad +=o.getNombre()+"\t"+o.sueldo()+"\n";
        }
        return cad;
    }
}

