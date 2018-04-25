/*
 * TablaArticulos.java
 *
 * Autor:  Fco. Javier Ceballos
 */
package TablaSimple_DB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TablaArticulos extends javax.swing.JFrame {

    private javax.swing.JScrollPane jScrollPanel1;
    private javax.swing.JTable jTabla1;
    private DefaultTableModel modelo;
    private JButton borrarBt, insertarBt;

    public TablaArticulos() {
        initComponents();
        setTitle("Datos");
        setSize(600, 500);
    }

    /* Iniciar los componentes */
    private void initComponents() {

        MySQL myDb = new MySQL();
        String[] cabecera = null;
//        ArrayList<String> header = new ArrayList<String>();
        Object[][] datos;
        MySQL.conecta("pepe", "pepa", "depemp");

        boolean salida = MySQL.ejecutaConsulta("select * from empleados");
        System.out.println("EjecutaConsulta: " + salida);

        //devuelve los datos de la consulta y la cabecera de la tabla
        datos = MySQL.getDatos();
        cabecera = MySQL.getCabecera();
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
                System.out.println("Hay que insertar");
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
                }
            }
        });

        // Asigna datos y cabecera a jTable
//    jTabla1.setModel(new javax.swing.table.DefaultTableModel(datos, cabecera)
//    {
//        // Declara los tipos de las columnas
////        Class[] tipoColumn = { java.lang.String.class,
////                             java.lang.String.class,
////                             java.lang.Long.class,
////                             java.lang.Boolean.class };
//
//        // Dice que columnas se pueden editar
//      boolean[] editColum = { false, true, true, true };
//
////      @Override
////      public Class getColumnClass(int indColum) // devuelve el tipo de la columna?
////      {
////        return tipoColumn[indColum];
////      }
//
////      @Override
////      public boolean isCellEditable(int indFila, int indColum)
////      {
////        return editColum[indColum];
////      }
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
        jTabla1.getModel().addTableModelListener(
                new TableModelListener() {
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

                    System.out.println(datoCelda.toString());
                }

            }

        });

//        jTabla1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jTabla1MouseClicked(evt);
//            }
//        });
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
