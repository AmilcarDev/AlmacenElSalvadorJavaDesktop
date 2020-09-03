/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import Datos.DALUsuario;
import Datos.Usuario;
import com.integra.users.ControladorAdministrarUsuario;
import com.integra.users.ControladorNuevoUsuario;
import com.integra.users.ModeloNuevoUsuario;
import com.integra.users.ModeloPrivilegios;
import com.integra.users.ModeloUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author defaultuser0
 */
public class UniqueRun {

    private ControladorAdministrarUsuario cau;
    private ControladorNuevoUsuario cnu;

    public UniqueRun() {
        cau = new ControladorAdministrarUsuario();
        cnu = new ControladorNuevoUsuario();
    }

    public boolean config() {
        if (cau.countEmpleado()) {
            // new ahorasi().setVisible(true);
            new Conexion().initAdmin();
            ModeloUsuario mu = new ModeloUsuario();
            mu.setNombreUsuario("Admin");
            mu.setEmail("Admin@info.com");
            mu.setIdEmpleado(1);
            mu.setPassword("Admin");
            ModeloPrivilegios mp = new ModeloPrivilegios();
            mp.setREGISTRO_PROVEEDORES(true);
            mp.setREGISTRO_EMPLEADOS(true);
            mp.setREGISTRO_PRODUCTO(true);
            mp.setREGISTRO_COMPRAS(true);
            mp.setREGISTRO_VENTAS(true);
            mp.setGENERAR_REPORTES(true);
            mp.setCONSULTAR_INVENTARIO(true);
            cnu.insertar(new ModeloNuevoUsuario(mu, mp));
            System.out.println("good");
            return true;
        }
        return false;
    }

    

}
