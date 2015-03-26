/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Honza
 */
public class Hash {
    
    public static String getHash(String text, String algorithm) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance(algorithm);

        md.update(text.getBytes());

        byte[] digest = md.digest();

        StringBuffer hash= new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
          hash.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return hash.toString();

    }
    
}
