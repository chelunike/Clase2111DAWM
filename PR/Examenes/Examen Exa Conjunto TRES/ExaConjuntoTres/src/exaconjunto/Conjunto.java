package exaconjunto;
import java.util.ArrayList;
/**
 * @author yo
 */
public class Conjunto {

    private ArrayList <Elemento> elementos;

    public Conjunto() {
        elementos = new ArrayList<Elemento>();
    }

    public Conjunto(Elemento[] lista) {
        elementos = new ArrayList <Elemento>();
        for (int i = 0; i < lista.length; i++) {
            elementos.add(lista[i]);
        }
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public boolean pertenece(Elemento e) {
        if (elementos.contains(e)) {
            return true;
        } else {
            return false;
        }
    }

    public Conjunto(ArrayList<Elemento> lista) {
        elementos = lista;
    }

    public boolean inserta(Elemento e) {
        if (pertenece(e)) {
            return false;
        } else {
            return elementos.add(e);
        }
    }

    public void borra(Elemento e) {
        elementos.remove(e);
    }


    public void interseccion(Conjunto con) {
        ArrayList <Elemento> interset = new ArrayList();
        
        for(Elemento ele:elementos){
            if(con.pertenece(ele))
                interset.add(ele);
        }
        
        elementos = interset;
    }
    
    public void diferencia(Conjunto con) {
        ArrayList <Elemento> dif = new ArrayList();
        
        for(Elemento ele:elementos){
            if(!con.pertenece(ele))
                dif.add(ele);
        }
        
        elementos = dif;
    }
    
    public void ordenaPorNombre(){
       elementos.sort(null);
    }
    
    public void ordenaPorValor(){
        elementos.sort(new ComparaValor());
    }
    
    @Override
    public String toString() {
        String salida = "listado del conjunto \n";
        for (Elemento e : elementos) {
            salida += e + "\n";
        }
        return salida;
    }
}
/*
-- Interseccion
        ArrayList<Elemento> intersec = new ArrayList <Elemento>();
        ArrayList <Elemento> ele2 = con.getElementos();
        
        for(Elemento ele:elementos){
            if(ele2.contains(ele))
                intersec.add(ele);
        }

        elementos = intersec;

---Diferencia
        ArrayList<Elemento> diferencia = new ArrayList<Elemento>();
        ArrayList <Elemento> ele2 = con.getElementos();
        
        for(Elemento ele:elementos){
            if(!ele2.contains(ele))
                diferencia.add(ele);
        }

        elementos = diferencia;

*/