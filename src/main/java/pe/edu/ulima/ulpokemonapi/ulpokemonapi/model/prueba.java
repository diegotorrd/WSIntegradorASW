/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.ulpokemonapi.ulpokemonapi.model;

import java.sql.Connection;
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
        SuministroDAO dao = new SuministroDAO();
        Connection con;
        int i;
        try {
             con = dao.conectarse();
             i = dao.obtenerSuministro(con, 1234567);
             dao.desconectarse(con);
             
             System.out.println(i);
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
