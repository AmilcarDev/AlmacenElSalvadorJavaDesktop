/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SIAGRO
 */
public class Calendario {

    SimpleDateFormat sdfbd;

    public Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    public int Dia_Mes() {//Retorna el dia del mes en curso
        Calendar calendar = Calendar.getInstance();
        return calendar.getActualMaximum(calendar.DAY_OF_MONTH);
    }

    public int Fecha_Secciones(Date fecha, int valor) {
        int resultado = 0;
        if (valor == 0) {//Se entendera que es dia
            sdfbd = new SimpleDateFormat("dd");
            resultado = Integer.parseInt(sdfbd.format(fecha));
        }
        if (valor == 1) {//Se entendera que es el mes
            sdfbd = new SimpleDateFormat("MM");
            resultado = Integer.parseInt(sdfbd.format(fecha));
        }
        if (valor == 2) {//Se entendera que es el año
            sdfbd = new SimpleDateFormat("yyyy");
            resultado = Integer.parseInt(sdfbd.format(fecha));
        }
        return resultado;
    }

    public String Fecha(Date fecha) {
        sdfbd = new SimpleDateFormat("dd-MM-yyyy");
        return sdfbd.format(fecha);
    }
    public String Armar_Fecha(int dia,int mes,int año) {
        String resultado="0" + dia + "-0" + mes + "-" + año;
        return resultado;
    }
    
}
