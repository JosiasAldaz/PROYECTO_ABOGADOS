package abogados;

import clases.Cliente;
import clases.Direcciones;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steven Zhicay
 */
public class VentanaPrincipal1 extends javax.swing.JFrame {
    Cliente usuario = new Cliente();
    int xMouse, yMouse;

    public VentanaPrincipal1() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LISTA = new javax.swing.JDialog();
        fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnRegistrarse = new javax.swing.JPanel();
        txtRegistrarse = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JPanel();
        txtIniciar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();

        javax.swing.GroupLayout LISTALayout = new javax.swing.GroupLayout(LISTA.getContentPane());
        LISTA.getContentPane().setLayout(LISTALayout);
        LISTALayout.setHorizontalGroup(
            LISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        LISTALayout.setVerticalGroup(
            LISTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(204, 204, 204));
        fondo.setForeground(new java.awt.Color(204, 204, 204));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(45, 45, 45))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setToolTipText("");
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(0, 0, 102));

        exitTxt.setBackground(new java.awt.Color(255, 255, 255));
        exitTxt.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(255, 255, 255));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 600));

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
        Login inicio = new Login();
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
       VENTANAC ventana = new VENTANAC();
       ventana.show();
    }//GEN-LAST:event_txtRegistrarseMouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(new Color(0,0,102));
        exitTxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_exitTxtMouseExited

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
    private javax.swing.JPanel btnIniciar;
    private javax.swing.JPanel btnRegistrarse;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel txtIniciar;
    private javax.swing.JLabel txtRegistrarse;
    // End of variables declaration//GEN-END:variables
}
