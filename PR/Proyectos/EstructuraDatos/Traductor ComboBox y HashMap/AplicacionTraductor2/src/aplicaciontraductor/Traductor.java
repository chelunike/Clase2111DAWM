package aplicaciontraductor;

import java.util.StringTokenizer;

/**
 * @author yo
 */

public class Traductor {

    public static final int FRANCES = 0;
    public static final int ESPAÑOL = 1;
    public static final int INGLES = 2;
    public static final int NUM_IDIOMAS = 3;
    private int idiomaOrigen;
    private int idiomaDestino;
    private String[][] diccionario = {
        {"Longue", "Rédiut", "Pain", "Bombe", "Moto","Patatin","Bonjou"},
        {"Largo", "Barato", "Pan", "Petardo", "Moto","Patata","Hola"},
        {"Long", "Cheap", "Bread", "Bomb", "Motorbike","Potato","Hello"}};
    private static String[] cadena = {"Francés", "Español",
        "Inglés"};
    
    private static String[][][] superArray ={
        {
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"}
        },
        {
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r"}
        },
        {
            {"s","t","u"},
            {"v","w","x"},
            {"y","z","patata"}
        }
    };
    
    public static String test(){
       String tmp = "";
       for(int i=0; i<superArray.length; i++){
           for(int j=0; j<superArray[i].length; j++){
               for(int k=0; k<superArray[j].length; k++)
                   tmp += superArray[i][j][k]+", ";
           }
       }
       
       return tmp+superArray.length;//superArray[2][2][2];
    }
        
        
    public Traductor() {
        this.idiomaOrigen = ESPAÑOL;
        this.idiomaDestino = INGLES;
    }

    public static String getCadenaIdioma(int codIdioma) {
        return cadena[codIdioma];
    }

    public void setIdiomaOrigen(int idiomaOrigen) {
        this.idiomaOrigen = idiomaOrigen;
    }

    public void setIdiomaDestino(int idiomaDestino) {
        this.idiomaDestino = idiomaDestino;
    }

    public int getIdiomaOrigen() {
        return idiomaOrigen;
    }

    public void invierteIdioma() {
        int aux;
        aux = idiomaOrigen;
        idiomaOrigen = idiomaDestino;
        idiomaDestino = aux;
    }

    public int getIdiomaDestino() {
        return idiomaDestino;
    }

    public String[] getPalabras(int codIdioma) {
        return diccionario[codIdioma];
    }

    public String traducePalabra(String palabra) {
        return this.traducePalabra(palabra, this.idiomaOrigen,
                this.idiomaDestino);
    }

    public String traducePalabra(String palabra,
            int codOrigen, int codDestino) {
        int i = 0;
        boolean encontrado = false;
        while ((i < diccionario[ESPAÑOL].length)
                && !encontrado) {
            if (palabra.equalsIgnoreCase(diccionario[codOrigen][i])) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (encontrado) {
            return diccionario[codDestino][i];
        } else {
            return "X";
        }
    }

    public String traduceTexto(String texto) {
        return this.traduceTexto(texto, this.idiomaOrigen,
                this.idiomaDestino);
    }

    public String traduceTexto(String texto, int codOrigen,
            int codDestino) {
        StringBuffer traduccion = new StringBuffer();
        StringTokenizer st = new StringTokenizer(texto,
                " \n");
        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            traduccion.append(this.traducePalabra(palabra,codOrigen, codDestino));
            traduccion.append(" ");
        }
        return traduccion.toString();
    }
}
