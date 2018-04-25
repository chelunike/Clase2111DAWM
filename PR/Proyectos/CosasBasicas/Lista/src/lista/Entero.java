package lista;
/**
 * @author yo
 */
public class Entero {
    
    private int[] array;
    private int maxEle;
    private int numEle;
    //piratas int carive;
    private String[] cadena;
    
    public Entero(int maxElem){
        this.maxEle = maxElem;
        maxEle = maxElem;
        array = new int[maxElem];
        numEle =0;
    }
    
    public Entero(int[] lista){
        array = lista;
    }
    
    public int recuperar(int j){
        return array[j];
    }
    
    public void setArray(int[] a){
        array = a;
    }
    
    public int[] getRaw(){
        return array;
    }
    
    public int buscar(int valor){
        int i=0;
        for(int e=0;e<maxEle; e++){
            if(array[e]==valor)
                i = e;
        }
        return i;
    }
    
    /*public void inValor(int ind, int val){
        array[ind] = val;
    }*/
    public boolean insert(int numero){
        if (numEle < maxEle){
            array[numEle] = numero;
            numEle++;
            return true;
        }else
            return false;
    }
    
    public boolean insertOrden(int valor){
        if(this.insert(valor)){
            this.insert(valor);
            this.ordena2();
            return true;
        }else
            return false;
    }
    
    public boolean insertOrden2(int valor){
        boolean c = false;
        System.out.println(this.numEle);
        if(numEle <= maxEle){
            c = true;
            for(int i=0; i<numEle; i++){
                if(valor>array[i] && (valor<array[i+1] || array[i+1]==0)){
                    for(int k=numEle; k>i; k--){
                        array[k] = array[k-1];
                    }
                    array[i+1] = valor;
                }
            }
            numEle++;
        }
        return c;
    }
    
    public boolean insertOrdenP(int valor){
        boolean c = false;
        int i=0;
        if(numEle<maxEle){
            while(i<numEle && valor>array[i])
                i++;
            if(i!=numEle){
                for(int j=numEle; j>i; j--){
                    array[j]=array[j-1];
                }
            }
            array[i]=valor;
            c=true;
            numEle++;
        }
        return c;     
    }
    
    public void borrar(int indice){
        if(indice>=0 && indice<maxEle){
            for(int i=indice; i <maxEle; i++){
                if(i<maxEle-1)
                    array[i]=array[i+1];
            }
            array[maxEle-1] = 0;
            this.numEle --;
        }else
            System.out.println("Error Posicion Incorrecta :( ");
    }   
    
    public static void TeoLeeArray(String[] s){
        for(int i=0;i<s.length-1;i++){
            System.out.print(s[i]+"; ");
        }
        System.out.println("");
    }
    
    public void TeoLee(){
        for(int e=0;e<maxEle;e++){
            System.out.print(array[e]+", ");
        }
        System.out.println("");
    }
    
    public void TeoLee(int[] n){
        for(int e=0;e<n.length;e++){
            System.out.print(n[e]+", ");
        }
        System.out.println("");
    }
    
    public void abcde(int lon){
        cadena = new String[lon];
        String abc="abcdefghijklmnñopqrstuvwxyz";
        for(int k=0;k<lon;k++){
            cadena[k]= abc.substring(k);
        }
    }
    
    public static void TeoLeeArray(int[] s){
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]+"; ");
        }
        System.out.println("");
    }
    
    @Override
    public String toString(){
        String cad="";
        for(int i=0;i<maxEle;i++){
            if(i==0){
                cad +="["+array[i]+", ";
            }else if(i>0 && i<maxEle-1){
                cad += array[i]+", ";
            }else if (i== maxEle-1){
                cad += array[i]+"]";
            }
        }
        return cad;
    }
    
    public void relleno(){
        for(int f=0;f<maxEle;f++){
            array[f] = f+1;
        }
        this.numEle = maxEle-1;
    }
    
    public void rellenoRandom(){
        for(int j=0;j<maxEle;j++){
            int s = 1;//= ((int)(Math.random()*2) < 1) ? -1: 1;
            array[j] = (int)(Math.random()*10)*s;
        }
        this.numEle = maxEle-1;
    }
    
    public static String arrayToString(int[] n){
        String s="";
        for(int j=0;j<n.length-1;j++){
            s += n[j];
        }
        return s;
    }
    
    public int mayor(){
        int c = array[0];
        for(int i=0;i<maxEle;i++){
            if (array[i]>c){
                c = array[i];
            }
        }
        return c;
    }
    
    public int menor(){
        int c = array[0];
        for(int i=0;i<maxEle;i++){
            if (array[i]<c){
                c = array[i];
            }
        }
        return c;
    }
    
    public void suma(Entero n2){
        for(int i=0;i<maxEle;i++){
            this.array[i] += n2.recuperar(i);
        }
    }
    
    public static int[] borra(int[] list, int ind){
        int[] tmp = new int[list.length];
        for(int i=ind;i<list.length;i++){
            if (i != list.length-1)
                tmp[i]=list[i+1];
        }
        tmp[list.length-1] = 0;
        return tmp;
    }
    
    /*public void ordena(){
        int[] list = array;
        int lon = maxEle;
        for(int i=0;i<array.length;i++){
            int m = list[0], ind=0;
            for(int j=0;j<lon;j++){
                if(m > list[j]){
                    m = list[j];
                    ind = j;
                }
            }
            array[i] = m;
            for(int k=ind;k<list.length;k++){
                if (k != list.length-1)
                    list[k]=list[k+1];
            }
            list[list.length-1] = 0;
            lon--;
        }
    }
    */
    public void ordena2(){
        int tmp;
        for(int i=0; i<maxEle; i++){
            for(int j=i; j<maxEle; j++){
                if(array[i]>array[j]){
                    tmp=array[i];
                    array[i]= array[j];
                    array[j]= tmp;
                }
            }
        }
    }
    
    //Busqueda Binaria
    /**
     * Algoritmo de busqueda binaria
     * 
     * @param valor es el valor a buscar
     * @return Devuelve el indice del valor si no hay devuelve -1
     */
    public int buscaBinaria(int valor){
        int ind = -1, i= 0, f= numEle, m=1;
        while(m>0 && i<=f){
            m = (i+f)/2;
            //System.out.println("Num m "+m);
            if(valor < array[m]){
                f = m -1;
            }else{
                i = m +1;
            }
            if(valor == array[m]){
                ind = m;
                break;
            }
        }
        return ind;
    } 
    
    public int buscaBinariaP(int valor){
        int i=0, f=numEle-1, m;
        while(i<f){
            m = (i+f)/2;
            if(valor == array[m])
                return m;
            else{
                if (array[m]<valor){
                    f = m -1;
                }else{
                    i = m +1;
                }
            }
        }
        return -1;
    }
    
    //ordenamiento por seleccion
    public void ordenaMayonesa(Entero e){
        for(int j=numEle; j>=0; j--){
            e.mayorAbajo(j);
        }
    }
    
    public void mayonesaAbajo(int n){
        int tmp, m=array[0];
        for(int i=0;i<n;i++){
            if(m > array[i]){
                tmp = array[i];
                array[i]=m;
                array[i-1]=tmp;
            }else
                m=array[i];
        }
    }
    
    public void mayorAbajo(int n){
        int ind=0;
        for(int i=0; i<n; i++){
            if(array[i]>=array[ind]){
                ind=i;
            }
        }
        int tmp = array[n];
        array[n] = array[ind];
        array[ind] = tmp;
    }
    
    public void ordenMenor(Entero e){
        for(int m=0;m<=maxEle-1;m++){
            e.menorUp2(m);
        }
    }
    
    public void menorUp(int n){
        int ind=0, m=array[n];
        for(int k=maxEle-1; k>=n; k--){
            if(array[k]<=m){
                m = array[k];
                ind = k;
            }
        }
        int tmp=array[n];
        array[n]=array[ind];
        array[ind]=tmp; 
    }
    
    public void menorUp2(int n){
        int tmp, m=array[maxEle-1];
        for(int g=maxEle-1; g>=n; g--){
            if(m<array[g]){
                tmp = array[g];
                array[g]=m;
                array[g+1]=tmp;
            }else
                m=array[g];
        }
    }
    
    /**
     * Algoritmo de ordenamiento por el cual se organizan los datos entorno
     * a un pivote y se colocan a la izquierda luego se colocan a la izquierda
     * o derecha del pivote
     *  :w
     * --- Recursividad
     */
    public void ordenaPivot(){
        //cojer un pivote 
        
        //inicio y fin del recorrido del pivote
        int i=0, f=array.length-1;
        
        //Recorer y desplazar y/o mover
        // --- Otro metodo
        this.pivotear(i, f);
    }
    
    /**
     * Y aqui es donde ocurre la magia de la recusividad
     * @param inicio El inicio del Pivote
     * @param fin El final del Pivote
     */
    public void pivotear(int inicio, int fin){
        int p = array[inicio], pos=inicio;
        for(int j=inicio+1; j<=fin; j++){
            if(p>=array[j]){
                int tmp = array[j];
                array[j] = array[pos+1];
                array[pos+1] = array[pos];
                array[pos] = tmp;
                pos++;
            }
        }
        if(inicio != fin){
            this.pivotear(0,pos-1);
            this.pivotear(pos+1, array.length-1);
        }
    }
}