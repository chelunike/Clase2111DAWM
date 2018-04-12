package exed20151124libros;

import java.time.LocalDate;

public class Libro implements Comparable<Libro> {
    String titulo;
    double precio;
    LocalDate fecha;
    public Libro (String ti, double pre, LocalDate fe){
        titulo= ti;
        precio= pre;
        fecha= fe;
    }
    @Override
    public String toString(){
        return String.format("%30s %8.2f %s", titulo, precio, fecha);
    }

    @Override
    public int compareTo(Libro o) {
        return this.titulo.compareTo(o.titulo);
    }
    
}
