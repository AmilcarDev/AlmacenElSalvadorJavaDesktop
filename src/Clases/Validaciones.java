/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import Clases.msm;
import java.util.Date;

/**
 *
 * @author integra
 */
public class Validaciones extends Exception{
    
    public Validaciones(String msg){
        super(msg);
    }
    public static void vacio(String n) throws Validaciones {
        if (n.equals("")) {
            //msm.ms_alerta("Debe llenar todos los campos");
            throw new Validaciones("Ningun Campo debe de estar vacio");
        }
    }
        
    public static void verificarPass(String pass,String passDB) throws Validaciones {
        if (!passDB.equals(pass)) {  
            throw new Validaciones("La Contraseña es Incorrecta");
        }
    }
    
    public static void verificarUser(String user,String userDB) throws Validaciones{
        if (!userDB.equals(user)) {  
            throw new Validaciones("El Usuario es Incorrecto");
        }
    }
    
    public static void userExists(boolean noExists) throws Validaciones{
        if(noExists){
            throw new Validaciones("El Usuario no Existe");
        }
    }
    
    public static void EmpladoSetterAUser(boolean noExists) throws Validaciones{
        if(noExists){
            throw new Validaciones("El Empleado ya posee un Usuario");
        }
    }
}
