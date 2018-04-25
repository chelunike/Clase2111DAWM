package mappaiscuidad;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.HashMap;

/**
 * @author yo
 */
public class Ventanal extends JFrame implements ActionListener {
    //Atributos
    private HashMap <String, String[]> mapa;
    private JComboBox paisCb, ciudadCb;
    
    
    //Constructor
    public Ventanal(HashMap <String, String[]> elMapa){
        //Recojemos los valores
        mapa = elMapa;
        
        //Instanciamos Componentes
        paisCb = new JComboBox(mapa.keySet().toArray(new String[0]));
        ciudadCb = new JComboBox(new String[0]);
        
        //Creamos un panel
        JPanel panel = new JPanel();
        
        //Configuramos nuestro Panel/Ventana y se lo añadimos
        panel.setBackground(Color.WHITE);
        this.setSize(300, 180);
        this.setDefaultCloseOperation(3);
        this.setContentPane(panel);
        
        //Añadimos Componentes
        panel.add(paisCb);
        panel.add(ciudadCb);
        
        //Insertamos Valores por defecto
        paisCb.setEditable(false);
        ciudadCb.setEditable(false);
        
        paisCb.setSelectedItem("España");
        this.actualizaCiudad("España");
        
        //Nos ponemos a escuchar
        paisCb.addActionListener(this);
        
        //Activamos el ventanal
        this.setVisible(true);
        
    }
    
    //Metodos
    public void actualizaCiudad(String pais){
        //Metodo 1
        ciudadCb.removeAllItems();
        for(String ciudad: mapa.get(pais))
            ciudadCb.addItem(ciudad);
        
        //Metodo 2
        //ciudadCb.setModel(new DefaultComboBoxModel((mapa.get(paisCb.getSelectedItem()))));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.actualizaCiudad((String)paisCb.getSelectedItem());
    }    
    
}
