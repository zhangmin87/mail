package test.mq;

import javax.jms.Destination;

/**
 * Created by Administrator on 2017/12/26.
 */
public interface ConsumerService {
    String receiveMessage(Destination destination, Destination replyDestination );
}
