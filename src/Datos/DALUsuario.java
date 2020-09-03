/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Control.msm;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Formularios.Menu1;

/**
 *
 * @author Amilcar Cortez
 */
public class DALUsuario {
    
    Conexion con= Menu1.hc;
    CargarDatos c=new CargarDatos();
    //otra clase conectar
   // private conectar conexion;
    
    
     public boolean duiexiste(String dni) {
        int cont = 0;
        try {
            con.getCon();
            con.st = con.con.createStatement();
            con.rs = con.st.executeQuery("select count(dni) as total from usuarios where dni like '" + dni + "%'");
            con.rs.next();
            cont = con.rs.getInt("total");
        } catch (SQLException ex) {
            System.out.println("el dui ya existe: "+ex.getMessage());
        }
        return cont == 0;
    }
     
    public boolean nitexiste(String nit) {
        int cont = 0;
        try {
            con.getCon();
            con.st = con.con.createStatement();
            con.rs = con.st.executeQuery("select count(correo) as total from usuarios where correo like '" + nit + "%'");
            con.rs.next();
            cont = con.rs.getInt("total");
        } catch (SQLException ex) {
            System.out.println("el nit ya existe: "+ex.getMessage());
        }
        return cont == 0;
    }
    
    public boolean telefonoexiste(String telefono) {
        int cont = 0;
        try {
            con.getCon();
            con.st = con.con.createStatement();
            con.rs = con.st.executeQuery("select count(telefono) as total from usuarios where telefono like '" + telefono + "%'");
            con.rs.next();
            cont = con.rs.getInt("total");
        } catch (SQLException ex) {
            System.out.println("el telefono ya existe: "+ex.getMessage());
        }
        return cont == 0;
    }
    
    
    public void mostrarLista(DefaultTableModel model, JTable tabla){
        
        try {
//            String sql="select idusuario,dni,nombres,apellidos,correo,telefono from usuarios where estado=1 order by nombres asc";
             String sql="select idusuario,dni,nombres,apellidos,correo,telefono from usuarios order by nombres asc";
            ResultSet rs=con.ejecutarSQLSelect(sql);
            c.cargarTabla(6, rs, model, tabla);
        } catch (Exception e) {
            System.out.println("error al cargar tabla dal mostrarlista "+e);
        }
    }
    
    public void buscarLista(DefaultTableModel model, JTable tabla, String dato){
        
        try {
//            String sql="select idusuario,dni,nombres,apellidos,correo,telefono from usuarios where estado=1 and nombres like '%"+dato+"%' order by nombres asc";
            String sql="select idusuario,dni,nombres,apellidos,correo,telefono from usuarios where nombres like '%"+dato+"%' order by nombres asc";
            ResultSet rs=con.ejecutarSQLSelect(sql);
            c.cargarTabla(6, rs, model, tabla);
        } catch (Exception e) {
            System.out.println("error al cargar tabla dal "+e);
        }
    }
    
    //para dar de alta
    
     public void mostrarListaestadocero(DefaultTableModel model, JTable tabla){
        
        try {
            String sql="select idusuario,dni,nombres,apellidos,correo,telefono from usuarios where estado=0";
            ResultSet rs=con.ejecutarSQLSelect(sql);
            c.cargarTabla(6, rs, model, tabla);
        } catch (Exception e) {
            System.out.println("error al cargar tabla dal "+e);
        }
    }
    
    public void buscarListaestadocero(DefaultTableModel model, JTable tabla, String dato){
        
        try {
            String sql="select idusuario,dni,nombres,apellidos,correo,telefono from usuarios where estado=0 and nombres like '%"+dato+"%' order by nombres asc";
            ResultSet rs=con.ejecutarSQLSelect(sql);
            c.cargarTabla(6, rs, model, tabla);
        } catch (Exception e) {
            System.out.println("error al cargar tabla dal "+e);
        }
    }
    //para dar de alta

    
    public void insertarDatos(Usuario u){
    
        try {
           
            String sql="insert into usuarios(dni,nombres,apellidos,correo,telefono,usuario,clave,fecha,foto) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.con.prepareStatement(sql);
            ps.setString(1,u.getDni());
            ps.setString(2,u.getNombres());
            ps.setString(3,u.getApellidos());
            ps.setString(4,u.getCorreo());
            ps.setString(5,u.getTelefono());
            ps.setString(6,u.getUsuario());
            ps.setFloat(7,u.getClave());
            ps.setDate(8, (Date) u.getFecha());
            ps.setBinaryStream(9,u.getFis(),u.getLongitudBytes());
            boolean ejecucion=con.ejecutarSQL(ps);
            if (ejecucion==true) {
                msm.ms_exito("Empleado registrado correctamente");
                //JOptionPane.showMessageDialog(null,"usuario registrado correctamente");
            }else if (ejecucion==false) {
                //JOptionPane.showMessageDialog(null,"error al insertar usuario");
                msm.ms_error("Error al guardar empleado");
            }  
        } catch (Exception e) {
            System.out.println("error al insertar"+e);
        }
    }
    
    public Object[] consultarporID(int id, JLabel lblfoto){
        
        Object [] datos=new Object[9];
        ImageIcon foto;
        InputStream is;
        
        try {
            String sql="select dni,nombres,apellidos,correo,telefono,usuario,clave,fecha,foto from usuarios where idusuario=?";
            PreparedStatement ps=con.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getDate(8);
                is=rs.getBinaryStream(9);
                BufferedImage bi= ImageIO.read(is);
                foto=new ImageIcon(bi);
                Image img=foto.getImage();
                Image newimg=img.getScaledInstance(lblfoto.getWidth(),lblfoto.getHeight(),java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon=new ImageIcon(newimg);
                datos[8]=newicon;
                
            }
        } catch (Exception e) {
            System.out.println("error al consultar"+e);
        }
        return datos;
        
    }
    
    
        public void modificarDatossinFoto(Usuario u){
    
        try {
           
            String sql="update usuarios set dni=?,nombres=?,apellidos=?,correo=?,telefono=?,usuario=?,clave=?,fecha=? where idusuario=?";
//            String sql="insert into usuarios(dni,nombres,apellidos,correo,telefono,usuario,clave,fecha,foto) values(?,?,?,?,?,?,?,'12-12-12',?)";
            PreparedStatement ps=con.con.prepareStatement(sql);
            ps.setString(1,u.getDni());
            ps.setString(2,u.getNombres());
            ps.setString(3,u.getApellidos());
            ps.setString(4,u.getCorreo());
            ps.setString(5,u.getTelefono());
            ps.setString(6,u.getUsuario());
            ps.setFloat(7,u.getClave());
            ps.setDate(8,u.getFecha());
            //ps.setBinaryStream(8,u.getFis(),u.getLongitudBytes());
            ps.setInt(9,u.getIdusuario());
            boolean ejecucion=con.ejecutarSQL(ps);
            if (ejecucion==true) {
               // JOptionPane.showMessageDialog(null,"usuario registrado correctamente");
                msm.ms_exito("Datos de empleado corrrectamente modificados");
            }else if (ejecucion==false) {
//                JOptionPane.showMessageDialog(null,"error al insertar usuario");
                msm.ms_error("Error al modificar datos de empleado");
            }  
        } catch (Exception e) {
            System.out.println("error al insertar"+e);
        }
    }
        
        public void modificarDatosconFoto(Usuario u){
    
        try {
           
            String sql="update usuarios set dni=?,nombres=?,apellidos=?,correo=?,telefono=?,usuario=?, clave=?,fecha=?,foto=? where idusuario=?";
//            String sql="insert into usuarios(dni,nombres,apellidos,correo,telefono,usuario,clave,fecha,foto) values(?,?,?,?,?,?,?,'12-12-12',?)";
            PreparedStatement ps=con.con.prepareStatement(sql);
            ps.setString(1,u.getDni());
            ps.setString(2,u.getNombres());
            ps.setString(3,u.getApellidos());
            ps.setString(4,u.getCorreo());
            ps.setString(5,u.getTelefono());
            ps.setString(6,u.getUsuario());
            ps.setFloat(7,u.getClave());
            ps.setDate(8,u.getFecha());
            ps.setBinaryStream(9,u.getFis(),u.getLongitudBytes());
            ps.setInt(10,u.getIdusuario());
            boolean ejecucion=con.ejecutarSQL(ps);
            if (ejecucion==true) {
//                JOptionPane.showMessageDialog(null,"usuario registrado correctamente");
                 msm.ms_exito("Datos de empleado corrrectamente modificados");
            }else if (ejecucion==false) {
//                JOptionPane.showMessageDialog(null,"error al insertar usuario");
                 msm.ms_error("Error al modificar datos de empleado");
            }  
        } catch (Exception e) {
            System.out.println("error al insertar"+e);
        }
    }
        
        
        
         public void eliminarUsuario(Usuario u){
    
        try {
           
            String sql="update usuarios set estado=0 where idusuario=?";
//            String sql="insert into usuarios(dni,nombres,apellidos,correo,telefono,usuario,clave,fecha,foto) values(?,?,?,?,?,?,?,'12-12-12',?)";
            PreparedStatement ps=con.con.prepareStatement(sql);
            ps.setInt(1,u.getIdusuario());
            boolean ejecucion=con.ejecutarSQL(ps);
            if (ejecucion==true) {
               // JOptionPane.showMessageDialog(null,"El usuario fue dado de baja");
                msm.ms_informacion("El empleado fue dado de baja");
            }else if (ejecucion==false) {
//                JOptionPane.showMessageDialog(null,"error al desactivar usuario");
                msm.ms_error("Error al desactivar empleado");
            }  
        } catch (Exception e) {
            System.out.println("error al insertar"+e);
        }
    }
         
     public void dardealta(Usuario u){
    
        try {
           
            String sql="update usuarios set estado=1 where idusuario=?";
//            String sql="insert into usuarios(dni,nombres,apellidos,correo,telefono,usuario,clave,fecha,foto) values(?,?,?,?,?,?,?,'12-12-12',?)";
            PreparedStatement ps=con.con.prepareStatement(sql);
            ps.setInt(1,u.getIdusuario());
            boolean ejecucion=con.ejecutarSQL(ps);
            if (ejecucion==true) {
//                JOptionPane.showMessageDialog(null,"El usuario fue dado de alta");
                msm.ms_informacion("El empleado fue dado de alta");
            }else if (ejecucion==false) {
//                JOptionPane.showMessageDialog(null,"error al activar usuario");
                msm.ms_error("Error al Activar empleado");
            }  
        } catch (Exception e) {
            System.out.println("error al modificar estado"+e);
        }
    }
    
}


       