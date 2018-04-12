package graficoprintable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
public class GraficoPrintable {
    public static void main(String[] args) {
      PrinterJob job = PrinterJob.getPrinterJob();
      job.setPrintable(new Calendario(2020, 5, 25, 
                                      2020, 12, 25));
      if (job.printDialog())
      {
         try { 
             job.print(); 
         } catch (PrinterException e) { 
             System.out.println("Error de impresión: " + e); 
         }
      }
    }
    
}
