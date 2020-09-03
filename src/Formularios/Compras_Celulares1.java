package Formularios;

import Clases.Compras_Set_Get;
import Clases.Datos_Regisro_Producto;
import Clases.Funcion;
import Clases.msm;
import com.integra.login.ControladorBitacora;
import com.integra.session.ModeloSession;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.edisoncor.gui.comboBox.ComboBoxRound;

/**
 *
 * @author Baltazar
 */
public class Compras_Celulares1 extends javax.swing.JFrame {

    Datos_Regisro_Producto Datos = new Datos_Regisro_Producto();
    DefaultTableCellRenderer tcr;
    Vector v = new Vector();
    DefaultTableModel dt = new DefaultTableModel();
    DefaultTableModel dt2 = new DefaultTableModel();
    Compras_Set_Get metodos = new Compras_Set_Get();
    DecimalFormat df = new DecimalFormat("0.00");
    Funcion fun = new Funcion();
    String sql_tabla = "Select Id_Producto,Nombre_Producto,Sistema,Camara,Pantalla,Color from producto";
    int cont = 0;
    int Numero_Departamento = 1;
    int filaSeleccionada;

    //Variables para la tabla Producto
    int Id_Producto;
    String Nombre_Producto;
    String Sistema_Producto;
    String Camara_Producto;
    String Pantalla_Producto;
    String Color_Producto;
    boolean llenar_tabla = false;

    //Variable para la insercion de compra
    int Id_Usuario = 0;
    String Numero_Factura;
    String Tipo_Pago;
    String Fecha_Compra;
    String Fecha_Pago;
    float Total;
    int Id_Compra;
    int Id_Proveedor;

    //Variable de insercion de detalle de compra
    int Id_Detalle_Compra;
    float Precio_Compra;
    int Cantidad_Compa;
    int proveedor_id;

    //Variables de inventario
    float precio_invt = 0;

    ModeloSession mss;
    ControladorBitacora cb;
    public Compras_Celulares1(ModeloSession mss) {
        initComponents();
        this.mss=mss;
        cb= new ControladorBitacora();
        color();
        tcr = new DefaultTableCellRenderer();
        dt = (DefaultTableModel) JT_Tabla.getModel();
        dt2 = (DefaultTableModel) JT_Compra.getModel();
        //Ajuste para la tabla comprobante
        Ajuste_Columna_Tabla(JT_Compra, 0, 0, 0, 0);
        Ajuste_Columna_Tabla(JT_Compra, 2, 60, 60, 60);
        Ajuste_Columna_Tabla(JT_Compra, 6, 80, 80, 80);
        Ajuste_Columna_Tabla(JT_Compra, 7, 80, 80, 80);

        CargarCombo();
        JCB_Proveedor.setSelected(true);
        JCB_Proveedor.setVisible(false);
        Datos.abrirConexion();
        proveedor_id = BuscarID("select * from proveedor where Nombre_Proveedor='" + JC_Proveedor.getSelectedItem().toString() + "'", "proveedor");
        System.out.println("proveedor " + proveedor_id);
        Datos.cerrarConexion();
        Llenar(sql_tabla + " Where Id_Departamento=" + Numero_Departamento + " AND Id_Proveedor=" + proveedor_id + "", "producto");
        In_Camp();
    }

    public void cargarCombo(ComboBoxRound combo, String Sql, String tabla_Error) {
        try {
            Datos.abrirConexion();
            Datos.Buscar(Sql, "" + tabla_Error);
            while (Datos.rs.next()) {
                combo.addItem(Datos.rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay conexion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        Datos.cerrarConexion();
    }

    public void CargarCombo() {
        cargarCombo(JC_Categoria, "select * from categoria where Id_Departamento=" + Numero_Departamento + "", "categoria");
        cargarCombo(JC_Clasificacion, "select * from clasificacion where Id_Departamento=" + Numero_Departamento + "", "clasificacion");
        cargarCombo(JC_Proveedor, "select * from proveedor where Estado='Activo'", "proveedor");
    }

    public void Llenar(String SQL, String tabla) {
        Ajuste_Columna_Tabla(JT_Tabla, 0, 0, 0, 0);
        Ajuste_Columna_Tabla(JT_Tabla, 2, 60, 60, 60);
        CentrarColumna(2);
        CentrarColumna(3);
        Datos.abrirConexion();
        try {
            Datos.Buscar(SQL, tabla);
            while (Datos.rs.next()) {
                v = new java.util.Vector();
                v.add(Datos.rs.getInt("Id_Producto"));
                v.add(Datos.rs.getString("Nombre_Producto"));
                v.add(Datos.rs.getString("Sistema"));
                v.add(Datos.rs.getString("Camara"));
                v.add(Datos.rs.getString("Pantalla"));
                v.add(Datos.rs.getString("Color"));
                dt.addRow(v);
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo LLenar");
        }
        Datos.cerrarConexion();

    }

    public void llenarTabla_compra() {
        float total = 0;
        int canti;
        float prec;
        float Precio;
        //String fecha = sdfCalendar.format(jcalproducto.getDate()).toString();

        Precio = Float.parseFloat(TFRI_Precio.getText());
        dt2.addRow(new Object[]{Id_Producto, Nombre_Producto, Sistema_Producto, Camara_Producto, Pantalla_Producto, Color_Producto, TFRI_Cantidad.getText(), String.valueOf(df.format(Precio))});
        total = 0;

        for (int i = 0; i < JT_Compra.getRowCount(); i++) {
            canti = Integer.parseInt(JT_Compra.getValueAt(i, 6).toString());
            prec = Float.parseFloat(JT_Compra.getValueAt(i, 7).toString());
            total = total + (canti * prec);
        }
        Total = Float.parseFloat(df.format(total));
    }

    public void modificarTabla_compra(int i) {

        float total = 0, precio = Float.parseFloat(TFRI_Precio.getText());
        int cant = Integer.parseInt(TFRI_Cantidad.getText().toString()) + Integer.parseInt(JT_Compra.getValueAt(i, 6).toString());
        int canti;
        float prec;

        JT_Compra.setValueAt(cant, i, 6);
        JT_Compra.setValueAt(df.format(precio), i, 7);
        total = 0;
        for (int j = 0; i < JT_Compra.getRowCount(); i++) {
            canti = Integer.parseInt(JT_Compra.getValueAt(i, 6).toString());
            prec = Float.parseFloat(JT_Compra.getValueAt(i, 7).toString());
            total = total + (canti * prec);
        }
        Total = Float.parseFloat(df.format(total));

    }

    public int BuscarID(String SQL, String Tabla) {
        int id = 0;
        try {
            Datos.Buscar(SQL, "" + Tabla);
            while (Datos.rs.next()) {
                id = Datos.rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.print("Buscar ID Error al buscar en Tabla " + Tabla);
        }
        return id;
    }

    public void Ajuste_Columna_Tabla(JTable T, int Columna, int MaxWidth, int MinWidth, int PreferredWidth) {
        T.getColumnModel().getColumn(Columna).setMaxWidth(MaxWidth);
        T.getColumnModel().getColumn(Columna).setMinWidth(MinWidth);
        T.getColumnModel().getColumn(Columna).setPreferredWidth(PreferredWidth);
    }

    public void CentrarColumna(int columna) {
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        JT_Tabla.getColumnModel().getColumn(columna).setCellRenderer(tcr);
    }

    public void color() {
        colorComboBox(JC_Categoria);
        colorComboBox(JC_Clasificacion);
        colorComboBox(JC_Proveedor);
    }

    public void colorComboBox(ComboBoxRound combo) {
        combo.setBackground(Color.WHITE);
    }

    public int validar() {
        int op = 0;
        String mensaje = "";

        if (TFRI_Cantidad.getText().trim().equals("")) {
            op = 1;
            mensaje = mensaje + "Cantidad                Agregue una cantidad\n";
        }
        if (TFRI_Precio.getText().trim().equals("")) {
            op = 2;
            mensaje = mensaje + "Precio unitario     Agregue un precio unitario\n";
        }

        if (op > 0) {
            msm.ms_alerta("          Verifique los siguientes campos:\n\n" + mensaje);
        }
        return op;
    }

    public int validar2() {
        int op = 0;
        String mensaje = "";

        if (TFRI_Numero_Factura.getText().trim().equals("")) {
            op = 1;
            mensaje = mensaje + "Numero de factura                Agregue un numero de factura\n";
        }

        if (JDC_Compra.getDate() == null) {
            op = 2;
            mensaje = mensaje + "Fecha de compra                Seleccione una fecha\n";
        }
        if (JRB_Credito.isSelected() && JDC_Pago.getDate() == null) {
            op = 3;
            mensaje = mensaje + "Fecha de pago                Seleccione una fecha\n";
        }
        if (JT_Compra.getRowCount() == 0) {
            op = 4;
            mensaje = mensaje + "Tabla comprobante        No tiene agregado ningun producto\n";
        }
        if (JRB_Contado.isSelected() == false && JRB_Credito.isSelected() == false) {
            op = 5;
            mensaje = mensaje + "Forma de pago                Seleccione una opción\n";
        }

        if (op > 0) {
            msm.ms_alerta("          Verifique los siguientes campos:\n\n" + mensaje);
        }
        return op;
    }

    String[] a = {"AutumnSkin", "BusinessBlackSteelSkin", "BusinessBlueSteelSkin", "BusinessSkin", "ChallengerDeepSkin",
        "CremeCoffeeSkin", "CremeSkin", "EmeraldDuskSkin", "FieldOfWheatSkin", "FindingNemoSkin", "GreenMagicSkin", "MagmaSkin", "MangoSkin", "MistAquaSkin",
        "MistSilverSkin", "ModerateSkin", "NebulaBrickWallSkin", "NebulaSkin", "OfficeBlue2007Skin", "OfficeSilver2007Skin", "RavenGraphiteGlassSkin",
        "RavenGraphiteSkin", "SaharaSkin", "SkinChangeListener", "SkinInfo", "SubstanceAbstractSkin", "SubstanceAutumnLookAndFeel", "SubstanceBusinessBlackSteelLookAndFeel", "SubstanceBusinessBlueSteelLookAndFeel", "SubstanceBusinessLookAndFeel",
        "SubstanceChallengerDeepLookAndFeel", "SubstanceCremeCoffeeLookAndFeel", "SubstanceEmeraldDuskLookAndFeel", "SubstanceFieldOfWheatLookAndFeel"};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jcMousePanel3 = new jcMousePanel.jcMousePanel();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        JTP_Pestaña = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        JC_Categoria = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        JC_Clasificacion = new org.edisoncor.gui.comboBox.ComboBoxRound();
        JC_Proveedor = new org.edisoncor.gui.comboBox.ComboBoxRound();
        TFRI_Nombre = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel30 = new javax.swing.JLabel();
        JCB_Categoria = new javax.swing.JCheckBox();
        JCB_Proveedor = new javax.swing.JCheckBox();
        JCB_Clasificacion = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JT_Tabla = new javax.swing.JTable();
        TFRI_Cantidad = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel24 = new javax.swing.JLabel();
        TFRI_Precio = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel32 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JT_Compra = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        JRB_Contado = new javax.swing.JRadioButton();
        JRB_Credito = new javax.swing.JRadioButton();
        TFRI_Numero_Factura = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JDC_Pago = new com.toedter.calendar.JDateChooser();
        JDC_Compra = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

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
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(600, 50));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administración de Compra Celulares");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button-close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRectTranslucido1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTP_Pestaña.setMinimumSize(new java.awt.Dimension(600, 310));
        JTP_Pestaña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTP_PestañaMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(173, 173, 173));
        jLabel49.setText("-------------------------------------------------------------------------------------------------------------------");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 590, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(173, 173, 173));
        jLabel53.setText("__________________________________________________________________________________");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 590, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel22.setText("Nombre");

        JC_Categoria.setAnchoDeBorde(2.0F);
        JC_Categoria.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Categoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JC_Categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JC_CategoriaItemStateChanged(evt);
            }
        });
        JC_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JC_CategoriaMouseClicked(evt);
            }
        });

        jLabel28.setText("Categoria");

        jLabel29.setText("Sección");

        JC_Clasificacion.setAnchoDeBorde(2.0F);
        JC_Clasificacion.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Clasificacion.setFocusable(false);
        JC_Clasificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JC_Clasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JC_ClasificacionMouseClicked(evt);
            }
        });

        JC_Proveedor.setAnchoDeBorde(2.0F);
        JC_Proveedor.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Proveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JC_Proveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JC_ProveedorItemStateChanged(evt);
            }
        });
        JC_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JC_ProveedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JC_ProveedorMouseEntered(evt);
            }
        });
        JC_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JC_ProveedorActionPerformed(evt);
            }
        });

        TFRI_Nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TFRI_NombreMouseClicked(evt);
            }
        });
        TFRI_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_NombreActionPerformed(evt);
            }
        });
        TFRI_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRI_NombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_NombreKeyTyped(evt);
            }
        });

        jLabel30.setText("Proveedor");

        JCB_Categoria.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCB_CategoriaMouseClicked(evt);
            }
        });
        JCB_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_CategoriaActionPerformed(evt);
            }
        });

        JCB_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCB_ProveedorMouseClicked(evt);
            }
        });
        JCB_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ProveedorActionPerformed(evt);
            }
        });

        JCB_Clasificacion.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Clasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCB_ClasificacionMouseClicked(evt);
            }
        });
        JCB_Clasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ClasificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JC_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCB_Categoria)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JC_Clasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCB_Clasificacion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JC_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCB_Proveedor))
                    .addComponent(TFRI_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(JC_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JC_Clasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(JCB_Categoria, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(JCB_Clasificacion))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JC_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(JCB_Proveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFRI_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 560, 120));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_user.png"))); // NOI18N
        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, -1, -1));

        JT_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Sistema", "Camara", "Pantalla", "Color"
            }
        ));
        JT_Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_TablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JT_Tabla);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 560, 150));

        TFRI_Cantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_CantidadActionPerformed(evt);
            }
        });
        TFRI_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_CantidadKeyTyped(evt);
            }
        });
        jPanel1.add(TFRI_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 90, -1));

        jLabel24.setText("Cantidad");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        TFRI_Precio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_PrecioActionPerformed(evt);
            }
        });
        TFRI_Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_PrecioKeyTyped(evt);
            }
        });
        jPanel1.add(TFRI_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 70, -1));

        jLabel32.setText("Precio");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/up.png"))); // NOI18N
        jButton5.setText("Siguiente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, -1, -1));

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 290));

        JTP_Pestaña.addTab("Producto", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        JT_Compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Sistema", "Camara", "Pantalla", "Color", "Cantidad", "Precio"
            }
        ));
        jScrollPane2.setViewportView(JT_Compra);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma  de  pago"));

        JRB_Contado.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JRB_Contado);
        JRB_Contado.setText("Contado");
        JRB_Contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_ContadoActionPerformed(evt);
            }
        });

        JRB_Credito.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JRB_Credito);
        JRB_Credito.setText("Credito");
        JRB_Credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_CreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JRB_Contado)
                    .addComponent(JRB_Credito))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JRB_Contado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JRB_Credito)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TFRI_Numero_Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_Numero_FacturaActionPerformed(evt);
            }
        });
        TFRI_Numero_Factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_Numero_FacturaKeyTyped(evt);
            }
        });

        jLabel23.setText("Numero de factura");

        jLabel25.setText("Proveedor");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));

        JDC_Pago.setDateFormatString("dd-MM-yyyy");

        JDC_Compra.setDateFormatString("dd-MM-yyyy");
        JDC_Compra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDC_CompraPropertyChange(evt);
            }
        });

        jLabel26.setText("Compra");

        jLabel27.setText("Pago");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(JDC_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(JDC_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(JDC_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDC_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        jButton6.setText("Remover");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(TFRI_Numero_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)))
                .addContainerGap(267, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jButton2)
                .addGap(70, 70, 70)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(66, 66, 66)
                .addComponent(jButton3)
                .addGap(118, 118, 118))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(TFRI_Numero_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(7, 7, 7)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        JTP_Pestaña.addTab("Comprobante", jPanel7);

        jPanel6.add(JTP_Pestaña, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 850, 390));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFRI_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_NombreActionPerformed

    private void TFRI_CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_CantidadActionPerformed
        TFRI_Cantidad.transferFocus();
    }//GEN-LAST:event_TFRI_CantidadActionPerformed

    private void TFRI_PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_PrecioActionPerformed

    private void TFRI_Numero_FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_Numero_FacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_Numero_FacturaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JT_TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_TablaMouseClicked
        //Variables de la tabla
        ImageIcon foto;
        InputStream is;
        ImageIcon newicon = null;
        filaSeleccionada = JT_Tabla.getSelectedRow();

        //Datos Recuperados de la tabla
        Id_Producto = Integer.parseInt(JT_Tabla.getValueAt(filaSeleccionada, 0).toString());
        Nombre_Producto = JT_Tabla.getValueAt(filaSeleccionada, 1).toString();
        Sistema_Producto = JT_Tabla.getValueAt(filaSeleccionada, 2).toString();
        Camara_Producto = JT_Tabla.getValueAt(filaSeleccionada, 3).toString();
        Pantalla_Producto = JT_Tabla.getValueAt(filaSeleccionada, 4).toString();
        Color_Producto = JT_Tabla.getValueAt(filaSeleccionada, 5).toString();

        Datos.abrirConexion();
        Datos.Buscar("select * from producto where Id_Producto=" + Id_Producto + "", "");
        try {
            while (Datos.rs.next()) {
//                Precio_Unitario = Datos.rs.getFloat("Precio_Unitario");
//                Ganancia = Datos.rs.getInt("Ganancia");
//                Existencia_Minima = Datos.rs.getInt("Stock");
//                Estado = Datos.rs.getString("Estado");
//                nomb = Datos.rs.getString("Nombre_Producto");
//                tela = Datos.rs.getString("Tela");
//                cuello = Datos.rs.getString("Cuello");
                is = Datos.rs.getBinaryStream("foto");
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
                newicon = new ImageIcon(newimg);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar en producto\nEvento Clic Tabla");
        }
        Datos.cerrarConexion();
        Datos.abrirConexion();
        Id_Proveedor = BuscarID("Select Id_Proveedor FROM producto WHERE Id_Producto=" + Id_Producto + " ", "proveedor");
        Datos.cerrarConexion();
        lblfoto.setIcon((Icon) (newicon));
        TFRI_Cantidad.setEnabled(true);
        TFRI_Precio.setEnabled(true);
        TFRI_Cantidad.requestFocus();

    }//GEN-LAST:event_JT_TablaMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JC_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JC_ProveedorActionPerformed
        if (dt.getRowCount() != 0) {
            llenar_tabla = true;
            AccionTabla();
        } else {
            if (llenar_tabla == true) {
                AccionTabla();
            }
        }
    }//GEN-LAST:event_JC_ProveedorActionPerformed
    public void AccionTabla() {
        limpiar_Tabla();
        Datos.abrirConexion();
        proveedor_id = BuscarID("select * from proveedor where Nombre_Proveedor='" + JC_Proveedor.getSelectedItem().toString() + "'", "proveedor");
        System.out.println("proveedor " + proveedor_id);
        Datos.cerrarConexion();
        Llenar(sql_tabla + " Where Id_Departamento=" + Numero_Departamento + " AND Id_Proveedor=" + proveedor_id + "", "producto");
    }

    public void limpiar_Tabla() {
        while (dt.getRowCount() != 0) {
            limpiarFila();
        }
    }

    public void limpiarFila() {
        if (dt.getRowCount() > 0) {
            for (int i = 0; i <= dt.getRowCount(); i++) {
                dt.removeRow(0);
            }
        }
    }

    public void limpiar_Tabla2() {
        while (dt2.getRowCount() != 0) {
            limpiarFila();
        }
    }

    public void limpiarFila2() {
        if (dt2.getRowCount() > 0) {
            for (int i = 0; i <= dt2.getRowCount(); i++) {
                dt2.removeRow(0);
            }
        }
    }
    private void TFRI_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_NombreKeyReleased
        if (JC_Categoria.getItemCount() == 0 || JC_Clasificacion.getItemCount() == 0 || JC_Proveedor.getItemCount() == 0) {

        } else {
            String categoria = JC_Categoria.getSelectedItem().toString();
            String clasificacion = JC_Clasificacion.getSelectedItem().toString();
            String proveedor = JC_Proveedor.getSelectedItem().toString();
////            String estado = JC_Estado.getSelectedItem().toString();

            Datos.abrirConexion();
            int id_clasificacion = BuscarID("select * from bdalmacen.clasificacion where Nombre_Clasificacion='" + clasificacion + "'", "clasificacion");
            int id_proveedor = BuscarID("select * from bdalmacen.proveedor where Nombre_Proveedor='" + proveedor + "'", "clasificacion");
            Datos.cerrarConexion();

            if (TFRI_Nombre.getText().equals("")) {
                limpiar_Tabla();
                Datos.abrirConexion();
                proveedor_id = BuscarID("select * from proveedor where Nombre_Proveedor='" + JC_Proveedor.getSelectedItem().toString() + "'", "proveedor");
                System.out.println("proveedor " + proveedor_id);
                Datos.cerrarConexion();
                Llenar(sql_tabla + " where Id_Departamento=" + Numero_Departamento + " AND Id_Proveedor=" + proveedor_id + "", "producto");
            } else {
                System.out.println("Estado de categoria_b=" + JCB_Categoria.isSelected());
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%'  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                     CUANDO ESTE SELECCIONADO SOLO UN COMBO                                      ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Categoria='" + categoria + "'  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Clasificacion='" + clasificacion + "'  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Id_Proveedor=" + id_proveedor + "  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%'   AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                       CUANDO ESTEN SELECCIONADOs DOS COMBOS                                     ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Categoria='" + categoria + "' AND Clasificacion='" + clasificacion + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Categoria='" + categoria + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                       CUANDO ESTEN SELECCIONADOS TRES COMBOS                                    ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == false && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == false && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%'  AND Clasificacion='" + clasificacion + "' AND Categoria='" + categoria + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                      CUANDO ESTEN SELECCIONADOS TODOS COMBOS                                    ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria.isSelected() == true && JCB_Clasificacion.isSelected() == true && JCB_Proveedor.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

            }
        }
    }//GEN-LAST:event_TFRI_NombreKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int i = 0, f = 0;
        boolean op = true;

        if (0 != validar()) {
        } else {
            for (i = 0; i < JT_Compra.getRowCount(); i++) {
                if (JT_Tabla.getValueAt(JT_Tabla.getSelectedRow(), 0).equals(JT_Compra.getValueAt(i, 0))) {
                    op = false;
                    f = i;
                    break;
                }
            }
            if (op) {
                llenarTabla_compra();
            } else {
                modificarTabla_compra(f);
            }
            msm.ms_informacion("Producto agregado");
            JDC_Compra.getCalendarButton().setEnabled(true);
            TFRI_Precio.setText("");
        }
        limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TFRI_NombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFRI_NombreMouseClicked
        In_Camp();
    }//GEN-LAST:event_TFRI_NombreMouseClicked

    private void JC_CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JC_CategoriaMouseClicked
        In_Camp();
    }//GEN-LAST:event_JC_CategoriaMouseClicked

    private void JC_ProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JC_ProveedorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JC_ProveedorMouseEntered

    private void JC_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JC_ProveedorMouseClicked
        In_Camp();
    }//GEN-LAST:event_JC_ProveedorMouseClicked

    private void JC_ClasificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JC_ClasificacionMouseClicked
        In_Camp();
    }//GEN-LAST:event_JC_ClasificacionMouseClicked

    private void JCB_CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCB_CategoriaMouseClicked
        In_Camp();
    }//GEN-LAST:event_JCB_CategoriaMouseClicked

    private void JCB_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCB_ProveedorMouseClicked
        In_Camp();
    }//GEN-LAST:event_JCB_ProveedorMouseClicked

    private void JCB_ClasificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCB_ClasificacionMouseClicked
        In_Camp();
    }//GEN-LAST:event_JCB_ClasificacionMouseClicked

    private void JC_CategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JC_CategoriaItemStateChanged
        In_Camp();
    }//GEN-LAST:event_JC_CategoriaItemStateChanged

    private void JTP_PestañaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTP_PestañaMouseClicked
        In_Camp();
    }//GEN-LAST:event_JTP_PestañaMouseClicked

    private void TFRI_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_CantidadKeyTyped
        char ca = evt.getKeyChar();
        if ((ca < '0' || ca > '9')) {
            evt.consume();
        }

        int limite = 2;
        if (TFRI_Cantidad.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_CantidadKeyTyped

    private void TFRI_PrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_PrecioKeyTyped

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != '.') {
            evt.consume();
        }

        if (TFRI_Precio.getText().length() == 5) {
            evt.consume();
        }

    }//GEN-LAST:event_TFRI_PrecioKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        JTP_Pestaña.setSelectedIndex(1);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void JRB_ContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_ContadoActionPerformed
        TFRI_Numero_Factura.requestFocus();
        JDC_Compra.getCalendarButton().setEnabled(true);
        JDC_Compra.setDate(null);
        JDC_Pago.getCalendarButton().setEnabled(false);
        JDC_Pago.setDate(null);

    }//GEN-LAST:event_JRB_ContadoActionPerformed

    private void JRB_CreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_CreditoActionPerformed
        TFRI_Numero_Factura.requestFocus();
        JDC_Compra.getCalendarButton().setEnabled(true);
        JDC_Compra.setDate(null);
        JDC_Pago.getCalendarButton().setEnabled(true);
        JDC_Pago.setDate(null);
    }//GEN-LAST:event_JRB_CreditoActionPerformed

    private void JDC_CompraPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDC_CompraPropertyChange
        Date compra = null, pago = null;
        try {
            if (JDC_Compra.getDate() != null) {
                compra = JDC_Compra.getDate();
                JDC_Pago.setSelectableDateRange(compra, null);
                if (JDC_Pago.getDate() != null) {
                    pago = JDC_Pago.getDate();
                    if (pago.compareTo(compra) < 0) {
                        JDC_Pago.setDate(null);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_JDC_CompraPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int cantidad_inventario = 0;
        float precio_venta_inventario = 0;
//        if (msm.ms_pregunta("Confirme: ¿Desea realizar esta compra?") == 0) {
        if (0 != validar2()) {
        } else {
            Capturar();
            ////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////
            /////                                                              /////
            /////        ALMACENAMIENTO DE VALORES DE LA TABLA COMPRAS         /////
            /////                                                              /////
            ////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////

            metodos.setId_Compras(Id_Compra);
            metodos.setNumero_Factura(Numero_Factura);
            metodos.setTipo_Pago(Tipo_Pago);
            metodos.setFecha_Compra(Fecha_Compra);
            metodos.setFecha_Pago(Fecha_Pago);
            metodos.setTotal(Total);
            metodos.setId_Usuario(Id_Usuario);
            System.out.println("id_Proveedor" + Id_Proveedor);
            metodos.setId_Proveedor(Id_Proveedor);
            Datos.abrirConexion();
            Datos.Insertar_Compra_Ropa(metodos);
            cb.insertarAccion(mss.getNombre(),"Realizo Compra celulares");

            for (int i = 0; i < JT_Compra.getRowCount(); i++) {
                Id_Producto = Integer.parseInt(JT_Compra.getValueAt(i, 0).toString());
                Cantidad_Compa = Integer.parseInt(JT_Compra.getValueAt(i, 6).toString());
                Precio_Compra = Float.parseFloat(JT_Compra.getValueAt(i, 7).toString());

                ////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////
                ////                                                        ////
                ////  ALMACENAMIENTO DE VALORES DE LA TABLA DETALLE COMPRAS ////
                ////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////
                Id_Detalle_Compra = BuscarID("select * from detalle_compras_producto", "detalle_compras_producto");
                Id_Detalle_Compra++;
                metodos.setId_Detalle_Compras_Producto(Id_Detalle_Compra);
                metodos.setId_Compras(Id_Compra);
                metodos.setId_Producto(Id_Producto);
                metodos.setPrecio_Compra(Precio_Compra);
                metodos.setCantidad_Compra(Cantidad_Compa);
                Datos.Insertar_Detalle_Compra_Ropa(metodos);

                Datos.Buscar("select * from inventario where Producto_Id_Producto=" + Id_Producto + "", "inventario");
                try {
                    while (Datos.rs.next()) {
                        cantidad_inventario = Datos.rs.getInt("cantidad");
                        precio_venta_inventario = Datos.rs.getFloat("precio_venta");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                float ganancia = 0, preVenta;
                try {
                    Datos.Buscar("select * from producto where Id_Producto=" + Id_Producto + "", "producto");
                    if (Datos.rs.next()) {
                        ganancia = Datos.rs.getInt("ganancia");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                preVenta = Precio_Compra + Precio_Compra * (ganancia / 100);
                precio_invt = ((precio_venta_inventario * cantidad_inventario) + (Cantidad_Compa * preVenta)) / (cantidad_inventario + Cantidad_Compa);
                cantidad_inventario += Cantidad_Compa;

                Datos.Modificar2("inventario", "Cantidad=" + cantidad_inventario + ",Precio_Venta=" + precio_invt + "", "Producto_Id_Producto=" + Id_Producto + "");
            }
            Datos.cerrarConexion();
            limpiar();
            limpiar_Tabla();
            Datos.abrirConexion();
            proveedor_id = BuscarID("select * from proveedor where Nombre_Proveedor='" + JC_Proveedor.getSelectedItem().toString() + "'", "proveedor");
            System.out.println("proveedor " + proveedor_id);
            Datos.cerrarConexion();
            Llenar(sql_tabla + " Where Id_Departamento=" + Numero_Departamento + " AND Id_Proveedor=" + proveedor_id + "", "producto");
            In_Camp();
            limpiarComprobante();
            JTP_Pestaña.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void limpiarComprobante() {
        TFRI_Numero_Factura.setText("");
        buttonGroup1.clearSelection();
        JDC_Pago.setDate(null);
        JDC_Compra.setDate(null);
        limpiarFila2();
    }
    private void JCB_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CategoriaActionPerformed
        TFRI_Nombre.requestFocus();
    }//GEN-LAST:event_JCB_CategoriaActionPerformed

    private void JCB_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ProveedorActionPerformed
        TFRI_Nombre.requestFocus();
    }//GEN-LAST:event_JCB_ProveedorActionPerformed

    private void JCB_ClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ClasificacionActionPerformed
        TFRI_Nombre.requestFocus();
    }//GEN-LAST:event_JCB_ClasificacionActionPerformed

    private void TFRI_Numero_FacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_Numero_FacturaKeyTyped
        // TODO add your handling code here:
        char ca = evt.getKeyChar();
        if ((ca < '0' || ca > '9')) {
            evt.consume();
        }

        int limite = 10;
        if (TFRI_Numero_Factura.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_Numero_FacturaKeyTyped

    private void JC_ProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JC_ProveedorItemStateChanged
//        Llenar(sql_tabla + " Where Id_Departamento=" + Numero_Departamento + " AND Id_Proveedor="+JC_Proveedor.getSelectedItem().toString()+"", "producto");
    }//GEN-LAST:event_JC_ProveedorItemStateChanged

    private void TFRI_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_NombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        int limite = 26;
        if (TFRI_Nombre.getText().length() == limite) {
            evt.consume();
        }
        char ca = evt.getKeyChar();
        if ((ca < 'A' || ca > 'Z') && (ca != ' ') && (ca < '0' || ca > '9') && (ca != '/') && (ca != '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_NombreKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      limpiarComprobante();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int cantidad;
        float precio, total;
        cantidad = Integer.parseInt(JT_Compra.getValueAt(JT_Compra.getSelectedRow(), 6).toString());
        precio = Float.parseFloat(JT_Compra.getValueAt(JT_Compra.getSelectedRow(), 7).toString());
        System.out.println("cantidad" + cantidad);
        System.out.println("precio" + precio);
        total = cantidad * precio;
        Total = Total - total;
        System.out.println("total nuevo " + Total);
        dt2.removeRow(JT_Compra.getSelectedRow());

    }//GEN-LAST:event_jButton6ActionPerformed
    //Funcion que inabilita campos cantidad y precio

    public void In_Camp() {
        TFRI_Cantidad.setEnabled(false);
        TFRI_Precio.setEnabled(false);
        JT_Tabla.clearSelection();
        lblfoto.setIcon(null);
    }

    public void limpiar() {
        TFRI_Cantidad.setText("");
        TFRI_Precio.setText("");
        TFRI_Nombre.setText("");

    }

    public void limpiarCombos() {
        JC_Categoria.removeAllItems();
        JC_Clasificacion.removeAllItems();
        JC_Proveedor.removeAllItems();

    }

    public void Capturar() {
        Id_Usuario = Menu1.Id_Usuario;
        Numero_Factura = TFRI_Numero_Factura.getText();

        Fecha_Compra = fun.getFecha(JDC_Compra);
        if (JRB_Contado.isSelected()) {
            Fecha_Pago = Fecha_Compra;
            Tipo_Pago = "CONTADO";
        } else {
            Tipo_Pago = "CREDITO";
            Fecha_Pago = fun.getFecha(JDC_Pago);
        }

        Datos.abrirConexion();
        Id_Compra = BuscarID("select * from compras", "compras");
        Id_Compra++;
        Datos.cerrarConexion();

    }

    public String BuscarNombre(String SQL, String Tabla) {
        String Nombre = "";
        try {
            Datos.Buscar(SQL, "" + Tabla);
            while (Datos.rs.next()) {
                Nombre = Datos.rs.getString(2);
            }
        } catch (Exception e) {
            System.out.print("BuscarNombre Error al buscar en Tabla " + Tabla);
        }
        return Nombre;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
////        JFrame.setDefaultLookAndFeelDecorated(false);
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Compras_Celulares1().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCB_Categoria;
    private javax.swing.JCheckBox JCB_Clasificacion;
    private javax.swing.JCheckBox JCB_Proveedor;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Categoria;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Clasificacion;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Proveedor;
    private com.toedter.calendar.JDateChooser JDC_Compra;
    private com.toedter.calendar.JDateChooser JDC_Pago;
    private javax.swing.JRadioButton JRB_Contado;
    private javax.swing.JRadioButton JRB_Credito;
    private javax.swing.JTabbedPane JTP_Pestaña;
    private javax.swing.JTable JT_Compra;
    private javax.swing.JTable JT_Tabla;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Cantidad;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Nombre;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Numero_Factura;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Precio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private javax.swing.JLabel lblfoto;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables
}
