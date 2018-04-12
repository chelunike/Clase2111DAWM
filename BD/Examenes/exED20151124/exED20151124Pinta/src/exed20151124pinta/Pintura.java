package exed20151124pinta;

public class Pintura {
    private char caracter;
    public Pintura(char ca){
        caracter= ca;
    }
    private String horizontal(int lon) {
        String s="";
        for (int i=0; i<lon; i++)
            s+= caracter;
        return s+"\n";
    }
    private String vertical(int lon) {
        String s="";
        for (int i=0; i<lon; i++)
            s+= caracter + "\n";
        return s;
    }
    private String vertical(int lon, int ancho) {
        String sAncho="";
        for (int i=0; i<ancho; i++)
            sAncho+= " ";
        String s="";
        for (int i=0; i<lon; i++)
            s+= caracter + sAncho + caracter + "\n";
        return s;
    }
    public String silla(int altRespaldo, int anchuraAsiento, int altPata){
        String s="";
        s+= vertical(altRespaldo);
        s+= horizontal(anchuraAsiento);
        s+= vertical(altPata, anchuraAsiento-2);
        return s;
    }
    
}
