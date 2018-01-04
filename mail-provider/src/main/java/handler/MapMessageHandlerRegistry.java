package handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/1/2.
 * 注册中心实现类
 */
public class MapMessageHandlerRegistry implements MessageHandlerRegister {

    /**
     * 如果已经注册是否忽略(true 为忽然，false 为重新注册)
     */
    private boolean ignore = true;

    /**
     * 消息类型
     */

    private Map<String,MessageHandler> messageHandlers = new ConcurrentHashMap<>();

    @Override
    public void register(String name, MessageHandler mh) throws Exception {
        if (messageHandlers.get(name) !=null && ignore) {
            return;
        }
        if (messageHandlers.get(name) !=null && !ignore) {
            unregister(name);
        }
    }

    @Override
    public void unregister(String name) throws Exception {
        if (messageHandlers.get(name) !=null) {
            messageHandlers.remove(name);
        }
    }

    @Override
    public MessageHandler lookup(String name) {
        return messageHandlers.get(name);
    }
}
