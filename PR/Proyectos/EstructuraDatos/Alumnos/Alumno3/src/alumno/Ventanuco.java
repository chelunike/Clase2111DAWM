package alumno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.NumberFormatException;

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
    private JButton guardarNotasBt;
    private JPanel notasPn;
    private JLabel asigLb, notaLb;
    
    
    //Constructor
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
        guardarNotasBt = new JButton("Guardar");
        notasPn = new JPanel(null);
        asigLb = new JLabel("Asignaturas ");
        notaLb = new JLabel("Notas");
        
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
        guardarNotasBt.setBounds(75, 5, 100, 20);
        asigLb.setBounds(13, 30, 100, 20);
        notaLb.setBounds(126, 30, 100, 20);
        
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
        notasPn.add(guardarNotasBt);
        notasPn.add(asigLb);
        notasPn.add(notaLb);

        
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
                if(select < tmp.size()-1){
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
                    anterior.setEnabled(true);
                    siguiente.setEnabled(true);
                    insert.setEnabled(true);
                    guardarNotasBt.setText("Guardar");
                    guardarNotasBt.setEnabled(true);
                }else{
                    escribeNotas(select);
                    notasPn.setVisible(true);
                    notasBt.setText("Volver");
                    //Desabilitamos el resto
                    anterior.setEnabled(false);
                    siguiente.setEnabled(false);
                    insert.setEnabled(false);
                }
            }
        });
        
        guardarNotasBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sacamos el alumno
                guardarNotasBt.setText("Guardado");
                guardarNotasBt.setEnabled(false);
                Alumno al1 = (Alumno)lista1.getPersona(select);
                AsigNota[] notas = leerNotas();
                if(notas != null)
                    al1.setNotas(notas);
            }
        });
        
        if(tmp.size() > 0){
            select = 0;
            escribeAlumno(select);
        }
        
        Alumno al1 = (Alumno)lista1.getPersona(select);
        for(int i=0; i<al1.getNotas().length; i++){
            AsigNota[] nota = al1.getNotas();
            JTextField tmp = new JTextField(nota[i].getAsig());
            tmp.setHorizontalAlignment(0);
            tmp.setBackground(Color.lightGray);
            tmp.setBounds( 13, 30*i+50, 100, 20);
            notasPn.add(tmp);
            JTextField tmp2 = new JTextField(""+nota[i].getNota());
            tmp2.setHorizontalAlignment(0);
            tmp2.setBackground(Color.lightGray);
            tmp2.setBounds( 126, 30*i+50, 100, 20);
            notasPn.add(tmp2);
            
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
    
    public void escribeNotas(int index){
        //Cojemos los componentes
        int numComp = notasPn.getComponentCount();
        Component[] componente = notasPn.getComponents();
        //Sacamos el alumno y con el las notas
        Alumno al1 = (Alumno)lista1.getPersona(index);
        AsigNota[] notas = al1.getNotas();
        if(notas[0] != null)
            for(int i=3; i<numComp; i+=2){
                JTextField nomAsig = (JTextField)componente[i];
                nomAsig.setText(notas[(i-3)/2].getAsig());
                JTextField nomNota = (JTextField)componente[i+1];
                nomNota.setText(""+notas[(i-3)/2].getNota());
            }
        else
            this.limpiaNotas();
        
    }
    
    
    public AsigNota[] leerNotas(){
        //Cojemos los componentes
        int numComp = notasPn.getComponentCount();
        Component[] componente = notasPn.getComponents();
        AsigNota[] notas = new AsigNota[numComp-3];
        for(int i=3; i<numComp; i+=2){
            JTextField nomAsig = (JTextField)componente[i];
            JTextField nomNota = (JTextField)componente[i+1];
            Color ant = nomAsig.getBackground();
            try{
                //sacamos el nombre de la asinatura
                String asig = nomAsig.getText();
                
                nomAsig.setBackground(ant);
                // Sacamos y comprobamos nuestra nota
                double nota = Double.parseDouble(nomNota.getText());
                if(nota<0 || nota >10)
                    throw new NumberFormatException("Fuera de Rango");
                nomNota.setBackground(ant);
                //Creamos nuestro AsigNota
                AsigNota a = new AsigNota(asig, nota);
                notas[(i-3)/2] = a;
            }catch(java.lang.NumberFormatException n){
                nomNota.setBackground(Color.red);
                guardarNotasBt.setText("Guardar");
                guardarNotasBt.setEnabled(true);
            }catch(Exception e){
                System.err.println("Erro inesperado: "+e);
                guardarNotasBt.setText("Guardar");
                guardarNotasBt.setEnabled(true);
            }
        }
        //java.lang.NumberFormatException
        return notas;
    }
    
    public void limpiaNotas(){
        //Cojemos los componentes
        int numComp = notasPn.getComponentCount();
        Component[] componente = notasPn.getComponents();
        for(int i=3; i<numComp; i++){
            JTextField tmp = (JTextField)componente[i];
            tmp.setText("");
        }
    }
    
    public void limpiaAsigNota(){
        int numCom = notasPn.getComponentCount();
        Component[] componente = notasPn.getComponents();
        if(numCom > 3)
            for(int i=3; i<numCom; i++){
                notasPn.remove(componente[i]);
            }
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
            notasBt.setEnabled(false);
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
                if(fechaL == null)
                    throw new java.time.format.DateTimeParseException("Error no se Admite espacios en blanco","No se admite nulo",0);
                fechaNaci.setBackground(Color.white);
                //Compurebo el curso
                int curs = Integer.parseInt(curso.getText());
                curso.setBackground(Color.white);
                //ArreFinikitao lo creo e inserto
                Alumno al1 = new Alumno(nom, fechaL, curs);
                tmp.insertarPersona(al1);
                    
                nombre.setEditable(false);
                fechaNaci.setEditable(false);
                curso.setEditable(false);
                insert.setEnabled(true);
                anterior.setEnabled(true);
                siguiente.setEnabled(true);
                save.setEnabled(false);
                isPrimero.setEnabled(true);
                //pollas
                isSegundo.setEnabled(true);
                notasBt.setEnabled(true);
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
