package abogados;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author Steven Zhicay
 */
public class VentanaPrincipal1 extends javax.swing.JFrame {

    int xMouse, yMouse;

    public VentanaPrincipal1() {
        initComponents();
//        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LISTA = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        btnCLIENTE = new javax.swing.JPanel();
        txtCLIENTE = new javax.swing.JLabel();
        btnASISTENTE = new javax.swing.JPanel();
        txtASISTENTE = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnRegistrarse = new javax.swing.JPanel();
        txtRegistrarse = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JPanel();
        txtIniciar = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

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
        txtCLIENTE.setText("CLIENTE");
        txtCLIENTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCLIENTEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnCLIENTELayout = new javax.swing.GroupLayout(btnCLIENTE);
        btnCLIENTE.setLayout(btnCLIENTELayout);
        btnCLIENTELayout.setHorizontalGroup(
            btnCLIENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCLIENTE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnCLIENTELayout.setVerticalGroup(
            btnCLIENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCLIENTE, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        btnASISTENTE.setBackground(new java.awt.Color(102, 102, 102));
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
        txtASISTENTE.setText("ASISTENTE");

        javax.swing.GroupLayout btnASISTENTELayout = new javax.swing.GroupLayout(btnASISTENTE);
        btnASISTENTE.setLayout(btnASISTENTELayout);
        btnASISTENTELayout.setHorizontalGroup(
            btnASISTENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtASISTENTE, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        btnASISTENTELayout.setVerticalGroup(
            btnASISTENTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtASISTENTE, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Desea registrarse como?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnASISTENTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCLIENTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(btnASISTENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LISTALayout = new javax.swing.GroupLayout(LISTA.getContentPane());
        LISTA.getContentPane().setLayout(LISTALayout);
        LISTALayout.setHorizontalGroup(
            LISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LISTALayout.setVerticalGroup(
            LISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(153, 153, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(51, 51, 51));
        jTextArea1.setRows(5);
        jTextArea1.setText("Bienvenidos a ABOGADOS-ECU,  su firma  de abogados de \nconfianza   en   Ecuador. Nuestro   equipo  de  profesionales\naltamente  capacitados   está  aquí  para  brindarle  el  mejor\nservicio   legal   y  asesoramiento   en  una  amplia  gama de\náreas, desde derecho  penal  hasta  derecho  corporativo  y\nmás allá.\nNos  enorgullece   trabajar   incansablemente  en  nombre de\nnuestros    clientes,   ofreciendo    soluciones    prácticas    y\nefectivas para sus problemas legales. En ABOGADOS-ECU,\ncreemos en la justicia y en la protección de  los derechos  de\nnuestros  clientes,  y   nos   esforzamos   por  garantizar  que\nreciban la mejor representación legal posible.\nNavegue    por     nuestra    aplicación   para    obtener    más\ninformación  sobre nuestros  servicios y no dude  en ponerse\nen  contacto  con   nosotros   para   programar  una  consulta\ngratuita. En ABOGADOS-ECU, estamos comprometidos con\nsu éxito legal y estamos listos para ayudarlo a lograrlo.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 521, 439));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ABOGADOS-ECU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 303, 49));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Principal (1).jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        btnRegistrarse.setBackground(new java.awt.Color(102, 102, 102));

        txtRegistrarse.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtRegistrarse.setForeground(new java.awt.Color(153, 153, 153));
        txtRegistrarse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegistrarse.setText("Registrarse");
        txtRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRegistrarseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtRegistrarseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRegistrarseLayout = new javax.swing.GroupLayout(btnRegistrarse);
        btnRegistrarse.setLayout(btnRegistrarseLayout);
        btnRegistrarseLayout.setHorizontalGroup(
            btnRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnRegistrarseLayout.setVerticalGroup(
            btnRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnIniciar.setBackground(new java.awt.Color(102, 102, 102));
        btnIniciar.setForeground(new java.awt.Color(102, 102, 102));

        txtIniciar.setBackground(new java.awt.Color(255, 255, 255));
        txtIniciar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtIniciar.setForeground(new java.awt.Color(153, 153, 153));
        txtIniciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIniciar.setText("Iniciar Sesión");
        txtIniciar.setToolTipText("");
        txtIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIniciarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtIniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtIniciarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnIniciarLayout = new javax.swing.GroupLayout(btnIniciar);
        btnIniciar.setLayout(btnIniciarLayout);
        btnIniciarLayout.setHorizontalGroup(
            btnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnIniciarLayout.setVerticalGroup(
            btnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtIniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(816, Short.MAX_VALUE)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 600));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIniciarMouseExited
        btnIniciar.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtIniciarMouseExited

    private void txtIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIniciarMouseEntered
        btnIniciar.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtIniciarMouseEntered

    private void txtIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIniciarMouseClicked
        LOGIN inicio = new LOGIN();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_txtIniciarMouseClicked

    private void txtRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarseMouseExited
        btnRegistrarse.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtRegistrarseMouseExited

    private void txtRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarseMouseEntered
        btnRegistrarse.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtRegistrarseMouseEntered

    private void txtRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarseMouseClicked
        LISTA.setVisible(true);
        LISTA.setSize(220, 364);
        LISTA.setLocationRelativeTo(null);
    }//GEN-LAST:event_txtRegistrarseMouseClicked

    private void btnCLIENTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTEMouseEntered
        btnCLIENTE.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnCLIENTEMouseEntered

    private void btnCLIENTEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTEMouseExited
        btnCLIENTE.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnCLIENTEMouseExited

    private void btnASISTENTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnASISTENTEMouseEntered
        btnASISTENTE.setBackground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnASISTENTEMouseEntered

    private void btnASISTENTEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnASISTENTEMouseExited
        btnASISTENTE.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_btnASISTENTEMouseExited

    private void btnCLIENTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCLIENTEMouseClicked
        
    }//GEN-LAST:event_btnCLIENTEMouseClicked

    private void btnASISTENTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnASISTENTEMouseClicked
        Regi_Asistente Asistente = new Regi_Asistente();
        Asistente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnASISTENTEMouseClicked

    private void txtCLIENTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCLIENTEMouseClicked
        Registro_u Cliente = new Registro_u();
        Cliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_txtCLIENTEMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new VentanaPrincipal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog LISTA;
    private javax.swing.JPanel btnASISTENTE;
    private javax.swing.JPanel btnCLIENTE;
    private javax.swing.JPanel btnIniciar;
    private javax.swing.JPanel btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel txtASISTENTE;
    private javax.swing.JLabel txtCLIENTE;
    private javax.swing.JLabel txtIniciar;
    private javax.swing.JLabel txtRegistrarse;
    // End of variables declaration//GEN-END:variables
}
