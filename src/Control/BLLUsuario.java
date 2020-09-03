/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.DALUsuario;
import Datos.Usuario;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amilcar Cortez
 */


public class BLLUsuario {
    
    DALUsuario dal=new DALUsuario();
    
     public void mostrarLista(DefaultTableModel model, JTable tabla){
         dal.mostrarLista(model, tabla);
     }
     
     public void insertarDatos(Usuario u){
         
         dal.insertarDatos(u);
         
     }
    public void modificarDatossinFoto(Usuario u){
        
        dal.modificarDatossinFoto(u);
    }
    
    public void modificarDatosconFoto(Usuario u){
        dal.modificarDatosconFoto(u);
    }
    
    public void buscarLista(DefaultTableModel model, JTable tabla, String dato){
        dal.buscarLista(model, tabla, dato);
    }
    
    public Object[] consultarporID(int id, JLabel lblfoto){
    
            return dal.consultarporID(id, lblfoto);
    }
    
    public void eliminarUsuario(Usuario u){
        dal.eliminarUsuario(u);
    }
    
    public void mostrarListaestadocero(DefaultTableModel model, JTable tabla){
        dal.mostrarListaestadocero(model, tabla);
    }
    
     public void buscarListaestadocero(DefaultTableModel model, JTable tabla, String dato){
         dal.buscarListaestadocero(model, tabla, dato);
         
     }
     
     public void dardealta(Usuario u){
         dal.dardealta(u);
     }
}
