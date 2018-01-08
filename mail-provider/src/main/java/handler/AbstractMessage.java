package handler;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Administrator on 2018/1/8.
 */
public abstract class AbstractMessage<T> implements MessageHandler<String >,InitializingBean,DisposableBean {

    private int retries = 0;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (getRegistry() !=null) {
            getRegistry().register(getMessageType(),this);
        }
    }

    public void doHandle(String originMessageText) {
        //消息文本 -> DTO 对象
        T payload = assemble(originMessageText);
        RuntimeException le = null; //Last Exception;
        int len = retries +1<1?1:retries+1;
        for (int i=0;i<len;i++) {
            try {
                doHandleInternal(payload);
                return;
            }catch (RuntimeException ex) {
                //按异常来区分哪些情况可以重试
                le = ex;
            }
        }
        throw le;
    }

    @Override
    public void destroy() throws Exception {
        if (getRegistry() != null) {
            getRegistry().unregister(getMessageType());
        }
    }

    protected abstract void doHandleInternal(T payload);

    protected abstract T assemble(String originMessageText);

    public abstract MessageHandlerRegister getRegistry();

    protected abstract String getMessageType();



    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }
}
