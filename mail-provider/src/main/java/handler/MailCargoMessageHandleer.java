package handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/9.
 */

@Component("mailCargoMessageHandler")
public  class MailCargoMessageHandleer<T> extends CustomMessageHandler<T> {
    Logger logger = LoggerFactory.getLogger(MailCargoMessageHandleer.class);

    @Override
    protected void validate(T payload) {
        logger.info("开始验证");
        logger.info("----------------------");
        logger.info("结束验证");
    }

    /**
     * 组装报文对象
     */
    @Override
    protected T assemble(String originMessageText) {
        logger.info("开始组装报文");
        logger.info("----------");
        logger.info("结束报文");
        return null;
    }

    @Override
    protected String getMessageType() {
        return "api_send_outbound_customs_cargo";
    }
}
