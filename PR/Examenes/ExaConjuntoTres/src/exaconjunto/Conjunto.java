package exaconjunto;
import java.util.ArrayList;
/**
 * @author yo
 */
public class Conjunto {

    private ArrayList<Elemento> elementos;

    public Conjunto() {
        elementos = new ArrayList <Elemento>();
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
        ArrayList<Elemento> intersec = new ArrayList<Elemento>();
        //--escriba código

    }

    public void diferencia(Conjunto con) {
        ArrayList<Elemento> diferencia = new ArrayList<Elemento>();
        //--escriba código

    }
    public void ordenaPorNombre(){
        //--escriba código
    }
    public void ordenaPorValor(){
        //--escriba código
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
