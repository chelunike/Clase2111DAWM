/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciafiguras;

/**
 *
 * @author prg
 */
public class HerenciaFiguras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Figura r1 = new Rectangulo(1, 1, 10, 4);
        Figura r2 = new Rectangulo(1, 1, 10, 2);
        Figura c1 = new Circulo(1, 1, 2);

        Figura[] lista = new Figura[3];

        lista[0] = r1;
        lista[1] = r2;
        lista[2] = c1;

        System.out.println("lista:");
        for (Figura fig : lista) {
            System.out.println("Area: " + fig.area());
        }

        Util.ordenar(lista);

        System.out.println("lista:");

        for (Figura fig : lista) {
            System.out.println("Area: " + Math.round(fig.area()*100)/100.0);
        }
        
    }

}
