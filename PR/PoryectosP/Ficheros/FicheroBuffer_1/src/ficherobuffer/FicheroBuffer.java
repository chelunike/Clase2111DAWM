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
            BufferedReader input2 = new BufferedReader(new FileReader("texto2.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("grito.txt"));

            String line = input.readLine();
            String line2 = input2.readLine();
            while (line != null&& line2!=null) {
                System.out.println(line);
                System.out.println(line2);
                String linea = grita(line);
                String linea2 = grita(line2);
               
                output.write(linea);
                output.newLine();
                output.write(linea2);
                output.newLine();
                line = input.readLine();
                line2 = input2.readLine();
            }
            input.close();
            input2.close();
            output.close();

        } catch (IOException ex) {
            System.out.println("Algo va mal");

        }
    }
}
