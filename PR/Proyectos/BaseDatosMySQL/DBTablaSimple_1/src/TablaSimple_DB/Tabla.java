package TablaSimple_DB;

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
    
    //Constructores
    public Tabla(){
        modelo = new DefaultTableModel();
        tabla = new JTable();
    }
    
    public Tabla(String[] cabecera, String[][] datos){
        modelo = new DefaultTableModel(datos, cabecera);
        tabla = new JTable(modelo);
    }
    
    //Metodos
    public JTable getTabla(){
        return tabla;
    }
    
    public boolean rentablaLaTabla(String[] cabecera, String[][] datos){
        boolean s = true;
        try{
            
            
        }catch(Exception e){
            s = false;
        }
        return s;
    }
    
    
    public void setTableChangeListener(TableModelListener oido){
        modelo.addTableModelListener(oido);
    }
}
