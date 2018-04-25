package opciones;

/**
 * @author yo
 */
public class PaisCiudadArray implements Datos {
    
    //Atributos
    private String[] paises;
    private String[][] ciudades;
    
    //Constructor
    
    public PaisCiudadArray(int keyLength, int dataLength){
        paises = new String[keyLength];
        ciudades = new String[keyLength][dataLength];
    }
    
    //Metodos
    
    public void rellenaEjemplo(){
        String[] paises = {"España", "Francia", "Portugal", "PatataLandia"};
        String[][] ciudades = {
            {"Granada", "Madrid", "HuertoVega", "Valencia", "Er Zaidin Sity"},
            {"Paris", "Lyon", "Burdeos"},
            {"Lisboa", "Setubal", "Oporto"},
            {"Tuberculo", "PatataDC", "Huertos en la Vega"}
        };
        this.paises = paises;
        this.ciudades = ciudades;
    }
    
    private int getIndexData(String key){
        for(int i=0; i<paises.length; i++)
            if(paises[i].compareToIgnoreCase(key)==0)
             return i;
        return -1; 
    }
    
    public String[] getData(String key){
        return this.getData(this.getIndexData(key));
    }
    
    public String[] getData(int keyIndex){
        String[] tmp = new String[ciudades[keyIndex].length];
        //for(int i=0; i<tmp.length; i++)
        //    tmp[i] = ciudades[keyIndex][i];
        tmp = ciudades[keyIndex];
        return tmp;
    }
    
    
    //Metodos de la Interfaz

    @Override
    public String[] damePais() {
        return paises;
    }

    @Override
    public String[] dameCiudades(String Pais) {
        return this.getData(Pais);
    }
    
    
    @Override
    public String toString(){
        String cad ="";
        int i=0;
        for(String k:paises){
            cad += "\nPais: "+k+"\n\tCiudades: ";
            for(String c: ciudades[this.getIndexData(k)])
                cad += c+", ";
        }
        return cad;
    }
    
}
