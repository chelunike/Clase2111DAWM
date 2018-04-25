package escuela;
//import java.util.Arrays;
/**
 * @author yo
 */
public class Clase {
    //Codigo aqui :)
    
    // Propiedades
    private int maxAlum;
    private int numAlum;
    private Alumno[] alumn;
    
    //Contructores
    public Clase(){}
    public Clase(int numMaxAlumnos){
        this.maxAlum = numMaxAlumnos;
        alumn = new Alumno[maxAlum];
        numAlum = 0;
    }
    
    //Metodos get Y set de todos
    //Get
    
    public int getMaxAlum() {
        return maxAlum;
    }

    public Alumno[] getAlumns() {
        return alumn;
    }
    
    // Set 

    public void setMaxAlum(int maxAlum) {
        this.maxAlum = maxAlum;
    }

    public void setAlumns(Alumno[] alumns) {
        this.alumn = alumns;
    }
    
    //Metodos weeeeeeeeeeee
    
    public boolean insertar(Alumno al1){
        boolean c;
        if(numAlum<maxAlum){
            alumn[numAlum] = al1;
            numAlum ++;
            c = true;
        }else
            c = false;
        return c;
    }
    
    public boolean insertaOrden(Alumno al1){
        boolean c=false;
        if(numAlum<maxAlum){
            if(numAlum == 0){
                alumn[0]=al1;
                numAlum++;
                c=true;
            }else{
                int i = 0;
                while(i<numAlum && alumn[i].getNombre().compareTo(al1.getNombre())<=0)
                    i++;
                
                for(int j=numAlum; j>i; j--){
                    //Alumno aux = alumn[j];
                    alumn[j]=alumn[j-1];
                    //alumn[j-1]=aux;
                }
                alumn[i]=al1;
                numAlum++;
                c=true;
            }
        }
        return c;
    }
    
    public int busca(Alumno al1){
        return this.busca(al1.getNombre()) ;
    }
    
    public int busca(String nombre){
        int ind=-1;
        for(int i = 0; i<numAlum; i++){
            if(alumn[i].getNombre() == nombre)
                ind=i;
        }
        return ind;
    }
    
    public boolean borra(Alumno al1){
        return this.borra(al1.getNombre());
    }
    
    public boolean borra(String nombre){
        if(this.busca(nombre)>0){
            int ind = this.busca(nombre);
            for(int i=ind; i<numAlum-1; i++){
                alumn[i] = alumn[i+1];
            }
            alumn[numAlum-1] = null;
            numAlum--;
            return true;
        }else
            return false;
    }
    
    
    @Override
    public String toString(){
        String cad = "";
        for(int i=0; i<numAlum; i++){
            if(i==0)
                cad+="[ "+(alumn[i]== null? alumn[i]: alumn[i].getNombre())+", ";
            else if(i==numAlum-1)
                cad+=alumn[i]== null? alumn[i]: alumn[i].getNombre()+" ]";
            else
                cad += alumn[i]== null? alumn[i]: alumn[i].getNombre()+", ";
        }
        return cad;
    }
    
    
    public String listadoAlumAsig(){
        String list = "";
        list += "Nombre \tNºSusp NºApro \tNotaMedia\n";
        for(int i=0; i<numAlum; i++){
            list += alumn[i].getNombre()+"\t";
            list += alumn[i].asigPaSeptiembre()+"\t";
            list += alumn[i].asigAprobadas()+"\t";
            list += alumn[i].notaMedia()+"\n";
        }
        return list;
    }
    
}
