/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.ulpokemonapi.ulpokemonapi.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
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
        UsuarioDAO dao = new UsuarioDAO();
        Registro reg = new Registro(1,5896,485.36f);
        reg.setConsumo(485.63f);
        Connection con;
        Usuario i = null;
        try {
             con = dao.conectarse();
             dao.desconectarse(con);
             System.out.println(i.getAp_paterno());
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
