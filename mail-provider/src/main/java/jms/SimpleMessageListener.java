package jms;

import handler.MessageHandler;
import handler.MessageHandlerRegister;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * Created by Administrator on 2018/1/2.
 */
public class SimpleMessageListener implements MessageListener{

    /**
     * 消息处理器注册中心
     */
    private MessageHandlerRegister registry;


    @Override
    public void onMessage(Message message) {
        try {
            //获取消息类型
            String messageType = getMessageType(message);
            if (messageType == null || "".equals(messageType)) {
                //没有设置消息类型
                throw new Exception("消息类型不能为空");
            }
            if (registry == null) {
                //没有注册中心
                throw new Exception("没有注册中心");
            }
            MessageHandler mh = registry.lookup(messageType);
            if (mh == null) {
                //没有找到消息类型的MessageHan
            }
            if (message instanceof TextMessage) {
                mh.doHandle(((TextMessage) message).getText());
            }else {
                //不支持的消息格式
                throw new Exception("仅支持TextMessage");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected String getMessageType(Message message) throws JMSException {
        return message.getStringProperty("MQ_MESSAGE_TYPE");
    }

    public void setRegistry(MessageHandlerRegister registry) {
        this.registry = registry;
    }

    public MessageHandlerRegister getRegistry() {
        return registry;
    }

}


