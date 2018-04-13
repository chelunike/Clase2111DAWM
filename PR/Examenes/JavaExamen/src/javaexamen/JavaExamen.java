package javaexamen;

import java.util.ArrayList;

/**
 * @author yo
 */
public class JavaExamen {

    public static void main(String[] args) {
        // TODO code aki, mi arma
        
        //---------Actividad 1 ----------
        //C1 c1 = new C1(1); 
        /*
        C12 c12 = new C12(1, 2);
        c12.metodo2();
        c12.metodo4();
        C1 c12Bis = new C12(3, 5);
        */  
        //-------------------------------
        //-----Activdad 2----------------
        //salida: Hola desde C12
        
        //-- Actividad 3
        ArrayList lista = JavaExamen.linkedRandom(10);
        
        //-- Actividad 4
        Examen mio = new Examen("yo he aprobado");
        
        System.out.println("Examen: "+mio.dameCadenaSinUltimaPalabra());
        
    }

    /*
    
// ----------- Actividad 1 ----------
//    Buscar errores
    
    abstract class C1 {

        private int atributo1;

        public C1(int a1) {
            this.atributo1 = a1;
        }

        public abstract int metodo1() {
            return atributo1 * 2;
        }

        public void metodo2() {
            System.out.println("hola soy el métodod2 desde C1");
        };
        
        public abstract void metodo3();

        public String metodo4() {
            return "hola desde C1";
        }
    }
    
//        Clase C1 
//            Los metodos abstratactos no pueden 
//        ser definidos.
//            No se puede poner un punto y coma al 
//        cerrar el corchete no da error
    
    
    class C12 extends C1 {

        private int atributo2;

        public C12(int x, int y) {
            super(y);
            this.atributo2 = x;
            
        }

        @Override
        public void metodo2() {
            System.out.println("Hola desde C12");
            super.metodo4();
        }

        public String metodo4() {
            return "hola desde C12";
        }
    }
    
    
//        Clase C12
//            Los metodos abstractos no se definen
//            El super del constructor debe de estar al principio
    
    
    
    public class PE1 {
        public static void main(String[] args) {
            C1 c1 = new C1(1);
            C12 c12 = new C12(1, 2);
            c12.metodo2();
            c12.metodo4();
            C1 c12Bis = new C12(3, 5);
        }
    }
    
    //Un metodo abstracto no se puede instanciar
    */
    
    
    
//Actividad 3  Escriba código Java en el que se defina un método que reciba 
//como parámetro un ArrayList lista de enteros y que meta los números pares de 
//lista en el ArrayList pares , los múltiplos de tres en el ArrayList m3 y el 
//resto en el ArrayList otros y que después elimine los enteros pares de lista.
    //(5 puntos)
    
    
    
    public static void actividad2(ArrayList <Integer> lista){
        ArrayList pares = new ArrayList();
        ArrayList m3 = new ArrayList();
        ArrayList <Integer> otros = new ArrayList();
        
        for(int x:lista){
        //for(int i=0; i<lista.size(); i++)
            if(x%2 == 0){
                pares.add(x);
                lista.remove(x);
            }else if(x%3 == 0){
                m3.add(x);
            }else
                otros.add(x);
        }
    }
    
    public static ArrayList <Integer> linkedRandom(int lon){
        ArrayList <Integer> tmp = new ArrayList();
        for(int i=0; i<lon; i++){
            tmp.add((int)Math.random()*100);
        }
        return tmp;
    }
    
}
