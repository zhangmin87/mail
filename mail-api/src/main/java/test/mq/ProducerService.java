package test.mq;


import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

/**
 * Created by Administrator on 2017/12/25.
 * 发送mq的工具
 */
public interface ProducerService {
    void sendMessage(Destination destination, final String message);
    //// FIXME: 2018/1/4 参考ceb 项目看看怎么开发的
//    void send(JmsTemplate jmsTemplate,String destionName,String messageType,String messageText);
}
