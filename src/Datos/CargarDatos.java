/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

//import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amilcar Cortez
 */
public class CargarDatos {
    
    public void cargarTabla(int columnas, ResultSet rs, DefaultTableModel model, JTable tabla){
        
        try {
            Object[] filas=new Object[columnas];
            
            while(rs.next()){
                
                for(int i=0;i<columnas;i++){
                    filas[i]=rs.getObject(i+1);
                }
                model.addRow(filas);
            }
            tabla.updateUI();
            rs.close();
            
        } catch (Exception e) {
            System.out.println("error al cargar tabla: "+e);
        }
        
    }
    
}
