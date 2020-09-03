package Clases;

import java.io.FileInputStream;
import java.sql.Date;

public class Compras_Set_Get {
    private int Id_Compras;
    private String Numero_Factura;
    private String Tipo_Pago;
    private String Fecha_Compra;
    private String Fecha_Pago;
    private float Total;
    private int Id_Usuario;
    private int Id_Proveedor;
    
    //Atributos de Tabla Detalle_Compras
    private int Id_Detalle_Compras_Producto;
    private int Id_Producto;
    private float Precio_Compra;
    private int Cantidad_Compra;
    
    //Atributos de tabla Inventario
    private int Producto_Id_Producto;
    private int Cantidad;
    private float Precio_Venta;

    /**
     * @return the Id_Compras
     */
    public int getId_Compras() {
        return Id_Compras;
    }

    /**
     * @param Id_Compras the Id_Compras to set
     */
    public void setId_Compras(int Id_Compras) {
        this.Id_Compras = Id_Compras;
    }

    /**
     * @return the Numero_Factura
     */
    public String getNumero_Factura() {
        return Numero_Factura;
    }

    /**
     * @param Numero_Factura the Numero_Factura to set
     */
    public void setNumero_Factura(String Numero_Factura) {
        this.Numero_Factura = Numero_Factura;
    }

    /**
     * @return the Tipo_Pago
     */
    public String getTipo_Pago() {
        return Tipo_Pago;
    }

    /**
     * @param Tipo_Pago the Tipo_Pago to set
     */
    public void setTipo_Pago(String Tipo_Pago) {
        this.Tipo_Pago = Tipo_Pago;
    }

    /**
     * @return the Fecha_Compra
     */
    public String getFecha_Compra() {
        return Fecha_Compra;
    }

    /**
     * @param Fecha_Compra the Fecha_Compra to set
     */
    public void setFecha_Compra(String Fecha_Compra) {
        this.Fecha_Compra = Fecha_Compra;
    }

    /**
     * @return the Fecha_Pago
     */
    public String getFecha_Pago() {
        return Fecha_Pago;
    }

    /**
     * @param Fecha_Pago the Fecha_Pago to set
     */
    public void setFecha_Pago(String Fecha_Pago) {
        this.Fecha_Pago = Fecha_Pago;
    }

    /**
     * @return the Total
     */
    public float getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(float Total) {
        this.Total = Total;
    }

    /**
     * @return the Id_Usuario
     */
    public int getId_Usuario() {
        return Id_Usuario;
    }

    /**
     * @param Id_Usuario the Id_Usuario to set
     */
    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    /**
     * @return the Id_Detalle_Compras_Producto
     */
    public int getId_Detalle_Compras_Producto() {
        return Id_Detalle_Compras_Producto;
    }

    /**
     * @param Id_Detalle_Compras_Producto the Id_Detalle_Compras_Producto to set
     */
    public void setId_Detalle_Compras_Producto(int Id_Detalle_Compras_Producto) {
        this.Id_Detalle_Compras_Producto = Id_Detalle_Compras_Producto;
    }

    /**
     * @return the Id_Producto
     */
    public int getId_Producto() {
        return Id_Producto;
    }

    /**
     * @param Id_Producto the Id_Producto to set
     */
    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    /**
     * @return the Precio_Compra
     */
    public float getPrecio_Compra() {
        return Precio_Compra;
    }

    /**
     * @param Precio_Compra the Precio_Compra to set
     */
    public void setPrecio_Compra(float Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    /**
     * @return the Cantidad_Compra
     */
    public int getCantidad_Compra() {
        return Cantidad_Compra;
    }

    /**
     * @param Cantidad_Compra the Cantidad_Compra to set
     */
    public void setCantidad_Compra(int Cantidad_Compra) {
        this.Cantidad_Compra = Cantidad_Compra;
    }

    /**
     * @return the Producto_Id_Producto
     */
    public int getProducto_Id_Producto() {
        return Producto_Id_Producto;
    }

    /**
     * @param Producto_Id_Producto the Producto_Id_Producto to set
     */
    public void setProducto_Id_Producto(int Producto_Id_Producto) {
        this.Producto_Id_Producto = Producto_Id_Producto;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the Precio_Venta
     */
    public float getPrecio_Venta() {
        return Precio_Venta;
    }

    /**
     * @param Precio_Venta the Precio_Venta to set
     */
    public void setPrecio_Venta(float Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    /**
     * @return the Id_Proveedor
     */
    public int getId_Proveedor() {
        return Id_Proveedor;
    }

    /**
     * @param Id_Proveedor the Id_Proveedor to set
     */
    public void setId_Proveedor(int Id_Proveedor) {
        this.Id_Proveedor = Id_Proveedor;
    }
    
    
}
