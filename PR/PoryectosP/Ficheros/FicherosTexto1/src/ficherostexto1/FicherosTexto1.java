/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherostexto1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author prg
 */
public class FicherosTexto1 {

    private static final String FILE_NAME = "texto.txt";
    private static final int FIN_FICHERO = -1;
    private static final int EOF = -1;
    public static void main(String[] args) {
        // TODO code application logic here
        FileReader input = null;
        int nA = 0;

        try {
            input = new FileReader(FILE_NAME);
            
            int n;
            char c;

            while ((n = input.read()) != FIN_FICHERO) {
                c = (char) n;
                System.out.print(c + ", ");

                if ('a' == c) {
                    nA++;
                }
            }
            System.out.printf("%d \n", n);
            System.out.println("El caracter a aparece " + nA + " veces");
        } catch (FileNotFoundException ex) {
            System.out.println("no se ha podido abrir");

        } catch (IOException ex) {
            System.out.println("problema leyendo");

        } finally {

            try {

                input.close();

            } catch (IOException ex) {
                System.out.println(" problema cerrando");

            }

        }

    }

}
