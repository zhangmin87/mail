package handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/10.
 */

public class MailOrderMessageHandler<T> extends CustomMessageHandler<T> {
    Logger logger = LoggerFactory.getLogger(MailOrderMessageHandler.class);

    @Override
    protected void validate(T payload) {
        logger.info("开始验证");
        logger.info("----------");
        logger.info("结束验证");
    }

    @Override
    protected T assemble(String originMessageText) {
        logger.info("结束组装报文");
        logger.info("------");
        logger.info("结束报文");
        return null;
    }

    @Override
    protected String getMessageType() {
        return "api_send_outbound_customs_good";
    }
}
