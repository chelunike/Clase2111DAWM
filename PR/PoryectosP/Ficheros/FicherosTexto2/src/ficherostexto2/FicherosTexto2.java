/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherostexto2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FicherosTexto2 {

    private static String FILE_NAME = "backwards3.txt";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {

            System.out.print("Introduzca un texto: ");
            String text = in.nextLine();

//            FileWriter(File file)  creates a FileWriter object given a File object.
// 	    FileWriter(File file, boolean append) creates a FileWriter object given a File object with a boolean indicating whether or not to append the data written.
//            FileWriter(FileDescriptor fd) creates a FileWriter object associated with the given file descriptor.
//            FileWriter(String fileName) creates a FileWriter object, given a file name.
//            FileWriter(String fileName, boolean append) creates a FileWriter object given a file name with a boolean indicating whether or not to append the data written.
//            FileWriter output = new FileWriter(FILE_NAME);
            FileWriter output = new FileWriter(FILE_NAME, true);
//            String nl = System.getProperty("line.separator");
//           // text = "hola \r\n" + "pepe";
//           
//           text = "hola "+nl+" Pepe";

            // output.write(text);
            output.write(System.getProperty("line.separator"));
            for (int i = text.length() - 1; i >= 0; i--) {

                output.write(text.charAt(i));
                

            }

            output.write(System.getProperty("line.separator"));
//            

            output.close();

        } catch (IOException ex) {
            System.out.println("Something bad has happended");
        }

    }

}
