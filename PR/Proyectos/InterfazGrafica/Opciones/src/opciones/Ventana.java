package opciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;

/**
 * @author yo
 */
public class Ventana extends JFrame implements ActionListener {
    //Atributos
    private Datos datos;
    private JComboBox paisCb, ciudadCb;
    
    
    //Constructor
    public Ventana(Datos datos){
        this.datos= datos;
        //Instanciamos Componentes
        paisCb = new JComboBox(datos.damePais());
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
        for(String ciudad: datos.dameCiudades(pais))
            ciudadCb.addItem(ciudad);
        
        //Metodo 2
        //ciudadCb.setModel(new DefaultComboBoxModel(datos.dameCiudades(pais)));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.actualizaCiudad((String)paisCb.getSelectedItem());
    }    
    
}
