/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class contrato extends javax.swing.JFrame {

    /**
     * Creates new form contrato
     */
    public contrato() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cedula_contra_cli5 = new javax.swing.JTextField();
        apell_cli2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        nombre_cli3 = new javax.swing.JTextField();
        nombre_cli4 = new javax.swing.JTextField();
        apell_cli1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nombre_abg1 = new javax.swing.JTextField();
        apell_abg2 = new javax.swing.JTextField();
        apell_abg1 = new javax.swing.JTextField();
        nombre_cli2 = new javax.swing.JTextField();
        nombre_abg2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cedula_contra_abg = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("CONTRATO DE ASESORAMIENTO LEGAL");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 330, 42));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("con cédula");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        cedula_contra_cli5.setBackground(new java.awt.Color(153, 153, 153));
        cedula_contra_cli5.setForeground(new java.awt.Color(102, 204, 255));
        cedula_contra_cli5.setBorder(null);
        cedula_contra_cli5.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        cedula_contra_cli5.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        cedula_contra_cli5.setSelectionColor(new java.awt.Color(240, 240, 240));
        jPanel1.add(cedula_contra_cli5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 15));

        apell_cli2.setBackground(new java.awt.Color(153, 51, 0));
        apell_cli2.setBorder(null);
        apell_cli2.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        apell_cli2.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        apell_cli2.setSelectionColor(new java.awt.Color(240, 240, 240));
        apell_cli2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apell_cli2ActionPerformed(evt);
            }
        });
        jPanel1.add(apell_cli2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 70, 15));

        jButton1.setText("ACEPTAR");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        jButton2.setText("RECHAZAR");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        jCheckBox1.setText("HE LEÍDO Y ACEPTO TÉRMINOS Y CONDICIONES  ");
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        nombre_cli3.setBackground(new java.awt.Color(204, 204, 204));
        nombre_cli3.setBorder(null);
        nombre_cli3.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        nombre_cli3.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        nombre_cli3.setSelectionColor(new java.awt.Color(240, 240, 240));
        nombre_cli3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_cli3ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre_cli3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 60, 15));

        nombre_cli4.setBackground(new java.awt.Color(153, 51, 0));
        nombre_cli4.setBorder(null);
        nombre_cli4.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        nombre_cli4.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        nombre_cli4.setSelectionColor(new java.awt.Color(240, 240, 240));
        nombre_cli4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_cli4ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre_cli4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 60, 15));

        apell_cli1.setBackground(new java.awt.Color(153, 51, 0));
        apell_cli1.setBorder(null);
        apell_cli1.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        apell_cli1.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        apell_cli1.setSelectionColor(new java.awt.Color(240, 240, 240));
        apell_cli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apell_cli1ActionPerformed(evt);
            }
        });
        jPanel1.add(apell_cli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 60, 15));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Conste el presente contrato que celebran de una parte");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        nombre_abg1.setBackground(new java.awt.Color(153, 51, 0));
        nombre_abg1.setBorder(null);
        nombre_abg1.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        nombre_abg1.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        nombre_abg1.setSelectionColor(new java.awt.Color(240, 240, 240));
        nombre_abg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_abg1ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre_abg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 60, 15));

        apell_abg2.setBackground(new java.awt.Color(153, 51, 0));
        apell_abg2.setBorder(null);
        apell_abg2.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        apell_abg2.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        apell_abg2.setSelectionColor(new java.awt.Color(240, 240, 240));
        apell_abg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apell_abg2ActionPerformed(evt);
            }
        });
        jPanel1.add(apell_abg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 60, 15));

        apell_abg1.setBackground(new java.awt.Color(153, 51, 0));
        apell_abg1.setBorder(null);
        apell_abg1.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        apell_abg1.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        apell_abg1.setSelectionColor(new java.awt.Color(240, 240, 240));
        apell_abg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apell_abg1ActionPerformed(evt);
            }
        });
        jPanel1.add(apell_abg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 15));

        nombre_cli2.setBackground(new java.awt.Color(153, 51, 0));
        nombre_cli2.setBorder(null);
        nombre_cli2.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        nombre_cli2.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        nombre_cli2.setSelectionColor(new java.awt.Color(240, 240, 240));
        nombre_cli2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_cli2ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre_cli2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 70, 15));

        nombre_abg2.setBackground(new java.awt.Color(153, 51, 0));
        nombre_abg2.setBorder(null);
        nombre_abg2.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        nombre_abg2.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        nombre_abg2.setSelectionColor(new java.awt.Color(240, 240, 240));
        nombre_abg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_abg2ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre_abg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 60, 15));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText(", a quién  se le denominara EL CONTRATADO , y  de  otra  ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText(", a quién se le denominara LA CONTRANTANTE, y  de  otra  parte ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        cedula_contra_abg.setBackground(new java.awt.Color(153, 153, 153));
        cedula_contra_abg.setForeground(new java.awt.Color(102, 204, 255));
        cedula_contra_abg.setBorder(null);
        cedula_contra_abg.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        cedula_contra_abg.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        cedula_contra_abg.setSelectionColor(new java.awt.Color(240, 240, 240));
        cedula_contra_abg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_contra_abgActionPerformed(evt);
            }
        });
        jPanel1.add(cedula_contra_abg, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, 15));

        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextPane2.setText("CLÁUSULA SEGUNDA: OBJETO.- Por medio de este contrato, la CONTRATANTE, contrata al ABOGADO, para que el ABOGADO la patrocine en los procesos descritos en los antecedentes hasta su total terminación, es decir, hasta que las sentencias se encuentren ejecutoriadas, en los casos en los que esto sea posibles; el ABOGADO, por medio del presente instrumento se compromete a elaborar la demanda y denuncias, citar a los demandados, realizar todos los actos procesales que este tipo de procesos demanden de conformidad a la Ley, actuará apegado a lo que manda la Ley y asistirá profesionalmente a cuanta diligencia sea necesario asistir de conformidad a lo que manda la Ley, especialmente el Código de Procedimiento Civil, el Código Orgánico Integral Pena, el código de la niñez y adolescencia, hasta la ejecución total de la sentencia de cualquier instancia o  resolución de cualquier tipo de recurso instaurado por cualquiera de las partes. \n\nEste contrato no es exclusivo, puesto que el abogado ejerce libremente su profesión y presta sus servicios profesionales a otras personas naturales y jurídicas.\n");
        jScrollPane2.setViewportView(jTextPane2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 600, 260));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("con cédula");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apell_cli2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apell_cli2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apell_cli2ActionPerformed

    private void nombre_cli3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_cli3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_cli3ActionPerformed

    private void nombre_cli4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_cli4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_cli4ActionPerformed

    private void apell_cli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apell_cli1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apell_cli1ActionPerformed

    private void nombre_abg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_abg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_abg1ActionPerformed

    private void apell_abg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apell_abg2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apell_abg2ActionPerformed

    private void apell_abg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apell_abg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apell_abg1ActionPerformed

    private void nombre_cli2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_cli2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_cli2ActionPerformed

    private void nombre_abg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_abg2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_abg2ActionPerformed

    private void cedula_contra_abgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_contra_abgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedula_contra_abgActionPerformed

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
            java.util.logging.Logger.getLogger(contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new contrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apell_abg1;
    private javax.swing.JTextField apell_abg2;
    private javax.swing.JTextField apell_cli1;
    private javax.swing.JTextField apell_cli2;
    private javax.swing.JTextField cedula_contra_abg;
    private javax.swing.JTextField cedula_contra_cli5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextField nombre_abg1;
    private javax.swing.JTextField nombre_abg2;
    private javax.swing.JTextField nombre_cli2;
    private javax.swing.JTextField nombre_cli3;
    private javax.swing.JTextField nombre_cli4;
    // End of variables declaration//GEN-END:variables
}