package handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/1/8.
 */
public abstract class customMessageHandler<T> extends mailMessageHandler<T> {

    //Logger
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected abstract T assemble(String originMessageText);


    @Override
    protected void doHandleInternal(Object payload) {

    }

    /**
     * 开始申报海关上下文的信息
     */
    protected void solveSomething() {

    }



}
