package BaseImagen;

import Formularios.Menu1;
import com.integra.login.ControladorBitacora;
import com.integra.session.ModeloSession;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

public class Ventas2 extends javax.swing.JFrame {

    DefaultTableModel dt = new DefaultTableModel();
    DefaultTableModel dtt = new DefaultTableModel();
    Conexion conec = new Conexion();
  //  Connection cn=conec.getConnection();

    Statement stt;
    Statement st;

    String Stock = "";
    String Codigo = "";
    String Nombre = "";
    String Categoria = "";
    String Proveedor = "";
    String N_proveedor = "";
    String PrecioVenta = "";
    String Cantidad = "";
    String Ganancia = "";
    String cadena = "";
    int Ganancia5 = 0;
    String inventario = "";
    int Numero = 0;
    int colucna = 0, fila = 0, fil = 0, col;
    int CodigoDetalle = 0;
    String Codigo2 = "";
    String Codigo_Vemta = "";
    String Codigo_DEtalle = "";
    String Codigo_Venta2 = "";
    String Nombre_Prd = "";
    String CdProducto = "";
    String Nombre2 = "";
    String PrecioVent = "";
    String Cantidadd = "";
    String Cantidadd10 = "";
    String SubTotal = "";
    String CodProveedor = "";
    String CodDepartamento = "";
    String R_Stock = "";
    String Cantidad_resta = "", cadena1 = "", Stock5 = "";
    String Codigo_IV = "";
    String Cantidad3 = "";

    String prueva1 = "";
    String prueva2 = "";

    String Comparar1 = "";
    String Comparar2 = "";

    float precioventa = 0;
    double descuento = 0.10;
    int numero = 0;
    int CodigoEntero = 0;
    String Activo = "Activo";
    String RepresentanteCombox;
    String ProveedorCombox;
    DefaultTableModel miModelo;
    float Suma_totala = 0;
    int numero2 = 0;
    int numero3 = 0;
    int col1 = 0, fil1 = 0;
    int R_Stock2 = 0, R_Stock3 = 0, R_Stock4 = 0;
    int fila10 = 0;
    int fila11 = 0;

    int Costo_Total2 = 0;
    String Costo_Total = "";
    String Nombre_Cliente = "javier";
    
    int idUsuario ;
    int Aumento_Codigo = 0;
    ///modifica stok final
    int Stok_ColumnaF = 0;
    int Producto_F = 0;

    String[] cabecera = {"Stock", "Cd_Detalle", "Cd_Producto", "Numero", "Nombre", "Precio $ Venta ", "Cantidad", "Sub Total $"};
    String[][] data = {};

    java.util.Date nuevaFecha = null;
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

    float C1 = 0;
    float C2 = 0;
    float C3 = 0;
    float Descuento = 0.10F;
    float Suma_TT = 0;
    float Suma_TT2 = 0;
    int C4 = 0;
    int C5 = 0;

    float sumaa2 = 0;
    float sumaa3 = 0;
    String columna7 = "";
    String Code_P_Detalle2 = "";

    int Code_P_Detalle = 0;
    int Code_V_Detalle = 0;
    int Prod_Detalle = 0;
    int Cant_Detalle = 0;
    float Sub_detalle = 0;

    String Code_V_Detalle2 = "";
    String Prod_Detalle2 = "";
    String Cant_Detalle2 = "";
    String Sub_detalle2 = "";
    private Object codigo_usuario;
    String cadena10 = "";
    String cadena11 = "";
    String cadena12 = "";
    String cadena13 = "";
    String cadena14 = "";
    String cadena16 = "";

    String cadena20 = "";
    String cadena21 = "";
    String cadena40 = "";
    String cadena41 = "";
    String cadena50 = "";
    String cadena51 = "";
    int contador = 0;

    public Ventas2(int Id_Usuario) {
        idUsuario=Id_Usuario;
        initComponents();

        centrarEnPantalla();
        cargarCombo_proveedor();
        cargarCombo_Departamento();

        VerTabla v = new VerTabla();
        Componer_tabla();
        Componer_tabla_factura();
        //jcProveedores.addItem("Scribe"); 
        jtCantidad.setEnabled(false);

        jXBuscar.requestFocus();

        miModelo = new DefaultTableModel(data, cabecera);
        JTFactura.setModel(miModelo);
        Buscar_Codigo_Venta();
        Buscar_Codigo_Detalle();
        REducir_T_Proveedor();
        REducir_tabla();
        tabla_ajuste();
        Actualizar_tabla();
        jbAgregar.setEnabled(false);

        jBGuardar.setEnabled(false);
        jBCancelar.setEnabled(false);
        jBNuevo.setEnabled(false);
        //jBsalir1.setEnabled(false);
        jtcolumna.setEnabled(false);
        jtTotalFinal.setEditable(false);
        jtcolumna.setVisible(false);
        jbActualizar.setVisible(false);

    }
    
    ModeloSession mss;
    ControladorBitacora cb;
    
    public Ventas2(int Id_Usuario, ModeloSession mss) {
        idUsuario=Id_Usuario;
        initComponents();
        this.mss=mss;
        cb= new ControladorBitacora();
        centrarEnPantalla();
        cargarCombo_proveedor();
        cargarCombo_Departamento();

        VerTabla v = new VerTabla();
        Componer_tabla();
        Componer_tabla_factura();
        //jcProveedores.addItem("Scribe"); 
        jtCantidad.setEnabled(false);

        jXBuscar.requestFocus();

        miModelo = new DefaultTableModel(data, cabecera);
        JTFactura.setModel(miModelo);
        Buscar_Codigo_Venta();
        Buscar_Codigo_Detalle();
        REducir_T_Proveedor();
        REducir_tabla();
        tabla_ajuste();
        Actualizar_tabla();
        jbAgregar.setEnabled(false);

        jBGuardar.setEnabled(false);
        jBCancelar.setEnabled(false);
        jBNuevo.setEnabled(false);
        //jBsalir1.setEnabled(false);
        jtcolumna.setEnabled(false);
        jtTotalFinal.setEditable(false);
        jtcolumna.setVisible(false);
        jbActualizar.setVisible(false);

    }

    
    public void cargarCombo() {

    }

    public void cargarCombo_proveedor() {

        try {

            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();
            ResultSet rs = st.executeQuery("select * from proveedor where Estado='" + Activo + "' ");

            while (rs.next()) {

                jcProveedores.addItem(rs.getString(2));
            }
            conec.cerrarConeccion();
        } catch (Exception e) {
        }
    }

    public void cargarCombo_Departamento() {

        try {

            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();
            ResultSet rs = st.executeQuery("select * from departamento ");

            while (rs.next()) {

                jcDEpartamento.addItem(rs.getString(2));
            }
            conec.cerrarConeccion();
        } catch (Exception e) {
        }
    }

////////////////////////////////////TABLA BUSQUEDA
    public void Componer_tabla() {
        JTProveedor.setModel(dt);

        dt.addColumn("Código");
        dt.addColumn("Nombre");
        dt.addColumn("Categoria");
        dt.addColumn("Talla");
        dt.addColumn("Precio Venta $");
        dt.addColumn("Existencia ");

    }

    public void Buscar(String sql3) {

        /////////////////777
        dt.setRowCount(0);
        ResultSet rs;

        String codigo = "";
        String sqlIncre = "";
        sqlIncre = sql3;

        try {
            conec.abrirConeccion();
            Statement stm = conec.con1.createStatement();

 //Numero=0;
            //Numero=0;
            rs = stm.executeQuery(sqlIncre);

            // Object[] fila = new Object[17];
            while (rs.next()) {
               //Numero++;
                //Numero2++;
                Codigo = rs.getString(1);
                Nombre = rs.getString(2);
                //jtCantidad.setText(Codigo);
                Categoria = rs.getString(11);
                Proveedor = rs.getString(7);
      //PrecioVenta = rs.getString(7);   
                // Cantidad = rs.getString(25);
                Ganancia = rs.getString(17);

                String nomDepartamento = String.valueOf(jcDEpartamento.getSelectedItem());
                Statement st = conec.con1.createStatement();
                Statement stt = conec.con1.createStatement();
                ResultSet rss = st.executeQuery("select * from inventario where Producto_Id_Producto='" + Codigo + "'");
                ResultSet rsss = stt.executeQuery("select * from proveedor where Id_Proveedor='" + Proveedor + "'");

                while (rss.next()) {

                    inventario = rss.getString(2);
                    PrecioVenta = rss.getString(3);
                //cargarCombo_producto();
                    // N_proveedor= rsss.getString(2);
                }

                while (rsss.next()) {

                    N_proveedor = rsss.getString(2);
                }
          //int Ganancia1=Integer.parseInt(PrecioVenta);
                // int Ganancia2=Integer.parseInt(Ganancia);
                //Ganancia5=Ganancia1+Ganancia2;
                String Ganancia4 = String.valueOf(Ganancia5);

                dt.addRow(new Object[]{Codigo, Nombre, Categoria, Proveedor, PrecioVenta, inventario});

            }

            conec.cerrarConeccion();

        } catch (Exception e) {
      // JOptionPane.showMessageDialog(null,"Error al guardar","error",JOptionPane.ERROR_MESSAGE);

        }

    }

    public void ObteneCodigoProveedor() {

        try {
            conec.abrirConeccion();
            String nomProveedor = String.valueOf(jcProveedores.getSelectedItem());
            Statement st = conec.con1.createStatement();
            // Statement st = conec.con.createStatement();
            ResultSet rss = st.executeQuery("select Id_proveedor from proveedor where Nombre_Proveedor='" + nomProveedor + "'");

            while (rss.next()) {

                CodProveedor = rss.getString(1);
                //cargarCombo_producto();

            }

        } catch (Exception e) {
        }

    }

    public void ObteneCodigoDepartamento() {

        try {
            conec.abrirConeccion();
            String nomDepartamento = String.valueOf(jcDEpartamento.getSelectedItem());
            Statement st = conec.con1.createStatement();
            // Statement st = conec.con.createStatement();
            ResultSet rss = st.executeQuery("select Id_Departamento from departamento where Nombre='" + nomDepartamento + "'");

            while (rss.next()) {

                CodDepartamento = rss.getString(1);
                //cargarCombo_producto();

            }

        } catch (Exception e) {
        }

    }

    public void ObteneNombreProveedor() {

        try {
            conec.abrirConeccion();
            String nomDepartamento = String.valueOf(jcDEpartamento.getSelectedItem());
            Statement st = conec.con1.createStatement();
            // Statement st = conec.con.createStatement();
            ResultSet rss = st.executeQuery("select Id_Departamento from departamento where Nombre='" + nomDepartamento + "'");

            while (rss.next()) {

                CodDepartamento = rss.getString(1);
                //cargarCombo_producto();

            }

        } catch (Exception e) {
        }

    }

    public void campos() {

        int op = 0;
        String mensaje = "";

        if (this.jtCantidad.getText().equals("")) {
            op = 4;
            mensaje = mensaje + "Nombre                  Agregue un nombre\n";
            jtCantidad.requestFocus();

        } else {
            if (this.jtCantidad.getText().equals("0")) {
                op = 4;
                mensaje = mensaje + "Nombre                  Agregue un nombre\n";
                jtCantidad.requestFocus();

            } else {
                ComprovarStock();

                //Pasar_Fila();  
                jXBuscar.requestFocus();
            }

        }
    }

    public void campos2() {

        int op = 0;
        String mensaje = "";

        if (this.jtcolumna.getText().equals("")) {
            op = 4;
            mensaje = mensaje + "Nombre                  Agregue un nombre\n";
            jtCantidad.requestFocus();

        } else {
            if (this.jtCantidad.getText().equals("0")) {
                op = 4;
                mensaje = mensaje + "Nombre                  Agregue un nombre\n";
                jtCantidad.requestFocus();

            } else {
                Actualizar_Columna();

                //Pasar_Fila();  
            }

        }
    }
//////////////////////////////////////////////TABLA FACTURA

    public void Componer_tabla_factura() {
        JTFactura.setModel(dtt);

        dtt.addColumn("Stock");
        dtt.addColumn("Cd_Detalle");
        dtt.addColumn("Cd_Producto");
        dtt.addColumn("Numero");
        dtt.addColumn("Nombre");
        dtt.addColumn("Precio Venta");
        dtt.addColumn("Cantidad");

        dtt.addColumn("Sub Total");

    }

    public void tabla_ajuste() {

        TableColumnModel columnModel = JTProveedor.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(0).setPreferredWidth(1);
            columnModel.getColumn(1).setPreferredWidth(100);
            columnModel.getColumn(2).setPreferredWidth(60);
            columnModel.getColumn(3).setPreferredWidth(30);
            columnModel.getColumn(4).setPreferredWidth(5);
            columnModel.getColumn(5).setPreferredWidth(5);

        }
    }

    public void REducir_T_Proveedor() {

        JTProveedor.getColumnModel().getColumn(0).setMaxWidth(-5);

        JTProveedor.getColumnModel().getColumn(0).setMinWidth(-5);

        JTProveedor.getColumnModel().getColumn(0).setPreferredWidth(-5);

    }

    public void REducir_tabla() {

        JTFactura.getColumnModel().getColumn(1).setMaxWidth(-5);

        JTFactura.getColumnModel().getColumn(1).setMinWidth(-5);

        JTFactura.getColumnModel().getColumn(1).setPreferredWidth(-5);
        JTFactura.getColumnModel().getColumn(0).setMaxWidth(-5);

        JTFactura.getColumnModel().getColumn(0).setMinWidth(-5);

        JTFactura.getColumnModel().getColumn(0).setPreferredWidth(-5);
        JTFactura.getColumnModel().getColumn(2).setMaxWidth(-5);

        JTFactura.getColumnModel().getColumn(2).setMinWidth(-5);

        JTFactura.getColumnModel().getColumn(2).setPreferredWidth(-5);

        JTFactura.getColumnModel().getColumn(3).setMaxWidth(-5);

        JTFactura.getColumnModel().getColumn(3).setMinWidth(-5);

        JTFactura.getColumnModel().getColumn(3).setPreferredWidth(-5);

    }

    public void ComprovarStock() {
        jXBuscar.requestFocus();
        dtt.setRowCount(numero);
        ResultSet rss = null;

        String datos[] = {"", "", "", "", "", ""};
        //captura le fila que seleccionamos en la tabla
        colucna = 0;//para que solo selecione la primera columna lo inicializo en cero
        fila = this.JTProveedor.getSelectedRow();
        fil = fila;
        for (int i = 0; i < 6; i++) {
            datos[i] = String.valueOf(JTProveedor.getValueAt(fil, i));//coordenadas y,x
        }
        //inicializando las variables
        fila = 0;
        //enviamos los daots a los textFields y la textAreea
        //      mostrar.setText(Codigo2);
        //jtCodigo.setText(""+datos[1]);
        Object[] fila = new Object[6];
        String str = " 12 ";
     //numero3=Integer.parseInt(str.trim());

        Nombre_Prd = datos[0];
//             jt_ppp.setText(Nombre_Prd);
        Recuperar_Stock3();
    }

    public void Recuperar_Stock3() {  //////////////7ya
        R_Stock = "";
        String mensaje = "";

        try {
            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();

           //  String nomProveedor = String.valueOf(jcProducto.getSelectedItem());
            //ResultSet rs=stm.executeQuery("SELECT * FROM tiendadigna.proveedor p");
            ResultSet rs = st.executeQuery("select * from inventario  where Producto_Id_Producto=('" + Nombre_Prd + "')");
            while (rs.next()) {

                R_Stock = rs.getString(2);//Recupera stock actual antes de sumar lo comprado

                R_Stock2 = Integer.parseInt(R_Stock.trim());
                R_Stock3 = Integer.parseInt(Cantidadd.trim());

                if (R_Stock3 > R_Stock2) {
                    jtCantidad.setText("");
                    // mensaje = mensaje + "Nombre                  Agregue un apellido\n";
                } else {
                    if (R_Stock3 <= 0) {
                        jtCantidad.setText("");
                    } else {
                        Pasar_Fila();

                    }
                }
            }

            conec.cerrarConeccion();
        } catch (Exception e) {

        }

    }

    public void Pasar_Fila() {

        jXBuscar.requestFocus();
        dtt.setRowCount(numero);
        ResultSet rss = null;

        String datos[] = {"", "", "", "", "", ""};
        //captura le fila que seleccionamos en la tabla
        colucna = 0;//para que solo selecione la primera columna lo inicializo en cero
        fila = this.JTProveedor.getSelectedRow();
        fil = fila;
        for (int i = 0; i < 6; i++) {
            datos[i] = String.valueOf(JTProveedor.getValueAt(fil, i));//coordenadas y,x
        }
        //inicializando las variables
        fila = 0;
        //enviamos los daots a los textFields y la textAreea
        //      mostrar.setText(Codigo2);
        //jtCodigo.setText(""+datos[1]);
        Object[] fila = new Object[6];
        String str = " 12 ";
        //numero3=Integer.parseInt(str.trim());
        CdProducto = datos[0];
//             jt_ppp.setText(CdProducto);
        Nombre_Prd = datos[1];
        Nombre2 = datos[2];
        Stock = datos[5];
            // jt_ppp.setText(Nombre_Prd);
        //Cantidadd=datos[3];
        PrecioVent = datos[4];

        //int precio1=Integer.parseInt(PrecioVent.trim());
        float precio1 = Float.parseFloat(PrecioVent);
        Cantidadd = jtCantidad.getText();
        Cantidadd10 = jtCantidad.getText();
        // int precio2=Integer.parseInt(Cantidadd.trim());
        float precio2 = Float.parseFloat(Cantidadd);

         //miString = miString.valueOf (miDouble);//conversion de un double a un strinf
        precioventa = precio1 * precio2;

        // dtt.addRow(new Object[]{CodigoEntero,Codigo22,numero,Codigo2,PrecioVent,Cantidadd,"10%",precioventa}); 
        dtt.addRow(new Object[]{Stock, CodigoDetalle, CdProducto, Codigo_Venta2, Nombre_Prd, PrecioVent, Cantidadd, precioventa});

        // dtt.addRow(new Object[]{Stock,CodigoEntero,CdProducto,numero,Nombre_Prd,PrecioVent,Cantidadd,precioventa}); 
        numero = numero + 1;
        Suma_Totall();

        jtCantidad.setText("");
     //Conversion_Double();
//   jproveedorrr.setText(PrecioVent);
        // Object filaa [] = {CodigoEntero,Codigo22,numero,Codigo2,PrecioVent,Cantidadd,"10%",precioventa};
        Object filaa[] = {Stock, CodigoDetalle, CdProducto, Codigo_Venta2, Nombre_Prd, PrecioVent, Cantidadd, precioventa};
 //Agregando la fila a nuestro modelo de tabla
        miModelo.addRow(filaa);
        jBGuardar.setEnabled(true);
        jBCancelar.setEnabled(true);
        jBNuevo.setEnabled(true);
        jBsalir1.setEnabled(false);
        Recuperar_Stock();
        Aumentar_Codigo();
        Actualizar_tabla();
        contador = contador + 1;
    }

    public void Vaciar_Tabla() {
        int filass = JTFactura.getRowCount();
        for (int i = 0; i < filass; i++) {
            miModelo.removeRow(0); //Removiendo la fila de la tabla
        }//Fin del for
    }

    public void Suma_Totall() {
        /* Suma_totala=Suma_totala+precioventa;
         //Suma_totala=Suma_totala-descuento;
         cadena = String.valueOf(Suma_totala);
         jtTotalFinal.setText(cadena);
         */ //SUMA TOTAL DE ENTEROS

        Suma_TT = Suma_TT + precioventa;
        String cadena = Float.toString(Suma_TT);
        jtTotalFinal.setText(cadena);
        ljTotal_V.setText(cadena);

    }

    public void Conversion_Double() {
     //Suma_totala=Suma_totala+precioventa;
        //Suma_totala=Suma_totala-descuento;
        // cadena = String.valueOf(Suma_totala);
        int ii = 9;
        double d = (double) ii;
        double resta = 0.45;
        d = d - resta;

        cadena = cadena.valueOf(d);
        jtTotalFinal.setText(cadena);
    }

    public void Restar_producto() {
        jXBuscar.requestFocus();
        dtt.setRowCount(numero);
        ResultSet rss = null;

        String datos[] = {"", "", "", "", "", "", "", "", ""};
        //captura le fila que seleccionamos en la tabla
        colucna = 0;//para que solo selecione la primera columna lo inicializo en cero
        fila = this.JTFactura.getSelectedRow();
        fil = fila;

        for (int i = 0; i < 8; i++) {
            datos[i] = String.valueOf(JTFactura.getValueAt(fil, i));//coordenadas y,x
        }
        //inici

        Object[] fila = new Object[9];
        String str = " 12 ";
     //numero3=Integer.parseInt(str.trim());

        SubTotal = datos[7];
//         jfff.setText(SubTotal);
        numero = numero + 1;
        float SubTotal2 = Float.parseFloat(SubTotal);

        float SubTotal3 = 0;
        Suma_TT = Suma_TT - SubTotal2;
         //SubTotal3=Suma_TT-SubTotal2;

        cadena = String.valueOf(Suma_TT);
        jtTotalFinal.setText(cadena);
        String a = "";
        a = jtTotalFinal.getText();
        ljTotal_V.setText(a);
        //jtRestar.setText(cadena);
    }

    ////////////////////////////STOCK
    public void Recuperar_Stock() {/////////////////////7ya
        R_Stock = "";

        try {
            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();

           //  String nomProveedor = String.valueOf(jcProducto.getSelectedItem());
            //ResultSet rs=stm.executeQuery("SELECT * FROM tiendadigna.proveedor p");
            ResultSet rs = st.executeQuery("select * from inventario  where Producto_Id_Producto=('" + CdProducto + "')");
            while (rs.next()) {

                R_Stock = rs.getString(2);//Recupera stock actual antes de sumar lo comprado

                R_Stock2 = Integer.parseInt(R_Stock.trim());
                R_Stock3 = Integer.parseInt(Cantidadd.trim());
                R_Stock4 = R_Stock2 - R_Stock3;
                Stock5 = String.valueOf(R_Stock4);

                //  jtStokkkk.setText(Stock5);
                Actualizar_Stock();

            }
//Actualizar_Stock();

            conec.cerrarConeccion();
        } catch (Exception e) {

        }

    }

    public void Actualizar_Stock() {////////////////ya

     //float Finalisimo_Stock = Float.parseFloat(R_Stock);   
        try {

            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();

            st.executeUpdate("UPDATE inventario p SET  Cantidad=('" + R_Stock4 + "')  WHERE Producto_Id_Producto=('" + CdProducto + "')");

            conec.cerrarConeccion();
        } catch (Exception e) {

        }

    }

    public void SumaStock() {
        jXBuscar.requestFocus();
        dtt.setRowCount(numero);
        ResultSet rss = null;

        String datos[] = {"", "", "", "", "", "", "", ""};
        //captura le fila que seleccionamos en la tabla
        colucna = 0;//para que solo selecione la primera columna lo inicializo en cero
        fila = this.JTFactura.getSelectedRow();
        fil = fila;
        for (int i = 0; i < 8; i++) {
            datos[i] = String.valueOf(JTFactura.getValueAt(fil, i));//coordenadas y,x
        }

        fila = 0;

        Object[] fila = new Object[9];
        String str = " 12 ";

        Codigo_IV = datos[2];

        Cantidad3 = datos[6];
             //  jtRestar.setText(Cantidad3);
        //Cantidadd=datos[3];

    // Conversion_Double();
//   jproveedorrr.setText(PrecioVent);
        Recuperar_Stock2();
    }

    public void Recuperar_Stock2() {//////ya
        R_Stock = "";

        try {
            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();

           //  String nomProveedor = String.valueOf(jcProducto.getSelectedItem());
            //ResultSet rs=stm.executeQuery("SELECT * FROM tiendadigna.proveedor p");
            ResultSet rs = st.executeQuery("select * from inventario  where Producto_Id_Producto=('" + Codigo_IV + "')");
            while (rs.next()) {

                R_Stock = rs.getString(2);//Recupera stock actual antes de sumar lo comprado

                R_Stock2 = Integer.parseInt(R_Stock.trim());
                R_Stock3 = Integer.parseInt(Cantidad3.trim());//////////????????????????
                R_Stock4 = R_Stock2 + R_Stock3;
                Stock5 = String.valueOf(R_Stock4);

                Actualizar_Stock2();

            }
//Actualizar_Stock();

            conec.cerrarConeccion();
        } catch (Exception e) {

        }

    }

    public void Actualizar_Stock2() {///////////////////ya 

     //float Finalisimo_Stock = Float.parseFloat(R_Stock);   
        try {

            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();

            st.executeUpdate("UPDATE inventario p SET  Cantidad=('" + R_Stock4 + "')  WHERE Producto_Id_Producto=('" + Codigo_IV + "')");

            conec.cerrarConeccion();
        } catch (Exception e) {

        }

    }

//////////////////////////////////////////////////
    public void Buscar_Codigo_Venta() {
        ResultSet rs;

        String codigo = "";
        String sqlIncre = "";
        sqlIncre = "SELECT Id_ventas FROM ventas t ORDER BY Id_ventas";

        try {

            conec.abrirConeccion();
            Statement stm = conec.con1.createStatement();

            rs = stm.executeQuery(sqlIncre);
            if (rs.last() == false) {
                codigo = "9000000";
            } else {
                rs.last();
                codigo = rs.getString(1);
               //cadena = String.valueOf(codigo);
                //cadena= Integer.toString(codigo);

            }
            rs.close();
            //  stm.close();
            conec.cerrarConeccion();

            Generar_Codigo_Venta(codigo);
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        } catch (Exception e) {
            System.out.println("Error al Abrir tabla ");
        }
    }

    public void Generar_Codigo_Venta(String codigo) {
        String codigo_usuario = "";
        String cod_capturado = codigo.substring(1, 7);//captura los ultimos 7 valores del codigo
        int valor = Integer.parseInt(cod_capturado);  //lo convierte a entero
        int cod_generado = valor + 1;                 //le suma 1 para incrementarlo
        if (cod_generado < 10) {
            codigo_usuario = "900000" + cod_generado;
        } else if (cod_generado < 100) {
            codigo_usuario = "90000" + cod_generado;
        } else if (cod_generado < 1000) {
            codigo_usuario = "9000" + cod_generado;
        } else if (cod_generado < 10000) {
            codigo_usuario = "900" + cod_generado;
        } else if (cod_generado < 100000) {
            codigo_usuario = "90" + cod_generado;
        } else if (cod_generado < 1000000) {
            codigo_usuario = "10" + cod_generado;

        }

        //jtCodigo.setText("");
        jlCodigo.setText(codigo_usuario);
        Codigo_DEtalle = codigo_usuario;
        Codigo_Venta2 = codigo_usuario;

        CodigoEntero = Integer.parseInt(codigo_usuario);

    }

    public void guardar() {
        
        try {
            conec.abrirConeccion();
            Statement sttt = conec.con1.createStatement();
            
            sttt.executeUpdate("insert into ventas (Id_Ventas,Fecha_Ventas,Usuario_Id_Usuario,Total) "
                    + " values ('" + CodigoEntero + "','" + sqlDate + "','" + idUsuario + "','" + Suma_TT + "')");

            //   sttt.executeUpdate("insert into ventas (Id_Ventas,Fecha_Ventas,Usuario_Id_Usuario,Total) values('"+CodigoEntero+"','"+sqlDate+"','"+idUsuario+"','"+Suma_TT+"')");
            //JOptionPane.showMessageDialog(null, "Venta Realizada con Exito ");
            
            msm.ms_exito("Venta realizada con éxito");
            cb.insertarAccion(mss.getNombre(),"Realizó una venta");
            
            conec.cerrarConeccion();
            Guardar_Detalle();
            jBGuardar.setEnabled(false);
            jBCancelar.setEnabled(false);
            jBNuevo.setEnabled(false);
            jBsalir1.setEnabled(true);
            Buscar_Codigo_Venta();
            //Guardar_Detalle();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "La venta genero Error ", "error", JOptionPane.ERROR_MESSAGE);
            msm.ms_error("No se pudo realizar la venta");
        }
    }

/////////////////////////////////Tabla Detalle de Venta
    public void Buscar_Codigo_Detalle() {
        ResultSet rs;

        String codigo = "";
        String sqlIncre = "";
        sqlIncre = "SELECT Id_Detalle_Ventas FROM detalle_ventas_has_producto t ORDER BY Id_Detalle_Ventas";

        try {

            conec.abrirConeccion();
            Statement stm = conec.con1.createStatement();

            rs = stm.executeQuery(sqlIncre);
            if (rs.last() == false) {
                codigo = "8000000";
            } else {
                rs.last();
                codigo = rs.getString(1);
               //cadena = String.valueOf(codigo);
                //cadena= Integer.toString(codigo);

            }
            rs.close();
            //  stm.close();
            conec.cerrarConeccion();

            Generar_Codigo_Detalle(codigo);
        } catch (SQLException e) {
            System.out.println("Error al Abrir tabla ");
        } catch (Exception e) {
            System.out.println("Error al Abrir tabla ");
        }
    }

    public void Generar_Codigo_Detalle(String codigo) {
        String codigo_usuario2 = "";
        String cod_capturado = codigo.substring(1, 7);//captura los ultimos 7 valores del codigo
        int valor = Integer.parseInt(cod_capturado);  //lo convierte a entero
        int cod_generado = valor + 1;                 //le suma 1 para incrementarlo
        if (cod_generado < 10) {
            codigo_usuario2 = "800000" + cod_generado;
        } else if (cod_generado < 100) {
            codigo_usuario2 = "80000" + cod_generado;
        } else if (cod_generado < 1000) {
            codigo_usuario2 = "8000" + cod_generado;
        } else if (cod_generado < 10000) {
            codigo_usuario2 = "800" + cod_generado;
        } else if (cod_generado < 100000) {
            codigo_usuario2 = "80" + cod_generado;
        } else if (cod_generado < 1000000) {
            codigo_usuario2 = "9" + cod_generado;

        }

         //jtCodigo.setText("");
        //jlDetalle.setText(codigo_usuario2);
        Codigo_Vemta = codigo_usuario2;

        CodigoDetalle = Integer.parseInt(codigo_usuario2);

    }

    public void Aumentar_Codigo() {
        CodigoDetalle = CodigoDetalle + 1;

    }

    public void pasar_Detalle() {
        jXBuscar.requestFocus();
        dtt.setRowCount(numero);
        ResultSet rss = null;

        String datos[] = {"", "", "", "", "", "", "", "", ""};
        //captura le fila que seleccionamos en la tabla
        colucna = 0;//para que solo selecione la primera columna lo inicializo en cero
        fila = this.JTFactura.getSelectedRow();
        fil = fila;

        for (int i = 0; i < 8; i++) {
            datos[i] = String.valueOf(JTFactura.getValueAt(fil, i));//coordenadas y,x
        }
        //inici

        Object[] fila = new Object[9];
        String str = " 12 ";
     //numero3=Integer.parseInt(str.trim());

        int Code_P_Detalle = 0;
        int Prod_Detalle = 0;
        int Cant_Detalle = 0;
        float Sub_detalle = 0;

        SubTotal = datos[7];
        //jfff.setText(SubTotal);
        numero = numero + 1;
        float SubTotal2 = Float.parseFloat(SubTotal);

        float SubTotal3 = 0;
        Suma_TT = Suma_TT - SubTotal2;
         //SubTotal3=Suma_TT-SubTotal2;

        cadena = String.valueOf(Suma_TT);
        jtTotalFinal.setText(cadena);
        //jtRestar.setText(cadena);
    }
         ////////////////////////////////////////////////////////////////PASAR DETALLE

    public void Cancelar() {
        try {
            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();
            int a = 1;
            a = JTFactura.getRowCount() + 1;
            for (int i = 0; i < a; i++) {

                //   String datos[]={"","","","",""};
                //String datos2[]={"","","","",""};
                String datos[] = new String[a];
                String datos2[] = new String[a];

                datos[i] = String.valueOf(JTFactura.getValueAt(i, 2));
                prueva1 = datos[i];

                datos2[i] = String.valueOf(JTFactura.getValueAt(i, 0));
                prueva2 = datos2[i];
                // jtRestar.setText(prueva2);
                int pruev3 = Integer.parseInt(prueva1);
                int pruev4 = Integer.parseInt(prueva2);

                st.executeUpdate("UPDATE inventario d SET Cantidad=('" + pruev4 + "') WHERE Producto_Id_Producto=('" + pruev3 + "')");

                Suma_TT = 0;

            }

        } catch (Exception e) {

            System.out.print(e.getMessage());
        }
    }

    public void Guardar_Detalle() {

        try {

            int a = 1;
            a = JTFactura.getRowCount() + 1;
            for (int i = 0; i < a; i++) {

                String datos[] = new String[a];
                String datos2[] = new String[a];
                String datos3[] = new String[a];
                String datos4[] = new String[a];
                String datos5[] = new String[a];

                datos[i] = String.valueOf(JTFactura.getValueAt(i, 1));
                Code_P_Detalle2 = datos[i];

                datos2[i] = String.valueOf(JTFactura.getValueAt(i, 3));
                Code_V_Detalle2 = datos2[i];
                //jtdetalle.setText(Code_V_Detalle2);
                datos3[i] = String.valueOf(JTFactura.getValueAt(i, 2));
                Prod_Detalle2 = datos3[i];

                datos4[i] = String.valueOf(JTFactura.getValueAt(i, 6));
                Cant_Detalle2 = datos4[i];

                datos5[i] = String.valueOf(JTFactura.getValueAt(i, 7));
                Sub_detalle2 = datos5[i];

                // jtRestar.setText(prueva2);
                int Code_P_Detalle = Integer.parseInt(Code_P_Detalle2);
                int Code_V_Detalle = Integer.parseInt(Code_V_Detalle2);
                int Prod_Detalle = Integer.parseInt(Prod_Detalle2);
                int Cant_Detalle = Integer.parseInt(Cant_Detalle2);
                float Sub_detalle = Float.parseFloat(Sub_detalle2);

                conec.abrirConeccion();
                Statement stttt = conec.con1.createStatement();
                stttt.executeUpdate("insert into detalle_ventas_has_producto (Id_Detalle_Ventas,Ventas_Id_Ventas,Producto_Id_Producto,Cantidad_Producto,SubTotal) "
                        + " values ('" + Code_P_Detalle + "','" + Code_V_Detalle + "','" + Prod_Detalle + "','" + Cant_Detalle + "','" + Sub_detalle + "')");

      //   sttt.executeUpdate("insert into ventas (Id_Ventas,Fecha_Ventas,Usuario_Id_Usuario,Total) values('"+CodigoEntero+"','"+sqlDate+"','"+idUsuario+"','"+Suma_TT+"')");
                //JOptionPane.showMessageDialog(null, "Detalle guardado con Exito ");
                Suma_TT = 0;
            }

        } catch (Exception e) {

        }

    }
///////////////////////////PASAR IMAGEN

    public void Imagen_mostrar(String sql3) {

        /////////////////777
        //dt.setRowCount(0);
        ResultSet rs;

        String codigo = "";
        String sqlIncre = "";
        sqlIncre = sql3;

        try {
            conec.abrirConeccion();
            Statement stm = conec.con1.createStatement();

            Numero = 0;
            Numero = 0;
            // rs = stm.executeQuery(“SELECT FOTO FROM IMAGENES WHERE ID = 1”);
            rs = stm.executeQuery(sqlIncre);
            //rs = stm.executeQuery(sqlIncre);

            Object[] fila = new Object[21];
            while (rs.next()) {

                Blob blob = rs.getBlob(21);
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;

                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                //Image icono=ImageIO.read(setSelectedFile()).getScaledInstance(jtImagen1.getWidth(),jtImagen1.getHeight(),Image.SCALE_DEFAULT);
                  /*  jtImagen1.setIcon(new ImageIcon(icono));
                 jtImagen1.setIcon(new ImageIcon(icono));
                 jtImagen1.updateUI();*/
                ImageIcon imagen = new ImageIcon(img);

                Icon icono;
                icono = new ImageIcon(imagen.getImage().getScaledInstance(jtImagen1.getWidth(), jtImagen1.getHeight(), 100));
                //  ImageIcon icono = new ImageIcon(img); 
                // img.getScaledInstance(110, 11o, icono.getImage());
                jtImagen1.setIcon(icono);
                //jtImagen2.setIcon(icono);
                this.repaint();

                JLDireccion.setText(" ");
                //Icon icono= new imageIcon(imagen.getImagen().getScaledInstence()lblfon.)
                // fila[8] = new JLabel(icono);
                //Telefono2 = rs.getString(6);

            }

            conec.cerrarConeccion();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null,"Error","error",JOptionPane.ERROR_MESSAGE);

        }

    }

    ///////////////////////////////

    public void Dos_Productos() {

        String datos7[] = new String[6];
        //  String   cadena10 = String.valueOf(fila10);
        for (int i = 0; i < 6; i++) {
            datos7[i] = String.valueOf(JTProveedor.getValueAt(fila11, i));//coordenadas y,x
        }
        //inicializando las variables
        fila = 0;
        cadena20 = datos7[0];

        //  jtCompara.setText(cadena20);
        if (contador > 0) {
            Dos_Productos2();
        }

    }

    public void Dos_Productos2() {

        try {
            int b = 1;
            b = JTFactura.getRowCount() + 1;
            for (int f = 0; f < b; f++) {

                String datos30[] = new String[b];

                datos30[f] = String.valueOf(JTFactura.getValueAt(f, 2));
                cadena40 = datos30[f];

                if (cadena40.equals(cadena20)) {
                    jtCantidad.setEditable(false);
                }

            }
        } catch (Exception e) {

            System.out.print(e.getMessage());
        }

    }

    public void Comparar() {
        try {

            int fila = JTProveedor.getSelectedRow();
            String cadena10 = String.valueOf(fila);

            String datos2[] = new String[5];

            String cadena11 = "";
            datos2[fila] = String.valueOf(JTProveedor.getValueAt(fila, 0));
            Comparar2 = datos2[fila];

            int p1 = Integer.parseInt(Comparar2);
                  //cadena11=jtCantidad.getText();

            int a = 0;

            a = JTFactura.getRowCount();
            for (int i = 0; i < a; i++) {

                //   String datos[]={"","","","",""};
                //String datos2[]={"","","","",""};
                String datos[] = new String[a];

                datos[i] = String.valueOf(JTFactura.getValueAt(i, 2));
                prueva1 = datos[i];

                int p2 = Integer.parseInt(prueva1.trim());

                if (p1 == p2) {

                }

            }

                  // int pruev3=Integer.parseInt(prueva1);                
        } catch (Exception e) {

            System.out.print(e.getMessage());
        }
    }
 ////////////////////////////////TABLA

    public void Actualizar_Columna() {

        String datos6[] = new String[8];
        //  String   cadena10 = String.valueOf(fila10);
        for (int i = 0; i < 8; i++) {
            datos6[i] = String.valueOf(JTFactura.getValueAt(fila10, i));//coordenadas y,x
        }
        //inicializando las variables
        fila = 0;
        cadena11 = datos6[7];
        cadena12 = datos6[5];

        cadena13 = datos6[0];
        cadena14 = datos6[2];
        //cadena12=datos6[5];
        cadena50 = datos6[6];
        Producto_F = Integer.parseInt(cadena14.trim());

        int RestaCadena = 0;
        float cc1 = Float.parseFloat(cadena11);
        float cc2 = Float.parseFloat(cadena12);
        float cc3 = Float.parseFloat(cadena13);
        int Stok_Columna = Integer.parseInt(cadena13.trim());
        int Cadena60 = Integer.parseInt(cadena50.trim());
        int Cadena61 = Integer.parseInt(cadena13.trim());
        String cadena10 = String.valueOf(cadena11);
        String cadena15 = String.valueOf(cadena12);

        //jtcolumna.setEnabled(true);
        columna7 = jtcolumna.getText();
        int Cadena62 = Integer.parseInt(columna7.trim());
        RestaCadena = Cadena61 - Cadena60;
        if (Cadena62 <= Stok_Columna) {
            int Stok_Columna2 = Integer.parseInt(columna7.trim());
            float cc4 = Float.parseFloat(columna7);
            int cc5 = Integer.parseInt(columna7.trim());
            sumaa3 = cc2 * cc4;
            Suma_TT = Suma_TT - cc1;
            Suma_TT = Suma_TT + sumaa3;
            String Suma_TT2 = String.valueOf(Suma_TT);
            jtTotalFinal.setText(Suma_TT2);
            miModelo.setValueAt(cc5, fila10, 6);
            miModelo.setValueAt(sumaa3, fila10, 7);
            cc1 = 0;
            cc2 = 0;

            sumaa3 = 0;
            jtcolumna.setVisible(false);
            jbActualizar.setVisible(false);
            jtcolumna.setText("");

            Stok_Columna = Stok_Columna - Stok_Columna2;
            // miModelo.setValueAt(Stok_Columna, fila10, 0);
            Stok_ColumnaF = Stok_Columna;
            Actualizar_Stock2_Fila();
            Actualizar_tabla();
            String a = "";
            a = jtTotalFinal.getText();
            ljTotal_V.setText(a);
        } else {
            //JOptionPane.showMessageDialog(null, "Compra sobrepasa las existencias  ");
            msm.ms_alerta("Compra sobrepasa existencias");
            jtcolumna.setText("");

            int op = 0;
            String mensaje = "";
            jtcolumna.setText("");
            jtcolumna.requestFocus(true);
        }

    }

    public void Actualizar_Stock2_Fila() {///////////////////ya 

     //float Finalisimo_Stock = Float.parseFloat(R_Stock);   
        try {

            conec.abrirConeccion();
            Statement st = conec.con1.createStatement();

            st.executeUpdate("UPDATE inventario p SET  Cantidad=('" + Stok_ColumnaF + "')  WHERE Producto_Id_Producto=('" + Producto_F + "')");

            conec.cerrarConeccion();
        } catch (Exception e) {

        }

    }

    public void Actualizar_tabla() {
        //////////////////////7
        String sql3 = "";
        sql3 = "SELECT * FROM producto c WHERE Estado='" + Activo + "'";
        Buscar(sql3);
    }
///////////////////////////////////////////

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel4 = new org.edisoncor.gui.panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        jXBuscar = new org.jdesktop.swingx.JXSearchField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jcProveedores = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jcDEpartamento = new org.edisoncor.gui.comboBox.ComboBoxRound();
        jtImagen1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        JTProveedor = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jbAgregar = new javax.swing.JButton();
        jtCantidad = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel38 = new javax.swing.JLabel();
        ljTotal_V = new javax.swing.JLabel();
        JLDireccion = new javax.swing.JLabel();
        jdetalle = new org.edisoncor.gui.panel.Panel();
        panel11 = new org.edisoncor.gui.panel.Panel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTFactura = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        panel12 = new org.edisoncor.gui.panel.Panel();
        jlCodigo = new javax.swing.JLabel();
        panel14 = new org.edisoncor.gui.panel.Panel();
        jLabel40 = new javax.swing.JLabel();
        jtTotalFinal = new org.edisoncor.gui.textField.TextFieldRoundImage();
        panelImage6 = new org.edisoncor.gui.panel.PanelImage();
        jBNuevo = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBsalir1 = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jtcolumna = new org.edisoncor.gui.textField.TextFieldRoundImage();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(728, 486));
        setMinimumSize(new java.awt.Dimension(733, 564));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(733, 564));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setMaximumSize(new java.awt.Dimension(700, 486));
        panel1.setPreferredSize(new java.awt.Dimension(700, 486));

        panelRectTranslucido1.setColorPrimario(new java.awt.Color(0, 0, 102));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panelRectTranslucido1.setMaximumSize(new java.awt.Dimension(709, 40));
        panelRectTranslucido1.setMinimumSize(new java.awt.Dimension(709, 40));
        panelRectTranslucido1.setPreferredSize(new java.awt.Dimension(709, 50));
        panelRectTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Vani", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ventas");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelRectTranslucido1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 390, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button-close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRectTranslucido1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(700, 430));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(700, 430));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(700, 430));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        panel4.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel4.setColorSecundario(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(675, 146));
        jPanel1.setMinimumSize(new java.awt.Dimension(675, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(675, 146));

        jXBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jXBuscarKeyReleased(evt);
            }
        });

        jLabel33.setText("Producto");

        jLabel34.setText("Proveedor");

        jLabel35.setText("Departamento");

        jcProveedores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        jcProveedores.setName("jcProveedores"); // NOI18N
        jcProveedores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcProveedoresItemStateChanged(evt);
            }
        });

        jcDEpartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        jcDEpartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcDEpartamentoItemStateChanged(evt);
            }
        });

        jtImagen1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jcDEpartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcDEpartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane8.setAutoscrolls(true);
        jScrollPane8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane8.setMaximumSize(new java.awt.Dimension(675, 146));
        jScrollPane8.setMinimumSize(new java.awt.Dimension(675, 146));
        jScrollPane8.setPreferredSize(new java.awt.Dimension(675, 146));

        JTProveedor = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        JTProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        JTProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTProveedor.getTableHeader().setReorderingAllowed(false);
        JTProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTProveedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JTProveedorMouseEntered(evt);
            }
        });
        jScrollPane8.setViewportView(JTProveedor);

        jLabel36.setText("Cantidad");

        jbAgregar.setBackground(new java.awt.Color(179, 212, 244));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/check64.png"))); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCantidadKeyTyped(evt);
            }
        });

        jLabel38.setText("Total de venta $");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(34, 34, 34)
                        .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ljTotal_V, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JLDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addComponent(ljTotal_V, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38)))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("LISTADO", panel4);

        jdetalle.setColorPrimario(new java.awt.Color(255, 255, 255));
        jdetalle.setColorSecundario(new java.awt.Color(255, 255, 255));

        panel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane7.setAutoscrolls(true);
        jScrollPane7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane7.setMaximumSize(new java.awt.Dimension(5, 20));
        jScrollPane7.setMinimumSize(new java.awt.Dimension(5, 20));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(5, 20));

        JTFactura = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        JTFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTFactura.setAutoscrolls(false);
        JTFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTFactura.setDoubleBuffered(true);
        JTFactura.getTableHeader().setReorderingAllowed(false);
        JTFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTFacturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JTFacturaMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(JTFactura);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Codigo Factura");

        panel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel12.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel12.setColorSecundario(new java.awt.Color(255, 255, 255));

        jlCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCodigo.setText("Codigo");

        javax.swing.GroupLayout panel12Layout = new javax.swing.GroupLayout(panel12);
        panel12.setLayout(panel12Layout);
        panel12Layout.setHorizontalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
            .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlCodigo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel12Layout.setVerticalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlCodigo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        panel14.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel14.setColorSecundario(new java.awt.Color(255, 255, 255));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Precio Total $");

        jtTotalFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTotalFinaljtDireccion1ActionPerformed(evt);
            }
        });
        jtTotalFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTotalFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtTotalFinalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtTotalFinalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel14Layout = new javax.swing.GroupLayout(panel14);
        panel14.setLayout(panel14Layout);
        panel14Layout.setHorizontalGroup(
            panel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtTotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panel14Layout.setVerticalGroup(
            panel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jtTotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelImage6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBNuevo.setBackground(new java.awt.Color(179, 212, 244));
        jBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/EEliminar.png"))); // NOI18N
        jBNuevo.setText("Eliminar");
        jBNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBNuevoMouseClicked(evt);
            }
        });
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });
        jBNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBNuevoKeyPressed(evt);
            }
        });
        panelImage6.add(jBNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

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
        panelImage6.add(jBCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 100, -1));

        jBsalir1.setBackground(new java.awt.Color(179, 212, 244));
        jBsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/cancel.png"))); // NOI18N
        jBsalir1.setText("Salir");
        jBsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalir1ActionPerformed(evt);
            }
        });
        panelImage6.add(jBsalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 100, -1));

        jBGuardar.setBackground(new java.awt.Color(179, 212, 244));
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes 10/aceptar.png"))); // NOI18N
        jBGuardar.setText("Vender");
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
        panelImage6.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 100, -1));

        jbActualizar.setBackground(new java.awt.Color(179, 212, 244));
        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh.png"))); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jtcolumna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtcolumnaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtcolumnaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtcolumnaKeyTyped(evt);
            }
        });

        jLabel3.setText("Cantidad");

        javax.swing.GroupLayout jdetalleLayout = new javax.swing.GroupLayout(jdetalle);
        jdetalle.setLayout(jdetalleLayout);
        jdetalleLayout.setHorizontalGroup(
            jdetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdetalleLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(panel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jdetalleLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jdetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdetalleLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jdetalleLayout.createSequentialGroup()
                        .addComponent(panelImage6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdetalleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtcolumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229))))
        );
        jdetalleLayout.setVerticalGroup(
            jdetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdetalleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jdetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jdetalleLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel37)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jdetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdetalleLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(panel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdetalleLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jdetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbActualizar)
                            .addComponent(jLabel3)
                            .addComponent(jtcolumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FACTURACION", jdetalle);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JTProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTProveedorMouseClicked
//Pasar_Fila();
        fila11 = JTProveedor.getSelectedRow();
        jtCantidad.setEditable(true);
        Dos_Productos();

        ///////////////////////////77
        jtCantidad.setEnabled(true);
        jbAgregar.setEnabled(true);
        jtCantidad.requestFocus();

        String datos[] = {"", "", "", "", "", ""};
        //captura le fila que seleccionamos en la tabla
        col = 0;//para que solo selecione la primera columna lo inicializo en cero
        fila = this.JTProveedor.getSelectedRow();
        fil = fila;
        for (int i = 0; i < 6; i++) {
            datos[i] = String.valueOf(JTProveedor.getValueAt(fil, i));//coordenadas y,x
        }
        //inicializando las variables
        fila = 0;
        //enviamos los daots a los textFields y la textAreea
//      mostrar.setText(Codigo2);
//jtCodigo.setText(""+datos[1]);
        Codigo2 = datos[0];

//  jtimagen.setText(Codigo2);
        String sql3 = "";
        //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
        // sql3="SELECT * FROM proveedor c WHERE c.Id_proveedor=Codigo2
        // sql3="SELECT * FROM proveedor c WHERE c.Nombre_Representante LIKE '%"+this.jXBuscar.getText()+"%'";
        sql3 = "SELECT *FROM producto WHERE Id_Producto= '" + Codigo2 + "'";
        Imagen_mostrar(sql3);

        // Comparar();
    }//GEN-LAST:event_JTProveedorMouseClicked

    private void JTProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTProveedorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JTProveedorMouseEntered

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
     //Pasar_Fila();  

        Cantidadd = jtCantidad.getText();
        jbAgregar.setEnabled(false);
        campos();

    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jXBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXBuscarKeyReleased

        if (jcProveedores.getSelectedIndex() == 0 && jcDEpartamento.getSelectedIndex() == 0) {

            String sql3 = "";
            // sql3="SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%"+this.jXBuscar.getText()+"%'";
            sql3 = "SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%" + this.jXBuscar.getText() + "%'  and Estado='" + Activo + "'";
            Buscar(sql3);

         //ProveedorCombox=""; 
        } else {
            if (jcProveedores.getSelectedIndex() == 0 && jcDEpartamento.getSelectedIndex() != 0) {

                String nomDepartamento = String.valueOf(jcDEpartamento.getSelectedItem());
                // jproveedorrr.setText(nomDepartamento); 
                String sql4 = "";
        //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
                //  sql3="SELECT * FROM proveedor c WHERE  c.Nombre_Proveedor LIKE '%"+this.jXBuscar.getText()+"%')";
                //sql3="SELECT * FROM proveedor  WHERE Nombre_Representante='" + RepresentanteCombox + "')";
                sql4 = "SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%" + this.jXBuscar.getText() + "%'  and Id_Departamento='" + CodDepartamento + "' and Estado='" + Activo + "'";

                // sql3="SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%"+this.jXBuscar.getText()+"%'  and Id_proveedor='" + CodProveedor  + "'";
                Buscar(sql4);
         //ProveedorCombox=""; 

            } else {
                if (jcProveedores.getSelectedIndex() != 0 && jcDEpartamento.getSelectedIndex() == 0) {

                    String nomProveedor = String.valueOf(jcProveedores.getSelectedItem());
                    // jproveedorrr.setText(nomProveedor); 
                    String sql3 = "";
        //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
                    //  sql3="SELECT * FROM proveedor c WHERE  c.Nombre_Proveedor LIKE '%"+this.jXBuscar.getText()+"%')";
                    //sql3="SELECT * FROM proveedor  WHERE Nombre_Representante='" + RepresentanteCombox + "')";
                    sql3 = "SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%" + this.jXBuscar.getText() + "%'  and Id_proveedor='" + CodProveedor + "'and Estado='" + Activo + "'";

                    // sql3="SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%"+this.jXBuscar.getText()+"%'  and Id_Departamento='" + CodDepartamento + "'";
                    Buscar(sql3);
         //ProveedorCombox=""; 

                } else {
                    if (jcProveedores.getSelectedIndex() != 0 && jcDEpartamento.getSelectedIndex() != 0) {

                        String nomProveedor = String.valueOf(jcProveedores.getSelectedItem());
                        // jproveedorrr.setText(nomProveedor); 
                        String sql3 = "";
        //sql3="SELECT * FROM proveedor c WHERE c.nombreEmpresa LIKE '%"+this.txt_buscar.getText()+"%'";
                        //  sql3="SELECT * FROM proveedor c WHERE  c.Nombre_Proveedor LIKE '%"+this.jXBuscar.getText()+"%')";
                        //sql3="SELECT * FROM proveedor  WHERE Nombre_Representante='" + RepresentanteCombox + "')";
                        sql3 = "SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%" + this.jXBuscar.getText() + "%'  and Id_proveedor='" + CodProveedor + "'and Id_Departamento='" + CodDepartamento + "'and Estado='" + Activo + "'";

                        // sql3="SELECT * FROM producto c WHERE c.Nombre_Producto LIKE '%"+this.jXBuscar.getText()+"%'  and Id_Departamento='" + CodDepartamento + "'";
                        Buscar(sql3);
         //ProveedorCombox=""; 

                    }
                }
            }
        }


    }//GEN-LAST:event_jXBuscarKeyReleased


    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        Nombre_Prd = "";
        Nombre2 = "";
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jcDEpartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcDEpartamentoItemStateChanged

     // RepresentanteCombox = (String) jcDEpartamento.getSelectedItem();
        ObteneCodigoDepartamento();


    }//GEN-LAST:event_jcDEpartamentoItemStateChanged

    private void jtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCantidadKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            getToolkit().beep();

            evt.consume();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCantidadKeyTyped

    private void jtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCantidadKeyReleased

        char car = (char) evt.getKeyCode();

        //para el uso de la tecla enter
        if (car == evt.VK_ENTER && jtCantidad.getText().length() != 0) {
            Cantidadd = jtCantidad.getText();
            jbAgregar.setEnabled(false);

            campos();
            jtCantidad.setEnabled(false);
            jtCantidad.setText("");
        }
    }//GEN-LAST:event_jtCantidadKeyReleased

    private void jtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCantidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCantidadKeyPressed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        guardar();

        Vaciar_Tabla();

        //Vaciar_Tabla();
        //Clear_Table1();
        Suma_totala = 0;
        //Suma_totala=Suma_totala-descuento;
        cadena = String.valueOf(Suma_totala);
        jtTotalFinal.setText(cadena);
        // ljTotal_V.setText(cadena);
        String a = "";
        a = jtTotalFinal.getText();
        ljTotal_V.setText(a);
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
        //Guardar_Ventas();
        // guardar();

        // TODO add your handling code here:
    }//GEN-LAST:event_jBGuardarMouseClicked

    private void jBsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalir1ActionPerformed
        //System.exit( 0 );
        dispose();
        // Vaciar_Tabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBsalir1ActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        Cancelar();

        Vaciar_Tabla();
        Actualizar_tabla();
        //Clear_Table1();
        Suma_totala = 0;

        //Suma_totala=Suma_totala-descuento;
        cadena = String.valueOf(Suma_totala);
        jtTotalFinal.setText(cadena);
        ljTotal_V.setText(cadena);
        jBNuevo.setEnabled(false);
        jBGuardar.setEnabled(false);
        jBsalir1.setEnabled(true);
        jBCancelar.setEnabled(false);
        jbActualizar.setVisible(false);
        jtcolumna.setVisible(false);
        jtcolumna.setText("");

    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCancelarMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelarMouseClicked

    private void jBNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBNuevoKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jBNuevoKeyPressed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) JTFactura.getModel();
        int fila = JTFactura.getSelectedRow();
        if (fila >= 0) {
            Restar_producto();
            SumaStock();
            modelo.removeRow(fila);
            //eliminar();
            Actualizar_tabla();
        } else {
          //  JOptionPane.showMessageDialog(null, "No Selecciono ninguna fila");
            msm.ms_alerta("No selecciono ninguna fila");
        }

        jbActualizar.setVisible(false);
        jtcolumna.setVisible(false);
        jtcolumna.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNuevoMouseClicked

        // validar();
        //campos();
        // jBNuevo.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNuevoMouseClicked

    private void jtTotalFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTotalFinalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalFinalKeyTyped

    private void jtTotalFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTotalFinalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalFinalKeyReleased

    private void jtTotalFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTotalFinalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalFinalKeyPressed

    private void jtTotalFinaljtDireccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTotalFinaljtDireccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalFinaljtDireccion1ActionPerformed

    private void JTFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTFacturaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFacturaMouseEntered

    private void JTFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTFacturaMouseClicked

        // DefaultTableModel modelo = (DefaultTableModel) JTFactura.getModel();
        fila10 = JTFactura.getSelectedRow();
        jtcolumna.setEnabled(true);
        jtcolumna.requestFocus(true);
        //  miModelo.setValueAt(suma, 1, 1);
        jtcolumna.setVisible(true);
        jbActualizar.setVisible(true);
        jtcolumna.requestFocus();
    }//GEN-LAST:event_JTFacturaMouseClicked

    private void jcProveedoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcProveedoresItemStateChanged
        ObteneCodigoProveedor();
        //Vaciar_Tabla();
        // Clear_Table1();

        /*  int a=0;

         ProveedorCombox="";
         jproveedorrr.setText("");

         //a =  jcProveedores.getSelectedIndex();

         if (jcProveedores.getSelectedIndex()==1){
         jproveedorrr.setText(ProveedorCombox);
         }
         */

    }//GEN-LAST:event_jcProveedoresItemStateChanged

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed

        if (this.jtcolumna.getText().equals("")) {

            //ensaje = mensaje + "Nombre                  Agregue un nombre\n";
            jtcolumna.requestFocus();

        } else {
            if (this.jtcolumna.getText().equals("0")) {

                //ensaje = mensaje + "Nombre                  Agregue un nombre\n";
                jtcolumna.requestFocus();

            } else {
                //  Actualizar_Columna();

                campos2();
                jtcolumna.setEnabled(true);

            }

        }

// TODO add your handling code here:
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jtcolumnaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtcolumnaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtcolumnaKeyPressed

    private void jtcolumnaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtcolumnaKeyReleased

        char car = (char) evt.getKeyCode();

        //para el uso de la tecla enter
        if (car == evt.VK_ENTER && jtcolumna.getText().length() != 0) {

            campos2();

        }

// TODO add your handling code here:
    }//GEN-LAST:event_jtcolumnaKeyReleased

    private void jtcolumnaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtcolumnaKeyTyped
        char c = evt.getKeyChar();

        // if(Character.isLetter(c)) {
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            getToolkit().beep();

            evt.consume();

        }

// TODO add your handling code here:
    }//GEN-LAST:event_jtcolumnaKeyTyped

    /**
     * @param args the command line arguments
     */
    public void centrarEnPantalla() {

        Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
        int x, y;
        int width, height;
        x = ((int) dimensiones.getWidth());
        y = ((int) dimensiones.getHeight());
        width = ((int) getSize().getWidth());
        height = ((int) getSize().getHeight());
        x = (x / 2) - (width / 2);
        y = (y / 2) - (height / 2);
        setBounds(x, y, width, height);

    }
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Ventas2().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLDireccion;
    private javax.swing.JTable JTFactura;
    private javax.swing.JTable JTProveedor;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBsalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXSearchField jXBuscar;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAgregar;
    private org.edisoncor.gui.comboBox.ComboBoxRound jcDEpartamento;
    private org.edisoncor.gui.comboBox.ComboBoxRound jcProveedores;
    private org.edisoncor.gui.panel.Panel jdetalle;
    private javax.swing.JLabel jlCodigo;
    private org.edisoncor.gui.textField.TextFieldRoundImage jtCantidad;
    private javax.swing.JLabel jtImagen1;
    private org.edisoncor.gui.textField.TextFieldRoundImage jtTotalFinal;
    private org.edisoncor.gui.textField.TextFieldRoundImage jtcolumna;
    private javax.swing.JLabel ljTotal_V;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel11;
    private org.edisoncor.gui.panel.Panel panel12;
    private org.edisoncor.gui.panel.Panel panel14;
    private org.edisoncor.gui.panel.Panel panel4;
    private org.edisoncor.gui.panel.PanelImage panelImage6;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables

    private void keyTyped() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void isCellEditable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
