/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherobuffer;

import java.io.*;

public class FicheroBuffer {

    private static String grita(String text) {
        return text.toUpperCase();
    }

    public static void main(String[] args) {
        try {

            BufferedReader input = new BufferedReader(new FileReader("texto.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("grito.txt",true));

            String line = input.readLine();
            while (line != null) {
                System.out.println(line);
                String linea = grita(line);
               // output.write(linea, 0, linea.length());
                output.write(linea);
                output.newLine();
                line = input.readLine();
            }
            input.close();
            output.close();

        } catch (IOException ex) {
            System.out.println("Algo va mal");

        }
    }
}
