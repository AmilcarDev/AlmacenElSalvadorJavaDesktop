/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.integra.session;

import com.integra.users.ModeloPrivilegios;

/**
 *
 * @author defaultuser0
 */
public class ModeloSession {
    private String idusuario;
    private String Nombre;
    private boolean logged;
    private ModeloPrivilegios privilegios;

    public ModeloSession() {
        logout();
    }
    
    public ModeloSession(String idusuario, String Nombre, boolean logged, ModeloPrivilegios privilegios) {
        this.idusuario = idusuario;
        this.Nombre = Nombre;
        this.logged = logged;
        this.privilegios=privilegios;
    }
    
    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public ModeloPrivilegios getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(ModeloPrivilegios privilegios) {
        this.privilegios = privilegios;
    }
    
    public void logout(){
        this.idusuario = "";
        this.Nombre = "";
        this.logged = false;
        this.privilegios=null;
    }

    @Override
    public String toString() {
        return "ModeloSession{" + "idusuario=" + idusuario + ", Nombre=" + Nombre + ", logged=" + logged + ", privilegios=" + privilegios + '}';
    }
        
}
