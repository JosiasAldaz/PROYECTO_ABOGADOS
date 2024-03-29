/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package abogados;

import clases.ENC_Factura;
import clases.MOSTRAR_facturas;
import clases.Mostrar_contrato;
import clases.abogado;
import clases.factura;
import desplazable.Desface;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ASUS
 */
public class abogadoInterfaz2 extends javax.swing.JFrame {

    /**
     * Creates new form abogadoInterfaz
     */
    Desface desplace;

    public abogadoInterfaz2() {
        initComponents();
//        setLocationRelativeTo(this);
        ContratosVigentes.setVisible(false);
        VentanaContratosEspera.setVisible(false);
        VentanaAsistenteAsignado.setVisible(false);
        desplace = new Desface();
        desplace.desplazarIzquierda(MenuDesplegable, MenuDesplegable.getX(), -160, 10, 0);
    }

    ////////////////////////////datos de casos/////////////////////////////////////////////
    public void mosterarCONTRATOS(ArrayList<Mostrar_contrato> lista_tipo) {
        // Para darle forma al modelo de la tabla
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) contra.getModel();
        mTabla.setNumRows(0);
        // Uso de una expresion landa
        lista_tipo.stream().forEach(tipos -> {
            String[] filaNueva = {String.valueOf(tipos.getID_cliente()),String.valueOf(tipos.getCedula_cli()), tipos.getNombre_cliu(), tipos.getApellido_cli(), String.valueOf(tipos.getID_contrato()), tipos.getDescripcion(),String.valueOf(tipos.getFecha())};
            mTabla.addRow(filaNueva);
        });
        contra.setModel(mTabla);
        columnascontra();
    }
    
    public void mosterarCONTAPROBADOS(ArrayList<Mostrar_contrato> lista_tipo) {
        // Para darle forma al modelo de la tabla
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) contra2.getModel();
        mTabla.setNumRows(0);
        // Uso de una expresion landa
        lista_tipo.stream().forEach(tipos -> {
            String[] filaNueva = {String.valueOf(tipos.getID_cliente()),String.valueOf(tipos.getID_abg()),String.valueOf(tipos.getCedula_cli()), tipos.getNombre_cliu(), tipos.getApellido_cli(), String.valueOf(tipos.getID_contrato()), tipos.getDescripcion(),String.valueOf(tipos.getFecha())};
            mTabla.addRow(filaNueva);
        });
        contra2.setModel(mTabla);
        columnascontra();
    }

    public void limpiar() {
        DefaultTableModel tb = (DefaultTableModel) contra.getModel();
        int a = contra.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }
    
    public void mosterarFACTURAS(ArrayList<MOSTRAR_facturas> lista_tipo) {
        // Para darle forma al modelo de la tabla
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) contra1.getModel();
        mTabla.setNumRows(0);
        // Uso de una expresion landa
        lista_tipo.stream().forEach(tipos -> {
            String[] filaNueva = {String.valueOf(tipos.getID_fact()),String.valueOf(tipos.getID_cliente()),String.valueOf(tipos.getFecha()) , String.valueOf(tipos.getSubtotal()), String.valueOf(tipos.getTotal()), tipos.getNombre(),tipos.getApellido()};
            mTabla.addRow(filaNueva);
        });
        contra1.setModel(mTabla);
        columnascontra();
    }
    
    public void columnascontra() {
        TableColumnModel columna = contra.getColumnModel();
        columna.getColumn(0).setPreferredWidth(100);
        columna.getColumn(1).setPreferredWidth(100);
        columna.getColumn(2).setPreferredWidth(115);
        columna.getColumn(3).setPreferredWidth(155);
        columna.getColumn(4).setPreferredWidth(155);
        columna.getColumn(5).setPreferredWidth(150);
    }

    public void mostrarABG(ArrayList<abogado> lista_tipo) {
        // Para darle forma al modelo de la tabla
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) contra.getModel();
        mTabla.setNumRows(0);
        // Uso de una expresion landa
        lista_tipo.stream().forEach(tipos -> {
            String[] filaNueva = {String.valueOf(tipos.getCedula()), tipos.getPrimerNombre(),tipos.getNombreApellido(),tipos.getTelefono(),String.valueOf(tipos.isGratuidad()),String.valueOf(tipos.getCost_hora()),tipos.getCorre()};
            mTabla.addRow(filaNueva);
        });
        contra.setModel(mTabla);

    }
    
    public void moscontra() {
        abogado abg_usuario = new abogado();
        DefaultTableModel modelo = (DefaultTableModel) contra.getModel();
        try {
            ArrayList<abogado> mostrar = new ArrayList();
            mostrar = abg_usuario.Listar();
            if (mostrar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO EXISTE CONTRATOS REGISTRADOS");
            } else {
                mostrarABG(mostrar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(administradorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnAsignar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        VentanaFondo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ContratosVigentes = new javax.swing.JPanel();
        txtID = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contra = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnEliminar = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        btnEliminar2 = new javax.swing.JButton();
        VentanaContratosEspera = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtIdContratos = new javax.swing.JLabel();
        txtTipoContratos = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        TipoContrato = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnRechazar = new javax.swing.JButton();
        VentanaAsistenteAsignado = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        btnAsignar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JLabel();
        txtWhatsapp = new javax.swing.JLabel();
        btnAsignar2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        contra1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        contra2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnAsignar3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MenuDesplegable = new javax.swing.JPanel();
        txtModificar = new javax.swing.JTextField();
        txtContratosVigentes = new javax.swing.JTextField();
        txtContratosEspera = new javax.swing.JTextField();
        txtAsistenteAsignado = new javax.swing.JTextField();
        txtOficinaAsignada = new javax.swing.JTextField();
        sesion = new javax.swing.JTextField();
        txtModificar1 = new javax.swing.JTextField();

        btnAsignar1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAsignar1.setText("CREAR FACTURA");
        btnAsignar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignar1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pexels-august-de-richelieu-4427430 (1).jpg"))); // NOI18N

        javax.swing.GroupLayout VentanaFondoLayout = new javax.swing.GroupLayout(VentanaFondo);
        VentanaFondo.setLayout(VentanaFondoLayout);
        VentanaFondoLayout.setHorizontalGroup(
            VentanaFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaFondoLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 170, Short.MAX_VALUE))
        );
        VentanaFondoLayout.setVerticalGroup(
            VentanaFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(VentanaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 510));

        ContratosVigentes.setBackground(new java.awt.Color(0, 102, 102));
        ContratosVigentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        txtID.setText("BUSCAR CONTRATOS");
        ContratosVigentes.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 70));

        btnBuscar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        ContratosVigentes.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 100, 40));

        btnMostrar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        ContratosVigentes.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        contra.setBackground(new java.awt.Color(98, 229, 229));
        contra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA_CLIENTE", "NOMBRE_CLIENTE", "APELLIDO_CLIENTE", "ID_contrato", "DESCRIPCIÓN", "FECHA DE CONTRATO "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contra.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(contra);
        if (contra.getColumnModel().getColumnCount() > 0) {
            contra.getColumnModel().getColumn(0).setResizable(false);
            contra.getColumnModel().getColumn(1).setResizable(false);
            contra.getColumnModel().getColumn(2).setResizable(false);
            contra.getColumnModel().getColumn(3).setResizable(false);
        }

        ContratosVigentes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 850, 188));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        ContratosVigentes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 330, 110));

        btnEliminar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnEliminar.setText("ACEPTAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        ContratosVigentes.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));
        ContratosVigentes.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 210, 40));

        btnEliminar2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnEliminar2.setText("ELIMINAR");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });
        ContratosVigentes.add(btnEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jPanel2.add(ContratosVigentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 510));

        VentanaContratosEspera.setBackground(new java.awt.Color(0, 102, 102));

        jTable2.setBackground(new java.awt.Color(0, 102, 102));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Contrato", "Tipo", "Fecha Inicio", "Fecha Final", "Estado"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        txtIdContratos.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtIdContratos.setText("ID Contratos: ");

        txtTipoContratos.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtTipoContratos.setText("Tipo de Contratos:");

        TipoContrato.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        TipoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoContratoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Seleccione una opción");

        btnAceptar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRechazar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnRechazar.setText("Rechazar");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VentanaContratosEsperaLayout = new javax.swing.GroupLayout(VentanaContratosEspera);
        VentanaContratosEspera.setLayout(VentanaContratosEsperaLayout);
        VentanaContratosEsperaLayout.setHorizontalGroup(
            VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaContratosEsperaLayout.createSequentialGroup()
                .addGroup(VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaContratosEsperaLayout.createSequentialGroup()
                        .addGroup(VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VentanaContratosEsperaLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdContratos)
                                    .addComponent(txtTipoContratos))
                                .addGap(23, 23, 23)
                                .addGroup(VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(TipoContrato, 0, 136, Short.MAX_VALUE))
                                .addGap(0, 197, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(VentanaContratosEsperaLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnAceptar)
                        .addGap(99, 99, 99)
                        .addComponent(btnRechazar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        VentanaContratosEsperaLayout.setVerticalGroup(
            VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaContratosEsperaLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(VentanaContratosEsperaLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdContratos)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoContratos)
                    .addComponent(TipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(61, 61, 61)
                .addGroup(VentanaContratosEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jPanel2.add(VentanaContratosEspera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 510));

        VentanaAsistenteAsignado.setBackground(new java.awt.Color(0, 102, 102));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        btnAsignar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAsignar.setText("CREAR FACTURA");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Whatsapp.logo.png"))); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Gmail.logo.png"))); // NOI18N

        txtGmail.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtGmail.setText("Gmail");

        txtWhatsapp.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txtWhatsapp.setText("Whatsapp");

        btnAsignar2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAsignar2.setText("MOSTRAR");
        btnAsignar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignar2ActionPerformed(evt);
            }
        });

        contra1.setBackground(new java.awt.Color(98, 229, 229));
        contra1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_FACTA", "ID_CLIENTE", "FECHA_FACTURA", "SUB_TOTAL", "TOTAL", "NOMBRE_CLIENTE", "APELLIDO_CLIENTE"
            }
        ));
        contra1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(contra1);
        if (contra1.getColumnModel().getColumnCount() > 0) {
            contra1.getColumnModel().getColumn(0).setResizable(false);
            contra1.getColumnModel().getColumn(1).setResizable(false);
            contra1.getColumnModel().getColumn(2).setResizable(false);
            contra1.getColumnModel().getColumn(3).setResizable(false);
        }

        contra2.setBackground(new java.awt.Color(98, 229, 229));
        contra2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_cliente", "ID_abg", "CEDULA_CLIENTE", "NOMBRE_CLIENTE", "APELLIDO_CLIENTE", "ID_contrato", "DESCRIPCIÓN", "FECHA DE CONTRATO "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contra2.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(contra2);
        if (contra2.getColumnModel().getColumnCount() > 0) {
            contra2.getColumnModel().getColumn(0).setResizable(false);
            contra2.getColumnModel().getColumn(1).setResizable(false);
            contra2.getColumnModel().getColumn(2).setResizable(false);
            contra2.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("FACTURAS REALIZADAS:");

        btnAsignar3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAsignar3.setText("MOSTRAR");
        btnAsignar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VentanaAsistenteAsignadoLayout = new javax.swing.GroupLayout(VentanaAsistenteAsignado);
        VentanaAsistenteAsignado.setLayout(VentanaAsistenteAsignadoLayout);
        VentanaAsistenteAsignadoLayout.setHorizontalGroup(
            VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addComponent(jScrollPane6)
            .addGroup(VentanaAsistenteAsignadoLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VentanaAsistenteAsignadoLayout.createSequentialGroup()
                        .addComponent(btnAsignar2)
                        .addGap(32, 32, 32)
                        .addComponent(btnAsignar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaAsistenteAsignadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAsignar3)
                    .addComponent(txtWhatsapp))
                .addGap(506, 506, 506))
        );
        VentanaAsistenteAsignadoLayout.setVerticalGroup(
            VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaAsistenteAsignadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaAsistenteAsignadoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VentanaAsistenteAsignadoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAsignar3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addGroup(VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaAsistenteAsignadoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaAsistenteAsignadoLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaAsistenteAsignadoLayout.createSequentialGroup()
                                .addComponent(txtGmail)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaAsistenteAsignadoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                        .addGroup(VentanaAsistenteAsignadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaAsistenteAsignadoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtWhatsapp)
                                .addContainerGap())))))
        );

        jPanel2.add(VentanaAsistenteAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 510));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 1050, 510));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 90)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ABOGADOS-ECU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 860, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/maps-and-location.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Octavio Chacón Moscoso 1-98 y Primera Transversal (Parque industrial)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 710, 710, 40));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escala-de-justicia.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 130, 150));

        MenuDesplegable.setBackground(new java.awt.Color(0, 0, 102));

        txtModificar.setEditable(false);
        txtModificar.setBackground(new java.awt.Color(0, 0, 102));
        txtModificar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtModificar.setForeground(new java.awt.Color(255, 255, 255));
        txtModificar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModificar.setText("MIS DATOS");
        txtModificar.setBorder(null);
        txtModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtModificarMouseExited(evt);
            }
        });
        txtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModificarActionPerformed(evt);
            }
        });

        txtContratosVigentes.setEditable(false);
        txtContratosVigentes.setBackground(new java.awt.Color(0, 0, 102));
        txtContratosVigentes.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtContratosVigentes.setForeground(new java.awt.Color(255, 255, 255));
        txtContratosVigentes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContratosVigentes.setText("CONTRATOS");
        txtContratosVigentes.setBorder(null);
        txtContratosVigentes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtContratosVigentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContratosVigentesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtContratosVigentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtContratosVigentesMouseExited(evt);
            }
        });
        txtContratosVigentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContratosVigentesActionPerformed(evt);
            }
        });

        txtContratosEspera.setEditable(false);
        txtContratosEspera.setBackground(new java.awt.Color(0, 0, 102));
        txtContratosEspera.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtContratosEspera.setForeground(new java.awt.Color(255, 255, 255));
        txtContratosEspera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContratosEspera.setText("TAREAS ASISTENTE");
        txtContratosEspera.setBorder(null);
        txtContratosEspera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtContratosEspera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContratosEsperaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtContratosEsperaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtContratosEsperaMouseExited(evt);
            }
        });
        txtContratosEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContratosEsperaActionPerformed(evt);
            }
        });

        txtAsistenteAsignado.setEditable(false);
        txtAsistenteAsignado.setBackground(new java.awt.Color(0, 0, 102));
        txtAsistenteAsignado.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtAsistenteAsignado.setForeground(new java.awt.Color(255, 255, 255));
        txtAsistenteAsignado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAsistenteAsignado.setText("GENERAR FACTURA");
        txtAsistenteAsignado.setBorder(null);
        txtAsistenteAsignado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAsistenteAsignado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAsistenteAsignadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAsistenteAsignadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtAsistenteAsignadoMouseExited(evt);
            }
        });
        txtAsistenteAsignado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsistenteAsignadoActionPerformed(evt);
            }
        });

        txtOficinaAsignada.setEditable(false);
        txtOficinaAsignada.setBackground(new java.awt.Color(0, 0, 102));
        txtOficinaAsignada.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtOficinaAsignada.setForeground(new java.awt.Color(255, 255, 255));
        txtOficinaAsignada.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtOficinaAsignada.setText("     Oficina Asignada");
        txtOficinaAsignada.setBorder(null);
        txtOficinaAsignada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtOficinaAsignada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtOficinaAsignadaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtOficinaAsignadaMouseExited(evt);
            }
        });
        txtOficinaAsignada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOficinaAsignadaActionPerformed(evt);
            }
        });

        sesion.setEditable(false);
        sesion.setBackground(new java.awt.Color(0, 0, 102));
        sesion.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        sesion.setForeground(new java.awt.Color(255, 255, 255));
        sesion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sesion.setText("CERRAR SESION");
        sesion.setBorder(null);
        sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sesionMouseExited(evt);
            }
        });
        sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesionActionPerformed(evt);
            }
        });

        txtModificar1.setEditable(false);
        txtModificar1.setBackground(new java.awt.Color(0, 0, 102));
        txtModificar1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        txtModificar1.setForeground(new java.awt.Color(255, 255, 255));
        txtModificar1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModificar1.setText("=");
        txtModificar1.setBorder(null);
        txtModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtModificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtModificar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtModificar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtModificar1MouseExited(evt);
            }
        });
        txtModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModificar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuDesplegableLayout = new javax.swing.GroupLayout(MenuDesplegable);
        MenuDesplegable.setLayout(MenuDesplegableLayout);
        MenuDesplegableLayout.setHorizontalGroup(
            MenuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtContratosEspera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(txtAsistenteAsignado)
            .addComponent(sesion, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(txtOficinaAsignada, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(txtContratosVigentes, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(txtModificar)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuDesplegableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtModificar1)
                .addContainerGap())
        );
        MenuDesplegableLayout.setVerticalGroup(
            MenuDesplegableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuDesplegableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContratosVigentes, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtContratosEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAsistenteAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtOficinaAsignada, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(MenuDesplegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        VentanaFondo.setVisible(true);

        ContratosVigentes.setVisible(false);
        VentanaContratosEspera.setVisible(false);
        VentanaAsistenteAsignado.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sesionActionPerformed

    private void sesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionMouseExited
        sesion.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_sesionMouseExited

    private void sesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionMouseEntered
        sesion.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_sesionMouseEntered

    private void txtOficinaAsignadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOficinaAsignadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOficinaAsignadaActionPerformed

    private void txtOficinaAsignadaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOficinaAsignadaMouseExited
        txtOficinaAsignada.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_txtOficinaAsignadaMouseExited

    private void txtOficinaAsignadaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOficinaAsignadaMouseEntered
        txtOficinaAsignada.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_txtOficinaAsignadaMouseEntered

    private void txtContratosEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContratosEsperaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContratosEsperaActionPerformed

    private void txtContratosEsperaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContratosEsperaMouseExited
        txtContratosEspera.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_txtContratosEsperaMouseExited

    private void txtContratosEsperaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContratosEsperaMouseEntered
        txtContratosEspera.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_txtContratosEsperaMouseEntered

    private void txtContratosVigentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContratosVigentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContratosVigentesActionPerformed

    private void txtContratosVigentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContratosVigentesMouseExited
        txtContratosVigentes.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_txtContratosVigentesMouseExited

    private void txtContratosVigentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContratosVigentesMouseEntered
        txtContratosVigentes.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_txtContratosVigentesMouseEntered

    private void txtContratosVigentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContratosVigentesMouseClicked
        VentanaFondo.setVisible(false);
        ContratosVigentes.setVisible(true);
        VentanaContratosEspera.setVisible(false);
        VentanaAsistenteAsignado.setVisible(false);
    }//GEN-LAST:event_txtContratosVigentesMouseClicked

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        factura factura = new factura();
        int select = contra2.getSelectedRow();
        if(select == -1){
            JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UNA FILA DE LA TABLA ");
        }else{
            System.out.println(contra2.getValueAt(select, 0).toString());
            factura.setFK_cliente(Integer.parseInt(contra2.getValueAt(select, 0).toString()));
            factura.setFK_abg(Integer.parseInt(contra2.getValueAt(select, 1).toString()));
            LocalDate fechafact = LocalDate.now();
            factura.setFecha(fechafact);
            try {
                factura.ingresarFACTURA();
                factura.setFK_id_encabezado(factura.ID_ENCA());
                abogado consultarprecio = new abogado();
                factura.setSub_total(consultarprecio.precioABG(Integer.parseInt(contra2.getValueAt(select, 1).toString())));
                factura.setTotal(factura.calculartotal());
                factura.cuerpofact();
                JOptionPane.showMessageDialog(null,"SE HA GENERADO CORRECTAMENTE LA FACTURA");
            } catch (SQLException ex) {
                Logger.getLogger(abogadoInterfaz2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void TipoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoContratoActionPerformed

    private void txtIdContraroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdContraroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdContraroActionPerformed

    private void txtModificar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificar1MouseClicked
        if (MenuDesplegable.getX() == 0) {
            desplace.desplazarIzquierda(MenuDesplegable, MenuDesplegable.getX(), -160, 10, 10);
        } else if (MenuDesplegable.getX() == -160) {
            desplace.desplazarDerecha(MenuDesplegable, MenuDesplegable.getX(), 0, 10, 10);
        }
    }//GEN-LAST:event_txtModificar1MouseClicked

    private void txtModificar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModificar1MouseEntered

    private void txtModificar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModificar1MouseExited

    private void txtModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModificar1ActionPerformed

    private void txtContratosEsperaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContratosEsperaMouseClicked
        VentanaContratosEspera.setVisible(true);
        VentanaFondo.setVisible(false);

        ContratosVigentes.setVisible(false);
        VentanaAsistenteAsignado.setVisible(false);
    }//GEN-LAST:event_txtContratosEsperaMouseClicked

    private void txtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModificarActionPerformed

    private void txtModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseExited
        txtModificar.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_txtModificarMouseExited

    private void txtModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseEntered
        txtModificar.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_txtModificarMouseEntered

    private void txtModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseClicked
      
    
    }//GEN-LAST:event_txtModificarMouseClicked

    private void txtAsistenteAsignadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsistenteAsignadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsistenteAsignadoActionPerformed

    private void txtAsistenteAsignadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAsistenteAsignadoMouseExited
        txtAsistenteAsignado.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_txtAsistenteAsignadoMouseExited

    private void txtAsistenteAsignadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAsistenteAsignadoMouseEntered
        txtAsistenteAsignado.setBackground(new Color(0, 0, 153));
    }//GEN-LAST:event_txtAsistenteAsignadoMouseEntered

    private void txtAsistenteAsignadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAsistenteAsignadoMouseClicked
        VentanaAsistenteAsignado.setVisible(true);
        VentanaContratosEspera.setVisible(false);
        VentanaFondo.setVisible(false);

        ContratosVigentes.setVisible(false);
    }//GEN-LAST:event_txtAsistenteAsignadoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        String url = "https://goo.gl/maps/UoBFEarK47ZhZvQU9";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (URISyntaxException ex) {

        } catch (IOException ex) {
            Logger.getLogger(administradorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        Mostrar_contrato listar = new Mostrar_contrato();
        try {
            ArrayList <Mostrar_contrato> lista = listar.motrarCON();
            limpiar();
            mosterarCONTRATOS(lista);
        } catch (SQLException ex) {
            Logger.getLogger(abogadoInterfaz2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        
        if(contra.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UNA FILA EN LA TABLA ");
        }else{
            int fila = contra.getSelectedRow();
            Integer.parseInt(contra.getValueAt(fila, 3).toString());
            Mostrar_contrato modificar = new Mostrar_contrato();
            modificar.setID_contrato(Integer.parseInt(contra.getValueAt(fila, 3).toString()));
            try {
                modificar.descartar();
                limpiar();
                mosterarCONTRATOS(modificar.motrarCON());
                JOptionPane.showMessageDialog(null, "SE HA ELIMINADO EL REGISTRO CORRECTAMENTE");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR EN LA ELIMINACION");
                Logger.getLogger(abogadoInterfaz2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(contra.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UNA FILA EN LA TABLA ");
        }else{
            int fila = contra.getSelectedRow();
            Integer.parseInt(contra.getValueAt(fila, 3).toString());
            Mostrar_contrato modificar = new Mostrar_contrato();
            modificar.setID_contrato(Integer.parseInt(contra.getValueAt(fila, 3).toString()));
            try {
                modificar.aceptar();
                limpiar();
                mosterarCONTRATOS(modificar.motrarCON());
                JOptionPane.showMessageDialog(null, "SE HA ACEPTADO EL CONTRATO CORRECTAMENTE");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR EN LA ELIMINACION");
                Logger.getLogger(abogadoInterfaz2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAsignar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignar1ActionPerformed

    private void btnAsignar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignar2ActionPerformed
        Mostrar_contrato listar = new Mostrar_contrato();
        try {
            ArrayList <Mostrar_contrato> lista = listar.motrarCONAPROBADOS();
            limpiar();
            mosterarCONTAPROBADOS(lista);
        } catch (SQLException ex) {
            Logger.getLogger(abogadoInterfaz2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAsignar2ActionPerformed

    private void btnAsignar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignar3ActionPerformed
        MOSTRAR_facturas mostrar = new MOSTRAR_facturas();
        try {
            mosterarFACTURAS(mostrar.MOSTRAR_FACTURA());
        } catch (SQLException ex) {
            Logger.getLogger(abogadoInterfaz2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAsignar3ActionPerformed

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
            java.util.logging.Logger.getLogger(abogadoInterfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abogadoInterfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abogadoInterfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abogadoInterfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new abogadoInterfaz2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContratosVigentes;
    private javax.swing.JPanel MenuDesplegable;
    private javax.swing.JComboBox<String> TipoContrato;
    private javax.swing.JPanel VentanaAsistenteAsignado;
    private javax.swing.JPanel VentanaContratosEspera;
    private javax.swing.JPanel VentanaFondo;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAsignar1;
    private javax.swing.JButton btnAsignar2;
    private javax.swing.JButton btnAsignar3;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRechazar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTable contra;
    private javax.swing.JTable contra1;
    private javax.swing.JTable contra2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField sesion;
    private javax.swing.JTextField txtAsistenteAsignado;
    private javax.swing.JTextField txtContratosEspera;
    private javax.swing.JTextField txtContratosVigentes;
    private javax.swing.JLabel txtGmail;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtIdContratos;
    private javax.swing.JTextField txtModificar;
    private javax.swing.JTextField txtModificar1;
    private javax.swing.JTextField txtOficinaAsignada;
    private javax.swing.JLabel txtTipoContratos;
    private javax.swing.JLabel txtWhatsapp;
    // End of variables declaration//GEN-END:variables
}
