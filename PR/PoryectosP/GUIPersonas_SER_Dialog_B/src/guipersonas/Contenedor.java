/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipersonas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class Contenedor implements Serializable{

    private int ultimoIdPersona;
    private ArrayList<Persona> personas;

    public Contenedor() {

        ultimoIdPersona = 0;
        personas = new ArrayList<Persona>();

        //OrdenaPorSaldo ops = new OrdenaPorSaldo();
        //personas.sort(ops);
    }

    public int getUltimoIdPersona() {
        return ultimoIdPersona;
    }

    public void setUltimoIdPersona(int ultimoIdPersona) {
        this.ultimoIdPersona = ultimoIdPersona;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public boolean insertaPersona(Persona p) {
        p.setIdPersona(ultimoIdPersona);
        if (personas.add(p)) {
            ultimoIdPersona++;
            return true;
        } else {
            return false;
        }

    }

    public Persona buscaPersona(int idPerso) {
        for (Persona per : personas) {
            if (per.getIdPersona() == idPerso) {
                return per;
            }
        }
        return null;

    }

    public void borraPersona(Persona per) {
        int pos = personas.indexOf(per);
        if (pos >= 0) {
            personas.remove(per);
        }

    }

    public boolean borraPersona(int idPerso) {
        Persona per = buscaPersona(idPerso);
        if (per != null) {
            borraPersona(per);
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return personas.size();
    }

    public Persona getPersonaPorIndice(int idx) {
        return personas.get(idx);

    }

}
