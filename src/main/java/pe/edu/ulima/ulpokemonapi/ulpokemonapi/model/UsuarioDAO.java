
package pe.edu.ulima.ulpokemonapi.ulpokemonapi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.ulima.ulpokemonapi.ulpokemonapi.dto.usuario.UsuarioResponse;

public class UsuarioDAO {
    public Connection conectarse() throws ClassNotFoundException, SQLException{
        Class.forName(Parametros.DRIVER_CLASS);
        return DriverManager.getConnection(Parametros.URL
                + "?user=" + Parametros.USER + "&password=" + Parametros.PASSWORD);
    }
    
    public void desconectarse(Connection conn) throws SQLException{
        conn.close();
    }
    
    public Usuario obtener(Connection conn, Usuario usu) throws SQLException{
        Usuario us = null;
        String sql = "SELECT * FROM usuario WHERE USUARIO=? and CONTRASEÑA=?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, usu.getUsername());
        ps.setString(2, usu.getPassword());
        
        ResultSet rs = ps.executeQuery();
        
        UsuarioResponse user = null;
        if(rs.next()){
            us = new Usuario();
            us.setDni(rs.getInt(4));
            us.setNombres(rs.getString(5));
            us.setAp_paterno(rs.getString(6));
            us.setAp_materno(rs.getString(7));
            us.setTipo(rs.getInt(8));
            return us;
        }else{
            us = null;
            return us;
        }
        
        
    }
    
    public void agregar(Connection conn, Usuario usuario) throws SQLException{
        String sql = "INSERT INTO usuario (username, password) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, usuario.getUsername());
        ps.setString(2, usuario.getPassword());
        
        ps.execute();
    }
}
