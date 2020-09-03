/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import Datos.Usuario;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author defaultuser0
 */
public class Conexion {

    public Connection con;
    public Statement st;
    public ResultSet rs;
    String userName = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/";
    String urlDriver = "com.mysql.jdbc.Driver";
    


    public void abrirConexion() throws SQLException {
        try {
            Class.forName(urlDriver).newInstance();
            con = DriverManager.getConnection(url + "bdalmacen", userName, password);
            System.out.println("ConexiÃ³n a la BD");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println("Error en conexion ");
            System.out.println(e.getMessage());
        }
    }

        public void dropBD() {
        //abrirConexion();
        try {
            con = DriverManager.getConnection(url, userName, password);
            st = con.createStatement();
            st.executeUpdate("DROP DATABASE " + "bdalmacen");
            System.out.println("La base de datos ha sido eliminada");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createBD() {
        try {
            //abrirConexion();
            con = DriverManager.getConnection(url, userName, password);
            st = con.createStatement();
            st.executeUpdate("CREATE SCHEMA IF NOT EXISTS " + "bdalmacen" + " DEFAULT CHARACTER SET utf8");
            System.out.println("La base de datos ha sido creada");
        } catch (SQLException ex) {
            System.out.println("Errror al crear la base de datos");
        }
    }
    
    public void cerrarConexion() {
        try {
            con.close();
            System.out.println("ConexiÃ³n cerrada");
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexiÃ³n");
        }
    }

    public void loadEmpleados(org.edisoncor.gui.comboBox.ComboBoxRound comboBoxRound1) {
        try {
            abrirConexion();
            PreparedStatement pstm = con.prepareStatement("select idusuario,nombres from usuarios");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                comboBoxRound1.addItem(rs.getInt("idusuario") + " - " + rs.getString("nombres"));
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion: " + e.getMessage());
        }
    }

    public void initAdmin() {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("insert into usuarios(idusuario,dni,nombres,apellidos,correo,telefono,usuario,clave,fecha,foto) values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,1);
            ps.setString(2, "");
            ps.setString(3, "Admin");
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setString(6, "");
            ps.setString(7, "");
            ps.setFloat(8, 0.0f);
            ps.setDate(9, new java.sql.Date(new Date().getTime()));
            ps.setBinaryStream(10, null, 0);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error init: " + e.getMessage());
        }
    }
}
