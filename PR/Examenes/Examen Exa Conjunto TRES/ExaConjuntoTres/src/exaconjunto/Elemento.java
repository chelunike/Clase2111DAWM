package exaconjunto;
/**
 * @author yo
 */
public class Elemento implements Comparable <Elemento> {

    private String nombre;
    private int valor;

    public Elemento() {

    }

    public Elemento(String n, String s) {
        setValor(s);
        setNombre(n);
    }

    public void setValor(String s){
        try{
            this.valor = Integer.parseInt(s);
        }catch(java.lang.NumberFormatException n){
            this.valor=0;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "nombre: " + nombre + " // valor: " + valor;

        return salida;
    }

    @Override
    public boolean equals(Object e) {
        if (nombre.equalsIgnoreCase(((Elemento) e).getNombre()) && valor == ((Elemento) e).getValor()) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Elemento o) {
        return nombre.compareToIgnoreCase(o.getNombre());
    }
}
