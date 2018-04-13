package examen22.pkg2.pkg2018_c;

import java.util.ArrayList;

/**
 * @author yo
 */
public class Datos {
    //Atributos
    private ArrayList<Punto> datos;
    
    //Constructores
    public Datos(){
        datos = new ArrayList();
    }
    
    public Datos(ArrayList <Punto> puntos){
        datos = puntos;
    }
    
    //Metodos
    public void add(Punto p) {
        datos.add(p);
    }
    
    public double distanciaMedia(){
        if(datos.size()==0)
            return -1;
        double dm = 0.0;
        for(Punto p:datos)
            dm+=p.distancia();
        return dm/datos.size();
    }
}
