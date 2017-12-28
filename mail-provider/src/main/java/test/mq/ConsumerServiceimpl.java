package test.mq;



import org.springframework.jms.core.JmsTemplate;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import javax.jms.*;

/**
 * Created by Administrator on 2017/12/26.
 */
@Service("consumerServiceImpl")
public class ConsumerServiceimpl implements ConsumerService{
    /**
     *
     *
     * 注入jmsTemplate
     */
    @Resource(name="jmsTemplate")
    private JmsTemplate jTemplate;
    @Override
    public String receiveMessage(Destination destination, Destination replyDestination) {
        /**
         * 接收消息队列中的消息
         */
        Message message = jTemplate.receive(destination);
        try {
            /**
             * 此处为了更好的容错性，可以使用instanceof来判断下消息类型
             */
            if(message instanceof TextMessage){
                String receiveMessage =  ((TextMessage) message).getText();
                System.out.println("收到生产者的消息:"+receiveMessage);
                /**
                 * 收到消息之后，将回复报文放到回复队列里面去
                 */
                jTemplate.send(replyDestination, new MessageCreator() {

                    @Override
                    public Message createMessage(Session session) throws JMSException {

                        return session.createTextMessage("消费者已经收到生产者的消息了，这是一条确认报文!");
                    }
                });
                return receiveMessage;
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return "";
    }
}

