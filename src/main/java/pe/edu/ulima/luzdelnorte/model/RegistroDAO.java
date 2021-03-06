/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public boolean registrarDatos(Connection conn, String reg) throws SQLException{
        
        int pos1,pos2;
        
        pos1=reg.indexOf(";");
        pos2=reg.length();
        
        
        String sql1 = "Select max(id) from registro";
        PreparedStatement ps = conn.prepareStatement(sql1);
        ResultSet rs = ps.executeQuery();
        int idmax=0;
        while(rs.next()){
           idmax =  rs.getInt(1);
        }
        String sql2 = "insert into registro (id, id_sum, lectura, fecha) values (?,?,?,Now())";
        
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        
        ps2.setInt(1, idmax+1);
        ps2.setInt(2, Integer.valueOf(reg.substring(0,pos1)));
        ps2.setInt(3, Integer.valueOf(reg.substring(pos1+1,pos2)));
        
        return ps2.execute();
    }
    
public List<DatosTabla> obtenerRegistros(Connection con) throws SQLException{
    ResultSet rs =null;
    List<DatosTabla> data = new ArrayList<>();
    DatosTabla dat = null;
    
    String sql = "SELECT c.dni, c.nombres, c.ap_paterno, c.ap_materno, c.direccion, o.id_sum, o.lectura, o.fecha " +
                    "FROM registro o, cliente c, suministro s " +
                    "WHERE o.id_sum = s.id_sum " +
                    "AND s.dni_titular = c.dni";
    PreparedStatement ps = con.prepareStatement(sql);
    rs = ps.executeQuery();
    
    while(rs.next()){
        dat = new DatosTabla();
        dat.setDni(rs.getString(1)); 
        dat.setNombres(rs.getString(2)); 
        dat.setAp_paterno(rs.getString(3)); 
        dat.setAp_materno(rs.getString(4)); 
        dat.setDireccion(rs.getString(5)); 
        dat.setId_sum(rs.getInt(6)); 
        dat.setLectura(rs.getInt(7));  
        dat.setFecha(rs.getString(8)); 
        data.add(dat);
    }
    
        return data;
       
}
}
