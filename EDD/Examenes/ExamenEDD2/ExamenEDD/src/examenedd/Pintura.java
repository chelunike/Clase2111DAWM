package examenedd;

public class Pintura {
    
    private char pint;
    
    public Pintura() {
    }

    public Pintura(char pint) {
        this.pint = pint;
    }

    public char getPint() {
        return pint;
    }

    public void setPint(char pint) {
        this.pint = pint;
    }
    
    public String silla (int respaldo, int asiento, int pata){
        String cadena = "";
        for (int i = 0; i < respaldo; i++) {
            cadena+=pint+"\n";
        }
        for (int i = 0; i < asiento; i++) {
            cadena+=pint;
        }
        cadena+="\n";
        for (int i = 0; i < pata; i++) {
            cadena+=pint;
            for (int j = 0; j < asiento-2; j++) {
                cadena+=' ';
            }
            cadena+=pint+"\n";
        }
        return cadena;
    }
}
