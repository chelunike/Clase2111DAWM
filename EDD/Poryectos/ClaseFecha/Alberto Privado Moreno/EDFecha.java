package edfecha;
public class EDFecha {
    public static void main(String[] args) {
        Fecha f1 = new Fecha(20,4,2020);
        Fecha f2 = new Fecha("25-03-2018");
        if (f1.correcta() && f2.correcta()){
            if (f1.mayorQue(f2))
                Fecha.intercambio(f1, f2);
//            System.out.println("Diferencia en dias: " +f1.difDias(f1, f2));
//            System.out.println("Diferencia en meses: " +f1.difMeses(f1, f2));
            System.out.println("Diferencia en años: " +f1.difAños(f2));
//            
            System.out.println("Fecha 1: " + f1.cadenaSimple());
            System.out.println("Fecha 2: " + f2.cadenaSimple());
            System.out.println("Fecha 1: " + f1.getD() + " de " + f1.nombreMes() + " de " +  f1.getA());
            System.out.println("Fecha 2: " + f2.getD() + " de " + f2.nombreMes() + " de " +  f2.getA());
            
        
//            System.out.println("Correcto");
//            else
//            System.out.println("Fallo");
                
    }
        
}
}