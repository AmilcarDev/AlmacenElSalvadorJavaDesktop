/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integra.users;

/**
 *
 * @author defaultuser0
 */
public class ModeloPrivilegios {
    private boolean REGISTRO_PROVEEDORES=false;
    private boolean REGISTRO_EMPLEADOS=false;
    private boolean REGISTRO_PRODUCTO=false;
    private boolean REGISTRO_COMPRAS=false;
    private boolean REGISTRO_VENTAS=false;
    private boolean GENERAR_REPORTES=false;
    private boolean CONSULTAR_INVENTARIO=false;

    public ModeloPrivilegios() {
    }

       

    public void setREGISTRO_PROVEEDORES(boolean REGISTRO_PROVEEDORES) {
        this.REGISTRO_PROVEEDORES = REGISTRO_PROVEEDORES;
    }

    public void setREGISTRO_EMPLEADOS(boolean REGISTRO_EMPLEADOS) {
        this.REGISTRO_EMPLEADOS = REGISTRO_EMPLEADOS;
    }

    public void setREGISTRO_PRODUCTO(boolean REGISTRO_PRODUCTO) {
        this.REGISTRO_PRODUCTO = REGISTRO_PRODUCTO;
    }

    public void setREGISTRO_COMPRAS(boolean REGISTRO_COMPRAS) {
        this.REGISTRO_COMPRAS = REGISTRO_COMPRAS;
    }

    public void setREGISTRO_VENTAS(boolean REGISTRO_VENTAS) {
        this.REGISTRO_VENTAS = REGISTRO_VENTAS;
    }

    public void setGENERAR_REPORTES(boolean GENERAR_REPORTES) {
        this.GENERAR_REPORTES = GENERAR_REPORTES;
    }

    public void setCONSULTAR_INVENTARIO(boolean CONSULTAR_INVENTARIO) {
        this.CONSULTAR_INVENTARIO = CONSULTAR_INVENTARIO;
    }

    public boolean isREGISTRO_PROVEEDORES() {
        return REGISTRO_PROVEEDORES;
    }

    public boolean isREGISTRO_EMPLEADOS() {
        return REGISTRO_EMPLEADOS;
    }

    public boolean isREGISTRO_PRODUCTO() {
        return REGISTRO_PRODUCTO;
    }

    public boolean isREGISTRO_COMPRAS() {
        return REGISTRO_COMPRAS;
    }

    public boolean isREGISTRO_VENTAS() {
        return REGISTRO_VENTAS;
    }

    public boolean isGENERAR_REPORTES() {
        return GENERAR_REPORTES;
    }

    public boolean isCONSULTAR_INVENTARIO() {
        return CONSULTAR_INVENTARIO;
    }

    @Override
    public String toString() {
        return "ModeloPrivilegios{" + "REGISTRO_PROVEEDORES=" + REGISTRO_PROVEEDORES + ", REGISTRO_EMPLEADOS=" + REGISTRO_EMPLEADOS + ", REGISTRO_PRODUCTO=" + REGISTRO_PRODUCTO + ", REGISTRO_COMPRAS=" + REGISTRO_COMPRAS + ", REGISTRO_VENTAS=" + REGISTRO_VENTAS + ", GENERAR_REPORTES=" + GENERAR_REPORTES + ", CONSULTAR_INVENTARIO=" + CONSULTAR_INVENTARIO + '}';
    }
    
    public boolean[] getPrivilegios(){
        return new boolean[]{
            REGISTRO_PROVEEDORES,
            REGISTRO_EMPLEADOS,
            REGISTRO_PRODUCTO,
            REGISTRO_COMPRAS,
            REGISTRO_VENTAS,
            GENERAR_REPORTES,
            CONSULTAR_INVENTARIO
        };
    }
}
