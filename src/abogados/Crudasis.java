/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Edisson
 */
public class Crudasis extends javax.swing.JFrame {
    String selec;

    /**
     * Creates new form Regi_Asistente
     */
    public Crudasis() {
        initComponents();
        ocultarasis.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextcedula = new javax.swing.JTextField();
        jTextnom1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextnom2 = new javax.swing.JTextField();
        jTextape1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCombselec = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextape2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextcelular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPasscontra = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jPasscontra2 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jTextnusu = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextcorreo = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jTextedad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JFSfoto_asis = new rojerusan.RSFotoSquare();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        mostrarasis = new javax.swing.JLabel();
        ocultarasis = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Cedula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 207, -1, -1));
        jPanel1.add(jTextcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 237, 163, -1));
        jPanel1.add(jTextnom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 237, 86, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nombres:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 207, -1, -1));

        jTextnom2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextnom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 237, 86, -1));
        jPanel1.add(jTextape1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 298, 86, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Genero:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 268, -1, -1));

        jCombselec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Seleccionar ", " Masculino", " Femenino", " Sin espesificar" }));
        jPanel1.add(jCombselec, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 293, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 268, -1, -1));
        jPanel1.add(jTextape2, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 298, 86, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Fecha  de naciminento:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 342, -1, -1));
        jPanel1.add(jTextcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 374, 86, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Nombre de usuario:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 207, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Contraseña:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 342, -1, -1));
        jPanel1.add(jPasscontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 374, 163, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Verificar Contraseña:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 417, -1, -1));

        jPasscontra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasscontra2ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasscontra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 447, 154, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Correo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 268, -1, -1));

        jTextnusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextnusuActionPerformed(evt);
            }
        });
        jPanel1.add(jTextnusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 237, 109, -1));

        jButton2.setText("ACTUALIZAR DATOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 145, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Celular:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 342, -1, -1));
        jPanel1.add(jTextcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 298, 163, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 374, 144, 23));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Edad:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 342, -1, -1));
        jPanel1.add(jTextedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 379, 39, -1));

        jPanel2.setBackground(new java.awt.Color(139, 69, 19));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zyro-image (1).png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Constantia", 2, 48)); // NOI18N
        jLabel13.setText("Asistente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JFSfoto_asis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(JFSfoto_asis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 754, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Calle principal");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 419, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 447, 163, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Calle secundaria");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 418, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 447, 149, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hame.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 50, 40));

        mostrarasis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contraseña.png"))); // NOI18N
        mostrarasis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarasisMouseClicked(evt);
            }
        });
        jPanel1.add(mostrarasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        ocultarasis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ocultar.png"))); // NOI18N
        ocultarasis.setMaximumSize(new java.awt.Dimension(25, 25));
        ocultarasis.setMinimumSize(new java.awt.Dimension(25, 25));
        ocultarasis.setPreferredSize(new java.awt.Dimension(25, 25));
        ocultarasis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocultarasisMouseClicked(evt);
            }
        });
        jPanel1.add(ocultarasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 40, 40));

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextnusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextnusuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextnusuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:                     
        valced();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasscontra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasscontra2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasscontra2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        VentanaPrincipal1 principal = new VentanaPrincipal1();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void mostrarasisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarasisMouseClicked
        char i = jPasscontra.getEchoChar();
        boolean a = true;
        if (a) {  // a es una variable boolean en true
            jPasscontra.setEchoChar((char) 0);
            jPasscontra2.setEchoChar((char) 0);
            mostrarasis.setVisible(false);
            ocultarasis.setVisible(true);
            a = false;
        } else {
            jPasscontra.setEchoChar(i); // i es el char
            a = true;
        }
    }//GEN-LAST:event_mostrarasisMouseClicked

    private void ocultarasisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocultarasisMouseClicked
        char i = jPasscontra.getEchoChar();
        boolean a = true;
        if (a) {  // a es una variable boolean en true
            jPasscontra.setEchoChar((char) '*');
            jPasscontra2.setEchoChar((char) '*');
            mostrarasis.setVisible(true);
            ocultarasis.setVisible(false);
            a = true;
        } else {
            jPasscontra.setEchoChar(i); // i es el char
            a = true;
        }
    }//GEN-LAST:event_ocultarasisMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        asistenteInterfaz2 ad = new asistenteInterfaz2();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    ///////////////////////////metodos///
    public void valced() {
        String ced = jTextcedula.getText();
        boolean esValida = validarCedula(ced);
        if (esValida) {
            ingresar_datos();
        } else {
            JOptionPane.showMessageDialog(null, "La cédula no es válida.");
        }
    }

    public static boolean validarCedula(String cedula) {
        // Comprobar que la cédula tenga 10 dígitos
        if (cedula == null || cedula.length() != 10) {
            return false;
        }
        // Extraer el número de provincia de los primeros dos dígitos
        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }
        // Validar el tercer dígito (debe ser 0, 1, 2 o 3)
        int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        if (tercerDigito < 0 || tercerDigito > 3) {
            return false;
        }
        // Extraer los nueve primeros dígitos como un número entero
        int numCedula = Integer.parseInt(cedula.substring(0, 9));
        // Validar el último dígito usando el algoritmo de validación del Registro Civil
        int ultimoDigito = Integer.parseInt(cedula.substring(9));
        int total = 0;
        int multiplicador = 2;
        for (int i = 8; i >= 0; i--) {
            int digito = numCedula % 10;
            numCedula /= 10;
            int producto = digito * multiplicador;
            if (producto > 9) {
                producto -= 9;
            }
            total += producto;
            multiplicador = (multiplicador == 2) ? 1 : 2;
        }
        int digitVerificador = 10 - (total % 10);
        if (digitVerificador == 10) {
            digitVerificador = 0;
        }
        if (ultimoDigito != digitVerificador) {
            return false;
        }
        // Si llegamos hasta aquí, la cédula es válida
        return true;
    }
    
    public void ingresar_datos() {
        String ced = jTextcedula.getText();
        String nom = jTextnom1.getText();
        String nom2 = jTextnom2.getText();
        String ape1 = jTextape1.getText();
        String ape2 = jTextape2.getText();
        String cel = jTextcelular.getText();
        String edad = jTextedad.getText();
        String corre = jTextcorreo.getText();
        String usu = jTextnusu.getText();
        String contra = jPasscontra.getText();
        String contra1 = jPasscontra2.getText();
        if (ced.isEmpty() || nom.isEmpty() || nom2.isEmpty() || ape1.isEmpty() || ape2.isEmpty() || cel.isEmpty() || corre.isEmpty() || usu.isEmpty() || contra.isEmpty() || contra1.isEmpty()) {
            // Mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos.");
        } else {
            if (nom.matches("[A-Z]{1}[a-z]+$") && nom2.matches("[A-Z]{1}[a-z]+$")) {
                if (ape1.matches("[A-Z]{1}[a-z]+$") && ape2.matches("[A-Z]{1}[a-z]+$")) {
                    if (jCombselec.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(this, "SELECCIONE El GENERO");
                    } else {
                        if (jCombselec.getSelectedIndex() == 1) {
                            selec = jCombselec.getItemAt(1);
                        }
                        if (jCombselec.getSelectedIndex() == 2) {
                            selec = jCombselec.getItemAt(2);
                        }
                        if (jCombselec.getSelectedIndex() == 3) {
                            selec = jCombselec.getItemAt(3);
                        }
                        if (cel.matches("^[0-9]{10}$")) {
                            if (edad.matches("^[0-9]+$")) {
                                if (usu.matches("[A-Za-z]+$")) {
                                    if (contra1.equals(contra)) {
                                        if (corre.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {

                                            System.out.println(" " + ced);
                                            System.out.println(" " + nom);
                                            System.out.println(" " + nom2);
                                            System.out.println(" " + ape1);
                                            System.out.println(" " + ape2);
                                            System.out.println(" " + selec);
                                            System.out.println(" " + cel);
                                            System.out.println(" " + usu);
                                            System.out.println(" " + corre);
                                            System.out.println(" " + jDateChooser1.getDate());
                                            System.out.println(" " + contra);
                                            JOptionPane.showMessageDialog(this, "REGISTRO EXITOSO");
                                            Login log = new Login();
                                            log.setVisible(true);
                                            dispose();
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Correo invalido");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Las contraseñas no son iguales");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Nombre de usuario invalido");
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Edad invalida");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Numero de telefono incorrecto");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique los apellidos");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verifique los nombres");
            }
        }
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
            java.util.logging.Logger.getLogger(Crudasis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crudasis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crudasis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crudasis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crudasis().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSFotoSquare JFSfoto_asis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCombselec;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasscontra;
    private javax.swing.JPasswordField jPasscontra2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextape1;
    private javax.swing.JTextField jTextape2;
    private javax.swing.JTextField jTextcedula;
    private javax.swing.JTextField jTextcelular;
    private javax.swing.JTextField jTextcorreo;
    private javax.swing.JTextField jTextedad;
    private javax.swing.JTextField jTextnom1;
    private javax.swing.JTextField jTextnom2;
    private javax.swing.JTextField jTextnusu;
    private javax.swing.JLabel mostrarasis;
    private javax.swing.JLabel ocultarasis;
    // End of variables declaration//GEN-END:variables
}