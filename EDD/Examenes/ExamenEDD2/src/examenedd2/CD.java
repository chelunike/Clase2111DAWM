package examenedd2;

import java.time.LocalDate;

public class CD implements Comparable<CD>{
    private String autor;
    private int pistas;
    private LocalDate fecsal;

    public CD(String autor, int pistas, LocalDate fecsal) {
        this.autor = autor;
        this.pistas = pistas;
        this.fecsal = fecsal;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPistas() {
        return pistas;
    }

    public void setPistas(int pistas) {
        this.pistas = pistas;
    }

    public LocalDate getFecsal() {
        return fecsal;
    }

    public void setFecsal(LocalDate fecsal) {
        this.fecsal = fecsal;
    }

    @Override
    public int compareTo(CD o) {
        return this.autor.compareTo(o.getAutor());
    }
    
    public String toString(){
        String cadena = "CD: "+"\n";
        cadena+="Autor: "+autor+"\n";
        cadena+="Pistas: "+pistas+"\n";
        cadena+="Fecha de salida: "+fecsal+"\n";
        cadena+= "\n";
        return cadena;
    }
    
    
}
