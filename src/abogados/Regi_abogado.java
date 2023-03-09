/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import static abogados.Regi_Asistente.validarCedula;
import clases.Direcciones;
import clases.Especializacion;
import clases.TIPO_diplomnma;
import clases.abogado;
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
 * @author Steven Zhicay
 */
public class Regi_abogado extends javax.swing.JFrame {

    public Regi_abogado() {
        initComponents();
        setLocationRelativeTo(null);
        Internal.setVisible(false);
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

    public void valced() {
        String ced = cedula_abogado.getText();
        boolean esValida = validarCedula(ced);
        if (esValida) {
            validar();
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
        return true;
    }

    public void validar() {
        if (cedula_abogado.getText().matches("^[0-9]{10}$")) {
            if (nombre1.getText().matches("[a-z]+") && nombre2.getText().matches("[a-z]+")) {
                if (apellido1.getText().matches("[a-z]+") && apellido2.getText().matches("^[a-z]+")) {

                    if (telefono.getText().matches("^[0-9]{10}$")) {
                        if (direccion1.getText().matches("[a-z]+$") && direccion2.getText().matches("[a-z]+$")) {
                            InserBase();
                        } else {
                            JOptionPane.showMessageDialog(this, "DIRECCION INGRESADO INCORRECTA");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "TELEFONO INGRESADO INCORRECTA");
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

    public void InserBase() {
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
                    Direcciones direccion_admin = new Direcciones();
                    direccion_admin.setCalle_principal(direccion1.getText());
                    direccion_admin.setCalle_secundaria(direccion2.getText());
                    direccion_admin.setSucursal(false);

                    double auxcost = Double.parseDouble(costo.getText());
                    try {
                        direccion_admin.Ingresar();
                        int id = 0;
                        String id_direccion = "SELECT id_direccion FROM direcciones where calle_principal ='" + direccion1.getText() + "' and calle_secundaria ='" + direccion2.getText() + "'";
                        id = direccion_admin.Seleccionar(id_direccion);
                        System.out.println(id);
                        abogado nuevo = new abogado();
                        nuevo.setCedula(cedula_abogado.getText());
                        nuevo.setPrimerNombre(nombre1.getText());
                        nuevo.setSegundoNombre(nombre2.getText());
                        nuevo.setNombreApellido(apellido1.getText());
                        nuevo.setSegundoApellido(apellido2.getText());
                        nuevo.setCost_hora(auxcost);
                        nuevo.setPassword(contra);
                        nuevo.setGenero(genero);
                        nuevo.setGratuidad(auxGratudad);
                        nuevo.setFecha_nacimiento(fechaHora);
                        nuevo.setTitulo(titulos.getText());
                        nuevo.setFoto_perfil(foto.getRutaImagen());
                        nuevo.setFK_direccion(id);
                        nuevo.setTelefono(telefono.getText());
                        nuevo.Insertar();
                        String selecABG = "SELECT id_abg FROM abogado WHERE cedula_abg = '" + nuevo.getCedula() + "'";
                        if (TXT_nombre.getText().equals("")) {

                        } else {
                            estatica.setFK_id_agb(nuevo.Seleccionar(selecABG));
                            estatica.Ingresar();
                        }
                        JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA ECU-ABOGADOS");

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN EL INGRESO");
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

        genero_abogado = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Internal = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TXT_instituciòn = new javax.swing.JTextField();
        TXT_nombre = new javax.swing.JTextField();
        JSp_año_inicio = new com.toedter.components.JSpinField();
        JSP_año_fin = new com.toedter.components.JSpinField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        TIPO_diploma = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
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
        cedula_abogado = new javax.swing.JTextField();
        m = new javax.swing.JRadioButton();
        f = new javax.swing.JRadioButton();
        direccion2 = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        costo = new javax.swing.JTextField();
        s = new javax.swing.JRadioButton();
        n = new javax.swing.JRadioButton();
        titulos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(169, 169, 169));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Internal.setIconifiable(true);
        Internal.setMaximizable(true);
        Internal.setResizable(true);
        Internal.setVisible(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setDoubleBuffered(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel4.setText("ESPECIALIDAD");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 28));

        jLabel17.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel17.setText("INSTITUCIÒN:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 130, 15));

        jLabel21.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel21.setText("AÑO DE INICIO:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 22));

        TXT_instituciòn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_instituciònActionPerformed(evt);
            }
        });
        jPanel3.add(TXT_instituciòn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 190, 30));
        jPanel3.add(TXT_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 115, 190, 30));
        jPanel3.add(JSp_año_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 70, 30));
        jPanel3.add(JSP_año_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 70, 30));

        jButton3.setText("REGISTRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 114, 33));

        jButton4.setText("REGRESAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 119, 33));

        jLabel23.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel23.setText("TIPO DE DIPLOMA:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 150, 20));

        jLabel22.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel22.setText("NOMBRE:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        TIPO_diploma.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        TIPO_diploma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIPO_diplomaActionPerformed(evt);
            }
        });
        jPanel3.add(TIPO_diploma, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 160, 40));

        jLabel24.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jLabel24.setText("AÑO GRADUCION:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        Internal.getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(Internal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 630, 410));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 77, 25));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 94, 22));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Cédula:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 60, 27));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Género:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 65, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Calle secundaria:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, 24));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setText("Seleccione una foto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setText("Gratuidad:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, 94, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setText("Título:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, -1));
        jPanel1.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 143, 33));

        nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre2ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 127, 33));

        apellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido2ActionPerformed(evt);
            }
        });
        jPanel1.add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 127, 33));
        jPanel1.add(apellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 143, 33));

        cedula_abogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_abogadoActionPerformed(evt);
            }
        });
        jPanel1.add(cedula_abogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 143, 32));

        genero_abogado.add(m);
        m.setText("Maculino");
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });
        jPanel1.add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 93, -1));

        genero_abogado.add(f);
        f.setText("Femenino");
        jPanel1.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 93, -1));
        jPanel1.add(direccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 140, 32));
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 140, 33));

        costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoActionPerformed(evt);
            }
        });
        jPanel1.add(costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 105, 33));

        buttonGroup2.add(s);
        s.setText("SI");
        jPanel1.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, 110, -1));

        buttonGroup2.add(n);
        n.setText("NO");
        jPanel1.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 540, 93, -1));
        jPanel1.add(titulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 600, 105, 30));

        jButton1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jButton1.setText("Ingresar especialización");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 670, -1, 31));

        jPanel2.setBackground(new java.awt.Color(139, 69, 19));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Screenshot_2.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 330, 160));

        jLabel14.setFont(new java.awt.Font("Constantia", 2, 48)); // NOI18N
        jLabel14.setText("Registro de abogados");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 510, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 950, 160));
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel11.setText("Costo por hora:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, -1, -1));

        jButton2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jButton2.setText("Registrarse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 670, -1, 31));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Día:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 40, 30));
        jPanel1.add(Jspdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 60, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Mes:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 40, 30));

        JBxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        JBxmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBxmesMouseClicked(evt);
            }
        });
        jPanel1.add(JBxmes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 90, 30));
        jPanel1.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 60, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Año:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 40, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 170, 20));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setText("Calle proncipal:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, 24));
        jPanel1.add(direccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 140, 32));

        contraseña.setText("jPasswordField1");
        jPanel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, 140, 30));

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel20.setText("Teléfono:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 940, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBxmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBxmesMouseClicked

    }//GEN-LAST:event_JBxmesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cedula_abogado.getText().equals("") || telefono.getText().equals("") || costo.getText().equals("") || titulos.getText().equals("") || nombre1.getText().equals("") || nombre2.getText().equals("") || apellido1.getText().equals("") || apellido2.getText().equals("") || direccion1.getText().equals("") || apellido2.getText().equals("") || genero_abogado.isSelected(null)) {
            JOptionPane.showMessageDialog(null, "CAMPOS VACIOS NO ES POSIBLE GUARDAR");
        } else {
            validar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Internal.setVisible(true);
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


    }//GEN-LAST:event_jButton1ActionPerformed

    private void costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costoActionPerformed

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mActionPerformed

    private void cedula_abogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_abogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedula_abogadoActionPerformed

    private void apellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido2ActionPerformed

    private void nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (TXT_instituciòn.getText().equals("") || TXT_nombre.getText().equals("") || TIPO_diploma.getSelectedItem().toString().equals("SELECCIONE")) {
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS");
            System.out.println();
        } else {
            LocalDate fecha = LocalDate.now(); // fecha actual
            int año = fecha.getYear();
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
                    JOptionPane.showMessageDialog(null, "SE HA INGRESADO SU ESPECIALIZACIÒN");
                    Internal.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Internal.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TXT_instituciònActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_instituciònActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_instituciònActionPerformed

    private void TIPO_diplomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIPO_diplomaActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Regi_abogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Regi_abogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Regi_abogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Regi_abogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Regi_abogado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Internal;
    private javax.swing.JComboBox<String> JBxmes;
    private com.toedter.components.JSpinField JSP_año_fin;
    private com.toedter.components.JSpinField JSp_año_inicio;
    private javax.swing.JSpinner Jspdia;
    private javax.swing.JComboBox<String> TIPO_diploma;
    private javax.swing.JTextField TXT_instituciòn;
    private javax.swing.JTextField TXT_nombre;
    private javax.swing.JTextField apellido1;
    private javax.swing.JTextField apellido2;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField cedula_abogado;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JTextField costo;
    private javax.swing.JTextField direccion1;
    private javax.swing.JTextField direccion2;
    private javax.swing.JRadioButton f;
    private rojerusan.RSFotoSquare foto;
    private javax.swing.ButtonGroup genero_abogado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JRadioButton m;
    private javax.swing.JRadioButton n;
    private javax.swing.JTextField nombre1;
    private javax.swing.JTextField nombre2;
    private javax.swing.JRadioButton s;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField titulos;
    // End of variables declaration//GEN-END:variables
}
