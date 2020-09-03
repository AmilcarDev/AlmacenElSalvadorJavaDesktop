/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Alex Callejas
 */
public class Utilidades {

    public String Encriptar(String texto) {
        String secretKey = "integrainfo2016"; //llave para Utilidades datos
        String base64EncryptedString = "";
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return base64EncryptedString;
    }

    public String Desencriptar(String textoEncriptado) throws Exception {
        String secretKey = "integrainfo2016"; //llave para Utilidades datos
        String base64EncryptedString = "";       
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            base64EncryptedString = new String(plainText, "UTF-8");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return base64EncryptedString;
    }
    
    public java.sql.Timestamp getTimesTamp(){
        Calendar calendar = Calendar.getInstance();
        return new java.sql.Timestamp(calendar.getTime().getTime());
    }
    
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    
//    public static void main(String[] args) {
//        try {
//            Utilidades u=new Utilidades();
//            System.out.println(u.Desencriptar("uUmwirU2Kn8="));
//        } catch (Exception ex) {
//            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
