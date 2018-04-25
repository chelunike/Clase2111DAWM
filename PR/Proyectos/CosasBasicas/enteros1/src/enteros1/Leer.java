/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteros1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author juan , edit by yo
 */
public class Leer {
    
     static BufferedReader flujo = new BufferedReader(
            new InputStreamReader(System.in));

    public static char caracter() {
        char carac;
        try {
            carac = (char) System.in.read();
            System.in.read();
        } catch (IOException e) {
            System.err.println("Error");
            carac = ' ';
        }
        return carac;
    }

    public static String cadena(String men) {
        System.out.print(men);
        String cad = null;
        try {
            cad = flujo.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return cad;
    }

    public static int entero(String men) {
        int num = Integer.MIN_VALUE;
        try {
            num = Integer.parseInt(cadena(men));
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return num;
    }

    public static float realSimple(String men) {
        float numero = Float.MIN_VALUE;
        try {
            numero = Float.parseFloat(cadena(men));
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return numero;
    }

    public static double real(String men) {
        double numero = Double.MIN_VALUE;
        try {
            numero = Double.parseDouble(cadena(men));
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return numero;
    }

    
}
