package test.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Administrator on 2017/12/25.
 */
@Service("producerServiceImpl")
public class ProducerServiceimpl implements ProducerService{
    //日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private JmsTemplate jmsTemplate;


    @Override
    public void  sendMessage(String receivedestination, final String messageTest,String messageType) {
        logger.info("生产者产生了第一条消息");
        jmsTemplate.send(receivedestination, new MessageCreator() {
            @Override
        public Message createMessage(Session session) throws JMSException {
            Message message  = jmsTemplate.getMessageConverter().toMessage(messageTest,session);
            message.setObjectProperty("MQ_MESSAGE_TYPE",messageType);
            return message;
        }
        });
    }
}
