package Formularios;

import presentacion.*;
import BaseImagen.Proveedor2;
import BaseImagen.Ventas2;
import Clases.Calendario;
import Clases.Datos_Regisro_Producto;
import Control.msm;
import com.UniqueRun;
import Datos.Conexion;
//import static Formularios.Menu1.Id_Usuario;
import com.integra.backup.BackupMySQL;
//import com.integra.backup.BackupMySQL;
import com.integra.backup.BackupMySQL;
import com.integra.backup.BackupView;
import com.integra.login.ControladorBitacora;
import com.integra.session.ModeloSession;
import com.integra.users.ModeloUsuario;
import java.awt.Rectangle;
//import java.lang.System.exit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.edisoncor.gui.label.LabelTask;
import presentacion.ahorasi;
import presentacion.registro_usuarios;

public class Menu1 extends javax.swing.JFrame implements Runnable {

    BackupMySQL bmsql = new BackupMySQL();
    int cont = 0;
    private ModeloSession mss;
    private boolean logged;
    String Menu1;
    Conexion con = new Conexion();
    ModeloUsuario ml2 = new ModeloUsuario();
    private String currentUser = "";

    //BITACORA
    private Inicio_Sesion login;

    //BITACORA
    private ControladorBitacora cb;
//    public Menu1(ModeloUsuario ml) {

    //Varibles para el uso de notificaciones
    Calendario calendario = new Calendario();
    Datos_Regisro_Producto Datos = new Datos_Regisro_Producto();
    static int contNoti = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
    Vector v, idProveedor, fecha_pago, Nombre_Empresa;
    Thread notificacion = new Thread(this);
    int y = 45;//esta variable lleva la posición en el eje "y" para posicionar las notificaciones

    // variables para cambiar de paquete
    String paquete = "Iconos";

    //Variables para uso de compras
    static int Id_Usuario = 0;

    public Menu1() {
        initComponents();

        cb = new ControladorBitacora();

//        ml2=ml;
//        
//        jlabelnomusu.setText(con.traerempleado(ml.getIdEmpleado()));       
        mss = new ModeloSession();
        logged = false;
        inactiveOptions();
        notificacion.start();
        cargarPagosProximos();
        ProductosProximosAgotarse();
        InsertarDepartamentos();

        InsertarMarcaCelular();
        InsertarMarcaPerfume();
        InsertarMarcaRopa();
        InsertarMarcaZapatos();

        InsertarSeccionPerfume();
        InsertarSeccionRopa();
        InsertarSeccionCalzado();
        InsertarSeccionCelular();

        InsertarCategoriaCelular();
        InsertarCategoriaPerfume();
        InsertarCategoriaRopa();
        InsertarCategoriaCalzado();

        InsertarTallaCalzado();
        InsertarTallaRopa();

        InsertarTelaRopa();
        InsertarCuellosRopa();
        InsertarEstiloRopa();
        InsertarColorRopa();

        InsertarAromaPerfume();
        InsertarContenidoPerfume();
        InsertarColorPerfume();

        InsertarColorCalzado();

        InsertarSistemaCelular();
        InsertarColorCelular();
        InsertarModeloCelular();
        InsertarMemoriaECelular();
        InsertarMemoriaICelular();

    }

    //Funciones baltazar
    public void cargarPagosProximos() {
        fecha_pago = new Vector();
        idProveedor = new Vector();
        Nombre_Empresa = new Vector();
        int n;
        LabelTask[] label = new LabelTask[11];
        Date ahora, despues;

        int dia_sumar_restar;
        int dia_ahora, año_ahora;
        int dia_despues, año_despues, mes_despues;

        String Fecha_D_1;//Fecha posterior 1 capturada; esta es la que calcularemos para inicios de año proximo
        Date Fecha_D_2;//Fecha posterior 2 capturada; esta la obtenemos en el primer calculo

        ahora = new Date();
        dia_ahora = calendario.Fecha_Secciones(ahora, 0);
        System.out.println("dia_ahora " + dia_ahora);
        año_ahora = calendario.Fecha_Secciones(ahora, 2);
        dia_sumar_restar = calendario.Dia_Mes();

        System.out.println("dia del mes -------> " + dia_sumar_restar);

        despues = calendario.sumarRestarDiasFecha(new Date(), dia_sumar_restar);
        Fecha_D_2 = despues;
        dia_despues = calendario.Fecha_Secciones(despues, 0);
        System.out.println("dia_despes " + dia_despues);
        mes_despues = calendario.Fecha_Secciones(despues, 1);
        año_despues = calendario.Fecha_Secciones(despues, 2);

        System.out.println("ahora " + calendario.Fecha(ahora));
        System.out.println("despues " + calendario.Fecha(despues));

        dia_sumar_restar = dia_sumar_restar - dia_ahora;
        System.out.println("dia sumar_restar " + dia_sumar_restar);
        despues = calendario.sumarRestarDiasFecha(new Date(), dia_sumar_restar);
        System.out.println("despues actualizada " + calendario.Fecha(despues));

        Datos.abrirConexion();
        try {
            //obtenemos el numero de compras proximas de pago
            System.out.println("ahoa" + calendario.Fecha(ahora));
            System.out.println("despu" + calendario.Fecha(despues));

            n = Datos.nFechaPagoCompra(calendario.Fecha(ahora), calendario.Fecha(despues));
            System.out.println("pagos=" + n);
            if (n <= 4) {
                System.out.println("" + calendario.Fecha(ahora));
                System.out.println("" + calendario.Fecha(despues));
                Datos.abrirConexion();
                Datos.buscarFechaPagoCompra(calendario.Fecha(ahora), calendario.Fecha(despues));
                while (Datos.rs.next()) {
                    //total = mCom.rs.getFloat("total");

                    fecha_pago.add(Datos.rs.getString("Fecha_Pago"));
                    idProveedor.add(Datos.rs.getInt("Id_Proveedor"));

                }
                System.out.println("vevvvvvvvvv->" + idProveedor.size());
                Datos.cerrarConexion();
                Datos.abrirConexion();
                for (int i = 0; i < idProveedor.size(); i++) {
                    System.out.println("");
                    System.out.println("////////////////////////////////////////////");
                    System.out.println("idProveedor=" + idProveedor.get(i));
                    Nombre_Empresa.add(BuscarNombre("select * from proveedor where Id_Proveedor=" + idProveedor.get(i) + "", "proveedor"));
                    System.out.println("nombre_empresa" + Nombre_Empresa.get(i));

                    contNoti++;
                    label[contNoti] = new LabelTask();
                    label[contNoti].setForeground(new java.awt.Color(0, 0, 0));
                    label[contNoti].setCategoryFont(new java.awt.Font("Arial", 1, 16));
                    label[contNoti].setCategorySmallFont(new java.awt.Font("Arial", 0, 12));
                    label[contNoti].setBounds(new Rectangle(0, y, 235, 80));
                    label[contNoti].setText("Pagos proximos");
                    label[contNoti].setDescription("" + Nombre_Empresa.get(i) + "\n Fecha " + fecha_pago.get(i));
                    Notificacion_Panel.add(label[contNoti]);
                    y += 50;

                }
                Datos.cerrarConexion();
            } else {
                contNoti++;
                label[contNoti] = new LabelTask();
                label[contNoti].setForeground(new java.awt.Color(0, 0, 0));
                label[contNoti].setCategoryFont(new java.awt.Font("Arial", 1, 16));
                label[contNoti].setCategorySmallFont(new java.awt.Font("Arial", 0, 12));
                label[contNoti].setBounds(new Rectangle(0, y, 235, 80));
                label[contNoti].setText("Tiene: " + n + " compras");
                label[contNoti].setDescription("pendientes de pagar");
                Notificacion_Panel.add(label[contNoti]);
                y += 50;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Datos.cerrarConexion();

    }

    public void cargarPagosProximos2() {
        fecha_pago = new Vector();
        idProveedor = new Vector();
        Nombre_Empresa = new Vector();
        int n;
        LabelTask[] label = new LabelTask[11];
        Date ahora, despues;

        int dia_sumar_restar;
        int dia_ahora, año_ahora;
        int dia_despues, año_despues, mes_despues;

        String Fecha_D_1;//Fecha posterior 1 capturada; esta es la que calcularemos para inicios de año proximo
        Date Fecha_D_2;//Fecha posterior 2 capturada; esta la obtenemos en el primer calculo

        ahora = new Date();
        dia_ahora = calendario.Fecha_Secciones(ahora, 0);
        dia_sumar_restar = calendario.Dia_Mes();
        System.out.println("dia del mes ------->-- " + dia_sumar_restar);

        despues = calendario.sumarRestarDiasFecha(new Date(), dia_sumar_restar);
        Fecha_D_2 = despues;

        dia_sumar_restar = dia_sumar_restar - dia_ahora;
        System.out.println("dia sumar_restar " + dia_sumar_restar);
        dia_sumar_restar = dia_sumar_restar + 1;
        ahora = calendario.sumarRestarDiasFecha(new Date(), dia_sumar_restar);
        System.out.println("ahora actualizada " + calendario.Fecha(ahora));

        Datos.abrirConexion();
        try {
            //obtenemos el numero de compras proximas de pago
            System.out.println("ahoaaaaaaaa" + calendario.Fecha(ahora));
            System.out.println("despuuuuuuu" + calendario.Fecha(Fecha_D_2));

            n = Datos.nFechaPagoCompra(calendario.Fecha(ahora), calendario.Fecha(Fecha_D_2));
            System.out.println("pagos22=" + n);
            if (n <= 3) {
                System.out.println("" + calendario.Fecha(ahora));
                System.out.println("" + calendario.Fecha(Fecha_D_2));
                Datos.abrirConexion();
                Datos.buscarFechaPagoCompra(calendario.Fecha(ahora), calendario.Fecha(Fecha_D_2));
                while (Datos.rs.next()) {
                    //total = mCom.rs.getFloat("total");

                    fecha_pago.add(Datos.rs.getString("Fecha_Pago"));
                    idProveedor.add(Datos.rs.getInt("Id_Proveedor"));

                }
                Datos.cerrarConexion();
                Datos.abrirConexion();
                for (int i = 0; i < idProveedor.size(); i++) {
                    System.out.println("");
                    System.out.println("////////////////////////////////////////////");
                    System.out.println("idProveedor=" + idProveedor.get(i));
                    Nombre_Empresa.add(BuscarNombre("select * from proveedor where Id_Proveedor=" + idProveedor.get(i) + "", "proveedor"));
                    System.out.println("nombre_empresa" + Nombre_Empresa.get(i));

                    contNoti++;
                    label[contNoti] = new LabelTask();
                    label[contNoti].setForeground(new java.awt.Color(0, 0, 0));
                    label[contNoti].setCategoryFont(new java.awt.Font("Arial", 1, 16));
                    label[contNoti].setCategorySmallFont(new java.awt.Font("Arial", 0, 12));
                    label[contNoti].setBounds(new Rectangle(0, y, 235, 80));
                    label[contNoti].setText("Pagos proximos");
                    label[contNoti].setDescription("" + Nombre_Empresa.get(i) + "\n Fecha " + fecha_pago.get(i));
                    Notificacion_Panel.add(label[contNoti]);
                    y += 50;

                }
                Datos.cerrarConexion();
            } else {
                contNoti++;
                label[contNoti] = new LabelTask();
                label[contNoti].setForeground(new java.awt.Color(0, 0, 0));
                label[contNoti].setCategoryFont(new java.awt.Font("Arial", 1, 16));
                label[contNoti].setCategorySmallFont(new java.awt.Font("Arial", 0, 12));
                label[contNoti].setBounds(new Rectangle(0, y, 235, 80));
                label[contNoti].setText("Tiene: " + n + " compras");
                label[contNoti].setDescription("pendientes de pagar");
                Notificacion_Panel.add(label[contNoti]);
                y += 50;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Datos.cerrarConexion();
    }

    public void ProductosProximosAgotarse() {
        String nombre_producto = "";
        int cantidad, idPresentacion;
        LabelTask[] label = new LabelTask[11];
        int n;
        Datos.abrirConexion();
        try {
            //obtenemos el numero de productos proximas a agotarse
            n = Datos.nProductosProximosAgotarse();
            System.out.println("agotase" + n);
            if (n <= 3) {
                Datos.buscarProductosProximosAgotarse();
                while (Datos.rs.next()) {
                    cantidad = Datos.rs.getInt("Cantidad");
                    nombre_producto = Datos.rs.getString("Nombre_Producto");
                    contNoti++;
                    label[contNoti] = new LabelTask();
                    label[contNoti].setForeground(new java.awt.Color(0, 0, 0));
                    label[contNoti].setCategoryFont(new java.awt.Font("Arial", 1, 16));
                    label[contNoti].setCategorySmallFont(new java.awt.Font("Arial", 0, 12));
                    label[contNoti].setBounds(new Rectangle(0, y, 235, 80));
                    label[contNoti].setText(nombre_producto);
                    if (cantidad == 1) {
                        label[contNoti].setDescription("Tiene: " + cantidad + " unidad");
                    } else if (cantidad == 0) {
                        label[contNoti].setDescription("Producto agotado!");
                    } else {
                        label[contNoti].setDescription("Tiene: " + cantidad + " unidades");
                    }
                    Notificacion_Panel.add(label[contNoti]);
                    y += 50;
                }
            } else {
                contNoti++;
                label[contNoti] = new LabelTask();
                label[contNoti].setForeground(new java.awt.Color(0, 0, 0));
                label[contNoti].setCategoryFont(new java.awt.Font("Arial", 1, 16));
                label[contNoti].setCategorySmallFont(new java.awt.Font("Arial", 0, 12));
                label[contNoti].setBounds(new Rectangle(0, y, 235, 80));
                label[contNoti].setText("Existen: " + n + " productos");
                label[contNoti].setDescription("próximos a agotarse");
                Notificacion_Panel.add(label[contNoti]);
                y += 50;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Datos.cerrarConexion();
    }

    public int BuscarID(String SQL, String Tabla) {
        int id = 0;
        try {
            Datos.Buscar(SQL, "" + Tabla);
            while (Datos.rs.next()) {
                id = Datos.rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.print("Buscar ID Error al buscar en Tabla " + Tabla);
        }
        return id;
    }

    public String BuscarNombre(String SQL, String Tabla) {
        String Nombre = "";
        try {
            Datos.Buscar(SQL, "" + Tabla);
            while (Datos.rs.next()) {
                Nombre = Datos.rs.getString(2);
            }
        } catch (Exception e) {
            System.out.print("BuscarNombre Error al buscar en Tabla " + Tabla);
        }
        return Nombre;
    }

    public void InsertarDepartamentos() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0;
        v.add("CELULARES");
        v.add("PERFUMES");
        v.add("ROPA");
        v.add("ZAPATOS");

        Datos.abrirConexion();
        valor = BuscarID("select * from departamento", "departamento");
        System.out.println("valor" + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("departamento", "Id_Departamento,Nombre", "" + id + ",'" + v.get(i) + "'");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarMarcaZapatos() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int talla, id = 0, departamento = 4;
        v.add("ANNE KLEIN");
        v.add("CARLO ROSSETTI");
        v.add("EUROSOFT");
        v.add("FLEXI");
        v.add("HAVAIANAS");
        v.add("JESSICA SIMPSON");
        v.add("KENNETH COLE");
        v.add("LUCKY BRAND");
        v.add("MARC FISHER");
        v.add("NEW BALANCE");
        v.add("NICOLLE");
        v.add("NIKE");
        v.add("NINE WEST");
        v.add("ORANGE");
        v.add("SABRINA");
        v.add("TOMMY HILFIGER");
        v.add("XTI");
        v.add("NAUTICA");
        v.add("GENTS");
        v.add("MICHAEL KORS");
        v.add("DOCKERS");
        v.add("DIMITRI");
        v.add("VANS");
        System.out.println("vector de zapatos " + v.size());

        Datos.abrirConexion();
        talla = BuscarID("select * from marca where Id_Departamento=" + departamento + "", "marca");
        id = BuscarID("select * from marca", "marca");
        System.out.println("talla " + talla);
        Datos.cerrarConexion();
        if (talla == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("marca", "Id_Marca,Nombre_Marca,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarMarcaRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;
        // CAMISAS
        v.add("ADIDAS");
        v.add("COLUMBIA");
        v.add("CUBAVERA");
        v.add("DIMITRI");
        v.add("GENTS");
        v.add("DOCKERS");
        v.add("GEORGE & MARTHA");
        v.add("IZOD");
        v.add("JACK & JONES");
        v.add("LEE ");
        v.add("LEVIS");
        v.add("MERCH");
        v.add("MICHAEL KORS");
        v.add("NAUTICA");
        v.add("OSCAR DE LA RENTA");
        v.add("PENGUIN");
        v.add("PIEERRE CARDIN");
        v.add("TEAM MATE");
        v.add("VAN HEUSEN");
        v.add("WARNING");
        v.add("WILSON");
        v.add("DIMITRI");
        v.add("VANS");

        //JEANS
        //v.add("LEVIS");
        //v.add("LEE");
        //v.add("IZOD");
        v.add("MAVI");
        // v.add("NAUTICA");
        v.add("PEPE REVOLUTION");

        // PANTALON DE VESTIR
        v.add("ARTECA");
        //v.add("DIMITRI");
        //v.add("DOCKERS");
        v.add("GEOFFREY BEENE");
        //v.add("IZOD");
        v.add("JACK & JONES");
        v.add("LAUREN");
        //v.add("LEE");
        v.add("MANHATTAN");
        v.add("MODELFIT");
        //v.add("NAUTICA");
        //v.add("PIERRE CARDIN");
        v.add("UNEXPECTED");
        //v.add("VAN HEUSEN");

        //ROPA INTERIOR
        v.add("SAMIA");
        v.add("HANES");
        //v.add("VAN HEUSEN");
        //v.add("WARNING");
        v.add("JOCKEY");
        v.add("FRUIT OT THE LOOM");
        //v.add("IZOD");
        v.add("JACK & JONES");

        System.out.println("vector de ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from marca where Id_Departamento=" + departamento + "", "marca");
        id = BuscarID("select * from marca", "marca");
        System.out.println("marca " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("marca", "Id_Marca,Nombre_Marca,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarMarcaPerfume() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 2;

        v.add("AGATHA RUIZ DE LA PRADA");
        v.add("ANTONIO BANDERAS");
        v.add("AQUARIUS");
        v.add("AZZARO");
        v.add("BAYLIS & HARDING");
        v.add("BENETTON");
        v.add("BODMAN");
        v.add("BODY FANTASIES");
        v.add("BRITNEY");
        v.add("BRITNEY SPEARS");
        v.add("KALVIN KLEIN");
        v.add("CARON");
        v.add("COTY PRESTIGE");
        v.add("DKNY");
        v.add("ELISABETH ARDEN");
        v.add("ERMENEGILDO ZEGNA");
        v.add("ESSENTIEL");
        v.add("EVAFLO PARIS");
        v.add("GUESS");
        v.add("HUGO BOSS");
        v.add("lACOSTE");
        v.add("MARC KORS");
        v.add("NAUTICA");
        v.add("PARIS HILTON");
        v.add("PENGUIN");
        v.add("PERRY ELLIS");
        v.add("TOUS");
        v.add("ZIPPO");
        System.out.println("vector de perfume " + v.size());
        Datos.abrirConexion();
        valor = BuscarID("select * from marca where Id_Departamento=" + departamento + "", "marca");
        id = BuscarID("select * from marca", "marca");
        System.out.println("marca perfume " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("marca", "Id_Marca,Nombre_Marca,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarMarcaCelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("5.2 PULG,1080x1920 PX");
        v.add("5 PULG,720x1280 PX");
        v.add("5 PULG,1080x1920 PX");
        v.add("5 PULG,540x960");
        v.add("6,720x1280 px");
        v.add("TFT 1.8,128x160");
        v.add("TFT 2.0,220X176,65K COLOR");
        v.add("TFT,16M COLORES,240X320 PX");
        v.add("TFT,256K COLORES,240X320 PX");

        System.out.println("vector de pantalla celular " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from pantalla where Id_Departamento=" + departamento + "", "pantalla");
        id = BuscarID("select * from pantalla", "pantalla");
        System.out.println("pantalla " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("pantalla", "Id_Pantalla,Nombre_Pantalla,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarSeccionRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;

        v.add("MUJER");
        v.add("HOMBRE");
        System.out.println("vector de celular " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from clasificacion where Id_Departamento=" + departamento + "", "clasificacion");
        id = BuscarID("select * from clasificacion", "marca");
        System.out.println("clasificacion " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("clasificacion", "Id_Clasificacion,Nombre_Clasificacion,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarSeccionPerfume() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 2;

        v.add("MUJER");
        v.add("HOMBRE");
        System.out.println("vector de celular " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from clasificacion where Id_Departamento=" + departamento + "", "clasificacion");
        id = BuscarID("select * from clasificacion", "marca");
        System.out.println("clasificacion " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("clasificacion", "Id_Clasificacion,Nombre_Clasificacion,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarSeccionCalzado() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 4;

        v.add("MUJER");
        v.add("HOMBRE");
        System.out.println("vector de calzado " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from clasificacion where Id_Departamento=" + departamento + "", "clasificacion");
        id = BuscarID("select * from clasificacion", "marca");
        System.out.println("clasificacion " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("clasificacion", "Id_Clasificacion,Nombre_Clasificacion,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarSeccionCelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("GAMA BAJA");
        v.add("GAMA MEDIA");
        v.add("GAMA ALTA");

        System.out.println("vector de calzado " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from clasificacion where Id_Departamento=" + departamento + "", "clasificacion");
        id = BuscarID("select * from clasificacion", "marca");
        System.out.println("clasificacion " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("clasificacion", "Id_Clasificacion,Nombre_Clasificacion,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarCategoriaCelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("TACTIL");
        v.add("NO TACTIL");

        System.out.println("vector de calzado " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from categoria where Id_Departamento=" + departamento + "", "categoria");
        id = BuscarID("select * from categoria", "categoria");
        System.out.println("categoria " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("categoria", "Id_Categoria,Nombre_Categoria,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarCategoriaPerfume() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 2;

        v.add("SPRAY");
        v.add("ROLON");
        v.add("COLONIA");

        System.out.println("vector de perfume " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from categoria where Id_Departamento=" + departamento + "", "categoria");
        id = BuscarID("select * from categoria", "categoria");
        System.out.println("categoria " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("categoria", "Id_Categoria,Nombre_Categoria,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarCategoriaRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;

        v.add("DEPORTIVO");
        v.add("VESTIR");
        v.add("CASUAL");

        System.out.println("vector de ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from categoria where Id_Departamento=" + departamento + "", "categoria");
        id = BuscarID("select * from categoria", "categoria");
        System.out.println("categoria " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("categoria", "Id_Categoria,Nombre_Categoria,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarCategoriaCalzado() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 4;

        v.add("DEPORTIVO");
        v.add("VESTIR");
        v.add("CASUAL");

        System.out.println("vector de ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from categoria where Id_Departamento=" + departamento + "", "categoria");
        id = BuscarID("select * from categoria", "categoria");
        System.out.println("categoria " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("categoria", "Id_Categoria,Nombre_Categoria,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarTallaRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;

        v.add("S");
        v.add("M");
        v.add("XL");
        v.add("XXL");
        v.add("XXS");
        v.add("XS");
        v.add("XL");
        v.add("26");
        v.add("28");
        v.add("32");
        v.add("36");
        v.add("38");

        System.out.println("vector de ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from talla where Id_Departamento=" + departamento + "", "talla");
        id = BuscarID("select * from talla", "talla");
        System.out.println("talla " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("talla", "Id_Talla,Nombre_Talla,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarTallaCalzado() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 4;

        v.add("6");
        v.add("7");
        v.add("8");
        v.add("9");
        v.add("10");
        v.add("11");
        v.add("12");
        v.add("13");
        v.add("14");

        System.out.println("vector de ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from talla where Id_Departamento=" + departamento + "", "talla");
        id = BuscarID("select * from talla", "talla");
        System.out.println("talla " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("talla", "Id_Talla,Nombre_Talla,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarTelaRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;

        v.add("MOARÉ");
        v.add("ACETATO");
        v.add("PANA");
        v.add("ACRÍLICA");
        v.add("ALEMANISCO");
        v.add("ALPACA");
        v.add("ANGORA(MOHAIR)");
        v.add("CHENILLE");
        v.add("CACHEMIR");
        v.add("CHIFFON");
        v.add("GABARDINA");
        v.add("GASA");

        v.add("LONA");
        v.add("NYLON");
        v.add("SEDA");

        v.add("ALGODON");

        //PARA BLUSAS
        v.add("POPELINA");
        v.add("ETAMINA");

        v.add("LINO");
        v.add("CHENILLE");
        v.add("CACHEMIR");

        System.out.println("vector de ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from tela where Id_Departamento=" + departamento + "", "tela");
        id = BuscarID("select * from tela", "tela");
        System.out.println("talla " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("tela", "Id_Tela,Nombre_Tela,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarCuellosRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;

        v.add("MAO");
        v.add("PETER PAN");
        v.add("POLO");
        v.add("REDONDO");
        v.add("PALABRA DE HORNO");
        v.add("TANK TOP");
        v.add("CRUZADO");
        v.add("ASIMETRICO");
        v.add("CAPA");
        v.add("BARCO");
        v.add("CORAZÓN");
        v.add("CUADRADO");
        v.add("BANDA");
        v.add("CAMISA");
        v.add("CHAL");
        v.add("PICO");

        System.out.println("vector de cuello ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from cuello where Id_Departamento=" + departamento + "", "cuello");
        id = BuscarID("select * from cuello", "cuello");
        System.out.println("cuello " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("cuello", "Id_Cuello,Nombre_Cuello,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarEstiloRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;

        v.add("BOYFRIEND");
        v.add("BOOTCUT");
        v.add("SUPER SKINNY");
        v.add("SKINNY");
        v.add("STRAIGHT");
        v.add("SLIM");
        v.add("REGULAR FIT");
        v.add("TAILORED FIT");
        v.add("CUSTOM FIT");
        v.add("SLIM FIT");
        v.add("SUPERSLIM FIT");
        v.add("ACAMPANADOS");
        v.add("FLARE");//PATA DE ELEFANTE

        System.out.println("vector de estilo ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from estilo where Id_Departamento=" + departamento + "", "estilo");
        id = BuscarID("select * from estilo", "estilo");
        System.out.println("estilo " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("estilo", "Id_Estilo,Nombre_Estilo,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarColorRopa() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 3;

        v.add("NEGRO");
        v.add("ROJO");
        v.add("VERDE");
        v.add("MORADO");
        v.add("AMARILLO");
        v.add("VINO");
        v.add("ANARANJADO");
        v.add("BLANCO");
        v.add("NEGRO-BLANCO");
        v.add("AZUL");
        v.add("CAFE");

        System.out.println("vector de color ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from color where Id_Departamento=" + departamento + "", "color");
        id = BuscarID("select * from color", "color");
        System.out.println("color " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("color", "Id_Color,Nombre_Color,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarAromaPerfume() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 2;

        v.add("AMADERADO Y CANELA");
        v.add("AMADERADA");
        v.add("FLORAL");
        v.add("HERBAL O VERDE");
        v.add("ARIENTAL");
        v.add("FRUTAL");
        v.add("FRESCAS");
        v.add("CHRIPRES");

        System.out.println("vector de aroma ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from aroma where Id_Departamento=" + departamento + "", "aroma");
        id = BuscarID("select * from aroma", "aroma");
        System.out.println("aroma " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("aroma", "Id_Aroma,Nombre_Aroma,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarContenidoPerfume() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 2;

        v.add("100ML");
        v.add("75ML");
        v.add("200ML");
        v.add("50ML");
        v.add("150ML");

        System.out.println("vector de contenido ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from contenido where Id_Departamento=" + departamento + "", "contenido");
        id = BuscarID("select * from contenido", "contenido");
        System.out.println("contenido " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("contenido", "Id_Contenido,Nombre_Contenido,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarColorPerfume() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 2;

        v.add("VERDE");
        v.add("ROJO");
        v.add("GRIS");
        v.add("CAFE");
        v.add("AZUL");

        System.out.println("vector de color ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from color where Id_Departamento=" + departamento + "", "color");
        id = BuscarID("select * from color", "color");
        System.out.println("color " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("color", "Id_Color,Nombre_Color,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarColorCalzado() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 4;

        v.add("VERDE");
        v.add("ROJO");
        v.add("GRIS");
        v.add("CAFE");
        v.add("AZUL");
        v.add("NEGRO");

        System.out.println("vector de color ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from color where Id_Departamento=" + departamento + "", "color");
        id = BuscarID("select * from color", "color");
        System.out.println("color " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("color", "Id_Color,Nombre_Color,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarSistemaCelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("SYMBIAN");
        v.add("WINDOWS PHONE");
        v.add("BLACKBERRY");
        v.add("IOS");
        v.add("ANDROID");

        System.out.println("vector de sistema ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from sistema where Id_Departamento=" + departamento + "", "sistema");
        id = BuscarID("select * from sistema", "sistema");
        System.out.println("sistema " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("sistema", "Id_Sistema,Nombre_Sistema,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarColorCelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("GRIS ROJO");
        v.add("GRIS");
        v.add("CAFE");
        v.add("NEGRO");

        System.out.println("vector de color ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from color where Id_Departamento=" + departamento + "", "color");
        id = BuscarID("select * from color", "color");
        System.out.println("color " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("color", "Id_Color,Nombre_Color,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarModeloCelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("13MP");
        v.add("21MP");
        v.add("5MP");
        v.add("3MP");

        System.out.println("vector de camara ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from camara where Id_Departamento=" + departamento + "", "camara");
        id = BuscarID("select * from camara", "camara");
        System.out.println("modelo " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("camara", "Id_Camara,Nombre_Camara,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarMemoriaICelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("1GB");
        v.add("2GB");
        v.add("4GB");
        v.add("8GB");

        v.add("16GB");
        v.add("480MB");

        System.out.println("vector de  	memoria_interna ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from  memoria_interna where Id_Departamento=" + departamento + "", " memoria_interna");
        id = BuscarID("select * from  	memoria_interna", " memoria_interna");
        System.out.println("memoria_interna " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("memoria_interna", "Id_Memoria_Interna,Nombre_Memoria_Interna,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    public void InsertarMemoriaECelular() {
        //Declaracion de Varibles
        Vector v;
        v = new Vector();
        int valor, id = 0, departamento = 1;

        v.add("1GB");
        v.add("2GB");
        v.add("4GB");
        v.add("8GB");

        v.add("16GB");
        v.add("480MB");

        System.out.println("vector de  	memoria_interna ropa " + v.size());

        Datos.abrirConexion();
        valor = BuscarID("select * from  memoria_externa where Id_Departamento=" + departamento + "", " memoria_externa");
        id = BuscarID("select * from  	memoria_externa", " memoria_externa");
        System.out.println("memoria_externa " + valor);
        Datos.cerrarConexion();
        if (valor == 0) {
            Datos.abrirConexion();
            for (int i = 0; i <= v.size() - 1; i++) {
                id++;
                System.out.println("id" + id);
                System.out.println("i=" + i);
                System.out.println("v{" + i + "]=" + v.get(i));
                Datos.Insertar2("memoria_externa", "Id_Memoria_Externa,Nombre_Memoria_Externa,Id_Departamento", "" + id + ",'" + v.get(i) + "'," + departamento + "");

            }
            Datos.cerrarConexion();
        }

    }

    //Fin funciones
    public void setMss(ModeloSession mss) {
        this.mss = mss;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    private void activeOptions() {
        jLabel5.setVisible(mss.getPrivilegios().isREGISTRO_PROVEEDORES());
        jLabel6.setVisible(mss.getPrivilegios().isREGISTRO_VENTAS());
        jLabel7.setVisible(mss.getPrivilegios().isREGISTRO_COMPRAS());
        jLabel8.setVisible(mss.getPrivilegios().isREGISTRO_EMPLEADOS());
        jLabel3.setVisible(mss.getPrivilegios().isREGISTRO_PRODUCTO());
        jLabel11.setVisible(mss.getPrivilegios().isGENERAR_REPORTES());
        jLabel12.setVisible(mss.getPrivilegios().isCONSULTAR_INVENTARIO());
        
    }

    private void inactiveOptions() {
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel3.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
//        notificacion.resume();
//
//        contNoti = 0;
//        y = 45;
//        Notificacion_Panel.removeAll();
//        Notificacion_Panel.repaint();

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        Menu_Inicio = new javax.swing.JPopupMenu();
        Submenu1 = new javax.swing.JMenuItem();
        Submenu2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Productos = new javax.swing.JPopupMenu();
        R_Calzado = new javax.swing.JMenuItem();
        R_Celulares = new javax.swing.JMenuItem();
        R_Ropa = new javax.swing.JMenuItem();
        R_Perfume = new javax.swing.JMenuItem();
        jpmCompras = new javax.swing.JPopupMenu();
        jmiCalzado = new javax.swing.JMenuItem();
        jmiCelular = new javax.swing.JMenuItem();
        jmiPerfume = new javax.swing.JMenuItem();
        jmiRopa = new javax.swing.JMenuItem();
        jpmReportes = new javax.swing.JPopupMenu();
        jmiEmpleados = new javax.swing.JMenuItem();
        jmiProductos = new javax.swing.JMenuItem();
        jmiBitacora = new javax.swing.JMenuItem();
        jmiVentas = new javax.swing.JMenuItem();
        Acceso = new javax.swing.JPopupMenu();
        Inicio = new javax.swing.JMenuItem();
        cerrar = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();
        jpmSeguridad = new javax.swing.JPopupMenu();
        jmiAdministrarUsuario = new javax.swing.JMenuItem();
        jmiGenerarBackup = new javax.swing.JMenuItem();
        jmiRestaurar = new javax.swing.JMenuItem();
        jmiMostrarBitacora = new javax.swing.JMenuItem();
        jmiRegistrarUsuario = new javax.swing.JMenuItem();
        jp = new javax.swing.JPanel();
        panel1 = new org.edisoncor.gui.panel.Panel();
        Notificacion_Panel = new jcMousePanel.jcMousePanel();
        mi_panel_menu = new javax.swing.JPanel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jcMousePanel3 = new jcMousePanel.jcMousePanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jcMousePanel2 = new jcMousePanel.jcMousePanel();
        Logo2 = new org.edisoncor.gui.panel.PanelImageReflect();
        jp_Menu = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panel4 = new org.edisoncor.gui.panel.Panel();
        jlabelnomusu = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panel3 = new jcMousePanel.jcMousePanel();
        jcMousePanel4 = new jcMousePanel.jcMousePanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("IntegraAlmacen");

        Submenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cesion.png"))); // NOI18N
        Submenu1.setText("jMenuItem1");
        Submenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submenu1ActionPerformed(evt);
            }
        });
        Menu_Inicio.add(Submenu1);

        Submenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Informacion (2).png"))); // NOI18N
        Submenu2.setText("jMenuItem2");
        Submenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submenu2ActionPerformed(evt);
            }
        });
        Menu_Inicio.add(Submenu2);

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        Menu_Inicio.add(jMenu1);

        R_Calzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Zapatos.png"))); // NOI18N
        R_Calzado.setText("jMenuItem2");
        R_Calzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_CalzadoActionPerformed(evt);
            }
        });
        Productos.add(R_Calzado);

        R_Celulares.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Telefo.png"))); // NOI18N
        R_Celulares.setText("jMenuItem2");
        R_Celulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_CelularesActionPerformed(evt);
            }
        });
        Productos.add(R_Celulares);

        R_Ropa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Rop.png"))); // NOI18N
        R_Ropa.setText("jMenuItem2");
        R_Ropa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_RopaActionPerformed(evt);
            }
        });
        Productos.add(R_Ropa);

        R_Perfume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Per.png"))); // NOI18N
        R_Perfume.setText("jMenuItem3");
        R_Perfume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_PerfumeActionPerformed(evt);
            }
        });
        Productos.add(R_Perfume);

        jmiCalzado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Zapatos.png"))); // NOI18N
        jmiCalzado.setText("jMenuItem3");
        jmiCalzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCalzadoActionPerformed(evt);
            }
        });
        jpmCompras.add(jmiCalzado);

        jmiCelular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Telefo.png"))); // NOI18N
        jmiCelular.setText("jMenuItem5");
        jmiCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCelularActionPerformed(evt);
            }
        });
        jpmCompras.add(jmiCelular);

        jmiPerfume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Per.png"))); // NOI18N
        jmiPerfume.setText("jMenuItem4");
        jmiPerfume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPerfumeActionPerformed(evt);
            }
        });
        jpmCompras.add(jmiPerfume);

        jmiRopa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Rop.png"))); // NOI18N
        jmiRopa.setText("jMenuItem2");
        jmiRopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRopaActionPerformed(evt);
            }
        });
        jpmCompras.add(jmiRopa);

        jmiEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reporte_Empleado.png"))); // NOI18N
        jmiEmpleados.setText("jMenuItem2");
        jmiEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmpleadosActionPerformed(evt);
            }
        });
        jpmReportes.add(jmiEmpleados);

        jmiProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reporte_Producto.png"))); // NOI18N
        jmiProductos.setText("jMenuItem3");
        jpmReportes.add(jmiProductos);

        jmiBitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reporte_Bitacora.png"))); // NOI18N
        jmiBitacora.setText("jMenuItem4");
        jpmReportes.add(jmiBitacora);

        jmiVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reporte_Ventas.png"))); // NOI18N
        jmiVentas.setText("jMenuItem5");
        jpmReportes.add(jmiVentas);

        Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/candado_negro.png"))); // NOI18N
        Inicio.setText("jMenuItem2");
        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });
        Acceso.add(Inicio);

        cerrar.setText("jMenuItem2");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        Acceso.add(cerrar);

        jmiSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jmiSalir.setText("jMenuItem3");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        Acceso.add(jmiSalir);

        jmiAdministrarUsuario.setText("jMenuItem2");
        jmiAdministrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdministrarUsuarioActionPerformed(evt);
            }
        });
        jpmSeguridad.add(jmiAdministrarUsuario);

        jmiGenerarBackup.setText("jMenuItem4");
        jmiGenerarBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGenerarBackupActionPerformed(evt);
            }
        });
        jpmSeguridad.add(jmiGenerarBackup);

        jmiRestaurar.setText("jMenuItem2");
        jmiRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRestaurarActionPerformed(evt);
            }
        });
        jpmSeguridad.add(jmiRestaurar);

        jmiMostrarBitacora.setText("jMenuItem2");
        jmiMostrarBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarBitacoraActionPerformed(evt);
            }
        });
        jpmSeguridad.add(jmiMostrarBitacora);

        jmiRegistrarUsuario.setText("jMenuItem2");
        jmiRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRegistrarUsuarioActionPerformed(evt);
            }
        });
        jpmSeguridad.add(jmiRegistrarUsuario);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jp.setPreferredSize(new java.awt.Dimension(242, 64));
        jp.setLayout(new java.awt.BorderLayout());

        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(44, 33));
        jp.add(panel1, java.awt.BorderLayout.PAGE_START);

        Notificacion_Panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Barra_Latera.png"))); // NOI18N

        javax.swing.GroupLayout Notificacion_PanelLayout = new javax.swing.GroupLayout(Notificacion_Panel);
        Notificacion_Panel.setLayout(Notificacion_PanelLayout);
        Notificacion_PanelLayout.setHorizontalGroup(
            Notificacion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        Notificacion_PanelLayout.setVerticalGroup(
            Notificacion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        jp.add(Notificacion_Panel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jp, java.awt.BorderLayout.LINE_END);

        mi_panel_menu.setLayout(new java.awt.BorderLayout());

        panel2.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel2.setPreferredSize(new java.awt.Dimension(44, 33));
        mi_panel_menu.add(panel2, java.awt.BorderLayout.PAGE_START);

        jcMousePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Barra_Latera.png"))); // NOI18N
        jcMousePanel3.setName(""); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Ventas.png"))); // NOI18N
        jLabel6.setToolTipText("Ventas");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Proveedor.png"))); // NOI18N
        jLabel5.setToolTipText("Proveedor");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Compras.png"))); // NOI18N
        jLabel7.setToolTipText("Compras");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Empleado.png"))); // NOI18N
        jLabel8.setToolTipText("Empleados");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Producto.png"))); // NOI18N
        jLabel3.setToolTipText("Productos");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reportes.png"))); // NOI18N
        jLabel11.setToolTipText("Reportes");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Seguridad.png"))); // NOI18N
        jLabel12.setToolTipText("Seguridad");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel12MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel3Layout = new javax.swing.GroupLayout(jcMousePanel3);
        jcMousePanel3.setLayout(jcMousePanel3Layout);
        jcMousePanel3Layout.setHorizontalGroup(
            jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addGroup(jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel11)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jcMousePanel3Layout.setVerticalGroup(
            jcMousePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mi_panel_menu.add(jcMousePanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(mi_panel_menu, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jcMousePanel1.setLayout(new java.awt.BorderLayout());

        jcMousePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Barra_Latera.png"))); // NOI18N
        jcMousePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/balta.png"))); // NOI18N
        jcMousePanel2.add(Logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 624, 260));

        jp_Menu.setColorDeBorde(new java.awt.Color(255, 255, 255));
        jp_Menu.setColorPrimario(new java.awt.Color(255, 255, 255));
        jp_Menu.setColorSecundario(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Bienvenido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("José Baltazar Rosales Galán");

        javax.swing.GroupLayout jp_MenuLayout = new javax.swing.GroupLayout(jp_Menu);
        jp_Menu.setLayout(jp_MenuLayout);
        jp_MenuLayout.setHorizontalGroup(
            jp_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel15)
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        jp_MenuLayout.setVerticalGroup(
            jp_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jp_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jcMousePanel2.add(jp_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 1020, -1));

        jcMousePanel1.add(jcMousePanel2, java.awt.BorderLayout.CENTER);

        panel4.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel4.setPreferredSize(new java.awt.Dimension(44, 33));
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlabelnomusu.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jlabelnomusu.setForeground(new java.awt.Color(255, 255, 255));
        panel4.add(jlabelnomusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 4, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Notificacion_1.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel16MouseReleased(evt);
            }
        });
        panel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Inicio_2.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        panel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Informacion_2.png"))); // NOI18N
        panel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 0, -1, -1));

        jcMousePanel1.add(panel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jcMousePanel1, java.awt.BorderLayout.CENTER);

        panel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Header.png"))); // NOI18N
        panel3.setPreferredSize(new java.awt.Dimension(1024, 100));
        getContentPane().add(panel3, java.awt.BorderLayout.PAGE_START);

        jcMousePanel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pie2.png"))); // NOI18N
        jcMousePanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("UES-FMP DERECHOS RESERVADOS 2016");
        jcMousePanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 15, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Sin título-1.png"))); // NOI18N
        jcMousePanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, -1));

        getContentPane().add(jcMousePanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Submenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submenu1ActionPerformed
        //exit(0);
        this.dispose();
    }//GEN-LAST:event_Submenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
        // jLabel12.setIcon(new ImageIcon(getClass().getResource("/wer/Seguridad2.png")));
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Seguridad3.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Seguridad.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Producto2.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Producto.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.R_Celulares.setText("Registro de Celulares");
        this.R_Calzado.setText("Registro de Calzado");
        this.R_Perfume.setText("Registro de Perfume");
        this.R_Ropa.setText("Registro de Ropa");
        Productos.show(evt.getComponent(), evt.getX(), evt.getY());

    }//GEN-LAST:event_jLabel3MouseClicked

    private void R_CelularesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_CelularesActionPerformed
        Celulares_1 cel = new Celulares_1(mss);
        cel.pack();
        cel.setVisible(true);
        cel.setLocationRelativeTo(this);
    }//GEN-LAST:event_R_CelularesActionPerformed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Proveedor2.png")));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Proveedor.png")));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Ventas2.png")));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Ventas.png")));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Compras2.png")));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Compras.png")));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Empleado2.png")));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Empleado.png")));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Reportes2.png")));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setIcon(new ImageIcon(getClass().getResource("/" + paquete + "/Reportes.png")));
    }//GEN-LAST:event_jLabel11MouseExited

    private void Submenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submenu2ActionPerformed

    }//GEN-LAST:event_Submenu2ActionPerformed

    private void jmiCalzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCalzadoActionPerformed
        Compras_Calzado1 a = new Compras_Calzado1(mss);
        a.pack();
        a.setVisible(true);
        a.setLocationRelativeTo(this);
    }//GEN-LAST:event_jmiCalzadoActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        this.jmiCalzado.setText("  Compra de Calzado");
        this.jmiCelular.setText("  Comppra de Celular");
        this.jmiPerfume.setText("  Compra de Perfume");
        this.jmiRopa.setText("  Compra de Ropa");
        jpmCompras.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jmiEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiEmpleadosActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        this.jmiBitacora.setText("Reporte de Bitacora");
        this.jmiEmpleados.setText("Repote de Empleados");
        this.jmiProductos.setText("Reporte de Productos");
        this.jmiVentas.setText("Reporte de Ventas");
        jpmReportes.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseReleased

    }//GEN-LAST:event_jLabel16MouseReleased

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        this.Inicio.setText("Inicio de sesion");
        this.cerrar.setText("Cerrar sesion");
        this.jmiSalir.setText("Salir de sistema");
        Acceso.show(evt.getComponent(), evt.getX() - 10, evt.getY() + 5);

    }//GEN-LAST:event_jLabel13MouseClicked

    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
        // TODO add your handling code here:        
        Inicio_Sesion a = new Inicio_Sesion(this, true);
        a.setVisible(true);
        a.setLocationRelativeTo(this);
        if (!logged) {
            if (mss.isLogged()) {
                activeOptions();
//                this.Inicio.setText("Cerrar Sesion");
                this.Inicio.setEnabled(false);
                this.cerrar.setEnabled(true);
                cb.insertarAccion(mss.getNombre(), "Inicio de sesion en el sistema INTEGRA ");
                logged = true;

            }
        }

    }//GEN-LAST:event_InicioActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        // TODO add your handling code here:

//        exit(0);
        this.dispose();
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void R_CalzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_CalzadoActionPerformed
        Calzado_1 cal = new Calzado_1(mss);
        cal.pack();
        cal.setVisible(true);
        cal.setLocationRelativeTo(this);
    }//GEN-LAST:event_R_CalzadoActionPerformed

    private void R_RopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_RopaActionPerformed
        Ropa_Bueno_2 ropa = new Ropa_Bueno_2(mss);
        ropa.pack();
        ropa.setVisible(true);
        ropa.setLocationRelativeTo(this);
    }//GEN-LAST:event_R_RopaActionPerformed

    private void R_PerfumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_PerfumeActionPerformed
        Perfume1 per = new Perfume1(mss);
        per.pack();
        per.setVisible(true);
        per.setLocationRelativeTo(this);
    }//GEN-LAST:event_R_PerfumeActionPerformed

    public static Conexion hc;
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        try {
            hc = new Conexion();
            System.out.println("Conectado");
            ahorasi g = new ahorasi(mss);
            g.setVisible(true);
            g.setLocationRelativeTo(this);
        } catch (Exception e) {
            System.out.println("error al iniciar" + e);
        }

    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Proveedor2 a = new Proveedor2(mss);
        a.pack();
        a.setVisible(true);
        a.setLocationRelativeTo(this);
        
        
        

//        registro_usuarios ru=new registro_usuarios();
//        ru.pack();
//        ru.setVisible(true);
//        ru.setLocationRelativeTo(this);
//////////////////////////////////////        Vista_Bitacora vb = new Vista_Bitacora(null, rootPaneCheckingEnabled);
//////////////////////////////////////        vb.setVisible(true);
//////////////////////////////////////        vb.setResizable(false);
//////////////////////////////////////        vb.setLocationRelativeTo(null);

    }//GEN-LAST:event_jLabel5MouseClicked

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
        cb.insertarAccion(mss.getNombre(), "Fin de sesion en el sistema INTEGRA");
        mss.logout();
        inactiveOptions();
//            this.Inicio.setText("Inicio de sesion");
        this.Inicio.setEnabled(true);
        logged = false;


    }//GEN-LAST:event_cerrarActionPerformed

    private void jmiCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCelularActionPerformed
        Compras_Celulares1 a = new Compras_Celulares1(mss);
        a.pack();
        a.setVisible(true);
        a.setLocationRelativeTo(this);
    }//GEN-LAST:event_jmiCelularActionPerformed

    private void jmiPerfumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPerfumeActionPerformed
        Compras_Perfume1 a = new Compras_Perfume1(mss);
        a.pack();
        a.setVisible(true);
        a.setLocationRelativeTo(this);
    }//GEN-LAST:event_jmiPerfumeActionPerformed

    private void jmiRopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRopaActionPerformed
        Compras_Producto a = new Compras_Producto(mss);
        a.pack();
        a.setVisible(true);
        a.setLocationRelativeTo(this);
    }//GEN-LAST:event_jmiRopaActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.jmiAdministrarUsuario.setText("Administrar Usuario");
        this.jmiRegistrarUsuario.setText("Registrar Usuario");
        this.jmiGenerarBackup.setText("Generar Backup");
        this.jmiRestaurar.setText("Restaurar Backup");
        this.jmiMostrarBitacora.setText("Mostrar Bitacora");
        jpmSeguridad.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jmiGenerarBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGenerarBackupActionPerformed
        // TODO add your handling code here:
        bmsql.backup();
        msm.ms_exito("Backup Creado con éxito");
    }//GEN-LAST:event_jmiGenerarBackupActionPerformed

    private void jmiRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRestaurarActionPerformed
        // TODO add your handling code here:
        String srt = new BackupView(this, true).getBackupFile();
        bmsql.restore(srt);
        //msm.ms_exito("Backup Restaurado con éxito");
    }//GEN-LAST:event_jmiRestaurarActionPerformed

    private void jmiRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRegistrarUsuarioActionPerformed
        
        registro_usuarios ru=new registro_usuarios(mss);
        ru.pack();
        ru.setVisible(true);
        ru.setLocationRelativeTo(this);
    }//GEN-LAST:event_jmiRegistrarUsuarioActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int ax=Id_Usuario;
        System.out.println("ax"+ax);
       Ventas2 a=new Ventas2(ax, mss);
        a.pack();
        a.setVisible(true);
        a.setLocationRelativeTo(this);
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jmiAdministrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarUsuarioActionPerformed
        // TODO add your handling code here:
        Adminstrar_Usuarios adu=new Adminstrar_Usuarios(this, rootPaneCheckingEnabled);
        adu.setVisible(true);
        adu.setResizable(false);
        adu.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmiAdministrarUsuarioActionPerformed

    private void jmiMostrarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarBitacoraActionPerformed
        // TODO add your handling code here:
        Vista_Bitacora vb = new Vista_Bitacora(null, rootPaneCheckingEnabled);
        vb.setVisible(true);
        vb.setResizable(false);
        vb.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmiMostrarBitacoraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (new UniqueRun().config()) {
                    Menu1 m = new Menu1();
                    m.setVisible(true);
                } else {
                    Menu1 m = new Menu1();
                    m.setVisible(true);
                }
                //m.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu Acceso;
    private javax.swing.JMenuItem Inicio;
    private org.edisoncor.gui.panel.PanelImageReflect Logo2;
    private javax.swing.JPopupMenu Menu_Inicio;
    private jcMousePanel.jcMousePanel Notificacion_Panel;
    private javax.swing.JPopupMenu Productos;
    private javax.swing.JMenuItem R_Calzado;
    private javax.swing.JMenuItem R_Celulares;
    private javax.swing.JMenuItem R_Perfume;
    private javax.swing.JMenuItem R_Ropa;
    private javax.swing.JMenuItem Submenu1;
    private javax.swing.JMenuItem Submenu2;
    private javax.swing.JMenuItem cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel6;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private jcMousePanel.jcMousePanel jcMousePanel2;
    private jcMousePanel.jcMousePanel jcMousePanel3;
    private jcMousePanel.jcMousePanel jcMousePanel4;
    private javax.swing.JLabel jlabelnomusu;
    private javax.swing.JMenuItem jmiAdministrarUsuario;
    private javax.swing.JMenuItem jmiBitacora;
    private javax.swing.JMenuItem jmiCalzado;
    private javax.swing.JMenuItem jmiCelular;
    private javax.swing.JMenuItem jmiEmpleados;
    private javax.swing.JMenuItem jmiGenerarBackup;
    private javax.swing.JMenuItem jmiMostrarBitacora;
    private javax.swing.JMenuItem jmiPerfume;
    private javax.swing.JMenuItem jmiProductos;
    private javax.swing.JMenuItem jmiRegistrarUsuario;
    private javax.swing.JMenuItem jmiRestaurar;
    private javax.swing.JMenuItem jmiRopa;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiVentas;
    private javax.swing.JPanel jp;
    private org.edisoncor.gui.panel.PanelRectTranslucido jp_Menu;
    private javax.swing.JPopupMenu jpmCompras;
    private javax.swing.JPopupMenu jpmReportes;
    private javax.swing.JPopupMenu jpmSeguridad;
    private javax.swing.JPanel mi_panel_menu;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private jcMousePanel.jcMousePanel panel3;
    private org.edisoncor.gui.panel.Panel panel4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Integer segundos = 0, milesimas = 0;
        boolean proceso = true;
        try {//mientras el estado de la bandera proceso sea verdadero seguira aumentando el tiempo
            while (proceso) {
                Thread.sleep(4);
                milesimas += 4;
                if (milesimas == 1000) {//Cuando llega a 1000 milesimas o sea 1 segundo aumenta 1 segundo y las milesimas de segundo vuelven de nuevo a 0
                    milesimas = 0;
                    segundos += 1;
                    if (segundos == 15) {//cada 15 segundos verifica si se han hecho cambios; si es asi actualiza los datos en el formulario Menu
                        segundos = 0;
                        contNoti = 0;
                        y = 45;
                        Notificacion_Panel.removeAll();
                        cargarPagosProximos();
                        ProductosProximosAgotarse();
                        Notificacion_Panel.repaint();

                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
