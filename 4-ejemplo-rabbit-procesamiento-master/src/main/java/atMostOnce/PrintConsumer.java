package atMostOnce;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

public class PrintConsumer implements Consumer {

    @Override
    public void handleConsumeOk(String consumerTag) {
        String nameofCurrMethod = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        printMethod(consumerTag, nameofCurrMethod);
    }

    @Override
    public void handleCancelOk(String consumerTag) {
        String nameofCurrMethod = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        printMethod(consumerTag, nameofCurrMethod);
    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {
        String nameofCurrMethod = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        printMethod(consumerTag, nameofCurrMethod);
    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
        String nameofCurrMethod = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        printMethod(consumerTag, nameofCurrMethod);
    }

    @Override
    public void handleRecoverOk(String consumerTag) {
        String nameofCurrMethod = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        printMethod(consumerTag, nameofCurrMethod);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String nameofCurrMethod = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        printMethod(consumerTag, nameofCurrMethod);
        String message = new String(body, "UTF-8");
        throw new IllegalStateException("voló todo");
    }

    private void printMethod(String consumerTag, String nameofCurrMethod) {
        System.out.println(String.format("PrintConsumer[%s] ---- %s", consumerTag, nameofCurrMethod));

    }
}
