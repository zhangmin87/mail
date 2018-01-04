package handler;

/**
 * Created by Administrator on 2018/1/2.
 */
public interface MessageHandlerRegister {

    /**
     * 注册服务
     **/
    void register(String name,MessageHandler mh) throws Exception;

    /**
     *移除注册
     */
    void unregister(String name) throws Exception;

    /**
     * lookup
     */
    MessageHandler lookup(String name);
}
