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
//    private JLabel idPersoLb;
//    private JTextField idPersoTf;
    private JLabel nombreLb;
    private JTextField nombreTf;
    private JLabel fechaLb;
    private JTextField fechaTf;
    private JLabel saldoLb;
    private JTextField saldoTf;
    private JButton guardarBt;
    private JButton desecharBt;

    public InsercionDg(JFrame form) {

        super(form, true);
        padre = form;
//        idPersoLb = new JLabel("idPerso:");
//        idPersoTf = new JTextField();
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
//                ((Ventana) padre).setNombreTxt(nombreTf);
//                ((Ventana) padre).setFechaNacTxt(fechaTf);
//                ((Ventana) padre).setSaldoTxt(saldoTf);

                Persona p = new Persona();

                p.setNombre(nombreTf.getText());
                try {
                    p.setSaldo(Double.parseDouble(saldoTf.getText()));
                } catch (NumberFormatException ex) {
                    p.setSaldo(0);
                }
                try {
                    p.setFechaNac(LocalDate.parse(fechaTf.getText()));
                } catch (DateTimeParseException ex) {
                    p.setFechaNac(LocalDate.now());
                }
                
                
                ((Ventana) padre).getContenedor().insertaPersona(p);
                ((Ventana) padre).setIndiceActual(((Ventana) padre).getIndiceActual()+1);
                ((Ventana) padre).actualizaComponentes(((Ventana) padre).getContenedor().getPersonas().get(((Ventana) padre).getIndiceActual()));
                ((Ventana) padre).repaint();
                 dispose();
            }
        }
        );

        //   JDialog dialogo = new JDialog(form, true);
        this.setLayout(
                new GridLayout(0, 2, 0, 20));
//        this.add(idPersoLb);
//        this.add(idPersoTf);

        this.add(nombreLb);

        this.add(nombreTf);

        this.add(fechaLb);

        this.add(fechaTf);

        this.add(saldoLb);

        this.add(saldoTf);

        this.add(guardarBt);

        this.add(desecharBt);

        this.setBounds(
                200, 200, 200, 300);

        this.pack();

        this.setVisible(
                true);
    }

    public void inicia() {

    }

}
