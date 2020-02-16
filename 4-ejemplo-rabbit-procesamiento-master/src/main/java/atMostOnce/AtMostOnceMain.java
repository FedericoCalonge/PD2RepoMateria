package atMostOnce;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import common.ParamsFetcher;

public class AtMostOnceMain {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = ParamsFetcher.getQueueName(args);
        channel.queueDeclare(queueName, false, false, false, null);
        channel.basicConsume(queueName, false, new PrintConsumer());
    }

}

