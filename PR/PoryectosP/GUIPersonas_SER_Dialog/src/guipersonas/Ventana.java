/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipersonas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author juan
 */
public class Ventana extends JFrame implements ActionListener {

    private Contenedor contenedor;
    private JLabel idPersoLb;
    private JLabel nombreLb;
    private JLabel fechaNacLb;
    private JLabel saldoLb;

    private JTextField idPersoTxt;
    private JTextField nombreTxt;
    private JTextField fechaNacTxt;
    private JTextField saldoTxt;

    public Contenedor getContenedor() {
        return contenedor;
    }

    public int getIndiceActual() {
        return indiceActual;
    }

    public void setIndiceActual(int indiceActual) {
        this.indiceActual = indiceActual;
    }

    public JTextField getIdPersoTxt() {
        return idPersoTxt;
    }

    public void setIdPersoTxt(JTextField idPersoTxt) {
        this.idPersoTxt = idPersoTxt;
    }

    public JTextField getNombreTxt() {
        return nombreTxt;
    }

    public void setNombreTxt(JTextField nombreTxt) {
        this.nombreTxt = nombreTxt;
    }

    public JTextField getFechaNacTxt() {
        return fechaNacTxt;
    }

    public void setFechaNacTxt(JTextField fechaNacTxt) {
        this.fechaNacTxt = fechaNacTxt;
    }

    public JTextField getSaldoTxt() {
        return saldoTxt;
    }

    public void setSaldoTxt(JTextField saldoTxt) {
        this.saldoTxt = saldoTxt;
    }

    private JButton previoBt;
    private JButton siguienteBt;
    private JButton borrarBt;
    private JButton editarBt;
    private JButton guardarBt;
    private JButton insertarBt;
    private int indiceActual;

    public Ventana(Contenedor con) {

        contenedor = con;

        idPersoLb = new JLabel("Id. persona:");
        nombreLb = new JLabel("Nombre: ");
        fechaNacLb = new JLabel("Fecha de Nacimiento: ");
        saldoLb = new JLabel("Saldo: ");
        idPersoTxt = new JTextField();
        nombreTxt = new JTextField();
        fechaNacTxt = new JTextField();
        saldoTxt = new JTextField();

        previoBt = new JButton(" Anterior ");
        siguienteBt = new JButton(" Siguiente ");
        borrarBt = new JButton(" Borrar ");
        editarBt = new JButton(" Editar ");
        guardarBt = new JButton(" Guardar ");
        insertarBt = new JButton(" Insertar ");

        getContentPane().setLayout(null);

        idPersoLb.setBounds(50, 50, 100, 30);
        nombreLb.setBounds(50, 100, 100, 30);
        fechaNacLb.setBounds(50, 150, 100, 30);
        saldoLb.setBounds(50, 200, 200, 30);

        idPersoTxt.setBounds(200, 50, 100, 30);
        nombreTxt.setBounds(200, 100, 100, 30);
        fechaNacTxt.setBounds(200, 150, 100, 30);
        saldoTxt.setBounds(200, 200, 100, 30);

        idPersoTxt.setEnabled(false);
        nombreTxt.setEnabled(false);
        fechaNacTxt.setEnabled(false);
        saldoTxt.setEnabled(false);

        previoBt.setBounds(50, 300, 100, 30);
        siguienteBt.setBounds(200, 300, 100, 30);
        insertarBt.setBounds(350, 300, 100, 30);
        borrarBt.setBounds(50, 350, 100, 30);
        editarBt.setBounds(200, 350, 100, 30);
        guardarBt.setBounds(350, 350, 100, 30);

        guardarBt.setEnabled(false);

        getContentPane().add(idPersoLb);
        getContentPane().add(nombreLb);
        getContentPane().add(fechaNacLb);
        getContentPane().add(saldoLb);
        getContentPane().add(idPersoTxt);
        getContentPane().add(nombreTxt);
        getContentPane().add(fechaNacTxt);
        getContentPane().add(saldoTxt);
        getContentPane().add(previoBt);
        getContentPane().add(siguienteBt);
        getContentPane().add(borrarBt);
        getContentPane().add(editarBt);
        getContentPane().add(guardarBt);
        getContentPane().add(insertarBt);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setBounds(0,0,1000,1400);
        setSize(600, 500);
        //pack();
//        GestorAction gestor = new GestorAction();

        previoBt.addActionListener(this);
        siguienteBt.addActionListener(this);
        borrarBt.addActionListener(this);
        editarBt.addActionListener(this);
        guardarBt.addActionListener(this);
        insertarBt.addActionListener(this);

        indiceActual = -1;

        if (contenedor != null) {
            if (contenedor.getPersonas().size() > 0) {
//                contenedor.getPersonas().sort(null);
                indiceActual = contenedor.getPersonas().size() - 1;
                actualizaComponentes(contenedor.getPersonas().get(indiceActual));
            } else {
//                Persona per = new Persona();
//                per.setFechaNac(LocalDate.now());
//                contenedor.insertaPersona(per);
            }
        } else {
            contenedor = new Contenedor();
//            Persona per = new Persona();
//            per.setFechaNac(LocalDate.now());
//            contenedor.insertaPersona(per);
//
//            actualizaComponentes(per);
        }

        this.setVisible(true);

        // this.addWindowListener(new WindowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                IOSerializar.serializarObjeto("RegistroPersonas.ser",
                        contenedor);
            }

        });

    }

    public void actualizaComponentes(Persona p) {
        if (p != null) {
            idPersoTxt.setText(String.valueOf(p.getIdPersona()));
            nombreTxt.setText(p.getNombre());
            fechaNacTxt.setText(p.getFechaNac().toString());
            saldoTxt.setText(String.valueOf(p.getSaldo()));
        } else {
            idPersoTxt.setText("");
            idPersoTxt.setText("");
            nombreTxt.setText("");
            fechaNacTxt.setText("");
            saldoTxt.setText("");

        }
        repaint();
    }

    public void guardaComponentes() {

        contenedor.getPersonas().get(indiceActual).setNombre(nombreTxt.getText());
        try {
            contenedor.getPersonas().get(indiceActual).setSaldo(Double.parseDouble(saldoTxt.getText()));
        } catch (NumberFormatException ex) {
            contenedor.getPersonas().get(indiceActual).setSaldo(0);
        }
        try {
            contenedor.getPersonas().get(indiceActual).setFechaNac(LocalDate.parse(fechaNacTxt.getText()));
        } catch (DateTimeParseException ex) {
            contenedor.getPersonas().get(indiceActual).setFechaNac(LocalDate.now());
        }
        // repaint();
    }

//    private class GestorAction implements ActionListener {
//        @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previoBt) {
            System.out.println("anterior");
            if (indiceActual > 0) {
                indiceActual--;
                actualizaComponentes(contenedor.getPersonas().get(indiceActual));

            }
            System.out.println("ia " + indiceActual);
        }

        if (e.getSource() == siguienteBt) {
            System.out.println("siguiente");

            if (indiceActual < contenedor.getSize() - 1) {
                indiceActual++;
                actualizaComponentes(contenedor.getPersonas().get(indiceActual));
            }
            System.out.println("ia " + indiceActual);
        }
        if (e.getSource() == borrarBt) {
            System.out.println("borrar");
            if (contenedor.getSize() > 0) {
                contenedor.getPersonas().remove(indiceActual);
                if (contenedor.getSize() > 0) {// puede que hubiese una sola persona
                    indiceActual = 0;
                    actualizaComponentes(contenedor.getPersonas().get(indiceActual));
                } else {
                    actualizaComponentes(null);
                    indiceActual = -1;
                }
            } else {
                System.out.println("No hay personas");
            }
            guardarBt.setEnabled(false);
            borrarBt.setEnabled(true);
            previoBt.setEnabled(true);
            siguienteBt.setEnabled(true);
            editarBt.setEnabled(true);
            insertarBt.setEnabled(true);
            nombreTxt.setEnabled(false);
            fechaNacTxt.setEnabled(false);
            saldoTxt.setEnabled(false);
        }
        if (e.getSource() == editarBt) {
            System.out.println("editar");

            if (contenedor.getPersonas().size() > 0) {

                //idPersoTxt.setEnabled(false);
                nombreTxt.setEnabled(true);
                fechaNacTxt.setEnabled(true);
                saldoTxt.setEnabled(true);

                guardarBt.setEnabled(true);
                borrarBt.setEnabled(false);
                previoBt.setEnabled(false);
                siguienteBt.setEnabled(false);
                editarBt.setEnabled(false);
                insertarBt.setEnabled(false);
            }

        }
        if (e.getSource() == guardarBt) {
            System.out.println("guardar");
            guardaComponentes();
            //idPersoTxt.setEnabled(false);
            nombreTxt.setEnabled(false);
            fechaNacTxt.setEnabled(false);
            saldoTxt.setEnabled(false);
            guardarBt.setEnabled(false);

            borrarBt.setEnabled(true);
            previoBt.setEnabled(true);
            siguienteBt.setEnabled(true);
            editarBt.setEnabled(true);
            insertarBt.setEnabled(true);
            indiceActual = 0;
            actualizaComponentes(contenedor.getPersonas().get(indiceActual));

            repaint();
        }

        if (e.getSource() == insertarBt) {

            new InsercionDg(this);
            System.out.println("insertar");
//                //guardaComponentes();
//                //idPersoTxt.setEnabled(false);
//                Persona p = new Persona();
//                p.setFechaNac(LocalDate.now());
//                contenedor.insertaPersona(p);
//                indiceActual = contenedor.getSize() - 1;
//                actualizaComponentes(contenedor.getPersonas().get(indiceActual));
//
//                nombreTxt.setEnabled(true);
//                fechaNacTxt.setEnabled(true);
//                saldoTxt.setEnabled(true);
//
//                guardarBt.setEnabled(true);
//                borrarBt.setEnabled(true);
//                previoBt.setEnabled(false);
//                siguienteBt.setEnabled(false);
//                editarBt.setEnabled(false);
//                insertarBt.setEnabled(false);
//                repaint();

        }
    }

//    }
}
