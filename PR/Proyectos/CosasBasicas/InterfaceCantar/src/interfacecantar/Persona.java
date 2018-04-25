
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecantar;

/**
 *
 * @author juan
 */
public class Persona implements ICantante{
    private String nombre;
    
    
    public void setNombre(String nom){
        nombre = nom;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void cantar()
            {
                  System.out.println("  La laa la raa laaa!");
            }

    
}
