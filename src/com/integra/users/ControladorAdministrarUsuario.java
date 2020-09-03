/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integra.users;

import com.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amilcar cortez
 */
public class ControladorAdministrarUsuario {

    private Conexion connect;
    private Statement st;
    private ResultSet rs;

    public ControladorAdministrarUsuario() {
        connect = new Conexion();
    }

    public void darAlta(String usuario) {
        try {
            connect.abrirConexion();
            st = connect.con.createStatement();
            st.executeUpdate("update usuario set estado=1 where Nombre='" + usuario + "'");
            connect.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void darBaja(String usuario) {
        try {
            connect.abrirConexion();
            st = connect.con.createStatement();
            st.executeUpdate("update  usuario set estado=0 where Nombre='" + usuario + "'");
            connect.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarListadoUsuarios(DefaultTableModel modelo) {
        try {
            connect.abrirConexion();
            st = connect.con.createStatement();
            rs = st.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("Nombre"),
                    (rs.getBoolean("estado")) ? "Activo" : "Inactivo"});
            }
            connect.cerrarConexion();
        } catch (Exception e) {
        }
    }

    public int getUserId(String usuario) {
        int id = 0;
        try {
            String sql = "select Id_Usuario as id from usuario where Nombre='" + usuario + "'";
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery(sql);
            connect.rs.next();
            id = connect.rs.getInt("id");
            connect.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("getLastID: " + ex.getMessage());
        }
        System.out.println("last: " + id);
        return id;
    }

    public boolean isEmpleadoUsedUser(int id) {
        int i = 0;
        try {
            String sql = "select count(*) as id from usuario where Empleados_Id_Empleados='" + id + "'";
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery(sql);
            connect.rs.next();
            i = connect.rs.getInt("id");
            connect.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("isEmpleadoUsedUser: " + ex.getMessage());
        }
        return !(i == 0);
    }

    public void buscarUsuario(DefaultTableModel model, String busqueda) {
        try {
            connect.abrirConexion();
            st = connect.con.createStatement();
            rs = st.executeQuery("SELECT Nombre,Estado,nombres FROM usuarios,usuario where usuarios.idusuario=usuario.Empleados_Id_Empleados and nombres LIKE '" + busqueda + "%'");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("nombres"), rs.getString("Nombre"),
                    (rs.getBoolean("Estado")) ? "Activo" : "Inactivo"});
            }
            connect.cerrarConexion();
        } catch (Exception e) {
            System.out.println("buscarUsuario:"+e.getMessage());
        }
    }

    public ModeloUsuario getDatosUsuario(int user) {
        ModeloUsuario mu = new ModeloUsuario();
        try {
            connect.abrirConexion();
            st = connect.con.createStatement();
            rs = st.executeQuery("SELECT * FROM usuario where Id_Usuario=" + user);
            rs.next();
            mu.setNombreUsuario(rs.getString("Nombre"));
            mu.setEmail(rs.getString("Correo"));
            mu.setIdEmpleado(rs.getInt("Empleados_Id_Empleados"));
            mu.setPassword(rs.getString("Password"));
            connect.cerrarConexion();
        } catch (Exception e) {
            System.out.println("getDatosUsuario:"+e.getMessage());
        }
        return mu;
    }

    public ModeloPrivilegios getPrivilegios(int id) {
        ModeloPrivilegios mp = new ModeloPrivilegios();
        try {
            connect.abrirConexion();
            st = connect.con.createStatement();
            rs = st.executeQuery("SELECT * FROM privilegios where Usuario_Id_Usuario=" + id);
            rs.next();
            mp.setREGISTRO_PROVEEDORES(rs.getBoolean("reg_prov"));
            mp.setREGISTRO_EMPLEADOS(rs.getBoolean("reg_emp"));
            mp.setREGISTRO_PRODUCTO(rs.getBoolean("reg_prod"));
            mp.setREGISTRO_COMPRAS(rs.getBoolean("reg_compras"));
            mp.setREGISTRO_VENTAS(rs.getBoolean("reg_ventas"));
            mp.setGENERAR_REPORTES(rs.getBoolean("gen_report"));
            mp.setCONSULTAR_INVENTARIO(rs.getBoolean("con_inv"));
            
            connect.cerrarConexion();
        } catch (Exception e) {
            System.out.println("getPrivilegios: "+e.getMessage());
        }
        return mp;
    }
    
    private void updateUsuario(ModeloUsuario usuario, int id) {
        try {
            connect.abrirConexion();
            PreparedStatement pstm = connect.con.prepareStatement("update usuario SET  Nombre =?,Password =?,Estado =?,Correo =? WHERE Id_Usuario =?");
            pstm.setString(1, usuario.getNombreUsuario());
            pstm.setString(2, usuario.getPassword());
            pstm.setBoolean(3, true);
            pstm.setString(4, usuario.getEmail());
            pstm.setInt(5, usuario.getIdEmpleado());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateUsuario: "+e.getMessage());
        }
    }

    private void updatePrivilegios(int Id_Usuario,ModeloPrivilegios privilegios){
        try {
            connect.abrirConexion();
            PreparedStatement pstm = connect.con.prepareStatement("update privilegios SET reg_prov =?, reg_emp =?, reg_prod =?, reg_compras =?, reg_ventas =?, gen_report =?, con_inv =? WHERE Usuario_Id_Usuario =?");
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
     public void modificar(ModeloNuevoUsuario mnu,int id){
         System.out.println(mnu.toString());
         updateUsuario(mnu.getMsu(),id);
         updatePrivilegios(id, mnu.getPrivilegios());
     }
     
     public boolean countEmpleado() {
        int i = 0;
        try {
            String sql = "select count(*) as id from usuarios ";
            connect.abrirConexion();
            connect.st = connect.con.createStatement();
            connect.rs = connect.st.executeQuery(sql);
            connect.rs.next();
            i = connect.rs.getInt("id");
            connect.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("isEmpleadoUsedUser: " + ex.getMessage());
        }
        return (i == 0);
    }
}
