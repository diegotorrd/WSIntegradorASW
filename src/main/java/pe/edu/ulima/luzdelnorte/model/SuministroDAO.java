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
    
    public Suministro obtenerSuministro(Connection conn, int id_suministro) throws SQLException{
        Suministro sum = null;
        Cliente cli = null;
        String sql = "SELECT dni_titular FROM suministro WHERE id_sum=?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, id_suministro);
        
        ResultSet rs = ps.executeQuery();
        
        
        while(rs.next()){
            
            sql = "SELECT * FROM cliente WHERE dni=?";
            
            PreparedStatement ps2 = conn.prepareStatement(sql);
            
            ps2.setInt(1, rs.getInt(1));
            
            ResultSet rs2 = ps2.executeQuery();
            
            while(rs2.next()){
                cli = new Cliente();
                cli.setDni(rs2.getString(1));
                cli.setNombres(rs2.getString(2));
                cli.setAp_paterno(rs2.getString(3));
                cli.setAp_materno(rs2.getString(4));
                cli.setDireccion(rs2.getString(5));
                switch(rs2.getInt(6)){
                    case Parametros.DIS_CALLAO: cli.setDistrito("CALLAO"); break;
                    case Parametros.DIS_COMAS: cli.setDistrito("COMAS"); break;
                    case Parametros.DIS_INDEPENDENCIA: cli.setDistrito("INDEPENDENCIA"); break;
                    case Parametros.DIS_PUENTE_PIEDRA: cli.setDistrito("PUENTE PIEDRA"); break;
                    case Parametros.DIS_PUEBLO_LIBRE: cli.setDistrito("PUEBLO LIBRE"); break;
                    case Parametros.DIS_SAN_JUAN_LURIGANCHO: cli.setDistrito("SAN JUAN DE LURIGANCHO"); break;
                    case Parametros.DIS_SAN_MIGUEL: cli.setDistrito("SAN MIGUEL"); break;
                }
                
            }           
        }
        if (cli!= null){
            sum = new Suministro();
            sum.setId_suministro(id_suministro);
            sum.setCliente(cli);
        }
        return sum;
    }
}
