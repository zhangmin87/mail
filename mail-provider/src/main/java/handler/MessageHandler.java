package handler;

/**
 * Created by Administrator on 2018/1/2.
 * @Date
 */
public interface MessageHandler<T> {
    void doHandle(T payload);
}
