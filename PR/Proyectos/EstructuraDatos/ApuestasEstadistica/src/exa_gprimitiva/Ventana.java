package exa_gprimitiva;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    
   // Variables declaration                    
    private JTextField apuestasTF;
    private JButton generaBt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultadoTa;
    private JLabel nApusLb;
    private javax.swing.JRadioButton ordenDesBt;
    private javax.swing.JRadioButton ordenNumBt;
    private javax.swing.JRadioButton ordenRepBt;
    private javax.swing.ButtonGroup ordenar;
    private JLabel titluloLb;
    
    private Primitiva prima;
    
    public Ventana() {
        prima = null;
        initComponents();
    }
    
                         
    private void initComponents() {
        
        titluloLb = new javax.swing.JLabel();
        nApusLb = new javax.swing.JLabel();
        apuestasTF = new javax.swing.JTextField();
        generaBt = new javax.swing.JButton();
        ordenNumBt = new javax.swing.JRadioButton();
        ordenRepBt = new javax.swing.JRadioButton();
        ordenDesBt = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoTa = new javax.swing.JTextArea();
        ordenar = new javax.swing.ButtonGroup();
        
        ordenar.add(ordenDesBt);
        ordenar.add(ordenNumBt);
        ordenar.add(ordenRepBt);
        ordenNumBt.setSelected(true);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        titluloLb.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        titluloLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titluloLb.setText("Estadisticas Primitivas");

        nApusLb.setFont(new java.awt.Font("Terminator Two", 0, 14)); // NOI18N
        nApusLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nApusLb.setText("Numero de Apuestas");

        apuestasTF.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        apuestasTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apuestasTF.setText("1000");
        
        generaBt.setText("AutoGenerar");
        generaBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int n = -1;
                try{
                    n = Integer.parseInt(apuestasTF.getText());
                    apuestasTF.setBackground(Color.white);
                    estadisticaAutomatica(n);
                }catch(Exception e){
                    apuestasTF.setBackground(Color.red);
                    System.out.println(""+e);
                }
            }
        });

        ordenNumBt.setText("Ordena Nº");
        ordenNumBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(prima!=null){
                    prima.ordenaPorNumero(); 
                    resultadoTa.setText(prima.toString());
                }
                       
            }
        });

        ordenRepBt.setText("Ordena Repetcion");
        ordenRepBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(prima!=null){
                    prima.ordenaPorRepeticion();
                    resultadoTa.setText(prima.toString());
                }
            }
        });

        ordenDesBt.setText("Ordena Desviaviacion");
        ordenDesBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(prima!=null){
                    prima.ordenaPorDesviacion();
                    resultadoTa.setText(prima.toString());
                }
            }
        });

        resultadoTa.setColumns(20);
        resultadoTa.setRows(5);
        jScrollPane1.setViewportView(resultadoTa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(titluloLb, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nApusLb, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(apuestasTF, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(71, 71, 71))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(generaBt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(188, 188, 188)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ordenNumBt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordenRepBt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(ordenDesBt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titluloLb, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nApusLb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apuestasTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(generaBt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordenNumBt)
                    .addComponent(ordenRepBt)
                    .addComponent(ordenDesBt))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        
        pack();
        
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension tamañoVentana = getSize();
            setLocation(new Point((tamañoPantalla.width - tamañoVentana.width) / 2,
                              (tamañoPantalla.height - tamañoVentana.width) / 2));
        
    }
    
    public void estadisticaAutomatica(int numApu){
        prima = new Primitiva(numApu);
        ordenNumBt.setSelected(true);
        resultadoTa.setText(prima.toString());
    }
    
   
    
}
