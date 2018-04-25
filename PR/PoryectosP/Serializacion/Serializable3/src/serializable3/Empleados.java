/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class Empleados implements Serializable {
    ArrayList<Empleado> lista;
    
    public Empleados() {
        lista = new ArrayList<Empleado>();
        
    }
    
    public void insertEmpleado(Empleado e) {
        
        lista.add(e);
            
    }
    
}
