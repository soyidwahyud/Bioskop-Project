/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEnd;

/**
 *
 * @author soyidwahyud
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
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

        jloginButton1 = new javax.swing.JButton();
        jExitButton = new javax.swing.JButton();
        jBeranda = new javax.swing.JLabel();
        jpesanButton2 = new javax.swing.JButton();
        jExitButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jloginButton1.setText("Login");
        jloginButton1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jloginButton1ComponentMoved(evt);
            }
        });
        jloginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jloginButton1ActionPerformed(evt);
            }
        });

        jExitButton.setText("Exit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpesanButton2.setText("Pesan Tiket");
        jpesanButton2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jpesanButton2ComponentMoved(evt);
            }
        });
        jpesanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpesanButton2ActionPerformed(evt);
            }
        });

        jExitButton1.setText("Exit");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontEnd/imageedit_5_9644080758.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jpesanButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jExitButton1)))
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBeranda)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jpesanButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jExitButton1)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBeranda)
                    .addContainerGap(364, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jloginButton1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jloginButton1ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jloginButton1ComponentMoved

    private void jloginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jloginButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jloginButton1ActionPerformed

    private void jpesanButton2ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpesanButton2ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jpesanButton2ComponentMoved

    private void jpesanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpesanButton2ActionPerformed
        // TODO add your handling code here:
        new FormPembelian().setVisible(true);
        dispose();
    }//GEN-LAST:event_jpesanButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBeranda;
    private javax.swing.JButton jExitButton;
    private javax.swing.JButton jExitButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jloginButton1;
    private javax.swing.JButton jpesanButton2;
    // End of variables declaration//GEN-END:variables
}
