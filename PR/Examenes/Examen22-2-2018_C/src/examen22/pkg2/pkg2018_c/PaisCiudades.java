package examen22.pkg2.pkg2018_c;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yo
 */
public class PaisCiudades {

    private HashMap< String, ArrayList<String>> paisCiudades;

    public PaisCiudades() {
        paisCiudades = new HashMap< String, ArrayList<String>>();
        ArrayList<String> ciudades = new ArrayList<String>();
        ciudades.add("Granada");
        ciudades.add("Madrid");
        ciudades.add("Valencia");
        ciudades.add("Jaén");
        this.paisCiudades.put("España", ciudades);
    }
//inserta país-ciudad si no está ya en el hashMap

    public boolean insertaPaisCiudad(String pais, String ciudad) {
        ArrayList <String> tmp = new ArrayList();
        if(paisCiudades.get(pais) == null){
            tmp.add(ciudad);
            paisCiudades.put(pais, tmp);
            return true;
        }else{
            if(paisCiudades.get(pais).contains(ciudad))
                return false;
            else{
                /*
                tmp = paisCiudades.get(pais);
                tmp.add(ciudad);
                */
                for(String c: paisCiudades.get(pais))
                    if(!tmp.contains(c))
                        tmp.add(c);
                paisCiudades.put(pais, tmp);
                return true;
            }
        }
    }
    
    
    public String toString(){
        String xd="";
        String[] tmp = paisCiudades.keySet().toArray(new String[0]);
        for(String p: tmp){
            xd +="Pais "+p+": ";
            for(String c:paisCiudades.get(p))
                xd+=c+", ";
            xd+="\n";
        }
        return xd;
    }
    
}
