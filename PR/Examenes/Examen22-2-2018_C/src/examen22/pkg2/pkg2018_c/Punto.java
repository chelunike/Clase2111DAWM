package examen22.pkg2.pkg2018_c;

/**
 * @author El Profesor
 */
public class Punto {
    //Atributos
    private double x;
    private double y;
    
    //Constructores
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    //Metodos
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia() {
        return Math.sqrt(x * x + y * y);
    }
    
    
}
