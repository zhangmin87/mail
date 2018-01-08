package handler;

import javax.annotation.Resource;
import javax.jms.Message;

/**
 * Created by Administrator on 2018/1/8.
 */
public abstract class mailMessageHandler<T> extends AbstractMessage {

    @Resource(name = "mapMessageHandlerRegistry")
    private MessageHandlerRegister register;

    @Override
    public MessageHandlerRegister getRegistry() {
        return register;
    }

}
