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
public class DatosTabla implements Serializable{
    private String dni;
    private String nombres;
    private String ap_paterno;
    private String ap_materno;
    private String direccion;
    private int id_sum;
    private int lectura;
    private int consumo;
    private String fecha;

    public DatosTabla() {
    }

    public DatosTabla(String dni, String nombres, String ap_paterno, String ap_materno, String direccion, int id_sum, int lectura, int consumo, String fecha) {
        this.dni = dni;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.direccion = direccion;
        this.id_sum = id_sum;
        this.lectura = lectura;
        this.consumo = consumo;
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_sum() {
        return id_sum;
    }

    public void setId_sum(int id_sum) {
        this.id_sum = id_sum;
    }

    public int getLectura() {
        return lectura;
    }

    public void setLectura(int lectura) {
        this.lectura = lectura;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
