/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipersonas;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author juan
 */
public class Persona implements  Serializable{
    private int idPersona;
    private String nombre;
    private LocalDate fechaNac;
    private double saldo;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    


    public String toString(){
        String salida = String.format("id perso: %d Nombre: %s Fecha n.: %s Saldo: %f", idPersona, nombre, fechaNac.toString(), saldo);
        return salida;
    }
    
}
