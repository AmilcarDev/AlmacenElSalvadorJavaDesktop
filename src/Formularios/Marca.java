
package Formularios;

import java.awt.Color;



/**
 *
 * @author Baltazar
 */
public class Marca extends javax.swing.JFrame {

    int cont=0;
    public Marca() {
        initComponents();
        
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
        jLabel22 = new javax.swing.JLabel();
        comboBoxRound2 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        textFieldRoundImage1 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel23 = new javax.swing.JLabel();

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
        jLabel2.setText("Adminisción de Marca");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

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

        textFieldRoundImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRoundImage1ActionPerformed(evt);
            }
        });
        jPanel6.add(textFieldRoundImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 100, -1));

        jLabel23.setText("Departamento");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldRoundImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRoundImage1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRoundImage1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        JFrame.setDefaultLookAndFeelDecorated(false);
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Marca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.comboBox.ComboBoxRound comboBoxRound2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    private org.edisoncor.gui.textField.TextFieldRoundImage textFieldRoundImage1;
    // End of variables declaration//GEN-END:variables
}
