/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integra.login.recovery;

import Control.msm;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author INTEGRA
 */
public class ModeloCorreo {
    
    Statement st;
    public ResultSet rs;
    
    public static String Username = "almacenelsalvador2@gmail.com";
    public static String PassWord = "integra1234";
    String Mensage = "Se ha recibido una peticion de recuperacion de Contraseña\n"+
            "Por favor copie este codigo y peguelo en el campo de recuperacion del sistema INTEGRA:\n", To = "", Subject = "", adjunto = "";    
    

    public void correoAdjunto(String correo, String msg, String rutaArchivo) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });

        try {
            BodyPart adjunto = new MimeBodyPart();
            BodyPart texto = new MimeBodyPart();
            texto.setText(msg);
            MimeMultipart multiParte = new MimeMultipart();
            adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
            adjunto.setFileName("copia de seguridad.zip");
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject("copia de seguridad INTEGRA");
            message.setContent(multiParte);

            message.setText(msg);
            message.setContent(multiParte);
            Transport.send(message);            

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void correoPIN(String correo, String msg) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject("RESETEO DE CONTRASEÑA");
            message.setText(Mensage+msg);
            Transport.send(message);            

        } catch (MessagingException e) {
            msm.ms_error("El mensaje no pudo ser enviado");
            throw new RuntimeException(e);
        }
    }

    public void correoDatos(String correo, String msg, String usuario, String pass) {
        String Datos = msg + "  Usuario=" + usuario + "Contraseña=" + pass;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject("Recuperación de usuario");
            message.setText(Datos);
            Transport.send(message);            

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarConexion() {
        String dirWeb = "www.google.com";
        int puerto = 80;
        boolean internet = false;
        try {
            Socket s = new Socket(dirWeb, puerto);
            if (s.isConnected()) {
                internet = true;                
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return internet;
    }
    
//    public static void main(String[] args) {
//       ModeloCorreo mc=new ModeloCorreo();
//       mc.correoPIN("alexcallej@live.com", "prueba con javaMail");
//    }
            
    
}
