/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exaconjunto;


public class ExcepcionConjuntoValor extends Exception {

    public ExcepcionConjuntoValor(){
            System.out.println("Error, el número es negativo");
        }
    
    @Override
    public String getMessage(){
        String mensaje="El valor tiene que ser >=0";
        return mensaje;
    }
    
}
