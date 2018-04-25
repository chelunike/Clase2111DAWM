/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipersonas;

import java.time.LocalDate;

/**
 *
 * @author juan
 */
public class GUIPersonas {

    public static void main(String[] args) {
        // TODO code application logic here

        Contenedor contenedor = null;
        //= new Contenedor();
        
        String fichero = "RegistroPersonas.ser";
        
        contenedor = (Contenedor) IOSerializar.deserializarObjecto(fichero);
        System.out.println("contebnedor "+contenedor);
              
         /*
        Persona p = new Persona();
        p.setNombre("pepe");
        p.setSaldo(234.56);
        p.setFechaNac(LocalDate.of(2000, 10, 20));

        System.out.println("Person: " + p.toString());
        contenedor.insertaPersona(p);

        p = new Persona();
        p.setNombre("ana");
        p.setSaldo(1234.56);
        p.setFechaNac(LocalDate.of(1999, 7, 21));
        System.out.println("Person: " + p.toString());
        contenedor.insertaPersona(p);

        p = new Persona();
        p.setNombre("luis");
        p.setSaldo(124.56);
        p.setFechaNac(LocalDate.of(1994, 7, 12));
        System.out.println("Person: " + p.toString());
        contenedor.insertaPersona(p);

        p = new Persona();
        p.setNombre("lola");
        p.setSaldo(1000.56);
        p.setFechaNac(LocalDate.of(2001, 7, 12));
        System.out.println("Person: " + p.toString());
        contenedor.insertaPersona(p);
        

        p = new Persona();
        p.setNombre("juan");
        p.setSaldo(2124.56);
        p.setFechaNac(LocalDate.of(1990, 7, 12));
        System.out.println("Person: " + p.toString());
        contenedor.insertaPersona(p);
         
         
        */
        new Ventana(contenedor);

    }

}
