/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integra.login.recovery;

import Clases.Utilidades;
import Control.msm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.Conexion;
import com.integra.users.ControladorAdministrarUsuario;

/**
 *
 * @author defaultuser0
 */
public class ControladorRecuperacionPass {

    private final Conexion conexion;
    private Utilidades utils;
    private ResultSet rs;
    private Statement st;
    private ModeloCorreo mc;
    private ControladorAdministrarUsuario cau;
    private String tokenTemp;
    private String respuesta;

    public ControladorRecuperacionPass() {
        conexion = new Conexion();
        mc = new ModeloCorreo();
        utils = new Utilidades();
        cau = new ControladorAdministrarUsuario();
        
    }

    //RECUPERACION POR MEDIO DE ENVIO DE CORREO
    private String generarToken(String user, String email) {
        String TOKEN = "";
        try {
            TOKEN = MD5.encrypt(user + email + utils.getTimesTamp());
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return TOKEN;
    }

    public String getUserEmail(String user) {
        String email = "";
        try {
            conexion.abrirConexion();
            conexion.st = conexion.con.createStatement();
            conexion.rs = conexion.st.executeQuery("select correo as email from usuario where Nombre= '" + user + "'");
            conexion.rs.next();
            email = conexion.rs.getString("email");
            conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("getUserEmail: " + ex.getMessage());
        }
        return email;
    }

    public boolean recoveryFromEmail(String user) throws Exception{
        boolean isDone = false;
        try {
            String email = getUserEmail(user);
            String token = generarToken(user, email);
            int userID = cau.getUserId(user);
            tokenTemp = token;
            if (!isExistRecoveryPassToken(userID)) {
                insertToken(userID, token);
                mc.correoPIN(email, token);
                msm.ms_informacion("Se ha enviado un codigo a su cuenta de correo"
                        + "\n Si no aparece en su bandeja de entrada. Revise en su bandeja de correo no deseado");
            }
            else {
                throw new Exception("Ya existe un codigo de recuperacion\n de contraseña para su cuenta");
            }
            isDone = true;
        } catch (Exception e) {
            System.out.println("recoveryFromEmail: " + e.getMessage());
        }
        return isDone;
    }
    
    public void resetPassEmail(String user){
        try {
            int userID = cau.getUserId(user);
            deletToken(userID);
        } catch (Exception e) {
            System.out.println("error");
        }
    } 
    

    private void insertToken(int userID, String Token) {
        try {
            conexion.abrirConexion();
            PreparedStatement pstm = conexion.con.prepareStatement("insert into pass_recovery(token,time,Id_Usuario)values(?,?,?)");
            pstm.setString(1, Token);
            pstm.setTimestamp(2, utils.getTimesTamp());
            pstm.setInt(3, userID);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("insertToken: " + e.getMessage());
        }
    }
    
    public void deletToken(int userID){
        try {
            conexion.abrirConexion();
            PreparedStatement pstm = conexion.con.prepareStatement("delete from pass_recovery where Id_Usuario=?");            
            pstm.setInt(1, userID);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deletToken: " + e.getMessage());
        }
    }

    public boolean isExistRecoveryPassToken(int userID) {
        int id = 0;
        try {
            String sql = "select count(*) as id from pass_recovery where Id_Usuario='" + userID + "'";
            conexion.abrirConexion();
            conexion.st = conexion.con.createStatement();
            conexion.rs = conexion.st.executeQuery(sql);
            conexion.rs.next();
            id = conexion.rs.getInt("id");
            conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("isExistRecoveryPassToken: " + ex.getMessage());
        }
        System.out.println("last: " + id);
        return id == 1;
    }

    public String getTokenUserPassRecovery(String tokenUser) {
        String token = "";
        try {
            String sql = "select token from pass_recovery where token='" + tokenUser + "'";
            conexion.abrirConexion();
            conexion.st = conexion.con.createStatement();
            conexion.rs = conexion.st.executeQuery(sql);
            conexion.rs.next();
            token = conexion.rs.getString("token");
            conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("getTokenUserPassRecovery: " + ex.getMessage());
        }
        return token;
    }

    public boolean compareTokenUserDB(String tokenUser) {
        return tokenUser.equals(getTokenUserPassRecovery(tokenUser));
    }

    //RECUPERACION POR MEDIO DE PREGUNTA DE SEGURIDAD    
    public String getSecurityQuestion(int userID) {
        String pregunta = "";
        try {
            String sql = "select preguntas.pregunta, usuario.respuesta from usuario,preguntas where preguntas.idpreguntas=usuario.preguntas_idpreguntas and usuario.idusuario='" + userID + "'";
            conexion.abrirConexion();
            conexion.st = conexion.con.createStatement();
            conexion.rs = conexion.st.executeQuery(sql);
            conexion.rs.next();
            pregunta = conexion.rs.getString("pregunta");
            respuesta = conexion.rs.getString("respuesta");
            conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("getSecurityQuestion: " + ex.getMessage());
        }
        return pregunta;
    }

    public boolean compareAnswer(String answerUser) {
        return respuesta.equals(answerUser);
    }

    public void resetPasswordUser(String newPassword, String user) {
        try {
            conexion.abrirConexion();
            st = conexion.con.createStatement();
            st.executeUpdate("update usuario set Password='" + newPassword + "' where Nombre='" + user + "'");
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    public static void main(String[] args) {
//        ControladorRecuperacionPass crp=new ControladorRecuperacionPass();
//        System.out.println(crp.generarToken("alex", "alex@hh.com"));
//    }
}
