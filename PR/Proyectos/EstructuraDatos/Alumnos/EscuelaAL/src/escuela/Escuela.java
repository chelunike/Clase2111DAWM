package escuela;
import java.util.Scanner;
/**
 * @author yo
 */
public class Escuela {
    /**
     * Esta es mi clase principal Escuela :)
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Er codijo aki
        System.out.println("Bienvenido a la Escuela");
        
//////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        //Construimos
        Alumno yo =  new Alumno("Patata", 10, 0);
        
        String[] asig = {"Lengua  ","Mates   ","Cono    ","Historia","Musica   ","Religion"}; 
        yo.setAsig(asig);
        double[] nota = {5, 6, 4, 7, 8, 9};
        yo.setAsigNota(nota);
        
        //yo.ordenaAsig();
        System.out.println(yo.toString());
        System.out.println("Nota media de las asignaturas: "+yo.notaMedia());
        System.out.println("Numeros asignaturas aprobadas: "+yo.asigAprobadas());
        System.out.println("Numero asignaturas suspensas: "+yo.asigPaSeptiembre()); 
        */
        
        
        //Creo alumnos imhajinarios
        Alumno yo = Escuela.leerAlumn("yo",10,6);
        Alumno Pocoyo = Escuela.leerAlumn("Pocoyo",4,6);
        Alumno Manu = Escuela.leerAlumn("Manuer",18,6);
        Alumno Placido = Escuela.leerAlumn("Placido",10,6);
        Alumno David = Escuela.leerAlumn("David",27,6);
        Alumno Jozemi = Escuela.leerAlumn("Josemi",18,6);
        
        
        Clase pr = new Clase(6);

        Escuela.say(pr.insertaOrden2(yo));
        pr.insertaOrden2(Manu);
        pr.insertaOrden2(Jozemi);
        pr.insertaOrden2(Pocoyo);
        pr.insertaOrden2(David);
        pr.insertaOrden2(Placido);
        
        
        
        System.out.println("Lista Alumnos: "+pr.toString());
        
        System.out.println("  -------\\Informacion/-------  \n"+pr.listaInfo());
    }
//////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Metodos Escuela   
    
    public static Alumno leerAlumn(){
        //Lo necesario
        Scanner teo = new Scanner(System.in);
        
        //Valores imprencindibles
        System.out.print("Insertar nombre: ");
        String nom = teo.nextLine();
        System.out.print("\nInsertar edad: ");
        int eda = teo.nextInt();
        System.out.print("\nInsertar numero de asignaturas: ");
        int numa = teo.nextInt();
        //Asignaturas y notas
        String[] tmpA = new String[numa];
        double[] tmpN = new double[numa];
        for(int i=0; i<numa; i++){
            System.out.printf("Inserte nombre asignatura "+(i+1)+"º : ");
            tmpA[i] = teo.next();
            System.out.printf("Inserte la nota de la asignatura: ");
            tmpN[i] = teo.nextDouble();
        }
        
        //Empezamos a definir la clase wee
        Alumno al1 = new Alumno(nom, eda, numa);
        
        al1.setAsig(tmpA);
        al1.setAsigNota(tmpN);
        
        //Apañao y listo para enviar :3
        return al1;
    }
    
    
    /**
     * Insertar alumnos imhajinarios
     * 
     * @param  nom Nombre
     * @param  edad Edad
     * @param  numAsig Nº Asignaturas
     * 
     * @return Devuelve un objeto alumno :) 
     */
    public static Alumno leerAlumn(String nom, int edad, int numAsig){
        //Empezamos a definir la clase wee
        Alumno al1 = new Alumno(nom, edad, numAsig);
        
        //Valores Predeterminados/Aleatorios
        String[] asig = {"Literatura","Matemáticas","Dibujo Tec","Historia","Tecnologia",
              "Religion","Programacion", "Lectura", "Fisolofia"};
        
        //Aleatorio = zapatos
        String[] tnp = new String[numAsig];
        double[] tmp = new double[numAsig];
        for(int i = 0; i<numAsig; i++){
            tnp[i]= asig[i];
            tmp[i] = Escuela.trunca(Math.random()*10);
        }
        al1.setAsig(tnp);
        al1.setAsigNota(tmp);
        
        //Apañao y listo para enviar :3
        return al1;
    }
    
    public static double trunca(double n){
        int tmp = (int)(n*100);
        return (double)tmp/100;
    }
    
    
    public static void say(boolean c){
        if (c){
            System.out.println("-_-_-_-_-_-_-_-_-_-");
            System.out.println("|    Correcto :)  |");
            System.out.println("|       :)/       |");
            System.out.println("|       /|        |");
            System.out.println("|        |        |");
            System.out.println("|       / \\       |");
            System.out.println("-_-_-_-_-_-_-_-_-_-");
        }else{
            System.out.println("-_-_-_-_-_-_-_-_-_-");
            System.out.println("|  Incorrecto :(  |");
            System.out.println("|      \\ /        |");
            System.out.println("|       |         |");
            System.out.println("|       |/        |");
            System.out.println("|      /:(        |");
            System.out.println("-_-_-_-_-_-_-_-_-_-");
        }
    }
    
}
