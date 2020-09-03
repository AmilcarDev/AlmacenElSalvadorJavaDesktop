package Clases;

import java.sql.*;
import javax.swing.JOptionPane;
import Clases.msm;
import Clases.Metodos_Set_Get;

public class Datos_Regisro_Producto extends Conexion {

    public ResultSet rs;

    public void Insertar_Datos(Metodos_Set_Get u) {
        try {
            String sql = "insert into producto(Id_Producto,Nombre_Producto,Stock,Id_Proveedor,Id_Departamento"
                    + ",Precio_unitario,Talla,Estilo,Marca,Color,Categoria,Clasificacion,Estado,Ganancia,Tela,Cuello,foto) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_Producto());
            ps.setString(2, u.getNombre_Producto());
            ps.setInt(3, u.getStock());
            ps.setInt(4, u.getId_Proveedor());
            ps.setInt(5, u.getId_Departamento());
            ps.setFloat(6, u.getPrecio_unitario());
            ps.setString(7, u.getTalla());
            ps.setString(8, u.getEstilo());
            ps.setString(9, u.getMarca());
            ps.setString(10, u.getColor());
            ps.setString(11, u.getCategoria());
            ps.setString(12, u.getClasificacion());
            ps.setString(13, u.getEstado());
            ps.setInt(14, u.getGanancia());
            ps.setString(15, u.getTela());
            ps.setString(16, u.getCuello());
            ps.setBinaryStream(17, u.getFis(), u.getLongitudBytes());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Ropa registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar ropa");
            }

        } catch (Exception e) {
            System.out.println("error al insertar" + e);
        }
    }

    public void ModificarDatosConFoto(Metodos_Set_Get u) {

        try {

            //"
            // 
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,Talla=?,Estilo=?"
                    + ",Marca=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=?,foto=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getTalla());
            ps.setString(7, u.getEstilo());
            ps.setString(8, u.getMarca());
            ps.setString(9, u.getColor());
            ps.setString(10, u.getCategoria());
            ps.setString(11, u.getClasificacion());
            ps.setString(12, u.getEstado());
            ps.setInt(13, u.getGanancia());
            ps.setString(14, u.getTela());
            ps.setString(15, u.getCuello());
            ps.setBinaryStream(16, u.getFis(), u.getLongitudBytes());
            ps.setInt(17, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Ropa registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar ropa");
            }
        } catch (Exception e) {
            System.out.println("error al insertar " + e);
        }
    }

    public void ModificarDatosSinFoto(Metodos_Set_Get u) {

        try {

            //"
            // 
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,Talla=?,Estilo=?"
                    + ",Marca=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getTalla());
            ps.setString(7, u.getEstilo());
            ps.setString(8, u.getMarca());
            ps.setString(9, u.getColor());
            ps.setString(10, u.getCategoria());
            ps.setString(11, u.getClasificacion());
            ps.setString(12, u.getEstado());
            ps.setInt(13, u.getGanancia());
            ps.setInt(14, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Ropa registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar ropa");
            }
        } catch (Exception e) {
            System.out.println("error al insertar " + e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////                      DATOS DE CELULARES                                                  /////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Insertar_Datos_Celulares(Metodos_Set_Get u) {
        try {
            String sql = "insert into producto(Id_Producto,Nombre_Producto,Stock,Id_Proveedor,Id_Departamento,Precio_unitario,Sistema,Camara,Pantalla,Color,Categoria,Clasificacion,Estado,Ganancia,Memoria_Interna,Memoria_Externa,foto) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_Producto());
            ps.setString(2, u.getNombre_Producto());
            ps.setInt(3, u.getStock());
            ps.setInt(4, u.getId_Proveedor());
            ps.setInt(5, u.getId_Departamento());
            ps.setFloat(6, u.getPrecio_unitario());
            ps.setString(7, u.getSistema());
            ps.setString(8, u.getModelo());
            ps.setString(9, u.getMarca());
            ps.setString(10, u.getColor());
            ps.setString(11, u.getCategoria());
            ps.setString(12, u.getClasificacion());
            ps.setString(13, u.getEstado());
            ps.setInt(14, u.getGanancia());
            ps.setString(15, u.getMemoria_Interna());
            ps.setString(16, u.getMemoria_Externa());
            ps.setBinaryStream(17, u.getFis(), u.getLongitudBytes());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Celular registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar celular");
            }

        } catch (Exception e) {
            System.out.println("error al insertar" + e);
        }
    }

    public void ModificarDatosConFoto_Celulares(Metodos_Set_Get u) {

        try {
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,"
                    + "Sistema=?,Camara=?,Pantalla=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=?,Memoria_Interna=?,Memoria_Externa=?,foto=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getSistema());
            ps.setString(7, u.getModelo());
            ps.setString(8, u.getMarca());
            ps.setString(9, u.getColor());
            ps.setString(10, u.getCategoria());
            ps.setString(11, u.getClasificacion());
            ps.setString(12, u.getEstado());
            ps.setInt(13, u.getGanancia());
            ps.setString(14, u.getMemoria_Interna());
            ps.setString(15, u.getMemoria_Externa());
            ps.setBinaryStream(16, u.getFis(), u.getLongitudBytes());
            ps.setInt(17, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Datos del celular registrados correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al modificar datos del celular con fotos");
            }
        } catch (Exception e) {
            System.out.println("Error al Modificar con foto " + e);
        }
    }

    public void ModificarDatosSinFoto_Celulares(Metodos_Set_Get u) {

        try {
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,Sistema=?,Modelo=?,Marca=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=?,Memoria_Interna=?,Memoria_Externa=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getSistema());
            ps.setString(7, u.getModelo());
            ps.setString(8, u.getMarca());
            ps.setString(9, u.getColor());
            ps.setString(10, u.getCategoria());
            ps.setString(11, u.getClasificacion());
            ps.setString(12, u.getEstado());
            ps.setInt(13, u.getGanancia());
            ps.setString(14, u.getMemoria_Interna());
            ps.setString(15, u.getMemoria_Externa());
            ps.setInt(16, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Empleado registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar empleado");
            }
        } catch (Exception e) {
            System.out.println("error al insertar " + e);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////                      DATOS DE ZAPATOS                                                  /////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void Insertar_Datos_Zapatos(Metodos_Set_Get u) {
        try {
            String sql = "insert into producto(Id_Producto,Nombre_Producto,Stock,Id_Proveedor,Id_Departamento,Precio_unitario,Talla,Marca,Color,Categoria,Clasificacion,Estado,Ganancia,foto) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_Producto());
            ps.setString(2, u.getNombre_Producto());
            ps.setInt(3, u.getStock());
            ps.setInt(4, u.getId_Proveedor());
            ps.setInt(5, u.getId_Departamento());
            ps.setFloat(6, u.getPrecio_unitario());
            ps.setString(7, u.getTalla());
            ps.setString(8, u.getMarca());
            ps.setString(9, u.getColor());
            ps.setString(10, u.getCategoria());
            ps.setString(11, u.getClasificacion());
            ps.setString(12, u.getEstado());
            ps.setInt(13, u.getGanancia());
            ps.setBinaryStream(14, u.getFis(), u.getLongitudBytes());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Calzado registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar calzado");
            }

        } catch (Exception e) {
            System.out.println("error al insertar" + e);
        }
    }

    public void ModificarDatosConFoto_Zapatos(Metodos_Set_Get u) {

        try {
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,Talla=?,Marca=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=?,foto=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getTalla());
            ps.setString(7, u.getMarca());
            ps.setString(8, u.getColor());
            ps.setString(9, u.getCategoria());
            ps.setString(10, u.getClasificacion());
            ps.setString(11, u.getEstado());
            ps.setInt(12, u.getGanancia());
            ps.setBinaryStream(13, u.getFis(), u.getLongitudBytes());
            ps.setInt(14, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Datos del calzado registrados correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al modificar datos del calzado con fotos");
            }
        } catch (Exception e) {
            System.out.println("Error al Modificar con foto " + e);
        }
    }

    public void ModificarDatosSinFoto_Zapatos(Metodos_Set_Get u) {

        try {
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,Talla=?,Marca=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getTalla());
            ps.setString(7, u.getMarca());
            ps.setString(8, u.getColor());
            ps.setString(9, u.getCategoria());
            ps.setString(10, u.getClasificacion());
            ps.setString(11, u.getEstado());
            ps.setInt(12, u.getGanancia());
            ps.setInt(13, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Calzado registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar calzado");
            }
        } catch (Exception e) {
            System.out.println("error al insertar " + e);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////                      DATOS DE PERFUMES                                                  /////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void Insertar_Datos_Perfume(Metodos_Set_Get u) {
        try {
            String sql = "insert into producto(Id_Producto,Nombre_Producto,Stock,Id_Proveedor,Id_Departamento,Precio_unitario"
                    + ",Aroma,Contenido,Marca,Color,Categoria,Clasificacion,Estado,Ganancia,foto) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_Producto());
            ps.setString(2, u.getNombre_Producto());
            ps.setInt(3, u.getStock());
            ps.setInt(4, u.getId_Proveedor());
            ps.setInt(5, u.getId_Departamento());
            ps.setFloat(6, u.getPrecio_unitario());
            ps.setString(7, u.getAroma());
            ps.setString(8, u.getContenido());
            ps.setString(9, u.getMarca());
            ps.setString(10, u.getColor());
            ps.setString(11, u.getCategoria());
            ps.setString(12, u.getClasificacion());
            ps.setString(13, u.getEstado());
            ps.setInt(14, u.getGanancia());
            ps.setBinaryStream(15, u.getFis(), u.getLongitudBytes());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Perfume registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar perfume");
            }

        } catch (Exception e) {
            System.out.println("error al insertar" + e);
        }
    }

    public void ModificarDatosConFoto_Perfume(Metodos_Set_Get u) {

        try {
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,Talla=?,Marca=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=?,foto=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getTalla());
            ps.setString(7, u.getMarca());
            ps.setString(8, u.getColor());
            ps.setString(9, u.getCategoria());
            ps.setString(10, u.getClasificacion());
            ps.setString(11, u.getEstado());
            ps.setInt(12, u.getGanancia());
            ps.setBinaryStream(13, u.getFis(), u.getLongitudBytes());
            ps.setInt(14, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Datos del perfume registrados correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al modificar datos del perfume con fotos");
            }
        } catch (Exception e) {
            System.out.println("Error al Modificar con foto " + e);
        }
    }

    public void ModificarDatosSinFoto_Perfume(Metodos_Set_Get u) {

        try {
            String sql = "update producto set Nombre_Producto=?,Stock=?,Id_Proveedor=?,Id_Departamento=?,Precio_unitario=?,Talla=?,Marca=?,Color=?,Categoria=?,Clasificacion=?,Estado=?,Ganancia=? where Id_Producto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre_Producto());
            ps.setInt(2, u.getStock());
            ps.setInt(3, u.getId_Proveedor());
            ps.setInt(4, u.getId_Departamento());
            ps.setFloat(5, u.getPrecio_unitario());
            ps.setString(6, u.getTalla());
            ps.setString(7, u.getMarca());
            ps.setString(8, u.getColor());
            ps.setString(9, u.getCategoria());
            ps.setString(10, u.getClasificacion());
            ps.setString(11, u.getEstado());
            ps.setInt(12, u.getGanancia());
            ps.setInt(13, u.getId_Producto());
            System.out.println("guardado datos");
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Perfume registrado correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar perfume");
            }
        } catch (Exception e) {
            System.out.println("error al insertar " + e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////                      DATOS DE COMPRA DE ROPA                                                /////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Insertar_Compra_Ropa(Compras_Set_Get u) {
        try {
            String sql = "insert into compras(Id_Compras,Numero_Factura,Tipo_Pago,Fecha_Compra,Fecha_Pago,Total,Id_Usuario,Id_Proveedor) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_Compras());
            ps.setString(2, u.getNumero_Factura());
            ps.setString(3, u.getTipo_Pago());
            ps.setString(4, u.getFecha_Compra());
            ps.setString(5, u.getFecha_Pago());
            ps.setFloat(6, u.getTotal());
            ps.setInt(7, u.getId_Usuario());
            ps.setInt(8, u.getId_Proveedor());
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                msm.ms_exito("Compra registrada correctamente");
            } else if (ejecucion == false) {
                msm.ms_error("Error al guardar la Compra");
            }

        } catch (Exception e) {
            System.out.println("error al insertar" + e);
        }
    }

    public void Insertar_Detalle_Compra_Ropa(Compras_Set_Get u) {
        try {
            String sql = "insert into detalle_compras_producto(Id_Detalle_Compras_Producto,Id_Compras,Id_Producto,Precio_Compra,Cantidad_Compra) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_Detalle_Compras_Producto());
            ps.setInt(2, u.getId_Compras());
            ps.setInt(3, u.getId_Producto());
            ps.setFloat(4, u.getPrecio_Compra());
            ps.setInt(5, u.getCantidad_Compra());
            boolean ejecucion = ejecutarSQL(ps);
            if (ejecucion == true) {
                System.out.println("Detalle de compra registrada correctamente");
            } else if (ejecucion == false) {
                System.out.println("Error al guardar los detalles de compra");
            }

        } catch (Exception e) {
            System.out.println("error al insertar" + e);
        }
    }

    public void Insertar(String Tabla, String Campos_Insert, String Valores_Values) {
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO " + Tabla + "(" + Campos_Insert + ") Values(" + Valores_Values + ")");
            msm.ms_exito("Dato guardado con éxito en tabla " + Tabla);
        } catch (Exception e) {
            msm.ms_error("Error al guardar en tabla " + Tabla);

        }
    }

    public void Insertar2(String Tabla, String Campos_Insert, String Valores_Values) {
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO " + Tabla + "(" + Campos_Insert + ") Values(" + Valores_Values + ")");
            System.out.println("Dato guardado con éxito en tabla " + Tabla);
        } catch (Exception e) {
            msm.ms_error("Error al guardar en tabla " + Tabla);
        }
    }

    public void Buscar(String SQL, String Tabla) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException e) {
            msm.ms_error("Error al buscar en tabla " + Tabla);
        }
    }

    public void Modificar(String Tabla, String Campos, String Condicion) {
        try {
            Statement s1 = con.createStatement();
            s1.executeUpdate("update " + Tabla + " set " + Campos + " where " + Condicion + ";");
            msm.ms_exito("Dato modificado con éxito en tabla " + Tabla);
        } catch (SQLException e) {
            msm.ms_error("Error al modificar en tabla " + Tabla);
        }
    }

    public void Modificar2(String Tabla, String Campos, String Condicion) {
        try {
            Statement s1 = con.createStatement();
            s1.executeUpdate("update " + Tabla + " set " + Campos + " where " + Condicion + ";");
            System.out.println("Dato modificado con éxito en tabla " + Tabla);
        } catch (SQLException e) {
            msm.ms_error("Error al modificar en tabla " + Tabla);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////                       DATOS DE MENU PRINCIPAL                                  ////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    public int nFechaPagoCompra(String desde, String hasta) {
        int n=0;
        try {            
            st = con.createStatement();
            rs = st.executeQuery("SELECT count(Id_Compras) as num FROM compras WHERE Tipo_Pago='CREDITO' AND Fecha_Pago BETWEEN '" + desde + "' AND '" + hasta + "'");
            if(rs.first()){
                n=rs.getInt("num");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return n;
    }
    
    public void buscarFechaPagoCompra(String desde, String hasta) {
        try {            
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM compras WHERE Tipo_Pago='CREDITO' AND Fecha_Pago BETWEEN '" + desde + "' AND '" + hasta + "' ORDER by fecha_pago");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int nProductosProximosAgotarse() {
        int n=0;
        try {            
            st = con.createStatement();
            rs = st.executeQuery("SELECT count(prod.Id_Producto) as num FROM producto prod INNER JOIN inventario inv ON prod.Id_Producto = inv.Producto_Id_Producto WHERE inv.cantidad<=prod.Stock");
            if(rs.first()){
                n=rs.getInt("num");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return n;
    }
    public void buscarProductosProximosAgotarse() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT prod.Nombre_Producto,inv.Cantidad FROM producto prod INNER JOIN inventario inv ON prod.Id_Producto = inv.Producto_Id_Producto WHERE inv.Cantidad<=prod.Stock");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
