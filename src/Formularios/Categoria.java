package Formularios;

import Clases.MostrarReportes;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Baltazar
 */
public class Categoria extends javax.swing.JFrame {

    MostrarReportes a = new MostrarReportes();
    int cont = 0;

    public Categoria() {
        initComponents();

    }

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
        jLabel22 = new javax.swing.JLabel();
        comboBoxRound2 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        TFRI_Titulo = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel23 = new javax.swing.JLabel();
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
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(300, 50));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adminisción de Categoria");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        getContentPane().add(panelRectTranslucido1, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(220, 115));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setText("Nombre");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        comboBoxRound2.setAnchoDeBorde(2.0F);
        comboBoxRound2.setColorDeBorde(new java.awt.Color(173, 173, 173));
        comboBoxRound2.setFocusable(false);
        comboBoxRound2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jPanel6.add(comboBoxRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 100, -1));

        TFRI_Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRI_TituloActionPerformed(evt);
            }
        });
        jPanel6.add(TFRI_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 100, -1));

        jLabel23.setText("Departamento");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFRI_TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRI_TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFRI_TituloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        a.producto();
        try {
//            //        a.ejecutarReporte();
//            JasperReport a=(JasperReport) JRLoader.loadObject(Categoria.class.getResource("/Reportes/Reporte1.jasper"));
//            Map parametros=new HashMap<String,Object>();
//            parametros.put("titulo",TFRI_Titulo.getText());
//            JasperPrint  jp= JasperFillManager.fillReport(a,parametros, new JREmptyDataSource());
//            JasperViewer jv=new JasperViewer(jp);
//            jv.show();
            
        } catch (Exception ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        JFrame.setDefaultLookAndFeelDecorated(false);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.textField.TextFieldRoundImage TFRI_Titulo;
    private org.edisoncor.gui.comboBox.ComboBoxRound comboBoxRound2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables
}
