/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaSimple_DB;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author prg
 */
public class InsercionDg extends JDialog {

    private JButton guardarBt;
    private JButton salirBt;
    private String[] columnas;
    private Object[] fila;
    private JLabel[] etiquetas;
    private JTextField[] campos;

    public InsercionDg(String[] columnas, Object[] fila) {
        super((JFrame) null, true);
        this.columnas = columnas;
        this.fila = fila;

        this.setLayout(new GridLayout(0, 2, 0, 10));
        etiquetas = new JLabel[columnas.length];
        campos = new JTextField[columnas.length];

        for (int i = 0; i < columnas.length; i++) {
            JLabel etiqueta = new JLabel(columnas[i]);
            JTextField campo = new JTextField();
            etiquetas[i] = etiqueta;
            campos[i] = campo;
            this.add(etiqueta);
            this.add(campo);
        }

        guardarBt = new JButton(" Guardar ");
        this.add(guardarBt);

        salirBt = new JButton(" Salir ");
        this.add(salirBt);

        guardarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < campos.length; i++) {
                    InsercionDg.this.fila[i] = InsercionDg.this.campos[i].getText();

                }

                dispose();
            }

        });

        salirBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }

        });
//        this.setLayout(null);

//        this.setBounds(200, 200, 500, 600);
        pack();
        this.setVisible(true);
    }

}
