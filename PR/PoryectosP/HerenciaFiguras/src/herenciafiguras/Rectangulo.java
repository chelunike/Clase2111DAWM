/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciafiguras;

/**
 *
 * suponer que los lados de un Rectangulo son paralelos a los ejes de
 * coordenadas.
 */
class Rectangulo extends Figura {

    double left, top, width, height;
    public Rectangulo( double x,double y, double w, double h){
        left = x; 
        top = y;
        width = w;
        height = h;
        
    }
    @Override
    public double area() {
        return width * height;
    }
}
