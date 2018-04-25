/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import javax.swing.UIManager;

/**
 *
 * @author super
 */
public class JFrameCurriculum extends javax.swing.JFrame {

    /**
     * Creates new form JFrameCurriculum
     */
    public JFrameCurriculum() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        notaPuntuacion = new javax.swing.JTextField();
        langIngles = new javax.swing.JCheckBox();
        langFrances = new javax.swing.JCheckBox();
        langRusky = new javax.swing.JCheckBox();
        langTentacle = new javax.swing.JCheckBox();
        langMerkel = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Puntuación de Curriculum");

        jLabel1.setText("Puntuación:");

        notaPuntuacion.setEditable(false);
        notaPuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaPuntuacionActionPerformed(evt);
            }
        });

        langIngles.setText("Ingles");
        langIngles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                langInglesItemStateChanged(evt);
            }
        });

        langFrances.setText("Baguette");
        langFrances.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                langFrancesItemStateChanged(evt);
            }
        });
        langFrances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langFrancesActionPerformed(evt);
            }
        });

        langRusky.setText("Vodka");
        langRusky.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                langRuskyItemStateChanged(evt);
            }
        });
        langRusky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langRuskyActionPerformed(evt);
            }
        });

        langTentacle.setText("Ora-Ora-Ora-Ora");
        langTentacle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                langTentacleItemStateChanged(evt);
            }
        });
        langTentacle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langTentacleActionPerformed(evt);
            }
        });

        langMerkel.setText("Frankfurt");
        langMerkel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                langMerkelItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notaPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(langMerkel)
                    .addComponent(langTentacle)
                    .addComponent(langRusky)
                    .addComponent(langFrances)
                    .addComponent(langIngles))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(notaPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(langIngles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(langFrances)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(langRusky)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(langTentacle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(langMerkel)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshState () {
        int resultado=0;
    if (langIngles.isSelected()==true) {
        resultado=resultado+2;
    }
    if (langFrances.isSelected()==true) {
        resultado=resultado+2;
    }
    if (langMerkel.isSelected()==true) {
        resultado=resultado+2;
    }
    if (langRusky.isSelected()==true) {
        resultado=resultado+2;
    }
    if (langTentacle.isSelected()==true) {
        resultado=resultado+2;
    }
    
        notaPuntuacion.setText(String.valueOf(resultado));
    }
    
    private void notaPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaPuntuacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notaPuntuacionActionPerformed

    private void langFrancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langFrancesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_langFrancesActionPerformed

    private void langTentacleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langTentacleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_langTentacleActionPerformed

    private void langRuskyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langRuskyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_langRuskyActionPerformed

    private void langInglesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_langInglesItemStateChanged
        refreshState();
    }//GEN-LAST:event_langInglesItemStateChanged

    private void langFrancesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_langFrancesItemStateChanged
        refreshState();
    }//GEN-LAST:event_langFrancesItemStateChanged

    private void langRuskyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_langRuskyItemStateChanged
        refreshState();
    }//GEN-LAST:event_langRuskyItemStateChanged

    private void langTentacleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_langTentacleItemStateChanged
        refreshState();
    }//GEN-LAST:event_langTentacleItemStateChanged

    private void langMerkelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_langMerkelItemStateChanged
        refreshState();
    }//GEN-LAST:event_langMerkelItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the system default look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
                javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameCurriculum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCurriculum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCurriculum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCurriculum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCurriculum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox langFrances;
    private javax.swing.JCheckBox langIngles;
    private javax.swing.JCheckBox langMerkel;
    private javax.swing.JCheckBox langRusky;
    private javax.swing.JCheckBox langTentacle;
    private javax.swing.JTextField notaPuntuacion;
    // End of variables declaration//GEN-END:variables
}
