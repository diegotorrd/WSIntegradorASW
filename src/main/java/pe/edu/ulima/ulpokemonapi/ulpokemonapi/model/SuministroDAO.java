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
public class SuministroDAO {
    public Connection conectarse() throws ClassNotFoundException, SQLException{
        Class.forName(Parametros.DRIVER_CLASS);
        return DriverManager.getConnection(Parametros.URL
                + "?user=" + Parametros.USER + "&password=" + Parametros.PASSWORD);
    }
    
    public void desconectarse(Connection conn) throws SQLException{
        conn.close();
    }
    
    public int obtenerSuministro(Connection conn, int id_suministro) throws SQLException{
        String sql = "SELECT * FROM suministro WHERE num_sum=?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, id_suministro);
        
        ResultSet rs = ps.executeQuery();
        
        UsuarioResponse user = null;
        if(rs.next()){
            return 1;
        }else{
            return 0;
        }
        
        
    }
}
