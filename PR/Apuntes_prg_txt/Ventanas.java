//-- -- Pasos para crear una ventana -- --

//Importamos nuestras clases
import javax.swing.*;//:)

//Creamos nuestros atributos en la clase
private JFrame ventana;
private JDialog dialogo;
private JPanel panel;
private JButton boton;
private JLabel etiqueta;
private JTextField texto;
private JTextArea paEscribir;
private JComboBox comboOpciones;
private JRadioButton botonRadio;
private JCheckbox casillita;
private JOptionGroup agruparBotones;

//En Constructor de la clase o en algun metodo que se ejecute al principio
//Instanciamos Componentes
ventana = new JFrame("Titulo de la ventana");
dialogo = new JDialog(ventanaPadre, "Titulo del dialogo", true);//true si es modal y coje protagonismo :v
comboOpciones = new JComboBox(arrayOpciones);

// ... 800 news despues xd

//Configuramos componentes; es decir, su estado inicial y posicionamiento si fuera necesario
//Estado inicial
botonRadio.setSetlected(true); // -- Establecer a un boton de radio o checkbox la seleccion
boton.setEnabled(false); // habilitar componentes
texto.setEditable(false); // Se puede editar o no
paEscribir.setWrapStyleWord(true); // Hacen salto de linea sino caben
etiqueta.setText("Etiqueta");//Poner texto

//Configuramos ventana y/o paneles
// - Ponemos titulo
// - Tamaño, si queremos que pueda cambiar de tamaño
// - Especifiacamos Layout
// - Especificamos como debe cerrarse
// - Especificamos el panel de contenido

//Añadimos los componentes a donde sea necesario

//Nos ponemos a capurar eventos
boton.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		//Asemos lo ke sea
	}
});

ventana.addWindowListener(new WindowAdapter(){
    @Override
    public void windowClosing(WindowEvent e) {
        //Algo 
        System.exit(0);//Salimos sino le hemos puesto (do_nothing_on_closing)
    }
});


texto.addKeyListener(new KeyAdapter(){
    @Override
    public void keyPressed(KeyEvent e) {
        //Algo 
    }
});

//Ponemos la Ventana visible :) y apañao

// En caso de capturar los eventos con la propia clase no olvidarse de instancias las clases e implementar la  intefaz correspondiente :v

// Y con todo esto ya tenemos una bonita ventana :D<-<