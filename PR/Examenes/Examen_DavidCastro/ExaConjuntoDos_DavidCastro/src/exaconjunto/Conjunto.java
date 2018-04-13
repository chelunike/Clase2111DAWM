package exaconjunto;
import java.util.ArrayList;

/**
 * @author David Castro
 */
public class Conjunto {
    
    private ArrayList<Elemento> elementos;
    
    public Conjunto(){
      elementos=new ArrayList();
    }
    
    public ArrayList<Elemento> getElementos(){
        return elementos;
    }
    
    public boolean pertenece(Elemento e){
        for(Elemento ele: elementos){
            if(ele.equals(e))
                return true;
        }
        return false;
    }
     
    public boolean  inserta(Elemento e){    
        if(this.pertenece(e)==false){
            this.elementos.add(e);
            return true;
        }
        return false;
    }
    
    public void union(Conjunto con){
        ArrayList eleCon=con.getElementos();   
        for(int i=0; i<eleCon.size();i++){
            if(this.pertenece((Elemento)eleCon.get(i))==false)
                this.elementos.add((Elemento)eleCon.get(i));
        }
    }
      
    @Override
    public String toString(){
        String salida ="listado del conjunto \n";
        for(Elemento e:elementos){
            salida+=e.toString()+"\n";
        }
        return salida;
    }
    
    
}
