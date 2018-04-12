package usodefechas;

public class Fecha {

    private int dia;
    private int mes;
    private int año;

    public Fecha() {
    }

    public Fecha(String DDMMAAAA) throws Exception {
        if (setFromString(DDMMAAAA) != 0) {
            throw new Exception("No se pudo iniciar la clase, Imposible establecer esa fecha");
        }
    }

    public Fecha(int dia, int mes, int año) throws Exception {
        if (set(dia, mes, año) != 0) {
            throw new Exception("No se pudo iniciar la clase, Imposible establecer esa fecha");
        }
    }

    public Fecha(Fecha Fecha) throws Exception {
        if (set(Fecha) != 0) {
            throw new Exception("No se pudo iniciar la clase, Imposible establecer esa fecha");
        }
    }

    public int setFromString(String DDMMAAAA) {
        try {
            String div = "/";
            if (!DDMMAAAA.contains("/")) {
                if (DDMMAAAA.contains("-")) {
                    div = "-";
                } else {
                    return -1;
                }
            }
            String[] vals = DDMMAAAA.split(div);
            if (vals.length == 3) {
                if (set(Integer.parseUnsignedInt(vals[0]), Integer.parseUnsignedInt(vals[1]), Integer.parseUnsignedInt(vals[2])) == 0) {
                    return 0;
                }
            }
            return -1;
        } catch (Exception ex) {
            return -1;
        }

    }

    public int set(int dia, int mes, int año) {
        if (EsCorrecta(dia, mes, año)) {
            this.dia = dia;
            this.mes = mes;
            this.año = año;
            return 0;
        }
        return -1;
    }

    public int set(Fecha Fech) {
        if (set(Fech.getDia(), Fech.getMes(), Fech.getAño()) == 0) {
            return 0;
        }
        return -1;
    }

    public static boolean EsCorrecta(Fecha Fech) {
        return EsCorrecta(Fech.getDia(), Fech.getMes(), Fech.getAño());
    }

    public static boolean EsCorrecta(int dia, int mes, int año) {
        if (año < 1600) {
            return false;
        }
        if (!(mes >= 1 && mes <= 12)) {
            return false;
        }
        if (!(dia >= 1 && dia <= 31)) {
            return false;
        }
        if (!(año >= 1)) {
            return false;
        }
        if (mes == 2) {
            if (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)) {
                if (dia > 29) {
                    return false;
                }
            } else if (dia > 28) {
                return false;
            }
        }
        return !((mes == 11 || mes == 9 || mes == 6 || mes == 4) && dia > 30);
    }

    public int diasMes() {
        if (mes == 2) {
            if (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if ((mes == 11 || mes == 9 || mes == 6 || mes == 4)) {
            return 30;
        } else {
            return 31;
        }
    }

    public String getString() {
        return dia + "/" + mes + "/" + año;
    }

    public String getFullString() throws Exception {
        String m = "";
        switch (this.mes) {
            case 1:
                m = "Enero";
                break;
            case 2:
                m = "Febrero";
                break;
            case 3:
                m = "Marzo";
                break;
            case 4:
                m = "Abril";
                break;
            case 5:
                m = "Mayo";
                break;
            case 6:
                m = "Junio";
                break;
            case 7:
                m = "Julio";
                break;
            case 8:
                m = "Agosto";
                break;
            case 9:
                m = "Septiembre";
                break;
            case 10:
                m = "Octubre";
                break;
            case 11:
                m = "Noviembre";
                break;
            case 12:
                m = "Diciembre";
                break;
        }
        String d = "Lunes";
        Fecha e11900 = new Fecha(1, 1, 1900);
        int diferenc = diferenciaDias(e11900);
        switch (diferenc % 7) {
            case 0:
                d = "Lunes";
                break;
            case 1:
                d = "Martes";
                break;
            case 2:
                d = "Miercoles";
                break;
            case 3:
                d = "Jueves";
                break;
            case 4:
                d = "Viernes";
                break;
            case 5:
                d = "Sabado";
                break;
            case 6:
                d = "Domingo";
                break;
        }
        return d + " " + this.dia + " de " + m + " de " + año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public void intercambio(Fecha fecha) throws Exception {
        Fecha tmp = new Fecha(fecha);
        fecha.set(this);
        set(tmp);
    }

    public static void intercambio(Fecha fecha1, Fecha fecha2) throws Exception {
        Fecha tmp = new Fecha(fecha2);
        fecha2.set(fecha1);
        fecha1.set(tmp);
    }

    public boolean mayor(Fecha Fecha) {
        if (año > Fecha.getAño()) {
            return true;
        }
        if (año < Fecha.getAño()) {
            return false;
        }
        if (mes > Fecha.getMes()) {
            return true;
        }
        if (mes < Fecha.getMes()) {
            return false;
        }
        return dia > Fecha.getDia();
    }

    public int diferenciaDias(Fecha Fecha) throws Exception {
        Fecha n = new Fecha(Fecha);
        int contador = 0;
        if (mayor(Fecha)) {
            while (n.getString().compareTo(getString()) != 0) {
                n.añadirDia();
                contador++;
            }
        } else {
            while (n.getString().compareTo(getString()) != 0) {
                n.restarDia();
                contador++;
            }
        }
        return contador;
    }

    public int diferenciaMes(Fecha Fecha) throws Exception {
        Fecha n = new Fecha(Fecha);
        int c = 0;
        if (mayor(Fecha)) {
            while (n.getString().compareTo(getString()) != 0) {
                if (EsCorrecta(n.getDia() + 1, n.getMes(), n.getAño())) {
                    n.set(n.getDia() + 1, n.getMes(), n.getAño());
                } else if (EsCorrecta(1, n.getMes() + 1, n.getAño())) {
                    n.set(1, n.getMes() + 1, n.getAño());
                    c++;
                } else {
                    n.set(1, 1, n.getAño() + 1);
                }
            }
        } else {
            while (n.getString().compareTo(getString()) != 0) {
                if (EsCorrecta(n.getDia() - 1, n.getMes(), n.getAño())) {
                    n.set(n.getDia() - 1, n.getMes(), n.getAño());
                } else if (EsCorrecta(31, n.getMes() - 1, n.getAño())) {
                    n.set(31, n.getMes() - 1, n.getAño());
                    c++;
                } else if (EsCorrecta(30, n.getMes() - 1, n.getAño())) {
                    n.set(30, n.getMes() - 1, n.getAño());
                    c++;
                } else if (EsCorrecta(29, n.getMes() - 1, n.getAño())) {
                    n.set(29, n.getMes() - 1, n.getAño());
                    c++;
                } else if (EsCorrecta(28, n.getMes() - 1, n.getAño())) {
                    n.set(28, n.getMes() - 1, n.getAño());
                    c++;
                } else {
                    n.set(31, 12, n.getAño() - 1);
                }
            }
        }
        return c;
    }
    
    public int diferenciaAño(Fecha Fecha) throws Exception {
        Fecha f1 = new Fecha(this);
        Fecha f2 = new Fecha(Fecha);
        if(f1.mayor(f2))
        {
            f2.intercambio(f1);
        }
        int ai=f1.getAño(), af = f2.getAño();
        int mi=f1.getMes(), mf = f2.getMes();
        int di=f1.getDia(), df = f2.getDia();
        int dif = af - ai;
        if (mi>mf)
            return dif -1;
        if (mi<mf)
            return dif;
        if (di>df)
            return dif -1;
        return dif;
    }

    public void añadirDias(int dias) {
        for (int i = 0; i < dias; i++) {
            añadirDia();
        }
    }

    public static String Calendario(Fecha Fech) throws Exception {
        String Calendario = "Lu\tMa\tMi\tJu\tVi\tSa\tDo\r\n";
        Fecha tmp = new Fecha(1, Fech.getMes(), Fech.getAño());
        Fecha e11900 = new Fecha(1, 1, 1900);
        int contador = 0;
        if (e11900.mayor(tmp)) {
            while (!tmp.getString().equals(e11900.getString())) {
                tmp.añadirDia();
                contador++;
            }
        } else {
            while (!tmp.getString().equals(e11900.getString())) {
                tmp.restarDia();
                contador++;
            }
        }
        int dsemana = contador % 7;
        for (int i = 0; i < dsemana; i++) {
            Calendario += "\t";
        }
        for (int i = 1; i <= Fech.diasMes(); i++) {
            dsemana++;
            Calendario += i;
            if (dsemana < 7) {
                Calendario += "\t";
            } else {
                Calendario += "\r\n";
                dsemana = 0;
            }
        }
        return Calendario;
    }

    public void restarDias(int dias) {
        for (int i = 0; i < dias; i++) {
            restarDia();
        }
    }

    private void restarDia() {
        if (EsCorrecta(dia - 1, mes, año)) {
            dia--;
        } else if (EsCorrecta(31, mes - 1, año)) {
            dia = 31;
            mes--;
        } else if (EsCorrecta(30, mes - 1, año)) {
            dia = 30;
            mes--;
        } else if (EsCorrecta(29, mes - 1, año)) {
            dia = 29;
            mes--;
        } else if (EsCorrecta(28, mes - 1, año)) {
            dia = 28;
            mes--;
        } else {
            dia = 31;
            mes = 12;
            año--;
        }
    }

    private void añadirDia() {
        if (EsCorrecta(dia + 1, mes, año)) {
            dia++;
        } else if (EsCorrecta(1, mes + 1, año)) {
            dia = 1;
            mes++;
        } else {
            dia = 1;
            mes = 1;
            año++;
        }
    }
}
