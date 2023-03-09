/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import clases.Administrador;
import clases.Direcciones;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Radministrador extends javax.swing.JFrame {

    /**
     * Creates new form Radministrador
     */
    public Radministrador() {
        initComponents();
        ocultar.setVisible(false);
    }

    public void diasvalidacion() {
        if (JBxmes.getSelectedItem().toString().equals("Febrero")) {
            if (Integer.valueOf(Jspdia.getValue().toString()) > 28) {
                JOptionPane.showMessageDialog(null, "FEBRERO NO TIENE MÁS DE 28 DÍAS, PORFAVOR \n"
                        + "SELECCIONE DE NUEVO EL DÍA DE SU NACIMIENTO");
                Jspdia.setValue(0);
            }
        }
    }

    public String meschoice(String mes) {
        String retorno = "";
        switch (mes) {
            case "Enero":
                retorno = "01";
                break;
            case "Febrero":
                retorno = "02";
                break;
            case "Marzo":
                retorno = "03";
                break;
            case "Abril":
                retorno = "04";
                break;
            case "Mayo":
                retorno = "05";
                break;
            case "Junio":
                retorno = "06";
                break;
            case "Julio":
                retorno = "07";
                break;
            case "Agosto":
                retorno = "08";
                break;
            case "Septiembre":
                retorno = "09";
                break;
            case "Octubre":
                retorno = "10";
                break;
            case "Noviembre":
                retorno = "11";
                break;
            case "Diciembre":
                retorno = "12";
                break;
        }
        return retorno;
    }

    public void validar() {
        if (cedula.getText().matches("^[0-9]{10}$")) {
            if (nombre1.getText().matches("[a-z]+") && nombre2.getText().matches("[a-z]+")) {
                if (apellido1.getText().matches("[a-z]+") && apellido2.getText().matches("^[a-z]+")) {
                    if (correo.getText().matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                        if (telefono.getText().matches("^[0-9]{10}$")) {
                            if (calle1.getText().matches("[a-z]+$") && calle2.getText().matches("[a-z]+$")) {
                                //if (contraseña3.equals(contraseña4)) {
                                     pru();

                                
                            } else {
                                JOptionPane.showMessageDialog(this, "DIRECCION INGRESADO INCORRECTA");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "TELEFONO INGRESADO INCORRECTA");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "CORREO INGRESADO INCORRECTA");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "APELLIDO INGRESADO INCORRECTA");
                }
            } else {
                JOptionPane.showMessageDialog(this, "NOMBRE INGRESADO INCORRECTA");
            }
        } else {
            JOptionPane.showMessageDialog(this, "CEDULA INCORRECTA");
        }
    }

    public void pru() {
        diasvalidacion();
        int anio = jYearChooser1.getYear();
        int dia = Integer.parseInt(Jspdia.getValue().toString());
        char genero = ' ';
        String contra = new String(contraseña1.getPassword());
        if (jRadioButton3.isSelected()) {
            genero = 'X';
        }
        if (jRadioButton2.isSelected()) {
            genero = 'F';
        }
        if (jRadioButton1.isSelected()) {
            genero = 'M';
        }
        if (dia > 31 || dia < 1) {
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN DIA MAYOR A 1 Y MENOR A 31");
        } else {
            if (JBxmes.getSelectedItem().toString().equals("SELECCIONE")) {
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN MES PARA LA FECHA DE NACIMIENTO");
            } else {
                if (anio >= LocalDate.now().getYear()) {
                    JOptionPane.showMessageDialog(null, "EL AÑO DE NACIMIENTO ES INCORRECTO");
                } else {
                    String diaF = "";
                    if (Jspdia.getValue().toString().length() == 1) {
                        diaF = "0" + Jspdia.getValue().toString();
                    } else {
                        diaF = Jspdia.getValue().toString();
                    }
                    String timechooser = diaF + "/" + meschoice(JBxmes.getSelectedItem().toString()) + "/" + jYearChooser1.getYear();
                    System.out.println(timechooser);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(timechooser, formato);
                    LocalDateTime fechaHora = fecha.atStartOfDay();
                    Direcciones direccion_admin = new Direcciones();
                    direccion_admin.setCalle_principal(calle1.getText());
                    direccion_admin.setCalle_secundaria(calle2.getText());
                    direccion_admin.setSucursal(false);
                    try {
                        int id = 0;
                        Administrador jefe = new Administrador();
                        direccion_admin.Ingresar();
                        //TRAEMOS EL ID DE LA DIRECCION RECIÉN CREADA
                        String id_direccion = "SELECT id_direccion FROM direcciones where calle_principal ='" + calle1.getText() + "' and calle_secundaria ='" + calle2.getText() + "'";
                        id = direccion_admin.Seleccionar(id_direccion);
                        System.out.println(id);
                        jefe.setCedula(cedula.getText());
                        jefe.setPrimerNombre(nombre1.getText());
                        jefe.setSegundoNombre(nombre2.getText());
                        jefe.setNombreApellido(apellido1.getText());
                        jefe.setSegundoApellido(apellido2.getText());
                        jefe.setFK_direccion(id);
                        jefe.setTelefono(telefono.getText());
                        jefe.setGenero(genero);
                        jefe.setPassword(contra);
                        jefe.setCorre(correo.getText());
                        jefe.setFoto_perfil(JFSfoto_admin.getRutaImagen());
                        jefe.setFecha_nacimiento(fechaHora);
                        jefe.Ingresar();
                    } catch (SQLException ex) {
                        Logger.getLogger(Radministrador.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR AL MOMENTO DE INGRESAR LA DIRECCION");
                    }
                }
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        nombre1 = new javax.swing.JTextField();
        nombre2 = new javax.swing.JTextField();
        apellido1 = new javax.swing.JTextField();
        apellido2 = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        mostrar = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        calle2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        calle1 = new javax.swing.JTextField();
        contraseña1 = new javax.swing.JPasswordField();
        contraseña = new javax.swing.JPasswordField();
        ocultar = new javax.swing.JLabel();
        Jspdia = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JBxmes = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jButton3 = new javax.swing.JButton();
        JFSfoto_admin = new rojerusan.RSFotoSquare();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cedula:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 60, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombres:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Apellidos:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Genero:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 140, 30));

        nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre1ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 140, 30));

        nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre2ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 160, 30));
        jPanel1.add(apellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 140, 30));
        jPanel1.add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 160, 30));
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Telefono:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Correo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Contraseña:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 517, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Verifar contraseña:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 280, 30));

        mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contraseña.png"))); // NOI18N
        mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarMouseClicked(evt);
            }
        });
        jPanel1.add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hame.png"))); // NOI18N
        jButton2.setText("PANTALLA PRINCIPAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 270, 50));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Masculino");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Femenino");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Sin Especificar");
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, -1, -1));

        jPanel2.setBackground(new java.awt.Color(139, 69, 19));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zyro-image (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addGap(96, 96, 96)
                .addComponent(jLabel1)
                .addContainerGap(408, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1010, 140));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 170, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Año:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 300, 40, 30));
        jPanel1.add(calle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 230, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Calle Secundaria:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 130, 30));
        jPanel1.add(calle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 230, 30));

        contraseña1.setText("jPasswordField1");
        jPanel1.add(contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 200, 30));

        contraseña.setText("jPasswordField1");
        jPanel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 200, 30));

        ocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ocultar.png"))); // NOI18N
        ocultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocultarMouseClicked(evt);
            }
        });
        jPanel1.add(ocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 40, 40));
        jPanel1.add(Jspdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 60, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Calle principal:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 118, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Día:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 40, 30));

        JBxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        JBxmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBxmesMouseClicked(evt);
            }
        });
        jPanel1.add(JBxmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 90, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Mes:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 40, 30));
        jPanel1.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 60, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("REGISTRARSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 150, 50));
        jPanel1.add(JFSfoto_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaPrincipal1 principal = new VentanaPrincipal1();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void mostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarMouseClicked
        char i = contraseña1.getEchoChar();
        boolean a = true;
        if (a) {  // a es una variable boolean en true
            contraseña.setEchoChar((char) 0);
            contraseña1.setEchoChar((char) 0);
            mostrar.setVisible(false);
            ocultar.setVisible(true);
            a = false;
        } else {
            contraseña1.setEchoChar(i); // i es el char
            a = true;
        }

    }//GEN-LAST:event_mostrarMouseClicked

    private void ocultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocultarMouseClicked
        char i = contraseña1.getEchoChar();
        boolean a = true;
        if (a) {  // a es una variable boolean en true
            contraseña1.setEchoChar((char) '*');
            contraseña.setEchoChar((char) '*');
            mostrar.setVisible(true);
            ocultar.setVisible(false);
            a = true;
        } else {
            contraseña1.setEchoChar(i); // i es el char
            a = true;
        }
    }//GEN-LAST:event_ocultarMouseClicked

    private void JBxmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBxmesMouseClicked

    }//GEN-LAST:event_JBxmesMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        validar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre1ActionPerformed

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
            java.util.logging.Logger.getLogger(Radministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Radministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Radministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Radministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Radministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JBxmes;
    private rojerusan.RSFotoSquare JFSfoto_admin;
    private javax.swing.JSpinner Jspdia;
    private javax.swing.JTextField apellido1;
    private javax.swing.JTextField apellido2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField calle1;
    private javax.swing.JTextField calle2;
    private javax.swing.JTextField cedula;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JPasswordField contraseña1;
    private javax.swing.JTextField correo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel mostrar;
    private javax.swing.JTextField nombre1;
    private javax.swing.JTextField nombre2;
    private javax.swing.JLabel ocultar;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
