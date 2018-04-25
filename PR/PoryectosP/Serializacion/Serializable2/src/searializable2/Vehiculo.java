/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searializable2;
import java.io.Serializable;
/**
 *
 * @author juan
 */
public class Vehiculo implements Serializable{
 
    private String matricula;
    private String marca;
    private String modelo;
     //tamañoDeposito: No se transfiere en la serializacion --> transient
    transient private double tamañoDeposito;

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTamañoDeposito(double tamañoDeposito) {
        this.tamañoDeposito = tamañoDeposito;
    }
   
    public String getMatricula() {
        return matricula;
    }
 
    public String getMarca() {
        return marca;
    }
 
    public double getTamañoDeposito() {
        return tamañoDeposito;
    }
 
    public String getModelo() {
        return modelo;
    }
 
    //Constructor
    
    public Vehiculo (String matricula, String marca, double tamañoDeposito, String modelo){
        this.matricula=matricula;
        this.tamañoDeposito=tamañoDeposito;
        this.marca=marca;
        this.modelo=modelo;
    }
 
}

