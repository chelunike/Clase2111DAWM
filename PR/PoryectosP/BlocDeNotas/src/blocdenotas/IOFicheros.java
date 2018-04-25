package blocdenotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOFicheros {

    public static String leeFicheroBuffer(File fichero, StringBuilder estado) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichero));
            String c = reader.readLine();
            StringBuilder sb = new StringBuilder();
            while (c != null) {
                sb.append(c);
                sb.append(System.lineSeparator());
                c = reader.readLine();
            }
            reader.close();
            return sb.toString();
        } catch (FileNotFoundException ex) {
            estado.append("Error: Fichero No Encontrado!");
            return "";
        } catch (IOException ex) {
            estado.append("Error: Error de lectura!");
            return "";
        }
    }

    public static String leeFichero(File fichero, StringBuilder estado) {
        try {
            FileReader reader = new FileReader(fichero);
            int c = reader.read();
            StringBuilder sb = new StringBuilder();
            while (c != -1) {
                sb.append((char) c);
                c = reader.read();
            }
            reader.close();
            return sb.toString();
        } catch (FileNotFoundException ex) {
            estado.append("Error: Fichero No Encontrado!");
            return "";
        } catch (IOException ex) {
            estado.append("Error: Error de lectura!");
            return "";
        }
    }

    public static int escribeFicheroBuffer(File fichero, String datos) {

        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(fichero));
            buff.write(datos);
            buff.close();
        } catch (IOException ex) {
            return -1;
        }
        return 0;
    }

    public static int escribeFichero(File fichero, String datos) {

        try {
            FileWriter output = new FileWriter(fichero);
            for (int i = 0; i < datos.length(); i++) {
                output.write(datos.charAt(i));
            }
            output.close();
        } catch (IOException ex) {
            return -1;
        }
        return 0;
    }

}
