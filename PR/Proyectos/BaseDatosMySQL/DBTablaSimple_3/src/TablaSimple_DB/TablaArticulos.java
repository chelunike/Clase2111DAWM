/*
 * TablaArticulos.java
 *
 * Autor:  Fco. Javier Ceballos
 */
package TablaSimple_DB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TablaArticulos extends javax.swing.JFrame implements TableModelListener {

    private javax.swing.JScrollPane jScrollPanel1;
    private javax.swing.JTable jTabla1;
    private DefaultTableModel modelo;
    private JButton borrarBt, insertarBt;
    private String[] cabecera;
    private String[] clases;
    private ResultSet rs;

    public TablaArticulos() {
        initComponents();
        setTitle("Datos");
        setSize(600, 500);
    }

    /* Iniciar los componentes */
    private void initComponents() {

        MySQL myDb = new MySQL();
        cabecera = null;
//        ArrayList<String> header = new ArrayList<String>();
        Object[][] datos;
        MySQL.conecta("pepe", "pepa", "depemp");

        boolean salida = MySQL.ejecutaConsulta("select * from empleados");
        System.out.println("EjecutaConsulta: " + salida);

        //devuelve los datos de la consulta y la cabecera de la tabla
        datos = MySQL.getDatos();
        cabecera = MySQL.getCabecera();
        clases = MySQL.getClases();
//        MySQL.cierra();

        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                System.out.print(datos[i][j] + ",");
            }
            System.out.println("\n");
        }

//        jTabla1 = new javax.swing.JTable(datos, cabecera);
        modelo = new DefaultTableModel(datos, cabecera);
        jTabla1 = new javax.swing.JTable();
        jTabla1.setModel(modelo);
        insertarBt = new JButton(" Insertar ");

        insertarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTabla1.getModel().removeTableModelListener(TablaArticulos.this);
                System.out.println("Hay que insertar");
                Object[] fila = new Object[cabecera.length];
                new InsercionDg(cabecera, fila);
                for (Object o : fila) {
                    System.out.println("o:" + o);
                }

                modelo.addRow(fila);
                int nf = jTabla1.getRowCount();
                int nc = cabecera.length;
                rs = MySQL.getResultSet();
                System.out.println("nF:" + nf + "  nC:" + nc);

                try {
                    rs.moveToInsertRow();
                    for (int i = 0; i < nc; i++) {
                        if (clases[i].toString().contains("Date")) {
                            try {
                                LocalDate.parse(jTabla1.getValueAt(nf - 1, i).toString());
                                rs.updateObject(i + 1, jTabla1.getValueAt(nf - 1, i));
                            } catch (DateTimeParseException eDate) {
                                jTabla1.setValueAt(LocalDate.now().toString(), nf - 1, i);
                                rs.updateObject(i + 1, LocalDate.now().toString());
                            }
                        }
                        if (clases[i].toString().contains("Decimal")) {
                            try {
                                Double.parseDouble(jTabla1.getValueAt(nf - 1, i).toString());
                                rs.updateObject(i + 1, jTabla1.getValueAt(nf - 1, i));
                            } catch (NumberFormatException eParse) {
                                jTabla1.setValueAt(0.0, nf - 1, i);
                                rs.updateObject(i + 1, 0.0);
                            }
                        }
                        if (clases[i].toString().contains("Int")) {
                            try {
                                Integer.parseInt(jTabla1.getValueAt(nf - 1, i).toString());
                                rs.updateObject(i + 1, jTabla1.getValueAt(nf - 1, i));
                            } catch (NumberFormatException eParse) {
                                jTabla1.setValueAt(0, nf - 1, i);
                                rs.updateObject(i + 1, 0);
                            }
                        } else {
                            rs.updateObject(i + 1, jTabla1.getValueAt(nf - 1, i));
                        }
                        System.out.println("clase " + clases[i]);

                    }
                    rs.insertRow();

                } catch (SQLException ex) {

                    Logger.getLogger(TablaArticulos.class.getName()).log(Level.SEVERE, null, ex);
                }
                jTabla1.getModel().addTableModelListener(TablaArticulos.this);
                validate();

            }

        });
        borrarBt = new JButton(" Borrar ");
        borrarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nFila = jTabla1.getSelectedRow();
                System.out.println("fila: " + nFila);
                if (nFila >= 0) {
                    modelo.removeRow(nFila);

                    try {
                        rs = MySQL.getResultSet();
                        rs.absolute(nFila + 1);
                        rs.deleteRow();
                    } catch (SQLException ex) {
                        Logger.getLogger(TablaArticulos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

        // Asigna datos y cabecera a jTable
//    jTabla1.setModel(new javax.swing.table.DefaultTableModel(datos, cabecera)
//    {
//         //Declara los tipos de las columnas
//        Class[] tipoColumn = { java.lang.String.class,
//                             java.lang.String.class,
//                             java.lang.Long.class,
//                             java.lang.Boolean.class };
//
//        // Dice que columnas se pueden editar
//      boolean[] editColum = { false, true, true, true };
//
//      @Override
//      public Class getColumnClass(int indColum) // devuelve el tipo de la columna?
//      {
//        return tipoColumn[indColum];
//      }
//
//      @Override
//      public boolean isCellEditable(int indFila, int indColum)
//      {
//        return editColum[indColum];
//      }
//    });
        // Aquí se especifica la anchura de las columnas
        javax.swing.table.TableColumn colum = null;
        for (int i = 0; i < jTabla1.getColumnCount(); i++) {
            colum = jTabla1.getColumnModel().getColumn(i);
            if (i < 2) {
                colum.setPreferredWidth(110);
            } else {
                colum.setPreferredWidth(40);
            }
        }
        jTabla1.getModel().addTableModelListener(this);
//   
        //  instanciar un JScrollPane  y se pasa jTabla1 como parámetro
        jScrollPanel1 = new javax.swing.JScrollPane(jTabla1);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        // Se coloca jScrollPane1 en el panel por defecto;
        this.setLayout(null);
        jScrollPanel1.setBounds(5, 5, 500, 150);
        this.add(jScrollPanel1);
        insertarBt.setBounds(100, 200, 100, 30);
        this.add(insertarBt);
        borrarBt.setBounds(300, 200, 100, 30);
        this.add(borrarBt);
    }

    private void jTabla1MouseClicked(java.awt.event.MouseEvent evt) {
        java.lang.Object datoCelda = jTabla1.getValueAt(
                jTabla1.getSelectedRow(),
                jTabla1.getSelectedColumn());
        System.out.println(datoCelda);

    }

    public void tableChanged(TableModelEvent evt) {

//                int tipo = evt.getType();
        if (evt.getType() == TableModelEvent.UPDATE) {
            System.out.println("columna: " + evt.getColumn());
            System.out.println("firstRow: " + evt.getFirstRow());
            System.out.println("lsatRow: " + evt.getLastRow());
            System.out.println("tipo: " + evt.getType());
            System.out.println("hola");
            java.lang.Object datoCelda = jTabla1.getValueAt(
                    evt.getFirstRow(), evt.getColumn());

            rs = MySQL.getResultSet();
            try {
                rs.absolute(evt.getFirstRow() + 1);
                rs.updateObject(evt.getColumn() + 1, datoCelda);
                rs.updateRow();

            } catch (SQLException ex) {
                Logger.getLogger(TablaArticulos.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(datoCelda.toString());
        }

    }

    /**
     * Salir de la aplicación
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {

        new TablaArticulos().setVisible(true);
    }

}
