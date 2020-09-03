package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
public class MostrarReportes {
    Connection conn = null;

    public void MuestraReporte() {
        
    }

    
     public void ejecutarReporte() {
         
         conectar();

         try {
            String archivo = "report1.jasper";
            System.out.println("Cargando desde: " + archivo);
            if (archivo == null) {
                System.out.println("No se encuentra el archivo.");
                System.exit(2);
            }
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(MostrarReportes.class.getResource("/Reportes/"+archivo) );
            } catch (Exception e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(2);
            }
             
//Se lanza el Viewer de Jasper, no termina aplicacionn al salir
           
             JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, conn);
             
//Se lanza el Viewer de Jasper, no termina aplicacionn al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Prueba de Reporte");
            jviewer.setVisible(true);
             } catch (Exception e) {
            System.out.println("Mensaje de Error:" + e.getMessage());
        }
     }
//////////////////////////////////////////////////////////////
     
     
      public void producto() {
         
         conectar();

         try {
            String archivo = "report1.jasper";
            if (archivo == null) {
                System.out.println("No se encuentra el archivo.");
                System.exit(2);
            }
            JasperReport masterReport = null;
            try {
                
                masterReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/"+archivo));
                
            System.out.println("Cargando desde: " + archivo);
            } catch (Exception e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(2);
            }
             
//Se lanza el Viewer de Jasper, no termina aplicacionn al salir
           
             JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, conn);
             
//Se lanza el Viewer de Jasper, no termina aplicacionn al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Prueba de Reporte");
            jviewer.setVisible(true);
             } catch (Exception e) {
            System.out.println("Mensaje de Error:" + e.getMessage());
        }
     }
     
     // AREPORTE DE EMPLEADO
       public void empleados() {
         
         conectar();

         try {
            String archivo = "empleado.jasper";
            System.out.println("Cargando desde: " + archivo);
            if (archivo == null) {
                System.out.println("No se encuentra el archivo.");
                System.exit(2);
            }
            JasperReport masterReport = null;
            try {
//                masterReport = (JasperReport) JRLoader.loadObject(archivo);
            } catch (Exception e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(2);
            }
             
//Se lanza el Viewer de Jasper, no termina aplicacionn al salir
           
             JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, conn);
             
//Se lanza el Viewer de Jasper, no termina aplicacionn al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Prueba de Reporte");
            jviewer.setVisible(true);
             } catch (Exception e) {
            System.out.println("Mensaje de Error:" + e.getMessage());
        }
     }
      
      
      
     
    private void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdalmacen", "root", "root");
            JOptionPane.showMessageDialog(null, "Conexion establecida");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

