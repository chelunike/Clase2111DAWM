package fecha;

public class EDFecha {

    public static void main(String[] args) {
        Fecha f1 = new Fecha(27, 02,2015);
        Fecha f2 = new Fecha(28,02,2012);
        if (f1.correcta() && f2.correcta()) {
            if (f2.mayor(f1)) {
                Fecha.intercabio(f1, f2);}

                System.out.println("CORRECTA");
            } else {
                System.err.println("INCORRECTA");
            }
            System.out.println("Diferencia en dias:"+f1.difDias(f2));
            System.out.println("Diferencia en meses:"+f1.difMeses(f2));
            System.out.println("Diferencia en años:"+f1.difAños(f2));
//            System.out.println("De la fecha:"+f1.cadenacompleta());}
        

//        }
        System.out.println("fecha 1: " + f1.cadenasimple());
        System.out.println("fecha 2: " + f2.cadenasimple());
    }
}
