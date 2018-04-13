/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaconjunto;

/**
 *
 * @author prg
 */
public class Elemento implements Comparable <Elemento> {

    private String nombre;
    private int valor;

    public Elemento() {

    }

    public Elemento(String n, String s) {
        setValor(s);
        setNombre(n);
    }

    public void setValor(String s) {
        //--escriba código
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "nombre: " + nombre + " // valor: " + valor;

        return salida;
    }

    public boolean equals(Object e) {
        if (nombre.equalsIgnoreCase(((Elemento) e).getNombre()) && valor == ((Elemento) e).getValor()) {
            return true;
        }
        return false;

    }

    @Override
    public int compareTo(Elemento o) {
        return nombre.compareToIgnoreCase(o.getNombre());
    }
}
