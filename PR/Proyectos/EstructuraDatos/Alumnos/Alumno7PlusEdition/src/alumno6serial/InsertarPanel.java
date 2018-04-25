package alumno6serial;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author yo
 */
public class InsertarPanel /*extends JDialog*/ implements ActionListener{
    //Atributos
    private JFrame padre;
    private Alumno hijo;
    //private Exception suegra;
    private JDialog ventanita;
    private MatriculaPanel matriculaPn;
    private JPanel content;
    private JLabel text1, text2, text3;
    private JTextField nombre, fechaNaci, curso;
    private JButton save, volver;
    
    private boolean estadoTexto;
    
    //Constructor
    public InsertarPanel(JFrame padre){
        this.padre = padre;
        init();
    }
    
    private void init(){
        
        //Instanciamos Componentes
        ventanita = new JDialog(padre, true);
        content = new JPanel();
        text1 = new JLabel("Nombre: ");
        text2 = new JLabel("Fecha Nacimiento: ");
        text3 = new JLabel("Curso: ");
        nombre = new JTextField();
        fechaNaci = new JTextField();
        curso = new JTextField();
        save = new JButton("Guardar");
        volver = new JButton("Volver");
        matriculaPn = new MatriculaPanel(Alumno.Asignaturas, false);
        
        //Configuramos Componenetes
        //- Posicionamiento
        text1.setBounds(10, 70, 100, 20);
        text2.setBounds(10, 110, 130, 20);
        text3.setBounds(10, 150, 100, 20);
        nombre.setBounds(150, 70, 100, 20);
        fechaNaci.setBounds(150, 110, 100, 20);
        curso.setBounds(150, 150, 100, 20);
        save.setBounds(10, 200, 100, 20);
        volver.setBounds(150, 200, 100, 20);
        matriculaPn.setBounds(290, 10, 250, 300);
        
        //- Situacion de los Componentes
        save.setEnabled(false);
        estadoTexto = false;
        
        //Creamos panel de objetos
        content.setLayout(null);
        ventanita.setContentPane(content);
        ventanita.setSize(580, 350);
        ventanita.setBackground(Color.white);
        ventanita.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Añadimos componentes
        content.add(text1);
        content.add(text2);
        content.add(text3);
        content.add(nombre);
        content.add(fechaNaci);
        content.add(curso);
        content.add(save);
        content.add(volver);
        content.add(matriculaPn);
        ventanita.setContentPane(content);
        
        //Nos Ponemos a escuchar
        KeyAdapter siPulsa = new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                estadoTexto = true;
                save.setEnabled(true);
            }
        };
        
        nombre.addKeyListener(siPulsa);
        fechaNaci.addKeyListener(siPulsa);
        curso.addKeyListener(siPulsa);
        save.addActionListener(this);
        
        volver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Y nos Vamos");
                ventanita.setVisible(false);
                limpiaPanel();
            }
        });
        
        ventanita.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("No nos quieren por aki :'( ");
                ventanita.setVisible(false);
                limpiaPanel();
            }
        });
        
        //Y hacemos visible
        //this.setVisible(true); // era broma :)
        
    }
    
    //Metodos
    public void limpiaPanel(){
        nombre.setText("");
        fechaNaci.setText("");
        curso.setText("");
        save.setEnabled(false);
    }
    
    public Alumno insertarAlumnoNuevo(){
        ventanita.setVisible(true);
        return hijo;
    }
    
    public Alumno modificarAlumno(Alumno al1){
        nombre.setText(al1.getNombre());
        fechaNaci.setText(al1.getFechaNaciToString());
        curso.setText(""+al1.getCurso());
        ventanita.setVisible(true);
        return hijo;
    }
    
    public void setTitle(String title){
        ventanita.setTitle(title);
    }
    
    public void setGuardarNombre(String title){
        save.setText(title);
    }
    
    //Control de Eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Vamos a Guardar :)");
        try{
            String nom="", fecha = fechaNaci.getText();
            //Compruebo Nombre
            if(this.nombre.getText().compareTo("")!=0){
                nom= this.nombre.getText();
                nombre.setBackground(Color.white);
            }else
                throw new Exception(){
                    @Override
                    public String toString(){
                        return "nombre en blanco";
                    }
                };
            //Compruebo la fecha
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaL = LocalDate.parse(fecha,fmt);
            if(fechaL == null)
                throw new java.time.format.DateTimeParseException("Error no se Admite espacios en blanco","No se admite nulo",0);
            fechaNaci.setBackground(Color.white);
            
            //Compurebo el curso
            int curs = Integer.parseInt(curso.getText());
            curso.setBackground(Color.white);

            //Compruebo las asignturas matriculadas
            ArrayList <AsigNota> nota = matriculaPn.leerAsiganturas();

            //ArreFinikitao lo creo e inserto
            Alumno al1 = new Alumno(nom, fechaL, curs, nota);
            hijo = al1;

            save.setEnabled(false);
            ventanita.setVisible(false);
            limpiaPanel();
            
        }catch(java.lang.NumberFormatException en){
            System.err.println("Error al Introducir Curso");
            curso.setBackground(Color.RED);
        }catch(java.time.format.DateTimeParseException ed){
            System.err.println("Error al introducir la Fecha");
            fechaNaci.setBackground(Color.RED);
        }catch(Exception ex){
            System.err.println(""+ex);
            if(ex.toString().compareToIgnoreCase("nombre en blanco")==0)
                nombre.setBackground(Color.RED);
            else
                matriculaPn.setBackground(Color.red);
        }
    }
    
    
}
