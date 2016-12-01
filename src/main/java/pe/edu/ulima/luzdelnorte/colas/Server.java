/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.colas;

import java.lang.annotation.Annotation;
import org.apache.activemq.*;
import javax.jms.*;
import org.apache.camel.Properties;
import pe.edu.ulima.luzdelnorte.model.Registro;


/**
 *
 * @author Diego Torres
 */
public class Server {
    
    private static ActiveMQConnectionFactory connectionFactory;
    private static Connection connection;
    private static Session session;
    private static Destination destination;
    private static boolean transacted = false;
    
      
    public boolean mandarCola(Registro reg){
        try {
			connectionFactory = new ActiveMQConnectionFactory(
			ActiveMQConnection.DEFAULT_USER,
			ActiveMQConnection.DEFAULT_PASSWORD,
			ActiveMQConnection.DEFAULT_BROKER_URL);
			
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(transacted,Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("LDN");
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                                                    
                        
                        ObjectMessage objectMessage = session.createObjectMessage();
                        objectMessage.setObject(reg.getIdsum() +";"+reg.getLectura());
			javax.jms.Message message = objectMessage;

			producer.send(message);
			
		} 
		catch (JMSException e) {
			System.out.print(e);
                        return false;
		}
        return true;
    }


    
}
