package graficoprintable;
import java.awt.*;
import java.awt.print.*;
import java.time.LocalDate;

public class Calendario implements Printable {
    private static final String[] meses = {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN",
            "JUL", "AGO", "SET", "OCT", "NOV", "DIC"};
    private final LocalDate f1, f2;
    private LocalDate fx;
    private boolean abierto= false;
    private final int filas = 22;
    private final int columnas = 7;
    private final int altoLetra = 10;
    private final int margenIzq = 25;
    private final int margenDer = 10;
    private final int margenSup = 30;
    private final int margenInf = 40;
    //private final int filasTotal;
    private int anchoColumna, altoFila, x1, y1;
    private Graphics2D g2;
    public Calendario(int a1, int m1, int d1, int a2, int m2, int d2){
        f1 = LocalDate.of(a1, m1, d1);
        fx = LocalDate.of(a1, m1, d1);
        f2 = LocalDate.of(a2, m2, d2);
        //filasTotal= filasTotal();
    }
    private void dibujaTituloMesAgno(LocalDate f, int x, int y){
        g2.setColor(Color.WHITE);
        g2.drawLine(x1 + anchoColumna * x + 20, y1 + altoFila * y,
                x1 + anchoColumna * x + 75, y1 + altoFila * y);
        g2.setColor(Color.BLACK);
        g2.drawString(meses[f.getMonthValue()-1] + "/"
                + f.getYear(),
                x1 + anchoColumna * x + 20, y1 + altoFila * y + altoLetra / 2);
    }
    private void dibujaTrama(){
        g2.setColor(Color.BLACK);
        for (int y = 0; y <= filas; y++) {
            g2.drawLine(x1, y1 + altoFila * y,
                    x1 + anchoColumna * columnas, y1 + altoFila * y);
        }
        for (int x = 0; x <= columnas; x++) {
            g2.drawLine(x1 + anchoColumna * x, y1,
                    x1 + anchoColumna * x, y1 + altoFila * filas);
        }
    }
    private void dibujaDias(){
        LocalDate f= LocalDate.ofYearDay(fx.getYear(), fx.getDayOfYear());
        int x= f.getDayOfWeek().getValue()-1;
        for (int y = 0; y < filas && f.compareTo(f2)<=0; y++) {
            for (; x < columnas && f.compareTo(f2)<=0; x++) {
                int diaMes = f.getDayOfMonth();
                if (diaMes == 1) {
                    dibujaTituloMesAgno(f, x, y);
                }
                g2.drawString(String.format("%1$2d", diaMes),
                        x1 + anchoColumna * x + 2, 
                        y1 + altoFila * y + altoLetra);
                f=f.plusDays(1);
            }
            x= 0;
        }
        if (abierto) { // para evitar el primer pase (ejecuta dos veces)
            fx= LocalDate.ofYearDay(f.getYear(), f.getDayOfYear());
        }
        abierto= !abierto;
    }
    @Override
    public int print(Graphics g, PageFormat f, int pageIndex) {
        g2 = (Graphics2D) g;
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        int x0 = (int) f.getImageableX();
        int y0 = (int) f.getImageableY();
        int ancho0 = (int) f.getImageableWidth();
        int alto0 = (int) f.getImageableHeight();
        x1 = x0 + margenIzq;
        y1 = y0 + margenSup;
        altoFila = (int) (alto0 - margenSup - margenInf) / filas;
        anchoColumna = (int) (ancho0 - margenDer - margenIzq) / columnas;
        if (pageIndex == 0) {
            fx= LocalDate.ofYearDay(f1.getYear(), f1.getDayOfYear());
            dibujaTrama();
            dibujaTituloMesAgno(fx, 0, 0);
            dibujaDias();
            return PAGE_EXISTS;
        }
        if(fx.compareTo(f2)<=0) {
            dibujaTrama();
            dibujaTituloMesAgno(fx, 0, 0);
            dibujaDias();
            return PAGE_EXISTS; 
        }
        return NO_SUCH_PAGE;
    }
    /*
    private int calcularFilas(LocalDate fi, LocalDate ff){
        int c= 0;
        LocalDate f= LocalDate.ofYearDay(fi.getYear(), fi.getDayOfYear());
        for( ; f.compareTo(ff)<=0; f=f.plusDays(1))
            if (f.getDayOfWeek() == DayOfWeek.SUNDAY)
                c++;
        if (f.getDayOfWeek() != DayOfWeek.MONDAY)
            c++;
        return c;
        
    }
    private int filasTotal(){
        return calcularFilas(f1, f2);
    }
    private int filasMes(LocalDate l){
        LocalDate fi= LocalDate.of(l.getYear(), l.getMonth(), 1);
        LocalDate ff= LocalDate.of(l.getYear(), l.getMonth(), l.lengthOfMonth());
        return calcularFilas(fi, ff);
    }
    */
}
