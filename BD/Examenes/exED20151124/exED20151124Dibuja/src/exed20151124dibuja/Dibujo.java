package exed20151124dibuja;

public class Dibujo {
    int altura;
    public Dibujo(int alt){
        altura= alt;
    }
    public String cuña(char ca){
        String s=ca+"\n";
        for (int i=1; i<altura-1; i++) {
            s+= ca;
            for (int k=0; k<i-1; k++)
                s+= " ";
            s+= ca+"\n";
        }
        for (int i=0; i<altura; i++) 
            s+= ca;
        return s+"\n";
    }
    
}
