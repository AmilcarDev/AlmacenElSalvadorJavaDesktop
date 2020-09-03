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
public class ModeloNuevoUsuario {

    private ModeloUsuario msu;
    private String codigo;
    private ModeloPrivilegios privilegios;

    public ModeloNuevoUsuario(ModeloUsuario msu, ModeloPrivilegios privilegios) {
        this.msu = msu;
        this.privilegios = privilegios;
    }

    public ModeloPrivilegios isPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(ModeloPrivilegios privilegios) {
        this.privilegios = privilegios;
    }

    public ModeloUsuario getMsu() {
        return msu;
    }

    public void setMsu(ModeloUsuario msu) {
        this.msu = msu;
    }

    public ModeloPrivilegios getPrivilegios() {
        return privilegios;
    }
    
    @Override
    public String toString() {
        return "ModeloNuevoUsuario{" + "msu=" + msu + ", privilegos=" + privilegios + '}';
    }


}
