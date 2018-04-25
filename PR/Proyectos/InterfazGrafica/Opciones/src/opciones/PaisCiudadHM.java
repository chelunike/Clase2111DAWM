package opciones;
import java.util.HashMap;

/**
 * @author yo
 */
public class PaisCiudadHM implements Datos{
    //Atributos
    private HashMap <String, String[]> paisCiudades;
    
    public PaisCiudadHM(){
        paisCiudades = new HashMap <String, String[]>();
    }
    
    public PaisCiudadHM(HashMap <String, String[]> mapa){
        paisCiudades = mapa;
    }
    
    //Metodos
    public void rellenaEjemplo(){
        paisCiudades.put("España", new String[]{"Granada", "Madrid", "HuertoVega", "Valencia", "Er Zaidin Sity"});
        paisCiudades.put("Francia", new String[]{"Paris", "Lyon", "Burdeos"});
        paisCiudades.put("Portugal", new String[]{"Lisboa", "Setubal", "Oporto"});
        paisCiudades.put("PatataLandia", new String[]{"Tuberculo", "PatataDC", "Huertos en la Vega"});
    }
    
    public String[] getPaises(){
        return paisCiudades.keySet().toArray(new String[0]);
    }
    
    public String[] getCiudades(String pais){
        return  paisCiudades.get(pais);
    }
    
    
    //Metodos Interfaz
    @Override
    public String[] damePais() {
        return this.getPaises();
    }

    @Override
    public String[] dameCiudades(String Pais) {
        return this.getCiudades(Pais);
    }
    
    
    
    @Override
    public String toString(){
        String cad ="";
        String[] paises = paisCiudades.keySet().toArray(new String[0]);
        for (String pais : paises) {
            String[] ciudades = paisCiudades.get(pais);
            cad += "\n-Pais: " + pais+"\n\\tCiudad:";
            for (String ciudad : ciudades) {
                cad += ciudad + ", ";
            }
        }
        return cad;
    }

}
