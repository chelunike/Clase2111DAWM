package escuela;
import java.util.Arrays;
/**
 * @author yo
 */
public class Alumno {
    //Codigo aqui :)
    
    //Propiedades de la clase
    private String nombre;
    private int edad;
    private int numAsig;
    private int minAsig;
    private String[] asig;
    private double[] asigNota;
    
    //Constructor
    public Alumno(){}
    
    public Alumno(String nombre, int edad, int numeroAsig){
        this.nombre = nombre;
        this.edad = edad;
        this.numAsig = numeroAsig;
        asig = new String[numeroAsig];
        asigNota = new double[numeroAsig];
    }
    
    //Get and Set for all of them :)
    //Get...
    public String getNombre(){
        return nombre;
    }
    
    public int Edad(){
        return edad;
    }
    
    public int getNumAsig(){
        return numAsig;
    }
    
    public int minAsig(){
        return minAsig;
    }
    
    public String[] getAsig(){
        return asig;
    }
    
    public double[] getAsigNota(){
        return asigNota;
    }
    
    //Set...
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setNumAsig(int n){
        this.numAsig = n;
    }
    
    public void setAsig(String[] asignaturas){
        this.asig = asignaturas;
    }
    
    public void setAsigNota(double[] notas){
        this.asigNota = notas;
    }
    
    // Metodos....porfin weeeeeeeeeeeeeeeeeeeeeeeeee
    
    public double notaMedia(){
        double media=0;
        for(int i=0; i<numAsig; i++){
            media += asigNota[i];
        }
        media /= numAsig;
        media = Escuela.trunca(media);
        return media;
    }
    
    public int asigPaSeptiembre(){
        int a=0;
        for(int i=0; i<numAsig; i++){
            if(asigNota[i]<5 && asigNota[i]>=0)
                a++;
        }
        return a;
    }
    
    public int asigAprobadas(){
            return numAsig - this.asigPaSeptiembre();
    }
    
    /**
     * Y pensar todo lo que hemos hecho
     * para acabar en array.sort() :)
     * 
     */
    public void ordenar(){
        Arrays.sort(asigNota);
    }
    
    public void ordenaAsig(){
        //Asignamos numeros a las letras
        String abc="abcdefghijklmñoprstuvwzyz";
        int[] tmp = new int[numAsig];
        for (int i=0; i<numAsig; i++) {
            for (int j=0; j<abc.length(); j++) {
                if (asig[i].substring(0) == abc.substring(j)) {
                    tmp[i]=j;
                }
            }
        }
        int ind=0, m;
        for (int k=numAsig-1; k>=0; k--) {
            m=tmp[0];
            for (int n=0; n<=k; n++) {
                if (tmp[n]>m) {
                    m=tmp[n];
                    ind=n;
                }
            }
            int tnp = tmp[k];
            tmp[k] = tmp[ind];
            tmp[ind] = tnp;
            String tmp2 = asig[k];
            asig[k] = asig[ind];
            asig[ind] = tmp2;
            double tmp3 = asigNota[k];
            asigNota[k] = asigNota[ind];
            asigNota[ind] = tmp3;
        }
        
    }
    
    public void ordenaAsig2(){
        int ind=0;
        for(int i=numAsig-1; i>=0; i--){
            String m = asig[0];
            for(int j=0; j<=i; j++){
                if(m.compareTo(asig[j]) <=0){
                    ind = j;
                    m = asig[j];
                }
            }
            String tmp = asig[ind];
            asig[ind] = asig[i];
            asig[i] = tmp;
            Double tmp2 = asigNota[ind];
            asigNota[ind] = asigNota[i];
            asigNota[i] = tmp2;
        }
    }
    
    public void ordenaAsig3(){
        for(int i=0; i<numAsig-1; i++){
            for(int j=numAsig-1; j<i; j--){
                if(asig[j].compareTo(asig[j-1])<=0){
                    String tmp = asig[j];
                    asig[j] = asig[j-1];
                    asig[j-1] = tmp;
                    double tmp2 = asigNota[j];
                    asigNota[j] = asigNota[j-1];
                    asigNota[j-1] = tmp2;
                }
            }
        }
    
    }
    
    @Override
    public String toString(){
        String cad="";
        cad += "Nombre: "+nombre;
        cad += "\tEdad: "+edad;
        cad += "\tNº Asignaturas: "+ numAsig;
        cad += "\nAsignaturas:\t Notas: \n";
        for(int i=0; i<numAsig; i++){
            cad += asig[i]+"\t";
            cad += asigNota[i]+"\n";
        }
        return cad;
    }
    
}
