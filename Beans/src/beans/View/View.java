/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.View;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jPanel1 = new javax.swing.JPanel();
    btnStart = new javax.swing.JButton();
    btnStop = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    tfCounterCenter = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Einarmiger Bandit");

    jPanel1.setLayout(new java.awt.GridBagLayout());

    btnStart.setText("Start");
    jPanel1.add(btnStart, new java.awt.GridBagConstraints());

    btnStop.setText("Stop");
    jPanel1.add(btnStop, new java.awt.GridBagConstraints());

    getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

    jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

    tfCounterCenter.setColumns(1);
    tfCounterCenter.setFont(new java.awt.Font("Monospaced", 1, 96)); // NOI18N
    tfCounterCenter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    tfCounterCenter.setText("9");
    tfCounterCenter.setEnabled(false);
    tfCounterCenter.setFocusable(false);
    tfCounterCenter.setMargin(new java.awt.Insets(5, 5, 5, 5));
    jPanel2.add(tfCounterCenter);

    getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

    setSize(new java.awt.Dimension(410, 330));
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public JTextField getTfCounterCenter() {
        return tfCounterCenter;
    }

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnStart;
  private javax.swing.JButton btnStop;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JTextField tfCounterCenter;
  // End of variables declaration//GEN-END:variables
}
