package javaexamen;
/**
 * @author yo
 */
    /*
    ----------Actividad 3-----------
    4.- Construir una clase Examen que declare un atributo String cadena y 
    que implemente la interfaz llamada
    IExamen. El contenido de esta interfaz es el siguiente:
    public interface IExamen{
    String dameCadenaSinUltimaPalabra();
    }
    El método devuelve la cadena miembro de la clase sin la última palabra. 
    Se supone que las palabras dentro de la
    cadena están separadas por un solo espacio en blanco y que no hay espacios
    al principio ni al final. Si la cadena está
    formada por una sola palabra la devuelve la cadena vacía.
    “pepeluis”.substring(2,6) devuelve “pelu”.charAt(),
    lastIndexOf(); contains() (2 +2 puntos)

    */

public class Examen implements dameCadenaSinUltimaPalabra {
    
    private String cadena;
    
    public Examen(String frase){
        cadena = frase;
    }
    
    public String dameCadenaSinUltimaPalabra(){
        String cad="";
        if(!(cadena.contains(" ")))
            return cad;
        else{
            cad=cadena;
            for(int i=cadena.length()-1; i>0; i--){
                if(cad.substring(i,i+1).equals(" "))
                    return cad.substring(0,i);
            }
        }
        return " ";
    }
    
}
