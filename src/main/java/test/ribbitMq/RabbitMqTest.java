package test.ribbitMq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class RabbitMqTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("119.23.44.107");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //5个参数，分别意为queue名字，是否持久化，是否进行消息共享可以多个消费者消费，自动删除，其他参数
        channel.queueDeclare("myQueue123",false,false,false,null);
        for (;;){
            Scanner scanner = new Scanner(System.in);
            channel.basicPublish("","myQueue", MessageProperties.PERSISTENT_TEXT_PLAIN,scanner.next().getBytes());
        }

    }
}
