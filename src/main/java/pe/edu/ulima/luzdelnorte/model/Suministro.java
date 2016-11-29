/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.model;

import java.io.Serializable;

/**
 *
 * @author Diego Torres
 */
public class Suministro implements Serializable{
    private int id_suministro;
    private Cliente cliente;
        

    public Suministro() {
    }

    public Suministro(int id_suministro, Cliente cliente) {
        this.id_suministro = id_suministro;
        this.cliente = cliente;
    }

    
   

    public int getId_suministro() {
        return id_suministro;
    }

    public void setId_suministro(int id_suministro) {
        this.id_suministro = id_suministro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
}
