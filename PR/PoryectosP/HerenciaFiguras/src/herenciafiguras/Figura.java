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
abstract class Figura implements IOrdenable {
    
    abstract double area();
    
    public boolean menor(IOrdenable obj) {
        return obj instanceof Figura
                && area() < ((Figura) obj).area();
    }

    
}
