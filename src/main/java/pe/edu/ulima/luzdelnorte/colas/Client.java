/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.luzdelnorte.colas;
import org.apache.activemq.*;
import javax.jms.*;

/**
 *
 * @author Diego Torres
 */
public class Client {
    private static ActiveMQConnectionFactory connectionFactory;
	private static Connection connection;
	private static Session session;
	private static Destination destination;

	public static void main(String[] args) {

		try {
			connectionFactory = new ActiveMQConnectionFactory(
			ActiveMQConnection.DEFAULT_USER,
			ActiveMQConnection.DEFAULT_PASSWORD,
			ActiveMQConnection.DEFAULT_BROKER_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			
			session = connection.createSession(false,
			Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("DemoQueue");
			MessageConsumer consumer = session.createConsumer(destination);
			
			Consumer myConsumer = new Consumer();
			consumer.setMessageListener(myConsumer);
			Thread.sleep(3000);
                        
			session.close();
			connection.close();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

    public void leerCola(){
        try {
			connectionFactory = new ActiveMQConnectionFactory(
			ActiveMQConnection.DEFAULT_USER,
			ActiveMQConnection.DEFAULT_PASSWORD,
			ActiveMQConnection.DEFAULT_BROKER_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			
			session = connection.createSession(false,
			Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("DemoQueue");
			MessageConsumer consumer = session.createConsumer(destination);
			
			Consumer myConsumer = new Consumer();
			consumer.setMessageListener(myConsumer);
			Thread.sleep(3000);
			session.close();
			connection.close();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}
