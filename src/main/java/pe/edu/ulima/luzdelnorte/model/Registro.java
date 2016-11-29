/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.model;

import java.io.Serializable;
import java.sql.Date;




/**
 *
 * @author Diego Torres
 */
public class Registro implements Serializable{
    private int idsum;
    private int lectura;
    private Date fecha;

    public Registro() {
    }

    public Registro(int idsum, int lectura) {
        this.idsum = idsum;
        this.lectura = lectura;
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


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    
}
