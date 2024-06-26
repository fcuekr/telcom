package test.activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;

public class ActiveMQTest{
    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        Queue myQueue = session.createQueue("myQueue");
        MessageProducer producer = session.createProducer(myQueue);

        MapMessage message = session.createMapMessage();
        message.setInt("score",1);
        message.setBoolean("noCheat",true);
        message.setIntProperty("score",1);
        message.setBooleanProperty("noCheat",true);
        producer.send(message);

        MapMessage message2 = session.createMapMessage();
        message2.setInt("score",65);
        message2.setBoolean("noCheat",false);
        message2.setIntProperty("score",65);
        message2.setBooleanProperty("noCheat",false);
        producer.send(message2);

        MapMessage message3 = session.createMapMessage();
        message3.setInt("score",40);
        message3.setBoolean("noCheat",true);
        message3.setIntProperty("score",40);
        message3.setBooleanProperty("noCheat",true);
        producer.send(message3);
        connection.close();
    }
}