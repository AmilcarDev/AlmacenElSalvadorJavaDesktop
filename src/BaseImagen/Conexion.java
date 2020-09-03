
package BaseImagen;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    Object con;
      Statement stm;
    ResultSet rs;
    /////////
     java.sql.Connection con1;
    java.sql.Statement stmt;
    java.sql.ResultSet resultado;
    public Connection conectar(){
        Connection con = null;
       // String url = "jdbc:h2:./BaseDatos/imagenesss";
        try{
             Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.h2.Driver");
             // con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Proveedor3","root","root");  
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BDAlmacen","root","");
           // con = DriverManager.getConnection(url, "root","root");
        
            System.out.println("En linea");
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return con;
    }
    
    public void abrirConeccion(){
        
        try{
            
        Class.forName("com.mysql.jdbc.Driver");
        con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/BDAlmacen","root","");
           stm= con1.createStatement();

        }catch(Exception e){
        
        }
        
    
    }
    
     public void cerrarConeccion(){
        
        try{
         con1.close();
        }catch(Exception e){
        
        }
    }
     
    public ResultSet visualizar(){
        Connection con = conectar();
        ResultSet rs = null;
        try{
            PreparedStatement ps = con.prepareStatement("select * from usuario");
            rs = ps.executeQuery();
        }catch(Exception ex){
            System.out.println("Error de consulta");
        }
        return rs;
    }
 // public void guardar(String ruta, String nombre){
  
    public void guardar(int Codigo, String nombre,String nombre_R, String Apellido1,String Direccion1,String Telefono1, String Celular1,String Estado ,String ruta ){
             String mensaje = "";
        Connection con = conectar();
      String insert = "insert into Proveedor(Id_Proveedor,Nombre_Proveedor,Nombre_Representante,Apellido,Direccion,Telefono_Encargado,Telefono_Empresa,Estado,foto) values(?,?,?,?,?,?,?,?,?)";
   
          //String insert = "insert into Proveedor(Id_Proveedor,Nombre_Proveedor,Nombre_Representante,Apellido,Direccion,Telefono_Encargado,Telefono_Empresa,Estado,foto) values(?,?,?,?,?,?,?,?,?)";
      // String insert = "insert into usuario(nombre,foto) values(?,?)";
        FileInputStream fi = null;
        PreparedStatement ps = null;
        try{
            File file = new File(ruta);
            fi = new FileInputStream(file);
            
            ps = con.prepareStatement(insert);
                ps.setInt(1, Codigo);
            //ps.setString(1, Codigo);
                  ps.setString(2, nombre);
                     ps.setString(3, nombre_R);
                        ps.setString(4, Apellido1);
                           ps.setString(5, Direccion1);
                              ps.setString(6, Celular1 );
            ps.setString(7, Telefono1);
            ps.setString(8, Estado);
              ps.setBinaryStream(9, fi);
            
            ps.executeUpdate();
       
              
                msm.ms_exito("Registo guardado con exito:\n\n" );
        }catch(Exception ex){
         
            
              
                msm.ms_alerta("Error al  guardado registo:\n\n" );
           // System.out.println("Error al Guardar los datos :("+ex.getMessage());
        }
    }
public void Modificar( String nombre,String nombre_R, String Apellido1,String Direccion1,String Telefono1, String Celular1,String Estado,String ruta ){
      String mensaje = "";   
    Connection con = conectar();
     //String Ssql = "UPDATE contacto SET nombres=?, apellidos=?, email=?, celular=?, direccion=?, ciudad=? "
                   // + "WHERE id_contacto=?";
          String insert = "UPDATE proveedor p SET Nombre_Proveedor=?,Nombre_Representante=?,Apellido=?,Direccion=?,Telefono_Encargado=?,Telefono_Empresa=?,Estado=?,foto=? WHERE Nombre_Proveedor='"+nombre+"'";///values(?,?,?,?,?,?,?,?)
      // String insert = "insert into usuario(nombre,foto) values(?,?)";
        FileInputStream fi = null;
        PreparedStatement ps = null;
        try{
            File file = new File(ruta);
            fi = new FileInputStream(file);
            
            ps = con.prepareStatement(insert);
                    // ps.setString(1, Codigo);
                  ps.setString(1, nombre);
                     ps.setString(2, nombre_R);
                        ps.setString(3, Apellido1);
                           ps.setString(4, Direccion1);
                              ps.setString(5, Telefono1);
            ps.setString(6, Celular1);
             ps.setString(7, Estado);
              
            ps.setBinaryStream(8, fi);
            
            ps.executeUpdate();
    
              
                msm.ms_exito("Registro modificado con éxito:\n\n" );
        }catch(Exception ex){
            
              
                msm.ms_alerta("Erro al modificar registro:\n\n" );
          //  System.out.println("Error al Modificar los datos :("+ex.getMessage());
        }
    }
public void Modificar2( String nombre,String nombre_R, String Apellido1,String Direccion1,String Telefono1, String Celular1,String Estado ){
        String mensaje = ""; 
    Connection con = conectar();
     //String Ssql = "UPDATE contacto SET nombres=?, apellidos=?, email=?, celular=?, direccion=?, ciudad=? "
                   // + "WHERE id_contacto=?";
          String insert = "UPDATE proveedor p SET Nombre_Proveedor=?,Nombre_Representante=?,Apellido=?,Direccion=?,Telefono_Encargado=?,Telefono_Empresa=?,Estado=? WHERE Nombre_Proveedor='"+nombre+"'";///values(?,?,?,?,?,?,?,?)
      // String insert = "insert into usuario(nombre,foto) values(?,?)";
      //  FileInputStream fi = null;
        PreparedStatement ps = null;
        try{
            //File file = new File(ruta);
            //fi = new FileInputStream(file);
            
            ps = con.prepareStatement(insert);
                    // ps.setString(1, Codigo);
                  ps.setString(1, nombre);
                     ps.setString(2, nombre_R);
                        ps.setString(3, Apellido1);
                           ps.setString(4, Direccion1);
                              ps.setString(5, Telefono1);
            ps.setString(6, Celular1);
             ps.setString(7, Estado);
              
          //  ps.setBinaryStream(8, fi);
            
            ps.executeUpdate();
          
              
                msm.ms_exito("Registo modificado con exito:\n\n" );
        }catch(Exception ex){
            //System.out.println("Error al Modificar los datos :("+ex.getMessage());
         
              
                msm.ms_alerta("Erro al modificar registro:\n\n");
        }
    }
    void guardar(String ruta, String Codigo, String nombre2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void visualizar_tabla(String Codigo, String Apellido1, String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void visualizar_tabla(String sql3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void Modificar(String nombre2, String nombre_R, String Apellido1, String Direccion1, String Telefono1, String Celular1, String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   

    
    
}
