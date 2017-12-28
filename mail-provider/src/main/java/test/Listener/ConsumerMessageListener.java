package test.Listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/12/28.
 */
public class ConsumerMessageListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        //我们知道生产者发送的就是一个纯文本消息,所以这里可以直接进行强制转换
        TextMessage textMessage = (TextMessage) message;
        System.out.println("接收到一个");
    }
}
