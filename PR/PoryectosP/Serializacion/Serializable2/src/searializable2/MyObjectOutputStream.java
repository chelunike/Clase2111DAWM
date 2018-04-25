/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searializable2;
import java.io.*;
/**
 *
 * @author juan
 */
public class MyObjectOutputStream extends ObjectOutputStream   {
    //Sobrescribimos el método que crea la cabecera
    @Override
    protected void writeStreamHeader() throws IOException
    {
        // No hacer nada.
    }
 
    //Constructores
 
    public MyObjectOutputStream () throws IOException{
        super();
    }
    public MyObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }

}
