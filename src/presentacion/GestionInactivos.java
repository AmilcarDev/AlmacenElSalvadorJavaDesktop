/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import Control.BLLUsuario;
import Control.ConvertirMayuscula;
import Datos.Usuario;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Amilcar Cortez
 */
public class GestionInactivos extends javax.swing.JFrame {

    /**
     * Creates new form GestionInactivos
     */
    
    DefaultTableModel modelo_tabla;
    DefaultTableModel modelo_tabla2;
    BLLUsuario bll = new BLLUsuario();
    FileInputStream fis;
    int longitudBytes, apretafoto = 0, id=0;
    boolean consultar = false;
    Usuario u = new Usuario();
    
    public GestionInactivos() {
        initComponents();
        btnnuevo.setVisible(false);
        btnguardar.setVisible(false);
        btnsubir.setVisible(false);
        btneliminar.setVisible(false);
        metodos_de_inicio();
        inhabilitar_daralta();
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
        
       // bll.mostrarLista(modelo_tabla, tbldatos);
        bll.mostrarListaestadocero(modelo_tabla, tbldatos);
        //metodo para evitar mover posicion de columnas
        tbldatos.getTableHeader().setReorderingAllowed(false);
        
        tbldatos.getColumnModel().getColumn(0).setMaxWidth(0);
        tbldatos.getColumnModel().getColumn(0).setMinWidth(0);
        tbldatos.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        
    }
    
    public void inhabilitar_daralta(){
        
        btneliminar.setEnabled(false);
        btnnuevo.setEnabled(false);
        btnguardar.setEnabled(false);
        btnsubir.setEnabled(false);
        btnalta.setEnabled(false);
        txtdni.setEnabled(false);
    }
    
     public void habilitar_daralta(){
      
        btnalta.setEnabled(true);
        
    }
    
    public void metodos_de_inicio() {
       
        
        txtnombres.setDocument(new ConvertirMayuscula());
        txtapellidos.setDocument(new ConvertirMayuscula());
        txtbuscar.setDocument(new ConvertirMayuscula());
         txtusuario.setDocument(new ConvertirMayuscula());
        
        
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
                    System.out.println("longitud e bytes: " + longitudBytes);
                } catch (IOException e) {
                    System.out.println("error al cargar foto IO" + e);
                }
                
            } catch (Exception e) {
                System.out.println("error al cargar file" + e);
            }
            
        }
        
    }
    
    public void botonGuardar() {
        
        String ndi = txtdni.getText();
        String nombre = txtnombres.getText();
        String apellido = txtapellidos.getText();
        String correo = txtcorreo.getText();
        String telefono = txttelefono.getText();
        String usuario = txtusuario.getText();
        //String clave = txtcontra.getText();
        Float clave=Float.valueOf(txtcontra.getText().trim());
        Date fecha = jdatefecha.getDate();
       // String estado;
        u.setIdusuario(id);
        u.setDni(ndi);
        u.setNombres(nombre);
        u.setApellidos(apellido);
        u.setCorreo(correo);
        u.setTelefono(telefono);
        u.setUsuario(usuario);
        u.setClave(clave);
//        u.setFecha(fecha);
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
                
            }else if (apretafoto==1) {
                bll.modificarDatosconFoto(u);
            }
            limpiarTodo();
        }
    }
    
    public void actualizarTabla() {

        //limpiar la tabla
        while (modelo_tabla.getRowCount() > 0) {
            modelo_tabla.removeRow(0);
        }
        //cargando tabla
        //bll.mostrarLista(modelo_tabla, tbldatos);
        bll.mostrarListaestadocero(modelo_tabla, tbldatos);
        //bll.mostrarLista(modelo_tabla, tbldatos);
        
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
            //bll.buscarLista(modelo_tabla, tbldatos, dato);
            bll.buscarListaestadocero(modelo_tabla, tbldatos, dato);
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

        pane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        btnsubir = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnalta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdatefecha = new com.toedter.calendar.JDateChooser();
        txtdni = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtnombres = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtapellidos = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtcorreo = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txttelefono = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtusuario = new org.edisoncor.gui.textField.TextFieldRoundImage();
        txtcontra = new org.edisoncor.gui.textField.TextFieldRoundImage();
        btnsalir1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtbuscar = new org.edisoncor.gui.textField.TextFieldRoundImage();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnsubir.setText("Subir foto");
        btnsubir.setEnabled(false);
        btnsubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubirActionPerformed(evt);
            }
        });

        btnnuevo.setText("Nuevo");
        btnnuevo.setEnabled(false);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.setEnabled(false);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.setEnabled(false);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnalta.setBackground(new java.awt.Color(179, 212, 244));
        btnalta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/up.png"))); // NOI18N
        btnalta.setText("Dar de alta");
        btnalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaltaActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("DUI");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 16, -1, 23));

        jLabel4.setText("Nombres");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 57, -1, 23));

        jLabel5.setText("Apellidos");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 98, -1, 23));

        jLabel6.setText("NIT");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 139, -1, 23));

        jLabel7.setText("Telefono");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 180, -1, 23));

        jLabel8.setText("Dirección");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 221, -1, 23));

        jLabel10.setText("Sueldo");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, 23));

        jLabel9.setText("Fecha de Nacimiento");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 23));

        jdatefecha.setEnabled(false);
        jPanel4.add(jdatefecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 113, -1));

        txtdni.setEnabled(false);
        jPanel4.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 17, 200, -1));

        txtnombres.setEnabled(false);
        jPanel4.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 58, 200, -1));

        txtapellidos.setEnabled(false);
        txtapellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidosActionPerformed(evt);
            }
        });
        jPanel4.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 99, 200, -1));

        txtcorreo.setEnabled(false);
        jPanel4.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 140, 200, -1));

        txttelefono.setEnabled(false);
        jPanel4.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 181, 200, -1));

        txtusuario.setEnabled(false);
        jPanel4.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 222, 200, -1));

        txtcontra.setEnabled(false);
        jPanel4.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 199, -1));

        btnsalir1.setBackground(new java.awt.Color(179, 212, 244));
        btnsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnsalir1.setText("   Salir     ");
        btnsalir1.setPreferredSize(new java.awt.Dimension(111, 29));
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsubir)
                            .addComponent(btnnuevo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btneliminar))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnalta)
                        .addGap(18, 18, 18)
                        .addComponent(btnsalir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnguardar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnsubir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btnalta)
                    .addComponent(btnsalir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pane.addTab("Registro Empleados", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros Inactivos"));

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldatos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 570, 250));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel1.setText("Buscar");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search.png"))); // NOI18N

        txtbuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtbuscarCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, -1));

        pane.addTab("Lista de Empleados", jPanel1);

        getContentPane().add(pane, java.awt.BorderLayout.CENTER);

        panelRectTranslucido1.setColorPrimario(new java.awt.Color(0, 0, 102));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(696, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrar Empleados Inactivos");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button-close.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRectTranslucido1Layout = new javax.swing.GroupLayout(panelRectTranslucido1);
        panelRectTranslucido1.setLayout(panelRectTranslucido1Layout);
        panelRectTranslucido1Layout.setHorizontalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(142, 142, 142)
                .addComponent(jLabel11)
                .addGap(18, 18, 18))
        );
        panelRectTranslucido1Layout.setVerticalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbldatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldatosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==2) {
            consultar=true;
            int fila=tbldatos.getSelectedRow();
            id=(int) tbldatos.getValueAt(fila,0);
            Object [] datos=bll.consultarporID(id, lblfoto);
            txtdni.setText(datos[0].toString());
            txtnombres.setText(datos[1].toString());
            txtapellidos.setText(datos[2].toString());
            txtcorreo.setText(datos[3].toString());
            txttelefono.setText(datos[4].toString());
            txtusuario.setText(datos[5].toString());
            txtcontra.setText(datos[6].toString());
            jdatefecha.setDate((Date)(datos[7]));
            lblfoto.setIcon((Icon)(datos[8]));
            pane.setSelectedIndex(0);

        }
        habilitar_daralta();
    }//GEN-LAST:event_tbldatosMouseClicked

    private void btnsubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubirActionPerformed
        // TODO add your handling code here:
        cargarFoto();
    }//GEN-LAST:event_btnsubirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        limpiarTodo();
        btnguardar.setEnabled(true);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        int respuesta=JOptionPane.showConfirmDialog(null,"Realmente desea dar de baja al empleado?");
        if (respuesta==0) {
            u.setIdusuario(id);
            bll.eliminarUsuario(u);
            limpiarTodo();

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        botonGuardar();
        actualizarTabla();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaltaActionPerformed
        // TODO add your handling code here:
        int respuesta=JOptionPane.showConfirmDialog(null,"Realmente desea dar de alta al empleado"+txtnombres.getText()+"?");
        if (respuesta==0) {
            u.setIdusuario(id);
            bll.dardealta(u);
            limpiarTodo();
            actualizarTabla();
            btnalta.setEnabled(false);
        }
        
    }//GEN-LAST:event_btnaltaActionPerformed

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalir1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txtapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidosActionPerformed

    private void txtbuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtbuscarCaretUpdate
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_txtbuscarCaretUpdate

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
            java.util.logging.Logger.getLogger(GestionInactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionInactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionInactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionInactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionInactivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnalta;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JButton btnsubir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdatefecha;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JTabbedPane pane;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private javax.swing.JTable tbldatos;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtapellidos;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtbuscar;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtcontra;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtcorreo;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtdni;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtnombres;
    private org.edisoncor.gui.textField.TextFieldRoundImage txttelefono;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtusuario;
    // End of variables declaration//GEN-END:variables
}
