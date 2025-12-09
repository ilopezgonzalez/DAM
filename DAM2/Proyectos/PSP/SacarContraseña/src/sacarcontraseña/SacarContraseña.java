/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sacarcontraseña;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author damt209
 */
public class SacarContraseña {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            String convertido=convertirSHA256(String.valueOf(i));
            if (convertido.equals("6c237681e70921603a306be9a1a5d9833fce5c1e268f52b1650970eaad0dce21")) {
                System.out.println("La contrseña es: "+i);
                break;
            }
        }

    }

    public static String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

}
