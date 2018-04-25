package blocdenotas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class Editor {

    private JFrame form;

    private JButton bNuevo;
    private JButton bAbrir;
    private JButton bGuardar;
    private JButton bSalir;

    private JLabel lFichero;
    private JLabel lEstado;

    private JTextField tFichero;

    private JTextArea tContenedor;
    private JScrollPane jspElScrol;

    private boolean algunCambio;

    private final int tamañoBoton = 100;
    private final int tamañoXVentana = 1000;
    private final int tamañoYVentana = 500;

    public Editor() {
        InicializaVentana();
    }

//    public Editor(String fichero) {
//        File archivo = new File(fichero);
//        if (archivo.exists()) {
//            tFichero = new JTextField(archivo.getAbsolutePath());
//            InicializaVentana();
//        } else {
//            JOptionPane.showMessageDialog(null, "El Fichero no existe!.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    public void InicializaVentana() {
        form = new JFrame();
        form.setLayout(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setResizable(false);
        form.setBounds(200, 100, tamañoXVentana + 6, tamañoYVentana + 68);
        form.setTitle("Editor de texto plano");

        bNuevo = new JButton("Nuevo");
        bAbrir = new JButton("Abrir");
        bGuardar = new JButton("Guardar");
        bSalir = new JButton("Salir");
        lFichero = new JLabel("Nombre del fichero:");
        lEstado = new JLabel("Estado: ...");
        if (tFichero == null) {
            tFichero = new JTextField("");
        }
        tContenedor = new JTextArea();
        jspElScrol = new JScrollPane(tContenedor);
        algunCambio = false;

        bNuevo.setBounds(0, 0, tamañoBoton, 20);
        bAbrir.setBounds(tamañoBoton, 0, tamañoBoton, 20);
        bGuardar.setBounds(tamañoBoton * 2, 0, tamañoBoton, 20);
        bSalir.setBounds(tamañoBoton * 3, 0, tamañoBoton, 20);
        lFichero.setBounds(3, 20, 120, 20);
        lEstado.setBounds(10, tamañoYVentana, tamañoXVentana, 40);
        tFichero.setBounds(120, 20, tamañoYVentana - 120, 20);
        jspElScrol.setBounds(0, 40, tamañoXVentana, tamañoYVentana - 40);

        form.add(bNuevo);
        form.add(bAbrir);
        form.add(bGuardar);
        form.add(bSalir);
        form.add(lFichero);
        form.add(lEstado);
        form.add(tFichero);
        form.add(jspElScrol);
//        if (tFichero.getText().length() > 0) {
//            StringBuilder setEstado = new StringBuilder();
//            String contenido = IOFicheros.leeFicheroBuffer(new File(tFichero.getText()), setEstado);
//            if (setEstado.toString().length() == 0) {
//                tContenedor.setText(contenido);
//            } else {
//                JOptionPane.showMessageDialog(null, setEstado.toString(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
        InicializaFunciones();

        form.setVisible(true);
    }

    public void InicializaFunciones() {
        bNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (continuo()) {
                    tFichero.setText("DocumentoNuevo1.txt");
                    tContenedor.setText("");
                    setEstado("Nuevo documento");
                    algunCambio = false;  
                }
            }
        });
        bGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (algunCambio) {
                    if (tFichero.getText().length() > 0) {
                        if (guardaActual() != 0) {
                            setEstado("Error guardando");
                            JOptionPane.showMessageDialog(null, "Error al guardar.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            setEstado("Documento guardando");
                            algunCambio = false;
                        }
                    } else {
                        setEstado("Nombre requerido");
                        JOptionPane.showMessageDialog(null, "Se requiere un nombre para el fichero.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    setEstado("No hay nada que guardar");
                    JOptionPane.showMessageDialog(null, "No hay nada que guardar.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!continuo()) {
                    return;
                }
                String NF = JOptionPane.showInputDialog("Nombre del fichero:");
                if (NF != null && NF.length() > 0) {
                    tFichero.setText(NF);
                    StringBuilder estado = new StringBuilder();
                    String contenido = IOFicheros.leeFicheroBuffer(new File(tFichero.getText()), estado);
                    if (estado.toString().length() == 0) {
                        tContenedor.setText(contenido);
                        setEstado("Documento abierto");
                    } else {
                        setEstado(estado.toString());
                        JOptionPane.showMessageDialog(null, estado.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    algunCambio = false;
                }
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!continuo()) {
                    return;
                }
                //form.dispose();
                System.exit(0);
            }
        });

        tContenedor.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                algunCambio = true;
                setEstado("Cambios detectados");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tFichero.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                algunCambio = true;
                setEstado("Cambios detectados");
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setEstado("Ventana cargada");
    }

    public boolean continuo() {
        if (algunCambio) {
            int ficheroAbierto = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
            if (ficheroAbierto == JOptionPane.CANCEL_OPTION) {
                return false;
            } else if (ficheroAbierto == 0) {
                if (guardaActual() != 0) {
                    JOptionPane.showMessageDialog(null, "Error al guardar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }

    public int guardaActual() {
        return IOFicheros.escribeFicheroBuffer(new File(tFichero.getText()), tContenedor.getText().replace("\r\n", "\n").replace("\n", "\r\n"));
    }

    public void setEstado(String nuevo) {
        lEstado.setText("Estado: " + nuevo);
    }
}
