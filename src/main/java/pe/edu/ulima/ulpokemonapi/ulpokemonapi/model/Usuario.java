
package pe.edu.ulima.ulpokemonapi.ulpokemonapi.model;

import java.io.Serializable;

public class Usuario implements Serializable{
    private transient long id;
    private String username;
    private String password;
    private int dni;
    private String nombres;
    private String ap_paterno;
    private String ap_materno;
    private int tipo;

    public Usuario() {
    }

    public Usuario(long id, String username, String password, int dni, String nombres, String ap_paterno, String ap_materno, int tipo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.tipo = tipo;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
