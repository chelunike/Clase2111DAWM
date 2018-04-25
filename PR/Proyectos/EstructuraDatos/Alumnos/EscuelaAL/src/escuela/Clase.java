package escuela;
import java.util.*;
/**
 * @author yo
 */
public class Clase {
    //Codigo aqui :)

/*    // 1.0
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
*/    
    // 2.0
    //Variables
    private ArrayList <Alumno> alumnos = new ArrayList <Alumno>();
    private int maxAlum;
    
    //Constructor
    public Clase(int maxAlumnos){
        maxAlum=maxAlumnos;
    }
    
    // Gets Y Sets
    public Alumno getAlumno(int i){
        return (Alumno) alumnos.get(i);
    }
    
    // -----\Metodos/-------
    
    // --- Set Y Get ---

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public int getNumAlum() {
        return alumnos.size();
    }

    public int getMaxAlum() {
        return maxAlum;
    }

    public void setMaxAlum(int maxAlum) {
        this.maxAlum = maxAlum;
    }
    

    //---------------------
    
    public boolean inserta(Alumno al1){
        if(alumnos.size()<maxAlum){
            alumnos.add(al1);
            return true;
        }else
            return false;
        
    }
    
    public boolean insertaOrden(Alumno al1){
        if(alumnos.size()<maxAlum){
            alumnos.add(al1);
            //alumnos.sort(null);
            return true;
        }else
            return false;
    }
    
    public boolean insertaOrden2(Alumno al1){
        boolean c=false;
        if(alumnos.size()<maxAlum){
            int i = 0;
            while(i<alumnos.size() && alumnos.get(i).getNombre().compareToIgnoreCase(al1.getNombre())<=0)
                i++;

            alumnos.add(i, al1);
            c=true;
        }
        return c;
    }
    
    public int busca(Alumno al1){
        return this.busca(al1.getNombre());
    }
    
    public int busca(String al1Nom){
        for(int i=0; i<alumnos.size(); i++){
            if(alumnos.get(i).getNombre().equals(al1Nom))
                return i;
        }
        return -1;
    }
    
    public boolean borra(Alumno al1){
        return this.borra(al1.getNombre());
    }
    
    public boolean borra(String al1Nom){
        if(this.busca(al1Nom)>=0){
            alumnos.remove(this.busca(al1Nom));
            return true;
        }else
            return false;
    }
    
    @Override
    public String toString(){
        String cad="";
        for(int i=0; i<alumnos.size(); i++){
            cad += (i==0?"[":"") + alumnos.get(i).getNombre()+ (i==alumnos.size()-1?"]":", ");
        }
        return cad;
    }
    
    public String listaInfo(){
        String list="";
        list += "Nombre \tNºSusp NºApro \tNotaMedia\n";
        for(int i=0; i<alumnos.size(); i++){
            list += alumnos.get(i).getNombre()+"\t";
            list += alumnos.get(i).asigPaSeptiembre()+"\t";
            list += alumnos.get(i).asigAprobadas()+"\t";
            list += alumnos.get(i).notaMedia()+"\n";
        }
        return list;
    }
    
    public String listaInfo2(){
        String list="";
        list += "Nombre \tNºSusp NºApro \tNotaMedia\n";
        for(Alumno alu:alumnos){
            list += alu.getNombre()+"\t";
            list += alu.asigPaSeptiembre()+"\t";
            list += alu.asigAprobadas()+"\t";
            list += alu.notaMedia()+"\n";
        }
        return list;
    }
    
}
