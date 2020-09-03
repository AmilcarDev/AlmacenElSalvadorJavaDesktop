/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Baltazar
 */
public class Funcion {
    SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");

    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }
     public java.util.Date StringADate(String fecha) {
        SimpleDateFormat formato_del_texto = new SimpleDateFormat("dd-MM-yyyy");
        Date FechaE = null;

        try {
            FechaE = (Date) formato_del_texto.parse(fecha);
            return FechaE;
        } catch (Exception e) {
            return null;
        }

    }
}
