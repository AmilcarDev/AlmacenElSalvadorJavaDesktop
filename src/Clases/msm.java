/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author SIAGRO
 */
public class msm {

    public static void ms_alerta(String msm) {
    
        JOptionPane.showMessageDialog(null, msm,"INTEGRA",1,new ImageIcon("alerta.png"));
    }

    public static void ms_error(String msm){
       JOptionPane.showMessageDialog(null, msm,"INTEGRA",1,new ImageIcon("error.png"));       
    }
    public static void ms_informacion(String msm){
        JOptionPane.showMessageDialog(null, msm,"INTEGRA",1,new ImageIcon("info28.png"));
        
    }
    public static void ms_exito(String msm){
        JOptionPane.showMessageDialog(null, msm,"INTEGRA",1,new ImageIcon("exitoso.png"));
        
    }
    public static int ms_pregunta(String msm){
        int n=JOptionPane.showConfirmDialog(
        null,
        msm,
        "INTEGRA",
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);        
        return n;
    }
}

