package opciones;

/**
 * @author yo
 */
public class Opciones {

    public static void main(String[] args) {
        
        //Dato 1
        PaisCiudadHM mapita = new PaisCiudadHM();
        mapita.rellenaEjemplo();
        
        //Dato 2
        PaisCiudadArray paisArray = new PaisCiudadArray(0,0);
        paisArray.rellenaEjemplo();
        
        new Ventana(mapita);
        //new Ventana(paisArray);
    }
    
}
