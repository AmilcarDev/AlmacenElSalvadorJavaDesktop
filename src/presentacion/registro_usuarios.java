package presentacion;

import Clases.Utilidades;
import Control.msm;
import clases.Validaciones;
import static clases.Validaciones.*;
import com.integra.login.ControladorBitacora;
import com.integra.session.ModeloSession;
import com.integra.users.ControladorAdministrarUsuario;
import com.integra.users.ControladorNuevoUsuario;
import com.integra.users.ModeloNuevoUsuario;
import com.integra.users.ModeloPrivilegios;
import com.integra.users.ModeloUsuario;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amilcar
 *
 */
public class registro_usuarios extends javax.swing.JFrame {

    private ModeloNuevoUsuario mnu;
    private ModeloPrivilegios mp;
    private ModeloUsuario mu;
    private ControladorNuevoUsuario cnu;
    private ControladorAdministrarUsuario cau;
    private DefaultTableModel modelo;
    private boolean modify;
    private String tempUser = "";
    private int tempIdEmployee = 0;
    Utilidades util = new Utilidades();

    public registro_usuarios() {
        initComponents();
        cnu = new ControladorNuevoUsuario();
        cnu.getAllEmpleados(comboBoxRound1);
        cau = new ControladorAdministrarUsuario();
        modelo = (DefaultTableModel) jTable2.getModel();
        jTable2.setModel(modelo);
        modify = false;
    }

    //////////BITACORA
    
        ModeloSession mss;
    ControladorBitacora cb;
    
     public registro_usuarios(ModeloSession mss) {
        initComponents();
        this.mss=mss;
        cb= new ControladorBitacora();
        cnu = new ControladorNuevoUsuario();
        cnu.getAllEmpleados(comboBoxRound1);
        cau = new ControladorAdministrarUsuario();
        modelo = (DefaultTableModel) jTable2.getModel();
        jTable2.setModel(modelo);
        modify = false;
    }
     
    //////////BITACORA
    
    
    
    
    
    
    
    public void obtenerDatos() {
        // mnu= new ModeloNuevoUsuario
        mu = new ModeloUsuario();
        mp = new ModeloPrivilegios();
        mu.setNombreUsuario(textFieldRoundImage1.getText().trim());
        mu.setEmail(textFieldRoundImage2.getText().trim());
        mu.setPassword(new String(passwordFieldRoundImage1.getPassword()));
        String[] id = comboBoxRound1.getSelectedItem().toString().split("-");
        System.out.println("id->" + id[0].trim());
        mu.setIdEmpleado((modify) ? tempIdEmployee : Integer.parseInt(id[0].trim()));
        mp.setREGISTRO_PROVEEDORES(jCheckBox1.isSelected());
        mp.setREGISTRO_EMPLEADOS(jCheckBox2.isSelected());
        mp.setREGISTRO_PRODUCTO(jCheckBox3.isSelected());
        mp.setREGISTRO_COMPRAS(jCheckBox4.isSelected());
        mp.setREGISTRO_VENTAS(jCheckBox5.isSelected());
        mp.setGENERAR_REPORTES(jCheckBox6.isSelected());
        mp.setCONSULTAR_INVENTARIO(jCheckBox7.isSelected());
    }

    private void borrarTabla() {
        for (int i = 0; i < modelo.getRowCount();) {
            modelo.removeRow(i);
        }
    }

    
    
    
    private void modificar() throws Exception {
        textFieldRoundImage1.setText(mu.getNombreUsuario());
        textFieldRoundImage2.setText(mu.getEmail());
        passwordFieldRoundImage1.setText(new Utilidades().Desencriptar(mu.getPassword()));
       // passwordFieldRoundImage1.setText(mu.getPassword());
       // passwordFieldRoundImage1.setText(new Utilidades().Desencriptar(mu.getPassword()));
        ComboBoxModel m = comboBoxRound1.getModel();
        for (int i = 0; i < m.getSize(); i++) {
            String[] id = m.getElementAt(i).toString().split("-");
            if (Integer.parseInt(id[0].trim()) == mu.getIdEmpleado()) {
                comboBoxRound1.setSelectedIndex(i);
                comboBoxRound1.setEnabled(false);
            }
        }
        jCheckBox1.setSelected(mp.getPrivilegios()[0]);
        jCheckBox2.setSelected(mp.getPrivilegios()[1]);
        jCheckBox3.setSelected(mp.getPrivilegios()[2]);
        jCheckBox4.setSelected(mp.getPrivilegios()[3]);
        jCheckBox5.setSelected(mp.getPrivilegios()[4]);
        jCheckBox6.setSelected(mp.getPrivilegios()[5]);
        jCheckBox7.setSelected(mp.getPrivilegios()[6]);
        tempUser = mu.getNombreUsuario();
        tempIdEmployee = mu.getIdEmpleado();
        mu = null;
        mp = null;
    }

    private void cargarDatosDB() {
        String user = jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString();
        //System.out.println(user);
        mu = cau.getDatosUsuario(cau.getUserId(user));
        mp = cau.getPrivilegios(cau.getUserId(user));
        System.out.println(mu.toString());
        System.out.println(mp.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BG_Grupo = new javax.swing.ButtonGroup();
        BG_Grupo2 = new javax.swing.ButtonGroup();
        BG_Grupo_1 = new javax.swing.ButtonGroup();
        BG_Grupo_2 = new javax.swing.ButtonGroup();
        BG_Grupo_3 = new javax.swing.ButtonGroup();
        BG_Grupo_4 = new javax.swing.ButtonGroup();
        BG_Grupo_5 = new javax.swing.ButtonGroup();
        BG_Grupo_6 = new javax.swing.ButtonGroup();
        BG_Grupo_7 = new javax.swing.ButtonGroup();
        jcMousePanel3 = new jcMousePanel.jcMousePanel();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passwordFieldRoundImage1 = new org.edisoncor.gui.passwordField.PasswordFieldRoundImage();
        passwordFieldRoundImage2 = new org.edisoncor.gui.passwordField.PasswordFieldRoundImage();
        textFieldRoundImage1 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        textFieldRoundImage2 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        comboBoxRound1 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        btncancelar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jLabel4.setText("jLabel4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jcMousePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pie.png"))); // NOI18N
        getContentPane().add(jcMousePanel3, java.awt.BorderLayout.PAGE_END);

        panelRectTranslucido1.setColorPrimario(new java.awt.Color(0, 0, 102));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(400, 50));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administración de Usuarios");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button-close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRectTranslucido1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jLabel3.setText("Usuario");

        jLabel5.setText("Correo");

        jLabel6.setText("Contraseña");

        jLabel7.setText("Repetir Contraseña");

        passwordFieldRoundImage1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                passwordFieldRoundImage1CaretUpdate(evt);
            }
        });

        passwordFieldRoundImage2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                passwordFieldRoundImage2CaretUpdate(evt);
            }
        });

        textFieldRoundImage1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textFieldRoundImage1CaretUpdate(evt);
            }
        });
        textFieldRoundImage1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldRoundImage1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldRoundImage1KeyTyped(evt);
            }
        });

        textFieldRoundImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRoundImage2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Asignación");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(passwordFieldRoundImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(comboBoxRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFieldRoundImage2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldRoundImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldRoundImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldRoundImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(textFieldRoundImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(passwordFieldRoundImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(passwordFieldRoundImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Privilegios"));

        jCheckBox1.setText("Registro de Proveedores");

        jCheckBox2.setText("Registro de Empleados");

        jCheckBox3.setText("Registro de Productos");

        jCheckBox4.setText("Compras");

        jCheckBox5.setText("Ventas");

        jCheckBox6.setText("Reportes");

        jCheckBox7.setText("Seguridad");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox5))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox6))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox7))
                .addGap(29, 29, 29)
                .addComponent(jCheckBox4)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btncancelar.setBackground(new java.awt.Color(179, 212, 244));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(179, 212, 244));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btncancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Permisos", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        jLabel9.setText("Buscar por");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre" }));

        jLabel10.setText("Nombre");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Usuario", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Búsqueda", jPanel3);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void textFieldRoundImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRoundImage2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRoundImage2ActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        try {
            obtenerDatos();
            vacio(mu.getNombreUsuario());
            vacio(mu.getEmail());
            vacio(mu.getPassword());
            verificarPass(mu.getPassword(), new String(passwordFieldRoundImage2.getPassword()));
            mnu = new ModeloNuevoUsuario(mu, mp);
            if (!modify) {
                EmpladoSetterAUser(cau.isEmpleadoUsedUser(mu.getIdEmpleado()));
                cnu.insertar(mnu);
                mu = null;
                mp = null;
                
                msm.ms_exito("Usuario creado con éxito");
                cb.insertarAccion(mss.getNombre(),"creo un nuevo usuario");
            } else {
                System.out.println("datos modificados");
                cau.modificar(mnu, cau.getUserId(tempUser));
                modify = false;
                tempUser = "";
                tempIdEmployee = 0;
                mu = null;
                mp = null;
                
                msm.ms_exito("Datos de Usuario modificados");
                
                cb.insertarAccion(mss.getNombre(),"modifico un usuario");
            }
        } catch (Validaciones | NullPointerException ex) {
            Logger.getLogger(registro_usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        borrarTabla();
        cau.buscarUsuario(modelo, jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 2) {
            cargarDatosDB();
            try {
                modificar();
            } catch (Exception ex) {
                Logger.getLogger(registro_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("datos cargados");
            modify = true;
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void textFieldRoundImage1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldRoundImage1KeyReleased
        // TODO add your handling code here:
        if (!(textFieldRoundImage1.equals(""))) {
            if ((cnu.isUserExists(textFieldRoundImage1.getText()))) {
                

            } else {
               // lbl_dui_existe.setForeground(Color.red);
                //lbl_dui_existe.setText("DUI ya existe!");
                msm.ms_informacion("El nombre de usuario ya existe");
                textFieldRoundImage1.setText("");
                //                bloquear_si_existe_dui();
                //               txtdni.requestFocus();
            }
        }
    
    }//GEN-LAST:event_textFieldRoundImage1KeyReleased

    private void textFieldRoundImage1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textFieldRoundImage1CaretUpdate
       
    }//GEN-LAST:event_textFieldRoundImage1CaretUpdate

    private void textFieldRoundImage1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldRoundImage1KeyTyped
        // TODO add your handling code here:
          
    }//GEN-LAST:event_textFieldRoundImage1KeyTyped

    private void passwordFieldRoundImage1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_passwordFieldRoundImage1CaretUpdate
        // TODO add your handling code here:
        
    }//GEN-LAST:event_passwordFieldRoundImage1CaretUpdate

    public boolean verificarPassword() {
        return (new String(passwordFieldRoundImage1.getPassword()).equals(new String(passwordFieldRoundImage2.getPassword())));
    }
    
    private void passwordFieldRoundImage2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_passwordFieldRoundImage2CaretUpdate
        // TODO add your handling code here:
        if (!(new String(passwordFieldRoundImage2.getPassword()).isEmpty())) {
                     
            if (!verificarPassword()) {
                //jLabel7.setText("si");
               // jLabel11.setText("no coinciden");
                 jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelu.png")));
                
            } else {
                jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/acept.png")));
                jLabel11.setText("");
                //jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/Cancelar.png")));
                //JOptionPane.showMessageDialog(null, "las contraseñas no coinciden","mensaje",1,new ImageIcon("error.png"));
            }
        } else {
            jLabel11.setText("");
        }
    }//GEN-LAST:event_passwordFieldRoundImage2CaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        JFrame.setDefaultLookAndFeelDecorated(false);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registro_usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_Grupo;
    private javax.swing.ButtonGroup BG_Grupo2;
    private javax.swing.ButtonGroup BG_Grupo_1;
    private javax.swing.ButtonGroup BG_Grupo_2;
    private javax.swing.ButtonGroup BG_Grupo_3;
    private javax.swing.ButtonGroup BG_Grupo_4;
    private javax.swing.ButtonGroup BG_Grupo_5;
    private javax.swing.ButtonGroup BG_Grupo_6;
    private javax.swing.ButtonGroup BG_Grupo_7;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private org.edisoncor.gui.comboBox.ComboBoxRound comboBoxRound1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundImage passwordFieldRoundImage1;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundImage passwordFieldRoundImage2;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage1;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage2;
    // End of variables declaration//GEN-END:variables

}
