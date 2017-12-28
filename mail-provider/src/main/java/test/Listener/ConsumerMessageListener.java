package test.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * Created by Administrator on 2017/12/28.
 */
public class ConsumerMessageListener implements MessageListener{

    //日志服务
    private Logger logger= LoggerFactory.getLogger(ConsumerMessageListener.class);

    @Override
    public void onMessage(Message message) {
        //我们知道生产者发送的就是一个纯文本消息,所以这里可以直接进行强制转换
        if (message instanceof TextMessage ) {
            try{
                String  text = ((TextMessage) message).getText();
                logger.info("消息生产者接到消息响应"+text);
            }catch (JMSException e) {
                logger.error("消息生产者接受消息时候发生异常",e);
            }
        }

    }


}
