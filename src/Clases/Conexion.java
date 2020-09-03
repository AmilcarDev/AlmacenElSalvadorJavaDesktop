package Clases;
import java.sql.*;

public class Conexion {
    Connection con;
    Statement st;
    
    public void abrirConexion() {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/bdalmacen";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión a la BD");
        } catch (Exception e) {
            System.out.println("Error en conexión ");
        }
    }
    public void cerrarConexion() {
        try {
            con.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión");
        }
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////
    ////////                                                                   ///////
    ////////                Manejo de Prepared statement                       ///////
    ////////                                                                   ///////
    //////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////
    
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
