package mappaiscuidad;
import java.util.HashMap;

/**
 * @author yo
 */
public class MapPaisCuidad {

    public static void main(String[] args) {
        HashMap <String, String[]> paisCiudades = new HashMap <String, String[]>();

        paisCiudades.put("España", new String[]{"Granada", "Madrid", "HuertoVega", "Valencia", "Er Zaidin Sity"});
        paisCiudades.put("Francia", new String[]{"Paris", "Lyon", "Burdeos"});
        paisCiudades.put("Portugal", new String[]{"Lisboa", "Setubal", "Oporto"});
        paisCiudades.put("PatataLandia", new String[]{"Tuberculo", "PatataDC", "Huertos en la Vega"});

        //String[] paises = paisCiudades.keySet().toArray(new String[paisCiudades.keySet().size()]);
        String[] paises = paisCiudades.keySet().toArray(new String[0]);
        for (String pais : paises) {
            String[] ciudades = paisCiudades.get(pais);
            System.out.println("Pais: " + pais);

            for (String ciudad : ciudades) {
                System.out.println("\tCiudad: " + ciudad);
            }
        }
        
        /**
         * Para comobox.
         * https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
         *  :)
         */
        
        //Ventana :) 
        
        new Ventanal(paisCiudades);
        
        
    }
    
}
