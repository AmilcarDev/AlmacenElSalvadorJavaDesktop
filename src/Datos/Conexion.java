/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amilcar Cortez
 */
public class Conexion implements Serializable{
    
    public Connection con=null;
    public Statement st;
    public ResultSet rs;
    
    public Conexion(){
            
        con=Conexion.realizaconexion();
    }
  
    //metodo get generado
    public Connection getCon() {
        return con;
    }
    
    
    public static Connection realizaconexion(){
        Connection c=null;
        try {
             Class.forName("com.mysql.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql://localhost/bdalmacen", "root", "");
             System.out.println("conectado correctamente");
        } catch (SQLException e) {
            System.out.println("error"+e);
        }catch(ClassNotFoundException ex){
            System.out.println("error 2"+ ex);
        }
        return c;
    }
    
     Statement st1;
    ResultSet rs1;
    
    public String traerempleado(int idusuario){
   
    
    try{        
 
    String sql ="SELECT * FROM usuarios WHERE idusuario='" + idusuario + "'";
            st1 = con.createStatement();
            rs1 = st1.executeQuery(sql);
                        
            while(rs1.next()){
                
               
             if(rs1.getInt(1)==idusuario){
                 
             return rs1.getString(2);
             
             }
            }
              
 
   }catch (SQLException e) {
            
        System.out.println("catch");
               
        }
       return null;
}
   
    
    
    
    public boolean ejecutarSQL(PreparedStatement sentencia){
    
        try {
            sentencia.execute();
            sentencia.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error al ejecuatar");
            return false;
        }
    }
    
    public ResultSet ejecutarSQLSelect(String sql){
        ResultSet resultado;
        try {
            PreparedStatement sentencia=con.prepareStatement(sql);
            resultado=sentencia.executeQuery();
            return resultado;
        } catch (SQLException e) {
            System.out.println("error al ejecutar consulta: "+e);
            return null;
        }
    }
    
}
