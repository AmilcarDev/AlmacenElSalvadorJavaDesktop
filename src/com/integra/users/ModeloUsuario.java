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
public class ModeloUsuario {

    private String nombreUsuario;
    private String password;
    private String email;
    private int idEmpleado;
    private boolean estado;

    @Override
    public String toString() {
        return "ModeloUsuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + ", estado=" + estado + ", email=" + email + ", id=" + idEmpleado + '}';
    }

    public ModeloUsuario(String nombreUsuario, String password, String email,boolean estado, int idEmpleado) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        this.estado=estado;
        this.idEmpleado=idEmpleado;
    }
    

    public ModeloUsuario() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int id) {
        this.idEmpleado = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
