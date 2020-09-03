/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integra.users;

import Clases.Utilidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.Conexion;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author defaultuser0
 */
public class ControladorNuevoUsuario {

    private Conexion connect;
    private Utilidades utils;

    public ControladorNuevoUsuario() {
        connect = new Conexion();
        utils=new Utilidades();
    }

    public boolean isUserExists(String user) {
        int cont = 0;
        try {
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery("select count(Nombre) as total from usuario where Nombre like '" + user + "'");
            connect.rs.next();
            cont = connect.rs.getInt("total");
            connect.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cont == 0;
    }

    public int getLastId() {
        int id = 0;
        try {
            String sql="select max(Id_Usuario) as id from usuario";
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery(sql);
            connect.rs.next();
            id = connect.rs.getInt("id");
            connect.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("getLastID: "+ex.getMessage());
        }
        System.out.println("last: "+id);
        return id;
    }

    public void insertarNuevoUsuario(ModeloUsuario usuario) {
        try {
            connect.abrirConexion();
            PreparedStatement pstm = connect.con.prepareStatement("insert into usuario(Nombre,Password,estado,Empleados_Id_Empleados,correo)values(?,?,?,?,?)");
            pstm.setString(1, usuario.getNombreUsuario());
            pstm.setString(2, new Utilidades().Encriptar(usuario.getPassword()));
            pstm.setBoolean(3, true);
            pstm.setInt(4, usuario.getIdEmpleado());
            pstm.setString(5, usuario.getEmail());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("insertarNuevoUsuario: "+e.getMessage());
        }
    }

    public void setPrivilegios(int Id_Usuario,ModeloPrivilegios privilegios){
        try {
            connect.abrirConexion();
            PreparedStatement pstm = connect.con.prepareStatement("insert into privilegios(reg_prov,reg_emp,reg_prod,reg_compras,reg_ventas,gen_report,con_inv,Usuario_Id_Usuario) values(?,?,?,?,?,?,?,?)");
            pstm.setBoolean(1, privilegios.isREGISTRO_PROVEEDORES());
            pstm.setBoolean(2, privilegios.isREGISTRO_EMPLEADOS());
            pstm.setBoolean(3, privilegios.isREGISTRO_PRODUCTO());
            pstm.setBoolean(4, privilegios.isREGISTRO_COMPRAS());
            pstm.setBoolean(5, privilegios.isREGISTRO_VENTAS());
            pstm.setBoolean(6, privilegios.isGENERAR_REPORTES());
            pstm.setBoolean(7, privilegios.isCONSULTAR_INVENTARIO());
            pstm.setInt(8, Id_Usuario);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("setPrivilegios: "+e.getMessage());
        }
    }
    
    public void getAllEmpleados(org.edisoncor.gui.comboBox.ComboBoxRound comboBoxRound1){
        try {
            connect.abrirConexion();
            PreparedStatement pstm = connect.con.prepareStatement("select idusuario,nombres from usuarios");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                comboBoxRound1.addItem(rs.getInt("idusuario")+" - "+rs.getString("nombres"));
            }
            rs.close();
            connect.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorNuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    public void insertar(ModeloNuevoUsuario mnu) {
        System.out.println(mnu.toString());
        insertarNuevoUsuario(mnu.getMsu());
        setPrivilegios( getLastId(),mnu.getPrivilegios());
    }
}
