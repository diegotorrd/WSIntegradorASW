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
public class Registro {
    private int idsum;
    private int lectura;
    private float consumo;

    public Registro() {
    }

    public Registro(int idsum, int lectura, float consumo) {
        this.idsum = idsum;
        this.lectura = lectura;
        this.consumo = consumo;
    }

    public int getIdsum() {
        return idsum;
    }

    public void setIdsum(int idsum) {
        this.idsum = idsum;
    }

    
    

    public int getLectura() {
        return lectura;
    }

    public void setLectura(int lectura) {
        this.lectura = lectura;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    
    
    
}
