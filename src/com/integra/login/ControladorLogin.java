/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integra.login;

import com.integra.session.ModeloSession;
import Clases.Utilidades;
import Control.msm;
import java.sql.ResultSet;
import java.sql.SQLException;
import static clases.Validaciones.*;
import com.Conexion;
import clases.Validaciones;
import com.integra.users.ModeloPrivilegios;

/**
 *
 * @author defaultuser0
 */
public class ControladorLogin {

    private Conexion connect;
    private Utilidades utils;

    public ControladorLogin() {
        connect = new Conexion();
        utils = new Utilidades(); 
    }

    public ModeloSession doLogin(String user, String pass) {
        ModeloSession mss = null;
        String userBD, passDB;        
        try {
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery("select * from usuario where Nombre='" + user + "'");
            connect.rs.next();
            userBD = connect.rs.getString("Nombre");
            verificarUser(user, userBD);
            passDB = connect.rs.getString("Password");
            verificarPass(pass, passDB);
            mss = new ModeloSession(connect.rs.getString("Id_Usuario"),user,
                     true,
                    getNivelAcceso(connect.rs.getInt("Id_Usuario")));
            connect.cerrarConexion();
        } catch (SQLException | Validaciones ex) {
            mss = new ModeloSession();
             msm.ms_error(ex.getMessage());
        } catch (Exception ex) {
            mss = new ModeloSession();
            System.out.println("doLogin: "+ex.getMessage());
        }
        return mss;
    }
    
    public ModeloPrivilegios getNivelAcceso(int userId) {
        ModeloPrivilegios nivelAcceso = new ModeloPrivilegios();
        try {
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery("select * from privilegios where Usuario_Id_Usuario='" + userId + "'");
            connect.rs.next();
            nivelAcceso.setREGISTRO_PROVEEDORES(connect.rs.getBoolean("reg_prov"));
            nivelAcceso.setREGISTRO_EMPLEADOS(connect.rs.getBoolean("reg_emp"));
            nivelAcceso.setREGISTRO_PRODUCTO(connect.rs.getBoolean("reg_prod"));
            nivelAcceso.setREGISTRO_COMPRAS(connect.rs.getBoolean("reg_compras"));
            nivelAcceso.setREGISTRO_VENTAS(connect.rs.getBoolean("reg_ventas"));
            nivelAcceso.setGENERAR_REPORTES(connect.rs.getBoolean("gen_report"));
            nivelAcceso.setCONSULTAR_INVENTARIO(connect.rs.getBoolean("con_inv"));
            connect.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nivelAcceso;
    }

    public boolean isUserActived(String username) {
        boolean estado = false;
        try {
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery("select * from usuario where Nombre='" + username + "'");
            connect.rs.next();
            estado = connect.rs.getBoolean("estado");
            //connect.cerrarConexion();
        } catch (Exception e) {
        }
        return estado;
    }
}
