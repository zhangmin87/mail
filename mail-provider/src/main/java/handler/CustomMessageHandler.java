package handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/1/8.
 */
public abstract class CustomMessageHandler<T> extends mailMessageHandler<T> {

    //Logger
    protected Logger logger = LoggerFactory.getLogger(getClass());




    @Override
    protected abstract T assemble(String originMessageText);


    @Override
    protected void doHandleInternal(T payload) {
        logger.info("开始处理信息");
    }

    /**
     * 开始申报海关上下文的信息
     */
    protected void solveSomething(T payload) {
        validate(payload);
        logger.info("消费掉了");
    }

    /**
     * 基本的校验
     * @param payload
     */
    protected abstract void validate(T payload);



}
