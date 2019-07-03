package nl.hu.ipass.firstapp.model;

import java.security.SecureRandom;
import java.util.Random;
 
public class GenereerWachtwoord {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        // Defineert een wachtwoord lengte
        int wachtwoordLengte = 10;
        
        // Genereert een wachtwoord
        String wachtwoord = genereerWachtwoord(wachtwoordLengte);
        
        // het wachtwoord weergeven
        System.out.println("wachtwoord: " + wachtwoord);
    }
    public static String genereerWachtwoord(int lengte) {
        StringBuilder returnValue = new StringBuilder(lengte);
        for (int i = 0; i < lengte; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
