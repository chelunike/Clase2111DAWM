package enteros1;

/*
 * No necesito lisencia porque esto España y asemos lo ke keremos xD
 * 
 * @author yo
 */

public class Enteros2 {    
    private int valor;
    public static int CERO=0; // Constante
    public Enteros2(){} //Constructor por defecto
    public Enteros2(int p){//Constructor de la clase
    
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    public int suma (int potato){
        return this.valor+potato;
    }
    public int getValor(){
        return this.valor; // 10/10
    } 
    public static void hola(int n){
        System.out.println("Hola toma se te ha caido esto: "+n);
    }
    public int multiplicar(int x){
        return this.valor*x;
    }
    public int factorial(int k ){
        if (k >= 0 && k <= 10){
            int f = 1;
            for(int i=1;i <= k;i++){
                f = f*i;
            }
            return f;
        }else{
            return -1;
        }
    }
    public boolean esPrimo(int n){
        int div=2,tmp=n,exp=0;
        do {
            while(tmp%div==0){
                tmp /= div;
                exp++;
                }
            div++;
        }while(tmp > 1);
        if (exp==1){
            return true;
        }else{return false;}       
    }
    public void intercambia(Enteros2 ehh){
        int tmp;
        tmp = valor;
        this.valor = ehh.getValor();
        ehh.setValor(tmp);
    }
}//End Class