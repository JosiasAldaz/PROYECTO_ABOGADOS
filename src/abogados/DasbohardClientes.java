/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import static abogados.modificarUsuario.jTxtFildTelefono;
import static abogados.modificarUsuario.jTxtFldApellido1;
import static abogados.modificarUsuario.jTxtFldApellido2;
import static abogados.modificarUsuario.jTxtFldCallePrincipal;
import static abogados.modificarUsuario.jTxtFldCalleSecundaria;
import static abogados.modificarUsuario.jTxtFldCedula;
import static abogados.modificarUsuario.jTxtFldCorreo;
import static abogados.modificarUsuario.jTxtFldNombre1;
import static abogados.modificarUsuario.jTxtFldNombre2;
import clases.Cliente;
import clases.Direcciones;
import clases.Label_conborde;
import clases.MOSTRAR_CLIENTES;
import clases.PostgresConexion;
import clases.TIPO_diplomnma;
import clases.abogado;
import clases.contrato;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class DasbohardClientes extends javax.swing.JFrame {

    TIPO_diplomnma combo = new TIPO_diplomnma();
    ArrayList<TIPO_diplomnma> combobox = combo.mostrar();
    ArrayList<MOSTRAR_CLIENTES> interfaz = combo.mostrar();
    int indice = 0;
    abogado buscar = new abogado();

    public DasbohardClientes() throws SQLException {
        initComponents();
        cargarcombo();
        JPslide.setVisible(false);
        JPbuscar_abg.setVisible(false);
        MODIFICAR_USUARIO.setVisible(false);
        ocultarContra.setVisible(false);
    }

    public void cargarcombo() throws SQLException {
        combobox = combo.mostrar();
        combobox.stream().forEach(tipos -> {
            if (JCB_tipos.getItemCount() == 0) {
                JCB_tipos.addItem("SELECCIONE");
            }
            JCB_tipos.addItem(tipos.getNombre_diplo());
        });
    }

    public void mostrarABG(ArrayList<abogado> lista_tipo) {
        // Para darle forma al modelo de la tabla
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) TablaR.getModel();
        mTabla.setNumRows(0);
        // Uso de una expresion landa
        lista_tipo.stream().forEach(tipos -> {
            String[] filaNueva = {String.valueOf(tipos.getCedula()), tipos.getPrimerNombre(), tipos.getNombreApellido(), tipos.getTelefono(), String.valueOf(tipos.isGratuidad()), String.valueOf(tipos.getCost_hora())};
            mTabla.addRow(filaNueva);
        });
        TablaR.setModel(mTabla);

    }

    public void limpiar() {
        DefaultTableModel tb = (DefaultTableModel) TablaR.getModel();
        int a = TablaR.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public int buscarID_diploma() {
        int retorno = 0;
        for (TIPO_diplomnma diploma : combobox) {
            if (diploma.getNombre_diplo().equals(JCB_tipos.getSelectedItem().toString())) {
                retorno = diploma.getID_diploma();
            }
        }
        return retorno;
    }

    public String parámetro() {
        String parámetro = "";
        switch (JCb_parámetros.getSelectedItem().toString()) {
            case "SELECCIONE":
                parámetro = "INVÁLIDO";
                break;
            case "NOMBRE":
                parámetro = "prim_nom_abg";
                buscar.setPrimerNombre(jTextField2.getText());
                break;
            case "APELLIDO":
                parámetro = "prim_apell_abg";
                buscar.setNombreApellido(jTextField2.getText());
                break;
            case "CÉDULA":
                parámetro = "cedula_abg";
                buscar.setCedula(jTextField2.getText());
                break;
        }
        return parámetro;
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

    public void validar() throws SQLException {
        if (jTxtFldCedula.getText().matches("^[0-9]{10}$")) {
            if (jTxtFldNombre1.getText().matches("[a-z]+") && jTxtFldNombre2.getText().matches("[a-z]+")) {
                if (jTxtFldApellido1.getText().matches("[a-z]+") && jTxtFldApellido2.getText().matches("[a-z]+")) {
                    if (jTxtFldCorreo.getText().matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                        if (jTxtFildTelefono.getText().matches("^[0-9]{10}$")) {
                            if (jPsswrdFldContraseña1.equals(jPsswrdFldContraseña2)) {
                                InserBase();
                            } else {
                                JOptionPane.showMessageDialog(this, "NO COINCIDEN LAS CONTRASEÑAS");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "TELEFONO INGRESADO INCORRECTA");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "CORREO INCORRECTO");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "APELLIDO INGRESADO INCORRECTO");
                }
            } else {
                JOptionPane.showMessageDialog(this, "NOMBRE INGRESADO INCORRECTO");
            }
        } else {
            JOptionPane.showMessageDialog(this, "CEDULA INGRESADA INCORRECTA");
        }
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

    public void modificarUsuario() throws SQLException {
        PostgresConexion conexion = new PostgresConexion();
        Cliente cli = new Cliente();
        cli.setID_cliente(Login.cliente.ID_cliente());
        String sql = "SELECT * FROM CLIENTES WHERE  id_clie= '" + cli.getID_cliente() + "'";
        ResultSet contenedor = conexion.Consulta(sql);
        while (contenedor.next()) {

          
            jTxtFldCedula.setText(contenedor.getString("cedula_cli"));
            jTxtFldNombre1.setText(contenedor.getString("prim_nom_cli"));
            jTxtFldNombre2.setText(contenedor.getString("seg_nom_cli"));
            jTxtFldApellido1.setText(contenedor.getString("prim_apell_cli"));
            jTxtFldApellido2.setText(contenedor.getString("seg_apell_cli"));
            jTxtFildTelefono.setText(contenedor.getString("telefono_cli"));
            jTxtFldCorreo.setText(contenedor.getString("correo_cli"));
            jPsswrdFldContraseña1.setText(contenedor.getString("contraseña_cli"));
            jPsswrdFldContraseña2.setText(contenedor.getString("contraseña_cli"));

            int k = contenedor.getInt("fk_id_direccion");
            Direcciones direc = new Direcciones();
            direc.setId_direccion(k);
            String sql1 = "SELECT * FROM public.direcciones WHERE id_direccion='" + direc.getId_direccion() + "'";
            ResultSet contenedor1 = conexion.Consulta(sql1);
            while (contenedor1.next()) {
                jTxtFldCallePrincipal.setText(contenedor1.getString("calle_principal"));
                jTxtFldCalleSecundaria.setText(contenedor1.getString("calle_secundaria"));

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

        jDialog1 = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        JPanel_explorar = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        MODIFICAR_USUARIO = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTxtFldNombre1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTxtFldApellido1 = new javax.swing.JTextField();
        jTxtFldNombre2 = new javax.swing.JTextField();
        jTxtFldApellido2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTxtFldCedula = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTxtFildTelefono = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPsswrdFldContraseña2 = new javax.swing.JPasswordField();
        jLblCorreo = new javax.swing.JLabel();
        jTxtFldCorreo = new javax.swing.JTextField();
        jTxtFldCallePrincipal = new javax.swing.JTextField();
        jTxtFldCalleSecundaria = new javax.swing.JTextField();
        JFSfoto_Usuario = new rojerusan.RSFotoSquare();
        jLabel31 = new javax.swing.JLabel();
        jLabelCon = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPsswrdFldContraseña1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jBttnRegresarPanPrincipal = new javax.swing.JButton();
        ocultarContra = new javax.swing.JLabel();
        mostrarContra = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        Jspdia = new javax.swing.JSpinner();
        JBxmes = new javax.swing.JComboBox<>();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel36 = new javax.swing.JLabel();
        jBttnRegresarPanPrincipal1 = new javax.swing.JButton();
        JPmenuinicio = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        interno = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        interno1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        interno2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JPslide = new javax.swing.JPanel();
        panelSlide = new abogados.PanelSlide();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JCB_tipos = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButtonActualizar1 = new javax.swing.JButton();
        JPbuscar_abg = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPaneCam = new javax.swing.JScrollPane();
        TablaR = new javax.swing.JTable();
        JCb_parámetros = new javax.swing.JComboBox<>();
        jButtonModificarA8 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(34, 45, 49));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(65, 105, 225));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ABOGADOS-ECU");
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        jLabel2.setBackground(new java.awt.Color(0, 191, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("ONLINE");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 50, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DATOS PERSONALES");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, 40));

        jTextField1.setBackground(new java.awt.Color(54, 73, 80));
        jTextField1.setBorder(null);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 30));

        jPanel7.setBackground(new java.awt.Color(34, 45, 49));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("BUSCAR");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 29));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 220, 50));

        JPanel_explorar.setBackground(new java.awt.Color(34, 45, 49));
        JPanel_explorar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPanel_explorarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPanel_explorarMouseExited(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("EXPLORAR ABOGADOS");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });

        javax.swing.GroupLayout JPanel_explorarLayout = new javax.swing.GroupLayout(JPanel_explorar);
        JPanel_explorar.setLayout(JPanel_explorarLayout);
        JPanel_explorarLayout.setHorizontalGroup(
            JPanel_explorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        JPanel_explorarLayout.setVerticalGroup(
            JPanel_explorarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_explorarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.add(JPanel_explorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, 50));

        jPanel9.setBackground(new java.awt.Color(34, 45, 49));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("NOTIFICAIONES");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 220, 50));

        jPanel8.setBackground(new java.awt.Color(34, 45, 49));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("MIS DATOS");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel37MouseExited(evt);
            }
        });
        jLabel37.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel37KeyPressed(evt);
            }
        });
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 220, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 760));

        jPanel3.setBackground(new java.awt.Color(65, 105, 225));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 990, 40));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MODIFICAR_USUARIO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zyro-image (1).png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 48)); // NOI18N
        jLabel23.setText("MODIFICAR CLIENTE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 196, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MODIFICAR_USUARIO.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 150));

        jPanel6.setBackground(new java.awt.Color(211, 211, 211));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxtFldNombre1.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldNombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldNombre1KeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFldNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 118, -1));

        jLabel24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel24.setText("Nombres:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 87, -1));

        jLabel25.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel25.setText("Apellidos:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 87, 20));

        jTxtFldApellido1.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldApellido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldApellido1KeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFldApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 118, 20));

        jTxtFldNombre2.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldNombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldNombre2KeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFldNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 118, 20));

        jTxtFldApellido2.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldApellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldApellido2KeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFldApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 118, 20));

        jLabel26.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel26.setText("Cedula:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 87, 20));

        jTxtFldCedula.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldCedulaKeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 130, 20));

        jLabel27.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel27.setText("Telefono:");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 87, 41));

        jTxtFildTelefono.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFildTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFildTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFildTelefonoKeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFildTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 182, 130, 20));

        jLabel28.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel28.setText("Genero:");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 67, 41));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButton2.setText("Masculino");
        jPanel6.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 87, -1));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButton1.setText("Femenino");
        jPanel6.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 87, -1));

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jRadioButton3.setText("Sin especificar");
        jPanel6.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 110, -1));

        jLabel29.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel29.setText("Calle principal:");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 118, 41));

        jLabel30.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel30.setText("Año:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, 41));

        jPsswrdFldContraseña2.setBackground(new java.awt.Color(211, 211, 211));
        jPsswrdFldContraseña2.setText("jPasswordField1");
        jPsswrdFldContraseña2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel6.add(jPsswrdFldContraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 100, 20));

        jLblCorreo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLblCorreo.setText("Correo:");
        jPanel6.add(jLblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 63, 40));

        jTxtFldCorreo.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFldCorreoActionPerformed(evt);
            }
        });
        jPanel6.add(jTxtFldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 230, 20));

        jTxtFldCallePrincipal.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCallePrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCallePrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldCallePrincipalKeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFldCallePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 150, -1));

        jTxtFldCalleSecundaria.setBackground(new java.awt.Color(211, 211, 211));
        jTxtFldCalleSecundaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTxtFldCalleSecundaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldCalleSecundariaKeyTyped(evt);
            }
        });
        jPanel6.add(jTxtFldCalleSecundaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 150, -1));

        JFSfoto_Usuario.setBackground(new java.awt.Color(211, 211, 211));
        JFSfoto_Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(JFSfoto_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel31.setText("Calle secundaria:");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, 41));

        jLabelCon.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabelCon.setText("Contraseña:");
        jPanel6.add(jLabelCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, -1));

        jLabel32.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel32.setText("Contraseña:");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 90, -1));

        jPsswrdFldContraseña1.setBackground(new java.awt.Color(211, 211, 211));
        jPsswrdFldContraseña1.setText("jPasswordField1");
        jPsswrdFldContraseña1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel6.add(jPsswrdFldContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 100, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 204));
        jPanel6.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 950, 10));

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
        jPanel6.add(jBttnRegresarPanPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 170, 40));

        ocultarContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ocultar.png"))); // NOI18N
        ocultarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocultarContraMouseClicked(evt);
            }
        });
        jPanel6.add(ocultarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 50, 50));

        mostrarContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contraseña.png"))); // NOI18N
        mostrarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarContraMouseClicked(evt);
            }
        });
        jPanel6.add(mostrarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel33.setFont(new java.awt.Font("Algerian", 3, 12)); // NOI18N
        jLabel33.setText("Seleccione una Imagen");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, 150, -1));

        jLabel34.setFont(new java.awt.Font("MS PGothic", 3, 14)); // NOI18N
        jLabel34.setText("Fecha de Nacimiento:");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 160, 41));

        jLabel35.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel35.setText("Mes:");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, 20));

        Jspdia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Jspdia.setBorder(null);
        jPanel6.add(Jspdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 50, 30));

        JBxmes.setBackground(new java.awt.Color(211, 211, 211));
        JBxmes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        JBxmes.setBorder(null);
        JBxmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBxmesMouseClicked(evt);
            }
        });
        jPanel6.add(JBxmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 110, 30));

        jYearChooser1.setBackground(new java.awt.Color(211, 211, 211));
        jPanel6.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 60, 30));

        jLabel36.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel36.setText("Dia:");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, 41));

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
        jPanel6.add(jBttnRegresarPanPrincipal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 170, 40));

        MODIFICAR_USUARIO.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 980, 380));

        jPanel4.add(MODIFICAR_USUARIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 720));

        JPmenuinicio.setBackground(new java.awt.Color(236, 239, 244));
        JPmenuinicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        jLabel10.setText("DASBOHARD");
        JPmenuinicio.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 37, 241, 54));

        interno.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(102, 102, 226));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrella.png"))); // NOI18N
        jLabel11.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Comprometidos con nuestros");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText(" clientes y con la justicia");

        javax.swing.GroupLayout internoLayout = new javax.swing.GroupLayout(interno);
        interno.setLayout(internoLayout);
        internoLayout.setHorizontalGroup(
            internoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internoLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(internoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        internoLayout.setVerticalGroup(
            internoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(internoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        JPmenuinicio.add(interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 127, -1, -1));

        interno1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(136, 55, 55));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/candado.png"))); // NOI18N
        jLabel14.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Guardamos tu información");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("con la mayor seguridad");

        javax.swing.GroupLayout interno1Layout = new javax.swing.GroupLayout(interno1);
        interno1.setLayout(interno1Layout);
        interno1Layout.setHorizontalGroup(
            interno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interno1Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(interno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        interno1Layout.setVerticalGroup(
            interno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(interno1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        JPmenuinicio.add(interno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 337, 388, -1));

        interno2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setBackground(new java.awt.Color(113, 238, 113));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/monedas.png"))); // NOI18N
        jLabel17.setOpaque(true);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Tenemos gran variedad de ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("tarifas, adaptables a tu bolsillo");

        javax.swing.GroupLayout interno2Layout = new javax.swing.GroupLayout(interno2);
        interno2.setLayout(interno2Layout);
        interno2Layout.setHorizontalGroup(
            interno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interno2Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(interno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        interno2Layout.setVerticalGroup(
            interno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(interno2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        JPmenuinicio.add(interno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 544, -1, -1));

        jPanel4.add(JPmenuinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        JPslide.setBackground(new java.awt.Color(255, 255, 255));
        JPslide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSlide.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout panelSlideLayout = new javax.swing.GroupLayout(panelSlide);
        panelSlide.setLayout(panelSlideLayout);
        panelSlideLayout.setHorizontalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        panelSlideLayout.setVerticalGroup(
            panelSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );

        JPslide.add(panelSlide, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 23, -1, -1));

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        JPslide.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 326, 47, -1));

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        JPslide.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 381, 48, -1));

        JCB_tipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        JPslide.add(JCB_tipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 154, 146, 39));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ESPECIALIDAD");
        JPslide.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 106, 147, 40));

        jButtonActualizar.setBackground(new java.awt.Color(0, 0, 0));
        jButtonActualizar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizar.setText("MOSTRAR");
        jButtonActualizar.setBorder(null);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        JPslide.add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 152, 110, 38));

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        JPslide.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 472, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("DESCRIPCION DEL CONTRATO");
        JPslide.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 426, 292, 40));

        jButtonActualizar1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonActualizar1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizar1.setText("CONTRATAR");
        jButtonActualizar1.setBorder(null);
        jButtonActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar1ActionPerformed(evt);
            }
        });
        JPslide.add(jButtonActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 651, 187, 40));

        jPanel4.add(JPslide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 993, 720));

        JPbuscar_abg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        JPbuscar_abg.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 101, 202, 41));

        jLabel5.setText("INGRESE EL PARÁMETRO DE BUSQUEDA:");
        JPbuscar_abg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 202, 41));

        TablaR.setBackground(new java.awt.Color(255, 160, 122));
        TablaR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        TablaR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "TELEFONO", "GRATUIDAD", "COSTO_X_HORAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaR.setRowHeight(30);
        TablaR.getTableHeader().setReorderingAllowed(false);
        TablaR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaRMouseClicked(evt);
            }
        });
        jScrollPaneCam.setViewportView(TablaR);

        JPbuscar_abg.add(jScrollPaneCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 375, 751, 290));

        JCb_parámetros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "NOMBRE", "APELLIDO", "CÉDULA" }));
        JPbuscar_abg.add(JCb_parámetros, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 101, 118, 41));

        jButtonModificarA8.setBackground(new java.awt.Color(136, 55, 55));
        jButtonModificarA8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButtonModificarA8.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificarA8.setText("BUSCAR");
        jButtonModificarA8.setBorder(null);
        jButtonModificarA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarA8ActionPerformed(evt);
            }
        });
        JPbuscar_abg.add(jButtonModificarA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 101, 134, 41));

        jPanel4.add(JPbuscar_abg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 980, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        indice = indice - 1;
        if (indice < 0) {
            JOptionPane.showMessageDialog(null, "ESTE ES EL PRIMER ABOGADO");
        } else {
            panelSlide.show(indice);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        indice = indice + 1;
        if (indice == interfaz.size()) {

            JOptionPane.showMessageDialog(null, "ESTE ES EL ÚLTIMO ABOGADO");
        } else {
            if (indice >= panelSlide.tamaño()) {
                String nombre = interfaz.get(indice).getNombrecompleto();
                String especializacion = interfaz.get(indice).getEspecialización();
                String ruta = interfaz.get(indice).getFoto();
                String telefono = interfaz.get(indice).getTelefono();
                String correo = interfaz.get(indice).getCorreo();
                double costo = interfaz.get(indice).getCostohoras();
                if (indice % 2 == 0) {
                    panelSlide.primerelemento(new Paneltest(nombre, new Color(188, 143, 143), especializacion, ruta, costo, telefono, correo));
                } else {
                    panelSlide.primerelemento(new Paneltest(nombre, new Color(218, 165, 32), especializacion, ruta, costo, telefono, correo));
                }

                panelSlide.show(indice);
            } else {
                panelSlide.show(indice);
            }

            //        if(indice % 2 =0){
            //
            //        }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        if (JCB_tipos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA ESPECIALIDAD");
        } else {
            MOSTRAR_CLIENTES objeto = new MOSTRAR_CLIENTES();

            try {
                interfaz = objeto.mostrarcli(buscarID_diploma());
                if (interfaz.size() == 0) {
                    JOptionPane.showMessageDialog(null, "NO TENEMOS ABOGADOS REGISTRADOS CON ESTA ESPECIALIDAD");
                } else {
                    String nombre = interfaz.get(indice).getNombrecompleto();
                    String especializacion = interfaz.get(indice).getEspecialización();
                    String ruta = interfaz.get(indice).getFoto();
                    String telefono = interfaz.get(indice).getTelefono();
                    String correo = interfaz.get(indice).getCorreo();
                    double costo = interfaz.get(indice).getCostohoras();
                    JOptionPane.showMessageDialog(null, "TENEMOS DISPONIBLES " + interfaz.size() + " ABOGADOS CON ESTA ESPECIALIDAD");
                    panelSlide.init(new Paneltest(nombre, new Color(255, 228, 196), especializacion, ruta, costo, telefono, correo));
                }

            } catch (SQLException ex) {
                Logger.getLogger(DasbohardClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar1ActionPerformed
        if (interfaz.size() == 0) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA ESPECIALIDAD ");
        } else {

            int response = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE CONTRATAR A ESTE ABOGADO?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    contrato contrato = new contrato();
                    contrato.setFK_ID_abg(interfaz.get(indice).getID_abg());
                    contrato.setDescripcion(descripcion.getText());
                    contrato.setID_cli(Login.cliente.ID_cliente());
                    contrato.setFecha_caso(LocalDateTime.now());
                    contrato.Insert();
                    JOptionPane.showMessageDialog(null, "SE SOLICITÓ EL CONTRATO AL ABOGADO,"
                            + "EN UN PERIODO MÁSIMO DE 24 HORAS TENDRÁ UNA CONFIRMACIÓN");
                } catch (SQLException ex) {
                    Logger.getLogger(administradorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR EN EL PROCESO DE ELIMINACION");
                }

            } else {
                JOptionPane.showMessageDialog(null, "SE HA CANCELADO LA  ACCION DE ELIMINAR");
            }
        }
    }//GEN-LAST:event_jButtonActualizar1ActionPerformed

    private void JPanel_explorarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanel_explorarMouseEntered

    }//GEN-LAST:event_JPanel_explorarMouseEntered

    private void JPanel_explorarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanel_explorarMouseExited

    }//GEN-LAST:event_JPanel_explorarMouseExited

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        jPanel9.setBackground(new Color(145, 145, 145));
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        jPanel9.setBackground(new Color(34, 45, 49));
    }//GEN-LAST:event_jPanel9MouseExited

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
       JPmenuinicio.setVisible(false);
        JPslide.setVisible(true);
        JPbuscar_abg.setVisible(false);
        MODIFICAR_USUARIO.setVisible(false);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        JPanel_explorar.setBackground(new Color(145, 145, 145));
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        JPanel_explorar.setBackground(new Color(34, 45, 49));
    }//GEN-LAST:event_jLabel20MouseExited

    private void TablaRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaRMouseClicked

    }//GEN-LAST:event_TablaRMouseClicked

    private void jButtonModificarA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarA8ActionPerformed

    }//GEN-LAST:event_jButtonModificarA8ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

        if (JCb_parámetros.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN PARÁMETRO DE BUSQUEDA");
        } else {
            String param1 = parámetro();
            if (param1.equals("INVÁLIDO")) {
                JOptionPane.showMessageDialog(null, "EL PARÁMETRO NO ES VÁLIDO PARA LA BUSQUEDA");
            } else {
                try {
                    ArrayList<abogado> lista = buscar.buscar_CLI(param1, jTextField2.getText().toUpperCase());
                    limpiar();
                    mostrarABG(lista);
                } catch (SQLException ex) {
                    Logger.getLogger(DasbohardClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jPanel7.setBackground(new Color(145, 145, 145));
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jPanel7.setBackground(new Color(34, 45, 49));
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        JPmenuinicio.setVisible(false);
        JPslide.setVisible(false);
        JPbuscar_abg.setVisible(true);
        MODIFICAR_USUARIO.setVisible(false);
    }//GEN-LAST:event_jLabel22MouseClicked

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

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        JPmenuinicio.setVisible(false);
        JPslide.setVisible(false);
        JPbuscar_abg.setVisible(false);
        MODIFICAR_USUARIO.setVisible(true);
        try {
            modificarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(DasbohardClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel37KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel37KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37KeyPressed

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
    jPanel9.setBackground(new Color(145, 145, 145));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
        jPanel8.setBackground(new Color(145, 145, 145));
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseExited
         jPanel8.setBackground(new Color(34, 45, 49));
    }//GEN-LAST:event_jLabel37MouseExited

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
            java.util.logging.Logger.getLogger(DasbohardClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DasbohardClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DasbohardClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DasbohardClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DasbohardClientes().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DasbohardClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JBxmes;
    private javax.swing.JComboBox<String> JCB_tipos;
    private javax.swing.JComboBox<String> JCb_parámetros;
    private rojerusan.RSFotoSquare JFSfoto_Usuario;
    private javax.swing.JPanel JPanel_explorar;
    private javax.swing.JPanel JPbuscar_abg;
    private javax.swing.JPanel JPmenuinicio;
    private javax.swing.JPanel JPslide;
    private javax.swing.JSpinner Jspdia;
    private javax.swing.JPanel MODIFICAR_USUARIO;
    private javax.swing.JTable TablaR;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JPanel interno;
    private javax.swing.JPanel interno1;
    private javax.swing.JPanel interno2;
    private javax.swing.JButton jBttnRegresarPanPrincipal;
    private javax.swing.JButton jBttnRegresarPanPrincipal1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonActualizar1;
    private javax.swing.JButton jButtonModificarA8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPsswrdFldContraseña1;
    private javax.swing.JPasswordField jPsswrdFldContraseña2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneCam;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
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
    private abogados.PanelSlide panelSlide;
    // End of variables declaration//GEN-END:variables
}
