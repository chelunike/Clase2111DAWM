package examen22.pkg2.pkg2018_c;

/**
 * @author yo
 */
public class Examen {

    public static void main(String[] args) {
        //Actividades
        // -- Act 1 Datos Test
        Punto p1 = new Punto(2, 2);
        Punto p2 = new Punto(1, 4);
        Punto p3 = new Punto(5, 2);
        Punto p4 = new Punto(10, 1);
        
        Datos d1 = new Datos();
        d1.add(p1);
        d1.add(p2);
        d1.add(p3);
        d1.add(p4);
        
        System.out.println("Distancia Media: "+d1.distanciaMedia());
        
        
        // -- Act 2 Test
        //Correcta: Una librería para construir interfaces gráficas
        
        // -- Act 3 insertaPaisCiudad
        PaisCiudades pc = new PaisCiudades();
        System.out.println("Insertamos: España, Granada. ¿Inserto?: "+pc.insertaPaisCiudad("España", "Granada"));
        System.out.println("Insertamos: España, Zaidin. ¿Inserto?: "+pc.insertaPaisCiudad("España", "Zaidin"));
        System.out.println("Insertamos: PatataLandia, Huerto de Patatas. ¿Inserto?: "+pc.insertaPaisCiudad("PatataLandia", "Huerto de Patatas"));
        
        System.out.println("HashMap: \n"+pc.toString());
        
        // -- Act 4 Test
        //Correcta: public class Componente implements Printable
        
    }
    
}
