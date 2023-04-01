/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

/**
 *
 * @author lieutuanvu
 */
public class controllerInputListJDialog extends javax.swing.JDialog {

    /**
     * Creates new form controllerInputListJDialog
     */
    private int soThuI = 1;
    public int soDaNhap = 0;
    public controllerInputListJDialog(java.awt.Frame parent, boolean modal, int soThuI) {
        super(parent, modal);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 3, dim.height / 3);
        this.soThuI = soThuI;
        initComponents();
        controllerInputListJDialogJPanelJLabel.setText("Nhập số thứ " + this.soThuI + ": ");
    }

    public controllerInputListJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 3, dim.height / 3);
        initComponents();
        controllerInputListJDialogJPanelJLabel.setText("Nhập số thứ " + soThuI + ": ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controllerInputListJDialogLabel = new javax.swing.JLabel();
        controllerInputListJDialogJPanel = new javax.swing.JPanel();
        controllerInputListJDialogJPanelJLabel = new javax.swing.JLabel();
        controllerInputListJDialogJPanelInput = new javax.swing.JSpinner();
        controllerInputListJDialogEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        controllerInputListJDialogLabel.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        controllerInputListJDialogLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        controllerInputListJDialogLabel.setText("NHẬP DÃY SỐ TỪ BÀN PHÍM");

        controllerInputListJDialogJPanelJLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        controllerInputListJDialogJPanelJLabel.setText("Nhập phần tử thứ i: ");

        controllerInputListJDialogJPanelInput.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        controllerInputListJDialogJPanelInput.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        controllerInputListJDialogJPanelInput.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        controllerInputListJDialogJPanelInput.setEditor(new javax.swing.JSpinner.NumberEditor(controllerInputListJDialogJPanelInput, ""));
        controllerInputListJDialogJPanelInput.setVerifyInputWhenFocusTarget(true);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) controllerInputListJDialogJPanelInput.getEditor()).getTextField();
        tf.setEditable(false);

        javax.swing.GroupLayout controllerInputListJDialogJPanelLayout = new javax.swing.GroupLayout(controllerInputListJDialogJPanel);
        controllerInputListJDialogJPanel.setLayout(controllerInputListJDialogJPanelLayout);
        controllerInputListJDialogJPanelLayout.setHorizontalGroup(
            controllerInputListJDialogJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllerInputListJDialogJPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(controllerInputListJDialogJPanelJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controllerInputListJDialogJPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controllerInputListJDialogJPanelLayout.setVerticalGroup(
            controllerInputListJDialogJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllerInputListJDialogJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controllerInputListJDialogJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(controllerInputListJDialogJPanelJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(controllerInputListJDialogJPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        controllerInputListJDialogEnter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        controllerInputListJDialogEnter.setText("NHẬP");
        controllerInputListJDialogEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                controllerInputListJDialogEnterMousePressed(evt);
            }
        });
        controllerInputListJDialogEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controllerInputListJDialogEnterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controllerInputListJDialogLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(controllerInputListJDialogJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controllerInputListJDialogEnter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controllerInputListJDialogLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controllerInputListJDialogJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(controllerInputListJDialogEnter, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean checkAvailableInput(int n) {
        if (n < 0 || n > 100) {
            return false;
        }
        return true;
    }
    private void controllerInputListJDialogEnterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_controllerInputListJDialogEnterMousePressed
        if (checkAvailableInput((int) controllerInputListJDialogJPanelInput.getValue())) {
            this.soDaNhap = (int) controllerInputListJDialogJPanelInput.getValue();
            this.setVisible(false);
        } else {
            controllerInputListJDialogJPanelJLabel.setText("Nhập lại (0-100): ");
        }
    }//GEN-LAST:event_controllerInputListJDialogEnterMousePressed

    private void controllerInputListJDialogEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controllerInputListJDialogEnterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_controllerInputListJDialogEnterActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(controllerInputListJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(controllerInputListJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(controllerInputListJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(controllerInputListJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                controllerInputListJDialog dialog = new controllerInputListJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton controllerInputListJDialogEnter;
    private javax.swing.JPanel controllerInputListJDialogJPanel;
    private javax.swing.JSpinner controllerInputListJDialogJPanelInput;
    private javax.swing.JLabel controllerInputListJDialogJPanelJLabel;
    private javax.swing.JLabel controllerInputListJDialogLabel;
    // End of variables declaration//GEN-END:variables

}