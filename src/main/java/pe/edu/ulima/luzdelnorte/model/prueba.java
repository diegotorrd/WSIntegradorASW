/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Torres
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        ClienteDAO dao = new ClienteDAO();
        UsuarioDAO udao = new UsuarioDAO();
        Registro reg = new Registro(1234567, 75696);
        Connection con;
        Usuario i = null;
        Usuario g = new Usuario();
        g.setUsername("dtorres");
        g.setPassword("1234");
        
        Cliente cli = new Cliente();
        cli.setAp_paterno("torr");
        List<Cliente> clis = new ArrayList<>();
        String resi="";
        try {
             con = dao.conectarse();
             clis = dao.obtenerClientes(con, cli);
             dao.desconectarse(con);
             System.out.println(clis.size());
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
