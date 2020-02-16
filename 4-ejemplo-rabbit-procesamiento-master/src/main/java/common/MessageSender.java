package common;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.stream.IntStream;

public class MessageSender {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String queueName = ParamsFetcher.getQueueName(args);
            channel.queueDeclare(queueName, false, false, false, null);
            String message = "Hola UNDAV!";
            IntStream.range(0, ParamsFetcher.getAmountOfMessages(args))
                    .forEach( idx -> {
                        try {
                            channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
                            System.out.println(String.format("Enviado mensaje #%d", idx));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
