    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;


import java.awt.Color;
import java.awt.HeadlessException;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amilcar
 */
public class Empleados_bueno extends javax.swing.JFrame {
   
    
    public Empleados_bueno() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        jdatefechanac.setSelectableDateRange( null,new Date());

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sexo = new javax.swing.ButtonGroup();
        Estado = new javax.swing.ButtonGroup();
        jcMousePanel3 = new jcMousePanel.jcMousePanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnombre = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtapellido = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtdireccion = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        jrbmasculino = new javax.swing.JRadioButton();
        jrbfemenino = new javax.swing.JRadioButton();
        jdatefechanac = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsueldo = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txttelefono = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        jlabelestado = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jrbActivo = new javax.swing.JRadioButton();
        jrbInactivo = new javax.swing.JRadioButton();
        txtdui = new javax.swing.JFormattedTextField();
        txtnit = new javax.swing.JFormattedTextField();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsubirfoto = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtbuscar = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbltotalregistros = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 30, -1, -1));

        jLabel3.setText("Apellido");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 61, -1, -1));

        jLabel5.setText("DUI");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 99, -1, -1));

        jLabel6.setText("NIT");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 137, -1, -1));

        jLabel7.setText("Dirección");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 165, -1, -1));

        jLabel8.setText("Sexo");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 196, -1, -1));
        jPanel5.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 27, 210, -1));
        jPanel5.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 58, 210, -1));
        jPanel5.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 165, 210, -1));

        jrbmasculino.setText("Masculino");
        jPanel5.add(jrbmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 193, 90, -1));

        jrbfemenino.setText("Femenino");
        jPanel5.add(jrbfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 193, 80, -1));
        jPanel5.add(jdatefechanac, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 233, 200, -1));

        jLabel9.setText("Fecha.Nac");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 233, -1, -1));

        jLabel10.setText("Teléfono");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 274, -1, -1));
        jPanel5.add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 302, 210, -1));
        jPanel5.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 271, 210, -1));

        jlabelestado.setText("Estado");
        jPanel5.add(jlabelestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel13.setText("Sueldo");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 305, -1, -1));

        jrbActivo.setText("Activo");
        jPanel5.add(jrbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        jrbInactivo.setText("Inactivo");
        jPanel5.add(jrbInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        try {
            txtdui.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel5.add(txtdui, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 200, -1));

        try {
            txtnit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel5.add(txtnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 200, -1));

        btnguardar.setBackground(new java.awt.Color(179, 212, 244));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(179, 212, 244));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnsalir.setText("   Salir     ");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(179, 212, 244));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        btnnuevo.setText("   Nuevo  ");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(179, 212, 244));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsubirfoto.setBackground(new java.awt.Color(179, 212, 244));
        btnsubirfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_user.png"))); // NOI18N
        btnsubirfoto.setText("Subir Foto");

        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsubirfoto)
                            .addComponent(btnnuevo)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalir))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsubirfoto)
                        .addGap(57, 57, 57)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo)
                    .addComponent(btncancelar)
                    .addComponent(btnsalir))
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("Registrar Empleados", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsquedas"));

        jLabel11.setText("Buscar");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros"));

        lbltotalregistros.setText("Total de Registros: ");

        t_datos.setModel(new javax.swing.table.DefaultTableModel(
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
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(t_datos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 428, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de Empleados", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 760, 490));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        panelRectTranslucido1.setColorPrimario(new java.awt.Color(0, 0, 102));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(733, 50));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrar Empleados");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 15, -1, -1));

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed


    }//GEN-LAST:event_btnnuevoActionPerformed

    
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
     
      
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
       
    }//GEN-LAST:event_t_datosMouseClicked
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados_bueno().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Estado;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsubirfoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private com.toedter.calendar.JDateChooser jdatefechanac;
    private javax.swing.JLabel jlabelestado;
    private javax.swing.JRadioButton jrbActivo;
    private javax.swing.JRadioButton jrbInactivo;
    private javax.swing.JRadioButton jrbfemenino;
    private javax.swing.JRadioButton jrbmasculino;
    private javax.swing.JLabel lbltotalregistros;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JTable t_datos;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtapellido;
    private org.edisoncor.gui.textField.TextFieldRoundImage txtbuscar;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtdireccion;
    private javax.swing.JFormattedTextField txtdui;
    private javax.swing.JFormattedTextField txtnit;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtnombre;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtsueldo;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txttelefono;
    // End of variables declaration//GEN-END:variables
}
