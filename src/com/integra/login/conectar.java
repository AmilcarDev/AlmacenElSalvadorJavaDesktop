
package com.integra.login;

import java.sql.*;

public class conectar {
    public Statement st;
    public ResultSet rs;
    public Connection con;
    
    
 public void abrirConexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection)
                    //DriverManager.getConnection("jdbc:mysql://192.168.0.102:3306/sicdabi2", "admin", "admin");
                    DriverManager.getConnection("jdbc:mysql://localhost/bdalmacen","root","");
            System.out.printf("Conexion a la BD\n");
            
           }catch(ClassNotFoundException | SQLException e){
               System.out.printf("Error en Conexion\n");
            
        }
    }
    
    /////////////////////////creacion del metodo cerrar conexion
    
    public void cerrarConexion(){
        
    
        try{
            con.close();
            System.out.printf("Conexion Cerrada");
         
        }catch(SQLException e){
            System.out.printf("Error al cerrar la Conexion");
        }
    }
}