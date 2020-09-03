
package Formularios;

import java.awt.Color;



/**
 *
 * @author Baltazar
 */
public class Compras_Celulares extends javax.swing.JFrame {

    int cont=0;
    public Compras_Celulares() {
        initComponents();
        //JC_categoria.setBackground(Color.white);
        
//      JC_categoria.setAnchoDeBorde(TOP_ALIGNMENT);
        
    }

    String[] a={"AutumnSkin","BusinessBlackSteelSkin","BusinessBlueSteelSkin","BusinessSkin","ChallengerDeepSkin",
        "CremeCoffeeSkin","CremeSkin","EmeraldDuskSkin","FieldOfWheatSkin","FindingNemoSkin","GreenMagicSkin","MagmaSkin","MangoSkin","MistAquaSkin",
    "MistSilverSkin","ModerateSkin","NebulaBrickWallSkin","NebulaSkin","OfficeBlue2007Skin","OfficeSilver2007Skin","RavenGraphiteGlassSkin",
    "RavenGraphiteSkin","SaharaSkin","SkinChangeListener","SkinInfo","SubstanceAbstractSkin","SubstanceAutumnLookAndFeel","SubstanceBusinessBlackSteelLookAndFeel","SubstanceBusinessBlueSteelLookAndFeel","SubstanceBusinessLookAndFeel",
    "SubstanceChallengerDeepLookAndFeel","SubstanceCremeCoffeeLookAndFeel","SubstanceEmeraldDuskLookAndFeel","SubstanceFieldOfWheatLookAndFeel"};
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jcMousePanel3 = new jcMousePanel.jcMousePanel();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textFieldRoundImage18 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel22 = new javax.swing.JLabel();
        JC_categoria1 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        comboBoxRound2 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        JC_categoria2 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jLabel30 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        textFieldRoundImage19 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel24 = new javax.swing.JLabel();
        textFieldRoundImage24 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel32 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        textFieldRoundImage20 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(600, 310));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(173, 173, 173));
        jLabel49.setText("-------------------------------------------------------------------------------------------------------------------");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 590, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(173, 173, 173));
        jLabel53.setText("__________________________________________________________________________________");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 590, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        textFieldRoundImage18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRoundImage18ActionPerformed(evt);
            }
        });

        jLabel22.setText("Nombre");

        JC_categoria1.setAnchoDeBorde(2.0F);
        JC_categoria1.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_categoria1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        jLabel28.setText("Categoria");

        jLabel29.setText("Clasificacion");

        comboBoxRound2.setAnchoDeBorde(2.0F);
        comboBoxRound2.setColorDeBorde(new java.awt.Color(173, 173, 173));
        comboBoxRound2.setFocusable(false);
        comboBoxRound2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        JC_categoria2.setAnchoDeBorde(2.0F);
        JC_categoria2.setColorDeBorde(new java.awt.Color(173, 173, 173));
        JC_categoria2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        jLabel30.setText("Proveedor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel28)
                        .addComponent(jLabel30))
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldRoundImage18, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JC_categoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JC_categoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(textFieldRoundImage18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(JC_categoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JC_categoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 560, 120));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_user.png"))); // NOI18N
        jButton4.setText("Agregar");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Modelo", "Marca", "Memoria interna", "Memoria externa"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 560, 150));

        textFieldRoundImage19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRoundImage19ActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldRoundImage19, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 315, 90, -1));

        jLabel24.setText("Cantidad");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 316, -1, -1));

        textFieldRoundImage24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRoundImage24ActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldRoundImage24, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 315, 70, -1));

        jLabel32.setText("Precio");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 316, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton5.setText("Aceptar");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        jTabbedPane1.addTab("Producto", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Modelo", "Marca", "Memoria interna", "Memoria externa"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma  de  pago"));

        jRadioButton1.setText("Contado");

        jRadioButton2.setText("Credito");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textFieldRoundImage20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRoundImage20ActionPerformed(evt);
            }
        });

        jLabel23.setText("Numero de factura");

        jLabel25.setText("Proveedor");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));

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
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton2.setText("Guardar");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                        .addComponent(textFieldRoundImage20, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(64, 64, 64)
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
                            .addComponent(textFieldRoundImage20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(7, 7, 7)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Comprobante", jPanel7);

        jPanel6.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 8, 620, 390));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldRoundImage18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRoundImage18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRoundImage18ActionPerformed

    private void textFieldRoundImage19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRoundImage19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRoundImage19ActionPerformed

    private void textFieldRoundImage24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRoundImage24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRoundImage24ActionPerformed

    private void textFieldRoundImage20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRoundImage20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRoundImage20ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        JFrame.setDefaultLookAndFeelDecorated(false);
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras_Celulares().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_categoria1;
    private org.edisoncor.gui.comboBox.ComboBoxRound JC_categoria2;
    private org.edisoncor.gui.comboBox.ComboBoxRound comboBoxRound2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage18;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage19;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage20;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage24;
    // End of variables declaration//GEN-END:variables
}
