package presentacion;

import Control.BLLUsuario;
import Control.ConvertirMayuscula;
import Control.msm;
import Datos.DALUsuario;
import Datos.Usuario;
import Datos.Conexion;
import com.integra.login.ControladorBitacora;
import com.integra.session.ModeloSession;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Amilcar Cortez
 */


public class ahorasi extends javax.swing.JFrame {

    /**
     * Creates new form ahorasi
     */
    
    
    
    DefaultTableModel modelo_tabla;
    DefaultTableModel modelo_tabla2;
    BLLUsuario bll = new BLLUsuario();
    FileInputStream fis;
    int longitudBytes, apretafoto = 0, id=0, contador=0;
    boolean consultar = false;
    Usuario u = new Usuario();
    DALUsuario cnu;
    public static Conexion hc;
    
    
    
    
    
        public ahorasi() {
        initComponents();
        
            hc=new Conexion();
        jdatefecha.setSelectableDateRange( null,new java.util.Date());
        txtdni.setBorder(null);
        txtcorreo.setBorder(null);
        txttelefono.setBorder(null);
         lbl_dui_existe.setText(" ");
         lbl_nit_existe.setText(" ");
         lbl_tel_existe.setText(" ");
         
         deentrada();
         
         btneliminar.setEnabled(false);
         btnsubir.setEnabled(false);
         btnguardar.setEnabled(false);
         btncancelar.setEnabled(false);
         
        
        cnu = new DALUsuario();
        metodos_de_inicio();
        modelo_tabla = new DefaultTableModel() {
            @Override
            //para que no sean editables las filas
            public boolean isCellEditable(int fila, int columna) {
                
                return false;
            }
        };
        
        tbldatos.setModel(modelo_tabla);
        modelo_tabla.addColumn("id");
        modelo_tabla.addColumn("DUI");
        modelo_tabla.addColumn("Nombres");
        modelo_tabla.addColumn("Apellidos");
        modelo_tabla.addColumn("NIT");
        modelo_tabla.addColumn("Telefono");
        bll.mostrarLista(modelo_tabla, tbldatos);
        //bll.mostrarListaestadocero(modelo_tabla, tbldatos);
        //metodo para evitar mover posicion de columnas
        tbldatos.getTableHeader().setReorderingAllowed(false);
        
        tbldatos.getColumnModel().getColumn(0).setMaxWidth(0);
        tbldatos.getColumnModel().getColumn(0).setMinWidth(0);
        tbldatos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    
    
    
    
    
    
    
    
    
    ModeloSession mss;
    ControladorBitacora cb;
    
    public ahorasi(ModeloSession mss) {
        initComponents();
        this.mss=mss;
        cb= new ControladorBitacora();
            hc=new Conexion();
        jdatefecha.setSelectableDateRange( null,new java.util.Date());
        txtdni.setBorder(null);
        txtcorreo.setBorder(null);
        txttelefono.setBorder(null);
         lbl_dui_existe.setText(" ");
         lbl_nit_existe.setText(" ");
         lbl_tel_existe.setText(" ");
         
         deentrada();
         
         btneliminar.setEnabled(false);
         btnsubir.setEnabled(false);
         btnguardar.setEnabled(false);
         btncancelar.setEnabled(false);
         
        
        cnu = new DALUsuario();
        metodos_de_inicio();
        modelo_tabla = new DefaultTableModel() {
            @Override
            //para que no sean editables las filas
            public boolean isCellEditable(int fila, int columna) {
                
                return false;
            }
        };
        
        tbldatos.setModel(modelo_tabla);
        modelo_tabla.addColumn("id");
        modelo_tabla.addColumn("DUI");
        modelo_tabla.addColumn("Nombres");
        modelo_tabla.addColumn("Apellidos");
        modelo_tabla.addColumn("NIT");
        modelo_tabla.addColumn("Telefono");
        bll.mostrarLista(modelo_tabla, tbldatos);
        //bll.mostrarListaestadocero(modelo_tabla, tbldatos);
        //metodo para evitar mover posicion de columnas
        tbldatos.getTableHeader().setReorderingAllowed(false);
        
        tbldatos.getColumnModel().getColumn(0).setMaxWidth(0);
        tbldatos.getColumnModel().getColumn(0).setMinWidth(0);
        tbldatos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
//    public void Buscar_Existencia(JFormattedTextField d, String Tabla, String Campo) {
//        String Nombre = "";
//        Datos.abrirConexion();
//        this.Datos.Buscar("select * from " + Tabla + " where " + Campo + "='" + d.getText() + "' AND Id_Departamento=" + Numero_Departamento + "", Tabla);
//        try {
//            while (Datos.rs.next()) {
//                Nombre = Datos.rs.getString(Campo);
//            }
//        } catch (Exception e) {
//
//        }
//        Datos.cerrarConexion();
//        if (Nombre != "") {
//            msm.ms_informacion("Dato ya existe en tabla " + Tabla);
//            d.setText("");
//        }
//    }
    
 
    
     public void metodos_de_inicio() { 
        
        txtnombres.setDocument(new ConvertirMayuscula());
        txtapellidos.setDocument(new ConvertirMayuscula());
        txtusuario.setDocument(new ConvertirMayuscula());
        txtbuscar.setDocument(new ConvertirMayuscula());
        
        
    }
     
     public void deentrada(){
        txtdni.setEnabled(false);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        txtcorreo.setEnabled(false);
        txttelefono.setEnabled(false);
        txtcontra.setEnabled(false);
        txtusuario.setEnabled(false);
        jdatefecha.setEnabled(false);
     }
     
        public void paranuevo(){
        txtdni.setEnabled(true);
        txtnombres.setEnabled(true);
        txtapellidos.setEnabled(true);
        txtcorreo.setEnabled(true);
        txttelefono.setEnabled(true);
        txtcontra.setEnabled(true);
        txtusuario.setEnabled(true);
        jdatefecha.setEnabled(true);
     }
         public void paramodifi(){
        txtdni.setEnabled(false);
        txtnombres.setEnabled(true);
        txtapellidos.setEnabled(true);
        txtcorreo.setEnabled(false);
        txttelefono.setEnabled(true);
        txtcontra.setEnabled(true);
        txtusuario.setEnabled(true);
        jdatefecha.setEnabled(false);
     }
    
    public String dateTomySQLDate(Date fecha){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(fecha);
    }
    
    public static String Date_a_String_fecha2(Date fecha) { 
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
     String fec_string = sdf.format(fecha);
     return fec_string; 
    }
    
    public void habilitar_btnguardar(){
        
         String ndi = txtdni.getText();
        String nombre = txtnombres.getText();
        String apellido = txtapellidos.getText();
        String correo = txtcorreo.getText();
        String telefono = txttelefono.getText();
        String usuario = txtusuario.getText();
        
        if(ndi.isEmpty() ||nombre.isEmpty()|| apellido.isEmpty() || correo.isEmpty() || telefono.isEmpty() || usuario.isEmpty())
        {        
            btnguardar.setEnabled(false);
        }else{
            btnguardar.setEnabled(true);
        }
        
    }
    
    public void validarIngreso(){
        
        String ndi = txtdni.getText();
        String nombre = txtnombres.getText();
        String apellido = txtapellidos.getText();
        String correo = txtcorreo.getText();
        String telefono = txttelefono.getText();
        String usuario = txtusuario.getText();
//      Float clave=Float.valueOf(txtcontra.getText().trim());
        //Date fecha = (Date) new Date(jdatefecha.getDate());
       Date fecha = (Date) jdatefecha.getDate();
        if(ndi.isEmpty() ||nombre.isEmpty()||
        apellido.isEmpty() || correo.isEmpty() || telefono.isEmpty() || usuario.isEmpty()
         || fecha==null)
        {        
            btnguardar.setEnabled(false);
        }else{
            btnguardar.setEnabled(true);
        }
        
        
    }
    
    
    public void cargarFoto() {
        
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & PNG","jpg", "png");
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
        
    public void botonGuardar() {
        
        if(validar()==0){
        String ndi = txtdni.getText();
        String nombre = txtnombres.getText();
        String apellido = txtapellidos.getText();
        String correo = txtcorreo.getText();
        String telefono = txttelefono.getText();
        String usuario = txtusuario.getText();
//      Float clave = txtcontra.getText();
        Float clave=Float.valueOf(txtcontra.getText().trim());
        Date fecha = new java.sql.Date(jdatefecha.getDate().getTime());
       // String estado;
        u.setIdusuario(id);
        u.setDni(ndi);
        u.setNombres(nombre);
        u.setApellidos(apellido);
        u.setCorreo(correo);
        u.setTelefono(telefono);
        u.setUsuario(usuario);
        u.setClave(clave);
        u.setFecha((java.sql.Date) fecha);
        u.setFis(fis);
        u.setLongitudBytes(longitudBytes);
        
        
        if (consultar == false) {
            //insertar
            
            bll.insertarDatos(u);
            limpiarTodo();
            
            
        } else if (consultar == true) {
            //modificar
            if (apretafoto==0) {
                bll.modificarDatossinFoto(u);
                btneliminar.setEnabled(false);
                btnsubir.setEnabled(false);
                deentrada();
                
            }else if (apretafoto==1) {
                bll.modificarDatosconFoto(u);
            }
            limpiarTodo();
        }
        }
        
    }
    
     public int validar() {
        int op = 0;
        Float sueldo= Float.valueOf(txtcontra.getText().trim());
        String mensaje = "";
        
      
        if (txtnombres.getText().equals("")|| txtnombres.getText().trim().length() < 3 ) {
            op = 1;
            mensaje = mensaje+ "* Verifique la longitud del campo Nombre\n";
        }
        if ((txtapellidos.getText().trim().equals("") || txtapellidos.getText().trim().length() < 3)) {
            op = 2;
            mensaje = mensaje + "* Verifique la longitud del campo Apellido\n";
        }
        if ((txtusuario.getText().trim().equals("")|| txtusuario.getText().trim().length() < 12)) {
            op = 3;
            mensaje = mensaje + "* Verifique la longitud del campo Dirección\n";
        }

        if (txtcontra.getText().trim().isEmpty() || txtcontra.getText().length()>3) {
            op = 4;
            mensaje = mensaje + "* Verifique la longitud del campo Sueldo\n";
       }     
        if (sueldo<251) {
            op=5;
            mensaje= mensaje + ("* El salraio no debe ser menor al mínimo legal\n");
        }
        
        if(!(txttelefono.getText().matches("[6]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}")
                ||txttelefono.getText().matches("[2]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}")
                        || txttelefono.getText().matches("[7]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))){          
            op=6;
            mensaje= mensaje + ("* El número debe comenzar por 2, 6 ó 7\n");
                }
        
        contador=0;
        java.util.Date fechaSelecNIT = jdatefecha.getDate();
            SimpleDateFormat formatoNIT = new SimpleDateFormat("ddMMyy");
            String F_Nac = formatoNIT.format(fechaSelecNIT);
           char [] cad= F_Nac.toCharArray();
           char [] aux =null;
           String cadena=txtcorreo.getText();
            char [] caracteres= cadena.toCharArray(); 
           for (int i=5;i<=10;i++){
                   if(cad[i-5]==caracteres[i]){
                       contador++;
                   }
             }
          System.out.println(contador);
//         ///////////////////////////////////////////////////////////////////////////////////  
        if (txtcorreo.getText().trim().length() <= 14 || contador<6) {
            op = 7;
            mensaje = mensaje + "* verifique campo NIT\n";
        }
        
        /////////////////////validarmenor de edad //////////////////
        
        java.util.Date fechaActual = new java.util.Date();
        java.util.Date fechaSelec = jdatefecha.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoS = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formato.format(fechaActual);
        if ((fechaActual.getYear() - jdatefecha.getDate().getYear()) < 18) {
            op=8;
            mensaje = mensaje + "* El empleado es menor de edad\n";
        }

        /////////////////////validar menor de edad //////////////////
        
        
        if (op > 0) {
            msm.ms_alerta("Verifique los Campos :\n" + mensaje);
        }
        return op;
    }
    
    public void actualizarTabla() {

        //limpiar la tabla
        while (modelo_tabla.getRowCount() > 0) {
            modelo_tabla.removeRow(0);
        }
        //cargando tabla
        bll.mostrarLista(modelo_tabla, tbldatos);
        
    }
    
    
    public void limpiarTodo(){
        
        txtdni.setText(null);
        txtnombres.setText(null);
        txtapellidos.setText(null);
        txtcorreo.setText(null);
        txttelefono.setText(null);
        txtusuario.setText(null);
        txtcontra.setText(null);
        jdatefecha.setDate(null);
        lblfoto.setIcon(null);
        consultar=false;
        apretafoto=0;
        btnguardar.setEnabled(false);
        actualizarTabla();
        
        
    }
    
    public void buscar(){
        
        String dato=txtbuscar.getText();
        
        if(dato.isEmpty()){
        actualizarTabla();
        }else if (!dato.isEmpty()) {
            while(modelo_tabla.getRowCount()>0)
            modelo_tabla.removeRow(0);
            bll.buscarLista(modelo_tabla, tbldatos, dato);
            //bll.buscarListaestadocero(modelo_tabla, tbldatos, dato);
        }
    }
    
    public void bloquear_si_existe_dui(){
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        
    }
    
     public void habilitar_sinoexiste_dui(){
        txtnombres.setEnabled(true);
        txtapellidos.setEnabled(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtdni = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JFormattedTextField();
        txtcorreo = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jdatefecha = new com.toedter.calendar.JDateChooser();
        lbl_tel_existe = new javax.swing.JLabel();
        lbl_nit_existe = new javax.swing.JLabel();
        lbl_dui_existe = new javax.swing.JLabel();
        txtnombres = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtapellidos = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtusuario = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtcontra = new org.edisoncor.gui.textField.TextFieldRoundImage();
        textFieldRoundImage1 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        textFieldRoundImage2 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        textFieldRoundImage4 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        btneliminar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnsubir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnactivar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtbuscar = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRectTranslucido1.setColorPrimario(new java.awt.Color(0, 0, 102));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRectTranslucido1.setMinimumSize(new java.awt.Dimension(740, 46));
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(740, 50));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrar Empleados");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button-close.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        panelRectTranslucido1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 10, -1, -1));

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(823, 460));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 40, 210, 250));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos personales"));
        jPanel4.setPreferredSize(new java.awt.Dimension(430, 310));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            txtdni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdni.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtdniCaretUpdate(evt);
            }
        });
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdniKeyReleased(evt);
            }
        });
        jPanel4.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 33, 200, -1));

        jLabel3.setText("DUI");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 27, -1, 23));

        jLabel4.setText("Nombres");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 63, -1, 23));

        jLabel5.setText("Apellidos");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 23));

        jLabel6.setText("NIT");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 23));

        jLabel7.setText("Teléfono");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 23));

        try {
            txttelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txttelefono.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txttelefonoCaretUpdate(evt);
            }
        });
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
        });
        jPanel4.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 183, 200, -1));

        try {
            txtcorreo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcorreo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtcorreoCaretUpdate(evt);
            }
        });
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcorreoKeyReleased(evt);
            }
        });
        jPanel4.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 143, 200, -1));

        jLabel9.setText("Dirección");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, 23));

        jLabel11.setText("Sueldo");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, 23));

        jLabel10.setText("Fecha de Nacimiento");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 23));

        jdatefecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdatefechaPropertyChange(evt);
            }
        });
        jPanel4.add(jdatefecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 150, 30));

        lbl_tel_existe.setText("tel_existe");
        jPanel4.add(lbl_tel_existe, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 181, 30, -1));

        lbl_nit_existe.setText("nit existe");
        jPanel4.add(lbl_nit_existe, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 123, 20, -1));

        lbl_dui_existe.setText("dui existe");
        jPanel4.add(lbl_dui_existe, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 20, 20));

        txtnombres.setPreferredSize(new java.awt.Dimension(69, 18));
        txtnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresActionPerformed(evt);
            }
        });
        txtnombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombresKeyTyped(evt);
            }
        });
        jPanel4.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 64, 220, 23));

        txtapellidos.setPreferredSize(new java.awt.Dimension(69, 23));
        txtapellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidosActionPerformed(evt);
            }
        });
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });
        jPanel4.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 105, 220, -1));

        txtusuario.setPreferredSize(new java.awt.Dimension(69, 23));
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        jPanel4.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 290, -1));

        txtcontra.setPreferredSize(new java.awt.Dimension(69, 23));
        txtcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraActionPerformed(evt);
            }
        });
        txtcontra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraKeyTyped(evt);
            }
        });
        jPanel4.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 220, -1));

        textFieldRoundImage1.setEnabled(false);
        textFieldRoundImage1.setPreferredSize(new java.awt.Dimension(69, 19));
        jPanel4.add(textFieldRoundImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 220, 24));

        textFieldRoundImage2.setEnabled(false);
        textFieldRoundImage2.setPreferredSize(new java.awt.Dimension(69, 19));
        jPanel4.add(textFieldRoundImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 220, 24));

        textFieldRoundImage4.setEnabled(false);
        textFieldRoundImage4.setPreferredSize(new java.awt.Dimension(69, 19));
        jPanel4.add(textFieldRoundImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, 24));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 480, 360));

        btneliminar.setBackground(new java.awt.Color(179, 212, 244));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/dow.png"))); // NOI18N
        btneliminar.setText("Desactivar");
        btneliminar.setPreferredSize(new java.awt.Dimension(124, 29));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, -1));

        btnguardar.setBackground(new java.awt.Color(179, 212, 244));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setPreferredSize(new java.awt.Dimension(124, 29));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        btncancelar.setBackground(new java.awt.Color(179, 212, 244));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setPreferredSize(new java.awt.Dimension(124, 29));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, -1, -1));

        btnsalir.setBackground(new java.awt.Color(179, 212, 244));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnsalir.setText("   Salir     ");
        btnsalir.setPreferredSize(new java.awt.Dimension(124, 29));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, -1, -1));

        btnnuevo.setBackground(new java.awt.Color(179, 212, 244));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_user.png"))); // NOI18N
        btnnuevo.setText("   Nuevo  ");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        btnsubir.setBackground(new java.awt.Color(179, 212, 244));
        btnsubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/addfoto.png"))); // NOI18N
        btnsubir.setText("Subir Foto");
        btnsubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubirActionPerformed(evt);
            }
        });
        jPanel2.add(btnsubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        pane.addTab("Registrar Empleados", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros"));

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DUI", "Teléfono", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldatos);

        btnactualizar.setBackground(new java.awt.Color(179, 212, 244));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        btnactualizar.setText("Actualizar Registros");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnactualizar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnactualizar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados Inactivos"));

        btnactivar.setBackground(new java.awt.Color(179, 212, 244));
        btnactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/up.png"))); // NOI18N
        btnactivar.setText("Activar Empleados");
        btnactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnactivar)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnactivar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsquedas"));

        jLabel12.setText("Buscar");

        txtbuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtbuscarCaretUpdate(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );

        pane.addTab("Lista de Empleados", jPanel1);

        getContentPane().add(pane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jdatefechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdatefechaPropertyChange
        // TODO add your handling code here:
        //        validarIngreso();

    }//GEN-LAST:event_jdatefechaPropertyChange

    private void txtdniCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtdniCaretUpdate
        // TODO add your handling code here:

        
//        else {
//            lbl_dui_existe.setText("");
//
//        }

    }//GEN-LAST:event_txtdniCaretUpdate

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
//       txtnombres.requestFocus();
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtcorreoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtcorreoCaretUpdate
        // TODO add your handling code here:
//        if (!(txtcorreo.equals(""))) {
//            if ((cnu.nitexiste(txtcorreo.getText()))) {
//                lbl_nit_existe.setText(" ");
//
//            } else {
//                lbl_nit_existe.setForeground(Color.red);
//                lbl_nit_existe.setText("El nit ya existe!");
//                //                bloquear_si_existe_dui();
//                //               txtdni.requestFocus();
//            }
//        } else {
//            lbl_nit_existe.setText("");
//
//        }

    }//GEN-LAST:event_txtcorreoCaretUpdate

    private void txttelefonoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txttelefonoCaretUpdate
        // TODO add your handling code here:
//
//        if (!(txttelefono.equals(""))) {
//            if ((cnu.telefonoexiste(txttelefono.getText()))) {
//                lbl_tel_existe.setText(" ");
//
//            } else {
//                lbl_tel_existe.setForeground(Color.red);
//                lbl_tel_existe.setText("El numero ya fue asignado!");
//                //                bloquear_si_existe_dui();
//                //               txtdni.requestFocus();
//            }
//        } else {
//            lbl_tel_existe.setText("");
//
//        }

    }//GEN-LAST:event_txttelefonoCaretUpdate

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        //int respuesta=JOptionPane.showConfirmDialog(null, "Realmente desea dar de baja al usuario?",new ImageIcon("alerta.png"));
        int respuesta=JOptionPane.showConfirmDialog(null,"Realmente desea dar de baja al empleado "+txtnombres.getText()+" ?");

        if (respuesta==0) {
            u.setIdusuario(id);
            bll.eliminarUsuario(u);
            limpiarTodo();
            btneliminar.setEnabled(false);
            btnsubir.setEnabled(false);

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        botonGuardar();
        cb.insertarAccion(mss.getNombre(),"Agrego un nuevo empleado");
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        deentrada();
        
        txtdni.setText("");
        txtnombres.setText("");
        txtapellidos.setText("");
        txtcorreo.setText("");
        txttelefono.setText("");
        txtcontra.setText("");
        txtusuario.setText("");
        jdatefecha.setDate(null);
        lblfoto.setIcon(null);
        
        btneliminar.setEnabled(false);
         btnsubir.setEnabled(false);
         btnguardar.setEnabled(false);
         btncancelar.setEnabled(false);
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtdni.requestFocus();
        pane.setTitleAt(0,"Registrar Empleados");
        limpiarTodo();
        btnguardar.setEnabled(true);
        btnguardar.setText("Guardar");
        btnsubir.setEnabled(true);
         btncancelar.setEnabled(true);
         txtdni.setEnabled(true);
         txtcorreo.setEnabled(true);
         
         paranuevo();

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnsubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubirActionPerformed
        // TODO add your handling code here:
        cargarFoto();
    }//GEN-LAST:event_btnsubirActionPerformed

    private void tbldatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldatosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            consultar = true;

            int fila = tbldatos.getSelectedRow();
            id = (int) tbldatos.getValueAt(fila, 0);
            Object[] datos = bll.consultarporID(id, lblfoto);
            txtdni.setText(datos[0].toString());
            txtdni.setEnabled(false);
            txtnombres.setText(datos[1].toString());
            txtapellidos.setText(datos[2].toString());
            txtcorreo.setText(datos[3].toString());
            txtcorreo.setEnabled(false);
            txttelefono.setText(datos[4].toString());
            txtusuario.setText(datos[5].toString());
            txtcontra.setText(datos[6].toString());
            jdatefecha.setDate((Date) (datos[7]));
            lblfoto.setIcon((Icon) (datos[8]));
              lbl_dui_existe.setText(" ");
              lbl_nit_existe.setText(" ");
             lbl_tel_existe.setText(" ");
            pane.setSelectedIndex(0);
            pane.setTitleAt(0, "Modificar Empleados");
            btnguardar.setText("Modificar");
            btnguardar.setEnabled(true);
            btneliminar.setEnabled(true);
            jdatefecha.setEnabled(false);
            btnsubir.setEnabled(true);
            btncancelar.setEnabled(true);
            
            paramodifi();

        }
    }//GEN-LAST:event_tbldatosMouseClicked

    private void btnactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactivarActionPerformed
        // TODO add your handling code here:
        GestionInactivos gi=new GestionInactivos();
        gi.setVisible(true);
        gi.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnactivarActionPerformed

    private void txtbuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtbuscarCaretUpdate
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_txtbuscarCaretUpdate

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
        txttelefono.requestFocus();
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
        txtusuario.requestFocus();
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtdniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyReleased
        // TODO add your handling code here:
       // duiyaesiste();
         if (!(txtdni.equals(""))) {
            if ((cnu.duiexiste(txtdni.getText()))) {
                lbl_dui_existe.setText(" ");

            } else {
               // lbl_dui_existe.setForeground(Color.red);
                //lbl_dui_existe.setText("DUI ya existe!");
                msm.ms_informacion("El número de DUI ya existe");
                txtdni.setText("");
                //                bloquear_si_existe_dui();
                //               txtdni.requestFocus();
            }
        }
        
    }//GEN-LAST:event_txtdniKeyReleased

    private void txtcorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyReleased
        // TODO add your handling code here:
                 if (!(txtcorreo.equals(""))) {
            if ((cnu.nitexiste(txtcorreo.getText()))) {
                lbl_dui_existe.setText(" ");

            } else {
               // lbl_dui_existe.setForeground(Color.red);
                //lbl_dui_existe.setText("DUI ya existe!");
                msm.ms_informacion("El número de NIT ya existe");
                txtcorreo.setText("");
                //                bloquear_si_existe_dui();
                //               txtdni.requestFocus();
            }
        }
        
    }//GEN-LAST:event_txtcorreoKeyReleased

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        // TODO add your handling code here:
//        if (!(txttelefono.equals(""))) {
//            if ((cnu.telefonoexiste(txttelefono.getText()))) {
//                lbl_dui_existe.setText(" ");
//
//            } else {
//               // lbl_dui_existe.setForeground(Color.red);
//                //lbl_dui_existe.setText("DUI ya existe!");
//                msm.ms_informacion("El numero de telefono ya fue asignado");
//                txttelefono.setText("");
//                //                bloquear_si_existe_dui();
//                //               txtdni.requestFocus();
//            }
//        }
    }//GEN-LAST:event_txttelefonoKeyReleased

    private void txtnombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresKeyTyped
        // TODO add your handling code here:
         char c= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        if (Character.isDigit(c) || k==64) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombresKeyTyped

    private void txtnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresActionPerformed
        // TODO add your handling code here:
       txtapellidos.requestFocus();
    }//GEN-LAST:event_txtnombresActionPerformed

    private void txtapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosActionPerformed
        // TODO add your handling code here:
        txtcorreo.requestFocus();
    }//GEN-LAST:event_txtapellidosActionPerformed

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        // TODO add your handling code here:
         char c= evt.getKeyChar();
        int k=(int)evt.getKeyChar();
        if (Character.isDigit(c) || k==64) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
        txtcontra.requestFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraActionPerformed
        // TODO add your handling code here:
        jdatefecha.requestFocus();
    }//GEN-LAST:event_txtcontraActionPerformed

    private void txtcontraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (((caracter < '0')
            || (caracter > '9')) && (caracter != '.')) {
        evt.consume();
        }
    }//GEN-LAST:event_txtcontraKeyTyped

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        actualizarTabla();
    }//GEN-LAST:event_btnactualizarActionPerformed

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
            java.util.logging.Logger.getLogger(ahorasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ahorasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ahorasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ahorasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ahorasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactivar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsubir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdatefecha;
    private javax.swing.JLabel lbl_dui_existe;
    private javax.swing.JLabel lbl_nit_existe;
    private javax.swing.JLabel lbl_tel_existe;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JTabbedPane pane;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private javax.swing.JTable tbldatos;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage1;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage2;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage4;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtapellidos;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtbuscar;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtcontra;
    private javax.swing.JFormattedTextField txtcorreo;
    private javax.swing.JFormattedTextField txtdni;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtnombres;
    private javax.swing.JFormattedTextField txttelefono;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtusuario;
    // End of variables declaration//GEN-END:variables
}
