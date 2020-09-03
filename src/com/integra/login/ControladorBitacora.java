/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integra.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SICDABI
 */
public class ControladorBitacora {

    private String descripcion;
    private String fecha;
    private String idUsuario;    
    private Statement st;
    private ResultSet rs;
    private conectar conexion;
    public ControladorBitacora() {
        conexion=new conectar();
    }
    
    
    
    public void insertarAccion(String idUsuario, String descripcion) {
        try {
            conexion.abrirConexion();
            st = conexion.con.createStatement();
            st.executeUpdate(
                    "INSERT INTO bitacora (usuario,descripcion) values ( '" + idUsuario + "', '" + descripcion + "')"); 
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void borrarBitacora(Connection con) {
        try {
            st = con.createStatement();
            st.executeUpdate("delete from bitacora");            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarUsuario(DefaultTableModel modelo,String idUsuario) {
        try {
            conexion.abrirConexion();
            st = conexion.con.createStatement();
            rs = st.executeQuery("select * FROM bitacora where usuario like '" + idUsuario + "%' order by fecha");
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getTimestamp("fecha"),rs.getString("descripcion"),rs.getString("usuario")});
            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostarTodos(DefaultTableModel modelo) {
        try {
            conexion.abrirConexion();
            st = conexion.con.createStatement();
            rs = st.executeQuery("select * FROM bitacora order by fecha ");
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getTimestamp("fecha"),rs.getString("descripcion"),rs.getString("usuario")});
            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarUsuarioFec(DefaultTableModel modelo,String fecha) {
        try {
            conexion.abrirConexion();
            st = conexion.con.createStatement();
            rs = st.executeQuery("select * FROM bitacora where fecha like '" + fecha + "%' order by fecha");
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getTimestamp("fecha"),rs.getString("descripcion"),rs.getString("usuario")});
            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarIdUsuarioFec(DefaultTableModel modelo, String fecha, String idUsuario) {
        try {
            System.out.println(idUsuario+"--"+fecha);
            conexion.abrirConexion();
            st = conexion.con.createStatement();
            rs = st.executeQuery("select * FROM bitacora where usuario like '" + idUsuario + "%' and fecha like '" + fecha + "%' order by fecha");
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getTimestamp("fecha"),rs.getString("descripcion"),rs.getString("usuario")});
            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
