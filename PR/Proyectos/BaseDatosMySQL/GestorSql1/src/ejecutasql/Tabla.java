package ejecutasql;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author yo
 */
public class Tabla {
    //Atributos 
    private JTable tabla;
    private DefaultTableModel modelo; 
    private TableModelListener eventos;
    
    //Constructores
    public Tabla(){
        modelo = new DefaultTableModel();
        tabla = new JTable();
    }
    
    public Tabla(String[] cabecera, String[][] datos){
        modelo = new DefaultTableModel(datos, cabecera);
        tabla = new JTable(modelo);
    }
    
    private void initTabla(){
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        modelo.addTableModelListener(eventos);
        tabla.setModel(modelo);
    }
    
    //Metodos
    public JTable getTabla(){
        return tabla;
    }
    
    public boolean rentablaLaTabla(String[] cabecera, String[][] datos){
        boolean s = true;
        try{
            /*
            int l = modelo.getRowCount();
            for(int n:new int[l])
                modelo.removeRow(n);
            modelo.addRow(cabecera);
            for(int i=0; i<datos.length; i++)
                modelo.addRow(datos[i]);
            */
            modelo = new DefaultTableModel(datos, cabecera);
            initTabla();
        }catch(Exception e){
            s = false;
        }
        return s;
    }
    
    
    public void setTableChangeListener(TableModelListener oido){
        eventos = oido;
        initTabla();
    }
}
