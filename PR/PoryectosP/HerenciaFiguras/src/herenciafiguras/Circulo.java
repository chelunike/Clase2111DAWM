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
class Circulo extends Figura {

    double centerX, centerY, radius;
    public Circulo(double x, double y, double r){
        centerX = x;
        centerY = y;
        radius = r;
        
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
