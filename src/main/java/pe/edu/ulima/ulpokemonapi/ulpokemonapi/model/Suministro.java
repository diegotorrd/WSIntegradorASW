/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.ulpokemonapi.ulpokemonapi.model;

/**
 *
 * @author Diego Torres
 */
public class Suministro {
    private int id_suministro;
    private int dni_titular;

    public Suministro() {
    }

    
    public Suministro(int id_suministro, int dni_titular) {
        this.id_suministro = id_suministro;
        this.dni_titular = dni_titular;
    }

    public int getId_suministro() {
        return id_suministro;
    }

    public void setId_suministro(int id_suministro) {
        this.id_suministro = id_suministro;
    }

    public int getDni_titular() {
        return dni_titular;
    }

    public void setDni_titular(int dni_titular) {
        this.dni_titular = dni_titular;
    }
    
    
}
