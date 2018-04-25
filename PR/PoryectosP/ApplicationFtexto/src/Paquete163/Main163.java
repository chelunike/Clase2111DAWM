package Paquete163;
import java.io.*;
import PaqueteMisClases.*;
public class Main163 {
    public static void main(String[] args) {
    //flujo de texto
    String linea;
    boolean añadir=true;
    File file=new File("amigos.txt");
    try{
        FileWriter fw=new FileWriter(file,false);
        BufferedWriter bw=new BufferedWriter(fw);
        System.out.println("teclee texto, terminar intro");
        linea = Cleer.datoString();
        while (linea.length()!=0){
            bw.write(linea);
            //bw.newLine();
            linea = Cleer.datoString();
        }
        if (bw!=null) bw.close();
        if (fw!=null) fw.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    
    file=new File("C:\\Users\\andres\\Documents\\amigos.txt");
    if (file.exists()){
    try{
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        while ((linea=br.readLine())!=null){
            System.out.println(linea);
        }
        if (br!=null) br.close();
        if (fr!=null) fr.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    }
}
