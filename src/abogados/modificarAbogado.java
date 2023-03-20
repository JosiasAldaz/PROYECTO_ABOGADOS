/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import static abogados.Regi_abogado.nombre1;
import clases.Administrador;
import clases.Direcciones;
import clases.Especializacion;
import clases.PostgresConexion;
import clases.TIPO_diplomnma;
import clases.abogado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class modificarAbogado extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public modificarAbogado() {
        initComponents();
    }

    Especializacion estatica = new Especializacion();
    ArrayList<TIPO_diplomnma> rellenar = new ArrayList();

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

    public int ID_TIPO(String nombre) {
        int id = 0;
        for (int i = 0; i < rellenar.size(); i++) {
            if (rellenar.get(i).getNombre_diplo().equals(nombre)) {
                id = rellenar.get(i).getID_diploma();
            } else {

            }
        }
        return id;
    }
public void validar() throws SQLException {
        if (cedula.getText().matches("^[0-9]{10}$")) {
            if (nombre1.getText().matches("[a-z]+||[A-Z]+") && nombre2.getText().matches("[a-z]+||[A-Z]+")) {
                if (apellido1.getText().matches("[a-z]+||[A-Z]+") && apellido2.getText().matches("^[a-z]+||[A-Z]+")) {
//                    if (correo.getText().matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                        if (telefono.getText().matches("^[0-9]{10}$")) {
                            if (direccion1.getText().matches("^[\\w\\s.,-]+$") && direccion2.getText().matches("^[\\w\\s.,-]+$")) {
                                //if (contraseña3.equals(contraseña4)) {
                                InserBase();

                            } else {
                                JOptionPane.showMessageDialog(this, "DIRECCION INGRESADO INCORRECTA");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "TELEFONO INGRESADO INCORRECTA");
                        }
//                    } else {
//                        JOptionPane.showMessageDialog(this, "CORREO INGRESADO INCORRECTA");
//                    }
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
    public void InserBase() throws SQLException {
        int anio = jYearChooser1.getYear();
        int dia = Integer.parseInt(Jspdia.getValue().toString());
        String contra = new String(contraseña.getPassword());
        char genero = '\0';
        boolean auxGratudad = false;

        if (m.isSelected()) {
            genero = 'F';

        }
        if (f.isSelected()) {
            genero = 'F';

        }
        if (s.isSelected()) {
            auxGratudad = true;

        }
        if (n.isSelected()) {
            auxGratudad = false;

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
                    PostgresConexion conexion = new PostgresConexion();
                    abogado abg = new abogado();
                    abg.setCedula(cedula.getText());
                    String sql = "SELECT * FROM ABOGADO WHERE  cedula_abg='" + abg.getCedula() + "'";
                    ResultSet contenedor = conexion.Consulta(sql);
                    Direcciones direc = new Direcciones();
                    Especializacion estatica = new Especializacion();
                    while (contenedor.next()) {
                        int k = contenedor.getInt("fk_id_direcc_abg");
                        direc.setId_direccion(k);
                        String sql1 = "SELECT * FROM public.direcciones WHERE id_direccion='" + direc.getId_direccion() + "'";
                        ResultSet contenedor1 = conexion.Consulta(sql1);
                        while (contenedor1.next()) {

                            direc.setCalle_principal(direccion1.getText());
                            direc.setCalle_secundaria(direccion2.getText());
                            direc.setSucursal(false);

                        }

                        double auxcost = Double.parseDouble(costo.getText());
                        try {
                            direc.modificar_direccion();
                            abg.setPrimerNombre(nombre1.getText());
                            abg.setSegundoNombre(nombre2.getText());
                            abg.setNombreApellido(apellido1.getText());
                            abg.setSegundoApellido(apellido2.getText());
                            abg.setCost_hora(auxcost);
                            abg.setPassword(contra);
                            abg.setGenero(genero);
                            abg.setGratuidad(auxGratudad);
                            abg.setFecha_nacimiento(fechaHora);
                            abg.setTitulo(titulos.getText());
                            abg.setFoto_perfil(foto.getRutaImagen());
                            abg.setTelefono(telefono.getText());
                            abg.Modificar_abogado();
                            String selecABG1 = "SELECT id_abg FROM abogado WHERE cedula_abg = '" + abg.getCedula() + "'";
                            if (Respecialidad.isSelected()) {
                                if (TXT_instituciòn.getText().equals("") || TXT_nombre.getText().equals("") || TIPO_diploma.getSelectedItem().toString().equals("SELECCIONE")) {
                                    JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS");
                                    System.out.println();
                                } else {

                                    LocalDate fecha1 = LocalDate.now(); // fecha actual
                                    int año = fecha1.getYear();
                                    if (JSp_año_inicio.getValue() == año || JSp_año_inicio.getValue() > año) {
                                        JOptionPane.showMessageDialog(null, "EL AÑO DE INICIO NO PUEDE SER EL MISMO QUE EL PRESENTE AÑO");
                                    } else {
                                        if (JSP_año_fin.getValue() == año || JSP_año_fin.getValue() > año) {
                                            JOptionPane.showMessageDialog(null, "EL AÑO DE FINALIZACION NO PUEDE SER EL MISMO QUE EL PRESENTE AÑO");
                                        } else {
                                            estatica.setFK_ID_tipo(ID_TIPO(TIPO_diploma.getSelectedItem().toString()));
                                            estatica.setFecha_fin(JSP_año_fin.getValue());
                                            estatica.setFecha_inicio(JSp_año_inicio.getValue());
                                            estatica.setNombre(TXT_nombre.getText());
                                            estatica.setUniverdadad(TXT_instituciòn.getText());
                                        }
                                    }
                                }
                                estatica.setFK_id_agb(abg.Seleccionar(selecABG1));
                                estatica.Ingresar_Especialidad();
                            } else {
                                String selecABG = "SELECT *FROM public.especialidad  ";
                                ResultSet contenedor3 = conexion.Consulta(selecABG);
                                while (contenedor3.next()) {
                                    if (contenedor3.getInt("fk_id_agb") == (contenedor.getInt("id_abg"))) {
                                        estatica.setFK_id_agb(contenedor3.getInt("fk_id_agb"));
                                        estatica.setFecha_fin(JSP_año_fin.getValue());
                                        estatica.setFecha_inicio(JSp_año_inicio.getValue());
                                        estatica.setNombre(TXT_nombre.getText());
                                        estatica.setUniverdadad(TXT_instituciòn.getText());
                                        estatica.modificarEspecialidad();
                                    }
                                }

                            }

                            JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA ECU-ABOGADOS");

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

        geneo = new javax.swing.ButtonGroup();
        gratis = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JTextField();
        nombre2 = new javax.swing.JTextField();
        apellido2 = new javax.swing.JTextField();
        apellido1 = new javax.swing.JTextField();
        cedula = new javax.swing.JTextField();
        m = new javax.swing.JRadioButton();
        f = new javax.swing.JRadioButton();
        direccion2 = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        costo = new javax.swing.JTextField();
        s = new javax.swing.JRadioButton();
        n = new javax.swing.JRadioButton();
        titulos = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        foto = new rojerusan.RSFotoSquare();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        Jspdia = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        JBxmes = new javax.swing.JComboBox<>();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        direccion1 = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        regresar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TXT_instituciòn = new javax.swing.JTextField();
        TXT_nombre = new javax.swing.JTextField();
        JSp_año_inicio = new com.toedter.components.JSpinField();
        JSP_año_fin = new com.toedter.components.JSpinField();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        TIPO_diploma = new javax.swing.JComboBox<>();
        Respecialidad = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(211, 211, 211));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 77, 25));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel2.setText("Apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 80, 22));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel3.setText("Cédula:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 60, 20));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel5.setText("Género:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 65, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel6.setText("Calle secundaria:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, 24));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel7.setText(" Contraseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bernard MT Condensed", 3, 14)); // NOI18N
        jLabel8.setText("Seleccione una foto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel9.setText("Gratuidad:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 94, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel10.setText("Título:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        nombre1.setBackground(new java.awt.Color(211, 211, 211));
        nombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre1KeyTyped(evt);
            }
        });
        jPanel1.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 120, 20));

        nombre2.setBackground(new java.awt.Color(211, 211, 211));
        nombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre2ActionPerformed(evt);
            }
        });
        nombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre2KeyTyped(evt);
            }
        });
        jPanel1.add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 120, 20));

        apellido2.setBackground(new java.awt.Color(211, 211, 211));
        apellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        apellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido2ActionPerformed(evt);
            }
        });
        apellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido2KeyTyped(evt);
            }
        });
        jPanel1.add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 120, 20));

        apellido1.setBackground(new java.awt.Color(211, 211, 211));
        apellido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        apellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido1KeyTyped(evt);
            }
        });
        jPanel1.add(apellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 120, 20));

        cedula.setBackground(new java.awt.Color(211, 211, 211));
        cedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 143, 20));

        geneo.add(m);
        m.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        m.setText("Maculino");
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });
        jPanel1.add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 93, 20));

        geneo.add(f);
        f.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f.setText("Femenino");
        jPanel1.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 93, 20));

        direccion2.setBackground(new java.awt.Color(211, 211, 211));
        direccion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        direccion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccion2KeyTyped(evt);
            }
        });
        jPanel1.add(direccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 160, 20));

        telefono.setBackground(new java.awt.Color(211, 211, 211));
        telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 140, 20));

        costo.setBackground(new java.awt.Color(211, 211, 211));
        costo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoActionPerformed(evt);
            }
        });
        costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoKeyTyped(evt);
            }
        });
        jPanel1.add(costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 70, 20));

        gratis.add(s);
        s.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        s.setText("SI");
        jPanel1.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 40, -1));

        gratis.add(n);
        n.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        n.setText("NO");
        jPanel1.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 50, -1));

        titulos.setBackground(new java.awt.Color(211, 211, 211));
        titulos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(titulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 110, 20));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Constantia", 2, 48)); // NOI18N
        jLabel14.setText("MODIFICAR ABOGADO");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 540, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zyro-image (1).png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 950, 160));

        foto.setBackground(new java.awt.Color(211, 211, 211));
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel11.setText("Costo por hora:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jButton2.setBackground(new java.awt.Color(245, 222, 179));
        jButton2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/disco-flexible.png"))); // NOI18N
        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 630, 190, 50));

        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel18.setText("Día:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 40, 30));
        jPanel1.add(Jspdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 50, 30));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel19.setText("Mes:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 40, 30));

        JBxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        JBxmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBxmesMouseClicked(evt);
            }
        });
        jPanel1.add(JBxmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 100, 30));
        jPanel1.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 60, 30));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel15.setText("Año:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 40, 30));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel16.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 170, 20));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel12.setText("Calle proncipal:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, 24));

        direccion1.setBackground(new java.awt.Color(211, 211, 211));
        direccion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        direccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccion1KeyTyped(evt);
            }
        });
        jPanel1.add(direccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 160, 20));

        contraseña.setBackground(new java.awt.Color(211, 211, 211));
        contraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 140, 20));

        regresar.setBackground(new java.awt.Color(245, 222, 179));
        regresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hame.png"))); // NOI18N
        regresar.setText("Pantalla Principal");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        jPanel1.add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, 190, 50));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel20.setText(" Teléfono:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, -1, -1));

        jPanel3.setBackground(new java.awt.Color(211, 211, 211));
        jPanel3.setDoubleBuffered(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel13.setText("ESPECIALIDAD");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 28));

        jLabel17.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel17.setText("INSTITUCIÒN:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 15));

        jLabel21.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel21.setText("AÑO DE INICIO:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 22));

        TXT_instituciòn.setBackground(new java.awt.Color(211, 211, 211));
        TXT_instituciòn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TXT_instituciòn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_instituciònActionPerformed(evt);
            }
        });
        TXT_instituciòn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_instituciònKeyTyped(evt);
            }
        });
        jPanel3.add(TXT_instituciòn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 190, 30));

        TXT_nombre.setBackground(new java.awt.Color(211, 211, 211));
        TXT_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TXT_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_nombreActionPerformed(evt);
            }
        });
        TXT_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_nombreKeyTyped(evt);
            }
        });
        jPanel3.add(TXT_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 190, 30));

        JSp_año_inicio.setBackground(new java.awt.Color(211, 211, 211));
        jPanel3.add(JSp_año_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 70, 30));

        JSP_año_fin.setBackground(new java.awt.Color(211, 211, 211));
        jPanel3.add(JSP_año_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 70, 30));

        jLabel23.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel23.setText("TIPO DE DIPLOMA:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 20));

        jLabel22.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel22.setText("NOMBRE:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel24.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel24.setText("AÑO GRADUCION:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        TIPO_diploma.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        TIPO_diploma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));
        TIPO_diploma.setSelectedIndex(-1);
        TIPO_diploma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIPO_diplomaActionPerformed(evt);
            }
        });
        jPanel3.add(TIPO_diploma, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 150, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 370, 280));

        Respecialidad.setText("REGISTRAR  ESPECIALIDAD");
        jPanel1.add(Respecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_nombre1KeyTyped

    private void nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre2ActionPerformed

    private void nombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_nombre2KeyTyped

    private void apellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido2ActionPerformed

    private void apellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_apellido2KeyTyped

    private void apellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_apellido1KeyTyped

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITEN NUMEROS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cedulaKeyTyped

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mActionPerformed

    private void direccion2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccion2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_direccion2KeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITEN NUMEROS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costoActionPerformed

    private void costoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITEN NUMEROS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_costoKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESE HACER ESTOS CAMBIO?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == 0) {
            try {
                validar();
            } catch (SQLException ex) {
                Logger.getLogger(modificarAbogado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JBxmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBxmesMouseClicked

    }//GEN-LAST:event_JBxmesMouseClicked

    private void direccion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccion1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_direccion1KeyTyped

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
       
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void TXT_instituciònActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_instituciònActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_instituciònActionPerformed

    private void TXT_instituciònKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_instituciònKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_TXT_instituciònKeyTyped

    private void TXT_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_nombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "SOLO SE PERMITAN LETRAS", "ADVERTENCIA ", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_TXT_nombreKeyTyped

    private void TXT_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_nombreActionPerformed

    private void TIPO_diplomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIPO_diplomaActionPerformed
        TIPO_diplomnma combo = new TIPO_diplomnma();
        try {
            rellenar = combo.mostrar();
            rellenar.stream().forEach(tipos -> {
                if (TIPO_diploma.getItemCount() == 0) {
                    TIPO_diploma.addItem("SELECCIONE");
                }
                TIPO_diploma.addItem(tipos.getNombre_diplo());
            });
        } catch (SQLException ex) {
            Logger.getLogger(Regi_abogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TIPO_diplomaActionPerformed

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
            java.util.logging.Logger.getLogger(modificarAbogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarAbogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarAbogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarAbogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarAbogado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> JBxmes;
    public static com.toedter.components.JSpinField JSP_año_fin;
    public static com.toedter.components.JSpinField JSp_año_inicio;
    public static javax.swing.JSpinner Jspdia;
    private javax.swing.JCheckBox Respecialidad;
    private javax.swing.JComboBox<String> TIPO_diploma;
    public static javax.swing.JTextField TXT_instituciòn;
    public static javax.swing.JTextField TXT_nombre;
    public static javax.swing.JTextField apellido1;
    public static javax.swing.JTextField apellido2;
    public static javax.swing.JTextField cedula;
    public static javax.swing.JPasswordField contraseña;
    public static javax.swing.JTextField costo;
    public static javax.swing.JTextField direccion1;
    public static javax.swing.JTextField direccion2;
    private javax.swing.JRadioButton f;
    public static rojerusan.RSFotoSquare foto;
    public static javax.swing.ButtonGroup geneo;
    private javax.swing.ButtonGroup gratis;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JRadioButton m;
    private javax.swing.JRadioButton n;
    public static javax.swing.JTextField nombre1;
    public static javax.swing.JTextField nombre2;
    private javax.swing.JButton regresar;
    private javax.swing.JRadioButton s;
    public static javax.swing.JTextField telefono;
    public static javax.swing.JTextField titulos;
    // End of variables declaration//GEN-END:variables
}
