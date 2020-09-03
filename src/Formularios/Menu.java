package Formularios;


import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.lang.System.exit;
import javax.swing.ImageIcon;

public class Menu extends javax.swing.JFrame {

    int cont = 0;
    String paquete = "Iconos";

    public Menu() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        Menu_Inicio = new javax.swing.JPopupMenu();
        Submenu1 = new javax.swing.JMenuItem();
        Submenu2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Productos = new javax.swing.JPopupMenu();
        R_Calzado = new javax.swing.JMenuItem();
        R_Celulares = new javax.swing.JMenuItem();
        R_Ropa = new javax.swing.JMenuItem();
        R_Perfume = new javax.swing.JMenuItem();
        jpmCompras = new javax.swing.JPopupMenu();
        jmiCalzado = new javax.swing.JMenuItem();
        jmiCelular = new javax.swing.JMenuItem();
        jmiPerfume = new javax.swing.JMenuItem();
        jmiRopa = new javax.swing.JMenuItem();
        jpmReportes = new javax.swing.JPopupMenu();
        jmiEmpleados = new javax.swing.JMenuItem();
        jmiProductos = new javax.swing.JMenuItem();
        jmiBitacora = new javax.swing.JMenuItem();
        jmiVentas = new javax.swing.JMenuItem();
        jp = new javax.swing.JPanel();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jcMousePanel5 = new jcMousePanel.jcMousePanel();
        mi_panel_menu = new javax.swing.JPanel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jcMousePanel3 = new jcMousePanel.jcMousePanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jcMousePanel2 = new jcMousePanel.jcMousePanel();
        Logo2 = new org.edisoncor.gui.panel.PanelImageReflect();
        panel4 = new org.edisoncor.gui.panel.Panel();
        panel3 = new jcMousePanel.jcMousePanel();
        jcMousePanel4 = new jcMousePanel.jcMousePanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("IntegraAlmacen");

        Submenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cesion.png"))); // NOI18N
        Submenu1.setText("jMenuItem1");
        Submenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submenu1ActionPerformed(evt);
            }
        });
        Menu_Inicio.add(Submenu1);

        Submenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Informacion (2).png"))); // NOI18N
        Submenu2.setText("jMenuItem2");
        Submenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submenu2ActionPerformed(evt);
            }
        });
        Menu_Inicio.add(Submenu2);

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        Menu_Inicio.add(jMenu1);

        R_Calzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Zapatos.png"))); // NOI18N
        R_Calzado.setText("jMenuItem2");
        Productos.add(R_Calzado);

        R_Celulares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Telefo.png"))); // NOI18N
        R_Celulares.setText("jMenuItem2");
        R_Celulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_CelularesActionPerformed(evt);
            }
        });
        Productos.add(R_Celulares);

        R_Ropa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Rop.png"))); // NOI18N
        R_Ropa.setText("jMenuItem2");
        Productos.add(R_Ropa);

        R_Perfume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Per.png"))); // NOI18N
        R_Perfume.setText("jMenuItem3");
        Productos.add(R_Perfume);

        jmiCalzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Zapatos.png"))); // NOI18N
        jmiCalzado.setText("jMenuItem3");
        jmiCalzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCalzadoActionPerformed(evt);
            }
        });
        jpmCompras.add(jmiCalzado);

        jmiCelular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Telefo.png"))); // NOI18N
        jmiCelular.setText("jMenuItem5");
        jpmCompras.add(jmiCelular);

        jmiPerfume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Per.png"))); // NOI18N
        jmiPerfume.setText("jMenuItem4");
        jpmCompras.add(jmiPerfume);

        jmiRopa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Rop.png"))); // NOI18N
        jmiRopa.setText("jMenuItem2");
        jpmCompras.add(jmiRopa);

        jmiEmpleados.setText("jMenuItem2");
        jmiEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmpleadosActionPerformed(evt);
            }
        });
        jpmReportes.add(jmiEmpleados);

        jmiProductos.setText("jMenuItem3");
        jpmReportes.add(jmiProductos);

        jmiBitacora.setText("jMenuItem4");
        jpmReportes.add(jmiBitacora);

        jmiVentas.setText("jMenuItem5");
        jpmReportes.add(jmiVentas);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1433, 9055));

        jp.setPreferredSize(new java.awt.Dimension(242, 64));
        jp.setLayout(new java.awt.BorderLayout());

        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(44, 24));
        jp.add(panel1, java.awt.BorderLayout.PAGE_START);

        jcMousePanel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Barra_Latera.png"))); // NOI18N

        javax.swing.GroupLayout jcMousePanel5Layout = new javax.swing.GroupLayout(jcMousePanel5);
        jcMousePanel5.setLayout(jcMousePanel5Layout);
        jcMousePanel5Layout.setHorizontalGroup(
            jcMousePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        jcMousePanel5Layout.setVerticalGroup(
            jcMousePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jp.add(jcMousePanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jp, java.awt.BorderLayout.LINE_END);

        mi_panel_menu.setLayout(new java.awt.BorderLayout());

        panel2.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel2.setPreferredSize(new java.awt.Dimension(44, 24));
        mi_panel_menu.add(panel2, java.awt.BorderLayout.PAGE_START);

        jcMousePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Barra_Latera.png"))); // NOI18N
        jcMousePanel3.setName(""); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Inicio.png"))); // NOI18N
        jLabel2.setToolTipText("Inicio");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Ventas.png"))); // NOI18N
        jLabel6.setToolTipText("Ventas");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Proveedor.png"))); // NOI18N
        jLabel5.setToolTipText("Proveedor");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Compras.png"))); // NOI18N
        jLabel7.setToolTipText("Compras");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Empleado.png"))); // NOI18N
        jLabel8.setToolTipText("Empleados");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Producto.png"))); // NOI18N
        jLabel3.setToolTipText("Productos");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reportes.png"))); // NOI18N
        jLabel11.setToolTipText("Reportes");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Seguridad.png"))); // NOI18N
        jLabel12.setToolTipText("Seguridad");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel12MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel3Layout = new javax.swing.GroupLayout(jcMousePanel3);
        jcMousePanel3.setLayout(jcMousePanel3Layout);
        jcMousePanel3Layout.setHorizontalGroup(
            jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(37, 37, 37))
            .addGroup(jcMousePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel3Layout.createSequentialGroup()
                        .addGroup(jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27))))
        );
        jcMousePanel3Layout.setVerticalGroup(
            jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mi_panel_menu.add(jcMousePanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(mi_panel_menu, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jcMousePanel1.setLayout(new java.awt.BorderLayout());

        jcMousePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Barra_Latera.png"))); // NOI18N
        jcMousePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/balta.png"))); // NOI18N
        jcMousePanel2.add(Logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 624, 260));

        jcMousePanel1.add(jcMousePanel2, java.awt.BorderLayout.CENTER);

        panel4.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel4.setPreferredSize(new java.awt.Dimension(44, 24));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 934, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        jcMousePanel1.add(panel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jcMousePanel1, java.awt.BorderLayout.CENTER);

        panel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Header.png"))); // NOI18N
        panel3.setPreferredSize(new java.awt.Dimension(1024, 100));
        getContentPane().add(panel3, java.awt.BorderLayout.PAGE_START);

        jcMousePanel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pie2.png"))); // NOI18N
        jcMousePanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("UES-FMP DERECHOS RESERVADOS 2016");
        jcMousePanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 15, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Sin título-1.png"))); // NOI18N
        jcMousePanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, -1));

        getContentPane().add(jcMousePanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.Submenu1.setText("Cerra cesión");
        this.Submenu2.setText("Informacion");
        Menu_Inicio.show(evt.getComponent(), evt.getX(), evt.getY());

    }//GEN-LAST:event_jLabel2MouseClicked

    private void Submenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submenu1ActionPerformed
        exit(0);
    }//GEN-LAST:event_Submenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
        // jLabel12.setIcon(new ImageIcon(getClass().getResource("/wer/Seguridad2.png")));
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Seguridad3.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Seguridad.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Producto2.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Producto.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.R_Celulares.setText("Registro de Celulares");
        this.R_Calzado.setText("Registro de Calzado");
        this.R_Perfume.setText("Registro de Perfume");
        this.R_Ropa.setText("Registro de Ropa");
        Productos.show(evt.getComponent(), evt.getX(), evt.getY());

    }//GEN-LAST:event_jLabel3MouseClicked

    private void R_CelularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_CelularesActionPerformed
 

    }//GEN-LAST:event_R_CelularesActionPerformed

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Inicio2.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Inicio.png")));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Proveedor2.png")));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Proveedor.png")));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Ventas2.png")));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Ventas.png")));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Compras2.png")));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Compras.png")));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Empleado2.png")));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Empleado.png")));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Reportes2.png")));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Reportes.png")));
    }//GEN-LAST:event_jLabel11MouseExited

    private void Submenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submenu2ActionPerformed

    }//GEN-LAST:event_Submenu2ActionPerformed

    private void jmiCalzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCalzadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiCalzadoActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        this.jmiCalzado.setText("  Compra de Calzado");
        this.jmiCelular.setText("  Comppra de Celular");
        this.jmiPerfume.setText("  Compra de Perfume");
        this.jmiRopa.setText("  Compra de Ropa");
        jpmCompras.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jmiEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiEmpleadosActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        this.jmiBitacora.setText("Reporte de Bitacora");
        this.jmiEmpleados.setText("Repote de Empleados");
        this.jmiProductos.setText("Reporte de Productos");
        this.jmiVentas.setText("Reporte de Ventas");
        jpmReportes.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel11MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Menu m = new Menu();
                m.setVisible(true);
                m.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.PanelImageReflect Logo2;
    private javax.swing.JPopupMenu Menu_Inicio;
    private javax.swing.JPopupMenu Productos;
    private javax.swing.JMenuItem R_Calzado;
    private javax.swing.JMenuItem R_Celulares;
    private javax.swing.JMenuItem R_Perfume;
    private javax.swing.JMenuItem R_Ropa;
    private javax.swing.JMenuItem Submenu1;
    private javax.swing.JMenuItem Submenu2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel6;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private jcMousePanel.jcMousePanel jcMousePanel2;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private jcMousePanel.jcMousePanel jcMousePanel4;
    private jcMousePanel.jcMousePanel jcMousePanel5;
    private javax.swing.JMenuItem jmiBitacora;
    private javax.swing.JMenuItem jmiCalzado;
    private javax.swing.JMenuItem jmiCelular;
    private javax.swing.JMenuItem jmiEmpleados;
    private javax.swing.JMenuItem jmiPerfume;
    private javax.swing.JMenuItem jmiProductos;
    private javax.swing.JMenuItem jmiRopa;
    private javax.swing.JMenuItem jmiVentas;
    private javax.swing.JPanel jp;
    private javax.swing.JPopupMenu jpmCompras;
    private javax.swing.JPopupMenu jpmReportes;
    private javax.swing.JPanel mi_panel_menu;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private jcMousePanel.jcMousePanel panel3;
    private org.edisoncor.gui.panel.Panel panel4;
    // End of variables declaration//GEN-END:variables
}
