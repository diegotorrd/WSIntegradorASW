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
        RegistroDAO dao = new RegistroDAO();
        UsuarioDAO udao = new UsuarioDAO();
        Registro reg = new Registro(1,5896,485.36f);
        reg.setConsumo(485.63f);
        Connection con;
        Usuario i = null;
        Usuario g = new Usuario();
        g.setUsername("dtorres");
        g.setPassword("1234");
        List<DatosTabla> dat = new ArrayList<>();
        try {
             con = dao.conectarse();
             i = udao.obtener(con, g);
             dao.desconectarse(con);
             System.out.println(i.getNombres());
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
