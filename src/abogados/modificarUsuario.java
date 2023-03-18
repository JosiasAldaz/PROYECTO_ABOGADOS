/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package abogados;

import static abogados.modificarAbogado.Jspdia;
import static abogados.modificarAbogado.contraseña;
import static abogados.modificarAbogado.jYearChooser1;
import clases.Cliente;
import clases.Direcciones;
import clases.PostgresConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class modificarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form modificarUsuario
     */
    public modificarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public String SeleccionarMes(String mes) {
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

    public void InserBase() throws SQLException {
        int anio = jYearChooser1.getYear();
        int dia = Integer.parseInt(Jspdia.getValue().toString());
        String contra = new String(jPsswrdFldContraseña1.getPassword());
        char genero = '\0';

        if (jRadioButton3.isSelected()) {
            genero = 'X';
        }
        if (jRadioButton1.isSelected()) {
            genero = 'F';
        }
        if (jRadioButton2.isSelected()) {
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
                    String timechooser = diaF + "/" + SeleccionarMes(JBxmes.getSelectedItem().toString()) + "/" + jYearChooser1.getYear();
                    System.out.println(timechooser);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(timechooser, formato);
                    LocalDateTime fechaHora = fecha.atStartOfDay();
                    LocalDate ahora = LocalDate.now();
                    Period periodo = Period.between(fecha, ahora);
                    int auxaedad = periodo.getYears();
                    PostgresConexion conexion = new PostgresConexion();
                    Cliente USU = new Cliente();
                    USU.setCedula(jTxtFldCedula.getText());
                    String sql = "SELECT * FROM CLIENTES WHERE  cedula_cli='" + USU.getCedula() + "'";
                    ResultSet contenedor = conexion.Consulta(sql);
                    Direcciones direccion_usuario = new Direcciones();
                    while (contenedor.next()) {
                        int k = contenedor.getInt("fk_id_direccion");
                        direccion_usuario.setId_direccion(k);
                        String sql1 = "SELECT * FROM public.direcciones WHERE id_direccion='" + direccion_usuario.getId_direccion() + "'";
                        ResultSet contenedor1 = conexion.Consulta(sql1);
                        while (contenedor1.next()) {
                            direccion_usuario.setCalle_principal(jTxtFldCallePrincipal.getText());
                            direccion_usuario.setCalle_secundaria(jTxtFldCalleSecundaria.getText());
                            direccion_usuario.setSucursal(false);
                        }
                        try {
                            direccion_usuario.modificar_direccion();
                            USU.setPrimerNombre(jTxtFldNombre1.getText());
                            USU.setSegundoNombre(jTxtFldNombre2.getText());
                            USU.setNombreApellido(jTxtFldApellido1.getText());
                            USU.setSegundoApellido(jTxtFldApellido2.getText());
                            USU.setTelefono(jTxtFildTelefono.getText());
                            USU.setGenero(genero);
                            USU.setEdad(auxaedad);
                            USU.setPassword(contra);
                            USU.setFecha_nacimiento(fechaHora);
                            USU.setFoto_perfil(JFSfoto_Usuario.getRutaImagen());
                            USU.Modificar_cliente();
                            dispose();
                            JOptionPane.showMessageDialog(null, "SE ACTUALIZO SU INFORMACION");
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO");
                        }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTxtFldNombre1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtFldApellido1 = new javax.swing.JTextField();
        jTxtFldNombre2 = new javax.swing.JTextField();
        jTxtFldApellido2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtFldCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtFildTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPsswrdFldContraseña2 = new javax.swing.JPasswordField();
        jLblCorreo = new javax.swing.JLabel();
        jTxtFldCorreo = new javax.swing.JTextField();
        jTxtFldCallePrincipal = new javax.swing.JTextField();
        jTxtFldCalleSecundaria = new javax.swing.JTextField();
        JFSfoto_Usuario = new rojerusan.RSFotoSquare();
        jLabel12 = new javax.swing.JLabel();
        jLabelCon = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPsswrdFldContraseña1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jBttnRegresarPanPrincipal = new javax.swing.JButton();
        ocultarContra = new javax.swing.JLabel();
        mostrarContra = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Jspdia = new javax.swing.JSpinner();
        JBxmes = new javax.swing.JComboBox<>();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel17 = new javax.swing.JLabel();
        jBttnRegresarPanPrincipal1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zyro-image (1).png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 48)); // NOI18N
        jLabel15.setText("MODIFICAR CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 170, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 150));

        jPanel2.setBackground(new java.awt.Color(211, 211, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxtFldNombre1.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldNombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldNombre1KeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFldNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 118, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel2.setText("Nombres:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 87, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel3.setText("Apellidos:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 87, 20));

        jTxtFldApellido1.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldApellido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldApellido1KeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFldApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 118, 20));

        jTxtFldNombre2.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldNombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldNombre2KeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFldNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 118, 20));

        jTxtFldApellido2.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldApellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldApellido2KeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFldApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 118, 20));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel4.setText("Cedula:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 87, 20));

        jTxtFldCedula.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldCedulaKeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 130, 20));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel5.setText("Telefono:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 87, 41));

        jTxtFildTelefono.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFildTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFildTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFildTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFildTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 182, 130, 20));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel6.setText("Genero:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 67, 41));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButton2.setText("Masculino");
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 87, -1));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButton1.setText("Femenino");
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 87, -1));

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButton3.setText("Sin especificar");
        jPanel2.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 110, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel8.setText("Calle principal:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 118, 41));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel9.setText("Año:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, 41));

        jPsswrdFldContraseña2.setBackground(new java.awt.Color(211, 211, 211));
        jPsswrdFldContraseña2.setText("jPasswordField1");
        jPsswrdFldContraseña2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel2.add(jPsswrdFldContraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 100, 20));

        jLblCorreo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLblCorreo.setText("Correo:");
        jPanel2.add(jLblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 63, 40));

        jTxtFldCorreo.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFldCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(jTxtFldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 230, 20));

        jTxtFldCallePrincipal.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCallePrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCallePrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldCallePrincipalKeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFldCallePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 150, -1));

        jTxtFldCalleSecundaria.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCalleSecundaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCalleSecundaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldCalleSecundariaKeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFldCalleSecundaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 150, -1));

        JFSfoto_Usuario.setBackground(new java.awt.Color(211, 211, 211));
        JFSfoto_Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(JFSfoto_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel12.setText("Calle secundaria:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, 41));

        jLabelCon.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabelCon.setText("Contraseña:");
        jPanel2.add(jLabelCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, -1));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel16.setText("Contraseña:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 90, -1));

        jPsswrdFldContraseña1.setBackground(new java.awt.Color(211, 211, 211));
        jPsswrdFldContraseña1.setText("jPasswordField1");
        jPsswrdFldContraseña1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel2.add(jPsswrdFldContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 100, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 204));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 950, 10));

        jBttnRegresarPanPrincipal.setBackground(new java.awt.Color(245, 222, 179));
        jBttnRegresarPanPrincipal.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jBttnRegresarPanPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/disco-flexible.png"))); // NOI18N
        jBttnRegresarPanPrincipal.setText("ACTUALIZAR");
        jBttnRegresarPanPrincipal.setBorder(null);
        jBttnRegresarPanPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnRegresarPanPrincipalActionPerformed(evt);
            }
        });
        jPanel2.add(jBttnRegresarPanPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 170, 40));

        ocultarContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ocultar.png"))); // NOI18N
        ocultarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocultarContraMouseClicked(evt);
            }
        });
        jPanel2.add(ocultarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 50, 50));

        mostrarContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contraseña.png"))); // NOI18N
        mostrarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarContraMouseClicked(evt);
            }
        });
        jPanel2.add(mostrarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel7.setFont(new java.awt.Font("Algerian", 3, 12)); // NOI18N
        jLabel7.setText("Seleccione una Imagen");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 150, -1));

        jLabel13.setFont(new java.awt.Font("MS PGothic", 3, 14)); // NOI18N
        jLabel13.setText("Fecha de Nacimiento:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 160, 41));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel14.setText("Mes:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, 20));

        Jspdia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Jspdia.setBorder(null);
        jPanel2.add(Jspdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 50, 30));

        JBxmes.setBackground(new java.awt.Color(211, 211, 211));
        JBxmes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        JBxmes.setBorder(null);
        JBxmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBxmesMouseClicked(evt);
            }
        });
        jPanel2.add(JBxmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 110, 30));

        jYearChooser1.setBackground(new java.awt.Color(211, 211, 211));
        jPanel2.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 60, 30));

        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel17.setText("Dia:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, 41));

        jBttnRegresarPanPrincipal1.setBackground(new java.awt.Color(245, 222, 179));
        jBttnRegresarPanPrincipal1.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jBttnRegresarPanPrincipal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regrasar.png"))); // NOI18N
        jBttnRegresarPanPrincipal1.setText("REGRESAR");
        jBttnRegresarPanPrincipal1.setBorder(null);
        jBttnRegresarPanPrincipal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnRegresarPanPrincipal1ActionPerformed(evt);
            }
        });
        jPanel2.add(jBttnRegresarPanPrincipal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 170, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 950, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFldNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldNombre1KeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTxtFldNombre1KeyTyped

    private void jTxtFldApellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldApellido1KeyTyped

        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTxtFldApellido1KeyTyped

    private void jTxtFldNombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldNombre2KeyTyped

        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTxtFldNombre2KeyTyped

    private void jTxtFldApellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldApellido2KeyTyped

        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTxtFldApellido2KeyTyped

    private void jTxtFldCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldCedulaKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITEN NUMEROS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTxtFldCedulaKeyTyped

    private void jTxtFildTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFildTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITEN NUMEROS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTxtFildTelefonoKeyTyped

    private void jTxtFldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFldCorreoActionPerformed

    private void jTxtFldCallePrincipalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldCallePrincipalKeyTyped

    }//GEN-LAST:event_jTxtFldCallePrincipalKeyTyped

    private void jTxtFldCalleSecundariaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldCalleSecundariaKeyTyped

    }//GEN-LAST:event_jTxtFldCalleSecundariaKeyTyped

    private void jBttnRegresarPanPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnRegresarPanPrincipalActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESE HACER ESTOS CAMBIO?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == 0) {

            try {
                InserBase();
                
            } catch (SQLException ex) {
                Logger.getLogger(modificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dispose();
        }

    }//GEN-LAST:event_jBttnRegresarPanPrincipalActionPerformed

    private void ocultarContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocultarContraMouseClicked
        // TODO add your handling code here:
        char i = jPsswrdFldContraseña1.getEchoChar();
        boolean a = true;
        if (a) {  // a es una variable boolean en true
            jPsswrdFldContraseña1.setEchoChar((char) '*');
            jPsswrdFldContraseña2.setEchoChar((char) '*');
            mostrarContra.setVisible(true);
            ocultarContra.setVisible(false);
            a = true;
        } else {
            jPsswrdFldContraseña1.setEchoChar(i); // i es el char
            a = true;
        }
    }//GEN-LAST:event_ocultarContraMouseClicked

    private void mostrarContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarContraMouseClicked
        char i = jPsswrdFldContraseña1.getEchoChar();
        boolean a = true;
        if (a) {  // a es una variable boolean en true
            jPsswrdFldContraseña1.setEchoChar((char) 0);
            jPsswrdFldContraseña2.setEchoChar((char) 0);
            mostrarContra.setVisible(false);
            ocultarContra.setVisible(true);
            a = true;
        } else {
            jPsswrdFldContraseña1.setEchoChar(i); // i es el char
            a = true;
        }
    }//GEN-LAST:event_mostrarContraMouseClicked

    private void JBxmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBxmesMouseClicked

    }//GEN-LAST:event_JBxmesMouseClicked

    private void jBttnRegresarPanPrincipal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnRegresarPanPrincipal1ActionPerformed
        dispose();
    }//GEN-LAST:event_jBttnRegresarPanPrincipal1ActionPerformed

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
            java.util.logging.Logger.getLogger(modificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JBxmes;
    private rojerusan.RSFotoSquare JFSfoto_Usuario;
    private javax.swing.JSpinner Jspdia;
    private javax.swing.JButton jBttnRegresarPanPrincipal;
    private javax.swing.JButton jBttnRegresarPanPrincipal1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCon;
    private javax.swing.JLabel jLblCorreo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPsswrdFldContraseña1;
    private javax.swing.JPasswordField jPsswrdFldContraseña2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextField jTxtFildTelefono;
    public static javax.swing.JTextField jTxtFldApellido1;
    public static javax.swing.JTextField jTxtFldApellido2;
    public static javax.swing.JTextField jTxtFldCallePrincipal;
    public static javax.swing.JTextField jTxtFldCalleSecundaria;
    public static javax.swing.JTextField jTxtFldCedula;
    public static javax.swing.JTextField jTxtFldCorreo;
    public static javax.swing.JTextField jTxtFldNombre1;
    public static javax.swing.JTextField jTxtFldNombre2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel mostrarContra;
    private javax.swing.JLabel ocultarContra;
    // End of variables declaration//GEN-END:variables
}
