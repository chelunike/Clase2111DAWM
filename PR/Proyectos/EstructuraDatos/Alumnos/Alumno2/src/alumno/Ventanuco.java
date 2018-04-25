package alumno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author yo
 */
public class Ventanuco extends JFrame implements ActionListener {
    
    //Atributos
    private Contenedor lista1;
    private Contenedor lista2;
    private Contenedor tmp;
    private int select;
    //pirates int carive;
    private JRadioButton isPrimero;
    private JRadioButton isSegundo;
    private JLabel text1, text2, text3;
    private JTextField nombre, fechaNaci, curso;
    private JButton anterior, siguiente, insert, save;
    private JTextArea log;
    
    private JButton notasBt;
    private JPanel notasPn;
    
    //Constructores
    public Ventanuco(Contenedor cont1, Contenedor cont2){
        //Declaramos Contenedores
        lista1 = cont1;
        lista2 = cont2;
        tmp = lista1;
        
        //Declaramos Componentes/Atributos
        isPrimero = new JRadioButton("Primero");
        isSegundo = new JRadioButton("Segundo");
        text1 = new JLabel("Nombre: ");
        text2 = new JLabel("Fecha Nacimiento: ");
        text3 = new JLabel("Curso: ");
        nombre = new JTextField();
        fechaNaci = new JTextField();
        curso = new JTextField();
        anterior = new JButton("Anterior");
        siguiente = new JButton("Siguiente");
        insert = new JButton("Insertar");
        save = new JButton("Guardar");
        log = new JTextArea();
        
        notasBt = new JButton("Ver Notas");
        notasPn = new JPanel();
        
        //Configuramos Componentes
        //Posicion
        isPrimero.setBounds(20, 20, 100, 20);
        isSegundo.setBounds(170, 20, 100, 20);
        text1.setBounds(20, 70, 100, 20);
        text2.setBounds(20, 110, 130, 20);
        text3.setBounds(20, 150, 100, 20);
        nombre.setBounds(170, 70, 100, 20);
        fechaNaci.setBounds(170, 110, 100, 20);
        curso.setBounds(170, 150, 100, 20);
        anterior.setBounds(20, 210, 100, 20);
        siguiente.setBounds(170, 210, 100, 20);
        insert.setBounds(20, 250, 100, 20);
        save.setBounds(170, 250, 100, 20);
        
        notasBt.setBounds(95, 300, 100, 20);
        notasPn.setBounds(300, 20, 250, 300);
        
        //Situacion
        isPrimero.setSelected(true);
        isSegundo.setSelected(false);
        
        nombre.setEditable(false);
        fechaNaci.setEditable(false);
        curso.setEditable(false);
        
        save.setEnabled(false);
        
        notasPn.setBackground(Color.white);
        notasPn.setVisible(false);
        
        //Creamos panel de objetos
        JPanel content = new JPanel();
        content.setLayout(null);
        this.setContentPane(content);
        this.setSize(600, 360);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aplicacion de Cursos :)");
        
        //Insertamos Componentes
        content.add(isPrimero);
        content.add(isSegundo);
        content.add(text1);
        content.add(text2);
        content.add(text3);
        content.add(nombre);
        content.add(fechaNaci);
        content.add(curso);
        content.add(anterior);
        content.add(siguiente);
        content.add(insert);
        content.add(save);
        
        content.add(notasBt);
        content.add(notasPn);
        
        //Nos ponemos a escuchar musica
        ActionListener radio = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(isPrimero) && isPrimero.isSelected()){
                    System.out.println("Pulsado Primero ");
                    isPrimero.setSelected(true);
                    isSegundo.setSelected(false);
                    lista2 = tmp;
                    tmp = lista1;
                    //Seleccionar Elemento
                }else if(e.getSource().equals(isSegundo) && isSegundo.isSelected()){
                    System.out.println("Pulsado segundo");
                    isPrimero.setSelected(false);
                    isSegundo.setSelected(true);
                    lista1 = tmp;
                    tmp = lista2;
                }
            } 
        };
        
        isPrimero.addActionListener(radio);
        isSegundo.addActionListener(radio);
        
        anterior.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(select >0){
                    escribeAlumno(select-1);
                    select--;
                }else
                    escribeAlumno(select);
            }
        });
        
        siguiente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(select < tmp.size()){
                    escribeAlumno(select+1);
                    select++;
                }else
                    escribeAlumno(select);
            }
        });
        
        insert.addActionListener(this);
        save.addActionListener(this);
        
        notasBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(notasPn.isVisible()){
                    notasPn.setVisible(false);
                    notasBt.setText("Ver Notas");
                }else{
                    notasPn.setVisible(true);
                    notasBt.setText("Volver");
                }
            }
        });
        
        
        
        if(tmp.size() > 0){
            select = 0;
            escribeAlumno(select);
        }
        //Ponemos en marcha la ventana
        this.setVisible(true);
        
        
    }
    
    //Metodos
    
    public void escribeAlumno(int index){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if(tmp.getPersona(index).getNombre() != null)
            nombre.setText(tmp.getPersona(index).getNombre());
        if(tmp.getPersona(index).getFechaNaci() != null)
            fechaNaci.setText(tmp.getPersona(index).getFechaNaci().format(fmt));
        curso.setText(""+((Alumno)tmp.getPersona(index)).getCurso()+"º");
    }
    
    
    //Nos Ocupamos de los Botones
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Insert / save");
        if(e.getSource().equals(insert)){
            nombre.setEditable(true);
            fechaNaci.setEditable(true);
            curso.setEditable(true);
            insert.setEnabled(false);
            anterior.setEnabled(false);
            siguiente.setEnabled(false);
            save.setEnabled(true);
            isPrimero.setEnabled(false);
            isSegundo.setEnabled(false);
        }else if(e.getSource().equals(save)){
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
                            return "Error no se admite nombre en blanco";
                        }
                    };
                //Compruebo la fecha
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fechaL = LocalDate.parse(fecha,fmt);
                if(fecha == null)
                    throw new java.time.format.DateTimeParseException("Error no se Admite espacios en blanco","No se admite nulo",0);
                fechaNaci.setBackground(Color.white);
                //Compurebo el curso
                int curs = Integer.parseInt(curso.getText());
                curso.setBackground(Color.white);
                //ArreFinikitao lo creo e inserto
                Alumno al1 = new Alumno(nom, fecha, curs);
                tmp.insertarPersona(al1);
                    
                nombre.setEditable(false);
                fechaNaci.setEditable(false);
                curso.setEditable(false);
                insert.setEnabled(true);
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
                save.setEnabled(false);
                isPrimero.setEnabled(true);
                isSegundo.setEnabled(true);

            }catch(java.lang.NumberFormatException en){
                System.err.println("Error al Introducir Curso");
                curso.setBackground(Color.RED);
            }catch(java.time.format.DateTimeParseException ed){
                System.err.println("Error al introducir la Fecha");
                fechaNaci.setBackground(Color.RED);
            }catch(Exception ex){
                System.err.println(""+ex);
                nombre.setBackground(Color.RED);
            }finally{
                for(int i=0; i<tmp.size(); i++)
                    System.out.println(""+tmp.getPersona(i).getNombre());
            }
        }
        
        
        
    }
    
    
}
