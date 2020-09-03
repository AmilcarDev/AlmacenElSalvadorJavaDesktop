
package BaseImagen;

import com.integra.login.ControladorBitacora;
import com.integra.session.ModeloSession;
import java.awt.Color;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.KeyEvent; // para el enter 
/////imagem
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

////

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.table.TableColumnModel;

public class Proveedor2 extends javax.swing.JFrame {
    Icon exito;
   Icon error;
   Icon Warning;
   //////////////////////
FileInputStream fis;
    int longitudBytes; 
   ///Para fotos 
  Statement stm;
  Conexion conec=new Conexion();
    String nombre="";
    String Representante="";
String direccion="";
String telefono="";
String Apellido="";
String Celular="";

  String Codigo="";
  
    String Codigo_Estado="";
    
  int CodigoEntero=0;
     String ruta = null;
     
     ButtonGroup bg1=new ButtonGroup(); 
   
     private Object jtNombreRepresentante;
    /////Tabla
    DefaultTableModel dt=new DefaultTableModel();
    int Aumentar_Foto=0;
int Numero=0;
int Numero2=0;
String Codigo2="";
String Nombre="";
 String Nombre2="";
  String Apellido1="";
 
  String cadena = "";
  
 String Estado="";
 String Telefono="";
  String Telefono2="";
  String Estados="";
 String Direccion="";
 private String tipo_usua4;
  private String tipo_usua5;
   private String tipo_usua6;
   private String tipo_usua7;
    int fila = 0;
    int col=0 , fil=0;
    
    String Estado1="Activo";
    private Object mostrar;
    
    
   /* public void Ocultar(){
        JTProveedor.getColorModel().getColumn(1).setMaxWidth(0);
    }*/
    public Proveedor2() {
  this.setUndecorated(true);
    
        this.setLocationRelativeTo(null);
        initComponents();
        
         centrarEnPantalla();
         des_habilitar();
          Buscar_Codigo();
        /////////Tabla 
        VerTabla v = new VerTabla();
         Componer_tabla();
         REducir_tabla();
            tabla_ajuste();
            LLenar_Tabla();
//       v.visualizar_tabla(tabla);
         exito=new ImageIcon("src/iconos/icono-exito.png");
        Warning=new ImageIcon("src/iconos/Warning.png");
        error=new ImageIcon("src/iconos/BotonError.png");
      
         bg1.add(jRActivo);
         bg1.add(jRInactivo);
         jRActivo.setSelected(true);
         
         jBModificar.setVisible(false);
         
         jBCancelar.setEnabled(false);
       
     jBGuardar.setEnabled(false);
    }
    
    
    
    //////////BITACORA
    
        ModeloSession mss;
    ControladorBitacora cb;
    
        public Proveedor2(ModeloSession mss) {
  this.setUndecorated(true);
    
  this.mss=mss;
        cb= new ControladorBitacora();
        this.setLocationRelativeTo(null);
        initComponents();
        
         centrarEnPantalla();
         des_habilitar();
          Buscar_Codigo();
        /////////Tabla 
        VerTabla v = new VerTabla();
         Componer_tabla();
         REducir_tabla();
            tabla_ajuste();
            LLenar_Tabla();
//       v.visualizar_tabla(tabla);
         exito=new ImageIcon("src/iconos/icono-exito.png");
        Warning=new ImageIcon("src/iconos/Warning.png");
        error=new ImageIcon("src/iconos/BotonError.png");
      
         bg1.add(jRActivo);
         bg1.add(jRInactivo);
         jRActivo.setSelected(true);
         
         jBModificar.setVisible(false);
         
         jBCancelar.setEnabled(false);
       
     jBGuardar.setEnabled(false);
    }
    
    
    
    
    
    
     public void Limpiar(){
    //jtCodigo.setText("");
    jtNombre2.setText("");
    jtNombreRepresentante3.setText("");
    jtApellido3.setText("");
    jtTelefono3.setText("");
    jtCelular3.setText("");
    jtDireccion3.setText("");
    jtImagen1.setIcon(null);
 
    }
      
      public void habilitar(){
      //jtCodigo.setText("");
          jtNombre2.requestFocus();
    jtNombre2.setEnabled(true); 
    jtNombreRepresentante3.setEnabled(true); 
    jtApellido3.setEnabled(true); 
    jtTelefono3.setEnabled(true); 
    jtCelular3.setEnabled(true); 
    jtDireccion3.setEnabled(true); 
   jBCancelar.setEnabled(true);
     jBGuardar.setEnabled(true);
        btnAgregarImagen1.setEnabled(true); 
    }
       public void habilitar2(){
      //jtCodigo.setText("");
          jtNombre2.requestFocus();
   // jtNombre2.setEnabled(true); 
    jtNombreRepresentante3.setEnabled(true); 
    jtApellido3.setEnabled(true); 
    jtTelefono3.setEnabled(true); 
    jtCelular3.setEnabled(true); 
   jtDireccion3.setEnabled(true); ////////////////////////////////////////////////////////////////////////////
  jRActivo.setEnabled(true); 
   jRInactivo.setEnabled(true); 
      btnAgregarImagen1.setEnabled(true); 
  
    }
       
    public void des_habilitar(){
      //jtCodigo.setText("");
        JLDireccion.setVisible(false);
    jtNombre2.setEnabled(false); 
    jtNombreRepresentante3.setEnabled(false); 
    jtApellido3.setEnabled(false); 
    jtTelefono3.setEnabled(false); 
    jtCelular3.setEnabled(false); 
    jtDireccion3.setEnabled(false); 
      jRActivo.setEnabled(false); 
   jRInactivo.setEnabled(false); 
    btnAgregarImagen1.setEnabled(false); 
         jBGuardar.setEnabled(false);
        jBCancelar.setEnabled(false);
       
   jRActivo.setVisible(false);
   jRInactivo.setVisible(false);
   jLEstado.setVisible(false);
    }
    
     public void des_habilitar2(){
      //jtCodigo.setText("");
        JLDireccion.setVisible(false);
    jtNombre2.setEnabled(false); 
    jtNombreRepresentante3.setEnabled(false); 
    jtApellido3.setEnabled(false); 
    jtTelefono3.setEnabled(false); 
    jtCelular3.setEnabled(false); 
    jtDireccion3.setEnabled(false); 
      jRActivo.setEnabled(false); 
   jRInactivo.setEnabled(false); 
    btnAgregarImagen1.setEnabled(false); 
         jBGuardar.setEnabled(false);
      
        jBCancelar.setEnabled(true);
       
   
    }
      public void modificar_Cambio(){
       Limpiar();////////////////////////////
        des_habilitar();//////////////////777
        panel1.setTitleAt(0, "Registro de proveedor");
        jBNuevo.setVisible(true);
        jBGuardar.setVisible(true);
        jBModificar.setVisible(false);
    
      }
        public void campos(){


 int op = 0;
        String mensaje = "";
            
                if(this.jtNombre2.getText().equals( "" )){
                  op = 4;
            mensaje = mensaje + "Nombre                  Agregue un nombre\n";
               jtNombre2.requestFocus();

                   }
               
                  else{
                               if(this.jtNombreRepresentante3.getText().equals( "" )){
                     op = 4;
            mensaje = mensaje + "Nombre                  Agregue un nombre\n";
        
               jtNombreRepresentante3.requestFocus();
                          }
                        else{
                               if(this.jtApellido3.getText().equals( "" )){
                   op = 4;
            mensaje = mensaje + "Nombre                  Agregue un apellido\n";
               jtApellido3.requestFocus();
                          }        
                    else{
                 
                            
                             int m=0;
    m=jtTelefono3.getText().trim().length();   
       if (jtTelefono3.getText().matches("    -    ")){
         
           // JOptionPane.showMessageDialog(null,"El campo del teléfono es vacio",""+titulo,
                //    JOptionPane.ERROR_MESSAGE);
       op = 4;
            mensaje = mensaje + "Teléfono                  Agregue un teléfono\n";  jtTelefono3.requestFocus();
        }
     else{
            if (!jtTelefono3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")){

                    //JOptionPane.showMessageDialog(null,"El de teléfono debe tener 8 digitos",""+titulo,
                            //JOptionPane.ERROR_MESSAGE);
               op = 4;
            mensaje = mensaje + "Teléfono                  El de teléfono debe tener 8 dígitos\n";
                    jtTelefono3.requestFocus();
                }
              else{
                
                
                if (!(jtTelefono3.getText().matches("[2]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))){

                    //JOptionPane.showMessageDialog(null,"EL NUMERO TELEFÓNICO DEBE DE INICIAR CON 2 "
                                                // + "  \nEJEMPLO: 2345-5674 ",""+titulo,
                           // JOptionPane.ERROR_MESSAGE);
                     op = 4;
            mensaje = mensaje + "Teléfono                  El número telefónico debe de iniciar con 2\n";
                    jtTelefono3.requestFocus();
                }
                else{
                    int mm=0;
    mm=jtCelular3.getText().trim().length();   
       if (jtCelular3.getText().matches("    -    ")){
         
           // JOptionPane.showMessageDialog(null,"El campo del teléfono es vacio",""+titulo,
                //    JOptionPane.ERROR_MESSAGE);
       //JOptionPane.showMessageDialog(this, "EL CAMPO DEL TELÉFONO  ES VACIO","REGISTRO DE PROVEEDOR",
               // JOptionPane.INFORMATION_MESSAGE,Warning);
           //JOptionPane.showMessageDialog(this, "EL CAMPO DEL TELÉFONO  ES VACIO","REGISTRO DE PROVEEDOR",
               // JOptionPane.INFORMATION_MESSAGE,Warning); op = 4;
            mensaje = mensaje + "Nombre                  El campo del teléfono  esta vacio \n";
            jtCelular3.requestFocus();
        }
       else{if (!jtCelular3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")){

                    //JOptionPane.showMessageDialog(null,"EL DE TELÉFONO DEBE TENER 8 DÍGITOS",""+titulo,
              op = 4;
            mensaje = mensaje + "Celular                   Agregue un Celular \n";
                    jtCelular3.requestFocus();
                }else{      if(!(jtCelular3.getText().matches("[6]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}")
                        || jtCelular3.getText().matches("[7]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))){
                      //JOptionPane.showMessageDialog(null,"EL NUMERO TELEFÓNICO DEBE DE INICIAR CON 6 Ó 7"
                                                // + "  \nEJEMPLO: 6345-5674 ó 7388-3342",""+titulo,
                           // JOptionPane.ERROR_MESSAGE
                op = 4;
            mensaje = mensaje + "Celular                   El número de celular debe de iniciar con 7 y 6\n";
                    jtCelular3.requestFocus();
                }
else{
                               if(this.jtCelular3.getText().equals( "" )){
                 // JOptionPane.showMessageDialog(null,"EL CAMPO DE LA DIRECCIÓN DEL PROVEEDOR  ESTA VACIO",""+titulo,
                       //JOptionPane.ERROR_MESSAGE);
                op = 4;
            mensaje = mensaje + "Celular                  El campo del celular  esta vacio\n";
               jtDireccion3.requestFocus();
                          }
                               else{
                               if(this.JLDireccion.getText().equals( "" )){
                 // JOptionPane.showMessageDialog(null,"EL CAMPO DE LA DIRECCIÓN DEL PROVEEDOR  ESTA VACIO",""+titulo,
                       //JOptionPane.ERROR_MESSAGE);
              op = 4;
            mensaje = mensaje + "Dirección                  Agregue una Dirección\n";
               jtDireccion3.requestFocus();
                          }
                
        
                                   else{
                                  Guardar();
                                 //  Modificar1();
                                   //Actualizar();
               Limpiar();
                //des_habilitar1();
                        
                       
                       }
                         }
                               }
                }

                       }
                  
                }
               }
            }
                    }
                               }
                   }
               
                }
        
         public int validar() {
        int op = 0;
        String mensaje = "";
      
        if ((jtNombre2.getText().trim().equals(""))) {
            op = 4;
             mensaje = mensaje + "Nombre                  Agregue un Proveedor\n";
            //jtNombre2.requestFocus();
        }
          if ((jtNombreRepresentante3.getText().trim().equals(""))) {
            op = 4;
            mensaje = mensaje + "Representante             Agregue un representante\n";
              //jtNombreRepresentante3.requestFocus();
        }
           if ((jtApellido3.getText().trim().equals(""))) {
            op = 4;
            mensaje = mensaje + "Apellido                  Agregue un apellido\n";
               //jtApellido3.requestFocus();
        }
           
           int mm=0;
    mm=jtTelefono3.getText().trim().length();  
            if (jtTelefono3.getText().matches("    -    ")) {
            op = 4;
            mensaje = mensaje + "Teléfono                  Agregue un teléfono\n";
             //  jtTelefono3.requestFocus();
        }else{
             if (!jtTelefono3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")) {
            op = 4;
            mensaje = mensaje + "Teléfono                  El teléfono debe tener 8 digitos\n";
             //  jtTelefono3.requestFocus();
        }
           else{ 
                 if (!(jtTelefono3.getText().matches("[2]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))) {
            op = 4;
            mensaje = mensaje + "Teléfono                  El teléfono debe de empesar con 2\n";
              // jtTelefono3.requestFocus();
        }
            }
            }
                  //int mm=0;
   // mm=jtCelular3.getText().trim().length();  
            if (jtCelular3.getText().matches("    -    ")) {
            op = 4;
            mensaje = mensaje + "Celular                  Agregue un Celular\n";
              // jtCelular3.requestFocus();
        }else{
             if (!jtCelular3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")) {
            op = 4;
            mensaje = mensaje + "Celular                  El Celular debe tener 8 digitos\n";
              // jtCelular3.requestFocus();
        }
           else{ 
                 if (!(jtCelular3.getText().matches("[6]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}")
                        || jtCelular3.getText().matches("[7]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))) {
            op = 4;
            mensaje = mensaje + "Celular                  El Celular debe de empezar con 6 y 7\n";
               //jtCelular3.requestFocus();
        }
            }
            }
             if (this.jtDireccion3.getText().equals( "" )) {
            op = 4;
            mensaje = mensaje + "Dirección                Agregue una dirección\n";
               ///jtDireccion3.requestFocus();
        }
              if (this.JLDireccion.getText().equals( "" )) {
            op = 4;
            mensaje = mensaje + "Foto                Agregue una foto o imagen\n";
               ///jtDireccion3.requestFocus();
        }
        if (op > 0) {
            msm.ms_alerta("          Verifique los siguientes campos:\n\n" + mensaje);
//            Men_A=new Mensaje_Aplicacion("Departamento de Ropa",mensaje);
//            Men_A.setVisible(true);
        }else{
      //  busqueda_Proveedor();
                                //  Guardar();
                                 //  Modificar1();
                                   //Actualizar();
               //Limpiar();
            busqueda_Proveedor();
        }
        return op;
    }
         
          public int validar2() {
        int op = 0;
        String mensaje = "";
      
        if ((jtNombre2.getText().trim().equals(""))) {
            op = 4;
             mensaje = mensaje + "Nombre                  Agregue un Proveedor\n";
            //jtNombre2.requestFocus();
        }
          if ((jtNombreRepresentante3.getText().trim().equals(""))) {
            op = 4;
            mensaje = mensaje + "Representante             Agregue un representante\n";
              //jtNombreRepresentante3.requestFocus();
        }
           if ((jtApellido3.getText().trim().equals(""))) {
            op = 4;
            mensaje = mensaje + "Apellido                  Agregue un apellido\n";
               //jtApellido3.requestFocus();
        }
           
           int mm=0;
    mm=jtTelefono3.getText().trim().length();  
            if (jtTelefono3.getText().matches("    -    ")) {
            op = 4;
            mensaje = mensaje + "Teléfono                  Agregue un teléfono\n";
             //  jtTelefono3.requestFocus();
        }else{
             if (!jtTelefono3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")) {
            op = 4;
            mensaje = mensaje + "Teléfono                  El teléfono debe tener 8 digitos\n";
             //  jtTelefono3.requestFocus();
        }
           else{ 
                 if (!(jtTelefono3.getText().matches("[2]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))) {
            op = 4;
            mensaje = mensaje + "Teléfono                  El teléfono debe de empesar con 2\n";
              // jtTelefono3.requestFocus();
        }
            }
            }
                  //int mm=0;
   // mm=jtCelular3.getText().trim().length();  
            if (jtCelular3.getText().matches("    -    ")) {
            op = 4;
            mensaje = mensaje + "Celular                  Agregue un Celular\n";
              // jtCelular3.requestFocus();
        }else{
             if (!jtCelular3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")) {
            op = 4;
            mensaje = mensaje + "Celular                  El Celular debe tener 8 digitos\n";
              // jtCelular3.requestFocus();
        }
           else{ 
                 if (!(jtCelular3.getText().matches("[6]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}")
                        || jtCelular3.getText().matches("[7]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))) {
            op = 4;
            mensaje = mensaje + "Celular                  El Celular debe de empezar con 6 y 7\n";
               //jtCelular3.requestFocus();
        }
            }
            }
             if (this.jtDireccion3.getText().equals( "" )) {
            op = 4;
            mensaje = mensaje + "Dirección                Agregue una dirección\n";
               ///jtDireccion3.requestFocus();
        }
              if (this.JLDireccion.getText().equals( "" )) {
            op = 4;
            mensaje = mensaje + "Foto                Agregue una foto o imagen\n";
               ///jtDireccion3.requestFocus();
        }
        if (op > 0) {
            msm.ms_alerta("          Verifique los siguientes campos:\n\n" + mensaje);
//            Men_A=new Mensaje_Aplicacion("Departamento de Ropa",mensaje);
//            Men_A.setVisible(true);
        }else{
                                    if(Aumentar_Foto==0){
                                           // Guardar();
                                   Modificar2();
                                   //Modificar2();
                                   //Actualizar();
               Limpiar();
                //des_habilitar1();
                        
                 
                          }
                      else{
                                 // Guardar();
                                  // Modificar1();
                                   Modificar1();
                                   //Actualizar();
               Limpiar();
                //des_habilitar1();
                        
                       
                       }
                         }
        return op;
    }
         
         
         public void campos2(){



            
                if(this.jtNombre2.getText().equals( "" )){
                  //JOptionPane.showMessageDialog(null,"El campo del nombre del Nombre de la Empresa esta vacio",""+titulo,
                       //JOptionPane.ERROR_MESSAGE
                      JOptionPane.showMessageDialog(this, "EL CAMPO  DEL NOMBRE DE LA EMPRESA ESTA VACIO","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
               jtNombre2.requestFocus();

                   }
               
                  else{
                               if(this.jtNombreRepresentante3.getText().equals( "" )){
                  //JOptionPane.showMessageDialog(null,"El campo del nombre del Representante esta vacio",""+titulo,
                     //  JOptionPane.ERROR_MESSAGE);
                   JOptionPane.showMessageDialog(this, "EL CAMPO DEL NOMBRE DEL REPRESENTANTE ESTA VACIO","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
               jtNombreRepresentante3.requestFocus();
                          }
                        else{
                               if(this.jtApellido3.getText().equals( "" )){
                  //JOptionPane.showMessageDialog(null,"El campo del nombre del Representante esta vacio",""+titulo,
                     //  JOptionPane.ERROR_MESSAGE);
                   JOptionPane.showMessageDialog(this, "EL CAMPO DEL APELLIDO DEL REPRESENTANTE ESTA VACIO","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
               jtApellido3.requestFocus();
                          }        
                    else{
                 
                            
                             int m=0;
    m=jtTelefono3.getText().trim().length();   
       if (jtTelefono3.getText().matches("    -    ")){
         
           // JOptionPane.showMessageDialog(null,"El campo del teléfono es vacio",""+titulo,
                //    JOptionPane.ERROR_MESSAGE);
       JOptionPane.showMessageDialog(this, "EL CAMPO DEL TELÉFONO  ES VACIO","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
            jtTelefono3.requestFocus();
        }
     else{
            if (!jtTelefono3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")){

                    //JOptionPane.showMessageDialog(null,"El de teléfono debe tener 8 digitos",""+titulo,
                            //JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "EL DE TELÉFONO DEBE TENER 8 DÍGITOS","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
                    jtTelefono3.requestFocus();
                }
              else{
                
                
                if (!(jtTelefono3.getText().matches("[2]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))){

                    //JOptionPane.showMessageDialog(null,"EL NUMERO TELEFÓNICO DEBE DE INICIAR CON 2 "
                                                // + "  \nEJEMPLO: 2345-5674 ",""+titulo,
                           // JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(this, "EL NUMERO TELEFÓNICO DEBE DE INICIAR CON 2 "
                            + "EJEMPLO: 2345-5674 ","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
                    jtTelefono3.requestFocus();
                }
                else{
                    int mm=0;
    mm=jtCelular3.getText().trim().length();   
       if (jtCelular3.getText().matches("    -    ")){
         
           // JOptionPane.showMessageDialog(null,"El campo del teléfono es vacio",""+titulo,
                //    JOptionPane.ERROR_MESSAGE);
       //JOptionPane.showMessageDialog(this, "EL CAMPO DEL TELÉFONO  ES VACIO","REGISTRO DE PROVEEDOR",
               // JOptionPane.INFORMATION_MESSAGE,Warning);
           JOptionPane.showMessageDialog(this, "EL CAMPO DEL TELÉFONO  ES VACIO","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
            jtCelular3.requestFocus();
        }
       else{if (!jtCelular3.getText().matches("[0-9]\\d{3}-[0-9]\\d{3}")){

                    //JOptionPane.showMessageDialog(null,"EL DE TELÉFONO DEBE TENER 8 DÍGITOS",""+titulo,
                      //      JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "EL DE TELÉFONO DEBE TENER 8 DÍGITOS","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
                    jtCelular3.requestFocus();
                }else{      if(!(jtCelular3.getText().matches("[6]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}")
                        || jtCelular3.getText().matches("[7]\\d{0}+[0-9]\\d{2}-[0-9]\\d{3}"))){
                      //JOptionPane.showMessageDialog(null,"EL NUMERO TELEFÓNICO DEBE DE INICIAR CON 6 Ó 7"
                                                // + "  \nEJEMPLO: 6345-5674 ó 7388-3342",""+titulo,
                           // JOptionPane.ERROR_MESSAGE
                JOptionPane.showMessageDialog(this, "EL NUMERO TELEFÓNICO DEBE DE INICIAR CON 6 Ó 7"
                        + "EJEMPLO: 6345-5674 ó 7388-3342","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
                    jtCelular3.requestFocus();
                }
else{
                               if(this.jtDireccion3.getText().equals( "" )){
                 // JOptionPane.showMessageDialog(null,"EL CAMPO DE LA DIRECCIÓN DEL PROVEEDOR  ESTA VACIO",""+titulo,
                       //JOptionPane.ERROR_MESSAGE);
               JOptionPane.showMessageDialog(this, "EL CAMPO DE LA DIRECCIÓN DEL PROVEEDOR  ESTA VACIO","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
               jtDireccion3.requestFocus();
                          }
                               else{
                               if(this.JLDireccion.getText().equals( "" )){
                 // JOptionPane.showMessageDialog(null,"EL CAMPO DE LA DIRECCIÓN DEL PROVEEDOR  ESTA VACIO",""+titulo,
                       //JOptionPane.ERROR_MESSAGE);
               JOptionPane.showMessageDialog(this, "EL CAMPO DE LA FOTO DEL PROVEEDOR  ESTA VACIO","REGISTRO DE PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,Warning);
               jtDireccion3.requestFocus();
                          }
                      else{
                                    if(Aumentar_Foto==0){
                                           // Guardar();
                                   Modificar2();
                                   //Modificar2();
                                   //Actualizar();
               Limpiar();
                //des_habilitar1();
                        
                 
                          }
                      else{
                                 // Guardar();
                                  // Modificar1();
                                   Modificar1();
                                   //Actualizar();
               Limpiar();
                //des_habilitar1();
                        
                       
                       }
                         }
                }
                }
                       }
                  }     
                }
               }
            }
                    }
                               }
                   }
                 
                }
         
    
         public void Guardar(){
         Conexion conn = new Conexion();
        //String Codigo = this.jtCodigo.getText();
        String nombre2 = this.jtNombre2.getText();
        String nombre_R = this.jtNombreRepresentante3.getText();
        String Apellido1 = this.jtApellido3.getText();
        String Telefono1 = this.jtTelefono3.getText();
        String Celular1 = this.jtCelular3.getText();
        String Direccion1 = this.jtDireccion3.getText();

        //conn.guardar(ruta, nombre_R);
          
        conn.guardar(CodigoEntero,nombre2,nombre_R,Apellido1,Direccion1,Telefono1,Celular1,Estado1,ruta);
        
        cb.insertarAccion(mss.getNombre(),"Agregó un nuevo Proveedor");
        
        
    
         }
         
          public void Modificar1(){
         Conexion conn = new Conexion();
        //String Codigo = this.jtCodigo.getText();
        String nombre2 = this.jtNombre2.getText();
        String nombre_R = this.jtNombreRepresentante3.getText();
        String Apellido1 = this.jtApellido3.getText();
        String Telefono1 = this.jtTelefono3.getText();
        String Celular1 = this.jtCelular3.getText();
        String Direccion1 = this.jtDireccion3.getText();

        //conn.guardar(ruta, nombre_R);
        conn.Modificar(nombre2,nombre_R,Apellido1,Direccion1,Telefono1,Celular1,Estado1,ruta);
     modificar_Cambio();
         }
           public void Modificar2(){
         Conexion conn = new Conexion();
        //String Codigo = this.jtCodigo.getText();
        String nombre2 = this.jtNombre2.getText();
        String nombre_R = this.jtNombreRepresentante3.getText();
        String Apellido1 = this.jtApellido3.getText();
        String Telefono1 = this.jtTelefono3.getText();
        String Celular1 = this.jtCelular3.getText();
        String Direccion1 = this.jtDireccion3.getText();
 modificar_Cambio();
        //conn.guardar(ruta, nombre_R);
        conn.Modificar2(nombre2,nombre_R,Apellido1,Direccion1,Telefono1,Celular1,Estado1);
    Aumentar_Foto=0;
         }
          
           /* public void Acitvo_Inactivo(){
           int a2=0;
       try{ 
     conec.abrirConeccion();
    Statement stmm=conec.con1.createStatement();
          ResultSet rss=stmm.executeQuery("select *from tproducto where eidproveedor=('"+Codigo2+"')");
        
            while(rss.next()){
             
                Codigo=rss.getString(1);
                 if(!(Codigo=="")){
                             a2=1;
                         }
                  }
            
               if(a2 == 1){
                        JOptionPane.showMessageDialog(null,"NOSEE PUEDE DESABILITAR EL PROVEEDOR","error",JOptionPane.ERROR_MESSAGE);
                     }
               
              }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al consultar","error",JOptionPane.ERROR_MESSAGE);

        }
     
 }
*/


 
 public void Buscar_Codigo(){
        ResultSet rs;

           String codigo = "";
        String sqlIncre="";
   sqlIncre="SELECT Id_Proveedor FROM proveedor t ORDER BY Id_Proveedor";

  
        try {

             conec.abrirConeccion();
           Statement stm=conec.con1.createStatement();
                
          
            rs = stm.executeQuery(sqlIncre);
            if(rs.last()==false){
                codigo = "1000000";
            }
            else{
                rs.last();
                codigo = rs.getString(1);
               //cadena = String.valueOf(codigo);
                //cadena= Integer.toString(codigo);
                
            }
            rs.close();
          //  stm.close();
            conec.cerrarConeccion();
           
            Generar_Codigo(codigo);
        }
        catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        }
        catch (Exception e) {
            System.out.println("Error al Abrir tabla ");
        }
    }

            public void Generar_Codigo(String codigo){
         String codigo_usuario="";
         String cod_capturado = codigo.substring(1, 7);//captura los ultimos 7 valores del codigo
         int valor = Integer.parseInt(cod_capturado);  //lo convierte a entero
         int cod_generado = valor + 1;                 //le suma 1 para incrementarlo
         if (cod_generado < 10) {
            codigo_usuario = "100000" + cod_generado;
         }
         else
            if (cod_generado < 100) {
               codigo_usuario = "10000" + cod_generado;
            }
            else
               if (cod_generado < 1000) {
                  codigo_usuario = "1000" + cod_generado;
               }
               else
                  if (cod_generado < 10000) {
                     codigo_usuario = "100" + cod_generado;
                  }
                  else
                     if (cod_generado < 100000) {
                        codigo_usuario = "10" + cod_generado;
                     }
                     else
                        if (cod_generado < 1000000) {
                           codigo_usuario = "2" + cod_generado;

                        }

         //jtCodigo.setText("");
         //jtCodigo.setText(codigo_usuario);
         Codigo=codigo_usuario;
         CodigoEntero=Integer.parseInt(Codigo);
    
    } 
           
            
     public void Componer_tabla(){
       JTProveedor.setModel(dt);
          dt.addColumn("Numero");
        dt.addColumn("Código");
        dt.addColumn("Nombre Empresa");
         dt.addColumn("Nombre Representante");
        dt.addColumn("Apellido");
         dt.addColumn("Dirección");
         dt.addColumn("Teléfono");
        dt.addColumn("Celular");
        dt.addColumn("Estado");
 
  
      
    }
     
     public void REducir_tabla(){
      
 JTProveedor.getColumnModel().getColumn(1).setMaxWidth(-5);

JTProveedor.getColumnModel().getColumn(1).setMinWidth(-5);

JTProveedor.getColumnModel().getColumn(1).setPreferredWidth(-5);
  JTProveedor.getColumnModel().getColumn(0).setMaxWidth(-5);

JTProveedor.getColumnModel().getColumn(0).setMinWidth(-5);

JTProveedor.getColumnModel().getColumn(0).setPreferredWidth(-5);
      
    }
     
     
        public void tabla_ajuste(){
         
         TableColumnModel columnModel =  JTProveedor.getColumnModel();
for (int i = 0; i < columnModel.getColumnCount(); i++) {
columnModel.getColumn(0).setPreferredWidth(1);
columnModel.getColumn(1).setPreferredWidth(30);
columnModel.getColumn(2).setPreferredWidth(80);
columnModel.getColumn(3).setPreferredWidth(80);
columnModel.getColumn(4).setPreferredWidth(15);
columnModel.getColumn(5).setPreferredWidth(22);
columnModel.getColumn(6).setPreferredWidth(25);
columnModel.getColumn(7).setPreferredWidth(25);
columnModel.getColumn(8).setPreferredWidth(10);

}
        }
         public void LLenar_Tabla(){
           String sql3="";
        //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
        sql3="SELECT * FROM proveedor c WHERE c.Nombre_Proveedor LIKE '%"+this.jXBuscar.getText()+"%'";

        Buscar(sql3);

}
 
     
        
        public void Buscar(String sql3){
       
          
          /////////////////777
          dt.setRowCount(0);
        ResultSet rs;

           String codigo = "";
        String sqlIncre="";
sqlIncre=sql3;

          try{
 conec.abrirConeccion();
           Statement stm=conec.con1.createStatement();

 Numero=0;
  Numero=0;
            rs = stm.executeQuery(sqlIncre);

  Object[] fila = new Object[9];
           while(rs.next()){
               Numero++;
               Numero2++;
      Codigo = rs.getString(1);
      Nombre = rs.getString(2);
      Nombre2 = rs.getString(3);
      Apellido1= rs.getString(4);
        Direccion = rs.getString(5);
       //Estado = rs.getString(7);
     
      Telefono = rs.getString(6);
       Telefono2 = rs.getString(7);
       Estados= rs.getString(8);
         //Estado = rs.getString(7);
      //Telefono2 = rs.getString(6);
      
    /////Imagen_mostrar(sqlIncre); //yamar a la fucinon q corre la imagen
    
  
 //System.out.println("Registro encontrado correctamente");
dt.addRow(new Object[]{Numero,Codigo,Nombre,Nombre2,Apellido1,Direccion,Telefono,Telefono2,Estados});
           }

           conec.cerrarConeccion();

       }catch(Exception e){
      // JOptionPane.showMessageDialog(null,"Error al guardar","error",JOptionPane.ERROR_MESSAGE);



       }


    }   
              
        
        
      public void Imagen_mostrar(String sql3){
       
          
          /////////////////777
          dt.setRowCount(0);
        ResultSet rs;

           String codigo = "";
        String sqlIncre="";
sqlIncre=sql3;

          try{
 conec.abrirConeccion();
           Statement stm=conec.con1.createStatement();

 Numero=0;
  Numero=0;
 // rs = stm.executeQuery(“SELECT FOTO FROM IMAGENES WHERE ID = 1”);
            rs = stm.executeQuery(sqlIncre);
             //rs = stm.executeQuery(sqlIncre);

  Object[] fila = new Object[9];
           while(rs.next()){
         
       Blob blob = rs.getBlob(9);
         byte[] data = blob.getBytes(1, (int)blob.length());
                        BufferedImage img = null;
                  
                        try{
                        img = ImageIO.read(new ByteArrayInputStream(data));
                        }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        }
                        
                          //Image icono=ImageIO.read(setSelectedFile()).getScaledInstance(jtImagen1.getWidth(),jtImagen1.getHeight(),Image.SCALE_DEFAULT);
                  /*  jtImagen1.setIcon(new ImageIcon(icono));
                      jtImagen1.setIcon(new ImageIcon(icono));
                    jtImagen1.updateUI();*/
                  ImageIcon imagen= new ImageIcon(img);
                     
                    Icon icono;
     icono = new ImageIcon(imagen.getImage().getScaledInstance(jtImagen1.getWidth(), jtImagen1.getHeight(),100));
                       //  ImageIcon icono = new ImageIcon(img); 
                   // img.getScaledInstance(110, 11o, icono.getImage());
                         jtImagen1.setIcon(icono);
                          //jtImagen2.setIcon(icono);
                         this.repaint();
                        
                          
                          
JLDireccion.setText(" f");
                          //Icon icono= new imageIcon(imagen.getImagen().getScaledInstence()lblfon.)
     // fila[8] = new JLabel(icono);
      //Telefono2 = rs.getString(6);
      

           }

           conec.cerrarConeccion();

       }catch(Exception e){
      // JOptionPane.showMessageDialog(null,"Error","error",JOptionPane.ERROR_MESSAGE);



       }


    }   
          
        
        public void Actualizar(){
            FileInputStream fi = null;  
  try{
   
                    File file = new File(ruta);
            fi = new FileInputStream(file);
conec.abrirConeccion();
     Statement stm=conec.con1.createStatement();
    stm.executeUpdate("UPDATE proveedor p SET Nombre_Representante=('"+jtNombre2.getText()+"')"
            + ",Telefono_Encargado=('"+jtCelular3.getText()+"'),Direccion=('"+jtDireccion3.getText()+"'),Telefono_Empresa=('"+jtTelefono3.getText()+"'),foto=)('"+fi+"')  WHERE Id_proveedor=('"+Codigo2+"')");
    //JOptionPane.showMessageDialog(null,"REGISTRO DE EMPLEADO ACTUALIZADO");
      JOptionPane.showMessageDialog(this, "REGISTRO DE EMPLEADO ACTUALIZADO","BUSCAR PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,exito);
    conec.cerrarConeccion();
}catch(Exception e){
    //JOptionPane.showMessageDialog(null,"Error al Actualizar","error",JOptionPane.ERROR_MESSAGE);
     JOptionPane.showMessageDialog(this, "ERROR AL ACTUALIZAR REGISTRO","BUSCAR PROVEEDOR",
                JOptionPane.INFORMATION_MESSAGE,error);
}
//jbBuscar.setEnabled(true);
  

}    
        
        public void busqueda_Proveedor(){
         String mensaje = "";
       try {
           conec.abrirConeccion();
            Statement stm=conec.con1.createStatement();
               
          ResultSet rs=stm.executeQuery("select * from Proveedor where Nombre_Proveedor=('"+jtNombre2.getText()+"')");
while(rs.next()){

                  tipo_usua4=rs.getString(2);
         
           }

 if(tipo_usua4==null){
          Guardar();
                                 //  Modificar1();
                                   //Actualizar();
               Limpiar(); 
               des_habilitar();
           
   }else
 {
      
     mensaje = mensaje + "Nombre             El proveedor ya existe\n";
     msm.ms_alerta("          Verifique el siguiente campo:\n\n" + mensaje);
   
        //OptionPane.showMessageDialog(this, "EL NOMBRE DE PROVEEDOR YA EXISTE","REGISTRO DE PROVEEDOR",
              //  JOptionPane.INFORMATION_MESSAGE,Warning);
tipo_usua4="";
    
        conec.cerrarConeccion();
          tipo_usua4=null;

 }
          
            conec.cerrarConeccion();
            }catch(Exception e){

        }


}
        public void busqueda_Telefono(){
         String mensaje = "";
       try {
           conec.abrirConeccion();
            Statement stm1=conec.con1.createStatement();
               
          ResultSet rs=stm1.executeQuery("select * from Proveedor where Telefono_Empresa=('"+jtTelefono3.getText()+"')");
while(rs.next()){

                  tipo_usua5=rs.getString(7);
         
           }

 if(tipo_usua5==null){
          //Guardar();
                                 //  Modificar1();
                                   //Actualizar();
               //Limpiar(); 
               //des_habilitar();
     
           
   }else
 {
      
     mensaje = mensaje + "Nombre             El telefono ya existee\n";
     msm.ms_alerta("         Verifique el siguiente campo:\n\n" + mensaje);
   jtTelefono3.setText("");
        //OptionPane.showMessageDialog(this, "EL NOMBRE DE PROVEEDOR YA EXISTE","REGISTRO DE PROVEEDOR",
              //  JOptionPane.INFORMATION_MESSAGE,Warning);
tipo_usua5="";
    
        conec.cerrarConeccion();
          tipo_usua5=null;

 }
          
            conec.cerrarConeccion();
            }catch(Exception e){

        }


}
  
        public void busqueda_Celular(){
         String mensaje = "";
       try {
           conec.abrirConeccion();
            Statement stm=conec.con1.createStatement();
               
          ResultSet rs=stm.executeQuery("select * from Proveedor where Telefono_Encargado=('"+jtCelular3.getText()+"')");
while(rs.next()){

                  tipo_usua6=rs.getString(6);
         
           }

 if(tipo_usua6==null){
         //Guardar();
                                 //  Modificar1();
                                   //Actualizar();
              // Limpiar(); 
              // des_habilitar();
           
   }else
 {
      
     mensaje = mensaje + "Nombre             El celular ya existe\n";
     msm.ms_alerta("          Verifique el siguiente campo:\n\n" + mensaje);
    jtCelular3.setText("");
        //OptionPane.showMessageDialog(this, "EL NOMBRE DE PROVEEDOR YA EXISTE","REGISTRO DE PROVEEDOR",
              //  JOptionPane.INFORMATION_MESSAGE,Warning);
tipo_usua6="";
    
        conec.cerrarConeccion();
          tipo_usua6=null;

 }
          
            conec.cerrarConeccion();
            }catch(Exception e){

        }


}
        
        public void busqueda_Telefono2(){
         String mensaje = "";
       try {
           conec.abrirConeccion();
            Statement stm1=conec.con1.createStatement();
               
          ResultSet rs=stm1.executeQuery("select * from usuarios where telefono=('"+jtTelefono3.getText()+"')");
while(rs.next()){

                  tipo_usua5=rs.getString(7);
         
           }

 if(tipo_usua5==null){
          //Guardar();
                                 //  Modificar1();
                                   //Actualizar();
               //Limpiar(); 
               //des_habilitar();
     
           
   }else
 {
      
     mensaje = mensaje + "Nombre             El telefono ya existee\n";
     msm.ms_alerta("         Verifique el siguiente campo:\n\n" + mensaje);
   jtTelefono3.setText("");
        //OptionPane.showMessageDialog(this, "EL NOMBRE DE PROVEEDOR YA EXISTE","REGISTRO DE PROVEEDOR",
              //  JOptionPane.INFORMATION_MESSAGE,Warning);
tipo_usua5="";
    
        conec.cerrarConeccion();
          tipo_usua5=null;

 }
          
            conec.cerrarConeccion();
            }catch(Exception e){

        }


}
  
        
        
          public void Acitvo_Inactivo(){
           int a2=0;
            String mensaje = "";
       try{ 
     conec.abrirConeccion();
     
    Statement stmm=conec.con1.createStatement();
         // ResultSet rss=stmm.executeQuery("select *from producto where Id_Proveedor=('"+Codigo+"')");
     ResultSet rss=stmm.executeQuery("select *from producto where Id_Proveedor=('"+Codigo_Estado+"')");
        
            while(rss.next()){
             
                Codigo2=rss.getString(1);
                 if(!(Codigo2=="")){
                             a2=1;
                         }
                  }
            
               if(a2 == 1){
                        //JOptionPane.showMessageDialog(null,"NOSEE PUEDE DESABILITAR EL PROVEEDOR","error",JOptionPane.ERROR_MESSAGE);
                    
               jRActivo.setSelected(true);
                   mensaje = mensaje + "Nombre             No se puede desabilitar el proveedor\n";
     msm.ms_alerta("         Verifique el siguiente campo:\n\n" + mensaje);
               }
               
              }catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Error al consultar","error",JOptionPane.ERROR_MESSAGE);
                  mensaje = mensaje + "Nombre            Error al consultar\n";
     msm.ms_alerta("        Error al consultar \n\n" + mensaje);

        }
     
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alphaPainter1 = new org.jdesktop.swingx.painter.AlphaPainter();
        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panel2 = new org.edisoncor.gui.panel.Panel();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel1 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jtNombre2 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jtNombreRepresentante3 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jtApellido3 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jtDireccion3 = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel42 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32hhh = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLEstado = new javax.swing.JLabel();
        jRActivo = new javax.swing.JRadioButton();
        jRInactivo = new javax.swing.JRadioButton();
        JLDireccion = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jtTelefono3 = new javax.swing.JFormattedTextField();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        jtCelular3 = new javax.swing.JFormattedTextField();
        jtImagen1 = new javax.swing.JLabel();
        btnAgregarImagen1 = new javax.swing.JButton();
        panelImage6 = new org.edisoncor.gui.panel.PanelImage();
        jBNuevo = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        panel3 = new org.edisoncor.gui.panel.Panel();
        jPanel18 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jXBuscar = new org.jdesktop.swingx.JXSearchField();
        panel5 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTProveedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel2.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel2.setColorSecundario(new java.awt.Color(255, 255, 255));

        panelRectTranslucido1.setColorPrimario(new java.awt.Color(0, 0, 102));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(733, 50));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrar Proveedor");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 370, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button-close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRectTranslucido1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        panel1.setMaximumSize(new java.awt.Dimension(733, 508));
        panel1.setMinimumSize(new java.awt.Dimension(733, 508));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(777, 448));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 12))); // NOI18N
        jPanel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel10.setName("datos"); // NOI18N

        jtNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });
        jtNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtNombre2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombre2KeyTyped(evt);
            }
        });

        jtNombreRepresentante3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreRepresentante1ActionPerformed(evt);
            }
        });
        jtNombreRepresentante3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtNombreRepresentante3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreRepresentante3KeyTyped(evt);
            }
        });

        jtApellido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApellido1ActionPerformed(evt);
            }
        });
        jtApellido3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtApellido3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellido3KeyTyped(evt);
            }
        });

        jtDireccion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDireccion1ActionPerformed(evt);
            }
        });
        jtDireccion3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtDireccion3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtDireccion3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDireccion3KeyTyped(evt);
            }
        });

        jLabel42.setText("Celular");

        jLabel28.setText("Nombre Proveedor");

        jLabel29.setText("Nombre Representante");

        jLabel32hhh.setText("Apellido");

        jLabel43.setText("Teléfono");

        jLabel44.setText("Dirección");

        jLEstado.setText("Estado");

        jRActivo.setBackground(new java.awt.Color(255, 255, 255));
        jRActivo.setText("Activo");
        jRActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRActivoActionPerformed(evt);
            }
        });

        jRInactivo.setBackground(new java.awt.Color(255, 255, 255));
        jRInactivo.setText("Inactivo");
        jRInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton12ActionPerformed(evt);
            }
        });

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/Texfield.PNG"))); // NOI18N

        jtTelefono3.setBorder(null);
        try {
            jtTelefono3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtTelefono3.setMinimumSize(new java.awt.Dimension(80, 20));
        jtTelefono3.setPreferredSize(new java.awt.Dimension(80, 20));
        jtTelefono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTelefono3ActionPerformed(evt);
            }
        });
        jtTelefono3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTelefono3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtTelefono3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtTelefono3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtTelefono3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/Texfield.PNG"))); // NOI18N

        jtCelular3.setBorder(null);
        try {
            jtCelular3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtCelular3.setMinimumSize(new java.awt.Dimension(80, 20));
        jtCelular3.setPreferredSize(new java.awt.Dimension(80, 20));
        jtCelular3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCelular3ActionPerformed(evt);
            }
        });
        jtCelular3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCelular3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtCelular3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelImage3Layout.setVerticalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtCelular3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLEstado)
                        .addGap(63, 412, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel32hhh)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtNombre2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtApellido3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jRActivo)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRInactivo)))
                                .addContainerGap(79, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtDireccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtNombreRepresentante3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JLDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtNombreRepresentante3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtApellido3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32hhh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel43))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel42)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtDireccion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))))
                .addGap(7, 7, 7)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRInactivo)
                    .addComponent(jRActivo)
                    .addComponent(jLEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtImagen1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnAgregarImagen1.setBackground(new java.awt.Color(179, 212, 244));
        btnAgregarImagen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/add.png"))); // NOI18N
        btnAgregarImagen1.setText("Subir Foto");
        btnAgregarImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagen1ActionPerformed(evt);
            }
        });

        panelImage6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBNuevo.setBackground(new java.awt.Color(179, 212, 244));
        jBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/add_user.png"))); // NOI18N
        jBNuevo.setText("Nuevo");
        jBNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBNuevoMouseClicked(evt);
            }
        });
        jBNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBNuevoKeyPressed(evt);
            }
        });
        panelImage6.add(jBNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jBGuardar.setBackground(new java.awt.Color(179, 212, 244));
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/aceptar.png"))); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBGuardarMouseClicked(evt);
            }
        });
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        panelImage6.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 111, -1));

        jBModificar.setBackground(new java.awt.Color(179, 212, 244));
        jBModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/redo.png"))); // NOI18N
        jBModificar.setText("Modificar");
        jBModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBModificarMouseClicked(evt);
            }
        });
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });
        panelImage6.add(jBModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        jBCancelar.setBackground(new java.awt.Color(179, 212, 244));
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/cancelar.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCancelarMouseClicked(evt);
            }
        });
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        panelImage6.add(jBCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 111, -1));

        jBsalir.setBackground(new java.awt.Color(179, 212, 244));
        jBsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/cancel.png"))); // NOI18N
        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });
        panelImage6.add(jBsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 111, -1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 40, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jtImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnAgregarImagen1))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(panelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        panel1.addTab("Registro de proveedor", jPanel11);
        jPanel11.getAccessibleContext().setAccessibleName("Registrar Proveedores");

        panel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel3MouseClicked(evt);
            }
        });
        panel3.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsquedas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 12))); // NOI18N
        jPanel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Buscar");

        jXBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jXBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jXBuscarKeyTyped(evt);
            }
        });

        panel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane1.setMaximumSize(new java.awt.Dimension(5, 20));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(5, 20));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(5, 20));

        JTProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        JTProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTProveedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JTProveedorMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(JTProveedor);

        panel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(51, 51, 51)
                .addComponent(jXBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel46)
                .addContainerGap(441, Short.MAX_VALUE))
            .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jXBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel46))
                .addGap(32, 32, 32)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        panel3.add(jPanel18, java.awt.BorderLayout.CENTER);

        panel1.addTab("Buscar proveedor", panel3);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void centrarEnPantalla(){
          
          Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
          int x,y;
          int width,height;
          x = ( (int) dimensiones.getWidth() );
          y = ( (int) dimensiones.getHeight() );
          width = ( (int) getSize().getWidth() );
          height = ( (int) getSize().getHeight() );
          x = (x/2) - (width/2);
          y = (y/2) - (height/2);
          setBounds(x,y,width,height);

    }
    private void JTProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTProveedorMouseClicked
des_habilitar2();
habilitar2();
        String datos[]={"","","","","","","","",""};
        //captura le fila que seleccionamos en la tabla
        col=0;//para que solo selecione la primera columna lo inicializo en cero
        fila = this.JTProveedor.getSelectedRow();
        fil=fila;
        for(int i=0; i<9; i++){
            datos[i]=String.valueOf(JTProveedor.getValueAt(fil,i));//coordenadas y,x
        }
        //inicializando las variables
        fila=0;
        //enviamos los daots a los textFields y la textAreea
//      mostrar.setText(Codigo2);
//jtCodigo.setText(""+datos[1]);
        Codigo2=datos[1];
  

jtNombre2.setText(""+datos[2]);
jtNombreRepresentante3.setText(""+datos[3]);
jtApellido3.setText(""+datos[4]);
jtTelefono3.setText(""+datos[6]);
jtCelular3.setText(""+datos[7]);
jtDireccion3.setText(""+datos[5]);

Codigo_Estado=Codigo2;

String sql3="";
        //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
              // sql3="SELECT * FROM proveedor c WHERE c.Id_proveedor=Codigo2
 // sql3="SELECT * FROM proveedor c WHERE c.Nombre_Representante LIKE '%"+this.jXBuscar.getText()+"%'";
sql3="SELECT *FROM proveedor WHERE Id_proveedor= '"+Codigo2+"'";
                Imagen_mostrar(sql3);
        
habilitar2();
panel1.setSelectedIndex(0);
panel1.setTitleAt(0, "Modificar");
jBNuevo.setVisible(false);
jBGuardar.setVisible(false);
jBModificar.setVisible(true);

 jRActivo.setVisible(true);
   jRInactivo.setVisible(true);
   jLEstado.setVisible(true);
    }//GEN-LAST:event_JTProveedorMouseClicked

    private void JTProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTProveedorMouseEntered
 
        //sonido("boton");
        // TODO add your handling code here:
    
    }//GEN-LAST:event_JTProveedorMouseEntered

    private void jXBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXBuscarKeyReleased
        String sql3="";
        //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
        sql3="SELECT * FROM proveedor c WHERE c.Nombre_Proveedor LIKE '%"+this.jXBuscar.getText()+"%'";

        Buscar(sql3);
        //   ResultSet visualizar(String sql3);

        // TODO add your handling code here:
    }//GEN-LAST:event_jXBuscarKeyReleased

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        //System.exit( 0 );
         dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        //  busqueda_Proveedor();
        // TODO add your handling code here:
        
        jRActivo.setSelected(true);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCancelarMouseClicked
        Limpiar();
        des_habilitar();
        panel1.setTitleAt(0, "Registro de proveedor");
        jBNuevo.setVisible(true);
        jBGuardar.setVisible(true);
        jBModificar.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelarMouseClicked

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        // campos2
        validar2();
        jRActivo.setSelected(true);
//        modificar_Cambio();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBModificarMouseClicked
       /* panel1.setTitleAt(0, "Registro de proveedor");
        jBNuevo.setVisible(true);
        jBGuardar.setVisible(true);
        jBModificar.setVisible(false);*/
    
    }//GEN-LAST:event_jBModificarMouseClicked

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

   
        /*String url = JLDireccion.getT
        ext();
        if(url.trim().length() != 0 && nombre2.trim().length() != 0){

            // VerTabla v = new VerTabla();
            // v.visualizar_tabla(tabla);
        }
        else{
            JOptionPane.showMessageDialog(null, "No debe dejar los campos vacios: Nombre e Imagen");
        }*/
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGuardarMouseClicked
        //campos();
        validar();
  LLenar_Tabla();
    LLenar_Tabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBGuardarMouseClicked

    private void jBNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBNuevoKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jBNuevoKeyPressed

    private void jBNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNuevoMouseClicked
        habilitar();
        Limpiar();
 Buscar_Codigo();
        // validar();
        //campos();
        // jBNuevo.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNuevoMouseClicked

    private void btnAgregarImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagen1ActionPerformed
        
        Aumentar_Foto++;
        jtImagen1.setIcon(null);
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado=j.showOpenDialog(null);
        j.setCurrentDirectory(new File("C:\\Users\\Amilcar Cortez\\Documents\\Proveedores"));
        if(estado== JFileChooser.APPROVE_OPTION){
            try{
                fis=new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes=(int)j.getSelectedFile().length();
                try {
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance(jtImagen1.getWidth(),jtImagen1.getHeight(),Image.SCALE_DEFAULT);
                    jtImagen1.setIcon(new ImageIcon(icono));
//                    jtImagen2.setIcon(new ImageIcon(icono));
                    jtImagen1.updateUI();
                    ////////////////////////////////////
                    ruta = j.getSelectedFile().getAbsolutePath();
                    JLDireccion.setText(ruta);

                    /////////////////////////////////
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        }      // TODO add your handling code here:
        /*  JFileChooser j = new JFileChooser();
        j.setCurrentDirectory(new File("Imagenes/"));
        int ap = j.showOpenDialog(this);

        if(ap == JFileChooser.APPROVE_OPTION){
            ruta = j.getSelectedFile().getAbsolutePath();
            jtImagen1.setIcon(new ImageIcon(ruta));
            JLDireccion.setText(ruta);
        }*/
    }//GEN-LAST:event_btnAgregarImagen1ActionPerformed

    private void jtCelular3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCelular3KeyReleased
busqueda_Celular();
//busqueda_Telefono();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCelular3KeyReleased

    private void jtCelular3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCelular3ActionPerformed

 jtDireccion3.requestFocus();        
// TODO add your handling code here:
    }//GEN-LAST:event_jtCelular3ActionPerformed

    private void jtTelefono3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelefono3KeyReleased
busqueda_Telefono();
busqueda_Telefono2();
        /////////////
//if(jtTelefono3!=null){
//busqueda_Telefono();
//
     
        /////////////////////////////7
    }//GEN-LAST:event_jtTelefono3KeyReleased

    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton12ActionPerformed
        //Acitvo_Inactivo();
        Acitvo_Inactivo();
        if(evt.getSource().equals( jRInactivo)){
            //String sql3="";
            //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
            //sql3="SELECT * FROM tproveedor c WHERE c.crepresentante LIKE '%"+this.txt_buscar.getText()+"%'";

            // Buscar(sql3);
            Estado1="Inactivo";

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton12ActionPerformed

    private void jRActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRActivoActionPerformed
        if(evt.getSource().equals( jRActivo)){

            Estado1="Activo";

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jRActivoActionPerformed

    private void jtDireccion3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDireccion3KeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtDireccion3KeyTyped

    private void jtDireccion3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDireccion3KeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jtDireccion3KeyPressed

    private void jtDireccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDireccion1ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jtDireccion1ActionPerformed

    private void jtApellido3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellido3KeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')   && (car!=(char)KeyEvent.VK_SPACE))
        {       evt.consume();
        }
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellido3KeyTyped

    private void jtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellido1ActionPerformed
   jtTelefono3.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellido1ActionPerformed

    private void jtNombreRepresentante3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreRepresentante3KeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')   && (car!=(char)KeyEvent.VK_SPACE) )
        {       evt.consume();
        }
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreRepresentante3KeyTyped

    private void jtNombreRepresentante3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreRepresentante3KeyReleased
        //if(jtNombreRepresentante3!=null){
            //busqueda_Proveedor();
            //}
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreRepresentante3KeyReleased

    private void jtNombreRepresentante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreRepresentante1ActionPerformed
 jtApellido3.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreRepresentante1ActionPerformed

    private void jtNombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombre2KeyTyped
         char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombre2KeyTyped

    private void jtNombre2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombre2KeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombre2KeyReleased

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
        jtNombreRepresentante3.requestFocus();
    }//GEN-LAST:event_jtNombreActionPerformed

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
jXBuscar.requestFocus();   
 //jLabel1.setVisible(false);
  LLenar_Tabla();
     
// TODO add your handling code here:
    }//GEN-LAST:event_panel1MouseClicked

    private void panel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel3MouseClicked

       
// TODO add your handling code here:
    }//GEN-LAST:event_panel3MouseClicked

    private void jtTelefono3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelefono3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelefono3KeyPressed

    private void jtApellido3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellido3KeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_jtApellido3KeyReleased

    private void jtDireccion3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDireccion3KeyReleased

     
// TODO add your handling code here:
    }//GEN-LAST:event_jtDireccion3KeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jXBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXBuscarKeyTyped

 char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }        
// TODO add your handling code here:
    }//GEN-LAST:event_jXBuscarKeyTyped

    private void jtTelefono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTelefono3ActionPerformed
 jtCelular3.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelefono3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedor2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLDireccion;
    private javax.swing.JTable JTProveedor;
    private org.jdesktop.swingx.painter.AlphaPainter alphaPainter1;
    private javax.swing.JButton btnAgregarImagen1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBsalir;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32hhh;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JRadioButton jRActivo;
    private javax.swing.JRadioButton jRInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXSearchField jXBuscar;
    private org.edisoncor.gui.textField.TextFieldRoundImage jtApellido3;
    private javax.swing.JFormattedTextField jtCelular3;
    private org.edisoncor.gui.textField.TextFieldRoundImage jtDireccion3;
    private javax.swing.JLabel jtImagen1;
    private org.edisoncor.gui.textField.TextFieldRoundImage jtNombre2;
    private org.edisoncor.gui.textField.TextFieldRoundImage jtNombreRepresentante3;
    private javax.swing.JFormattedTextField jtTelefono3;
    private javax.swing.JTabbedPane panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.panel.Panel panel5;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage6;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables

    private File setSelectedFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
