/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.ulpokemonapi.ulpokemonapi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.ulima.ulpokemonapi.ulpokemonapi.dto.usuario.UsuarioResponse;

/**
 *
 * @author Diego Torres
 */
public class RegistroDAO {
    public Connection conectarse() throws ClassNotFoundException, SQLException{
        Class.forName(Parametros.DRIVER_CLASS);
        return DriverManager.getConnection(Parametros.URL
                + "?user=" + Parametros.USER + "&password=" + Parametros.PASSWORD);
    }
    
    public void desconectarse(Connection conn) throws SQLException{
        conn.close();
    }
    
    public boolean registrarDatos(Connection conn, Registro reg) throws SQLException{
        
        String sql1 = "Select max(id) from registro";
        PreparedStatement ps = conn.prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        int idmax=0;
        while(rs.next()){
           idmax =  rs.getInt(1);
        }
        String sql2 = "insert into registro (id, id_sum, lectura, consumo, fecha) values (?,?,?,?,Now())";
        
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        
        ps2.setInt(1, idmax+1);
        ps2.setInt(2, reg.getIdsum());
        ps2.setInt(3, reg.getLectura());
        ps2.setFloat(4, reg.getConsumo());
        
        return ps2.execute();
              
        
    }
}
