/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import java.awt.Color;

/**
 *
 * @author Steven Zhicay
 */
public class VENTANAC extends javax.swing.JFrame {

    /**
     * Creates new form VENTANAC
     */
    public VENTANAC() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnCLIENTE = new javax.swing.JPanel();
        txtCLIENTE = new javax.swing.JLabel();
        btnASISTENTE = new javax.swing.JPanel();
        txtASISTENTE = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnABOGADO = new javax.swing.JPanel();
        txtABOGADO = new javax.swing.JLabel();
        btnCLIENTE1 = new javax.swing.JPanel();
        txtCLIENTE1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCLIENTE.setBackground(new java.awt.Color(102, 102, 102));
        btnCLIENTE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCLIENTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCLIENTEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCLIENTEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCLIENTEMouseExited(evt);
            }
        });

        txtCLIENTE.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        txtCLIENTE.setForeground(new java.awt.Color(153, 153, 153));
        txtCLIENTE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atencion-al-cliente.png"))); // NOI18N
        txtCLIENTE.setText("   CLIENTE");

        javax.swing.GroupLayout btnCLIENTELayout = new javax.swing.GroupLayout(btnCLIENTE);
        btnCLIENTE.setLayout(btnCLIENTELayout);
        btnCLIENTELayout.setHorizontalGroup(
            btnCLIENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCLIENTELayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtCLIENTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        btnCLIENTELayout.setVerticalGroup(
            btnCLIENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCLIENTE, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel3.add(btnCLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 190, 60));

        btnASISTENTE.setBackground(new java.awt.Color(102, 102, 102));
        btnASISTENTE.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnASISTENTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnASISTENTEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnASISTENTEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnASISTENTEMouseExited(evt);
            }
        });

        txtASISTENTE.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        txtASISTENTE.setForeground(new java.awt.Color(153, 153, 153));
        txtASISTENTE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtASISTENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asistente-virtual.png"))); // NOI18N
        txtASISTENTE.setText("  ASISTENTE");
        txtASISTENTE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnASISTENTELayout = new javax.swing.GroupLayout(btnASISTENTE);
        btnASISTENTE.setLayout(btnASISTENTELayout);
        btnASISTENTELayout.setHorizontalGroup(
            btnASISTENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnASISTENTELayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtASISTENTE, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnASISTENTELayout.setVerticalGroup(
            btnASISTENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnASISTENTELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtASISTENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(btnASISTENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 190, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Desea registrarse como?");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 310, 36));

        btnABOGADO.setBackground(new java.awt.Color(102, 102, 102));
        btnABOGADO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnABOGADOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnABOGADOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnABOGADOMouseExited(evt);
            }
        });

        txtABOGADO.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        txtABOGADO.setForeground(new java.awt.Color(153, 153, 153));
        txtABOGADO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtABOGADO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ley (1).png"))); // NOI18N
        txtABOGADO.setText("   ABOGADO");
        txtABOGADO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnABOGADOLayout = new javax.swing.GroupLayout(btnABOGADO);
        btnABOGADO.setLayout(btnABOGADOLayout);
        btnABOGADOLayout.setHorizontalGroup(
            btnABOGADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnABOGADOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtABOGADO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnABOGADOLayout.setVerticalGroup(
            btnABOGADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnABOGADOLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtABOGADO, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(btnABOGADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 190, 70));

        btnCLIENTE1.setBackground(new java.awt.Color(102, 102, 102));
        btnCLIENTE1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCLIENTE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCLIENTE1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCLIENTE1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCLIENTE1MouseExited(evt);
            }
        });

        txtCLIENTE1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        txtCLIENTE1.setForeground(new java.awt.Color(153, 153, 153));
        txtCLIENTE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCLIENTE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regrasar.png"))); // NOI18N
        txtCLIENTE1.setText("MENU PRINCIPAL");
        txtCLIENTE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCLIENTE1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnCLIENTE1Layout = new javax.swing.GroupLayout(btnCLIENTE1);
        btnCLIENTE1.setLayout(btnCLIENTE1Layout);
        btnCLIENTE1Layout.setHorizontalGroup(
            btnCLIENTE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCLIENTE1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCLIENTE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );
        btnCLIENTE1Layout.setVerticalGroup(
            btnCLIENTE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCLIENTE1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCLIENTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.add(btnCLIENTE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 210, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCLIENTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTEMouseClicked

        Registro_u Cliente = new Registro_u();
        Cliente.setVisible(true);
        dispose();


    }//GEN-LAST:event_btnCLIENTEMouseClicked

    private void btnCLIENTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTEMouseEntered
        btnCLIENTE.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnCLIENTEMouseEntered

    private void btnCLIENTEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTEMouseExited
        btnCLIENTE.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnCLIENTEMouseExited

    private void btnASISTENTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnASISTENTEMouseClicked

        Regi_Asistente Asistente = new Regi_Asistente();
        Asistente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnASISTENTEMouseClicked

    private void btnASISTENTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnASISTENTEMouseEntered
        btnASISTENTE.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnASISTENTEMouseEntered

    private void btnASISTENTEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnASISTENTEMouseExited
        btnASISTENTE.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnASISTENTEMouseExited

    private void btnABOGADOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnABOGADOMouseClicked

        Regi_abogado Abogado = new Regi_abogado();
        Abogado.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnABOGADOMouseClicked

    private void btnABOGADOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnABOGADOMouseEntered
        btnABOGADO.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnABOGADOMouseEntered

    private void btnABOGADOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnABOGADOMouseExited
        btnABOGADO.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnABOGADOMouseExited

    private void btnCLIENTE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTE1MouseClicked
        VentanaPrincipal1 nueva = new VentanaPrincipal1();
        nueva.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCLIENTE1MouseClicked

    private void btnCLIENTE1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTE1MouseEntered
        btnCLIENTE1.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnCLIENTE1MouseEntered

    private void btnCLIENTE1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTE1MouseExited
        btnCLIENTE1.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnCLIENTE1MouseExited

    private void txtCLIENTE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCLIENTE1MouseClicked

    }//GEN-LAST:event_txtCLIENTE1MouseClicked

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
            java.util.logging.Logger.getLogger(VENTANAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VENTANAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VENTANAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VENTANAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VENTANAC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnABOGADO;
    private javax.swing.JPanel btnASISTENTE;
    private javax.swing.JPanel btnCLIENTE;
    private javax.swing.JPanel btnCLIENTE1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtABOGADO;
    private javax.swing.JLabel txtASISTENTE;
    private javax.swing.JLabel txtCLIENTE;
    private javax.swing.JLabel txtCLIENTE1;
    // End of variables declaration//GEN-END:variables
}
