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
public class ClienteDAO {
    public Connection conectarse() throws ClassNotFoundException, SQLException{
        Class.forName(Parametros.DRIVER_CLASS);
        return DriverManager.getConnection(Parametros.URL
                + "?user=" + Parametros.USER + "&password=" + Parametros.PASSWORD);
    }
    
    public void desconectarse(Connection conn) throws SQLException{
        conn.close();
    }
    
    
    public String registrarCliente(Connection conn,Cliente cliente) throws SQLException{
        String sql1 = "Select * from cliente where dni=?";
        PreparedStatement ps = conn.prepareStatement(sql1);
        
        ps.setString(1, cliente.getDni());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return "existe";
        }else{
          String sql2 = "insert into cliente (dni, nombres, ap_paterno, ap_materno, direccion, distrito) values (?,?,?,?,?,?)";
        
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        
        ps2.setString(1, cliente.getDni());
        ps2.setString(2, cliente.getNombres());
        ps2.setString(3, cliente.getAp_paterno());
        ps2.setString(4, cliente.getAp_materno());
        ps2.setString(5, cliente.getDireccion());
        ps2.setString(6, cliente.getDistrito());
        
        if(ps2.execute()){
            return "no";
        }else{
            return "si";
        }
        
        }
        
        
    } 
    
    public List<Cliente> obtenerClientes(Connection conn,Cliente filtro) throws SQLException{
        
        List<Cliente> clis = new ArrayList<>();
        Cliente cli = null;
        String sql1 = "Select * from cliente where 1 ";
        if(filtro.getDni()!=null){
            sql1 = sql1 + " and dni='"+ filtro.getDni().trim() +"'";
        }else if(filtro.getAp_paterno()!=null){
            sql1 = sql1 + " and ap_paterno LIKE LOWER('%"+ filtro.getAp_paterno().trim() +"%' )";          
        }else if (filtro.getAp_materno()!=null){
            sql1 = sql1 + " and ap_materno LIKE LOWER('%"+ filtro.getAp_materno().trim() +"%' )"; 
        }
        PreparedStatement ps = conn.prepareStatement(sql1);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cli = new Cliente();
            cli.setDni(rs.getString(1));
            cli.setNombres(rs.getString(2));
            cli.setAp_paterno(rs.getString(3));
            cli.setAp_materno(rs.getString(4));
            cli.setDireccion(rs.getString(5));
            cli.setDistrito(rs.getString(6));
            clis.add(cli);
        }
        
        return clis;
    } 
    
}
