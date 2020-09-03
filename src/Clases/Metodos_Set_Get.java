package Clases;

import java.io.FileInputStream;

public class Metodos_Set_Get {

    private int Id_Producto;
    private String Nombre_Producto;
    private int Stock;
    private int Id_Proveedor;
    private int Id_Departamento;
    private float Precio_unitario;
    private String Talla;
    private String Estilo;
    private String Marca;
    private String Color;
    private String Categoria;
    private String Memoria_Interna;
    private String Memoria_Externa;
    private String Estado;
    private int Ganancia;
    private String Clasificacion;
    private String Aroma;
    private String Contenido;
    private String Sistema;
    private String Modelo;
    private String Tela;
    private String Cuello;
    private FileInputStream fis;
    private int longitudBytes;

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getId_Proveedor() {
        return Id_Proveedor;
    }

    public void setId_Proveedor(int Id_Proveedor) {
        this.Id_Proveedor = Id_Proveedor;
    }

    public int getId_Departamento() {
        return Id_Departamento;
    }

    public void setId_Departamento(int Id_Departamento) {
        this.Id_Departamento = Id_Departamento;
    }

    public float getPrecio_unitario() {
        return Precio_unitario;
    }

    public void setPrecio_unitario(float Precio_unitario) {
        this.Precio_unitario = Precio_unitario;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        this.Estilo = Estilo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getMemoria_Interna() {
        return Memoria_Interna;
    }

    public void setMemoria_Interna(String Memoria_Interna) {
        this.Memoria_Interna = Memoria_Interna;
    }

    public String getMemoria_Externa() {
        return Memoria_Externa;
    }

    public void setMemoria_Externa(String Memoria_Externa) {
        this.Memoria_Externa = Memoria_Externa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getGanancia() {
        return Ganancia;
    }

    public void setGanancia(int Ganacia) {
        this.Ganancia = Ganacia;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Id_Clasificacion) {
        this.Clasificacion = Id_Clasificacion;
    }

    public String getAroma() {
        return Aroma;
    }

    public void setAroma(String Aroma) {
        this.Aroma = Aroma;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public String getSistema() {
        return Sistema;
    }

    public void setSistema(String Sistema) {
        this.Sistema = Sistema;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public int getLongitudBytes() {
        return longitudBytes;
    }

    public void setLongitudBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }

    /**
     * @return the Tela
     */
    public String getTela() {
        return Tela;
    }

    /**
     * @param Tela the Tela to set
     */
    public void setTela(String Tela) {
        this.Tela = Tela;
    }

    /**
     * @return the Cuello
     */
    public String getCuello() {
        return Cuello;
    }

    /**
     * @param Cuello the Cuello to set
     */
    public void setCuello(String Cuello) {
        this.Cuello = Cuello;
    }

}
