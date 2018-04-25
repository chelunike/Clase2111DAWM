/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipersonas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author prg
 */
public class InsercionDg extends JDialog {

    private JFrame padre;
    private Persona per;
    private JLabel nombreLb;
    private JTextField nombreTf;
    private JLabel fechaLb;
    private JTextField fechaTf;
    private JLabel saldoLb;
    private JTextField saldoTf;
    private JButton guardarBt;
    private JButton desecharBt;

    public Persona getPer() {
        return per;
    }

    public InsercionDg(JFrame form,String titulo, Persona p) {

        super(form,titulo,true);
        padre = form;
        per = p;
//        if (p == null) {
//                    per= new Persona();
//                    p=per;
//        }
        nombreLb = new JLabel("Nombre:");
        nombreTf = new JTextField();
        fechaLb = new JLabel("Fecha Nac.:");
        fechaTf = new JTextField();
        fechaTf.setText(LocalDate.now().toString());
        saldoLb = new JLabel("Saldo:");
        saldoTf = new JTextField();
        guardarBt = new JButton(" Guardar ");
        desecharBt = new JButton(" desechar ");

        desecharBt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                if (per == null) {
//                    per= new Persona();
//                }
                per.setNombre(nombreTf.getText());
                try {
                    per.setSaldo(Double.parseDouble(saldoTf.getText()));
                } catch (NumberFormatException ex) {
                    per.setSaldo(0);
                }
                try {
                    per.setFechaNac(LocalDate.parse(fechaTf.getText()));
                } catch (DateTimeParseException ex) {
                    per.setFechaNac(LocalDate.now());
                }

                setVisible(false);
               dispose();
            }
        }
        );

        this.setLayout(new GridLayout(0, 2, 0, 20));
        this.add(nombreLb);
        this.add(nombreTf);
        this.add(fechaLb);
        this.add(fechaTf);
        this.add(saldoLb);
        this.add(saldoTf);
        this.add(guardarBt);
        this.add(desecharBt);

        this.setBounds(300, 400, 200, 300);
      
        this.pack();
        this.setVisible(true);
        System.out.println("algo");
       
    }

}
