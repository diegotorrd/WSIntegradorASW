/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.colas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Message;
import javax.jms.*;
import javax.jms.MessageListener;
import pe.edu.ulima.luzdelnorte.model.Registro;
import pe.edu.ulima.luzdelnorte.model.RegistroDAO;

public class Consumer implements MessageListener {
    
	public void onMessage(Message arg0) {
            java.sql.Connection con;
            RegistroDAO dao = null;

		try {
			if (arg0 instanceof ObjectMessage) {
				ObjectMessage objectMessage = (ObjectMessage) arg0;
                                dao = new RegistroDAO();
                                con = dao.conectarse();
                                dao.registrarDatos(con, (Registro)((ObjectMessage)arg0).getObject());
                                dao.desconectarse(con);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
	}
  
        
}


