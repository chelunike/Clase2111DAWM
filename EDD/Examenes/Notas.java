public class Notas {
    private String[] nombre= {"Ana", "Jose", "Luis", "Pepe", "María"};
    private int[][] nota={{8,3,2},{5,6,7},{4,1,3},{2,2,2},{9,3,10}};
    private double[] media= new double[5];    
    public String getNombre(int pos){
        if (pos<0 || pos>=nombre.length)
            return "";
        return nombre[pos];
    }
    public int getNota(int pos, int pexa){
        if (pos<0 || pos>=nombre.length || pexa<0 || pexa>=3)
            return -1;
        return nota[pos][pexa];
    }
    public double getMedia(int pos){
        if (pos<0 || pos>=nombre.length)
            return -1;
        return media[pos];
    }
    // paso los valores de los pesos y calcula las medias
    public boolean ponePesos(int p1, int p2, int p3){
        if (p1==p2 || p1==p3 || p2==p3) {
            for(int i=0; i<nombre.length; i++){
                media[i]= 0;
            }
            return false;
        }
        for(int i=0; i<nombre.length; i++){
            media[i]= (nota[i][0]*p1+nota[i][1]*p2+nota[i][2]*p3)/6.0;
        }
        return true;
    }
}
