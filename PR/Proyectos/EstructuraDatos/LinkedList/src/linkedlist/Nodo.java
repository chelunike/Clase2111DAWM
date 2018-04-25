package linkedlist;
/**
 * @author yO
 */
public class Nodo {
    
    //Variables
    
    private Nodo sig;
    private int data;
    private String cad;
    private double num;
    
    //Contructor
    //public Nodo(){}
    
    public Nodo(int dato, Nodo dir){
        data=dato;
        sig = dir;
    }
    
    public Nodo(int dato){
        data=dato;
    }
    
    //---------Metodos----------
    
    //Set Y Get

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
    
    
    
}
