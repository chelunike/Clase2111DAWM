package alumno6serial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author yo
 */
public class Ventanuco extends JFrame implements ActionListener {
    
    //Atributos
    private Contenedor listaAlumnos;
    private int cursoSelect;
    private int select;
    //pirates int carive;
    private JRadioButton isPrimero;
    private JRadioButton isSegundo;
    private ButtonGroup cursoRg;
    private JLabel text1, text2, text3;
    private JTextField nombre, fechaNaci, curso;
    private JButton anterior, siguiente, insert;
    
    private JButton notasBt;
    private JButton guardarNotasBt;
    private JPanel notasPn;
    private JLabel asigLb, notaLb;
    
    private JLabel ordenLb;
    private JRadioButton orNombreRb, orFechaRb;
    private ButtonGroup ordenRg;
    
    private MatriculaPanel matriculaPn;
    private JButton matriculaBt;
    
    private InsertarPanel insertarPn;//Nuevo
    
    //Constructor
    public Ventanuco(Contenedor cont){
        //Declaramos Contenedores
        listaAlumnos = cont;
        init();
    }
    
    private void init(){
        //Declaramos Componentes/Atributos
        isPrimero = new JRadioButton("Primero");
        isSegundo = new JRadioButton("Segundo");
        cursoRg = new ButtonGroup();
        
        text1 = new JLabel("Nombre: ");
        text2 = new JLabel("Fecha Nacimiento: ");
        text3 = new JLabel("Curso: ");
        nombre = new JTextField();
        fechaNaci = new JTextField();
        curso = new JTextField();
        anterior = new JButton("Anterior");
        siguiente = new JButton("Siguiente");
        insert = new JButton("Insertar");
        
        notasBt = new JButton("Ver Notas");
        guardarNotasBt = new JButton("Guardar");
        notasPn = new JPanel(null);
        asigLb = new JLabel("Asignaturas ");
        notaLb = new JLabel("Notas");
        
        ordenLb = new JLabel("Ordena por: ");
        orNombreRb = new JRadioButton(" Nombre ");
        orFechaRb = new JRadioButton(" Fecha de Nacimiento ");
        ordenRg = new ButtonGroup();
        
        matriculaPn = new MatriculaPanel(Alumno.Asignaturas, true);
        matriculaBt = new JButton("Asignaturas");
        
        insertarPn = new InsertarPanel(this);//Nuevo
        
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
        
        notasBt.setBounds(20, 290, 100, 20);
        notasPn.setBounds(300, 20, 250, 300);
        guardarNotasBt.setBounds(75, 5, 100, 20);
        asigLb.setBounds(13, 30, 100, 20);
        notaLb.setBounds(126, 30, 100, 20);
        
        ordenLb.setBounds(20, 320, 100, 20);
        orNombreRb.setBounds(40, 350, 100, 20);
        orFechaRb.setBounds(40, 380, 150, 20);
        
        matriculaPn.setBounds(300, 20, 250, 300);
        matriculaBt.setBounds(170, 290, 100, 20);
        
        //Situacion
        isPrimero.setSelected(true);
        cursoRg.add(isPrimero);
        cursoRg.add(isSegundo);
        
        nombre.setEditable(false);
        fechaNaci.setEditable(false);
        curso.setEditable(false);
        
        notasPn.setBackground(Color.white);
        notasPn.setVisible(false);
        
        ordenRg.add(orNombreRb);
        ordenRg.add(orFechaRb); 
        orNombreRb.setSelected(true);
        
        matriculaPn.setVisible(false);
        
        //Creamos panel de objetos
        JPanel content = new JPanel();
        content.setLayout(null);
        this.setContentPane(content);
        this.setSize(600, 450);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
        
        content.add(notasBt);
        content.add(notasPn);
        notasPn.add(guardarNotasBt);
        notasPn.add(asigLb);
        notasPn.add(notaLb);
        
        content.add(ordenLb);
        content.add(orNombreRb);
        content.add(orFechaRb);
        
        content.add(matriculaPn);
        content.add(matriculaBt);
        
        //Nos ponemos a escuchar musica
        ActionListener radio = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(isPrimero) ){
                    cursoSelect = 1;
                }else if(e.getSource().equals(isSegundo) ){
                    cursoSelect = 2;
                }
            }
        };
        
        isPrimero.addActionListener(radio);
        isSegundo.addActionListener(radio);
        
        anterior.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(select >0){
                    Alumno al1 = (Alumno)listaAlumnos.getPersona(select-1);
                    select--;
                    if(al1.getCurso() == cursoSelect){
                        escribeAlumno(select);
                    }else
                        this.actionPerformed(e);
                }
            }
        });
        
        siguiente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(select < listaAlumnos.size()-1){
                    Alumno al1 = (Alumno)listaAlumnos.getPersona(select+1);
                    select++;
                    if(al1.getCurso() == cursoSelect){
                        escribeAlumno(select);
                    }else
                        this.actionPerformed(e);
                }
            }
        });
        
        insert.addActionListener(this);
        
        notasBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(notasPn.isVisible()){
                    notasPn.setVisible(false);
                    //limpiaAsigNota();
                    notasBt.setText("Ver Notas");
                    anterior.setEnabled(true);
                    siguiente.setEnabled(true);
                    insert.setEnabled(true);
                    matriculaBt.setEnabled(true);
                    guardarNotasBt.setText("Guardar");
                    guardarNotasBt.setEnabled(true);
                }else{
                    limpiaAsigNota();
                    escribeAsigNota();
                    //escribeNotas(select);
                    notasPn.setVisible(true);
                    notasBt.setText("Volver");
                    //Desabilitamos el resto
                    anterior.setEnabled(false);
                    siguiente.setEnabled(false);
                    insert.setEnabled(false);
                    matriculaBt.setEnabled(false);
                }
            }
        });
        
        guardarNotasBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sacamos el alumno
                guardarNotasBt.setText("Guardado");
                guardarNotasBt.setEnabled(false);
                Alumno al1 = (Alumno)listaAlumnos.getPersona(select);
                ArrayList <AsigNota> notas = leerNotas();
                if(notas != null)
                    al1.setNotas(notas);
            }
        });
        
        matriculaPn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumno al1 = (Alumno)listaAlumnos.getPersona(select);
                al1.setNotas(matriculaPn.leerAsiganturas());
            }
            
        });
        
        matriculaBt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(matriculaPn.isVisible()){
                    matriculaPn.setVisible(false);
                    matriculaPn.limpiaMatricula();
                    //limpiaAsigNota();
                    matriculaBt.setText("Asignaturas");
                    anterior.setEnabled(true);
                    siguiente.setEnabled(true);
                    insert.setEnabled(true);
                    notasBt.setEnabled(true);
                    //guardarNotasBt.setText("Guardar");
                    //guardarNotasBt.setEnabled(true);
                }else{
                    matriculaPn.limpiaMatricula();
                    matriculaPn.escribeMatricula((Alumno)listaAlumnos.getPersona(select));
                    //escribeNotas(select);
                    matriculaPn.setVisible(true);
                    matriculaBt.setText("Volver");
                    //Desabilitamos el resto
                    anterior.setEnabled(false);
                    siguiente.setEnabled(false);
                    insert.setEnabled(false);
                    notasBt.setEnabled(false);
                }
            }
        });
        
        orNombreRb.addActionListener(new ordenEvent());
        orFechaRb.addActionListener(new ordenEvent());
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("\n -- Adios con el corazon y que tenga un buen dia --\n\t:)/\n\t/|\n\t |\n\t/ \\");
                EstudIO.serializa(listaAlumnos, "alumnos.info");
                System.exit(0);
            }
        });
        
        
        if(listaAlumnos.size() > 0){
            select = 0;
            escribeAlumno(select);
        }
        cursoSelect = 1;
        listaAlumnos.ordenaPorNombre();
        this.escribeAsigNota();
        
        //Ponemos en marcha la ventana
        this.setVisible(true);
    }
    
    //Metodos
    public Contenedor getContenedor(){
        return listaAlumnos;
    }
    
    public void escribeAlumno(int index){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if(listaAlumnos.getPersona(index).getNombre() != null)
            nombre.setText(listaAlumnos.getPersona(index).getNombre());
        if(listaAlumnos.getPersona(index).getFechaNaci() != null)
            fechaNaci.setText(listaAlumnos.getPersona(index).getFechaNaci().format(fmt));
        curso.setText(""+((Alumno)listaAlumnos.getPersona(index)).getCurso()+"º");
    }
    
    public void escribeNotas(int index){
        //Cojemos los componentes
        int numComp = notasPn.getComponentCount();
        Component[] componente = notasPn.getComponents();
        //Sacamos el alumno y con el las notas
        Alumno al1 = (Alumno)listaAlumnos.getPersona(index);
        ArrayList <AsigNota> notas = al1.getNotas();
        if(notas != null)
            for(int i=3; i<numComp; i+=2){
                JTextField nomAsig = (JTextField)componente[i];
                nomAsig.setText(notas.get((i-3)/2).getAsig());
                JTextField nomNota = (JTextField)componente[i+1];
                nomNota.setText(""+notas.get((i-3)/2).getNota());
            }
        else
            this.limpiaNotas();
    }
    
    
    public ArrayList <AsigNota> leerNotas(){
        //Cojemos los componentes
        int numComp = notasPn.getComponentCount();
        Component[] componente = notasPn.getComponents();
        ArrayList <AsigNota> notas = new ArrayList();
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
                notas.add(a);
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
    
    public void escribeAsigNota(){
        Alumno al1 = (Alumno)listaAlumnos.getPersona(select);
        int lon=0;
        ArrayList <AsigNota> notas;
        if(al1.getNotas() != null){
            lon = al1.getNotas().size();
            notas = al1.getNotas();
        }else{
            lon = 5;
            notas = null;
        }
        int i=0;
        for(AsigNota a:al1.getNotas()){
            JTextField tmp = new JTextField(a.getAsig()==null?"":a.getAsig());
            tmp.setHorizontalAlignment(0);
            tmp.setBackground(Color.lightGray);
            tmp.setBounds( 13, 30*i+50, 100, 20);
            notasPn.add(tmp);
            JTextField tmp2 = new JTextField(a==null?"":""+a.getNota());
            tmp2.setHorizontalAlignment(0);
            tmp2.setBackground(Color.lightGray);
            tmp2.setBounds( 126, 30*i+50, 100, 20);
            notasPn.add(tmp2); 
            i++;
        }
    }
    
    public void actualizaAlumno(){
        for(int i=0; i<listaAlumnos.size(); i++){
            Alumno al1 = (Alumno)listaAlumnos.getPersona(i);
            if(al1.getCurso() == cursoSelect){
                this.escribeAlumno(i);
                select = i;
                i = listaAlumnos.size();
            }
        }      
    }
    
    //Nos Ocupamos de los Botones
    @Override
    public void actionPerformed(ActionEvent e) {
        Alumno al1 = insertarPn.insertarAlumnoNuevo();
        System.out.println("Arre cojio er nuevo Alumno :) ");
        listaAlumnos.insertarPersona(al1);
    }
    
    private class ordenEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(orNombreRb)){
                listaAlumnos.ordenaPorNombre();
                actualizaAlumno();
            }else{
                listaAlumnos.ordenaPorFechaNacimiento();
                actualizaAlumno();
            }        
        }
    }    
    
}