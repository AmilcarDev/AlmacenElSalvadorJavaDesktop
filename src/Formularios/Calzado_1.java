package Formularios;

import Clases.Datos_Regisro_Producto;
import Clases.Metodos_Set_Get;
import Clases.msm;
import com.integra.login.ControladorBitacora;
import com.integra.session.ModeloSession;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.edisoncor.gui.comboBox.ComboBoxRound;
import org.edisoncor.gui.textField.TextFieldRoundImage;

/**
 *
 * @author Baltazar
 */
public class Calzado_1 extends javax.swing.JFrame {

    Datos_Regisro_Producto Datos = new Datos_Regisro_Producto();
    Metodos_Set_Get metodos = new Metodos_Set_Get();
    DecimalFormat df = new DecimalFormat("0.00");
    FileInputStream fis;
    int longitudBytes, apretafoto = 0;

    int cont = 0;
    String paquete = "Iconos";
    Boolean b_categoria = false;
    Boolean b_clasificacion = false;
    Boolean b_proveedor = false;
    Boolean b_talla = false;
    Boolean b_estilo = false;
    Boolean b_marca = false;
    Boolean b_color = false;

    Boolean Modificar = false;

    ////////////////////////////////////        
    //  Variables del boton Guardar  //
    int Numero_Departamento = 4;
    int ID_Producto = 0;
    int ID_Categoria = 0;
    int ID_Clasificacion = 0;
    int ID_Proveedor = 0;
    int ID_Talla = 0;
    int ID_Estilo = 0;
    int ID_Marca = 0;
    int ID_Color = 0;

    int id_Modificar_Producto;

    int filaSeleccionada;

    int ID_Proveedor_b = 0;
    int ID_Categoria_b = 0;
    int ID_Clasificacion_b = 0;
    String Nombre_Producto;
    String Nombre_Categoria;
    String Nombre_Clasificacion;
    String Nombre_Proveedor;
    String Nombre_Talla;
    String Nombre_Estilo;
    String Nombre_Marca;
    String Nombre_Color;
    String sql_tabla = "Select Id_Producto,Nombre_Producto,Talla,Color,Marca,Id_Proveedor,Clasificacion,Categoria,Estado from producto";

    float Ganancia;
    int Procentaje_Ganancia, Stock;
    float Precio_Venta;
    String Estado_Producto;

    DefaultTableModel dt = new DefaultTableModel();
    DefaultTableCellRenderer tcr;
    Vector v = new Vector();
    Mensaje_Aplicacion Men_A;

     ModeloSession mss;
    ControladorBitacora cb;
    public Calzado_1(ModeloSession mss) {
        this.mss=mss;
        cb= new ControladorBitacora();
        initComponents();
        dt = (DefaultTableModel) JT_Tabla.getModel();
        JC_Categoria.setBackground(Color.WHITE);
        JC_Clasificacion.setBackground(Color.WHITE);
        JC_Proveedor.setBackground(Color.WHITE);
        JC_Talla.setBackground(Color.WHITE);

        JC_Marca.setBackground(Color.WHITE);
        JC_Color.setBackground(Color.WHITE);
        JC_Categoria_b.setBackground(Color.WHITE);
        JC_Proveedor_b.setBackground(Color.WHITE);
        JC_Clasificacion_b.setBackground(Color.WHITE);
        JC_Estado_b.setBackground(Color.WHITE);

        Boolean a = JCB_Categoria.isSelected();
        System.out.println("estadoInicio =" + a);
        DesHabilitar();
        tcr = new DefaultTableCellRenderer();
        Llenar(sql_tabla + " Where Id_Departamento=" + Numero_Departamento + "", "producto");
        cargarCombo(JC_Categoria_b, "select * from categoria where Id_Departamento=" + Numero_Departamento + "", "categoria");
        cargarCombo(JC_Clasificacion_b, "select * from clasificacion where Id_Departamento=" + Numero_Departamento + "", "clasificacion");
        cargarCombo(JC_Proveedor_b, "select * from proveedor", "proveedor");
        jPanel2.setVisible(false);
    }

    public void Buscar_Existencia(TextFieldRoundImage d, String Tabla, String Campo) {
        String Nombre = "";
        Datos.abrirConexion();
        this.Datos.Buscar("select * from " + Tabla + " where " + Campo + "='" + d.getText() + "' AND Id_Departamento=" + Numero_Departamento + "", Tabla);
        try {
            while (Datos.rs.next()) {
                Nombre = Datos.rs.getString(Campo);
            }
        } catch (Exception e) {

        }
        Datos.cerrarConexion();
        if (Nombre != "") {
            msm.ms_informacion("Dato ya existe en tabla " + Tabla);
        }
    }
    public void Buscar_Existencia2(TextFieldRoundImage d, String Tabla, String Campo) {
        String Nombre = "";
        Datos.abrirConexion();
        this.Datos.Buscar("select * from " + Tabla + " where " + Campo + "='" + d.getText() + "' AND Id_Departamento=" + Numero_Departamento + "", Tabla);
        try {
            while (Datos.rs.next()) {
                Nombre = Datos.rs.getString(Campo);
            }
        } catch (Exception e) {

        }
        Datos.cerrarConexion();
        if (Nombre != "") {
            d.setText("");
        }
    }

    public void CentrarColumna(int columna) {
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        JT_Tabla.getColumnModel().getColumn(columna).setCellRenderer(tcr);
    }

    public void cargarFoto() {

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
        j.setCurrentDirectory(new File("C:\\Users\\Baltazar\\Documents\\Productos Almacen\\Zapatos"));
        j.setFileFilter(filtro);

        int estado = j.showOpenDialog(null);

        if (estado == JFileChooser.APPROVE_OPTION) {

            try {

                fis = new FileInputStream(j.getSelectedFile());
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    lblfoto.setIcon(null);
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
                    lblfoto.setIcon(new ImageIcon(icono));
                    lblfoto.updateUI();
                    apretafoto = 1;
                    System.out.println("longitud de bytes: " + longitudBytes);
                } catch (IOException e) {
                    System.out.println("error al cargar foto IO" + e);
                }

            } catch (Exception e) {
                System.out.println("error al cargar file" + e);
            }

        }

    }

    public void Llenar(String SQL, String tabla) {
        Ajuste_Columna_Tabla(JT_Tabla, 0, 0, 0, 0);
        Ajuste_Columna_Tabla(JT_Tabla, 2, 60, 60, 60);
        Ajuste_Columna_Tabla(JT_Tabla, 5, 0, 0, 0);
//        Ajuste_Columna_Tabla(JT_Tabla, 7, 0, 0, 0);
//        Ajuste_Columna_Tabla(JT_Tabla, 8, 0, 0, 0);
//        Ajuste_Columna_Tabla(JT_Tabla, 9, 0, 0, 0);

        CentrarColumna(2);
        CentrarColumna(8);
        Datos.abrirConexion();
        try {
            Datos.Buscar(SQL, tabla);
            while (Datos.rs.next()) {
                v = new java.util.Vector();
                v.add(Datos.rs.getInt("Id_Producto"));
                v.add(Datos.rs.getString("Nombre_Producto"));
                v.add(Datos.rs.getString("Talla"));
                v.add(Datos.rs.getString("Color"));
                v.add(Datos.rs.getString("Marca"));
                v.add(Datos.rs.getInt("Id_Proveedor"));
                v.add(Datos.rs.getString("Clasificacion"));
                v.add(Datos.rs.getString("Categoria"));
                v.add(Datos.rs.getString("Estado"));
                dt.addRow(v);
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo LLenar");
        }
        Datos.cerrarConexion();

    }

    public void Ajuste_Columna_Tabla(JTable T, int Columna, int MaxWidth, int MinWidth, int PreferredWidth) {
        T.getColumnModel().getColumn(Columna).setMaxWidth(MaxWidth);
        T.getColumnModel().getColumn(Columna).setMinWidth(MinWidth);
        T.getColumnModel().getColumn(Columna).setPreferredWidth(PreferredWidth);
    }

    public void BorrarCombo(ComboBoxRound combo) {
        int categoria = combo.getItemCount();
        for (int i = 0; i < categoria; i++) {

            combo.removeItemAt(0);

        }

    }

    public void precio(float precio) {
        Ganancia = (float) precio * Float.parseFloat(TFRI_Precio_Unitario.getText());
        System.out.println("Ganancia" + Ganancia);
        Precio_Venta = Ganancia + Float.parseFloat(TFRI_Precio_Unitario.getText());
        System.out.println("Precio_Venta= " + Precio_Venta);
        TFRI_Precio_Venta.setText(String.valueOf(df.format(Precio_Venta)));
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

    public int BuscarID(String SQL, String Tabla) {
        int id = 0;
        try {
            Datos.Buscar(SQL, "" + Tabla);
            while (Datos.rs.next()) {
                id = Datos.rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.print("Error al buscar en Tabla " + Tabla);
        }
        return id;
    }

    public String BuscarNombre(String SQL, String Tabla) {
        String Nombre = "";
        try {
            Datos.Buscar(SQL, "" + Tabla);
            while (Datos.rs.next()) {
                Nombre = Datos.rs.getString(2);
            }
        } catch (Exception e) {
            System.out.print("Error al buscar en Tabla " + Tabla);
        }
        return Nombre;
    }

    public void Limpiar() {
        JC_Categoria.removeAllItems();
        JC_Clasificacion.removeAllItems();
        JC_Proveedor.removeAllItems();
        JC_Talla.removeAllItems();

        JC_Color.removeAllItems();
        JC_Marca.removeAllItems();
        BG_Grupo.clearSelection();
        BG_Grupo2.clearSelection();
        TFRI_Categoria.setText("");
        TFRI_Clasificacion.setText("");
        TFRI_Proveedor.setText("");
        TFRI_Nombre.setText("");
        TFRI_Cantidad.setText("");
        TFRI_Precio_Venta.setText("");
        TFRI_Existencia_Minima.setText("");
        TFRI_Precio_Unitario.setText("");
        TFRI_Otro.setText("");
        TFRI_Talla.setText("");

        TFRI_Marca.setText("");
        TFRI_Color.setText("");
        lblfoto.setIcon(null);

//        JCB_Categoria.setSelectedIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
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
        jPanel6 = new javax.swing.JPanel();
        JTP_Pestaña = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        TFRI_Nombre = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        JC_Clasificacion = new org.edisoncor.gui.comboBox.ComboBoxRound();
        JC_Proveedor = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jPanel5 = new javax.swing.JPanel();
        JC_Marca = new org.edisoncor.gui.comboBox.ComboBoxRound();
        JC_Color = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel31 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        TFRI_Existencia_Minima = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel26 = new javax.swing.JLabel();
        JC_Talla = new org.edisoncor.gui.comboBox.ComboBoxRound();
        JCB_Marca = new javax.swing.JCheckBox();
        JCB_Color = new javax.swing.JCheckBox();
        JCB_Talla = new javax.swing.JCheckBox();
        TFRI_Talla = new org.edisoncor.gui.textField.TextFieldRoundImage();
        TFRI_Marca = new org.edisoncor.gui.textField.TextFieldRoundImage();
        TFRI_Color = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jPanel2 = new javax.swing.JPanel();
        JCB_Activo = new javax.swing.JRadioButton();
        JCB_Inactivo = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        TFRI_Precio_Venta = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        JC_Categoria = new org.edisoncor.gui.comboBox.ComboBoxRound();
        TFRI_Categoria = new org.edisoncor.gui.textField.TextFieldRoundImage();
        JB_Salir = new javax.swing.JButton();
        JB_Cancelar = new javax.swing.JButton();
        JB_Guardar = new javax.swing.JButton();
        JB_Nuevo = new javax.swing.JButton();
        JCB_Clasificacion = new javax.swing.JCheckBox();
        JCB_Categoria = new javax.swing.JCheckBox();
        JCB_Proveedor = new javax.swing.JCheckBox();
        TFRI_Cantidad = new org.edisoncor.gui.textField.TextFieldRoundImage();
        TFRI_Clasificacion = new org.edisoncor.gui.textField.TextFieldRoundImage();
        TFRI_Proveedor = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jPanel4 = new javax.swing.JPanel();
        JCB_Diez = new javax.swing.JCheckBox();
        JCB_Veite = new javax.swing.JCheckBox();
        TFRI_Otro = new org.edisoncor.gui.textField.TextFieldRoundImage();
        JCB_Otro = new javax.swing.JCheckBox();
        TFRI_Precio_Unitario = new org.edisoncor.gui.textField.TextFieldRoundImage();
        JB_Modificar = new javax.swing.JButton();
        JB_Cancelar1 = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        btnsubir = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JT_Tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TFRI_Nombre_B = new org.edisoncor.gui.textField.TextFieldRoundImage();
        JC_Categoria_b = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel6 = new javax.swing.JLabel();
        JC_Clasificacion_b = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JC_Proveedor_b = new org.edisoncor.gui.comboBox.ComboBoxRound();
        JC_Estado_b = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel9 = new javax.swing.JLabel();
        JCB_Categoria_b = new javax.swing.JCheckBox();
        JCB_Clasificacion_b = new javax.swing.JCheckBox();
        JCB_Proveedor_b = new javax.swing.JCheckBox();
        JCB_Estado_b = new javax.swing.JCheckBox();

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
        jLabel2.setText("Administración de Zapatos");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button-close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRectTranslucido1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTP_Pestaña.setMinimumSize(new java.awt.Dimension(600, 310));
        JTP_Pestaña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTP_PestañaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTP_PestañaMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(173, 173, 173));
        jLabel49.setText("-------------------------------------------------------------------------------------------------------------------");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 590, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(173, 173, 173));
        jLabel53.setText("__________________________________________________________________________________");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 590, 30));

        TFRI_Nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_NombreActionPerformed(evt);
            }
        });
        TFRI_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_NombreKeyTyped(evt);
            }
        });
        jPanel1.add(TFRI_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 195, -1));

        jLabel22.setText("Proveedor");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel28.setText("Categoría ");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        jLabel29.setText("Sección");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 80, 10));

        JC_Clasificacion.setAnchoDeBorde(2.0F);
        JC_Clasificacion.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Clasificacion.setFocusable(false);
        JC_Clasificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(JC_Clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 150, -1));

        JC_Proveedor.setAnchoDeBorde(2.0F);
        JC_Proveedor.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Proveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(JC_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JC_Marca.setAnchoDeBorde(2.0F);
        JC_Marca.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Marca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel5.add(JC_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 48, 150, -1));

        JC_Color.setAnchoDeBorde(2.0F);
        JC_Color.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Color.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel5.add(JC_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 74, 150, -1));

        jLabel31.setText("Color");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 76, -1, -1));

        jLabel51.setText("Marca");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 53, -1, -1));

        jLabel50.setText("Talla");
        jPanel5.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 28, -1, -1));

        TFRI_Existencia_Minima.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Existencia_Minima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TFRI_Existencia_MinimaMouseClicked(evt);
            }
        });
        TFRI_Existencia_Minima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_Existencia_MinimaActionPerformed(evt);
            }
        });
        TFRI_Existencia_Minima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_Existencia_MinimaKeyTyped(evt);
            }
        });
        jPanel5.add(TFRI_Existencia_Minima, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 80, -1));

        jLabel26.setText("Existencia Mínima ");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        JC_Talla.setAnchoDeBorde(2.0F);
        JC_Talla.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Talla.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel5.add(JC_Talla, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 22, 150, -1));

        JCB_Marca.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Marca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        JCB_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_MarcaActionPerformed(evt);
            }
        });
        jPanel5.add(JCB_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        JCB_Color.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Color.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        JCB_Color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ColorActionPerformed(evt);
            }
        });
        jPanel5.add(JCB_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        JCB_Talla.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Talla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        JCB_Talla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_TallaActionPerformed(evt);
            }
        });
        jPanel5.add(JCB_Talla, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        TFRI_Talla.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Talla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_TallaActionPerformed(evt);
            }
        });
        TFRI_Talla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRI_TallaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_TallaKeyTyped(evt);
            }
        });
        jPanel5.add(TFRI_Talla, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 22, 150, -1));

        TFRI_Marca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_MarcaActionPerformed(evt);
            }
        });
        TFRI_Marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRI_MarcaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_MarcaKeyTyped(evt);
            }
        });
        jPanel5.add(TFRI_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 48, 150, -1));

        TFRI_Color.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_ColorActionPerformed(evt);
            }
        });
        TFRI_Color.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRI_ColorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_ColorKeyTyped(evt);
            }
        });
        jPanel5.add(TFRI_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 74, 150, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado "));

        JCB_Activo.setBackground(new java.awt.Color(255, 255, 255));
        BG_Grupo.add(JCB_Activo);
        JCB_Activo.setText("Activo");
        JCB_Activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ActivoActionPerformed(evt);
            }
        });

        JCB_Inactivo.setBackground(new java.awt.Color(255, 255, 255));
        BG_Grupo.add(JCB_Inactivo);
        JCB_Inactivo.setText("Inactivo");
        JCB_Inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_InactivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JCB_Activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(JCB_Inactivo)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Activo)
                    .addComponent(JCB_Inactivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 220, 60));

        jLabel30.setText("Precio venta");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        TFRI_Precio_Venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Precio_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_Precio_VentaActionPerformed(evt);
            }
        });
        jPanel5.add(TFRI_Precio_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 80, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 630, 140));

        jLabel25.setText("Precio unitario");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        jLabel27.setText("Cantidad");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        JC_Categoria.setAnchoDeBorde(2.0F);
        JC_Categoria.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Categoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(JC_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 150, -1));

        TFRI_Categoria.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_CategoriaActionPerformed(evt);
            }
        });
        TFRI_Categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRI_CategoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_CategoriaKeyTyped(evt);
            }
        });
        jPanel1.add(TFRI_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 150, -1));

        JB_Salir.setBackground(new java.awt.Color(179, 212, 244));
        JB_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        JB_Salir.setText("Salir");
        JB_Salir.setPreferredSize(new java.awt.Dimension(101, 31));
        JB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_SalirActionPerformed(evt);
            }
        });
        jPanel1.add(JB_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, -1, -1));

        JB_Cancelar.setBackground(new java.awt.Color(179, 212, 244));
        JB_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        JB_Cancelar.setText("Cancelar");
        JB_Cancelar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JB_CancelarStateChanged(evt);
            }
        });
        JB_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(JB_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        JB_Guardar.setBackground(new java.awt.Color(179, 212, 244));
        JB_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        JB_Guardar.setText("Guardar");
        JB_Guardar.setPreferredSize(new java.awt.Dimension(108, 31));
        JB_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(JB_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        JB_Nuevo.setBackground(new java.awt.Color(179, 212, 244));
        JB_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_user.png"))); // NOI18N
        JB_Nuevo.setText("Nuevo");
        JB_Nuevo.setPreferredSize(new java.awt.Dimension(101, 31));
        JB_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_NuevoActionPerformed(evt);
            }
        });
        jPanel1.add(JB_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        JCB_Clasificacion.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Clasificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        JCB_Clasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ClasificacionActionPerformed(evt);
            }
        });
        jPanel1.add(JCB_Clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        JCB_Categoria.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        JCB_Categoria.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JCB_CategoriaStateChanged(evt);
            }
        });
        JCB_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCB_CategoriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JCB_CategoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JCB_CategoriaMouseExited(evt);
            }
        });
        JCB_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_CategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(JCB_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        JCB_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        JCB_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        JCB_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(JCB_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

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
        jPanel1.add(TFRI_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 115, -1));

        TFRI_Clasificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Clasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_ClasificacionActionPerformed(evt);
            }
        });
        TFRI_Clasificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRI_ClasificacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_ClasificacionKeyTyped(evt);
            }
        });
        jPanel1.add(TFRI_Clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 150, -1));

        TFRI_Proveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_ProveedorActionPerformed(evt);
            }
        });
        TFRI_Proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_ProveedorKeyTyped(evt);
            }
        });
        jPanel1.add(TFRI_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ganancia"));

        JCB_Diez.setBackground(new java.awt.Color(255, 255, 255));
        BG_Grupo2.add(JCB_Diez);
        JCB_Diez.setText("10%");
        JCB_Diez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_DiezActionPerformed(evt);
            }
        });

        JCB_Veite.setBackground(new java.awt.Color(255, 255, 255));
        BG_Grupo2.add(JCB_Veite);
        JCB_Veite.setText("20%");
        JCB_Veite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_VeiteActionPerformed(evt);
            }
        });

        TFRI_Otro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Otro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_OtroActionPerformed(evt);
            }
        });
        TFRI_Otro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFRI_OtroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_OtroKeyTyped(evt);
            }
        });

        JCB_Otro.setBackground(new java.awt.Color(255, 255, 255));
        BG_Grupo2.add(JCB_Otro);
        JCB_Otro.setText("Otro");
        JCB_Otro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_OtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCB_Diez)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCB_Veite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCB_Otro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFRI_Otro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Diez)
                    .addComponent(JCB_Veite)
                    .addComponent(TFRI_Otro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Otro))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, 60));

        TFRI_Precio_Unitario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TFRI_Precio_Unitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_Precio_UnitarioActionPerformed(evt);
            }
        });
        TFRI_Precio_Unitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_Precio_UnitarioKeyTyped(evt);
            }
        });
        jPanel1.add(TFRI_Precio_Unitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 115, -1));

        JB_Modificar.setBackground(new java.awt.Color(179, 212, 244));
        JB_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        JB_Modificar.setText("Modificar");
        JB_Modificar.setPreferredSize(new java.awt.Dimension(114, 31));
        JB_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(JB_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        JB_Cancelar1.setBackground(new java.awt.Color(179, 212, 244));
        JB_Cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        JB_Cancelar1.setText("Cancelar");
        JB_Cancelar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JB_Cancelar1StateChanged(evt);
            }
        });
        JB_Cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Cancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(JB_Cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, 250));

        btnsubir.setBackground(new java.awt.Color(179, 212, 244));
        btnsubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/addfoto.png"))); // NOI18N
        btnsubir.setText("Subir Foto");
        btnsubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel24.setText("Nombre");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        JTP_Pestaña.addTab("Ingresar", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        JT_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Talla", "Color", "Marca", "Proveedor", "Clasificacion", "Categoria", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JT_Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_TablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JT_Tabla);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Busqueda"));

        jLabel5.setText("Nombre");

        TFRI_Nombre_B.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFRI_Nombre_BKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFRI_Nombre_BKeyTyped(evt);
            }
        });

        JC_Categoria_b.setAnchoDeBorde(2.0F);
        JC_Categoria_b.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Categoria_b.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JC_Categoria_bItemStateChanged(evt);
            }
        });

        jLabel6.setText("Categoria");

        JC_Clasificacion_b.setAnchoDeBorde(2.0F);
        JC_Clasificacion_b.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Clasificacion_b.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JC_Clasificacion_bItemStateChanged(evt);
            }
        });

        jLabel7.setText("Sección");

        jLabel8.setText("Proveedor");

        JC_Proveedor_b.setAnchoDeBorde(2.0F);
        JC_Proveedor_b.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Proveedor_b.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JC_Proveedor_bItemStateChanged(evt);
            }
        });

        JC_Estado_b.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        JC_Estado_b.setAnchoDeBorde(2.0F);
        JC_Estado_b.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_Estado_b.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JC_Estado_bItemStateChanged(evt);
            }
        });

        jLabel9.setText("Estado");

        JCB_Categoria_b.setBackground(new java.awt.Color(255, 255, 255));

        JCB_Clasificacion_b.setBackground(new java.awt.Color(255, 255, 255));

        JCB_Proveedor_b.setBackground(new java.awt.Color(255, 255, 255));

        JCB_Estado_b.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JC_Clasificacion_b, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(JC_Categoria_b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(JCB_Categoria_b)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JC_Proveedor_b, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(JCB_Clasificacion_b)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JC_Estado_b, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(TFRI_Nombre_B, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCB_Proveedor_b)
                    .addComponent(JCB_Estado_b))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JC_Categoria_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JC_Proveedor_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(JCB_Categoria_b)
                    .addComponent(JCB_Proveedor_b))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JC_Clasificacion_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JC_Estado_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(JCB_Clasificacion_b)
                    .addComponent(JCB_Estado_b))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFRI_Nombre_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        JTP_Pestaña.addTab("Buscar", jPanel7);

        jPanel6.add(JTP_Pestaña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 950, 430));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCB_InactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_InactivoActionPerformed

    }//GEN-LAST:event_JCB_InactivoActionPerformed

    private void TFRI_TallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_TallaActionPerformed
        Buscar_Existencia(TFRI_Talla, "talla", "Nombre_Talla");
        if (Integer.parseInt(TFRI_Talla.getText()) < 1 || Integer.parseInt(TFRI_Talla.getText()) > 14) {
            msm.ms_informacion("No es una talla valida");
            TFRI_Talla.setText("");
        }
    }//GEN-LAST:event_TFRI_TallaActionPerformed

    private void TFRI_Existencia_MinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_Existencia_MinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_Existencia_MinimaActionPerformed

    private void JCB_DiezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_DiezActionPerformed
        if (TFRI_Precio_Unitario.getText().equals("")) {
            msm.ms_alerta("Necesita ingresar primero un Precio unitario");
            BG_Grupo2.clearSelection();
            TFRI_Precio_Unitario.requestFocus();
        } else {
            precio((float) 0.10);
            TFRI_Otro.setText("");
            TFRI_Existencia_Minima.requestFocus();
            TFRI_Otro.setEnabled(false);
        }
        Procentaje_Ganancia = 10;
    }//GEN-LAST:event_JCB_DiezActionPerformed

    private void TFRI_OtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_OtroActionPerformed
        precio((float) (Integer.parseInt(TFRI_Otro.getText()) * (float) 0.01));
        this.TFRI_Existencia_Minima.requestFocus();
        TFRI_Existencia_Minima.requestFocus();

        Procentaje_Ganancia = Integer.parseInt(TFRI_Otro.getText());
    }//GEN-LAST:event_TFRI_OtroActionPerformed

    private void TFRI_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_NombreActionPerformed
        TFRI_Cantidad.requestFocus();
    }//GEN-LAST:event_TFRI_NombreActionPerformed

    private void TFRI_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_CategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_CategoriaActionPerformed

    private void JB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_SalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_JB_SalirActionPerformed

    private void JB_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_GuardarActionPerformed
        Buscar_Existencia2(TFRI_Talla, "talla", "Nombre_Talla");        
        Buscar_Existencia2(TFRI_Marca, "marca", "Nombre_Marca");
        Buscar_Existencia2(TFRI_Color, "color", "Nombre_Color");
        if (0 != validar()) {
        } else {
            this.Datos.abrirConexion();

            if (Integer.parseInt(TFRI_Existencia_Minima.getText()) < Integer.parseInt(TFRI_Cantidad.getText())) {

                Busqueda_Insercion();
                Estado_Producto = "Activo";
                Stock = Integer.parseInt(TFRI_Existencia_Minima.getText());
                ////////////////////////////////////////////////////////////////////////////////////////////////
                metodos.setId_Producto(ID_Producto);
                metodos.setNombre_Producto(TFRI_Nombre.getText());
                metodos.setStock(Stock);
                metodos.setId_Proveedor(ID_Proveedor);
                metodos.setId_Departamento(Numero_Departamento);
                metodos.setPrecio_unitario(Float.parseFloat(TFRI_Precio_Unitario.getText()));
                metodos.setTalla(Nombre_Talla);
                metodos.setMarca(Nombre_Marca);
                metodos.setColor(Nombre_Color);
                metodos.setCategoria(Nombre_Categoria);
                metodos.setClasificacion(Nombre_Clasificacion);
                metodos.setEstado(Estado_Producto);
                metodos.setGanancia(Procentaje_Ganancia);
                metodos.setFis(fis);
                metodos.setLongitudBytes(longitudBytes);
                ////////////////////////////////////////////////////////////////////////////////////////////////
                Datos.Insertar_Datos_Zapatos(metodos);
                Datos.Insertar2("inventario", "Producto_Id_Producto,Cantidad,Precio_Venta", "" + ID_Producto + "," + Integer.parseInt(TFRI_Cantidad.getText()) + "," + Float.parseFloat(TFRI_Precio_Venta.getText()) + "");
                cb.insertarAccion(mss.getNombre(),"Registró calzado");
                this.Datos.cerrarConexion();

                ValoresBanderas();
                Limpiar();
                CargarCombo();
            } else {
                msm.ms_alerta("Existencia no puede ser mayor a cantidad");
            }

        }
    }//GEN-LAST:event_JB_GuardarActionPerformed
    public void ValoresBanderas() {
        b_categoria = false;
        JC_Categoria.setVisible(true);
        JCB_Categoria.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));

        b_clasificacion = false;
        JC_Clasificacion.setVisible(true);
        JCB_Clasificacion.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));

        b_proveedor = false;
        JC_Proveedor.setVisible(true);
        JCB_Proveedor.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));

        b_talla = false;
        JC_Talla.setVisible(true);
        JCB_Talla.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));

        b_estilo = false;

        b_marca = false;
        JC_Marca.setVisible(true);
        JCB_Marca.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));

        b_color = false;
        JC_Color.setVisible(true);
        JCB_Color.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
    }

    public void CargarCombo() {
        cargarCombo(JC_Categoria, "select * from categoria where Id_Departamento=" + Numero_Departamento + "", "categoria");
        cargarCombo(JC_Clasificacion, "select * from clasificacion where Id_Departamento=" + Numero_Departamento + "", "clasificacion");
        cargarCombo(JC_Proveedor, "select * from proveedor where Estado='Activo'", "proveedor");
        cargarCombo(JC_Talla, "select * from talla where Id_Departamento=" + Numero_Departamento + " order by Nombre_Talla asc", "Talla");
        cargarCombo(JC_Color, "select * from color where Id_Departamento=" + Numero_Departamento + "", "Color");
        cargarCombo(JC_Marca, "select * from marca where Id_Departamento=" + Numero_Departamento + " order by Nombre_Marca asc", "Marca");
    }
    private void JB_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_NuevoActionPerformed
        Limpiar();
        CargarCombo();
        Habilitar();

    }//GEN-LAST:event_JB_NuevoActionPerformed

    private void JCB_TallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_TallaActionPerformed
        if (JCB_Talla.isSelected() == true) {
            b_talla = true;
            TFRI_Talla.requestFocus();
            JC_Talla.setVisible(false);
            JCB_Talla.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/AgregarRojo.png")));
        } else {
            b_talla = false;
            JC_Talla.setVisible(true);
            JCB_Talla.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));

        }


    }//GEN-LAST:event_JCB_TallaActionPerformed

    private void TFRI_Precio_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_Precio_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_Precio_VentaActionPerformed

    private void TFRI_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_MarcaActionPerformed
        Buscar_Existencia(TFRI_Marca, "marca", "Nombre_Marca");
    }//GEN-LAST:event_TFRI_MarcaActionPerformed

    private void TFRI_ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_ColorActionPerformed
        Buscar_Existencia(TFRI_Color, "color", "Nombre_Color");
    }//GEN-LAST:event_TFRI_ColorActionPerformed

    private void JCB_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_MarcaActionPerformed
        if (JCB_Marca.isSelected() == true) {
            b_marca = true;
            JC_Marca.setVisible(false);
            TFRI_Marca.requestFocus();
            JCB_Marca.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/AgregarRojo.png")));
        } else {
            b_marca = false;
            JC_Marca.setVisible(true);
            JCB_Marca.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

    }//GEN-LAST:event_JCB_MarcaActionPerformed

    private void JCB_ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ColorActionPerformed
        if (JCB_Color.isSelected() == true) {
            b_color = true;
            JC_Color.setVisible(false);
            TFRI_Color.requestFocus();
            JCB_Color.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/AgregarRojo.png")));
        } else {
            b_color = false;
            JC_Color.setVisible(true);
            JCB_Color.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

    }//GEN-LAST:event_JCB_ColorActionPerformed

    private void TFRI_CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_CantidadActionPerformed
        TFRI_Precio_Unitario.requestFocus();
    }//GEN-LAST:event_TFRI_CantidadActionPerformed

    private void TFRI_ClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_ClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_ClasificacionActionPerformed

    private void TFRI_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_ProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_ProveedorActionPerformed

    private void JCB_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CategoriaActionPerformed
        //Accion_Checbox(JCB_Categoria,JC_Categoria,b_categoria);
        if (JCB_Categoria.isSelected() == true) {
            b_categoria = true;
            JC_Categoria.setVisible(false);
            TFRI_Categoria.requestFocus();
            JCB_Categoria.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/AgregarRojo.png")));
        } else {
            b_categoria = false;
            JC_Categoria.setVisible(true);
            JCB_Categoria.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
    }//GEN-LAST:event_JCB_CategoriaActionPerformed

    private void JCB_ClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ClasificacionActionPerformed
        if (JCB_Clasificacion.isSelected() == true) {
            b_clasificacion = true;
            JC_Clasificacion.setVisible(false);
            TFRI_Clasificacion.requestFocus();
            JCB_Clasificacion.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/AgregarRojo.png")));
        } else {
            b_clasificacion = false;
            JC_Clasificacion.setVisible(true);
            JCB_Clasificacion.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

    }//GEN-LAST:event_JCB_ClasificacionActionPerformed

    private void JCB_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ProveedorActionPerformed
        if (JCB_Proveedor.isSelected() == true) {
            b_proveedor = true;
            JC_Proveedor.setVisible(false);
            JCB_Proveedor.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/AgregarRojo.png")));
        } else {
            b_proveedor = false;
            JC_Proveedor.setVisible(true);
            JCB_Proveedor.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

    }//GEN-LAST:event_JCB_ProveedorActionPerformed

    private void JCB_CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCB_CategoriaMouseClicked

    }//GEN-LAST:event_JCB_CategoriaMouseClicked

    private void JCB_CategoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCB_CategoriaMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_JCB_CategoriaMouseExited

    private void JCB_CategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCB_CategoriaMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_JCB_CategoriaMouseEntered

    private void JB_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CancelarActionPerformed
        if (JCB_Categoria.isSelected() == true) {
            b_categoria = false;
            JC_Categoria.setVisible(true);
            JCB_Categoria.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
        if (JCB_Clasificacion.isSelected() == true) {
            b_clasificacion = false;
            JC_Clasificacion.setVisible(true);
            JCB_Clasificacion.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

        if (JCB_Proveedor.isSelected() == true) {
            b_proveedor = false;
            JC_Proveedor.setVisible(true);
            JCB_Proveedor.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

        if (JCB_Talla.isSelected() == true) {
            b_talla = false;
            JC_Talla.setVisible(true);
            JCB_Talla.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

        if (JCB_Marca.isSelected() == true) {
            b_marca = false;
            JC_Marca.setVisible(true);
            JCB_Marca.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
        if (JCB_Color.isSelected() == true) {
            b_color = false;
            JC_Color.setVisible(true);
            JCB_Color.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
        Limpiar();
        DesHabilitar();

    }//GEN-LAST:event_JB_CancelarActionPerformed

    private void JB_CancelarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JB_CancelarStateChanged

    }//GEN-LAST:event_JB_CancelarStateChanged

    private void JCB_CategoriaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JCB_CategoriaStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_JCB_CategoriaStateChanged

    private void JCB_OtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_OtroActionPerformed
        if (TFRI_Precio_Unitario.getText().equals("")) {
            msm.ms_alerta("Necesita ingresar primero un Precio unitario");
            BG_Grupo2.clearSelection();
            TFRI_Precio_Unitario.requestFocus();
        } else {
            TFRI_Precio_Venta.setText("");
            TFRI_Otro.setEnabled(true);
            TFRI_Otro.requestFocus();
        }

    }//GEN-LAST:event_JCB_OtroActionPerformed

    private void JCB_ActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ActivoActionPerformed

    }//GEN-LAST:event_JCB_ActivoActionPerformed

    private void TFRI_Precio_UnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_Precio_UnitarioActionPerformed

    }//GEN-LAST:event_TFRI_Precio_UnitarioActionPerformed

    private void JCB_VeiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_VeiteActionPerformed
        if (TFRI_Precio_Unitario.getText().equals("")) {
            msm.ms_alerta("Necesita ingresar primero un Precio unitario");
            BG_Grupo2.clearSelection();
            TFRI_Precio_Unitario.requestFocus();
        } else {
            precio((float) 0.20);
            TFRI_Otro.setText("");
            TFRI_Existencia_Minima.requestFocus();
            TFRI_Otro.setEnabled(false);
        }
        Procentaje_Ganancia = 20;
    }//GEN-LAST:event_JCB_VeiteActionPerformed

    private void TFRI_Existencia_MinimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFRI_Existencia_MinimaMouseClicked
        // TODO add your handling code here:
        if (TFRI_Precio_Unitario.getText().equals("")) {
        } else {
            if (TFRI_Otro.getText().equals("")) {
            } else {
                precio((float) (Integer.parseInt(TFRI_Otro.getText()) * (float) 0.01));
            }
        }
    }//GEN-LAST:event_TFRI_Existencia_MinimaMouseClicked

    private void TFRI_OtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_OtroKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
        int limite = 3;
        if (TFRI_Otro.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_OtroKeyTyped

    private void TFRI_Precio_UnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_Precio_UnitarioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != '.') {
            evt.consume();
        }
        int limite = 6;
        if (TFRI_Precio_Unitario.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_Precio_UnitarioKeyTyped

    private void TFRI_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_CantidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
        int limite = 4;
        if (TFRI_Cantidad.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_CantidadKeyTyped

    private void TFRI_OtroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_OtroKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_TFRI_OtroKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void TFRI_Nombre_BKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_Nombre_BKeyTyped
        // TODO add your handling code here:
//         char ca = evt.getKeyChar();
//        if ((ca < '0' || ca > '9')) {
//            evt.consume();
//        }
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
    }//GEN-LAST:event_TFRI_Nombre_BKeyTyped

    private void TFRI_Nombre_BKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_Nombre_BKeyReleased

        if (JC_Categoria_b.getItemCount() == 0 || JC_Clasificacion_b.getItemCount() == 0 || JC_Proveedor_b.getItemCount() == 0) {

        } else {
            String categoria = JC_Categoria_b.getSelectedItem().toString();
            String clasificacion = JC_Clasificacion_b.getSelectedItem().toString();
            String proveedor = JC_Proveedor_b.getSelectedItem().toString();
            String estado = JC_Estado_b.getSelectedItem().toString();

            Datos.abrirConexion();
            int id_clasificacion = BuscarID("select * from bdalmacen.clasificacion where Nombre_Clasificacion='" + clasificacion + "'", "clasificacion");
            int id_proveedor = BuscarID("select * from bdalmacen.proveedor where Nombre_Proveedor='" + proveedor + "'", "clasificacion");
            Datos.cerrarConexion();

            if (TFRI_Nombre_B.getText().equals("")) {
                limpiar_Tabla();
                Llenar(sql_tabla + " where Id_Departamento=" + Numero_Departamento + "", "producto");
            } else {
                System.out.println("Estado de categoria_b=" + JCB_Categoria_b.isSelected());
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%'  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                     CUANDO ESTE SELECCIONADO SOLO UN COMBO                                      ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Categoria='" + categoria + "'  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Clasificacion='" + clasificacion + "'  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Id_Proveedor=" + id_proveedor + "  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Estado='" + estado + "'  AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                       CUANDO ESTEN SELECCIONADOs DOS COMBOS                                     ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Categoria='" + categoria + "' AND Clasificacion='" + clasificacion + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Categoria='" + categoria + "' AND Estado='" + estado + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Estado='" + estado + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Estado='" + estado + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                       CUANDO ESTEN SELECCIONADOS TRES COMBOS                                    ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == false) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Clasificacion='" + clasificacion + "' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == false && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Estado='" + estado + "' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == false && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Estado='" + estado + "' AND Clasificacion='" + clasificacion + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == false && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Estado='" + estado + "' AND Clasificacion='" + clasificacion + "' AND Categoria='" + categoria + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ///////                      CUANDO ESTEN SELECCIONADOS TODOS COMBOS                                    ///////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (JCB_Categoria_b.isSelected() == true && JCB_Clasificacion_b.isSelected() == true && JCB_Proveedor_b.isSelected() == true && JCB_Estado_b.isSelected() == true) {
                    limpiar_Tabla();
                    Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Estado='" + estado + "' AND Clasificacion='" + clasificacion + "' AND Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Departamento=" + Numero_Departamento + ";", "producto");
                }

            }
        }

//        limpiar_Tabla();
//        Llenar(sql_tabla + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Categoria='" + categoria + "' AND Clasificacion='" + clasificacion + "' AND Id_Proveedor=" + id_proveedor + " AND Estado='" + estado + "' AND Id_Departamento=" + Numero_Departamento + ";", "producto");
//        
////////////////////////////Hasta aqui ///////////////////////////////// 
        ///////////////////////////////////////////////////////////////////
//        String categoria = JC_Categoria_b.getSelectedItem().toString();
//        String clasificacion = JC_Clasificacion_b.getSelectedItem().toString();
//        String proveedor = JC_Proveedor_b.getSelectedItem().toString();
//        String estado = JC_Estado_b.getSelectedItem().toString();
//        String sql = "Select Id_Producto,Nombre_Producto,Talla,Estilo,Color,Marca from bdalmacen.producto";
//
//        Datos.abrirConexion();
//        int id_clasificacion = BuscarID("select * from bdalmacen.clasificacion where Nombre_Clasificacion='" + clasificacion + "'", "clasificacion");
//        int id_proveedor = BuscarID("select * from bdalmacen.proveedor where Nombre_Proveedor='" + proveedor + "'", "clasificacion");
//        Datos.cerrarConexion();
//
//        if (TFRI_Nombre_B.getText().equals("")) {
//            limpiar_Tabla();
//            Llenar("Select Id_Producto,Nombre_Producto,Talla,Estilo,Color,Marca from producto;", "producto");
//        } else {
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            /////                       CUANDO ESTE SELECCIONADO SOLO UN COMBO                                      /////
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            if (categoria != "Todos" && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND Categoria='" + JC_Categoria_b.getSelectedItem() + "' ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor.equals("Todos") && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Id_Clasificacion=" + id_clasificacion + " ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion.equals("Todos") && proveedor != "Todos" && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Id_Proveedor=" + id_proveedor + " ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado != "Todos") {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Estado='" + estado + "' ;", "producto");
//            }
//
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            /////                       CUANDO ESTE SELECCIONADO SOLO DOS COMBO                                      /////
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            if (categoria != "Todos" && clasificacion.equals("Todos") && proveedor != "Todos" && estado.equals("Todos")) {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + ";", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor.equals("Todos") && estado.equals("Todos")) {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Categoria='" + categoria + "' AND Id_Clasificacion=" + id_clasificacion + " ;", "producto");
//            }
//            if (categoria != "Todos" && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado != "Todos") {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Categoria='" + categoria + "' AND Estado='" + estado + "' ;", "producto");
//            }
//
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor != "Todos" && estado.equals("Todos")) {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Id_Clasificacion=" + id_clasificacion + " AND Id_Proveedor=" + id_proveedor + " ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion.equals("Todos") && proveedor != "Todos" && estado != "Todos") {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Estado='" + estado + "' AND Id_Proveedor=" + id_proveedor + " ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor.equals("Todos") && estado != "Todos") {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Estado='" + estado + "' AND Id_Clasificacion=" + id_clasificacion + " ;", "producto");
//            }
//
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            /////                      CUANDO ESTE SELECCIONADO TODOS COMBOS                                        /////
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            if (categoria.equals("Todos") && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado.equals("Todos")) {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Clasificacion=" + id_clasificacion + " AND Estado='" + estado + "';", "producto");
//            }
//
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            /////                     CUANDO ESTE SELECCIONADO SOLO TRES COMBOS                                    /////
//            /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor != "Todos" && estado.equals("Todos")) {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Id_Clasificacion=" + id_clasificacion + " ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor != "Todos" && estado != "Todos") {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%'  AND Id_Proveedor=" + id_proveedor + " AND Id_Clasificacion=" + id_clasificacion + " AND Estado='" + estado + "';", "producto");
//            }
//            if (categoria != "Todos" && clasificacion.equals("Todos") && proveedor != "Todos" && estado != "Todos") {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Categoria='" + categoria + "' AND Id_Proveedor=" + id_proveedor + " AND Estado='" + estado + "';", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor.equals("Todos") && estado != "Todos") {
//
//                limpiar_Tabla();
//                Llenar(sql + " where Nombre_Producto like '%" + TFRI_Nombre_B.getText() + "%' AND  Categoria='" + categoria + "' AND Id_Clasificacion=" + id_clasificacion + " AND Estado='" + estado + "';", "producto");
//            }
//        }
    }//GEN-LAST:event_TFRI_Nombre_BKeyReleased

    private void JT_TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_TablaMouseClicked
        apretafoto = 0;
        ImageIcon foto;
        InputStream is;
        ImageIcon newicon = null;
        filaSeleccionada = JT_Tabla.getSelectedRow();
        Modificar = true;

        JTP_Pestaña.setTitleAt(0, "Modificar");

        Limpiar();
        cargarCombo(JC_Categoria, "select * from categoria where Id_Departamento=" + Numero_Departamento + "", "categoria");
        cargarCombo(JC_Clasificacion, "select * from clasificacion where Id_Departamento=" + Numero_Departamento + "", "clasificacion");
        cargarCombo(JC_Proveedor, "select * from proveedor", "proveedor");
        cargarCombo(JC_Talla, "select * from talla where Id_Departamento=" + Numero_Departamento + "", "Talla");

        cargarCombo(JC_Color, "select * from color where Id_Departamento=" + Numero_Departamento + "", "Color");
        cargarCombo(JC_Marca, "select * from marca where Id_Departamento=" + Numero_Departamento + "", "Marca");

        Habilitar2();
        id_Modificar_Producto = Integer.parseInt(JT_Tabla.getValueAt(filaSeleccionada, 0).toString());

        int Cantidad = 0;
        float Precio_Venta = 0;
        float Precio_Unitario = 0;
        int Ganancia = 0;
        int Existencia_Minima = 0;
        String Nombre_Proveedor = "", Estado = "";

        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        //////           BUSQUEDAS DE VALORES NO CONTENIDOS EN LA TABLA PRODUCTO              ///////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        Datos.abrirConexion();
        Datos.Buscar("select * from inventario where Producto_Id_Producto=" + Integer.parseInt(JT_Tabla.getValueAt(filaSeleccionada, 0).toString()) + "", "");
        try {
            while (Datos.rs.next()) {
                Cantidad = Datos.rs.getInt("Cantidad");
                Precio_Venta = Datos.rs.getFloat("Precio_Venta");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar en inventario\nEvento Clic Tabla");
        }
        Datos.cerrarConexion();
        Datos.abrirConexion();
        Datos.Buscar("select * from producto where Id_Producto=" + Integer.parseInt(JT_Tabla.getValueAt(filaSeleccionada, 0).toString()) + "", "");
        try {
            while (Datos.rs.next()) {
                Precio_Unitario = Datos.rs.getFloat("Precio_Unitario");
                Ganancia = Datos.rs.getInt("Ganancia");
                Existencia_Minima = Datos.rs.getInt("Stock");
                Estado = Datos.rs.getString("Estado");
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
        Nombre_Proveedor = this.BuscarNombre("select * from proveedor where Id_Proveedor=" + Integer.parseInt(JT_Tabla.getValueAt(filaSeleccionada, 5).toString()) + "", "proveedor");
        Datos.cerrarConexion();
        //Ganancia_Modificar_Producto = Ganancia;
        if (Ganancia == 20) {
            JCB_Veite.setSelected(true);
            TFRI_Otro.setEnabled(false);
            TFRI_Otro.setText("");
        } else {
            if (Ganancia == 10) {
                JCB_Diez.setSelected(true);
                TFRI_Otro.setEnabled(false);
                TFRI_Otro.setText("");
            } else {
                JCB_Otro.setSelected(true);
                TFRI_Otro.setEnabled(true);
                TFRI_Otro.setText(String.valueOf(Ganancia));
            }
        }
        //Estado_Modificar_Producto = Estado;
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        //////                ASIGNACION DE VALORES AL LOS CAMPOS DE TEXTO                  ///////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        lblfoto.setIcon((Icon) (newicon));
        TFRI_Nombre.setText(JT_Tabla.getValueAt(filaSeleccionada, 1).toString());
        TFRI_Cantidad.setText(String.valueOf(Cantidad));
        TFRI_Precio_Venta.setText(String.valueOf(Precio_Venta));
        TFRI_Precio_Unitario.setText(String.valueOf(Precio_Unitario));
        TFRI_Existencia_Minima.setText(String.valueOf(Existencia_Minima));

        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        //////              ASIGNACION DE LOS VALOS EN LOS COMBOS DE SELECCION              ///////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        JC_Categoria.setSelectedItem(JT_Tabla.getValueAt(filaSeleccionada, 8).toString());
        JC_Clasificacion.setSelectedItem(JT_Tabla.getValueAt(filaSeleccionada, 7).toString());
        JC_Talla.setSelectedItem(JT_Tabla.getValueAt(filaSeleccionada, 2).toString());

        JC_Color.setSelectedItem(JT_Tabla.getValueAt(filaSeleccionada, 4).toString());
        JC_Marca.setSelectedItem(JT_Tabla.getValueAt(filaSeleccionada, 5).toString());
        JC_Proveedor.setSelectedItem(Nombre_Proveedor);

        jPanel2.setVisible(true);
        if (Estado.equals("Activo")) {
            JCB_Activo.setSelected(true);
        } else {
            JCB_Inactivo.setSelected(true);
        }

        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        //////              ASIGNACION DE LOS VALOS EN LOS BOTONES              ///////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        JB_Guardar.setVisible(false);
        JB_Nuevo.setVisible(false);
        JB_Cancelar.setVisible(false);

        JTP_Pestaña.setSelectedIndex(0);
    }//GEN-LAST:event_JT_TablaMouseClicked

    private void JC_Categoria_bItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JC_Categoria_bItemStateChanged
        TFRI_Nombre_B.setText("");
//        String categoria = JC_Categoria_b.getSelectedItem().toString();
//        String clasificacion = JC_Clasificacion_b.getSelectedItem().toString();
//        String proveedor = JC_Proveedor_b.getSelectedItem().toString();
//        String estado = JC_Estado_b.getSelectedItem().toString();
//        Datos.abrirConexion();
//        int id_clasificacion = BuscarID("select * from bdalmacen.clasificacion where Nombre_Clasificacion='" + clasificacion + "'", "clasificacion");
//        int id_proveedor = BuscarID("select * from bdalmacen.proveedor where Nombre_Proveedor='" + proveedor + "'", "clasificacion");
//        Datos.cerrarConexion();
//        System.out.println("id-clasiiiiii=" + id_clasificacion);
//        String sql = "Select Id_Producto,Nombre_Producto,Talla,Estilo,Color,Marca from bdalmacen.producto";
//
//        if (categoria.equals("Todos") && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado.equals("Todos")) {
//            limpiar_Tabla();
//            Llenar("Select Id_Producto,Nombre_Producto,Talla,Estilo,Color,Marca from bdalmacen.producto;", "producto");
//            TFRI_Nombre_B.setEnabled(false);
//        } else {
//            //System.out.println("Estoy en combobox");
//            TFRI_Nombre_B.setEnabled(true);
//            if (categoria != "Todos" && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado.equals("Todos")) {
//                System.out.println("Estoy en combobox");
//                limpiar_Tabla();
//                //Llenar(sql+" where Nombre_Clasificacion='"+clasificacion+"' AND Nombre_Proveedor='"+proveedor+"' AND Estado='"+estado+"';", "producto");
//                Llenar(sql + " where Categoria='" + categoria + "';", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor.equals("Todos") && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Id_Clasificacion=" + id_clasificacion + ";", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor != "Todos" && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Id_Clasificacion=" + id_clasificacion + " AND Id_Proveedor=" + id_proveedor + ";", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor != "Todos" && estado != "Todos") {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Id_Clasificacion='" + id_clasificacion + "' AND Id_Proveedor='" + id_proveedor + "' AND Estado='" + estado + "';", "producto");
//            }
//
//            if (categoria != "Todos" && clasificacion.equals("Todos") && proveedor != "Todos" && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "'  AND Id_Proveedor='" + id_proveedor + "' ;", "producto");
//            }
//
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor.equals("Todos") && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where  Id_Clasificacion='" + id_clasificacion + "' ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor.equals("Todos") && estado != "Todos") {
//                limpiar_Tabla();
//                Llenar(sql + " where  Id_Clasificacion=" + id_clasificacion + " AND Estado='" + estado + "' ;", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor != "Todos" && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where  Id_Clasificacion=" + id_clasificacion + " AND Id_Proveedor=" + id_proveedor + " ;", "producto");
//            }
//            if (categoria != "Todos" && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado != "Todos") {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Estado='" + estado + "' ;", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor.equals("Todos") && estado != "Todos") {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Id_Clasificacion='" + id_clasificacion + "' AND Estado='" + estado + "' ;", "producto");
//            }
//        }

    }//GEN-LAST:event_JC_Categoria_bItemStateChanged

    private void JC_Clasificacion_bItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JC_Clasificacion_bItemStateChanged

        TFRI_Nombre_B.setText("");
//
//        String categoria = JC_Categoria_b.getSelectedItem().toString();
//        String clasificacion = JC_Clasificacion_b.getSelectedItem().toString();
//        String proveedor = JC_Proveedor_b.getSelectedItem().toString();
//        String estado = JC_Estado_b.getSelectedItem().toString();
//        Datos.abrirConexion();
//        int id_clasificacion = BuscarID("select * from bdalmacen.clasificacion where Nombre_Clasificacion='" + clasificacion + "'", "clasificacion");
//        int id_proveedor = BuscarID("select * from bdalmacen.proveedor where Nombre_Proveedor='" + proveedor + "'", "clasificacion");
//        Datos.cerrarConexion();
//        System.out.println("id-clasiiiiii=" + id_clasificacion);
//        String sql = "Select Id_Producto,Nombre_Producto,Talla,Estilo,Color,Marca from bdalmacen.producto";
//
//        if (categoria.equals("Todos") && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado.equals("Todos")) {
//            limpiar_Tabla();
//            Llenar("Select Id_Producto,Nombre_Producto,Talla,Estilo,Color,Marca from bdalmacen.producto;", "producto");
//            TFRI_Nombre_B.setEnabled(false);
//        } else {
//            //System.out.println("Estoy en combobox");
//            TFRI_Nombre_B.setEnabled(true);
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor.equals("Todos") && estado.equals("Todos")) {
//                System.out.println("Estoy en combobox");
//                limpiar_Tabla();
//                //Llenar(sql+" where Nombre_Clasificacion='"+clasificacion+"' AND Nombre_Proveedor='"+proveedor+"' AND Estado='"+estado+"';", "producto");
//                Llenar(sql + " where Id_Clasificacion='" + id_clasificacion + "';", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor.equals("Todos") && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Id_Clasificacion=" + id_clasificacion + ";", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor != "Todos" && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Id_Clasificacion=" + id_clasificacion + " AND Id_Proveedor=" + id_proveedor + ";", "producto");
//            }
//            if (categoria != "Todos" && clasificacion != "Todos" && proveedor != "Todos" && estado != "Todos") {
//                limpiar_Tabla();
//                Llenar(sql + " where  Categoria='" + categoria + "' AND Id_Clasificacion='" + id_clasificacion + "' AND Id_Proveedor='" + id_proveedor + "' AND Estado='" + estado + "';", "producto");
//            }
//
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor != "Todos" && estado.equals("Todos")) {
//                limpiar_Tabla();
//                Llenar(sql + " where   Id_Clasificacion='" + id_clasificacion + "' AND Id_Proveedor='" + id_proveedor + "';", "producto");
//            }
//
//            if (categoria.equals("Todos") && clasificacion != "Todos" && proveedor.equals("Todos") && estado != "Todos") {
//                limpiar_Tabla();
//                Llenar(sql + " where   Id_Clasificacion='" + id_clasificacion + "' AND Estado='" + estado + "';", "producto");
//            }
//            if (categoria.equals("Todos") && clasificacion.equals("Todos") && proveedor.equals("Todos") && estado != "Todos") {
//                limpiar_Tabla();
//                Llenar(sql + " where Estado='" + estado + "';", "producto");
//            }
//        }

    }//GEN-LAST:event_JC_Clasificacion_bItemStateChanged

    private void JC_Proveedor_bItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JC_Proveedor_bItemStateChanged
        TFRI_Nombre_B.setText("");
    }//GEN-LAST:event_JC_Proveedor_bItemStateChanged

    private void JC_Estado_bItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JC_Estado_bItemStateChanged
        TFRI_Nombre_B.setText("");
    }//GEN-LAST:event_JC_Estado_bItemStateChanged

    private void JTP_PestañaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTP_PestañaMouseClicked
        if (JTP_Pestaña.getSelectedIndex() == 0) {
            System.out.println("Hola soy la pestaña Registro");
        } else {
            System.out.println("Hola soy la pestaña Buscar");
            JC_Categoria_b.removeAllItems();
            JC_Clasificacion_b.removeAllItems();
            JC_Proveedor_b.removeAllItems();

            cargarCombo(JC_Categoria_b, "select * from categoria where Id_Departamento=" + Numero_Departamento + "", "categoria");
            cargarCombo(JC_Clasificacion_b, "select * from clasificacion where Id_Departamento=" + Numero_Departamento + "", "clasificacion");
            cargarCombo(JC_Proveedor_b, "select * from proveedor", "proveedor");
            limpiar_Tabla();
            Llenar(sql_tabla + " where  Id_Departamento=" + Numero_Departamento + "", "producto");
        }

    }//GEN-LAST:event_JTP_PestañaMouseClicked

    private void JTP_PestañaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTP_PestañaMouseReleased

    }//GEN-LAST:event_JTP_PestañaMouseReleased

    private void JB_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ModificarActionPerformed
        if (0 != validar()) {
        } else {
            this.Datos.abrirConexion();
            if (Integer.parseInt(TFRI_Existencia_Minima.getText()) < Integer.parseInt(TFRI_Cantidad.getText())) {
                Busqueda_Insercion();
                if (JCB_Activo.isSelected()) {
                    Estado_Producto = "Activo";
                } else {
                    Estado_Producto = "Inactivo";
                }

                if (JCB_Diez.isSelected() == true) {
                    Procentaje_Ganancia = 10;
                } else {
                    if (JCB_Veite.isSelected() == true) {
                        Procentaje_Ganancia = 20;
                    } else {
                        if (JCB_Otro.isSelected() == true) {
                            Procentaje_Ganancia = Integer.parseInt(TFRI_Otro.getText());
                        }
                    }
                }
                Stock = Integer.parseInt(TFRI_Existencia_Minima.getText());
                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                metodos.setId_Producto(id_Modificar_Producto);
                metodos.setNombre_Producto(TFRI_Nombre.getText());
                metodos.setStock(Stock);
                metodos.setId_Proveedor(ID_Proveedor);
                metodos.setId_Departamento(Numero_Departamento);
                metodos.setPrecio_unitario(Float.parseFloat(TFRI_Precio_Unitario.getText()));
                metodos.setTalla(Nombre_Talla);
                metodos.setMarca(Nombre_Marca);
                metodos.setColor(Nombre_Color);
                metodos.setCategoria(Nombre_Categoria);
                metodos.setClasificacion(Nombre_Clasificacion);
                metodos.setEstado(Estado_Producto);
                metodos.setGanancia(Procentaje_Ganancia);
                metodos.setFis(fis);
                metodos.setLongitudBytes(longitudBytes);
                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                if(apretafoto==1){
                    Datos.ModificarDatosConFoto_Zapatos(metodos);
                    Datos.Modificar2("inventario", "Cantidad=" + Integer.parseInt(TFRI_Cantidad.getText()) + ",Precio_Venta=" + Float.parseFloat(TFRI_Precio_Venta.getText()) + "", "Producto_Id_Producto=" + id_Modificar_Producto + "");
                    cb.insertarAccion(mss.getNombre(),"Modifico Calzado");
                }else{
                    Datos.ModificarDatosSinFoto_Zapatos(metodos);
                    
                    Datos.Modificar2("inventario", "Cantidad=" + Integer.parseInt(TFRI_Cantidad.getText()) + ",Precio_Venta=" + Float.parseFloat(TFRI_Precio_Venta.getText()) + "", "Producto_Id_Producto=" + id_Modificar_Producto + "");
                    cb.insertarAccion(mss.getNombre(),"Modifico Calzado");
                }
                
                this.Datos.cerrarConexion();

                ValoresBanderas();
                Limpiar();
                CargarCombo();

                JC_Categoria_b.removeAllItems();
                JC_Clasificacion_b.removeAllItems();
                JC_Proveedor_b.removeAllItems();

                cargarCombo(JC_Categoria_b, "select * from categoria where Id_Departamento=" + Numero_Departamento + "", "categoria");
                cargarCombo(JC_Clasificacion_b, "select * from clasificacion where Id_Departamento=" + Numero_Departamento + "", "clasificacion");
                cargarCombo(JC_Proveedor_b, "select * from proveedor", "proveedor");
                limpiar_Tabla();
                Llenar(sql_tabla + " where  Id_Departamento=" + Numero_Departamento + "", "producto");

                //Evento del boton cancelar
                Modificar = false;
                JB_Guardar.setVisible(true);
                JB_Nuevo.setVisible(true);
                JB_Cancelar.setVisible(true);
                JTP_Pestaña.setTitleAt(0, "Ingresar");
                JTP_Pestaña.setSelectedIndex(1);

                if (JCB_Categoria.isSelected() == true) {
                    b_categoria = false;
                    JC_Categoria.setVisible(true);
                    JCB_Categoria.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
                }
                if (JCB_Clasificacion.isSelected() == true) {
                    b_clasificacion = false;
                    JC_Clasificacion.setVisible(true);
                    JCB_Clasificacion.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
                }

                if (JCB_Proveedor.isSelected() == true) {
                    b_proveedor = false;
                    JC_Proveedor.setVisible(true);
                    JCB_Proveedor.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
                }

                if (JCB_Talla.isSelected() == true) {
                    b_talla = false;
                    JC_Talla.setVisible(true);
                    JCB_Talla.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
                }

                if (JCB_Marca.isSelected() == true) {
                    b_marca = false;
                    JC_Marca.setVisible(true);
                    JCB_Marca.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
                }
                if (JCB_Color.isSelected() == true) {
                    b_color = false;
                    JC_Color.setVisible(true);
                    JCB_Color.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
                }
                Limpiar();
                DesHabilitar();
                JTP_Pestaña.setSelectedIndex(1);

            } else {
                msm.ms_alerta("Existencia no puede ser mayor a cantidad");
            }

        }
    }//GEN-LAST:event_JB_ModificarActionPerformed

    private void JB_Cancelar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JB_Cancelar1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_Cancelar1StateChanged

    private void JB_Cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Cancelar1ActionPerformed
        Modificar = false;
        JB_Guardar.setVisible(true);
        JB_Nuevo.setVisible(true);
        JB_Cancelar.setVisible(true);
        JTP_Pestaña.setTitleAt(0, "Ingresar");
        JTP_Pestaña.setSelectedIndex(1);

        if (JCB_Categoria.isSelected() == true) {
            b_categoria = false;
            JC_Categoria.setVisible(true);
            JCB_Categoria.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
        if (JCB_Clasificacion.isSelected() == true) {
            b_clasificacion = false;
            JC_Clasificacion.setVisible(true);
            JCB_Clasificacion.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

        if (JCB_Proveedor.isSelected() == true) {
            b_proveedor = false;
            JC_Proveedor.setVisible(true);
            JCB_Proveedor.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

        if (JCB_Talla.isSelected() == true) {
            b_talla = false;
            JC_Talla.setVisible(true);
            JCB_Talla.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }

        if (JCB_Marca.isSelected() == true) {
            b_marca = false;
            JC_Marca.setVisible(true);
            JCB_Marca.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
        if (JCB_Color.isSelected() == true) {
            b_color = false;
            JC_Color.setVisible(true);
            JCB_Color.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
        Limpiar();
        DesHabilitar();
    }//GEN-LAST:event_JB_Cancelar1ActionPerformed

    private void TFRI_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_NombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        int limite = 18;
        if (TFRI_Nombre.getText().length() == limite) {
            evt.consume();
        }
        char ca = evt.getKeyChar();
        if ((ca < 'A' || ca > 'Z') && (ca != ' ')&& (ca < '0' || ca > '9') && (ca != '/') && (ca != '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_NombreKeyTyped

    private void TFRI_Existencia_MinimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_Existencia_MinimaKeyTyped
        // TODO add your handling code here:
        char ca = evt.getKeyChar();
        if ((ca < '0' || ca > '9')) {
            evt.consume();
        }
        int limite = 2;
        if (TFRI_Existencia_Minima.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_TFRI_Existencia_MinimaKeyTyped

    private void TFRI_TallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_TallaKeyTyped
        char ca = evt.getKeyChar();
        if ((ca < '0' || ca > '9')) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        int limite = 3;
        if (TFRI_Talla.getText().length() == limite) {
            evt.consume();
        }

    }//GEN-LAST:event_TFRI_TallaKeyTyped

    private void TFRI_MarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_MarcaKeyTyped

        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        int limite = 18;
        if (TFRI_Marca.getText().length() == limite) {
            evt.consume();
        }
        char ca = evt.getKeyChar();
        if ((ca < 'A' || ca > 'Z')) {
            evt.consume();
        }
        if (ca == ' ') {
            String a = TFRI_Marca.getText();
            TFRI_Marca.setText(a + "-");
            TFRI_Marca.requestFocus();
        }
    }//GEN-LAST:event_TFRI_MarcaKeyTyped

    private void TFRI_ColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_ColorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        int limite = 18;
        if (TFRI_Color.getText().length() == limite) {
            evt.consume();
        }
        char ca = evt.getKeyChar();
        if ((ca < 'A' || ca > 'Z')) {
            evt.consume();
        }
        if (ca == ' ') {
            String a = TFRI_Color.getText();
            TFRI_Color.setText(a + "-");
            TFRI_Color.requestFocus();
        }
    }//GEN-LAST:event_TFRI_ColorKeyTyped

    private void TFRI_ClasificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_ClasificacionKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        int limite = 12;
        if (TFRI_Clasificacion.getText().length() == limite) {
            evt.consume();
        }
        char ca = evt.getKeyChar();
        if ((ca < 'A' || ca > 'Z')) {
            evt.consume();
        }
//        if(ca==' '){
//            String a=TFRI_Categoria.getText();
//            TFRI_Categoria.setText(a+"/");
//            TFRI_Categoria.requestFocus();
//        }
    }//GEN-LAST:event_TFRI_ClasificacionKeyTyped

    private void TFRI_CategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_CategoriaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        int limite = 12;
        if (TFRI_Categoria.getText().length() == limite) {
            evt.consume();
        }
        char ca = evt.getKeyChar();
        if ((ca < 'A' || ca > 'Z') && (ca != ' ')) {
            evt.consume();
        }
        if (ca == ' ') {
            String a = TFRI_Categoria.getText();
            TFRI_Categoria.setText(a + "-");
            TFRI_Categoria.requestFocus();
        }
    }//GEN-LAST:event_TFRI_CategoriaKeyTyped

    private void TFRI_ProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_ProveedorKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
    }//GEN-LAST:event_TFRI_ProveedorKeyTyped

    private void TFRI_CategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_CategoriaKeyReleased
        Buscar_Existencia(TFRI_Categoria, "categoria", "Nombre_Categoria");
    }//GEN-LAST:event_TFRI_CategoriaKeyReleased

    private void TFRI_ClasificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_ClasificacionKeyReleased
        Buscar_Existencia(TFRI_Clasificacion, "clasificacion", "Nombre_Clasificacion");
    }//GEN-LAST:event_TFRI_ClasificacionKeyReleased

    private void TFRI_TallaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_TallaKeyReleased

    }//GEN-LAST:event_TFRI_TallaKeyReleased

    private void TFRI_MarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_MarcaKeyReleased
        
    }//GEN-LAST:event_TFRI_MarcaKeyReleased

    private void TFRI_ColorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRI_ColorKeyReleased
        
    }//GEN-LAST:event_TFRI_ColorKeyReleased

    private void btnsubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubirActionPerformed
        cargarFoto();
    }//GEN-LAST:event_btnsubirActionPerformed

    public void Accion_Checbox(JCheckBox JCB, ComboBoxRound JC, Boolean bandera) {
        bandera = false;
        if (JCB.isSelected() == true) {
            bandera = true;
            JC.setVisible(false);
            JCB.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/AgregarRojo.png")));
        } else {
            bandera = false;
            JC.setVisible(true);
            JCB.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Agregar.png")));
        }
    }

    public void DesHabilitar() {

        JC_Categoria.setEnabled(false);
        JC_Clasificacion.setEnabled(false);
        JC_Proveedor.setEnabled(false);
        JC_Talla.setEditable(false);

        JC_Color.setEnabled(false);
        JC_Marca.setEditable(false);
        JC_Talla.setEnabled(false);
        JC_Marca.setEnabled(false);

        JCB_Activo.setEnabled(false);
        JCB_Inactivo.setEnabled(false);

        JCB_Veite.setEnabled(false);
        JCB_Otro.setEnabled(false);
        JCB_Diez.setEnabled(false);

        JCB_Categoria.setEnabled(false);
        JCB_Clasificacion.setEnabled(false);
        JCB_Proveedor.setVisible(false);
        JCB_Talla.setEnabled(false);

        JCB_Marca.setEnabled(false);
        JCB_Color.setEnabled(false);

        TFRI_Categoria.setEnabled(false);
        TFRI_Clasificacion.setEnabled(false);
        TFRI_Proveedor.setEnabled(false);
        TFRI_Nombre.setEnabled(false);
        TFRI_Cantidad.setEnabled(false);
        TFRI_Precio_Venta.setEnabled(false);
        TFRI_Existencia_Minima.setEnabled(false);
        TFRI_Precio_Unitario.setEnabled(false);
        TFRI_Otro.setEnabled(false);
        TFRI_Talla.setEnabled(false);

        TFRI_Marca.setEnabled(false);
        TFRI_Color.setEnabled(false);
        JB_Guardar.setEnabled(false);
        JB_Cancelar.setEnabled(false);
        JB_Salir.setEnabled(true);
        JB_Nuevo.setEnabled(true);

        JB_Modificar.setVisible(false);
        //JB_Guardar.setEnabled(true);
        JB_Cancelar1.setVisible(false);
        //JB_Cancelar.setEnabled(true);
        //JB_Salir.setVisible(false);
        jPanel2.setVisible(false);
        btnsubir.setEnabled(false);
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

    public void Habilitar() {
        JC_Categoria.setEnabled(true);
        JC_Clasificacion.setEnabled(true);
        JC_Proveedor.setEnabled(true);
        JC_Talla.setEnabled(true);

        JC_Color.setEnabled(true);
        JC_Marca.setEnabled(true);
        JC_Talla.setEnabled(true);
        JC_Marca.setEnabled(true);

        JCB_Activo.setEnabled(true);
        JCB_Inactivo.setEnabled(true);

        JCB_Veite.setEnabled(true);
        JCB_Otro.setEnabled(true);
        JCB_Diez.setEnabled(true);

        JCB_Categoria.setEnabled(true);
        JCB_Clasificacion.setEnabled(true);
        JCB_Proveedor.setEnabled(true);
        JCB_Talla.setEnabled(true);

        JCB_Marca.setEnabled(true);
        JCB_Color.setEnabled(true);

        TFRI_Categoria.setEnabled(true);
        TFRI_Clasificacion.setEnabled(true);
        TFRI_Proveedor.setEnabled(true);
        TFRI_Nombre.setEnabled(true);
        TFRI_Cantidad.setEnabled(true);
        TFRI_Precio_Venta.setEnabled(false);
        TFRI_Existencia_Minima.setEnabled(true);
        TFRI_Otro.setEnabled(false);
        TFRI_Talla.setEnabled(true);

        TFRI_Marca.setEnabled(true);
        TFRI_Precio_Unitario.setEnabled(true);

        TFRI_Color.setEnabled(true);
        JB_Guardar.setEnabled(true);
        JB_Cancelar.setEnabled(true);
        JB_Salir.setEnabled(true);
        JB_Nuevo.setEnabled(false);
        JB_Modificar.setVisible(false);
        //JB_Guardar.setEnabled(true);
        JB_Cancelar1.setVisible(false);
        //JB_Cancelar.setEnabled(true);
        //JB_Salir.setVisible(false);
        jPanel2.setVisible(false);
        btnsubir.setEnabled(true);
    }

    public void Habilitar2() {
        JC_Categoria.setEnabled(true);
        JC_Clasificacion.setEnabled(true);
        JC_Proveedor.setEnabled(true);
        JC_Talla.setEnabled(true);

        JC_Color.setEnabled(true);
        JC_Marca.setEnabled(true);
        JC_Talla.setEnabled(true);
        JC_Marca.setEnabled(true);

        JCB_Activo.setEnabled(true);
        JCB_Inactivo.setEnabled(true);

        JCB_Veite.setEnabled(true);
        JCB_Otro.setEnabled(true);
        JCB_Diez.setEnabled(true);

        JCB_Categoria.setEnabled(false);
        JCB_Clasificacion.setEnabled(false);
        JCB_Proveedor.setEnabled(false);
        JCB_Talla.setEnabled(false);

        JCB_Marca.setEnabled(false);
        JCB_Color.setEnabled(false);

        TFRI_Categoria.setEnabled(true);
        TFRI_Clasificacion.setEnabled(true);
        TFRI_Proveedor.setEnabled(true);
        TFRI_Nombre.setEnabled(true);
        TFRI_Cantidad.setEnabled(true);
        TFRI_Precio_Venta.setEnabled(false);
        TFRI_Existencia_Minima.setEnabled(true);
        TFRI_Otro.setEnabled(false);
        TFRI_Talla.setEnabled(true);

        TFRI_Marca.setEnabled(true);
        TFRI_Precio_Unitario.setEnabled(true);

        TFRI_Color.setEnabled(true);
        JB_Modificar.setEnabled(true);
        //JB_Guardar.setEnabled(true);
        JB_Cancelar1.setEnabled(true);
        //JB_Cancelar.setEnabled(true);
        JB_Salir.setEnabled(true);
        //JB_Nuevo.setEnabled(false);

        JB_Modificar.setVisible(true);
        //JB_Guardar.setEnabled(true);
        JB_Cancelar1.setVisible(true);
        //JB_Cancelar.setEnabled(true);
        //JB_Salir.setVisible(false);

    }

    public void Busqueda_Insercion() {
        //////////////////////////////////////////////////////////////////
        //                  BUSQUEDA DE ID_Producto                     //
        //////////////////////////////////////////////////////////////////
        ID_Producto = this.BuscarID("select * from producto", "Producto");
        System.out.print("ID_Producto= " + ID_Producto + "\n");
        ID_Producto++;
        System.out.print("ID++= " + ID_Producto + "\n");

        //////////////////////////////////////////////////////////////////
        //           INSERCION O BUSQUEDA DE ID_Categoria               //
        //////////////////////////////////////////////////////////////////
        if (b_categoria == true) {
            ID_Categoria = BuscarID("select * from categoria", "Categoria");
            ID_Categoria++;
            this.Datos.Insertar2("categoria", "Id_Categoria,Nombre_Categoria,Id_Departamento", "" + ID_Categoria + ",'" + TFRI_Categoria.getText() + "'," + Numero_Departamento + "");
            Nombre_Categoria = TFRI_Categoria.getText();

        } else {

            ID_Categoria = this.BuscarID("select * from categoria where Id_Departamento=" + Numero_Departamento + " AND Nombre_Categoria='" + JC_Categoria.getSelectedItem().toString() + "'", "Categotria");
            Nombre_Categoria = JC_Categoria.getSelectedItem().toString();
        }
        //////////////////////////////////////////////////////////////////
        //          INSERCION O BUSQUEDA DE ID_Clasificacion            //
        //////////////////////////////////////////////////////////////////
        if (b_clasificacion == true) {
            ID_Clasificacion = BuscarID("select * from clasificacion", "clasificacion");
            ID_Clasificacion++;
            this.Datos.Insertar2("clasificacion", "Id_Clasificacion,Nombre_Clasificacion,Id_Departamento", "" + ID_Clasificacion + ",'" + TFRI_Clasificacion.getText() + "'," + Numero_Departamento + "");
            Nombre_Clasificacion = TFRI_Clasificacion.getText();

        } else {//Buscqueda de ID_Clasificacion
            ID_Clasificacion = this.BuscarID("select * from clasificacion where Nombre_Clasificacion='" + JC_Clasificacion.getSelectedItem().toString() + "' AND Id_Departamento=" + Numero_Departamento + "", "Clasificacion");
            System.out.print("ID_Clasificacion= " + ID_Clasificacion + "\n");
            Nombre_Clasificacion = JC_Clasificacion.getSelectedItem().toString();
        }

        //////////////////////////////////////////////////////////////////
        //           INSERCION O BUSQUEDA DE ID_Proveedor               //
        //////////////////////////////////////////////////////////////////
        if (b_proveedor == true) {
            ID_Proveedor = BuscarID("select * from proveedor", "proveedor");
            ID_Proveedor++;
            this.Datos.Insertar2("proveedor", "Id_Proveedor,Nombre_Proveedor", "" + ID_Proveedor + ",'" + TFRI_Proveedor.getText() + "'");

        } else {//Buscqueda de ID_Proveedor
            ID_Proveedor = this.BuscarID("select * from proveedor where Nombre_Proveedor='" + JC_Proveedor.getSelectedItem().toString() + "'", "Proveedor");
            System.out.print("ID_Proveedor= " + ID_Proveedor + "\n");
        }

        //////////////////////////////////////////////////////////////////
        //           INSERCION O BUSQUEDA DE ID_Talla                   //
        //////////////////////////////////////////////////////////////////
        if (b_talla == true) {
            ID_Talla = BuscarID("select * from talla", "talla");
            ID_Talla++;
            this.Datos.Insertar2("talla", "Id_Talla,Nombre_Talla,Id_Departamento", "" + ID_Talla + ",'" + TFRI_Talla.getText() + "'," + Numero_Departamento + "");
            Nombre_Talla = TFRI_Talla.getText();

        } else {//Buscqueda de ID_Talla
            ID_Talla = this.BuscarID("select * from talla where Id_Departamento=" + Numero_Departamento + " AND Nombre_Talla='" + JC_Talla.getSelectedItem().toString() + "'", "Talla");
            System.out.print("ID_Talla= " + ID_Talla + "\n");
            Nombre_Talla = JC_Talla.getSelectedItem().toString();
        }

        //////////////////////////////////////////////////////////////////
        //            INSERCION O BUSQUEDA DE ID_Marca                  //
        //////////////////////////////////////////////////////////////////
        if (b_marca == true) {
            ID_Marca = BuscarID("select * from marca", "marca");
            ID_Marca++;
            this.Datos.Insertar2("marca", "Id_Marca,Nombre_Marca,Id_Departamento", "" + ID_Marca + ",'" + TFRI_Marca.getText() + "'," + Numero_Departamento + "");
            Nombre_Marca = TFRI_Marca.getText();

        } else {//Buscqueda de ID_Marca
            ID_Marca = this.BuscarID("select * from marca where Id_Departamento=" + Numero_Departamento + " AND Nombre_Marca='" + JC_Marca.getSelectedItem().toString() + "'", "Marca");
            System.out.print("ID_Marca= " + ID_Marca + "\n");
            Nombre_Marca = JC_Marca.getSelectedItem().toString();
        }

        //////////////////////////////////////////////////////////////////
        //            INSERCION O BUSQUEDA DE ID_Color                  //
        //////////////////////////////////////////////////////////////////
        if (b_color == true) {
            ID_Color = BuscarID("select * from color", "color");
            ID_Color++;
            this.Datos.Insertar2("color", "Id_Color,Nombre_Color,Id_Departamento", "" + ID_Color + ",'" + TFRI_Color.getText() + "'," + Numero_Departamento + "");
            Nombre_Color = TFRI_Color.getText();

        } else {//Buscqueda de ID_Color
            ID_Color = this.BuscarID("select * from color where Id_Departamento=" + Numero_Departamento + " AND Nombre_Color='" + JC_Color.getSelectedItem().toString() + "'", "Color");
            System.out.print("ID_Color= " + ID_Color + "\n");
            Nombre_Color = JC_Color.getSelectedItem().toString();
        }
    }

    public int validar() {
        int op = 0;
        String mensaje = "";
        if (b_categoria == true) {
            if (TFRI_Categoria.getText().equals("")) {
                op = 1;

                mensaje = mensaje + "Categoria              Agregue o Seleccione una opcion\n";
            }
        } else {
            if (JC_Categoria.getItemCount() == 0) {
                op = 1;
                mensaje = mensaje + "Categoria              Agregue o Seleccione una opcion\n";
            }

        }

        if (b_clasificacion == true) {
            if ((TFRI_Clasificacion.getText().trim().equals(""))) {
                op = 2;
                mensaje = mensaje + "Clasificacion        Agregue o Seleccione una opcion\n";
            }
        } else {
            if (JC_Clasificacion.getItemCount() == 0) {
                op = 2;
                mensaje = mensaje + "Clasificacion        Agregue o Seleccione una opcion\n";
            }
        }

        if (b_proveedor == true) {
            if (TFRI_Proveedor.getText().trim().equals("-")) {
                op = 3;
                mensaje = mensaje + "Proveedor             Agregue o Seleccione una opcion\n";
            }
        } else {
            if (JC_Proveedor.getItemCount() == 0) {
                op = 3;
                mensaje = mensaje + "Proveedor             Agregue o Seleccione una opcion\n";
            }
        }

        if ((TFRI_Nombre.getText().trim().equals(""))) {
            op = 4;
            mensaje = mensaje + "Nombre                  Agregue un nombre\n";
        }

        if (TFRI_Cantidad.getText().trim().equals("")) {
            op = 5;
            mensaje = mensaje + "Cantidad                Agregue una cantidad\n";
        }
        if (TFRI_Precio_Unitario.getText().trim().equals("")) {
            op = 6;
            mensaje = mensaje + "Precio unitario     Agregue un precio unitario\n";
        }

        if (JCB_Otro.isSelected() == true) {
            if (TFRI_Otro.getText().trim().equals("")) {
                op = 7;
                mensaje = mensaje + "Otra Ganancia      Agregue una cantidad\n";
            }
        }

        if (TFRI_Existencia_Minima.getText().trim().equals("")) {
            op = 8;
            mensaje = mensaje + "Existencia             Agregue una cantidad\n";
        }

        if (b_talla == true) {
            if (TFRI_Talla.getText().trim().equals("")) {
                op = 9;
                mensaje = mensaje + "Talla      Agregue o Seleccione una opcion\n";
            }
        } else {
            if (JC_Talla.getItemCount() == 0) {
                op = 9;
                mensaje = mensaje + "Talla                        Agregue o Seleccione una opcion\n";
            }

        }

        if (b_marca == true) {
            if (TFRI_Marca.getText().trim().equals("")) {
                op = 11;
                mensaje = mensaje + "Marca                      Agregue o Seleccione una opcion\n";
            }
        } else {
            if (JC_Marca.getItemCount() == 0) {
                op = 11;
                mensaje = mensaje + "Marca                     Agregue o Seleccione una opcion\n";
            }

        }
        if (b_color == true) {
            if (TFRI_Color.getText().trim().equals("")) {
                op = 12;
                mensaje = mensaje + "Color                  Agregue o Seleccione una opcion\n";
            }
        } else {
            if (JC_Color.getItemCount() == 0) {
                op = 12;
                mensaje = mensaje + "Color                       Agregue o Seleccione una opcion\n";
            }

        }

        if (op > 0) {
            msm.ms_alerta("          Verifique los siguientes campos:\n\n" + mensaje);
//            Men_A=new Mensaje_Aplicacion("Departamento de Ropa",mensaje);
//            Men_A.setVisible(true);
        }
        return op;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
////        JFrame.setDefaultLookAndFeelDecorated(false);
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Calzado_1().setVisible(true);
//            }
//        });
//    }

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
    private javax.swing.JButton JB_Cancelar;
    private javax.swing.JButton JB_Cancelar1;
    private javax.swing.JButton JB_Guardar;
    private javax.swing.JButton JB_Modificar;
    private javax.swing.JButton JB_Nuevo;
    private javax.swing.JButton JB_Salir;
    private javax.swing.JRadioButton JCB_Activo;
    private javax.swing.JCheckBox JCB_Categoria;
    private javax.swing.JCheckBox JCB_Categoria_b;
    private javax.swing.JCheckBox JCB_Clasificacion;
    private javax.swing.JCheckBox JCB_Clasificacion_b;
    private javax.swing.JCheckBox JCB_Color;
    private javax.swing.JCheckBox JCB_Diez;
    private javax.swing.JCheckBox JCB_Estado_b;
    private javax.swing.JRadioButton JCB_Inactivo;
    private javax.swing.JCheckBox JCB_Marca;
    private javax.swing.JCheckBox JCB_Otro;
    private javax.swing.JCheckBox JCB_Proveedor;
    private javax.swing.JCheckBox JCB_Proveedor_b;
    private javax.swing.JCheckBox JCB_Talla;
    private javax.swing.JCheckBox JCB_Veite;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Categoria;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Categoria_b;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Clasificacion;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Clasificacion_b;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Color;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Estado_b;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Marca;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Proveedor;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Proveedor_b;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_Talla;
    private javax.swing.JTabbedPane JTP_Pestaña;
    private javax.swing.JTable JT_Tabla;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Cantidad;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Categoria;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Clasificacion;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Color;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Existencia_Minima;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Marca;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Nombre;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Nombre_B;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Otro;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Precio_Unitario;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Precio_Venta;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Proveedor;
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Talla;
    private javax.swing.JButton btnsubir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
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
    private javax.swing.JTable jTable1;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private javax.swing.JLabel lblfoto;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables

}
