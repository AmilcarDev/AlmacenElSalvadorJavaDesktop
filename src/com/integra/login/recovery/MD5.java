/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.integra.login.recovery;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author defaultuser0
 */
public class MD5 {
    
    public static String encrypt(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
        return convertToHex(hash);
    }
    
    public static String convertToHex(byte[] hash){
        StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
    }
    
    public static boolean compareMD5(String digesta, String digestb) throws UnsupportedEncodingException{
       return MessageDigest.isEqual(digesta.getBytes("UTF-8"), digestb.getBytes("UTF-8"));
    }
}
